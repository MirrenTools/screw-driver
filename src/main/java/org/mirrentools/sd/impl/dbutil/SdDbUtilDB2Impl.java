package org.mirrentools.sd.impl.dbutil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.logging.Logger;

import org.mirrentools.sd.models.db.query.SdTableAttribute;
import org.mirrentools.sd.models.db.update.SdAbstractDatabaseContent;
import org.mirrentools.sd.options.SdDatabaseOptions;

public class SdDbUtilDB2Impl  extends SdAbstractDbUtil {
	private final Logger LOG = Logger.getLogger(this.getClass().getName());

	/**
	 * 初始化
	 * 
	 * @param options
	 */
	public SdDbUtilDB2Impl(SdDatabaseOptions options) {
		super(options);
	}

	@Override
	public boolean createDatabase(SdAbstractDatabaseContent content) throws Exception {
		super.createDatabase(getBaseUrlConfig(), content);
		return true;
	}

	@Override
	public boolean existDatabase(String dbName) throws Exception {
		return existDatabase(getBaseUrlConfig(), dbName);
	}

	@Override
	public boolean existDatabase(SdDatabaseOptions config, String dbName) throws Exception {
		Connection connection = null;
		ResultSet rs = null;
		try {
			connection = getConnection(config);
			String sql = String.format("select count(*) from pg_database where datname='%s'", dbName);
			LOG.info("执行SQL语句:\n" + sql);
			ResultSet res = connection.createStatement().executeQuery(sql);
			res.next();
			int result = res.getInt(1);
			try {
				res.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result == 1 ? true : false;
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}

	@Override
	public SdTableAttribute getTableAttribute(String tableName) throws Exception {
		Connection connection = null;
		ResultSet rs = null;
		try {
			connection = getConnection();
			SdTableAttribute result = null;
			String sql = String.format("select relname as name,cast(obj_description(relfilenode,'pg_class') as varchar) as remarks from pg_class where relname ='%s'", tableName);
			LOG.info("执行SQL语句:\n" + sql);
			ResultSet res = connection.createStatement().executeQuery(sql);
			if (res.next()) {
				result = new SdTableAttribute();
				result.setTableName(res.getString("name"));
				result.setRemarks(res.getString("remarks"));
				try {
					res.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return result;
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}


}
