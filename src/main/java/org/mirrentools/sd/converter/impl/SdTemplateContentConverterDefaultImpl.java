package org.mirrentools.sd.converter.impl;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.mirrentools.sd.converter.SdTemplateContentConverter;
import org.mirrentools.sd.models.SdClassContent;
import org.mirrentools.sd.models.SdTemplate;
import org.mirrentools.sd.models.SdTemplateAttribute;
import org.mirrentools.sd.models.SdTemplateContent;
import org.mirrentools.sd.options.SdDatabaseOptions;

/**
 * 将实体属性与模板属性转换为模板生成所需要的材料的默认实现
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public class SdTemplateContentConverterDefaultImpl implements SdTemplateContentConverter {

	@Override
	public Map<String, SdTemplateContent> converter(SdClassContent bean, SdDatabaseOptions databaseOptions,
			Map<String, SdTemplate> templates) {
		Map<String, SdTemplateContent> result = new LinkedHashMap<String, SdTemplateContent>();
		for (Entry<String, SdTemplate> entry : templates.entrySet()) {
			SdTemplateContent content = new SdTemplateContent();
			converterInfo(bean, databaseOptions, entry.getValue(), content);
			converterAttribute(bean, databaseOptions, entry.getValue(), content);
			converterExtensions(bean, databaseOptions, entry.getValue(), content);
			result.put(entry.getKey(), content);
		}
		return result;
	}
	/**
	 * 转换基本信息
	 * 
	 * @param bean
	 * @param databaseOptions
	 * @param template
	 * @param result
	 */
	public void converterInfo(SdClassContent bean, SdDatabaseOptions databaseOptions, SdTemplate template, SdTemplateContent result) {
		result.setPath(template.getPath());
		result.setFile(template.getFile());
		result.setOverride(template.isOverride());
		result.setSourceFolder(template.getSourceFolder());
		result.setPackageName(template.getPackageName());
		result.setClassName(template.getClassName());
		result.setSuffix(template.getSuffix());
	}
	/**
	 * 转换该模板需要的属性
	 * 
	 * @param bean
	 * @param databaseOptions
	 * @param template
	 * @param result
	 */
	public void converterAttribute(SdClassContent bean, SdDatabaseOptions databaseOptions, SdTemplate template, SdTemplateContent result) {
		if (template.getAttributes() != null) {
			for (SdTemplateAttribute attribute : template.getAttributes()) {
				replaceTemplateAttributePlaceholder(bean, databaseOptions, attribute);
				result.putAttr(attribute);
			}
		}
	}
	/**
	 * 转换附加属性
	 * 
	 * @param bean
	 * @param databaseOptions
	 * @param template
	 * @param result
	 */
	public void converterExtensions(SdClassContent bean, SdDatabaseOptions databaseOptions, SdTemplate template, SdTemplateContent result) {
		result.setExtensions(template.getExtensions());
	}
	/**
	 * 填充替换属性里面的占位符
	 * @param bean
	 * @param databaseOptions
	 * @param attribute
	 */
	public void replaceTemplateAttributePlaceholder(SdClassContent bean, SdDatabaseOptions databaseOptions, SdTemplateAttribute attribute) {
		if (attribute.getValue() != null) {
			String value = attribute.getValue()
					.replace("{c}", bean.getCamelName())
					.replace("{p}", bean.getPascalName())
					.replace("{u}", bean.getUnderScoreName())
					.replace("{h}", bean.getHyphenName());
			attribute.setValue(value);
		}
		if (attribute.getDescribe() != null) {
			String value = attribute.getDescribe()
					.replace("{c}", bean.getCamelName())
					.replace("{p}", bean.getPascalName())
					.replace("{u}", bean.getUnderScoreName())
					.replace("{h}", bean.getHyphenName());
			attribute.setDescribe(value);
		}
	}

}
