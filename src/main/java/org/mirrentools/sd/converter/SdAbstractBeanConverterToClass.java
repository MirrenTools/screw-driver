package org.mirrentools.sd.converter;

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
	/** 关系中的SdBean转SdClassContent最多转换到第几级的默认值,如果要修改最大限制子类可以重写set方法 */
	private int defaltRelationalCount = 3;

	@Override
	public SdClassContent converter(SdBean bean) {
		SdClassContent result = new SdClassContent();
		converterBean(bean, result);
		converterFields(bean, result);
		converterAdditionalField(bean, result);
		converterRelationals(bean, result);
		converterExtensions(bean, result);
		return result;
	}
	/**
	 * 初始化bean的基本信息
	 * 
	 * @param bean
	 * @param result
	 */
	public void converterBean(SdBean bean, SdClassContent result) {
		result.setTableName(bean.getName());
		result.setAlias(bean.getAlias());
		result.setCamelName(SdUtil.toCamelCase(bean.getName()));
		result.setPascalName(SdUtil.toPascalCase(bean.getName()));
		result.setHyphenName(SdUtil.toHyphenCase(bean.getName()));
		result.setUnderScoreName(SdUtil.toUnderScoreCase(bean.getName()));
		result.setRemark(bean.getRemark());
	}

	/**
	 * 转换属性列
	 * 
	 * @param bean
	 * @param result
	 */
	public void converterFields(SdBean bean, SdClassContent result) {
		for (SdColumn col : bean.getColumns()) {
			SdUtil.requireNonNull(col.getName(), "属性列的名字不能为空");
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
			boolean flag = true;
			if (col.isPrimary()) {
				result.addPrimaryField(col);
				flag = false;
			}
			if (col.isIndex()) {
				result.addIndexField(col);
				flag = false;
			}
			if (col.isForeignKey()) {
				result.addForeignField(col);
				flag = false;
			}
			if (flag) {
				result.addOtherField(col);
			}
			if (!col.isNullable()) {
				result.addCantNullField(col);
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
	 * 转换附加属性
	 * 
	 * @param bean
	 * @param result
	 */
	public void converterAdditionalField(SdBean bean, SdClassContent result) {
		if (bean.getAdditionalColumns() != null) {
			for (SdColumn col : bean.getAdditionalColumns()) {
				// 设置类属性
				if (col.getName() == null && col.getFieldName() == null) {
					throw new NullPointerException("附加属性中name或者fieldName至少需要有一个名字不为空");
				}
				String name = col.getFieldName() == null ? col.getName() : col.getFieldName();
				if (SdUtil.isNullOrEmpty(col.getFieldType())) {
					col.setFieldType(getTypeConverter().converter(col.getType()));
				}
				if (SdUtil.isNullOrEmpty(col.getFieldName())) {
					col.setFieldName(SdUtil.toCamelCase(name));
				}
				if (SdUtil.isNullOrEmpty(col.getFieldNamePascal())) {
					col.setFieldNamePascal(SdUtil.toPascalCase(name));
				}
				if (SdUtil.isNullOrEmpty(col.getFieldNameHyphen())) {
					col.setFieldNameHyphen(SdUtil.toHyphenCase(name));
				}
				if (SdUtil.isNullOrEmpty(col.getFieldNameUnderScore())) {
					col.setFieldNameUnderScore(SdUtil.toUnderScoreCase(name));
				}
				if (col.getFieldRemark() == null) {
					col.setFieldRemark(col.getRemark());
				}
				result.addAdditionalField(col);
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
		if (bean.getRelationals() != null) {
			for (SdRelational rel : bean.getRelationals()) {
				if (rel.getImports() != null) {
					for (String impt : rel.getImports()) {
						result.addImports(impt);
					}
				}
				SdRelationalContent relational = newNonClassContentRelationalContent(rel);
				if (rel.getBean() != null) {
					SdClassContent classContent = new SdClassContent();
					converterRelationals(rel.getBean(), classContent, 0);
					relational.setClassContent(classContent);
				}
				result.addRelational(relational);
			}
		}
	}
	/**
	 * 转换关系属性
	 * 
	 * @param bean
	 * @param result
	 * @param count
	 *          该参数用于标记将关系中的SdBean转换为SdClassContent已经转换到第几层了,第一次调用输入0
	 */
	public void converterRelationals(SdBean bean, SdClassContent result, int count) {
		if (count >= defaltRelationalCount) {
			return;
		}
		converterBean(bean, result);
		converterFields(bean, result);
		converterAdditionalField(bean, result);
		if (bean.getRelationals() != null) {
			for (SdRelational rel : bean.getRelationals()) {
				if (rel.getImports() != null) {
					for (String impt : rel.getImports()) {
						result.addImports(impt);
					}
				}
				SdRelationalContent relational = newNonClassContentRelationalContent(rel);
				if (rel.getBean() != null) {
					SdClassContent classContent = new SdClassContent();
					// 递归转换SdBean
					converterRelationals(rel.getBean(), classContent, ++count);
					relational.setClassContent(classContent);
				}
				result.addRelational(relational);
			}
		}
		converterExtensions(bean, result);
	}

	/**
	 * 通过关系创建一个没有关系Bean的内容
	 * 
	 * @param rel
	 * @return
	 */
	public SdRelationalContent newNonClassContentRelationalContent(SdRelational rel) {
		SdRelationalContent content = new SdRelationalContent();
		content.setImports(rel.getImports());
		content.setAnnotations(rel.getAnnotations());
		content.setRelationalType(rel.getRelationalType());
		content.setFieldRemark(rel.getFieldRemark());
		content.setFieldType(rel.getFieldType());
		content.setFieldName(rel.getFieldName());
		content.setPascalName(SdUtil.toPascalCase(rel.getFieldName()));
		content.setCamelName(SdUtil.toCamelCase(rel.getFieldName()));
		content.setHyphenName(SdUtil.toHyphenCase(rel.getFieldName()));
		content.setUnderScoreName(SdUtil.toUnderScoreCase(rel.getFieldName()));
		content.setExtensions(rel.getExtensions());
		return content;
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

	/**
	 * 关系中的SdBean转SdClassContent最多转换到第几级的默认值,默认再向下取3级
	 * 
	 * @param defaltRelationalCount
	 * @return
	 */
	public SdAbstractBeanConverterToClass setDefaltRelationalCount(int defaltRelationalCount) {
		this.defaltRelationalCount = defaltRelationalCount;
		return this;
	}

}
