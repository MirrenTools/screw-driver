package org.mirrentools.sd.util;

import org.mirrentools.sd.ScrewDriver;
import org.mirrentools.sd.SdType;
import org.mirrentools.sd.constant.MySqlConstant;
import org.mirrentools.sd.models.SdBean;
import org.mirrentools.sd.models.SdColumn;
import org.mirrentools.sd.options.ScrewDriverOptions;

public class ScrewDriverMySQLTest {

	public static void main(String[] args) {
		ScrewDriverOptions options = new ScrewDriverOptions(MySqlConstant.databaseOptions);
		ScrewDriver driver = ScrewDriver.instance(options);
		boolean deleteTable = driver.deleteTable(MySqlConstant.classesBean);
		System.out.println("deleteTable: " + deleteTable);
		boolean createTable = driver.createTable(MySqlConstant.classesBean);
		System.out.println("createTable: " + createTable);
		SdBean bean = new SdBean().setName("classes");
		bean.addColumn(new SdColumn().setName("alteradd").setType(SdType.INTEGER));
		boolean updateTable = driver.updateTable(bean);
		System.out.println("updateTable: " + updateTable);
	}

}
