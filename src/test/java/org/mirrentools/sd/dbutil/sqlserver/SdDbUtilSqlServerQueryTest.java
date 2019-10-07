package org.mirrentools.sd.dbutil.sqlserver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.mirrentools.sd.constant.SqlServer;
import org.mirrentools.sd.constant.SqliteConstant;
import org.mirrentools.sd.dbutil.SdDbUtil;
import org.mirrentools.sd.dbutil.impl.SdDbUtilSqlServerImpl;
import org.mirrentools.sd.models.db.query.SdTable;
import org.mirrentools.sd.models.db.query.SdTableAttribute;
import org.mirrentools.sd.models.db.query.SdTableColumnAttribute;
import org.mirrentools.sd.models.db.query.SdTableIndexKeyAttribute;
import org.mirrentools.sd.models.db.query.SdTablePortedKeysAttribute;
import org.mirrentools.sd.models.db.query.SdTablePrimaryKeyAttribute;
import org.mirrentools.sd.options.SdDatabaseOptions;

/**
 * 操作工具的测试类
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public class SdDbUtilSqlServerQueryTest {
	/** 操作工具 */
	private SdDbUtil sdDbUtil;

	public static void main(String[] args) throws Exception {
		SdDbUtilSqlServerQueryTest test = new SdDbUtilSqlServerQueryTest();
		test.setUp();
		String tableName = SqliteConstant.studentBean.getName();
		test.existDatabaseTest();
		test.existTableTest(tableName);
		test.getSdTableTest(tableName);
		test.getTableNamesTest();
		test.getTableAttributeTest(tableName);
		test.getColumnsTest(tableName);
		test.getTablePrimaryKeyAttributeTest(tableName);
		test.getTableIndexKeysAttributeTest(tableName);
		test.getTableExportedKeysAttributeTest(tableName);
		 test.getTableImportedKeysAttributeTest(tableName);
	}

	public void setUp() throws Exception {
		SdDatabaseOptions config = new SdDatabaseOptions(SqlServer.SQL_SERVER_DERVER, "jdbc:sqlserver://localhost:1433;DatabaseName=item");
		config.setUser("sa");
		config.setPassword("root");
		sdDbUtil = new SdDbUtilSqlServerImpl(config);
	}

	public void existDatabaseTest() throws Exception {
		boolean exist = sdDbUtil.existDatabase("item");
		assertTrue(exist);
	}

	public void existTableTest(String tableName) throws Exception {
		boolean exist = sdDbUtil.existTable(tableName);
		assertTrue(exist);
	}

	public void getSdTableTest(String tableName) throws Exception {
		SdTable table = sdDbUtil.getSdTable(tableName);
		System.out.println(table);
		assertNotNull(table);
	}

	public void getTableNamesTest() throws Exception {
		List<String> names = sdDbUtil.getTableNames();
		System.out.println(names);
	}
	public void getTableAttributeTest(String tableName) throws Exception {
		SdTableAttribute attribute = sdDbUtil.getTableAttribute(tableName);
		System.out.println(attribute);
		assertEquals("classes_student", attribute.getTableName());
		assertEquals("班级里面的学生", attribute.getRemarks());
	}

	public void getColumnsTest(String tableName) throws Exception {
		List<SdTableColumnAttribute> list = sdDbUtil.getTableColumnsAttribute(tableName);
		System.out.println(list);
		assertEquals(7, list.size());
//		assertEquals("注解name", list.get(1).getRemarks());
	}

	public void getTablePrimaryKeyAttributeTest(String tableName) throws Exception {
		SdTablePrimaryKeyAttribute keyAttribute = sdDbUtil.getTablePrimaryKeyAttribute(tableName);
		System.out.println(keyAttribute);
		assertEquals("id", keyAttribute.getColumnName());
	}

	public void getTableIndexKeysAttributeTest(String tableName) throws Exception {
		List<SdTableIndexKeyAttribute> list = sdDbUtil.getTableIndexKeysAttribute(tableName, false, true);
		System.out.println(list);
		assertEquals(2, list.size());
		assertEquals("idx_user_mobile_phone", list.get(0).getIndexName());
	}

	public void getTableExportedKeysAttributeTest(String tableName) throws Exception {
		List<SdTablePortedKeysAttribute> list = sdDbUtil.getTableExportedKeysAttribute(tableName);
		System.out.println("getTableExportedKeysAttributeTest");
		System.out.println(list);
	}

	public void getTableImportedKeysAttributeTest(String tableName) throws Exception {
		List<SdTablePortedKeysAttribute> list = sdDbUtil.getTableImportedKeysAttribute(tableName);
		System.out.println("getTableImportedKeysAttributeTest");
		System.out.println(list);
	}

}
