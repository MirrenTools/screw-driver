package org.mirrentools.sd;

import java.util.Map;

import org.mirrentools.sd.models.SdRenderContent;
import org.mirrentools.sd.models.SdTemplate;

/**
 * 模板生成工具
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public interface ScrewDriverTemplate {
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
	boolean render(String projectPath, String format, SdRenderContent content, SdTemplate template);

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
