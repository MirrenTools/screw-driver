package org.mirrentools.sd.models.db.update;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 抽象索引属性,用于新建与修改
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
/**
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public abstract class SdAbstractIndexKeyContent {
	/** 索引的类型 */
	private String type;
	/** 索引的名字 */
	private String name;
	/** 索引的注释 */
	private String remark;
	/** 索引的列名 */
	private List<String> columns;
	/** 拓展属性 */
	private Map<String, Object> extensions;

	/**
	 * 创建的SQL语句
	 * 
	 * @return
	 */
	public abstract String createSQL();

	/**
	 * 修改的SQL语句
	 * 
	 * @return
	 */
	public abstract String updateSQL();

	/**
	 * 获取索引类型
	 * 
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * 设置索引类型
	 * 
	 * @param type
	 */
	public SdAbstractIndexKeyContent setType(String type) {
		this.type = type;
		return this;
	}

	/**
	 * 获取索引名字
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置索引名字
	 * 
	 * @param name
	 */
	public SdAbstractIndexKeyContent setName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * 获取索引的注释
	 * 
	 * @return
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 设置索引的注释
	 * 
	 * @param remark
	 * @return
	 */
	public SdAbstractIndexKeyContent setRemark(String remark) {
		this.remark = remark;
		return this;
	}

	/**
	 * 获取索引列名
	 * 
	 * @return
	 */
	public List<String> getColumns() {
		return columns;
	}

	/**
	 * 添加索引列名
	 * 
	 * @param column
	 */
	public SdAbstractIndexKeyContent addColumn(String column) {
		if (getColumns() == null) {
			setColumns(new ArrayList<String>());
		}
		getColumns().add(column);
		return this;
	}

	/**
	 * 设置索引列名
	 * 
	 * @param columns
	 */
	public SdAbstractIndexKeyContent setColumns(List<String> columns) {
		this.columns = columns;
		return this;
	}

	/**
	 * 获得拓展属性
	 * 
	 * @return
	 */
	public Map<String, Object> getExtensions() {
		return extensions;
	}

	/**
	 * 获得拓展属性值
	 * 
	 * @return
	 */
	public Object getExtension(String key) {
		return getExtensions().get(key);
	}

	/**
	 * 添加附加属性
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public SdAbstractIndexKeyContent addExtension(String key, Object value) {
		if (getExtensions() == null) {
			setExtensions(new LinkedHashMap<String, Object>());
		}
		getExtensions().put(key, value);
		return this;
	}

	/**
	 * 设置附加属性
	 * 
	 * @param extensions
	 * @return
	 */
	public SdAbstractIndexKeyContent setExtensions(Map<String, Object> extensions) {
		this.extensions = extensions;
		return this;
	}

	@Override
	public String toString() {
		return "AbstractIndexKeyContent [type=" + type + ", name=" + name + ", columns=" + columns + ", extensions=" + extensions + "]";
	}

}
