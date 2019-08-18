package org.mirrentools.sd.dbutil.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.logging.Logger;

import org.mirrentools.sd.dbutil.SdAbstractDbUtil;
import org.mirrentools.sd.models.db.query.SdTableAttribute;
import org.mirrentools.sd.models.db.update.SdAbstractDatabaseContent;
import org.mirrentools.sd.options.SdDatabaseOptions;

/**
 * 数据库操作相关的工具接口,PostgreSql的抽象实现,其他数据库或者不兼容可以重写该类
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class SdDbUtilPostgreSqlImpl extends SdAbstractDbUtil {

	private final Logger LOG = Logger.getLogger(this.getClass().getName());

	/**
	 * 初始化
	 * 
	 * @param options
	 */
	public SdDbUtilPostgreSqlImpl(SdDatabaseOptions options) {
		super(options);
	}

	@Override
	public boolean createDatabase(SdAbstractDatabaseContent content) throws Exception {
		super.createDatabase(content);
		return true;
	}

	@Override
	public boolean existDatabase(String dbName) throws Exception {
		Connection connection = null;
		ResultSet rs = null;
		try {
			connection = getConnection();
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
