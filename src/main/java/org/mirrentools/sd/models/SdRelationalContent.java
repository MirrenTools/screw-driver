package org.mirrentools.sd.models;

import java.util.HashSet;
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
public class SdRelationalContent {
	/** 需要导入的包 */
	private Set<String> imports;
	/** 注解 */
	private Set<String> annotations;
	/** 关系类型 */
	private Relational relationalType;

	/** 关系属性的注释 */
	private String fieldRemark;
	/** 关系属性数据类型,比如List<Type> */
	private String fieldType;
	/** 属性的名字 */
	private String fieldName;
	/** 表的名字帕斯卡命名 */
	private String pascalName;
	/** 表的名字驼峰命名 */
	private String camelName;
	/** 表的名字连字符命名 */
	private String hyphenName;
	/** 表的名字下划线命名 */
	private String underScoreName;
	/** 创建类与表所需要的属性 */
	private SdClassContent classContent;
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
	public SdRelationalContent addImport(String imports) {
		if (getImports() == null) {
			setImports(new HashSet<String>());
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
	public SdRelationalContent setImports(Set<String> imports) {
		this.imports = imports;
		return this;
	}
	/**
	 * 获取注解
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
	public SdRelationalContent addAnnotation(String annotation) {
		if (getAnnotations() == null) {
			setAnnotations(new HashSet<String>());
		}
		getAnnotations().add(annotation);
		return this;
	}
	/**
	 * 设置注解
	 * 
	 * @param annotations
	 * @return
	 */
	public SdRelationalContent setAnnotations(Set<String> annotations) {
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
	public SdRelationalContent setRelationalType(Relational relationalType) {
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
	public SdRelationalContent setFieldRemark(String fieldRemark) {
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
	public SdRelationalContent setFieldType(String fieldType) {
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
	public SdRelationalContent setFieldName(String fieldName) {
		this.fieldName = fieldName;
		return this;
	}
	/**
	 * 获取表名的帕斯卡命名
	 * 
	 * @return
	 */
	public String getPascalName() {
		return pascalName;
	}
	/**
	 * 设置表名的帕斯卡命名
	 * 
	 * @param pascalName
	 * @return
	 */
	public SdRelationalContent setPascalName(String pascalName) {
		this.pascalName = pascalName;
		return this;
	}
	/**
	 * 获取表名的驼峰命名
	 * 
	 * @return
	 */
	public String getCamelName() {
		return camelName;
	}
	/**
	 * 表名的驼峰命名
	 * 
	 * @param camelName
	 * @return
	 */
	public SdRelationalContent setCamelName(String camelName) {
		this.camelName = camelName;
		return this;
	}
	/**
	 * 获取表名的连字符命名
	 * 
	 * @return
	 */
	public String getHyphenName() {
		return hyphenName;
	}
	/**
	 * 设置表名的连字符命名
	 * 
	 * @param hyphenName
	 * @return
	 */
	public SdRelationalContent setHyphenName(String hyphenName) {
		this.hyphenName = hyphenName;
		return this;
	}
	/**
	 * 获取表名的下划线命名
	 * 
	 * @return
	 */
	public String getUnderScoreName() {
		return underScoreName;
	}
	/**
	 * 设置表名的下划线命名
	 * 
	 * @param underScoreName
	 * @return
	 */
	public SdRelationalContent setUnderScoreName(String underScoreName) {
		this.underScoreName = underScoreName;
		return this;
	}

	/**
	 * 获取实体类需要的属性
	 * 
	 * @return
	 */
	public SdClassContent getClassContent() {
		return classContent;
	}
	/**
	 * 设置实体类需要的属性
	 * 
	 * @param classContent
	 * @return
	 */
	public SdRelationalContent setClassContent(SdClassContent classContent) {
		this.classContent = classContent;
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
	public SdRelationalContent addExtension(String key, Object value) {
		if (getExtensions()==null) {
			setExtensions(new LinkedHashMap<String, Object>());
		}
		getExtensions().put(key, value);
		return this;
	}

	public Map<String, Object> getExtensions() {
		return extensions;
	}

	public SdRelationalContent setExtensions(Map<String, Object> extensions) {
		this.extensions = extensions;
		return this;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("SdRelationalContent: \n");
		sb.append("┣━imports = " + imports + "\n");
		sb.append("┣━annotations = " + annotations + "\n");
		sb.append("┣━relationalType = " + relationalType + "\n");
		sb.append("┣━fieldRemark = " + fieldRemark + "\n");
		sb.append("┣━fieldType = " + fieldType + "\n");
		sb.append("┣━fieldName = " + fieldName + "\n");
		sb.append("┣━pascalName = " + pascalName + "\n");
		sb.append("┣━camelName = " + camelName + "\n");
		sb.append("┣━hyphenName = " + hyphenName + "\n");
		sb.append("┣━underScoreName = " + underScoreName + "\n");
		sb.append("┣━classContent = " + classContent + "\n");
		sb.append("┗━extensions = " + extensions + "\n");
		return sb.toString();
	}

}
