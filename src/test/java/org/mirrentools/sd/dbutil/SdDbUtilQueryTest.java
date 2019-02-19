package org.mirrentools.sd.dbutil;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.mirrentools.sd.constant.MySQL;
import org.mirrentools.sd.dbutil.impl.SdDbUtilImplByMySQL;
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
public class SdDbUtilQueryTest {
	/** 操作工具 */
	private SdDbUtil sdDbUtil;

	public static void main(String[] args) throws Exception {
		SdDbUtilQueryTest test = new SdDbUtilQueryTest();
		test.setUp();
		String tableName = "root";
		test.getTableAttributeTest(tableName);
		test.getColumnsTest(tableName);
		test.getTablePrimaryKeyAttributeTest(tableName);
		test.getTableIndexKeysAttributeTest(tableName);
		test.getTableExportedKeysAttributeTest(tableName);
		test.getTableImportedKeysAttributeTest(tableName);
	}

	public void setUp() throws Exception {
		SdDatabaseOptions config = new SdDatabaseOptions(MySQL.MYSQL_DERVER,
				"jdbc:mysql://localhost:3306/root?useUnicode=true&useSSL=false&characterEncoding=UTF-8&serverTimezone=UTC");
		config.setUser("root");
		config.setPassword("root");
		sdDbUtil = new SdDbUtilImplByMySQL(config);
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
		assertEquals("PRIMARY", keyAttribute.getPkName());
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
