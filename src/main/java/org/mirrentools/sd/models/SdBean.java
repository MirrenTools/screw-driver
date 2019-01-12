package org.mirrentools.sd.models;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.mirrentools.sd.common.SdUtil;

/**
 * 创建类与表所需要的属性
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class SdBean {
	/** 表的名字 */
	private String name;
	/** 表的名字 */
	private String remark;
	/** 表的列属性 */
	private List<SdColumn> columns;
	/** 表的关系属性 */
	private List<SdRelational> relationals;
	/** 拓展属性 */
	private Map<String, Object> extensions;

	public String getName() {
		return name;
	}

	public SdBean setName(String name) {
		this.name = name;
		return this;
	}

	public String getRemark() {
		return remark;
	}

	public SdBean setRemark(String remark) {
		this.remark = remark;
		return this;
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

	public List<SdColumn> getColumns() {
		return columns;
	}

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

	public List<SdRelational> getRelationals() {
		return relationals;
	}

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

	public Map<String, Object> getExtensions() {
		return extensions;
	}

	public SdBean setExtensions(Map<String, Object> extensions) {
		this.extensions = extensions;
		return this;
	}

	@Override
	public String toString() {
		return "JsgBean [name=" + name + ", remark=" + remark + ", columns=" + columns + ", relationals=" + relationals + ", extensions=" + extensions + "]";
	}

}
