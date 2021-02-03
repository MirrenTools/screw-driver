package org.mirrentools.sd.impl.dbutil;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.mirrentools.sd.ScrewDriverDbUtil;
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
 * 数据库操作相关的工具接口的抽象类,默认大部分以MySQL为基准的实现,<br>
 * 如果其他数据库或不兼容可以继承该类并重写相应的方法
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public abstract class SdAbstractDbUtil extends ScrewDriverDbUtil {
	/** JUL日志 */
	private final Logger LOG = Logger.getLogger(this.getClass().getName());

	/** 数据库配置 */
	private SdDatabaseOptions config;

	/**
	 * 初始化一个默认的数据库管理实现类
	 */
	public SdAbstractDbUtil(SdDatabaseOptions config) {
		super();
		this.config = config;
	}

	/**
	 * 获取根连接的配置文件
	 * 
	 * @return
	 */
	public SdDatabaseOptions getBaseUrlConfig() {
		String[] split = getConfig().getUrl().split("\\?");
		String prefix = split[0].substring(0, split[0].lastIndexOf("/") + 1);
		StringBuilder url = new StringBuilder();
		url.append(prefix);
		if (split.length > 1) {
			url.append("?");
			url.append(split[1]);
		}
		SdDatabaseOptions options = new SdDatabaseOptions(getConfig().getDriverClass(), url.toString());
		options.setUser(getConfig().getUser());
		options.setPassword(getConfig().getPassword());
		return options;
	}

	@Override
	public Connection getConnection() throws Exception {
		return getConnection(config);
	}

	@Override
	public Connection getConnection(SdDatabaseOptions config) throws Exception {
		DriverManager.setLoginTimeout(config.getLoginTimeout());
		Class.forName(config.getDriverClass());
		return DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword());
	}

	@Override
	public boolean execute(String sql) throws Exception {
		Connection connection = getConnection();
		Statement statement = null;
		try {
			LOG.info("执行SQL语句:\n" + sql);
			statement = connection.createStatement();
			statement.execute(sql);
			return true;
		} catch (Exception e) {
			throw e;
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}

	@Override
	public boolean createDatabase(SdAbstractDatabaseContent content) throws Exception {
		return createDatabase(getConfig(), content);
	}

	@Override
	public boolean createDatabase(SdDatabaseOptions config, SdAbstractDatabaseContent content) throws Exception {
		return createDatabase(config, content.createSQL());
	}

	@Override
	public boolean createDatabase(String sql) throws Exception {
		return createDatabase(getConfig(), sql);
	}

	@Override
	public boolean createDatabase(SdDatabaseOptions config, String sql) throws Exception {
		int result = 0;
		Connection connection = getConnection(config);
		try {
			LOG.info("执行SQL语句:\n" + sql);
			result = connection.createStatement().executeUpdate(sql);
		} catch (Exception e) {
			throw e;
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
		return result == 1;
	}

	@Override
	public boolean updateDatabase(SdAbstractDatabaseContent content) throws Exception {
		return updateDatabase(getConfig(), content);
	}

	@Override
	public boolean updateDatabase(SdDatabaseOptions config, SdAbstractDatabaseContent content) throws Exception {
		return updateDatabase(getConfig(), content.updateSQL());
	}

	@Override
	public boolean updateDatabase(String sql) throws Exception {
		return updateDatabase(getConfig(), sql);
	}

	@Override
	public boolean updateDatabase(SdDatabaseOptions config, String sql) throws Exception {
		int result = 0;
		Connection connection = getConnection(config);
		Statement statement = null;
		try {
			LOG.info("执行SQL语句:\n" + sql);
			statement = connection.createStatement();
			result = statement.executeUpdate(sql);
		} catch (Exception e) {
			throw e;
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
		return result == 1;
	}

	@Override
	public boolean createTable(SdAbstractTableContent content) throws Exception {
		for (String sql : content.createSQL()) {
			createTable(sql);
		}
		LOG.info(String.format("Create table-->%s Successful", content.getTableName()));
		return true;
	}

	@Override
	public boolean createTable(String sql) throws Exception {
		Connection connection = getConnection();
		Statement statement = null;
		try {
			LOG.info("执行SQL语句:\n" + sql);
			statement = connection.createStatement();
			statement.execute(sql);
			return true;
		} catch (Exception e) {
			throw e;
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}

	}

	@Override
	public boolean updateTable(SdAbstractTableContent content) throws Exception {
		for (String sql : content.updateSQL()) {
			updateTable(sql);
		}
		LOG.info(String.format("Update table-->%s Successful", content.getTableName()));
		return true;
	}

	@Override
	public boolean updateTable(String sql) throws Exception {
		Connection connection = getConnection();
		Statement statement = null;
		try {
			LOG.info("执行SQL语句:\n" + sql);
			statement = connection.createStatement();
			statement.execute(sql);
			return true;
		} catch (Exception e) {
			throw e;
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}

	@Override
	public boolean deleteTable(SdAbstractTableContent content) throws Exception {
		deleteTable(content.deleteSQL());
		LOG.info(String.format("Delete table-->%s Successful", content.getTableName()));
		return true;
	}

	@Override
	public boolean deleteTable(String sql) throws Exception {
		Connection connection = getConnection();
		Statement statement = null;
		try {
			LOG.info("执行SQL语句:\n" + sql);
			statement = connection.createStatement();
			statement.execute(sql);
			return true;
		} catch (Exception e) {
			throw e;
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}

	@Override
	public boolean existDatabase(String dbName) throws Exception {
		return existDatabase(getConfig(), dbName);
	}

	@Override
	public boolean existTable(String tableName) throws Exception {
		Connection connection = getConnection();
		ResultSet query = null;
		try {
			DatabaseMetaData md = connection.getMetaData();
			String catalog = connection.getCatalog() == null ? null : connection.getCatalog();
			query = md.getTables(catalog, null, tableName, new String[]{"TABLE"});
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
	public SdTable getSdTable(String tableName) throws Exception {
		return getSdTable(tableName, true, true);
	}

	@Override
	public SdTable getSdTable(String tableName, boolean unique, boolean approximate) throws Exception {
		SdTable result = new SdTable();
		result.setInfo(getTableAttribute(tableName));
		result.setColumns(getTableColumnsAttribute(tableName));
		result.setPrimaryKey(getTablePrimaryKeyAttribute(tableName));
		result.setIndexKeys(getTableIndexKeysAttribute(tableName, unique, approximate));
		result.setForeignKeys(getTableImportedKeysAttribute(tableName));
		return result;
	}

	@Override
	public List<String> getTableNames() throws Exception {
		List<String> result = new ArrayList<String>();
		Connection connection = getConnection();
		ResultSet rs = null;
		try {
			DatabaseMetaData md = connection.getMetaData();
			String[] types = {"TABLE", "VIEW"};
			rs = md.getTables(null, null, null, types);
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
	public List<SdTableColumnAttribute> getTableColumnsAttribute(String tableName) throws Exception {
		Connection connection = null;
		ResultSet rs = null;
		try {
			connection = getConnection();
			DatabaseMetaData md = connection.getMetaData();
			String catalog = connection.getCatalog() == null ? null : connection.getCatalog();
			rs = md.getColumns(catalog, null, tableName, null);
			Map<String, SdTableColumnAttribute> columnMap = new LinkedHashMap<String, SdTableColumnAttribute>();
			while (rs.next()) {
				SdTableColumnAttribute attr = new SdTableColumnAttribute();
				converterColumnsAttribute(rs, attr);
				columnMap.put(rs.getString("COLUMN_NAME"), attr);
			}
			if (columnMap.size() == 0) {
				throw new NullPointerException("从表中获取字段失败!获取不到任何字段!");
			}
			ArrayList<SdTableColumnAttribute> result = new ArrayList<SdTableColumnAttribute>(columnMap.values());
			Collections.sort(result);
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
	public SdTablePrimaryKeyAttribute getTablePrimaryKeyAttribute(String tableName) throws Exception {
		Connection connection = null;
		ResultSet rs = null;
		try {
			connection = getConnection();
			DatabaseMetaData md = connection.getMetaData();
			String catalog = connection.getCatalog() == null ? null : connection.getCatalog();
			rs = md.getPrimaryKeys(catalog, null, tableName);
			SdTablePrimaryKeyAttribute result = null;
			if (rs.next()) {
				result = new SdTablePrimaryKeyAttribute();
				converterPrimaryKeyAttribute(rs, result);
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
			DatabaseMetaData md = connection.getMetaData();
			String catalog = connection.getCatalog() == null ? null : connection.getCatalog();
			rs = md.getIndexInfo(catalog, null, tableName, unique, approximate);
			List<SdTableIndexKeyAttribute> result = new ArrayList<SdTableIndexKeyAttribute>();
			while (rs.next()) {
				SdTableIndexKeyAttribute attr = new SdTableIndexKeyAttribute();
				converterIndexKeysAttribute(rs, attr);
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
	public List<SdTablePortedKeysAttribute> getTableExportedKeysAttribute(String tableName) throws Exception {
		Connection connection = null;
		ResultSet rs = null;
		try {
			connection = getConnection();
			DatabaseMetaData md = connection.getMetaData();
			String catalog = connection.getCatalog() == null ? null : connection.getCatalog();
			rs = md.getExportedKeys(catalog, null, tableName);
			List<SdTablePortedKeysAttribute> result = new ArrayList<SdTablePortedKeysAttribute>();
			while (rs.next()) {
				SdTablePortedKeysAttribute attr = new SdTablePortedKeysAttribute();
				converterPortedKeysAttribute(rs, attr);
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
	public List<SdTablePortedKeysAttribute> getTableImportedKeysAttribute(String tableName) throws Exception {
		Connection connection = null;
		ResultSet rs = null;
		try {
			connection = getConnection();
			DatabaseMetaData md = connection.getMetaData();
			String catalog = connection.getCatalog() == null ? null : connection.getCatalog();
			rs = md.getImportedKeys(catalog, null, tableName);
			List<SdTablePortedKeysAttribute> result = new ArrayList<SdTablePortedKeysAttribute>();
			while (rs.next()) {
				SdTablePortedKeysAttribute attr = new SdTablePortedKeysAttribute();
				converterPortedKeysAttribute(rs, attr);
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

	/**
	 * 将DatabaseMetaData.getTables转换为SdTableAttribute属性
	 * 
	 * @param rs
	 * @param result
	 * @throws SQLException
	 */
	public void converterTableAttribute(ResultSet rs, SdTableAttribute result) throws SQLException {
		result.setTableName(rs.getString("TABLE_NAME"));
		result.setRemarks(rs.getString("REMARKS"));
		try {
			result.setTableCat(rs.getString("TABLE_CAT"));
		} catch (Exception e1) {
		}
		try {
			result.setTableSchem(rs.getString("TABLE_SCHEM"));
		} catch (Exception e1) {
		}
		try {
			result.setTableType(rs.getString("TABLE_TYPE"));
		} catch (Exception e1) {
		}
		try {
			result.setTypeCat(rs.getString("TYPE_CAT"));
		} catch (Exception e) {
		}
		try {
			result.setTypeSchem(rs.getString("TYPE_SCHEM"));
		} catch (Exception e) {
		}
		try {
			result.setTypeName(rs.getString("TYPE_NAME"));
		} catch (Exception e) {
		}
		try {
			result.setSelfReferencingColName(rs.getString("SELF_REFERENCING_COL_NAME"));
		} catch (Exception e) {
		}
		try {
			result.setRefGeneration(rs.getString("REF_GENERATION"));
		} catch (Exception e) {
		}
	}

	/**
	 * 将DatabaseMetaData.getColumns转换为SdTableColumnAttribute属性
	 * 
	 * @param rs
	 * @param result
	 * @throws SQLException
	 */
	public void converterColumnsAttribute(ResultSet rs, SdTableColumnAttribute result) throws SQLException {
		// TABLE_CAT
		result.setTableCat(rs.getString(1));
		// TABLE_SCHEM
		result.setTableSchem(rs.getString(2));
		// TABLE_NAME
		result.setTableName(rs.getString(3));
		// COLUMN_NAME
		result.setColumnName(rs.getString(4));
		// DATA_TYPE
		result.setDataType(rs.getInt(5));
		// TYPE_NAME
		result.setTypeName(rs.getString(6));
		// COLUMN_SIZE
		result.setColumnSize(rs.getInt(7));
		// DECIMAL_DIGITS
		result.setDecimalDigits(rs.getInt(9));
		// NUM_PREC_RADIX
		result.setNumPrecRadix(rs.getInt(10));
		// NULLABLE
		result.setNullable(rs.getInt(11));
		// REMARKS
		result.setRemarks(rs.getString(12));
		// COLUMN_DEF
		result.setColumnDef(rs.getString(13));
		// CHAR_OCTET_LENGTH
		result.setCharOctetLength(rs.getInt(16));
		// ORDINAL_POSITION
		result.setOrdinalPosition(rs.getInt(17));
		// IS_NULLABLE
		result.setIsNullable(rs.getString(18));
		// SCOPE_CATLOG
		result.setScopeCatalog(rs.getString(19));
		// SCOPE_SCHEMA
		result.setScopeSchema(rs.getString(20));
		// SCOPE_TABLE
		result.setScopeTable(rs.getString(21));
		try {
			// SOURCE_DATA_TYPE
			result.setSourceDataType(rs.getShort(22));
		} catch (Exception e) {
			try {
				result.setSourceDataType(new Short(rs.getString(22)));
			} catch (NumberFormatException e1) {
			}
		}
		// IS_AUTOINCREMENT
		result.setAutoincrement(rs.getString(23));
		// IS_GENERATEDCOLUMN
		result.setGeneratedcolumn(rs.getString(24));
	}

	/**
	 * 转换主键属性
	 * 
	 * @param rs
	 * @param result
	 * @throws SQLException
	 */
	public void converterPrimaryKeyAttribute(ResultSet rs, SdTablePrimaryKeyAttribute result) throws SQLException {
		// TABLE_CAT String => table catalog (may be null)
		result.setTableCat(rs.getString(1));
		// 2.TABLE_SCHEM String => table schema (may be null)
		result.setTableSchem(rs.getString(2));
		// 3.TABLE_NAME String => table name
		result.setTableName(rs.getString(3));
		// 4.COLUMN_NAME String => column name
		result.setColumnName(rs.getString(4));
		// 5.KEY_SEQ short => sequence number within primary key( a valueof 1
		// represents the first column of the primary key, a value of 2
		// wouldrepresent the second column within the primary key).
		result.setKeySeq(rs.getString(5));
		// 6.PK_NAME String => primary key name (may be null)
		result.setPkName(rs.getString(6));
	}

	/**
	 * 将DatabaseMetaData.getColumns转换为SdTableIndexKeyAttribute属性
	 * 
	 * @param rs
	 * @param result
	 * @throws SQLException
	 */
	public void converterIndexKeysAttribute(ResultSet rs, SdTableIndexKeyAttribute result) throws SQLException {
		// 1.TABLE_CAT String => table catalog (may be null)
		result.setTableCat(rs.getString(1));
		// 2.TABLE_SCHEM String => table schema (may be null)
		result.setTableSchem(rs.getString(2));
		// 3.TABLE_NAME String => table name
		result.setTableName(rs.getString(3));
		// 4.NON_UNIQUE boolean => Can index values be non-unique.false when TYPE is
		// tableIndexStatistic
		result.setNonUnique(rs.getBoolean(4));
		// 5.INDEX_QUALIFIER String => index catalog (may be null); null when TYPE
		// is tableIndexStatistic
		result.setIndexQualifier(rs.getString(5));
		// 6.INDEX_NAME String => index name; null when TYPE istableIndexStatistic
		result.setIndexName(rs.getString(6));
		// 7.TYPE short => index type:
		// ◦ tableIndexStatistic - this identifies table statistics that arereturned
		// in conjuction with a table's index descriptions
		// ◦ tableIndexClustered - this is a clustered index
		// ◦ tableIndexHashed - this is a hashed index
		// ◦ tableIndexOther - this is some other style of index
		result.setType(rs.getShort(7));
		// 8.ORDINAL_POSITION short => column sequence numberwithin index; zero when
		// TYPE is tableIndexStatistic
		result.setOrdinalPosition(rs.getShort(8));
		// 9.COLUMN_NAME String => column name; null when TYPE istableIndexStatistic
		result.setColumnName(rs.getString(9));
		// 10.ASC_OR_DESC String => column sort sequence, "A" => ascending,"D" =>
		// descending, may be null if sort sequence is not supported; null when TYPE
		// is tableIndexStatistic
		result.setAscOrDesc(rs.getString(10));
		// 11.CARDINALITY int => When TYPE is tableIndexStatistic, thenthis is the
		// number of rows in the table; otherwise, it is thenumber of unique values
		// in the index.
		result.setCardinality(rs.getInt(11));
		// 12.PAGES int => When TYPE is tableIndexStatisic thenthis is the number of
		// pages used for the table, otherwise itis the number of pages used for the
		// current index.
		result.setPages(rs.getInt(12));
		// 13.FILTER_CONDITION String => Filter condition, if any.(may be null)
		result.setFilterCondition(rs.getString(13));
	}

	/**
	 * 将DatabaseMetaData.getExportedKeys与getImportedKeys转换为SdTableIndexKeyAttribute属性
	 * 
	 * @param rs
	 * @param result
	 * @throws SQLException
	 */
	public void converterPortedKeysAttribute(ResultSet rs, SdTablePortedKeysAttribute result) throws SQLException {
		// 1.PKTABLE_CAT String => primary key table catalogbeing imported (may be
		// null)
		result.setPktableCat(rs.getString(1));
		// 2.PKTABLE_SCHEM String => primary key table schemabeing imported (may be
		// null)
		result.setPktableSchem(rs.getString(2));
		// 3.PKTABLE_NAME String => primary key table namebeing imported
		result.setPktableName(rs.getString(3));
		// 4.PKCOLUMN_NAME String => primary key column namebeing imported
		result.setPkcolumnName(rs.getString(4));
		// 5.FKTABLE_CAT String => foreign key table catalog (may be null)
		result.setFktableCat(rs.getString(5));
		// 6.FKTABLE_SCHEM String => foreign key table schema (may be null)
		result.setFktableSchem(rs.getString(6));
		// 7.FKTABLE_NAME String => foreign key table name
		result.setFktableName(rs.getString(7));
		// 8.FKCOLUMN_NAME String => foreign key column name
		result.setFkcolumnName(rs.getString(8));
		// 9.KEY_SEQ short => sequence number within a foreign key( a valueof 1
		// represents the first column of the foreign key, a value of 2
		// wouldrepresent the second column within the foreign key).
		result.setKeySeq(rs.getShort(9));
		// 10.UPDATE_RULE short => What happens to aforeign key when the primary key
		// is updated:
		// ◦ importedNoAction - do not allow update of primarykey if it has been
		// imported
		// ◦ importedKeyCascade - change imported key to agreewith primary key
		// update
		// ◦ importedKeySetNull - change imported key to NULLif its primary key has
		// been updated
		// ◦ importedKeySetDefault - change imported key to default valuesif its
		// primary key has been updated
		// ◦ importedKeyRestrict - same as importedKeyNoAction(for ODBC 2.x
		// compatibility)
		result.setUpdateRule(rs.getShort(10));
		// 11.DELETE_RULE short => What happens tothe foreign key when primary is
		// deleted.
		// ◦ importedKeyNoAction - do not allow delete of primarykey if it has been
		// imported
		// ◦ importedKeyCascade - delete rows that import a deleted key
		// ◦ importedKeySetNull - change imported key to NULL ifits primary key has
		// been deleted
		// ◦ importedKeyRestrict - same as importedKeyNoAction(for ODBC 2.x
		// compatibility)
		// ◦ importedKeySetDefault - change imported key to default ifits primary
		// key has been deleted
		result.setDeleteRule(rs.getShort(11));
		// 12.FK_NAME String => foreign key name (may be null)
		result.setFkName(rs.getString(12));
		// 13.PK_NAME String => primary key name (may be null)
		result.setPkName(rs.getString(13));
		// 14.DEFERRABILITY short => can the evaluation of foreign keyconstraints be
		// deferred until commit ◦ importedKeyInitiallyDeferred - see SQL92 for
		// definition
		// ◦ importedKeyInitiallyImmediate - see SQL92 for definition
		// ◦ importedKeyNotDeferrable - see SQL92 for definition
		result.setDeferrability(rs.getShort(14));
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
	public SdAbstractDbUtil setConfig(SdDatabaseOptions config) {
		this.config = config;
		return this;
	}

}
