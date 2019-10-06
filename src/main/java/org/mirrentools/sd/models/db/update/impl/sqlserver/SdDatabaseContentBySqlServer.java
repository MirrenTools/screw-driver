package org.mirrentools.sd.models.db.update.impl.sqlserver;

import org.mirrentools.sd.models.SdDatabase;
import org.mirrentools.sd.models.db.update.SdAbstractDatabaseContent;

/**
 * SQL Server数据库的数据库属性
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public class SdDatabaseContentBySqlServer extends SdAbstractDatabaseContent {
	/** 新的数据库名称 */
	private String newDatabaseName;
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

	public SdDatabaseContentBySqlServer(String databaseName) {
		super(databaseName);
	}

	public SdDatabaseContentBySqlServer(SdDatabase database) {
		super(database.getDatabase());
		this.newDatabaseName = database.getNewDatabase();
		this.dbName = database.getDbName();
		this.dbFilename = database.getDbFilename();
		this.dbSize = database.getDbSize();
		this.dbFilegrowth = database.getDbFilegrowth();
		this.dbMaxsize = database.getDbMaxsize();
		this.logName = database.getLogName();
		this.logFilename = database.getLogFilename();
		this.logSize = database.getLogSize();
		this.logFilegrowth = database.getLogFilegrowth();
		this.logMaxsize = database.getLogMaxsize();
	}

	@Override
	public String createSQL() {
		StringBuilder result = new StringBuilder();
		result.append(" CREATE DATABASE ");
		result.append(getDatabaseName());
		result.append(" ON ( ");
		result.append(" name = " + getDbName() + ",");
		result.append(" filename = " + getDbFilename());
		if (getDbSize() != null) {
			result.append(",");
			result.append(" size = " + getDbSize());
		}
		if (getDbFilegrowth() != null) {
			result.append(",");
			result.append(" filegrowth = " + getDbFilegrowth());
		}
		if (getDbMaxsize() != null) {
			result.append(",");
			result.append(" maxsize = " + getDbMaxsize());
		}
		result.append(" ) ");

		result.append("LOG ON (");
		result.append(" name = " + getLogName() + ",");
		result.append(" filename = " + getLogFilename());
		if (getLogSize() != null) {
			result.append(",");
			result.append(" size = " + getLogSize());
		}
		if (getLogFilegrowth() != null) {
			result.append(",");
			result.append(" filegrowth = " + getLogFilegrowth());
		}
		if (getLogMaxsize() != null) {
			result.append(",");
			result.append(" maxsize = " + getLogMaxsize());
		}
		result.append(" ) ");
		return result.toString();
	}

	@Override
	public String updateSQL() throws UnsupportedOperationException {
		throw new UnsupportedOperationException("该方法未实现");
	}

	@Override
	public String deleteSQL() {
		return "DROP DATABASE IF EXISTS " + getDatabaseName();
	}

	/**
	 * 获取数据库的新名称
	 * 
	 * @return
	 */
	public String getNewDatabaseName() {
		return newDatabaseName;
	}

	/**
	 * 设置数据库的新名称
	 * 
	 * @param newDatabaseName
	 * @return
	 */
	public SdDatabaseContentBySqlServer setNewDatabaseName(String newDatabaseName) {
		this.newDatabaseName = newDatabaseName;
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
	public SdDatabaseContentBySqlServer setDbName(String dbName) {
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
	public SdDatabaseContentBySqlServer setDbFilename(String dbFilename) {
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
	public SdDatabaseContentBySqlServer setDbSize(String dbSize) {
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
	public SdDatabaseContentBySqlServer setDbFilegrowth(String dbFilegrowth) {
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
	public SdDatabaseContentBySqlServer setDbMaxsize(String dbMaxsize) {
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
	public SdDatabaseContentBySqlServer setLogName(String logName) {
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
	public SdDatabaseContentBySqlServer setLogFilename(String logFilename) {
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
	public SdDatabaseContentBySqlServer setLogSize(String logSize) {
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
	public SdDatabaseContentBySqlServer setLogFilegrowth(String logFilegrowth) {
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
	public SdDatabaseContentBySqlServer setLogMaxsize(String logMaxsize) {
		this.logMaxsize = logMaxsize;
		return this;
	}

	@Override
	public String toString() {
		return "SdDatabaseContentBySqlServer [newDatabaseName=" + newDatabaseName + ", dbName=" + dbName + ", dbFilename=" + dbFilename + ", dbSize=" + dbSize + ", dbFilegrowth=" + dbFilegrowth
				+ ", dbMaxsize=" + dbMaxsize + ", logName=" + logName + ", logFilename=" + logFilename + ", logSize=" + logSize + ", logFilegrowth=" + logFilegrowth + ", logMaxsize=" + logMaxsize + "]";
	}

}
