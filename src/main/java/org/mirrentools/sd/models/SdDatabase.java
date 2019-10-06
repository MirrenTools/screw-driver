package org.mirrentools.sd.models;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Sd数据库描述
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public class SdDatabase {
	/** 数据库的名称 */
	private String database;
	/** 数据库新的名称 */
	private String newDatabase;
	/** 用户的角色名 */
	private String userName;
	/** 数据库的模板名称 */
	private String template;
	/** 字符集编码 */
	private String encoding;
	/** 排序规则顺序 */
	private String collate;
	/** 数据库中使用的字符分类 */
	private String ctype;
	/** 数据库相关联的表空间名称 */
	private String tablespaceName;
	/** 如果为假，则没有人能连接到这个数据库。默认为真，表示允许连接（除了被其他机制约束以外，例如GRANT/REVOKE CONNECT） */
	private String allowconn;
	/** 这个数据库允许多少并发连接。-1（默认值）表示没有限制。 */
	private String connlimit;
	/** 如果为真，则任何具有CREATEDB特权的用户都可以从这个数据库克隆。如果为假（默认），则只有超级用户或者该数据库的拥有者可以克隆它。 */
	private String istemplate;

	/** 数据库逻辑名称显示在数据库的名字 */
	private String dbName;
	/** 数据库存放的路径 */
	private String dbFilename;
	/** 数据库的大小比如=5 就代表5mb */
	private String dbSize;
	/** 数据库的大小增长按百分比还是按指定在都可以,比如=10%/=5则代表按10%增长/5mb增长 */
	private String dbFilegrowth;
	/** 数据库文件最大值 */
	private String dbMaxsize;

	/** 日志文件逻辑名称显示在日志文件的名字 */
	private String logName;
	/** 日志文件存放的路径 */
	private String logFilename;
	/** 日志文件的大小比如=5 就代表5mb */
	private String logSize;
	/** 日志文件的大小增长按百分比还是按指定在都可以,比如=10%/=5则代表按10%增长/5mb增长 */
	private String logFilegrowth;
	/** 日志文件最大值 */
	private String logMaxsize;
	/** 拓展属性 */
	private Map<String, Object> extensions;

	/**
	 * 获取数据库的名称
	 * 
	 * @return
	 */
	public String getDatabase() {
		return database;
	}

	/**
	 * 设置数据库名称
	 * 
	 * @param database
	 * @return
	 */
	public SdDatabase setDatabase(String database) {
		this.database = database;
		return this;
	}

	/**
	 * 获取数据库新的名称
	 * 
	 * @return
	 */
	public String getNewDatabase() {
		return newDatabase;
	}

	/**
	 * 设置数据库新的名称
	 * 
	 * @param newDatabase
	 * @return
	 */
	public SdDatabase setNewDatabase(String newDatabase) {
		this.newDatabase = newDatabase;
		return this;
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
	public SdDatabase setUserName(String userName) {
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
	public SdDatabase setTemplate(String template) {
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
	public SdDatabase setEncoding(String encoding) {
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
	public SdDatabase setCollate(String collate) {
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
	public SdDatabase setTablespaceName(String tablespaceName) {
		this.tablespaceName = tablespaceName;
		return this;
	}

	/**
	 * 获取要在新数据库中使用的字符分类（LC_CTYPE）。这会影响字符的类别，如小写、大写和数字。默认是使用模板数据库的字符分类。附加限制见下文。
	 * 
	 * @return
	 */
	public String getCtype() {
		return ctype;
	}

	/**
	 * 设置要在新数据库中使用的字符分类（LC_CTYPE）。这会影响字符的类别，如小写、大写和数字。默认是使用模板数据库的字符分类。附加限制见下文。
	 * 
	 * @param ctype
	 * @return
	 */
	public SdDatabase setCtype(String ctype) {
		this.ctype = ctype;
		return this;
	}

	/**
	 * 获取如果为假，则没有人能连接到这个数据库。默认为真，表示允许连接（除了被其他机制约束以外，例如GRANT/REVOKE CONNECT）。
	 * 
	 * @return
	 */
	public String getAllowconn() {
		return allowconn;
	}

	/**
	 * 设置如果为假，则没有人能连接到这个数据库。默认为真，表示允许连接（除了被其他机制约束以外，例如GRANT/REVOKE CONNECT）。
	 * 
	 * @param allowconn
	 * @return
	 */
	public SdDatabase setAllowconn(String allowconn) {
		this.allowconn = allowconn;
		return this;
	}

	/**
	 * 获取这个数据库允许多少并发连接。-1（默认值）表示没有限制。
	 * 
	 * @return
	 */
	public String getConnlimit() {
		return connlimit;
	}

	/**
	 * 设置这个数据库允许多少并发连接。-1（默认值）表示没有限制。
	 * 
	 * @param connlimit
	 * @return
	 */
	public SdDatabase setConnlimit(String connlimit) {
		this.connlimit = connlimit;
		return this;
	}

	/**
	 * 获取如果为真，则任何具有CREATEDB特权的用户都可以从这个数据库克隆。如果为假（默认），则只有超级用户或者该数据库的拥有者可以克隆它。
	 * 
	 * @return
	 */
	public String getIstemplate() {
		return istemplate;
	}

	/**
	 * 设置如果为真，则任何具有CREATEDB特权的用户都可以从这个数据库克隆。如果为假（默认），则只有超级用户或者该数据库的拥有者可以克隆它。
	 * 
	 * @param istemplate
	 * @return
	 */
	public SdDatabase setIstemplate(String istemplate) {
		this.istemplate = istemplate;
		return this;
	}

	/**
	 * 获取数据库逻辑名称
	 * 
	 * @return
	 */
	public String getDbName() {
		return dbName;
	}

	/**
	 * 设置数据库逻辑名称
	 * 
	 * @param dbName
	 * @return
	 */
	public SdDatabase setDbName(String dbName) {
		this.dbName = dbName;
		return this;
	}

	/**
	 * 获取数据库文件存储路径
	 * 
	 * @return
	 */
	public String getDbFilename() {
		return dbFilename;
	}

	/**
	 * 设置数据库文件存储路径
	 * 
	 * @param dbFilename
	 * @return
	 */
	public SdDatabase setDbFilename(String dbFilename) {
		this.dbFilename = dbFilename;
		return this;
	}

	/**
	 * 获取数据库的大小比如=5 就代表5mb
	 * 
	 * @return
	 */
	public String getDbSize() {
		return dbSize;
	}

	/**
	 * 设置数据库的大小比如=5 就代表5mb
	 * 
	 * @param dbSize
	 * @return
	 */
	public SdDatabase setDbSize(String dbSize) {
		this.dbSize = dbSize;
		return this;
	}

	/**
	 * 获取数据库的大小增长按百分比还是按指定在都可以,比如=10%/=5则代表按10%增长/5mb增长
	 * 
	 * @return
	 */
	public String getDbFilegrowth() {
		return dbFilegrowth;
	}

	/**
	 * 设置数据库的大小增长按百分比还是按指定在都可以,比如=10%/=5则代表按10%增长/5mb增长
	 * 
	 * @param dbFilegrowth
	 * @return
	 */
	public SdDatabase setDbFilegrowth(String dbFilegrowth) {
		this.dbFilegrowth = dbFilegrowth;
		return this;
	}

	/**
	 * 获取数据库文件最大值
	 * 
	 * @return
	 */
	public String getDbMaxsize() {
		return dbMaxsize;
	}

	/**
	 * 设置数据库文件最大值
	 * 
	 * @param dbMaxsize
	 * @return
	 */
	public SdDatabase setDbMaxsize(String dbMaxsize) {
		this.dbMaxsize = dbMaxsize;
		return this;
	}

	/**
	 * 获取日志文件逻辑名称显示在日志文件的名字
	 * 
	 * @return
	 */
	public String getLogName() {
		return logName;
	}

	/**
	 * 设置日志文件逻辑名称显示在日志文件的名字
	 * 
	 * @param logName
	 * @return
	 */
	public SdDatabase setLogName(String logName) {
		this.logName = logName;
		return this;
	}

	/**
	 * 获取日志文件存放的路径
	 * 
	 * @return
	 */
	public String getLogFilename() {
		return logFilename;
	}

	/**
	 * 设置日志文件存放的路径
	 * 
	 * @param logFilename
	 * @return
	 */
	public SdDatabase setLogFilename(String logFilename) {
		this.logFilename = logFilename;
		return this;
	}

	/**
	 * 获取日志文件的大小比如=5 就代表5mb
	 * 
	 * @return
	 */
	public String getLogSize() {
		return logSize;
	}

	/**
	 * 设置日志文件的大小比如=5 就代表5mb
	 * 
	 * @param logSize
	 * @return
	 */
	public SdDatabase setLogSize(String logSize) {
		this.logSize = logSize;
		return this;
	}

	/**
	 * 获取日志文件的大小增长按百分比还是按指定在都可以,比如=10%/=5则代表按10%增长/5mb增长
	 * 
	 * @return
	 */
	public String getLogFilegrowth() {
		return logFilegrowth;
	}

	/**
	 * 设置日志文件的大小增长按百分比还是按指定在都可以,比如=10%/=5则代表按10%增长/5mb增长
	 * 
	 * @param logFilegrowth
	 * @return
	 */
	public SdDatabase setLogFilegrowth(String logFilegrowth) {
		this.logFilegrowth = logFilegrowth;
		return this;
	}

	/**
	 * 获取日志文件最大值
	 * 
	 * @return
	 */
	public String getLogMaxsize() {
		return logMaxsize;
	}

	/**
	 * 设置日志文件最大值
	 * 
	 * @param logMaxsize
	 * @return
	 */
	public SdDatabase setLogMaxsize(String logMaxsize) {
		this.logMaxsize = logMaxsize;
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
	public SdDatabase addExtension(String key, Object value) {
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
	public SdDatabase setExtensions(Map<String, Object> extensions) {
		this.extensions = extensions;
		return this;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("SdDatabase: \n");
		sb.append("  ┣━database = " + database + "\n");
		sb.append("  ┣━newDatabase = " + newDatabase + "\n");
		sb.append("  ┣━userName = " + userName + "\n");
		sb.append("  ┣━template = " + template + "\n");
		sb.append("  ┣━encoding = " + encoding + "\n");
		sb.append("  ┣━collate = " + collate + "\n");
		sb.append("  ┣━ctype = " + ctype + "\n");
		sb.append("  ┣━tablespaceName = " + tablespaceName + "\n");
		sb.append("  ┣━allowconn = " + allowconn + "\n");
		sb.append("  ┣━connlimit = " + connlimit + "\n");
		sb.append("  ┣━istemplate = " + istemplate + "\n");
		sb.append("  ┣━dbName = " + dbName + "\n");
		sb.append("  ┣━dbFilename = " + dbFilename + "\n");
		sb.append("  ┣━dbSize = " + dbSize + "\n");
		sb.append("  ┣━dbFilegrowth = " + dbFilegrowth + "\n");
		sb.append("  ┣━dbMaxsize = " + dbMaxsize + "\n");
		sb.append("  ┣━logName = " + logName + "\n");
		sb.append("  ┣━logFilename = " + logFilename + "\n");
		sb.append("  ┣━logSize = " + logSize + "\n");
		sb.append("  ┣━logFilegrowth = " + logFilegrowth + "\n");
		sb.append("  ┣━logMaxsize = " + logMaxsize + "\n");
		sb.append("  ┗━extensions = " + extensions + "\n");
		return sb.toString();
	}

}
