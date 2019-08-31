package org.mirrentools.sd.models.db.update;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 抽象表外键属性,用于新建与修改
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public abstract class SdAbstractForeignKeyContent {
	/** 约束名 */
	private String constraint;
	/** 要删除的约束名 */
	private String removeConstraint;
	/** 外键列名 */
	private List<String> foreignKeys;
	/** 引用库或模式 */
	private String referencesDB;
	/** 引用表 */
	private String referencesTable;
	/** 引用列名 */
	private List<String> referencesColumns;
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
	 * 删除的SQL语句,如果getRemoveConstraint==null返回null
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
	public SdAbstractForeignKeyContent setConstraint(String constraint) {
		this.constraint = constraint;
		return this;
	}

	/**
	 * 获取要删除的约束名
	 * 
	 * @return
	 */
	public String getRemoveConstraint() {
		return removeConstraint;
	}

	/**
	 * 设置要删除的要删除的约束名
	 * 
	 * @param removeConstraint
	 * @return
	 */
	public SdAbstractForeignKeyContent setRemoveConstraint(String removeConstraint) {
		this.removeConstraint = removeConstraint;
		return this;
	}

	/**
	 * 获取引用那个数据库或模式
	 * 
	 * @return
	 */
	public String getReferencesDB() {
		return referencesDB;
	}

	/**
	 * 设置应用那个数据库或模式
	 * 
	 * @param referencesDB
	 * @return
	 */
	public SdAbstractForeignKeyContent setReferencesDB(String referencesDB) {
		this.referencesDB = referencesDB;
		return this;
	}

	/**
	 * 获取引用那个表
	 * 
	 * @return
	 */
	public String getReferencesTable() {
		return referencesTable;
	}

	/**
	 * 设置引用那个表
	 * 
	 * @param referencesTable
	 * @return
	 */
	public SdAbstractForeignKeyContent setReferencesTable(String referencesTable) {
		this.referencesTable = referencesTable;
		return this;
	}

	/**
	 * 获取引用那些列
	 * 
	 * @return
	 */
	public List<String> getReferencesColumns() {
		return referencesColumns;
	}

	/**
	 * 添加引用列
	 * 
	 * @param referencesColumns
	 * @return
	 */
	public SdAbstractForeignKeyContent addReferencesColumn(String referencesColumn) {
		if (getReferencesColumns() == null) {
			setReferencesColumns(new ArrayList<String>());
		}
		getReferencesColumns().add(referencesColumn);
		return this;
	}

	/**
	 * 设置引用那些列
	 * 
	 * @param referencesColumns
	 * @return
	 */
	public SdAbstractForeignKeyContent setReferencesColumns(List<String> referencesColumns) {
		this.referencesColumns = referencesColumns;
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
	 * 添加引用列名
	 * 
	 * @param foreignKey
	 */
	public SdAbstractForeignKeyContent addForeignKey(String foreignKey) {
		if (getForeignKeys() == null) {
			setForeignKeys(new ArrayList<String>());
		}
		getForeignKeys().add(foreignKey);
		return this;
	}

	/**
	 * 设置引用列名
	 * 
	 * @param foreignKeys
	 */
	public SdAbstractForeignKeyContent setForeignKeys(List<String> foreignKeys) {
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
	public SdAbstractForeignKeyContent addExtension(String key, Object value) {
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
	public SdAbstractForeignKeyContent setExtensions(Map<String, Object> extensions) {
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
	public void setSchema(String schema) {
		this.schema = schema;
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
	public void setTable(String table) {
		this.table = table;
	}

	@Override
	public String toString() {
		return "SdAbstractForeignKeyContent [constraint=" + constraint + ", removeConstraint=" + removeConstraint
				+ ", foreignKeys=" + foreignKeys + ", referencesDB=" + referencesDB + ", referencesTable=" + referencesTable
				+ ", referencesColumns=" + referencesColumns + ", extensions=" + extensions + ", schema=" + schema + ", table="
				+ table + "]";
	}


}
