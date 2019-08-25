package org.mirrentools.sd.util;

import org.mirrentools.sd.constant.MySQL;
import org.mirrentools.sd.converter.TestConstant;
import org.mirrentools.sd.impl.ScrewDriverSqlImpl;
import org.mirrentools.sd.options.ScrewDriverOptions;
import org.mirrentools.sd.options.SdDatabaseOptions;

public class ScrewDriverMySQLTest {
	/** 数据库配置文件 */
	SdDatabaseOptions config;

	public static void main(String[] args) {
		ScrewDriverMySQLTest test = new ScrewDriverMySQLTest();
		test.setUp();
		test.testCreateClasses();
		test.testCreateStudent();
	}

	public void setUp() {
		config = new SdDatabaseOptions(MySQL.MYSQL_DERVER, "jdbc:mysql://localhost:3306/item?useUnicode=true&useSSL=false&characterEncoding=UTF-8&serverTimezone=UTC");
		config.setUser("root");
		config.setPassword("root");
		config.setDatabase("item");
	}

	public void testCreateClasses() {
		boolean execute = new ScrewDriverSqlImpl(new ScrewDriverOptions(TestConstant.classesBean, config)).execute();
		System.out.println("SQL执行结果:" + execute);
	}

	public void testCreateStudent() {
		boolean execute = new ScrewDriverSqlImpl(new ScrewDriverOptions(TestConstant.studentBean, config)).execute();
		System.out.println("SQL执行结果:" + execute);
	}

}
