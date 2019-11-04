package org.mirrentools.sd;

import java.util.LinkedHashMap;
import java.util.Map;

import org.mirrentools.sd.common.SdUtil;
import org.mirrentools.sd.models.SdRenderContent;
import org.mirrentools.sd.models.SdTemplate;

/**
 * 模板渲染引擎(生成文件)
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public abstract class ScrewDriverTemplateEngine {
	/** 拓展属性 */
	private Map<String, Object> extensions;

	/**
	 * 渲染模板,规范建议:<br>
	 * 1.遵循 {@link org.mirrentools.sd.common.SdTemplatePathUtil}中的获取path与获取file规则<br>
	 * 2.SdRenderContent使用content添加既然模板上下文的名称为content
	 * 
	 * @param outputPath
	 *          输出文件夹
	 * @param format
	 *          编码格式
	 * @param content
	 *          模板生成所需要的内容
	 * @param template
	 *          模板信息
	 * @return
	 */
	public abstract boolean render(String outputPath, String format, SdRenderContent content, SdTemplate template);

	/**
	 * 获得拓展属性值
	 * 
	 * @return
	 */
	public Object getExtension(String key) {
		if (SdUtil.isNullOrEmpty(getExtensions())) {
			return null;
		}
		return getExtensions().get(key);
	}

	/**
	 * 添加附加属性
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public ScrewDriverTemplateEngine addExtension(String key, Object value) {
		if (getExtensions() == null) {
			setExtensions(new LinkedHashMap<String, Object>());
		}
		this.extensions.put(key, value);
		return this;
	}

	/**
	 * 获取拓展属性
	 * 
	 * @return
	 */
	public Map<String, Object> getExtensions() {
		return extensions;
	}

	/**
	 * 设置拓展属性
	 * 
	 * @param extensions
	 * @return
	 */
	public ScrewDriverTemplateEngine setExtensions(Map<String, Object> extensions) {
		this.extensions = extensions;
		return this;
	}

}
