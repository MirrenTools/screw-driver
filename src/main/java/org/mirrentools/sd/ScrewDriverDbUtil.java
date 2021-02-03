package org.mirrentools.sd;

import java.sql.Connection;
import java.util.List;

import org.mirrentools.sd.impl.dbutil.SdDbUtilDB2Impl;
import org.mirrentools.sd.impl.dbutil.SdDbUtilMySqlImpl;
import org.mirrentools.sd.impl.dbutil.SdDbUtilOracleImpl;
import org.mirrentools.sd.impl.dbutil.SdDbUtilPostgreSqlImpl;
import org.mirrentools.sd.impl.dbutil.SdDbUtilSqlServerImpl;
import org.mirrentools.sd.impl.dbutil.SdDbUtilSqliteImpl;
import org.mirrentools.sd.models.db.query.SdTable;
import org.mirrentools.sd.models.db.query.SdTableAttribute;
import org.mirrentools.sd.models.db.query.SdTableColumnAttribute;
import org.mirrentools.sd.models.db.query.SdTableIndexKeyAttribute;
import org.mirrentools.sd.models.db.query.SdTablePortedKeysAttribute;
import org.mirrentools.sd.models.db.query.SdTablePrimaryKeyAttribute;
import org.mirrentools.sd.models.db.update.SdAbstractDatabaseContent;
import org.mirrentools.sd.models.db.update.SdAbstractTableContent;
import org.mirrentools.sd.options.SdDatabaseOptions;

/**
 * ScrewDriver数据库操作相关的工具接口,该工具用户创建/读取:库、表、属性等
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public abstract class ScrewDriverDbUtil {
	/**
	 * 根据配置文件实例化ScrewDriverDbUtil
	 * 
	 * @param databaseOptions
	 * @return
	 */
	public static ScrewDriverDbUtil instance(SdDatabaseOptions databaseOptions) {
		String groupId = databaseOptions.getDriverClass();
		if (groupId.contains("mysql")) {
			return new SdDbUtilMySqlImpl(databaseOptions);
		} else if (groupId.contains("postgresql")) {
			return new SdDbUtilPostgreSqlImpl(databaseOptions);
		} else if (groupId.contains("db2")) {
			return new SdDbUtilDB2Impl(databaseOptions);
		} else if (groupId.contains("oracle")) {
			return new SdDbUtilOracleImpl(databaseOptions);
		} else if (groupId.contains("sqlserver")) {
			return new SdDbUtilSqlServerImpl(databaseOptions);
		} else if (groupId.contains("sqlite")) {
			return new SdDbUtilSqliteImpl(databaseOptions);
		} else {
			throw new ScrewDriverException(
					"Unable to recognize database types through DriverClass,You can extends the SdAbstractDbUtil class and init it");
		}
	}

	/**
	 * 获取数据库连接
	 * 
	 * @param config
	 * @return
	 */
	public abstract Connection getConnection() throws Exception;

	/**
	 * 获取数据库连接
	 * 
	 * @param config
	 * @return
	 */
	public abstract Connection getConnection(SdDatabaseOptions config) throws Exception;
	
	/**
	 * 执行SQL
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public abstract boolean execute(String sql) throws Exception;
	
	/**
	 * 数据库是否存在
	 * 
	 * @param dbName
	 *          数据库名称
	 * @return
	 * @throws Exception
	 */
	public abstract boolean existDatabase(String dbName) throws Exception;

	/**
	 * 数据库是否存在
	 * 
	 * @param config
	 *          数据库连接信息
	 * @param dbName
	 *          数据库名称
	 * @return
	 * @throws Exception
	 */
	public abstract boolean existDatabase(SdDatabaseOptions config, String dbName) throws Exception;

	/**
	 * 数据库表是否存在
	 * 
	 * @return
	 * @throws Exception
	 */
	public abstract boolean existTable(String tableName) throws Exception;

	/**
	 * 创建数据库
	 * 
	 * @param content
	 *          数据库创建的内容
	 * @return
	 * @throws Exception
	 */
	public abstract boolean createDatabase(SdAbstractDatabaseContent content) throws Exception;

	/**
	 * 创建数据库
	 * 
	 * @param config
	 *          数据库连接信息
	 * @param content
	 *          数据库创建的内容
	 * @return
	 * @throws Exception
	 */
	public abstract boolean createDatabase(SdDatabaseOptions config, SdAbstractDatabaseContent content) throws Exception;

	/**
	 * 创建数据库
	 * 
	 * @param sql
	 *          数据库创建的语句
	 * @return
	 * @throws Exception
	 */
	public abstract boolean createDatabase(String sql) throws Exception;

	/**
	 * 创建数据库
	 * 
	 * @param config
	 *          数据库连接信息
	 * @param sql
	 *          数据库创建的SQL
	 * @return
	 * @throws Exception
	 */
	public abstract boolean createDatabase(SdDatabaseOptions config, String sql) throws Exception;

	/**
	 * 修改数据库
	 * 
	 * @param content
	 *          数据库修改的内容
	 * @return
	 * @throws Exception
	 */
	public abstract boolean updateDatabase(SdAbstractDatabaseContent content) throws Exception;

	/**
	 * 修改数据库
	 * 
	 * @param config
	 *          数据库连接信息
	 * @param content
	 *          数据库修改的内容
	 * @return
	 * @throws Exception
	 */
	public abstract boolean updateDatabase(SdDatabaseOptions config, SdAbstractDatabaseContent content) throws Exception;

	/**
	 * 修改数据库
	 * 
	 * @param sql
	 *          修改数据库的语句
	 * @return
	 * @throws Exception
	 */
	public abstract boolean updateDatabase(String sql) throws Exception;

	/**
	 * 修改数据库
	 * 
	 * @param config
	 *          数据库连接信息
	 * @param sql
	 *          数据库修改的SQL
	 * @return
	 * @throws Exception
	 */
	public abstract boolean updateDatabase(SdDatabaseOptions config, String sql) throws Exception;

	/**
	 * 创建一张表
	 * 
	 * @param content
	 * @return
	 * @throws Exception
	 */
	public abstract boolean createTable(SdAbstractTableContent content) throws Exception;
	
	/**
	 * 创建一张表
	 * 
	 * @param sql
	 *          创建表的语句
	 * @return
	 * @throws Exception
	 */
	public abstract boolean createTable(String sql) throws Exception;

	/**
	 * 修改一张表
	 * 
	 * @param content
	 * @return
	 * @throws Exception
	 */
	public abstract boolean updateTable(SdAbstractTableContent content) throws Exception;

	/**
	 * 修改一张表
	 * 
	 * @param sql
	 *          修改表的SQL语句
	 * @return
	 * @throws Exception
	 */
	public abstract boolean updateTable(String sql) throws Exception;

	/**
	 * 删除一张表
	 * 
	 * @param content
	 * @return
	 * @throws Exception
	 */
	public abstract boolean deleteTable(SdAbstractTableContent content) throws Exception;

	/**
	 * 删除一张表
	 * 
	 * @param sql
	 *          删除表的语句
	 * @return
	 * @throws Exception
	 */
	public abstract boolean deleteTable(String sql) throws Exception;

	/**
	 * 获取数据库中指定表的描述
	 * 
	 * @param tableName
	 * @return
	 * @throws Exception
	 */
	public abstract SdTable getSdTable(String tableName) throws Exception;

	/**
	 * 获取数据库中指定表的描述
	 * 
	 * @param tableName
	 *          表的名字
	 * @param unique 
	 * 				when true, return only indices for unique values;
	 * 				when false, return indices regardless of whether unique or not (get index info)
	 * @param approximate  
	 * 				when true, result is allowed to reflect approximateor out of data values; 
	 * 				when false, results are requested to beaccurate (get index info )
	 * @return
	 * @throws Exception
	 */
	public abstract SdTable getSdTable(String tableName, boolean unique, boolean approximate) throws Exception;

	/**
	 * 获取当前数据库所有数据库表名,如果不存在返回长度为0的集合
	 * 
	 * @return
	 * @throws Exception
	 */
	public abstract List<String> getTableNames() throws Exception;

	/**
	 * 获取指定数据库,指定表的属性,如果不存在返回null
	 * 
	 * @param config
	 * @param tableName
	 * @return
	 * @throws Exception
	 */
	public abstract SdTableAttribute getTableAttribute(String tableName) throws Exception;

	/**
	 * 获取当前数据库中指定表的所有属性,如果不存在抛出异常
	 * 
	 * @param tableName
	 * @return
	 * @throws Exception
	 */
	public abstract List<SdTableColumnAttribute> getTableColumnsAttribute(String tableName) throws Exception;

	/**
	 * 获取指定表的主键属性,如果不存在返回null
	 * 
	 * @param tableName
	 * @return
	 * @throws Exception
	 */
	public abstract SdTablePrimaryKeyAttribute getTablePrimaryKeyAttribute(String tableName) throws Exception;

	/**
	 * 获取指定表的索引属性,如果不存在返回长度为0的集合
	 * 
	 * @param tableName
	 * @param unique
	 *          when true, return only indices for unique values;
	 *          when false, return indices regardless of whether unique or not
	 * @param approximate
	 *          when true, result is allowed to reflect approximateor out of data values; 
	 *          when false, results are requested to beaccurate
	 * @return
	 * @throws Exception
	 */
	public abstract List<SdTableIndexKeyAttribute> getTableIndexKeysAttribute(String tableName, boolean unique, boolean approximate)
			throws Exception;

	/**
	 * 获取指定表的外键索引属性,如果不存在返回长度为0的集合
	 * 
	 * @param tableName
	 * @return
	 * @throws Exception
	 */
	public abstract List<SdTablePortedKeysAttribute> getTableExportedKeysAttribute(String tableName) throws Exception;

	/**
	 * 获取指定表的主键索引属性,如果不存在返回长度为0的集合
	 * 
	 * @param tableName
	 * @return
	 * @throws Exception
	 */
	public abstract List<SdTablePortedKeysAttribute> getTableImportedKeysAttribute(String tableName) throws Exception;

}
