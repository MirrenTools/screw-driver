package org.mirrentools.sd.impl.dbutil;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

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

}
