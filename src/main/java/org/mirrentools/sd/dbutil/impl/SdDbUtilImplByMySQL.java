package org.mirrentools.sd.dbutil.impl;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.List;

import org.mirrentools.sd.dbutil.AbstractSdDbUtil;
import org.mirrentools.sd.models.db.query.SdTableAttribute;
import org.mirrentools.sd.models.db.query.SdTableColumnAttribute;
import org.mirrentools.sd.models.db.query.SdTablePrimaryKeyAttribute;
import org.mirrentools.sd.models.db.update.SdAbstractTableContent;
import org.mirrentools.sd.options.SdDatabaseOptions;

/**
 * 数据库操作相关的工具接口,MySQL的抽象实现,其他数据库或者不兼容可以重写该类
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public class SdDbUtilImplByMySQL extends AbstractSdDbUtil {
	/** 数据库配置文件 */
	private SdDatabaseOptions config;

	public SdDbUtilImplByMySQL(SdDatabaseOptions config) {
		super(config);
		this.config = config;
	}

	@Override
	public boolean existDatabase(String dbName) throws Exception {
		int result = 0;
		Connection connection = getConnection();
		ResultSet query = null;
		try {
			query = connection.createStatement().executeQuery(String.format("SELECT COUNT(*) FROM information_schema.schemata WHERE schema_name='%s'", dbName));
			if (query.next()) {
				result = query.getInt(1);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (query != null) {
				query.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
		return result == 1;
	}

	@Override
	public boolean existTable(String tableName) throws Exception {
		Connection connection = getConnection();
		ResultSet query = null;
		try {
			DatabaseMetaData md = connection.getMetaData();
			query = md.getTables(connection.getCatalog(), config.getUser(), tableName, new String[] { "TABLE" });
			return query.next();
		} catch (Exception e) {
			throw e;
		} finally {
			if (query != null) {
				query.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}

	@Override
	public boolean createTable(SdAbstractTableContent content) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateTable(SdAbstractTableContent content) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<String> getTableNames() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SdTableAttribute getTableAttribute(String tableName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SdTableColumnAttribute> getTableColumnsAttribute(String tableName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SdTablePrimaryKeyAttribute getTablePrimaryKeyAttribute(String tableName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 获取数据库配置文件
	 * 
	 * @return
	 */
	public SdDatabaseOptions getConfig() {
		return config;
	}

	/**
	 * 设置数据库配置文件
	 * 
	 * @param config
	 * @return
	 */
	public SdDbUtilImplByMySQL setConfig(SdDatabaseOptions config) {
		this.config = config;
		return this;
	}

	@Override
	public String toString() {
		return "JsgDbExecuteImplByMySQL [config=" + config + "]";
	}

}
