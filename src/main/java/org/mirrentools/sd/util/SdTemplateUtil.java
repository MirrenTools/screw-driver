package org.mirrentools.sd.util;

import java.util.Map;

import org.mirrentools.sd.models.SdTemplate;

/**
 * 模板生成工具
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public interface SdTemplateUtil {
	/**
	 * 
	 * @param projectPath
	 *          项目所在路径
	 * @param format
	 *          编码格式
	 * @param content
	 *          模板生成所需要的内容
	 * @param template
	 *          模板
	 * @return
	 */
	<T> boolean render(String projectPath, String format, T content, SdTemplate template);

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
