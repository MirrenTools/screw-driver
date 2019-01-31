package org.mirrentools.sd.converter;

import java.util.List;
import java.util.Set;

import org.mirrentools.sd.common.SdUtil;
import org.mirrentools.sd.models.SdBean;
import org.mirrentools.sd.models.SdClassContent;
import org.mirrentools.sd.models.SdColumn;
import org.mirrentools.sd.models.SdRelational;
import org.mirrentools.sd.models.SdRelationalContent;

/**
 * 
 * 将SdBean转换成类属性的抽象实现,可以根据不同语言继承后设置类型转换
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public abstract class SdAbstractBeanConverterToClass implements SdBeanConverterToClass {
	@Override
	public SdClassContent converter(SdBean bean) {
		SdClassContent result = new SdClassContent();
		result.setTableName(bean.getName());
		result.setAlias(bean.getAlias());
		result.setCamelName(SdUtil.toCamelCase(bean.getName()));
		result.setPascalName(SdUtil.toPascalCase(bean.getName()));
		result.setHyphenName(SdUtil.toHyphenCase(bean.getName()));
		result.setUnderScoreName(SdUtil.toUnderScoreCase(bean.getName()));
		result.setRemark(bean.getRemark());
		converterField(bean, result);
		converterRelationals(bean, result);
		converterExtensions(bean, result);
		return result;
	}
	/**
	 * 转换属性列
	 * 
	 * @param bean
	 * @param result
	 */
	public void converterField(SdBean bean, SdClassContent result) {
		for (SdColumn col : bean.getColumns()) {
			// 设置类属性
			if (SdUtil.isNullOrEmpty(col.getFieldType())) {
				col.setFieldType(getTypeConverter().converter(col.getType()));
			}
			if (SdUtil.isNullOrEmpty(col.getFieldName())) {
				col.setFieldName(SdUtil.toCamelCase(col.getName()));
			}
			if (SdUtil.isNullOrEmpty(col.getFieldNamePascal())) {
				col.setFieldNamePascal(SdUtil.toPascalCase(col.getName()));
			}
			if (SdUtil.isNullOrEmpty(col.getFieldNameHyphen())) {
				col.setFieldNameHyphen(SdUtil.toHyphenCase(col.getName()));
			}
			if (SdUtil.isNullOrEmpty(col.getFieldNameUnderScore())) {
				col.setFieldNameUnderScore(SdUtil.toUnderScoreCase(col.getName()));
			}
			if (col.getFieldRemark() == null) {
				col.setFieldRemark(col.getRemark());
			}
			// 添加不同的属性类型
			result.addField(col);
			// 用于判读该属性列是否为普通属性列
			boolean falg = true;
			if (col.isPrimary()) {
				result.addPrimaryField(col);
				falg = false;
			}
			if (col.isIndex()) {
				result.addIndexField(col);
				falg = false;
			}
			if (!col.isNullable()) {
				result.addCantNullField(col);
				falg = false;
			}
			if (falg) {
				result.addOtherField(col);
			}
			// 添加需要引入的包
			Set<String> set = col.getImports();
			if (set != null && !set.isEmpty()) {
				for (String impt : set) {
					result.addImports(impt);
				}
			}
		}
	}

	/**
	 * 转换关系属性
	 * 
	 * @param bean
	 * @param result
	 */
	public void converterRelationals(SdBean bean, SdClassContent result) {
		List<SdRelational> relationals = bean.getRelationals();
		if (relationals != null) {
			for (SdRelational rel : relationals) {
				SdRelationalContent content = new SdRelationalContent();
				content.setImports(rel.getImports());
				content.setAnnotations(rel.getAnnotations());
				content.setRelationalType(rel.getRelationalType());
				content.setFliedName(rel.getFliedName());
				content.setPascalName(SdUtil.toPascalCase(rel.getFliedName()));
				content.setCamelName(SdUtil.toCamelCase(rel.getFliedName()));
				content.setHyphenName(SdUtil.toHyphenCase(rel.getFliedName()));
				content.setUnderScoreName(SdUtil.toUnderScoreCase(rel.getFliedName()));
				content.setFliedType(rel.getFliedType());
				content.setClassContent(converter(rel.getBean()));
				content.setExtensions(rel.getExtensions());
				content.setFieldRemark(rel.getFieldRemark());

				result.addRelational(content);

				if (content.getImports() != null && !content.getImports().isEmpty()) {
					for (String impt : content.getImports()) {
						result.addImports(impt);
					}
				}
			}
		}
	}
	/**
	 * 转换拓展属性
	 * 
	 * @param bean
	 * @param result
	 */
	public void converterExtensions(SdBean bean, SdClassContent result) {
		result.setExtensions(bean.getExtensions());
	}

}
