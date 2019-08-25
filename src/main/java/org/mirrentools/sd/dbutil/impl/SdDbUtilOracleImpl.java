package org.mirrentools.sd.dbutil.impl;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mirrentools.sd.dbutil.SdAbstractDbUtil;
import org.mirrentools.sd.models.db.query.SdTableAttribute;
import org.mirrentools.sd.options.SdDatabaseOptions;

/**
 * 数据库操作相关的工具接口,Oracle的抽象实现,其他数据库或者不兼容可以重写该类
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class SdDbUtilOracleImpl extends SdAbstractDbUtil {

	// private final Logger LOG = Logger.getLogger(this.getClass().getName());

	/**
	 * 初始化
	 * 
	 * @param options
	 */
	public SdDbUtilOracleImpl(SdDatabaseOptions options) {
		super(options);
	}

	@Override
	public boolean existDatabase(SdDatabaseOptions config, String dbName) throws Exception {
		return false;
	}

	@Override
	public SdTableAttribute getTableAttribute(String tableName) throws Exception {

		Connection connection = null;
		ResultSet rs = null;
		try {
			connection = getConnection();
			DatabaseMetaData md = connection.getMetaData();
			String catalog = connection.getCatalog() == null ? null : connection.getCatalog();
			String[] types = { "TABLE", "VIEW" };
			rs = md.getTables(catalog, null, tableName.toUpperCase(), types);
			SdTableAttribute result = null;
			if (rs.next()) {
				result = new SdTableAttribute();
				converterTableAttribute(rs, result);
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
	public void converterTableAttribute(ResultSet rs, SdTableAttribute result) throws SQLException {
		result.setTableCat(rs.getString("TABLE_CAT"));
		result.setTableSchem(rs.getString("TABLE_SCHEM"));
		result.setTableName(rs.getString("TABLE_NAME"));
		result.setTableType(rs.getString("TABLE_TYPE"));
		result.setRemarks(rs.getString("REMARKS"));
		result.setTypeCat("TYPE_CAT");
	}

}
