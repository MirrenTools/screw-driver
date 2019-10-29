package org.mirrentools.sd;

import java.util.Map;

import org.mirrentools.sd.converter.SdClassConverter;
import org.mirrentools.sd.converter.SdTemplateContentConverter;
import org.mirrentools.sd.models.SdBean;
import org.mirrentools.sd.models.SdClassContent;
import org.mirrentools.sd.models.SdTemplate;
import org.mirrentools.sd.options.SdDatabaseOptions;

/**
 * 代码生成工具
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 * 
 */
public interface ScrewDriverCode {

	/**
	 * 执行生成
	 * 
	 * @return
	 */
	boolean execute(SdBean bean);

	/**
	 * 执行生成
	 * 
	 * @return
	 */
	boolean execute(SdClassContent classContent);

	/**
	 * 获取项目所在目录
	 * 
	 * @return
	 */
	String getOutputPath();

	/**
	 * 设置项目所在目录
	 * 
	 * @param projectPath
	 * @return
	 */
	ScrewDriverCode setOutputPath(String projectPath);

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
	ScrewDriverCode setCodeFormat(String codeFormat);

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
	ScrewDriverCode setDatabaseOptions(SdDatabaseOptions dbOptions);

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
	ScrewDriverCode addTemplate(String key, SdTemplate template);

	/**
	 * 设置模板集
	 * 
	 * @param templates
	 * @return
	 */
	ScrewDriverCode setTemplateMaps(Map<String, SdTemplate> templates);

	/**
	 * 获取实体类属性转换器
	 * 
	 * @return
	 */
	SdClassConverter getBeanConverter();

	/**
	 * 设置实体类属性转换器
	 * 
	 * @param converter
	 * @return
	 */
	ScrewDriverCode setBeanConverter(SdClassConverter converter);

	/**
	 * 获取模板工具所需要的内容转换器
	 * 
	 * @return
	 */
	SdTemplateContentConverter getTemplateConverter();

	/**
	 * 设置模板工具所需要的内容转换器
	 * 
	 * @param templateConverter
	 * @return
	 */
	ScrewDriverCode setTemplateConverter(SdTemplateContentConverter templateConverter);

	/**
	 * 设置模板工具
	 * 
	 * @return
	 */
	ScrewDriverTemplateEngine getTemplateEngine();

	/**
	 * 设置模板工具
	 * 
	 * @param templateEngine
	 * @return
	 */
	ScrewDriverCode setTemplateEngine(ScrewDriverTemplateEngine templateEngine);

	/**
	 * 添加附加属性
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	ScrewDriverCode addExtension(String key, Object value);

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
	ScrewDriverCode setExtensions(Map<String, Object> extensions);

}
