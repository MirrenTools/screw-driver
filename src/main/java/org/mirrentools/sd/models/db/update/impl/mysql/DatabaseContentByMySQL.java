package org.mirrentools.sd.models.db.update.impl.mysql;

import org.mirrentools.sd.models.db.update.AbstractDatabaseContent;

/**
 * MySQL数据库的数据库属性
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public class DatabaseContentByMySQL extends AbstractDatabaseContent {
	/** 字符集 */
	private String characterSet;
	/** 数据库排序规则 */
	private String collate;

	/**
	 * 初始化一个数据库SQL类
	 * 
	 * @param databaseName
	 *          数据库的名字
	 */
	public DatabaseContentByMySQL(String databaseName) {
		super(databaseName);
	}

	/**
	 * 初始化一个数据库SQL类
	 * 
	 * @param databaseName
	 *          数据库的名字
	 * @param characterSet
	 *          数据的字符集
	 * @param collate
	 *          数据库的排序规则
	 */
	public DatabaseContentByMySQL(String databaseName, String characterSet, String collate) {
		super(databaseName);
		this.characterSet = characterSet;
		this.collate = collate;
	}

	@Override
	public String createSQL() {
		if (getDatabaseName() == null) {
			throw new NullPointerException("数据库的名字不能为空");
		}
		StringBuilder sb = new StringBuilder("CREATE DATABASE ");
		sb.append(getDatabaseName());
		if (getCharacterSet() != null) {
			sb.append(" DEFAULT CHARACTER SET ");
			sb.append(getCharacterSet());
		}
		if (getCollate() != null) {
			sb.append(" COLLATE ");
			sb.append(getCollate());
		}
		sb.append(";");
		return sb.toString();
	}

	@Override
	public String updateSQL() throws UnsupportedOperationException {
		throw new UnsupportedOperationException("该方法未实现");
	}

	/**
	 * 获取字符集
	 * 
	 * @return
	 */
	public String getCharacterSet() {
		return characterSet;
	}

	/**
	 * 设置字符集
	 * 
	 * @param characterSet
	 */
	public void setCharacterSet(String characterSet) {
		this.characterSet = characterSet;
	}

	/**
	 * 获取字符集核对
	 * 
	 * @return
	 */
	public String getCollate() {
		return collate;
	}

	/**
	 * 设置字符集核对
	 * 
	 * @param collate
	 */
	public void setCollate(String collate) {
		this.collate = collate;
	}

}
