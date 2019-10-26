package org.mirrentools.sd.dbutil.sqlserver;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;

import org.mirrentools.sd.ScrewDriverDbUtil;
import org.mirrentools.sd.constant.SqlServer;
import org.mirrentools.sd.models.SdDatabase;
import org.mirrentools.sd.models.db.update.SdAbstractDatabaseContent;
import org.mirrentools.sd.models.db.update.impl.sqlserver.SdDatabaseContentBySqlServer;
import org.mirrentools.sd.options.SdDatabaseOptions;

/**
 * 操作工具的测试类
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public class SdDbUtilSqlServerExecuteTest {
	/** 操作工具 */
	private ScrewDriverDbUtil sdDbUtil;

	public static void main(String[] args) throws Exception {
		SdDbUtilSqlServerExecuteTest test = new SdDbUtilSqlServerExecuteTest();
		test.setUp();
		test.testGetConnection();
		test.testGetConnectionDatabaseConfig();
		test.testCreateDatabase();
		// test.testUpdateDatabase();
	}

	public void setUp() throws Exception {
		SdDatabaseOptions config = new SdDatabaseOptions(SqlServer.SQL_SERVER_DERVER, "jdbc:sqlserver://localhost:1433;DatabaseName=item");
		config.setUser("sa");
		config.setPassword("root");
		sdDbUtil =  ScrewDriverDbUtil.instance(config);
	}

	public void testGetConnection() throws Exception {
		Connection connection = sdDbUtil.getConnection();
		assertNotNull(connection);
	}

	public void testGetConnectionDatabaseConfig() throws Exception {
		SdDatabaseOptions config = new SdDatabaseOptions(SqlServer.SQL_SERVER_DERVER, "jdbc:sqlserver://localhost:1433;DatabaseName=item");
		config.setUser("sa");
		config.setPassword("root");
		Connection connection = sdDbUtil.getConnection(config);
		assertNotNull(connection);
	}

	public void testCreateDatabase() throws Exception {
		SdDatabase database = new SdDatabase();
		database.setDatabase("test");
		database.setDbName("test").setDbFilename("E:/sqlserver/test/test.mdf");
		database.setLogName("test_log").setLogFilename("E:/sqlserver/test/test_log.ldf");
		SdAbstractDatabaseContent content = new SdDatabaseContentBySqlServer(database);
		boolean result = sdDbUtil.createDatabase(content);
		assertTrue(result);
	}

}
