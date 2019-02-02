package org.mirrentools.sd.converter;

import java.util.Map;

import org.mirrentools.sd.models.SdClassContent;
import org.mirrentools.sd.models.SdTemplate;
import org.mirrentools.sd.models.SdTemplateContent;
import org.mirrentools.sd.options.SdDatabaseOptions;

/**
 * 将实体属性与模板属性转换为模板生成所需要的材料
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public interface SdTemplateContentConverter {
	/**
	 * 转换属性
	 * 
	 * @param bean
	 *          创建类与表所需要的属性
	 * @param databaseOptions
	 *          数据库连接属性
	 * @param templates
	 *          模板属性集
	 * @return
	 */
	Map<String, SdTemplateContent> converter(SdClassContent bean, SdDatabaseOptions databaseOptions, Map<String, SdTemplate> templates);

}
