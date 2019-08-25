package org.mirrentools.sd;

import org.mirrentools.sd.common.SdUtil;
import org.mirrentools.sd.constant.DB2;
import org.mirrentools.sd.models.SdBean;
import org.mirrentools.sd.models.SdColumn;
import org.mirrentools.sd.options.ScrewDriverOptions;
import org.mirrentools.sd.options.SdDatabaseOptions;

public class Db2Test {
	public static void main(String[] args) throws Exception {
		// 创建一个实体描述
		SdBean bean = new SdBean();
		SdColumn column = new SdColumn().setName("id").setType(DB2.DECIMAL).setLength(10).setPrimary(true).setRemark("用户的id");
		SdColumn column2 = new SdColumn().setName("name").setType(DB2.VARCHAR).setLength(30).setRemark("用户的名字");
		SdColumn column3 = new SdColumn().setName("pwd").setType(DB2.VARCHAR).setLength(60).setRemark("用户的的密码");
		bean.setName("user").setRemark("用户").setColumns(SdUtil.asList(column, column2, column3));
		// 设置实体生成模板
		/*
		 * Map<String, SdTemplate> templates = new HashMap<String, SdTemplate>();
		 * templates.put("entity", new
		 * SdTemplate().setPath("mybatis").setFile("JavaEntity.ftl").
		 * setSourceFolder( Constant.MAVEN_SRC)
		 * .setPackageName("entity").setClassName("User")); // 初始化代码执行生成工具
		 * ScrewDriverCode codeUtil = new ScrewDriverCodeImpl(bean, templates);
		 * codeUtil.execute();
		 */
		// 初始化SQL执行生成工具
		SdDatabaseOptions databaseOptions = new SdDatabaseOptions(DB2.DB2_DERVER, "jdbc:db2://127.0.0.1:50000/sample");
		databaseOptions.setUser("db2admin");
		databaseOptions.setPassword("000000");
		ScrewDriver screwDriver = ScrewDriver.instance(new ScrewDriverOptions(bean, databaseOptions));
		screwDriver.createSQL();
	}

}
