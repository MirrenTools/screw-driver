package org.mirrentools.sd;

import java.util.HashMap;
import java.util.Map;

import org.mirrentools.sd.common.SdUtil;
import org.mirrentools.sd.constant.Constant;
import org.mirrentools.sd.constant.MySQL;
import org.mirrentools.sd.impl.ScrewDriverCodeImpl;
import org.mirrentools.sd.impl.ScrewDriverSqlImpl;
import org.mirrentools.sd.models.SdBean;
import org.mirrentools.sd.models.SdColumn;
import org.mirrentools.sd.models.SdTemplate;
import org.mirrentools.sd.options.SdDatabaseOptions;

public class ScrewDriverMainExample {

	public static void main(String[] args) throws Exception {
		// 创建一个实体描述
		SdBean bean = new SdBean();
		SdColumn column = new SdColumn().setName("id").setType(MySQL.BIGINT).setPrimary(true).setNullable(false).setAutoIncrement(true)
				.setRemark("用户的id");
		SdColumn column2 = new SdColumn().setName("name").setType(MySQL.VARCHAR).setLength(30).setRemark("用户的名字");
		SdColumn column3 = new SdColumn().setName("pwd").setType(MySQL.VARCHAR).setLength(60).setRemark("用户的的密码");
		bean.setName("user").setRemark("用户").setColumns(SdUtil.asList(column, column2, column3));
		// 设置实体生成模板
		Map<String, SdTemplate> templates = new HashMap<String, SdTemplate>();
		templates.put("entity", new SdTemplate().setPath("mybatis").setFile("JavaEntity.ftl").setSourceFolder(Constant.MAVEN_SRC)
				.setPackageName("entity").setClassName("User"));
		// 初始化代码执行生成工具
		ScrewDriverCode codeUtil = new ScrewDriverCodeImpl(bean, templates);
		// 初始化SQL执行生成工具
		SdDatabaseOptions databaseOptions = new SdDatabaseOptions(MySQL.MYSQL_8_DERVER,
				"jdbc:mysql://localhost:3306/root?useUnicode=true&useSSL=false&characterEncoding=UTF-8&serverTimezone=UTC");
		databaseOptions.setUser("root");
		databaseOptions.setPassword("root");
		ScrewDriverSQL sqlUtil = new ScrewDriverSqlImpl(bean, databaseOptions);
		sqlUtil.execute();
	}
}
