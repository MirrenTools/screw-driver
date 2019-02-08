package org.mirrentools.sd.models.db.update;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 抽象的数据库表操作类,用于做表的新建与修改
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public abstract class SdAbstractTableContent {
	/** 表名 */
	private String tableName;
	/** 表的注释 */
	private String remark;
	/** 表列的属性 */
	private List<SdAbstractColumnContent> colums;
	/** 表主键列属性 */
	private SdAbstractPrimaryKeyContent primaryKeys;
	/** 表索引列属性 */
	private List<SdAbstractIndexKeyContent> indexKeys;
	/** 表外键列的属性 */
	private List<SdAbstractForeignKeyContent> foreignKeys;
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
	public SdAbstractTableContent setTableName(String tableName) {
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
	public SdAbstractTableContent setRemark(String remark) {
		this.remark = remark;
		return this;
	}

	/**
	 * 获取列属性
	 * 
	 * @return
	 */
	public List<SdAbstractColumnContent> getColums() {
		return colums;
	}

	/**
	 * 添加列属性
	 * 
	 * @param colum
	 * @return
	 */
	public SdAbstractTableContent addColum(SdAbstractColumnContent colum) {
		if (getColums() == null) {
			setColums(new ArrayList<SdAbstractColumnContent>());
		}
		getColums().add(colum);
		return this;
	}

	/**
	 * 设置列属性
	 * 
	 * @param colums
	 * @return
	 */
	public SdAbstractTableContent setColums(List<SdAbstractColumnContent> colums) {
		this.colums = colums;
		return this;
	}

	/**
	 * 获取主键属性
	 * 
	 * @return
	 */
	public SdAbstractPrimaryKeyContent getPrimaryKeys() {
		return primaryKeys;
	}

	/**
	 * 设置主键属性
	 * 
	 * @param primaryKeys
	 */
	public SdAbstractTableContent setPrimaryKeys(SdAbstractPrimaryKeyContent primaryKeys) {
		this.primaryKeys = primaryKeys;
		return this;
	}

	/**
	 * 获取索引属性
	 * 
	 * @return
	 */
	public List<SdAbstractIndexKeyContent> getIndexKeys() {
		return indexKeys;
	}

	/**
	 * 添加索引属性
	 * 
	 * @param indexKey
	 */
	public SdAbstractTableContent addIndexKey(SdAbstractIndexKeyContent indexKey) {
		if (getIndexKeys() == null) {
			setIndexKeys(new ArrayList<SdAbstractIndexKeyContent>());
		}
		getIndexKeys().add(indexKey);
		return this;
	}

	/**
	 * 设置索引属性
	 * 
	 * @param indexKeys
	 */
	public SdAbstractTableContent setIndexKeys(List<SdAbstractIndexKeyContent> indexKeys) {
		this.indexKeys = indexKeys;
		return this;
	}

	/**
	 * 获取 外键属性
	 * 
	 * @return
	 */
	public List<SdAbstractForeignKeyContent> getForeignKeys() {
		return foreignKeys;
	}

	/**
	 * 添加外键属性
	 * 
	 * @param foreignKey
	 */
	public SdAbstractTableContent addForeignKey(SdAbstractForeignKeyContent foreignKey) {
		if (getForeignKeys() == null) {
			setForeignKeys(new ArrayList<SdAbstractForeignKeyContent>());
		}
		getForeignKeys().add(foreignKey);
		return this;
	}

	/**
	 * 设置外键属性
	 * 
	 * @param foreignKeys
	 */
	public SdAbstractTableContent setForeignKeys(List<SdAbstractForeignKeyContent> foreignKeys) {
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
		return getExtensions().get(key);
	}

	/**
	 * 添加附加属性
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public SdAbstractTableContent addExtension(String key, Object value) {
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
	public SdAbstractTableContent setExtensions(Map<String, Object> extensions) {
		this.extensions = extensions;
		return this;
	}

	@Override
	public String toString() {
		return "SdAbstractTableContent [tableName=" + tableName + ", remark=" + remark + ", colums=" + colums + ", primaryKeys=" + primaryKeys + ", indexKeys=" + indexKeys + ", foreignKeys=" + foreignKeys
				+ ", extensions=" + extensions + "]";
	}

}
