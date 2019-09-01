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
	/** 索引是否为唯一 */
	private boolean unique;
	/** 索引是否并发 */
	private boolean concurrently;
	/** 索引的类型 */
	private String type;
	/** 索引的名字 */
	private String name;
	/** 要删除索引的名字 */
	private String removeIndexName;
	/** 索引的注释 */
	private String remark;
	/** 索引的列名 */
	private List<String> columns;
	/** 拓展属性 */
	private Map<String, Object> extensions;
	/** 模式 */
	private String schema;
	/** 表 */
	private String table;

	/**
	 * 创建的SQL语句
	 * 
	 * @return
	 */
	public abstract String createSQL();

	/**
	 * 修改的SQL语句,仅可以添加或删除
	 * 
	 * @return
	 */
	public abstract String updateSQL();

	/**
	 * 删除的SQL语句,如果getRemoveIndexName==null返回null
	 * 
	 * @return
	 */
	public abstract String deleteSQL();

	/**
	 * 转换拓展字段,该方法用户转换拓展字段,如果基础的getBasicSQL方法可以用但是需要用到拓展字段时可以重写该方法,给方法的内容如果不为空会被追加到最后
	 * 
	 * @return
	 */
	public String converterExtensions() {
		return null;
	}

	/**
	 * 获取索引是否为唯一索引
	 * 
	 * @return
	 */
	public boolean isUnique() {
		return unique;
	}

	/**
	 * 设置索引是否为唯一索引
	 * 
	 * @param unique
	 * @return
	 */
	public SdAbstractIndexKeyContent setUnique(boolean unique) {
		this.unique = unique;
		return this;
	}

	/**
	 * 获取索引是否并发
	 * 
	 * @return
	 */
	public boolean isConcurrently() {
		return concurrently;
	}

	/**
	 * 设置索引是否并发
	 * 
	 * @param concurrently
	 * @return
	 */
	public SdAbstractIndexKeyContent setConcurrently(boolean concurrently) {
		this.concurrently = concurrently;
		return this;
	}

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
	 * 设置要删除索引的名字
	 * 
	 * @return
	 */
	public String getRemoveIndexName() {
		return removeIndexName;
	}

	/**
	 * 设置删除索引的名字
	 * 
	 * @param removeIndexName
	 * @return
	 */
	public SdAbstractIndexKeyContent setRemoveIndexName(String removeIndexName) {
		this.removeIndexName = removeIndexName;
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
	/**
	 * 获取索引的模式
	 * 
	 * @return
	 */
	public String getSchema() {
		return schema;
	}
	/**
	 * 设置索引模式
	 * 
	 * @param columns
	 */
	public SdAbstractIndexKeyContent setSchema(String schema) {
		this.schema = schema;
		return this;
	}
	/**
	 * 获取索引的表
	 * 
	 * @return
	 */
	public String getTable() {
		return table;
	}
	/**
	 * 设置索引的表
	 * 
	 * @param columns
	 */
	public SdAbstractIndexKeyContent setTable(String table) {
		this.table = table;
		return this;
	}

	@Override
	public String toString() {
		return "AbstractIndexKeyContent [type=" + type + ", name=" + name + ", columns=" + columns + ", schema=\" + schema +, table=\" + table +, extensions=" + extensions + "]";
	}

}
