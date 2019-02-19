package org.mirrentools.sd.dbutil.impl;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.mirrentools.sd.dbutil.SdAbstractDbUtil;
import org.mirrentools.sd.models.db.query.SdTableAttribute;
import org.mirrentools.sd.models.db.query.SdTableIndexKeyAttribute;
import org.mirrentools.sd.options.SdDatabaseOptions;

/**
 * 数据库操作相关的工具接口,MySQL的抽象实现,其他数据库或者不兼容可以重写该类
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public class SdDbUtilImplByMySQL extends SdAbstractDbUtil {

	/** JUL日志 */
	private final Logger LOG = Logger.getLogger(this.getClass().getName());

	/**
	 * 初始化
	 * 
	 * @param config
	 */
	public SdDbUtilImplByMySQL(SdDatabaseOptions options) {
		super(options);
	}

	@Override
	public boolean existDatabase(String dbName) throws Exception {
		int result = 0;
		Connection connection = getConnection();
		ResultSet query = null;
		String sql = String.format("SELECT COUNT(*) FROM information_schema.schemata WHERE schema_name='%s'", dbName);
		try {
			query = connection.createStatement().executeQuery(sql);
			if (query.next()) {
				result = query.getInt(1);
			}
		} catch (Exception e) {
			LOG.info("执行SQL语句:\n" + sql);
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
	public SdTableAttribute getTableAttribute(String tableName) throws Exception {
		Connection connection = null;
		ResultSet rs = null;
		try {
			connection = getConnection();
			DatabaseMetaData md = connection.getMetaData();
			String catalog = connection.getCatalog() == null ? null : connection.getCatalog();
			String[] types = {"TABLE", "VIEW"};
			rs = md.getTables(catalog, null, tableName, types);
			SdTableAttribute result = null;
			if (rs.next()) {
				result = new SdTableAttribute();
				converterTableAttribute(rs, result);
				// 查询表的注释
				ResultSet comment = connection.createStatement()
						.executeQuery(String.format("SELECT TABLE_NAME,TABLE_COMMENT FROM information_schema.TABLES WHERE TABLE_NAME='%s'", tableName));
				if (comment.next()) {
					result.setRemarks(comment.getString(2));
					try {
						comment.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
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

	@Override
	public List<SdTableIndexKeyAttribute> getTableIndexKeysAttribute(String tableName, boolean unique, boolean approximate) throws Exception {
		Connection connection = null;
		ResultSet rs = null;
		try {
			connection = getConnection();
			rs = connection.createStatement().executeQuery("SHOW INDEX FROM " + tableName);
			List<SdTableIndexKeyAttribute> result = new ArrayList<SdTableIndexKeyAttribute>();
			while (rs.next()) {
				SdTableIndexKeyAttribute attr = new SdTableIndexKeyAttribute();
				attr.setTableName(rs.getString("Table"));
				attr.setColumnName(rs.getString("Column_name"));
				attr.setNonUnique(rs.getInt("Non_unique") == 1);
				attr.setIndexName(rs.getString("Key_name"));
				attr.setAscOrDesc(rs.getString("Collation"));
				attr.setCardinality(rs.getInt("Cardinality"));
				attr.setIndexRemarks(rs.getString("Index_comment"));
				result.add(attr);
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

	@Override
	public SdDbUtilImplByMySQL setConfig(SdDatabaseOptions config) {
		super.setConfig(config);
		return this;
	}

}
