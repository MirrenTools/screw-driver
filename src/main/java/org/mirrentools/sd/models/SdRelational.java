package org.mirrentools.sd.models;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
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
	/** 属性需要的注解 */
	private Set<String> annotations;
	/** 关系类型 */
	private Relational relationalType;
	/** 关系属性的注释 */
	private String fieldRemark;
	/** 属性数据类型,比如List<Type> */
	private String fieldType;
	/** 属性的名字 */
	private String fieldName;
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
	 * 添加需要引入的包
	 * 
	 * @param imports
	 * @return
	 */
	public SdRelational addImport(String imports) {
		if (getImports() == null) {
			setImports(new LinkedHashSet<String>());
		}
		getImports().add(imports);
		return this;
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
	 * 添加注释
	 * 
	 * @param annotations
	 * @return
	 */
	public SdRelational addAnnotation(String annotation) {
		if (getAnnotations() == null) {
			setAnnotations(new LinkedHashSet<String>());
		}
		getAnnotations().add(annotation);
		return this;
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
	 * 
	 * @return
	 */
	public String getFieldRemark() {
		return fieldRemark;
	}
	/**
	 * 设置关系属性注释
	 * 
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
	public String getFieldType() {
		return fieldType;
	}
	/**
	 * 设置属性类型
	 * 
	 * @param fieldType
	 * @return
	 */
	public SdRelational setFieldType(String fieldType) {
		this.fieldType = fieldType;
		return this;
	}
	/**
	 * 获取属性名字
	 * 
	 * @return
	 */
	public String getFieldName() {
		return fieldName;
	}
	/**
	 * 设置属性名字
	 * 
	 * @param fieldName
	 * @return
	 */
	public SdRelational setFieldName(String fieldName) {
		this.fieldName = fieldName;
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
	public SdRelational addExtension(String key, Object value) {
		if (getExtensions() == null) {
			setExtensions(new LinkedHashMap<String, Object>());
		}
		getExtensions().put(key, value);
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
		StringBuilder sb = new StringBuilder();
		sb.append("SdRelational: \n");
		sb.append("  ┣━imports = " + imports + "\n");
		sb.append("  ┣━annotations = " + annotations + "\n");
		sb.append("  ┣━relationalType = " + relationalType + "\n");
		sb.append("  ┣━fieldRemark = " + fieldRemark + "\n");
		sb.append("  ┣━fieldType = " + fieldType + "\n");
		sb.append("  ┣━fieldName = " + fieldName + "\n");
		sb.append("  ┣━bean = " + bean + "\n");
		sb.append("  ┗━extensions = " + extensions + "\n");
		return sb.toString();

	}

}
