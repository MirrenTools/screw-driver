package org.mirrentools.sd.util;

import java.util.Map;

import org.mirrentools.sd.converter.SdBeanConverterToClass;
import org.mirrentools.sd.converter.SdTemplateContentConverter;
import org.mirrentools.sd.models.SdBean;
import org.mirrentools.sd.models.SdTemplate;
import org.mirrentools.sd.options.SdDatabaseOptions;

/**
 * 代码生成工具
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public interface SdCodeUtil {

	/**
	 * 执行生成
	 * 
	 * @return
	 */
	boolean execute();

	/**
	 * 获取项目所在目录
	 * 
	 * @return
	 */
	String getProjectPath();

	/**
	 * 设置项目所在目录
	 * 
	 * @param projectPath
	 * @return
	 */
	SdCodeUtil setProjectPath(String projectPath);

	/**
	 * 获取生成编码格式
	 * 
	 * @return
	 */
	String getCodeFormat();

	/**
	 * 设置生成编码格式,默认UTF-8
	 * 
	 * @param codeFormat
	 * @return
	 */
	SdCodeUtil setCodeFormat(String codeFormat);

	/**
	 * 获取创建所需要的属性
	 * 
	 * @return
	 */
	SdBean getBean();

	/**
	 * 设置创建所需要的属性
	 * 
	 * @param bean
	 */
	SdCodeUtil setBean(SdBean bean);
	/**
	 * 获取数据库连接属性
	 * 
	 * @return
	 */
	SdDatabaseOptions getDatabaseOptions();

	/**
	 * 设置数据库连接属性
	 * 
	 * @param dbOptions
	 * @return
	 */
	SdCodeUtil setDatabaseOptions(SdDatabaseOptions dbOptions);

	/**
	 * 获取生成模板
	 * 
	 * @return
	 */
	Map<String, SdTemplate> getTemplateMaps();

	/**
	 * 添加一个模板
	 * 
	 * @param key
	 * @param template
	 * @return
	 */
	SdCodeUtil addTemplate(String key, SdTemplate template);

	/**
	 * 设置模板集
	 * 
	 * @param templates
	 * @return
	 */
	SdCodeUtil setTemplateMaps(Map<String, SdTemplate> templates);

	/**
	 * 获取实体类属性转换器
	 * 
	 * @return
	 */
	SdBeanConverterToClass getBeanConverter();

	/**
	 * 设置实体类属性转换器
	 * 
	 * @param converter
	 * @return
	 */
	SdCodeUtil setBeanConverter(SdBeanConverterToClass converter);

	/**
	 * 获取模板工具所需要的内容转换器
	 * 
	 * @return
	 */
	SdTemplateContentConverter getContentConverter();

	/**
	 * 设置模板工具所需要的内容转换器
	 * 
	 * @param contentConverter
	 * @return
	 */
	SdCodeUtil setContentConverter(SdTemplateContentConverter contentConverter);

	/**
	 * 设置模板工具
	 * 
	 * @return
	 */
	SdTemplateUtil getTemplateUtil();

	/**
	 * 设置模板工具
	 * 
	 * @param templateUtil
	 * @return
	 */
	SdCodeUtil setTemplateUtil(SdTemplateUtil templateUtil);

	/**
	 * 添加附加属性
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	SdCodeUtil addExtension(String key, Object value);

	/**
	 * 获取附加属性集合
	 * 
	 * @return
	 */
	Map<String, Object> getExtensions();

	/**
	 * 设置附加属性集合
	 * 
	 * @param extensions
	 * @return
	 */
	SdCodeUtil setExtensions(Map<String, Object> extensions);

}
