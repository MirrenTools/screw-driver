package org.mirrentools.sd.dbutil;

import java.sql.Connection;
import java.util.List;

import org.mirrentools.sd.models.db.query.SdTableAttribute;
import org.mirrentools.sd.models.db.query.SdTableColumnAttribute;
import org.mirrentools.sd.models.db.query.SdTablePrimaryKeyAttribute;
import org.mirrentools.sd.models.db.update.SdAbstractDatabaseContent;
import org.mirrentools.sd.models.db.update.SdAbstractTableContent;
import org.mirrentools.sd.options.SdDatabaseOptions;

/**
 * 数据库操作相关的工具接口,该工具用户创建/读取:库.表.属性等
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public interface SdDbUtil {
	/**
	 * 获取数据库连接
	 * 
	 * @param config
	 * @return
	 */
	Connection getConnection() throws Exception;

	/**
	 * 获取数据库连接
	 * 
	 * @param config
	 * @return
	 */
	Connection getConnection(SdDatabaseOptions config) throws Exception;

	/**
	 * 数据库是否存在
	 * 
	 * @return
	 * @throws Exception
	 */
	boolean existDatabase(String dbName) throws Exception;

	/**
	 * 数据库表是否存在
	 * 
	 * @return
	 * @throws Exception
	 */
	boolean existTable(String tableName) throws Exception;

	/**
	 * 创建数据库
	 * 
	 * @param content
	 * @return
	 * @throws Exception
	 */
	boolean createDatabase(SdAbstractDatabaseContent content) throws Exception;

	/**
	 * 修改数据库
	 * 
	 * @param content
	 * @return
	 * @throws Exception
	 */
	boolean updateDatabase(SdAbstractDatabaseContent content) throws Exception;

	/**
	 * 创建一张表
	 * 
	 * @param content
	 * @return
	 * @throws Exception
	 */
	boolean createTable(SdAbstractTableContent content) throws Exception;

	/**
	 * 修改一张表
	 * 
	 * @param content
	 * @return
	 * @throws Exception
	 */
	boolean updateTable(SdAbstractTableContent content) throws Exception;
	/**
	 * 删除一张表
	 * 
	 * @param content
	 * @return
	 * @throws Exception
	 */
	boolean deleteTable(SdAbstractTableContent content) throws Exception;

	/**
	 * 获取当前数据库所有数据库表名
	 * 
	 * @return
	 * @throws Exception
	 */
	List<String> getTableNames() throws Exception;

	/**
	 * 获取指定数据库,指定表的属性
	 * 
	 * @param config
	 * @param tableName
	 * @return
	 * @throws Exception
	 */
	SdTableAttribute getTableAttribute(String tableName) throws Exception;

	/**
	 * 获取当前数据库中指定表的所有属性
	 * 
	 * @param tableName
	 * @return
	 * @throws Exception
	 */
	List<SdTableColumnAttribute> getTableColumnsAttribute(String tableName) throws Exception;

	/**
	 * 获取指定表的主键属性
	 * 
	 * @param tableName
	 * @return
	 * @throws Exception
	 */
	SdTablePrimaryKeyAttribute getTablePrimaryKeyAttribute(String tableName) throws Exception;

}
