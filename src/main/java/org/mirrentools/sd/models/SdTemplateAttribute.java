package org.mirrentools.sd.models;

/**
 * 模板中需要使用到的属性值
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public class SdTemplateAttribute {
	/** 属性值的key */
	private String key;
	/** 属性值的value */
	private Object value;
	/** 属性值的描述 */
	private String describe;
	/**
	 * 初始化
	 * 
	 * @param key
	 * @param value
	 */
	public SdTemplateAttribute(String key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}
	/**
	 * 初始化
	 * 
	 * @param key
	 * @param value
	 * @param describe
	 */
	public SdTemplateAttribute(String key, Object value, String describe) {
		super();
		this.key = key;
		this.value = value;
		this.describe = describe;
	}
	/**
	 * 获取属性值的键
	 * 
	 * @return
	 */
	public String getKey() {
		return key;
	}
	/**
	 * 设置属性值的键
	 * 
	 * @param key
	 * @return
	 */
	public SdTemplateAttribute setKey(String key) {
		this.key = key;
		return this;
	}
	/**
	 * 获取属性值
	 * 
	 * @return
	 */
	public Object getValue() {
		return value;
	}
	/**
	 * 设置属性值
	 * 
	 * @param value
	 * @return
	 */
	public SdTemplateAttribute setValue(Object value) {
		this.value = value;
		return this;
	}
	/**
	 * 获取属性的描述
	 * 
	 * @return
	 */
	public String getDescribe() {
		return describe;
	}
	/**
	 * 设置属性值的描述
	 * 
	 * @param describe
	 * @return
	 */
	public SdTemplateAttribute setDescribe(String describe) {
		this.describe = describe;
		return this;
	}
	@Override
	public String toString() {
		return "SdTemplateAttribute [key=" + key + ", value=" + value + ", describe=" + describe + "]";
	}

}
