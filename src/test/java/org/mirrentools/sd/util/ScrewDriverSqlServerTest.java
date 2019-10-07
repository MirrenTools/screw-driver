package org.mirrentools.sd.util;

import org.mirrentools.sd.ScrewDriver;
import org.mirrentools.sd.constant.SqlServerConstant;
import org.mirrentools.sd.options.ScrewDriverOptions;

public class ScrewDriverSqlServerTest {

	public static void main(String[] args) {
		ScrewDriverOptions options = new ScrewDriverOptions(SqlServerConstant.databaseOptions);
		ScrewDriver driver = ScrewDriver.instance(options);
		boolean deleteTable = driver.deleteTable(SqlServerConstant.classesBean);
		System.out.println("deleteTable: " + deleteTable);
		boolean createTable = driver.createTable(SqlServerConstant.classesBean);
		System.out.println("createTable: " + createTable);
		boolean createTable1 = driver.createTable(SqlServerConstant.studentBean);
		System.out.println("createTable: " + createTable1);
		
	}

}
