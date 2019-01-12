package org.mirrentools.sd.models.db.update;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.mirrentools.sd.common.SdUtil;

/**
 * 抽象的数据库表操作类,用于做表的新建与修改
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public abstract class AbstractTableContent {
	/** 表名 */
	private String tableName;
	/** 表的注释 */
	private String remark;
	/** 表主键列属性 */
	private AbstractPrimaryKeyContent primaryKeys;
	/** 表索引列属性 */
	private List<AbstractIndexKeyContent> indexKeys;
	/** 表列的属性 */
	private List<AbstractColumnContent> colums;
	/** 表外键列的属性 */
	private List<AbstractForeignKeyContent> foreignKeys;
	/** 拓展属性 */
	private Map<String, Object> extensions;

	/**
	 * 创建表的SQL语句
	 * 
	 * @return
	 */
	public abstract String createSQL();

	/**
	 * 修改表的SQL语句
	 * 
	 * @return
	 */
	public abstract String updateSQL();

	/**
	 * 获取表名字
	 * 
	 * @return
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * 设置表名字
	 * 
	 * @param tableName
	 * @return
	 */
	public AbstractTableContent setTableName(String tableName) {
		this.tableName = tableName;
		return this;
	}

	/**
	 * 获取表注解
	 * 
	 * @return
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 设置表注解
	 * 
	 * @param comment
	 * @return
	 */
	public AbstractTableContent setRemark(String remark) {
		this.remark = remark;
		return this;
	}

	/**
	 * 获取列属性
	 * 
	 * @return
	 */
	public List<AbstractColumnContent> getColums() {
		return colums;
	}

	/**
	 * 设置列属性
	 * 
	 * @param colums
	 * @return
	 */
	public AbstractTableContent setColums(List<AbstractColumnContent> colums) {
		this.colums = colums;
		return this;
	}

	/**
	 * 获取主键属性
	 * 
	 * @return
	 */
	public AbstractPrimaryKeyContent getPrimaryKeys() {
		return primaryKeys;
	}

	/**
	 * 设置主键属性
	 * 
	 * @param primaryKeys
	 */
	public AbstractTableContent setPrimaryKeys(AbstractPrimaryKeyContent primaryKeys) {
		this.primaryKeys = primaryKeys;
		return this;
	}

	/**
	 * 获取索引属性
	 * 
	 * @return
	 */
	public List<AbstractIndexKeyContent> getIndexKeys() {
		return indexKeys;
	}

	/**
	 * 设置索引属性
	 * 
	 * @param indexKeys
	 */
	public AbstractTableContent setIndexKeys(List<AbstractIndexKeyContent> indexKeys) {
		this.indexKeys = indexKeys;
		return this;
	}

	/**
	 * 获取 外键属性
	 * 
	 * @return
	 */
	public List<AbstractForeignKeyContent> getForeignKeys() {
		return foreignKeys;
	}

	/**
	 * 设置外键属性
	 * 
	 * @param foreignKeys
	 */
	public AbstractTableContent setForeignKeys(List<AbstractForeignKeyContent> foreignKeys) {
		this.foreignKeys = foreignKeys;
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
	public AbstractTableContent addExtension(String key, Object value) {
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
	 * 设置附加属性
	 * 
	 * @param extensions
	 * @return
	 */
	public AbstractTableContent setExtensions(Map<String, Object> extensions) {
		this.extensions = extensions;
		return this;
	}

	@Override
	public String toString() {
		return "AbstractTableContent [tableName=" + tableName + ", remark=" + remark + ", primaryKeys=" + primaryKeys + ", indexKeys=" + indexKeys + ", colums=" + colums + ", foreignKeys=" + foreignKeys
				+ ", extensions=" + extensions + "]";
	}

}
