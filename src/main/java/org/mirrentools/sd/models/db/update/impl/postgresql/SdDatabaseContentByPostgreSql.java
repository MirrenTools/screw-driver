package org.mirrentools.sd.models.db.update.impl.postgresql;

import org.mirrentools.sd.models.db.update.SdAbstractDatabaseContent;

/**
 * PostgreSql数据库的数据库属性
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public class SdDatabaseContentByPostgreSql extends SdAbstractDatabaseContent {
	/** 用户的角色名 */
	private String userName;
	/** 数据库的模板名称 */
	private String template;
	/** 字符集编码 */
	private String encoding;
	/** 排序规则顺序 */
	private String collate;
	/** 数据库相关联的表空间名称 */
	private String tablespaceName;

	/**
	 * 初始化一个数据库SQL类
	 * 
	 * @param databaseName
	 *          数据库的名字
	 */
	public SdDatabaseContentByPostgreSql(String databaseName) {
		super(databaseName);
	}

	/**
	 * 初始化一个数据库SQL类
	 * 
	 * @param databaseName
	 *          数据库的名字
	 * @param tablespaceName
	 *          数据库相关联的表空间名称
	 * @param userName
	 *          用户的角色名
	 * @param encoding
	 *          字符集编码
	 * @param collate
	 *          排序规则顺序
	 */
	public SdDatabaseContentByPostgreSql(String databaseName, String tablespaceName, String userName, String encoding, String collate) {
		super(databaseName);
		this.tablespaceName = tablespaceName;
		this.userName = userName;
		this.encoding = encoding;
		this.collate = collate;
	}

	@Override
	public String createSQL() {
		if (getDatabaseName() == null) {
			throw new NullPointerException("数据库的名字不能为空");
		}
		StringBuilder sb = new StringBuilder("CREATE DATABASE ");
		sb.append(getDatabaseName());
		sb.append(";");
		return sb.toString();
	}

	@Override
	public String updateSQL() throws UnsupportedOperationException {
		// TODO 等待实现
		return null;
	}

	@Override
	public String deleteSQL() {
		return "DROP DATABASE " + getDatabaseName();
	}

	/**
	 * 获取将拥有该数据库的用户的角色名
	 * 
	 * @return
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 设置将拥有该数据库的用户的角色名
	 * 
	 * @param userName
	 * @return
	 */
	public SdDatabaseContentByPostgreSql setUserName(String userName) {
		this.userName = userName;
		return this;
	}

	/**
	 * 获取要从其创建新数据库的模板名称
	 * 
	 * @return
	 */
	public String getTemplate() {
		return template;
	}

	/**
	 * 设置要从其创建新数据库的模板名称
	 * 
	 * @param template
	 * @return
	 */
	public SdDatabaseContentByPostgreSql setTemplate(String template) {
		this.template = template;
		return this;
	}

	/**
	 * 获取使用的字符集编码。
	 * 
	 * @return
	 */
	public String getEncoding() {
		return encoding;
	}

	/**
	 * 设置使用的字符集编码。
	 * 
	 * @param encoding
	 * @return
	 */
	public SdDatabaseContentByPostgreSql setEncoding(String encoding) {
		this.encoding = encoding;
		return this;
	}

	/**
	 * 获取使用的排序规则顺序
	 * 
	 * @return
	 */
	public String getCollate() {
		return collate;
	}

	/**
	 * 设置使用的排序规则顺序
	 * 
	 * @param collate
	 * @return
	 */
	public SdDatabaseContentByPostgreSql setCollate(String collate) {
		this.collate = collate;
		return this;
	}

	/**
	 * 获取数据库相关联的表空间名称
	 * 
	 * @return
	 */
	public String getTablespaceName() {
		return tablespaceName;
	}

	/**
	 * 设置数据库相关联的表空间名称
	 * 
	 * @param tablespaceName
	 * @return
	 */
	public SdDatabaseContentByPostgreSql setTablespaceName(String tablespaceName) {
		this.tablespaceName = tablespaceName;
		return this;
	}

}
