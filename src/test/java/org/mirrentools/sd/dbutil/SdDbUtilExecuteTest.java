package org.mirrentools.sd.dbutil;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Connection;

import org.mirrentools.sd.constant.MySQL;
import org.mirrentools.sd.dbutil.impl.SdDbUtilImplByMySQL;
import org.mirrentools.sd.models.db.update.AbstractDatabaseContent;
import org.mirrentools.sd.models.db.update.impl.DatabaseContentByMySQL;
import org.mirrentools.sd.options.SdDatabaseOptions;

/**
 * 操作工具的测试类
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public class SdDbUtilExecuteTest {
	/** 操作工具 */
	private SdDbUtil jgUtil;

	public static void main(String[] args) throws Exception {
		SdDbUtilExecuteTest test = new SdDbUtilExecuteTest();
		test.setUp();
		test.testGetConnection();
		test.testGetConnectionDatabaseConfig();
		test.testCreateDatabase();
		test.testUpdateDatabase();
	}

	public void setUp() throws Exception {
		SdDatabaseOptions config = new SdDatabaseOptions(MySQL.MYSQL_8_DERVER,
				"jdbc:mysql://localhost:3306/root?useUnicode=true&useSSL=false&characterEncoding=UTF-8&serverTimezone=UTC");
		config.setUser("root");
		config.setPassword("root");
		jgUtil = new SdDbUtilImplByMySQL(config);
	}

	public void testGetConnection() {
		try {
			Connection connection = jgUtil.getConnection();
			assertNotNull(connection);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	public void testGetConnectionDatabaseConfig() {
		SdDatabaseOptions config = new SdDatabaseOptions(MySQL.MYSQL_8_DERVER,
				"jdbc:mysql://localhost:3306/root?useUnicode=true&useSSL=false&characterEncoding=UTF-8&serverTimezone=UTC");
		config.setUser("root");
		config.setPassword("root");
		try {
			Connection connection = jgUtil.getConnection(config);
			assertNotNull(connection);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testCreateDatabase() {
		AbstractDatabaseContent content = new DatabaseContentByMySQL("item");
		try {
			boolean result = jgUtil.createDatabase(content);
			assertTrue(result);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testUpdateDatabase() {
		AbstractDatabaseContent content = new DatabaseContentByMySQL("item");
		try {
			boolean result = jgUtil.updateDatabase(content);
			assertTrue(result);
		} catch (UnsupportedOperationException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
