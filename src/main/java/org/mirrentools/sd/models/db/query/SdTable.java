package org.mirrentools.sd.models.db.query;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.mirrentools.sd.common.SdUtil;

/**
 * 数据库中表的描述
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public class SdTable {
	/** 表属性的描述信息 */
	private SdTableAttribute info;
	/** 表的列属性 */
	private List<SdTableColumnAttribute> columns;
	/** 表的主键属性 */
	private SdTablePrimaryKeyAttribute primaryKey;
	/** 表的索引属性 */
	private List<SdTableIndexKeyAttribute> indexKeys;
	/** 表的外键属性 */
	private List<SdTablePortedKeysAttribute> foreignKeys;
	/** 拓展属性 */
	private Map<String, Object> extensions;
	/**
	 * 获取表属性
	 * 
	 * @return
	 */
	public SdTableAttribute getInfo() {
		return info;
	}
	/**
	 * 设置表属性
	 * 
	 * @param info
	 * @return
	 */
	public SdTable setInfo(SdTableAttribute info) {
		this.info = info;
		return this;
	}
	/**
	 * 获取所有列
	 * 
	 * @return
	 */
	public List<SdTableColumnAttribute> getColumns() {
		return columns;
	}
	/**
	 * 添加列
	 * 
	 * @param columns
	 * @return
	 */
	public SdTable addColumn(SdTableColumnAttribute column) {
		if (getColumns() == null) {
			setColumns(new ArrayList<SdTableColumnAttribute>());
		}
		getColumns().add(column);
		return this;
	}
	/**
	 * 设置所有列
	 * 
	 * @param columns
	 * @return
	 */
	public SdTable setColumns(List<SdTableColumnAttribute> columns) {
		this.columns = columns;
		return this;
	}
	/**
	 * 获取主键属性
	 * 
	 * @return
	 */
	public SdTablePrimaryKeyAttribute getPrimaryKey() {
		return primaryKey;
	}
	/**
	 * 设置主键属性
	 * 
	 * @param primaryKey
	 * @return
	 */
	public SdTable setPrimaryKey(SdTablePrimaryKeyAttribute primaryKey) {
		this.primaryKey = primaryKey;
		return this;
	}
	/**
	 * 获取索引属性
	 * 
	 * @return
	 */
	public List<SdTableIndexKeyAttribute> getIndexKeys() {
		return indexKeys;
	}
	/**
	 * 设置索引属性
	 * 
	 * @param indexKeys
	 * @return
	 */
	public SdTable addIndexKey(SdTableIndexKeyAttribute indexKey) {
		if (getIndexKeys() == null) {
			setIndexKeys(new ArrayList<SdTableIndexKeyAttribute>());
		}
		getIndexKeys().add(indexKey);
		return this;
	}
	/**
	 * 设置索引属性
	 * 
	 * @param indexKeys
	 * @return
	 */
	public SdTable setIndexKeys(List<SdTableIndexKeyAttribute> indexKeys) {
		this.indexKeys = indexKeys;
		return this;
	}
	/**
	 * 获取外键属性
	 * 
	 * @return
	 */
	public List<SdTablePortedKeysAttribute> getForeignKeys() {
		return foreignKeys;
	}
	/**
	 * 设置外键属性
	 * 
	 * @param foreignKeys
	 * @return
	 */
	public SdTable addForeignKey(SdTablePortedKeysAttribute foreignKey) {
		if (getForeignKeys() == null) {
			setForeignKeys(new ArrayList<SdTablePortedKeysAttribute>());
		}
		getForeignKeys().add(foreignKey);
		return this;
	}
	/**
	 * 设置外键属性
	 * 
	 * @param foreignKeys
	 * @return
	 */
	public SdTable setForeignKeys(List<SdTablePortedKeysAttribute> foreignKeys) {
		this.foreignKeys = foreignKeys;
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
	public SdTable addExtension(String key, Object value) {
		if (getExtensions() == null) {
			setExtensions(new LinkedHashMap<String, Object>());
		}
		getExtensions().put(key, value);
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
	public SdTable setExtensions(Map<String, Object> extensions) {
		this.extensions = extensions;
		return this;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("SdTable: \n");
		sb.append("  ┣━table = " + info + "\n");
		sb.append("  ┣━columns = " + columns + "\n");
		sb.append("  ┣━primaryKey = " + primaryKey + "\n");
		sb.append("  ┣━indexKeys = " + indexKeys + "\n");
		sb.append("  ┣━foreignKeys = " + foreignKeys + "\n");
		sb.append("  ┗━extensions = " + extensions + "\n");
		return sb.toString();
	}

}
