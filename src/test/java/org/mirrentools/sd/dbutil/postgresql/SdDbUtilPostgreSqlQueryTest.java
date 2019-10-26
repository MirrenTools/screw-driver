package org.mirrentools.sd.dbutil.postgresql;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.mirrentools.sd.ScrewDriverDbUtil;
import org.mirrentools.sd.constant.PostgreSQL;
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
public class SdDbUtilPostgreSqlQueryTest {
	/** 操作工具 */
	private ScrewDriverDbUtil sdDbUtil;

	public static void main(String[] args) throws Exception {
		SdDbUtilPostgreSqlQueryTest test = new SdDbUtilPostgreSqlQueryTest();
		test.setUp();
		String tableName = "root";
		test.getTableNamesTest();
		test.getTableAttributeTest(tableName);
		test.getColumnsTest(tableName);
		test.getTablePrimaryKeyAttributeTest(tableName);
		test.getTableIndexKeysAttributeTest(tableName);
		test.getTableExportedKeysAttributeTest(tableName);
		test.getTableImportedKeysAttributeTest(tableName);
	}

	public void setUp() throws Exception {
		SdDatabaseOptions config = new SdDatabaseOptions(PostgreSQL.POSTGRE_SQL_DERVER, "jdbc:postgresql://localhost:5432/root");
		config.setUser("postgres");
		config.setPassword("root");
		sdDbUtil =  ScrewDriverDbUtil.instance(config);
	}

	public void getTableNamesTest() throws Exception {
		List<String> names = sdDbUtil.getTableNames();
		System.out.println(names);
	}

	public void getTableAttributeTest(String tableName) throws Exception {
		SdTableAttribute attribute = sdDbUtil.getTableAttribute(tableName);
		System.out.println(attribute);
		assertEquals("root", attribute.getTableName());
		assertEquals("remarks test", attribute.getRemarks());
	}

	public void getColumnsTest(String tableName) throws Exception {
		List<SdTableColumnAttribute> list = sdDbUtil.getTableColumnsAttribute(tableName);
		System.out.println(list);
		assertEquals(2, list.size());
		assertEquals("注解name", list.get(1).getRemarks());
	}

	public void getTablePrimaryKeyAttributeTest(String tableName) throws Exception {
		SdTablePrimaryKeyAttribute keyAttribute = sdDbUtil.getTablePrimaryKeyAttribute(tableName);
		System.out.println(keyAttribute);
		assertEquals("table1_pkey", keyAttribute.getPkName());
	}

	public void getTableIndexKeysAttributeTest(String tableName) throws Exception {
		List<SdTableIndexKeyAttribute> list = sdDbUtil.getTableIndexKeysAttribute(tableName, true, true);
		System.out.println(list);
		assertEquals(4, list.size());
		assertEquals("UK_name_test", list.get(1).getIndexName());
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
