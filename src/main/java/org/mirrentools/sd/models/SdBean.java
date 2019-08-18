package org.mirrentools.sd.models;

import java.util.ArrayList;
import java.util.Arrays;
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
	/** 表或类的名字 */
	private String name;
	/** 表或类的别名 */
	private String alias;
	/** 表或类的注释 */
	private String remark;
	/** 表或类的属性 */
	private List<SdColumn> columns;
	/** 附加的属性,该属性一般用于只需要创建类属性而不需要创建表属性时使用,可以直接定义Field属性 */
	private List<SdColumn> additionalColumns;
	/** 表或类的关系属性 */
	private List<SdRelational> relationals;
	/** 序列属性 */
	private List<SdSequence> sequences;
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
		SdUtil.requireNonNull(columns);
		if (getColumns() == null) {
			setColumns(new ArrayList<SdColumn>());
		}
		getColumns().add(column);
		return this;
	}

	/**
	 * 添加属性列
	 * 
	 * @param column
	 * @return
	 */
	public SdBean addColumn(SdColumn... columns) {
		SdUtil.requireNonNull(columns);
		if (getColumns() == null) {
			setColumns(new ArrayList<SdColumn>());
		}
		getColumns().addAll(Arrays.asList(columns));
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
	 * 获取附加属性
	 * 
	 * @return
	 */
	public List<SdColumn> getAdditionalColumns() {
		return additionalColumns;
	}

	/**
	 * 添加附加属性,该属性一般用在类需要该属性,表不需要该属性的地方
	 * 
	 * @param additionalColumn
	 * @return
	 */
	public SdBean addAdditionalColumn(SdColumn additionalColumn) {
		if (getAdditionalColumns() == null) {
			setAdditionalColumns(new ArrayList<SdColumn>());
		}
		getAdditionalColumns().add(additionalColumn);
		return this;
	}

	/**
	 * 添加附加属性,该属性一般用在类需要该属性,表不需要该属性的地方
	 * 
	 * @param additionalColumn
	 * @return
	 */
	public SdBean addAdditionalColumn(SdColumn... additionalColumn) {
		SdUtil.requireNonNull(additionalColumn);
		if (getAdditionalColumns() == null) {
			setAdditionalColumns(new ArrayList<SdColumn>());
		}
		getAdditionalColumns().addAll(Arrays.asList(additionalColumn));
		return this;
	}

	/**
	 * 设置附加属性,该属性一般用在类需要该属性,表不需要该属性的地方
	 * 
	 * @param additionalColumns
	 * @return
	 */
	public SdBean setAdditionalColumns(List<SdColumn> additionalColumns) {
		this.additionalColumns = additionalColumns;
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
	 * 获取序列
	 * 
	 * @return
	 */
	public List<SdSequence> getSequences() {
		return sequences;
	}
	/**
	 * 设置序列
	 * 
	 * @param sequences
	 * @return
	 */
	public SdBean addSequence(SdSequence sequence) {
		if (getSequences()==null) {
			setSequences(new ArrayList<SdSequence>());
		}
		getSequences().add(sequence);
		return this;
	}
	/**
	 * 设置序列
	 * 
	 * @param sequences
	 * @return
	 */
	public SdBean setSequences(List<SdSequence> sequences) {
		this.sequences = sequences;
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
	public SdBean addExtension(String key, Object value) {
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
	public SdBean setExtensions(Map<String, Object> extensions) {
		this.extensions = extensions;
		return this;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("SdBean: \n");
		sb.append("  ┣━name = " + name + "\n");
		sb.append("  ┣━remark = " + remark + "\n");
		sb.append("  ┣━columns = " + columns + "\n");
		sb.append("  ┣━relationals = " + relationals + "\n");
		sb.append("  ┣━sequences = " + sequences + "\n");
		sb.append("  ┗━extensions = " + extensions + "\n");
		return sb.toString();

	}

}
