package org.mirrentools.sd.models;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.mirrentools.sd.common.SdUtil;
import org.mirrentools.sd.enums.Relational;

/**
 * 创建类与表添加关系
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class SdRelational {
	/** 需要导入的包 */
	private Set<String> imports;
	/** 注解 */
	private Set<String> annotations;
	/** 关系类型 */
	private Relational relationalType;
	/** 关系属性的注释 */
	private String fieldRemark;
	/** 属性数据类型,比如List<Type> */
	private String fliedType;
	/** 属性的名字 */
	private String fliedName;
	/** 创建类与表所需要的属性 */
	private SdBean bean;
	/** 拓展属性 */
	private Map<String, Object> extensions;

	/**
	 * 获取需要引入的包
	 * 
	 * @return
	 */
	public Set<String> getImports() {
		return imports;
	}
	/**
	 * 设置需要引入的包
	 * 
	 * @param imports
	 * @return
	 */
	public SdRelational setImports(Set<String> imports) {
		this.imports = imports;
		return this;
	}
	/**
	 * 获取注释
	 * 
	 * @return
	 */
	public Set<String> getAnnotations() {
		return annotations;
	}
	/**
	 * 设置注释
	 * 
	 * @param annotations
	 * @return
	 */
	public SdRelational setAnnotations(Set<String> annotations) {
		this.annotations = annotations;
		return this;
	}
	/**
	 * 获取关系的类型
	 * 
	 * @return
	 */
	public Relational getRelationalType() {
		return relationalType;
	}
	/**
	 * 设置关系的类型
	 * 
	 * @param relationalType
	 * @return
	 */
	public SdRelational setRelationalType(Relational relationalType) {
		this.relationalType = relationalType;
		return this;
	}
	/**
	 * 获取关系属性注释
	 * @return
	 */
	public String getFieldRemark() {
		return fieldRemark;
	}
	/**
	 * 设置关系属性注释
	 * @param fieldRemark
	 * @return
	 */
	public SdRelational setFieldRemark(String fieldRemark) {
		this.fieldRemark = fieldRemark;
		return this;
	}
	/**
	 * 获取属性类型
	 * 
	 * @return
	 */
	public String getFliedType() {
		return fliedType;
	}
	/**
	 * 设置属性类型
	 * 
	 * @param fliedType
	 * @return
	 */
	public SdRelational setFliedType(String fliedType) {
		this.fliedType = fliedType;
		return this;
	}
	/**
	 * 获取属性名字
	 * 
	 * @return
	 */
	public String getFliedName() {
		return fliedName;
	}
	/**
	 * 设置属性名字
	 * 
	 * @param fliedName
	 * @return
	 */
	public SdRelational setFliedName(String fliedName) {
		this.fliedName = fliedName;
		return this;
	}
	/**
	 * 获取创建类与表所需要的属性
	 * 
	 * @return
	 */
	public SdBean getBean() {
		return bean;
	}
	/**
	 * 设置创建类与表所需要的属性
	 * 
	 * @param bean
	 * @return
	 */
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

}
