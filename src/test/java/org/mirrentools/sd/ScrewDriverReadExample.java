package org.mirrentools.sd;

import java.util.HashMap;
import java.util.Map;

import org.mirrentools.sd.constant.MySQL;
import org.mirrentools.sd.models.SdClassContent;
import org.mirrentools.sd.models.SdTemplate;
import org.mirrentools.sd.options.ScrewDriverOptions;
import org.mirrentools.sd.options.SdDatabaseOptions;

public class ScrewDriverReadExample {

	public static void main(String[] args) throws Exception {

		// 设置实体生成模板
		Map<String, SdTemplate> templates = new HashMap<String, SdTemplate>();
		templates.put("entity", new SdTemplate().setFile("JavaEntity.ftl").setPackageName("entity").setClassName("User"));

		// 初始化数据库连接信息
		SdDatabaseOptions databaseOptions = new SdDatabaseOptions(MySQL.MYSQL_8_DERVER, "jdbc:mysql://localhost:3306/root?useUnicode=true&useSSL=false&serverTimezone=UTC");
		databaseOptions.setUser("root");
		databaseOptions.setPassword("root");

		// 初始化执行工具
		ScrewDriver screwDriver = ScrewDriver.instance(new ScrewDriverOptions(templates, databaseOptions));
		// 读取表信息
		SdClassContent content = screwDriver.readTable("root");
		// 创建代码
		screwDriver.createCode(content);
	}
}
