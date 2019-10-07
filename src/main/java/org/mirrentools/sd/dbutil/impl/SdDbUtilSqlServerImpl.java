package org.mirrentools.sd.dbutil.impl;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.mirrentools.sd.dbutil.SdAbstractDbUtil;
import org.mirrentools.sd.models.db.query.SdTableAttribute;
import org.mirrentools.sd.models.db.query.SdTableColumnAttribute;
import org.mirrentools.sd.models.db.query.SdTableIndexKeyAttribute;
import org.mirrentools.sd.options.SdDatabaseOptions;

/**
 * 数据库操作相关的工具接口,SQL Server的抽象实现,其他数据库或者不兼容可以重写该类
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class SdDbUtilSqlServerImpl extends SdAbstractDbUtil {
	private final Logger LOG = Logger.getLogger(this.getClass().getName());

	/**
	 * 初始化
	 * 
	 * @param options
	 */
	public SdDbUtilSqlServerImpl(SdDatabaseOptions options) {
		super(options);
	}

	@Override
	public boolean existDatabase(SdDatabaseOptions config, String dbName) throws Exception {
		Connection connection = null;
		ResultSet rs = null;
		try {
			connection = getConnection(config);
			String sql = String.format("select count(*) from sys.databases where name='%s'", dbName);
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
	public List<String> getTableNames() throws Exception {
		Connection connection = null;
		ResultSet rs = null;
		try {
			connection = getConnection();
			String sql = "select name from sysobjects  where xtype='u' or xtype='v' ";
			rs = connection.createStatement().executeQuery(sql);
			List<String> result = new ArrayList<String>();
			while (rs.next()) {
				result.add(rs.getString("name"));
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
	public SdTableAttribute getTableAttribute(String tableName) throws Exception {
		Connection connection = null;
		ResultSet rs = null;
		try {
			connection = getConnection();
			DatabaseMetaData md = connection.getMetaData();
			String catalog = connection.getCatalog() == null ? null : connection.getCatalog();
			String[] types = { "TABLE", "VIEW" };
			rs = md.getTables(catalog, null, tableName, types);
			SdTableAttribute result = null;
			if (rs.next()) {
				result = new SdTableAttribute();
				converterTableAttribute(rs, result);
				// 查询表的注释
				ResultSet comment = connection.createStatement().executeQuery(String.format(
						"select t.name,cast(m.value as varchar) remarks from sys.tables t inner join  sys.extended_properties m on(t.object_id=m.major_id) where m.minor_id=0 and t.name = '%s'", tableName));
				if (comment.next()) {
					result.setRemarks(comment.getString("remarks"));
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
			String sql = "select c.name,cast(r.value as varchar) remarks from sys.tables t " + "inner join sys.columns c on t.object_id=c.object_id "
					+ "inner join sys.extended_properties r on (c.column_id=r.minor_id and  r.major_id=t.object_id )" + "where t.name='" + tableName + "'";
			ResultSet query = connection.createStatement().executeQuery(sql);
			while (query.next()) {
				String name = query.getString("name");
				columnMap.get(name).setRemarks(query.getString("remarks"));
			}
			try {
				query.close();
			} catch (Exception e) {
				e.printStackTrace();
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
	public List<SdTableIndexKeyAttribute> getTableIndexKeysAttribute(String tableName, boolean unique, boolean approximate) throws Exception {
		List<SdTableIndexKeyAttribute> items = super.getTableIndexKeysAttribute(tableName, unique, approximate);
		if (items != null && !items.isEmpty()) {
			Connection connection = null;
			try {
				connection = getConnection();
				List<SdTableIndexKeyAttribute> result = new ArrayList<SdTableIndexKeyAttribute>();
				for (SdTableIndexKeyAttribute index : items) {
					String indexName = index.getIndexName();
					if (indexName == null) {
						continue;
					}
					String sql = String.format("select index_id,is_unique,is_primary_key from sys.indexes where name='%s'", indexName);
					ResultSet query = connection.createStatement().executeQuery(sql);
					if (query.next()) {
						if (query.getInt("is_primary_key") == 1) {
							try {
								query.close();
							} catch (Exception e) {
								e.printStackTrace();
							}
							continue;
						}
						index.setNonUnique(query.getInt("is_unique") == 0);
						index.setOrdinalPosition(query.getShort("index_id"));
						result.add(index);
						try {
							query.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				return result;
			} finally {
				if (connection != null) {
					connection.close();
				}
			}
		}
		return new ArrayList<SdTableIndexKeyAttribute>();
	}

}
