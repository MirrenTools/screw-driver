package org.mirrentools.sd;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Connection;

import org.junit.Before;
import org.junit.Test;
import org.mirrentools.sd.constant.MySQL;
import org.mirrentools.sd.dbutil.SdDbUtil;
import org.mirrentools.sd.dbutil.impl.SdDbUtilImplByMySQL;
import org.mirrentools.sd.models.db.update.AbstractDatabaseContent;
import org.mirrentools.sd.models.db.update.impl.DatabaseContentByMySQL;
import org.mirrentools.sd.options.DatabaseOptions;

/**
 * 操作工具的测试类
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public class SdDbUtilExecuteTest {
	/** 操作工具 */
	private SdDbUtil jgUtil;

	@Before
	public void setUp() throws Exception {
		DatabaseOptions config = new DatabaseOptions(MySQL.MYSQL_8_DERVER, "jdbc:mysql://localhost:3306/root?useUnicode=true&useSSL=false&characterEncoding=UTF-8&serverTimezone=UTC");
		config.setUser("root");
		config.setPassword("root");
		jgUtil = new SdDbUtilImplByMySQL(config);
	}

	@Test
	public void testGetConnection() {
		try {
			Connection connection = jgUtil.getConnection();
			assertNotNull(connection);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testGetConnectionDatabaseConfig() {
		DatabaseOptions config = new DatabaseOptions(MySQL.MYSQL_8_DERVER, "jdbc:mysql://localhost:3306/root?useUnicode=true&useSSL=false&characterEncoding=UTF-8&serverTimezone=UTC");
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

	@Test
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

	@Test
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

	@Test
	public void testCreateTable() {
	}

	@Test
	public void testUpdateTable() {
	}
}
