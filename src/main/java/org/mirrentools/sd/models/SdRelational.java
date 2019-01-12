package org.mirrentools.sd.models;

import java.util.LinkedHashMap;
import java.util.Map;

import org.mirrentools.sd.common.SdUtil;

/**
 * 创建类与表添加关系
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class SdRelational {
	/** 类型修饰,比如List<>或Set<>等,如果没有则等于null */
	private String type;
	/** 属性的名字 */
	private String name;
	/** 创建类与表所需要的属性 */
	private SdBean bean;
	/** 拓展属性 */
	private Map<String, Object> extensions;

	public String getType() {
		return type;
	}

	public SdRelational setType(String type) {
		this.type = type;
		return this;
	}

	public String getName() {
		return name;
	}

	public SdRelational setName(String name) {
		this.name = name;
		return this;
	}

	public SdBean getBean() {
		return bean;
	}

	public SdRelational setBean(SdBean bean) {
		this.bean = bean;
		return this;
	}

	/**
	 * 获得拓展属性值
	 * 
	 * @return
	 */
	public Object getExtension(String key) {
		if (SdUtil.isNullOrEmpty(getExtensions(), key)) {
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
	public SdRelational addExtension(String key, Object value) {
		if (SdUtil.isNullOrEmpty(key)) {
			return this;
		}
		if (this.extensions == null) {
			this.extensions = new LinkedHashMap<String, Object>();
		}
		this.extensions.put(key, value);
		return this;
	}

	public Map<String, Object> getExtensions() {
		return extensions;
	}

	public SdRelational setExtensions(Map<String, Object> extensions) {
		this.extensions = extensions;
		return this;
	}

	@Override
	public String toString() {
		return "JsgRelational [type=" + type + ", name=" + name + ", bean=" + bean + ", extensions=" + extensions + "]";
	}

}
