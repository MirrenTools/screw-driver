package org.mirrentools.sd.models.db.update;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.mirrentools.sd.common.SdUtil;

/**
 * 抽象表外键属性,用于新建与修改
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public abstract class AbstractForeignKeyContent {
	/** 约束名 */
	private String constraint;
	/** 引用列名 */
	private List<String> foreignKeys;
	/** 引用库 */
	private String referencesDB;
	/** 引用表 */
	private String referencesTable;
	/** 引用列名 */
	private List<String> referencesColumns;
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
	 * 获取约束名
	 * 
	 * @return
	 */
	public String getConstraint() {
		return constraint;
	}

	/**
	 * 设置约束名
	 * 
	 * @param constraint
	 */
	public AbstractForeignKeyContent setConstraint(String constraint) {
		this.constraint = constraint;
		return this;
	}

	/**
	 * 获取引用列名
	 * 
	 * @return
	 */
	public List<String> getForeignKeys() {
		return foreignKeys;
	}

	/**
	 * 设置引用列名
	 * 
	 * @param foreignKeys
	 */
	public AbstractForeignKeyContent setForeignKeys(List<String> foreignKeys) {
		this.foreignKeys = foreignKeys;
		return this;
	}

	/**
	 * 获取引用数据库名
	 * 
	 * @return
	 */
	public String getReferencesDB() {
		return referencesDB;
	}

	/**
	 * 设置引用数据库名
	 * 
	 * @param referencesDB
	 */
	public AbstractForeignKeyContent setReferencesDB(String referencesDB) {
		this.referencesDB = referencesDB;
		return this;
	}

	/**
	 * 获取引用数据库表名
	 * 
	 * @return
	 */
	public String getReferencesTable() {
		return referencesTable;
	}

	/**
	 * 设置引用数据库表名
	 * 
	 * @param referencesTable
	 */
	public AbstractForeignKeyContent setReferencesTable(String referencesTable) {
		this.referencesTable = referencesTable;
		return this;
	}

	/**
	 * 获取引用列名
	 * 
	 * @return
	 */
	public List<String> getReferencesColumns() {
		return referencesColumns;
	}

	/**
	 * 设置引用列名
	 * 
	 * @param referencesColumns
	 */
	public AbstractForeignKeyContent setReferencesColumns(List<String> referencesColumns) {
		this.referencesColumns = referencesColumns;
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
	public AbstractForeignKeyContent addExtension(String key, Object value) {
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
	public AbstractForeignKeyContent setExtensions(Map<String, Object> extensions) {
		this.extensions = extensions;
		return this;
	}

	@Override
	public String toString() {
		return "AbstractForeignKeyContent [constraint=" + constraint + ", foreignKeys=" + foreignKeys + ", referencesDB=" + referencesDB + ", referencesTable=" + referencesTable + ", referencesColumns="
				+ referencesColumns + ", extensions=" + extensions + "]";
	}

}
