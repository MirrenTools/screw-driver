package org.mirrentools.sd.dbutil.impl;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.mirrentools.sd.dbutil.AbstractSdDbUtil;
import org.mirrentools.sd.models.db.query.SdTableAttribute;
import org.mirrentools.sd.models.db.query.SdTableColumnAttribute;
import org.mirrentools.sd.models.db.query.SdTablePrimaryKeyAttribute;
import org.mirrentools.sd.options.SdDatabaseOptions;

/**
 * 数据库操作相关的工具接口,MySQL的抽象实现,其他数据库或者不兼容可以重写该类
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public class SdDbUtilImplByMySQL extends AbstractSdDbUtil {

	/** JUL日志 */
	private final Logger LOG = Logger.getLogger(this.getClass().getName());

	/**
	 * 初始化
	 * 
	 * @param config
	 */
	public SdDbUtilImplByMySQL(SdDatabaseOptions config) {
		super(config);
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
	public boolean existTable(String tableName) throws Exception {
		Connection connection = getConnection();
		ResultSet query = null;
		try {
			DatabaseMetaData md = connection.getMetaData();
			query = md.getTables(connection.getCatalog(), getConfig().getUser(), tableName, new String[] { "TABLE" });
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
	public List<String> getTableNames() throws Exception {
		List<String> result = new ArrayList<String>();
		Connection connection = getConnection();
		ResultSet rs = null;
		try {
			DatabaseMetaData md = connection.getMetaData();
			String[] types = { "TABLE", "VIEW" };
			rs = md.getTables(null, getConfig().getUser().toUpperCase(), null, types);
			while (rs.next()) {
				result.add(rs.getString(3));
			}
			return result;
		} catch (Exception e) {
			throw e;
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
		return null;
	}

	@Override
	public List<SdTableColumnAttribute> getTableColumnsAttribute(String tableName) throws Exception {
		Connection conn = getConnection();
		DatabaseMetaData md = conn.getMetaData();
		ResultSet rs = md.getColumns(null, null, tableName, null);
		Map<String, SdTableColumnAttribute> columnMap = new HashMap<String, SdTableColumnAttribute>();
		while (rs.next()) {
			SdTableColumnAttribute attr = new SdTableColumnAttribute();
			// TODO 实现获取列属性
			// attr.setTdColumnName(rs.getString("COLUMN_NAME"));
			// attr.setTdJdbcType(rs.getString("TYPE_NAME"));
			// attr.setTdJavaType(JavaType.jdbcTypeToJavaType(rs.getString("TYPE_NAME")));
			//
			// attr.setColumnDef(rs.getString("COLUMN_DEF"));
			// attr.setRemarks(rs.getString("REMARKS"));
			// attr.setColumnSize(rs.getInt("COLUMN_SIZE"));
			// attr.setDecimalDigits(rs.getInt("DECIMAL_DIGITS"));
			// attr.setOrdinalPosition(rs.getInt("ORDINAL_POSITION"));
			// attr.setNullable(rs.getInt("NULLABLE") == 1 ? true : false);
			// columnMap.put(rs.getString("COLUMN_NAME"), attr);
		}
		if (columnMap.size() == 0) {
			throw new NullPointerException("从表中获取字段失败!获取不到任何字段!");
		}
		ArrayList<SdTableColumnAttribute> result = new ArrayList<SdTableColumnAttribute>(columnMap.values());
		Collections.sort(result);
		return result;
	}

	@Override
	public SdTablePrimaryKeyAttribute getTablePrimaryKeyAttribute(String tableName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SdDbUtilImplByMySQL setConfig(SdDatabaseOptions config) {
		super.setConfig(config);
		return this;
	}

}
