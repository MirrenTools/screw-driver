package org.mirrentools.sd.dbutil.mysql;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;

import org.mirrentools.sd.constant.MySQL;
import org.mirrentools.sd.dbutil.SdDbUtil;
import org.mirrentools.sd.dbutil.impl.SdDbUtilMySqlImpl;
import org.mirrentools.sd.models.db.update.SdAbstractDatabaseContent;
import org.mirrentools.sd.models.db.update.impl.mysql.SdDatabaseContentByMySQL;
import org.mirrentools.sd.options.SdDatabaseOptions;

/**
 * 操作工具的测试类
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public class SdDbUtilMySqlExecuteTest {
	/** 操作工具 */
	private SdDbUtil sdDbUtil;

	public static void main(String[] args) throws Exception {
		SdDbUtilMySqlExecuteTest test = new SdDbUtilMySqlExecuteTest();
		test.setUp();
		test.testGetConnection();
		test.testGetConnectionDatabaseConfig();
		test.testCreateDatabase();
		test.testUpdateDatabase();
	}

	public void setUp() throws Exception {
		SdDatabaseOptions config = new SdDatabaseOptions(MySQL.MYSQL_DERVER, "jdbc:mysql://localhost:3306/root?useUnicode=true&useSSL=false&characterEncoding=UTF-8&serverTimezone=UTC");
		config.setUser("root");
		config.setPassword("root");
		sdDbUtil = new SdDbUtilMySqlImpl(config);
	}

	public void testGetConnection() throws Exception {
		Connection connection = sdDbUtil.getConnection();
		assertNotNull(connection);
	}

	public void testGetConnectionDatabaseConfig() throws Exception {
		SdDatabaseOptions config = new SdDatabaseOptions(MySQL.MYSQL_8_DERVER, "jdbc:mysql://localhost:3306/root?useUnicode=true&useSSL=false&characterEncoding=UTF-8&serverTimezone=UTC");
		config.setUser("root");
		config.setPassword("root");
		Connection connection = sdDbUtil.getConnection(config);
		assertNotNull(connection);
	}

	public void testCreateDatabase() throws Exception {
		SdAbstractDatabaseContent content = new SdDatabaseContentByMySQL("item");
		boolean result = sdDbUtil.createDatabase(content);
		assertTrue(result);
	}

	public void testUpdateDatabase() throws Exception {
		SdAbstractDatabaseContent content = new SdDatabaseContentByMySQL("item");
		boolean result = sdDbUtil.updateDatabase(content);
		assertTrue(result);
	}

}
