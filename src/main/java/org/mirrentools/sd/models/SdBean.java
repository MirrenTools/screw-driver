package org.mirrentools.sd.models;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.mirrentools.sd.common.SdUtil;

/**
 * 创建类与表所需要的属性
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class SdBean {
	/** 表或类的名字 */
	private String name;
	/** 表或类的别名 */
	private String alias;
	/** 表或类的注释 */
	private String remark;
	/** 表或类的属性 */
	private List<SdColumn> columns;
	/** 表或类的关系属性 */
	private List<SdRelational> relationals;
	/** 拓展属性 */
	private Map<String, Object> extensions;
	/**
	 * 获取表或者类的名字
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置表或者类的名字,默认一般是设置表名,因为类名一般根据表名生成
	 * 
	 * @param name
	 * @return
	 */
	public SdBean setName(String name) {
		this.name = name;
		return this;
	}
	/**
	 * 获取表或者类的别名
	 * 
	 * @return
	 */
	public String getAlias() {
		return alias;
	}
	/**
	 * 设置表或者类的别名
	 * 
	 * @param alias
	 * @return
	 */
	public SdBean setAlias(String alias) {
		this.alias = alias;
		return this;
	}

	/**
	 * 获取注释信息
	 * 
	 * @return
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置注释信息
	 * 
	 * @param remark
	 * @return
	 */
	public SdBean setRemark(String remark) {
		this.remark = remark;
		return this;
	}

	/**
	 * 获取属性列
	 * 
	 * @return
	 */
	public List<SdColumn> getColumns() {
		return columns;
	}
	/**
	 * 添加属性列
	 * 
	 * @param column
	 * @return
	 */
	public SdBean addColumn(SdColumn column) {
		if (SdUtil.isNullOrEmpty(column)) {
			return this;
		}
		if (this.columns == null) {
			this.columns = new ArrayList<SdColumn>();
		}
		this.columns.add(column);
		return this;
	}
	/**
	 * 添加属性列
	 * 
	 * @param column
	 * @return
	 */
	public SdBean addColumn(SdColumn... columns) {
		Objects.requireNonNull(columns);
		if (this.columns == null) {
			this.columns = new ArrayList<SdColumn>();
		}
		for (SdColumn col : columns) {
			this.columns.add(col);
		}
		return this;
	}
	/**
	 * 设置属性列
	 * 
	 * @param columns
	 * @return
	 */
	public SdBean setColumns(List<SdColumn> columns) {
		this.columns = columns;
		return this;
	}

	/**
	 * 添加关联关系
	 * 
	 * @param relational
	 * @return
	 */
	public SdBean addRelational(SdRelational relational) {
		if (SdUtil.isNullOrEmpty(relational)) {
			return this;
		}
		if (this.relationals == null) {
			this.relationals = new ArrayList<SdRelational>();
		}
		this.relationals.add(relational);
		return this;
	}
	/**
	 * 获取关系属性
	 * 
	 * @return
	 */
	public List<SdRelational> getRelationals() {
		return relationals;
	}
	/**
	 * 设置关系属性
	 * 
	 * @param relationals
	 * @return
	 */
	public SdBean setRelationals(List<SdRelational> relationals) {
		this.relationals = relationals;
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
	public SdBean addExtension(String key, Object value) {
		if (SdUtil.isNullOrEmpty(key)) {
			return this;
		}
		if (this.extensions == null) {
			this.extensions = new LinkedHashMap<String, Object>();
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
	public SdBean setExtensions(Map<String, Object> extensions) {
		this.extensions = extensions;
		return this;
	}

	@Override
	public String toString() {
		return "JsgBean [name=" + name + ", remark=" + remark + ", columns=" + columns + ", relationals=" + relationals + ", extensions="
				+ extensions + "]";
	}

}
