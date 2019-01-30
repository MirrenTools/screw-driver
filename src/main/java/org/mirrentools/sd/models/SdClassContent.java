package org.mirrentools.sd.models;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.mirrentools.sd.common.SdUtil;

/**
 * 模板生成所需要的实体属性
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class SdClassContent {
	/** 表的名字 */
	private String tableName;
	/** 表的名字帕斯卡命名 */
	private String pascalName;
	/** 表的名字驼峰命名 */
	private String camelName;
	/** 表的注释 */
	private String remark;
	/** 需要导入的包 */
	private Set<String> imports;
	/** 所有属性集 */
	private List<SdColumn> allField;
	/** 所有主键属性集 */
	private List<SdColumn> primaryField;
	/** 所有索引属性集 */
	private List<SdColumn> indexField;
	/** 表或类的关系属性 */
	private List<SdRelational> relationals;
	/** 属性的获取与设置方法 */
	private Set<String> getSet;
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
	 */
	public SdClassContent setImports(Set<String> imports) {
		this.imports = imports;
		return this;
	}

	/**
	 * 获取所有属性列
	 * 
	 * @return
	 */
	public List<SdColumn> getAllField() {
		return allField;
	}

	/**
	 * 设置所有属性列
	 * 
	 * @param allField
	 * @return
	 */
	public SdClassContent setAllField(List<SdColumn> allField) {
		this.allField = allField;
		return this;
	}

	/**
	 * 获取主键属性列
	 * 
	 * @return
	 */
	public List<SdColumn> getPrimaryField() {
		return primaryField;
	}

	/**
	 * 设置主键属性列
	 * 
	 * @param primaryField
	 * @return
	 */
	public SdClassContent setPrimaryField(List<SdColumn> primaryField) {
		this.primaryField = primaryField;
		return this;
	}

	/**
	 * 获取索引属性列
	 * 
	 * @return
	 */
	public List<SdColumn> getIndexField() {
		return indexField;
	}

	/**
	 * 设置索引属性列
	 * 
	 * @param indexField
	 * @return
	 */
	public SdClassContent setIndexField(List<SdColumn> indexField) {
		this.indexField = indexField;
		return this;
	}

	/**
	 * 获取关系列属性
	 * 
	 * @return
	 */
	public List<SdRelational> getRelationals() {
		return relationals;
	}

	/**
	 * 设置关系列属性
	 * 
	 * @param relationals
	 * @return
	 */
	public SdClassContent setRelationals(List<SdRelational> relationals) {
		this.relationals = relationals;
		return this;
	}

	/**
	 * 获取get与set方法
	 * 
	 * @return
	 */
	public Set<String> getGetSet() {
		return getSet;
	}

	/**
	 * 设置get与set方法
	 * 
	 * @param getSet
	 * @return
	 */
	public SdClassContent setGetSet(Set<String> getSet) {
		this.getSet = getSet;
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
	public SdClassContent addExtension(String key, Object value) {
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

	/**
	 * 设置拓展属性
	 * 
	 * @param extensions
	 * @return
	 */
	public SdClassContent setExtensions(Map<String, Object> extensions) {
		this.extensions = extensions;
		return this;
	}

}
