package org.mirrentools.sd.converter;

import java.util.Map;

import org.mirrentools.sd.models.SdClassContent;
import org.mirrentools.sd.models.SdTemplate;

/**
 * 将实体属性与模板属性转换为模板所需要的材料
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public interface SdConverterToTemplateContent {
	/**
	 * 转换属性
	 * 
	 * @param bean
	 *          创建类与表所需要的属性
	 * @param templates
	 *          模板属性集
	 * @return
	 */
	<T> T converter(SdClassContent bean, Map<String, SdTemplate> templates);
}
