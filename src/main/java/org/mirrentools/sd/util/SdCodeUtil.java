package org.mirrentools.sd.util;

import java.util.List;
import java.util.Map;

import org.mirrentools.sd.converter.SdBeanConverterToClass;
import org.mirrentools.sd.models.SdBean;
import org.mirrentools.sd.models.SdTemplate;

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
	 * 获取生成模板
	 * 
	 * @return
	 */
	List<SdTemplate> getTemplates();

	/**
	 * 添加一个模板
	 * 
	 * @param template
	 * @return
	 */
	SdCodeUtil addTemplates(SdTemplate template);

	/**
	 * 设置模板集
	 * 
	 * @param templates
	 * @return
	 */
	SdCodeUtil setTemplates(List<SdTemplate> templates);

	/**
	 * 获取转换器
	 * 
	 * @return
	 */
	SdBeanConverterToClass getConverter();

	/**
	 * 设置转换器
	 * 
	 * @param converter
	 * @return
	 */
	SdCodeUtil setConverter(SdBeanConverterToClass converter);

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
