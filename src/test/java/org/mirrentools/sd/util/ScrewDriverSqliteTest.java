package org.mirrentools.sd.util;

import org.mirrentools.sd.constant.SQLite;
import org.mirrentools.sd.constant.SqliteConstant;
import org.mirrentools.sd.impl.ScrewDriverSqlImpl;
import org.mirrentools.sd.options.ScrewDriverOptions;
import org.mirrentools.sd.options.SdDatabaseOptions;

public class ScrewDriverSqliteTest {
	/** 数据库配置文件 */
	SdDatabaseOptions config;

	public static void main(String[] args) {
		ScrewDriverSqliteTest test = new ScrewDriverSqliteTest();
		test.setUp();
		test.testCreateClasses();
		test.testCreateStudent();
	}

	public void setUp() {
		config = new SdDatabaseOptions(SQLite.SQLITE_DERVER, "jdbc:sqlite:D:/tempProject/item.db");
	}

	public void testCreateClasses() {
		boolean execute = new ScrewDriverSqlImpl(new ScrewDriverOptions(config)).createTable(SqliteConstant.classesBean);
		System.out.println("SQL执行结果:" + execute);
	}

	public void testCreateStudent() {
		boolean execute = new ScrewDriverSqlImpl(new ScrewDriverOptions(config)).createTable(SqliteConstant.studentBean);
		System.out.println("SQL执行结果:" + execute);
	}

}
