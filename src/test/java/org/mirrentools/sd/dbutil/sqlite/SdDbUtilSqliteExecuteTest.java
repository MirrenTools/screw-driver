package org.mirrentools.sd.dbutil.sqlite;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Connection;

import org.mirrentools.sd.constant.SQLite;
import org.mirrentools.sd.dbutil.SdDbUtil;
import org.mirrentools.sd.dbutil.impl.SdDbUtilSqliteImpl;
import org.mirrentools.sd.models.db.update.SdAbstractDatabaseContent;
import org.mirrentools.sd.models.db.update.impl.mysql.SdDatabaseContentByMySQL;
import org.mirrentools.sd.models.db.update.impl.sqlite.SdDatabaseContentBySqlite;
import org.mirrentools.sd.options.SdDatabaseOptions;

/**
 * 操作工具的测试类
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public class SdDbUtilSqliteExecuteTest {
	/** 操作工具 */
	private SdDbUtil sdDbUtil;

	public static void main(String[] args) throws Exception {
		SdDbUtilSqliteExecuteTest test = new SdDbUtilSqliteExecuteTest();
		test.setUp();
		test.testGetConnection();
		test.testCreateDatabase();
		test.testUpdateDatabase();
	}

	public void setUp() throws Exception {
		SdDatabaseOptions config = new SdDatabaseOptions(SQLite.SQLITE_DERVER, "jdbc:sqlite:D:/tempProject/test.db");
		sdDbUtil = new SdDbUtilSqliteImpl(config);
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
	public void testCreateDatabase() {
		try {
			boolean result = sdDbUtil.createDatabase(new SdDatabaseContentBySqlite("idd"));
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
