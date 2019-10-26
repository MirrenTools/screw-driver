package org.mirrentools.sd.dbutil.postgresql;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Connection;

import org.mirrentools.sd.ScrewDriverDbUtil;
import org.mirrentools.sd.constant.PostgreSQL;
import org.mirrentools.sd.models.db.update.SdAbstractDatabaseContent;
import org.mirrentools.sd.models.db.update.impl.mysql.SdDatabaseContentByMySQL;
import org.mirrentools.sd.options.SdDatabaseOptions;

/**
 * 操作工具的测试类
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public class SdDbUtilPostgreSqlExecuteTest {
	/** 操作工具 */
	private ScrewDriverDbUtil sdDbUtil;

	public static void main(String[] args) throws Exception {
		SdDbUtilPostgreSqlExecuteTest test = new SdDbUtilPostgreSqlExecuteTest();
		test.setUp();
		test.testGetConnection();
		test.testGetConnectionDatabaseConfig();
		test.testCreateDatabase();
		test.testUpdateDatabase();
	}

	public void setUp() throws Exception {
		SdDatabaseOptions config = new SdDatabaseOptions(PostgreSQL.POSTGRE_SQL_DERVER, "jdbc:postgresql://localhost:5432/root");
		config.setUser("postgres");
		config.setPassword("root");
		sdDbUtil = ScrewDriverDbUtil.instance(config);
	}

	public void testGetConnection() {
		try {
			Connection connection = sdDbUtil.getConnection();
			assertNotNull(connection);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	public void testGetConnectionDatabaseConfig() {
		SdDatabaseOptions config = new SdDatabaseOptions(PostgreSQL.POSTGRE_SQL_DERVER, "jdbc:postgresql://localhost:5432/root");
		config.setUser("postgres");
		config.setPassword("root");
		try {
			Connection connection = sdDbUtil.getConnection(config);
			assertNotNull(connection);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testCreateDatabase() {
		SdAbstractDatabaseContent content = new SdDatabaseContentByMySQL("item");
		try {
			boolean result = sdDbUtil.createDatabase(content);
			assertTrue(result);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testUpdateDatabase() {
		SdAbstractDatabaseContent content = new SdDatabaseContentByMySQL("item");
		try {
			boolean result = sdDbUtil.updateDatabase(content);
			assertTrue(result);
		} catch (UnsupportedOperationException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
