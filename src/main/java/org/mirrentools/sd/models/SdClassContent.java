package org.mirrentools.sd.models;

import java.util.List;
import java.util.Set;

/**
 * 模板生成所需要的实体属性
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class SdClassContent {
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

}
