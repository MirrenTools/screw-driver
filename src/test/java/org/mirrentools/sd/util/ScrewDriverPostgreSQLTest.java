package org.mirrentools.sd.util;

import org.mirrentools.sd.constant.PostgreSQL;
import org.mirrentools.sd.constant.PostgreSqlConstant;
import org.mirrentools.sd.impl.ScrewDriverSqlImpl;
import org.mirrentools.sd.options.ScrewDriverOptions;
import org.mirrentools.sd.options.SdDatabaseOptions;

public class ScrewDriverPostgreSQLTest {
	/** 数据库配置文件 */
	SdDatabaseOptions config;

	public static void main(String[] args) {
		ScrewDriverPostgreSQLTest test = new ScrewDriverPostgreSQLTest();
		test.setUp();
		test.testCreateClasses();
		test.testCreateStudent();
	}

	public void setUp() {
		config = new SdDatabaseOptions(PostgreSQL.POSTGRE_SQL_DERVER, "jdbc:postgresql://localhost:5432/item");
		config.setUser("postgres");
		config.setPassword("root");
		config.setDatabase("item");
	}

	public void testCreateClasses() {
		boolean execute = new ScrewDriverSqlImpl(new ScrewDriverOptions(config)).createTable(PostgreSqlConstant.classesBean);
		System.out.println("SQL执行结果:" + execute);
	}

	public void testCreateStudent() {
		boolean execute = new ScrewDriverSqlImpl(new ScrewDriverOptions(config)).createTable(PostgreSqlConstant.studentBean);
		System.out.println("SQL执行结果:" + execute);
	}

}
