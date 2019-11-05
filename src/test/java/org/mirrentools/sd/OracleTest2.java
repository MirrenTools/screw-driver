package org.mirrentools.sd;

import java.util.HashMap;
import java.util.Map;

import org.mirrentools.sd.common.SdUtil;
import org.mirrentools.sd.constant.Constant;
import org.mirrentools.sd.constant.Oracle;
import org.mirrentools.sd.models.SdBean;
import org.mirrentools.sd.models.SdColumn;
import org.mirrentools.sd.models.SdTemplate;
import org.mirrentools.sd.options.SdDatabaseOptions;
import org.mirrentools.sd.options.def.ScrewDriverOracleOptions;

public class OracleTest2 {
	public static void main(String[] args) throws Exception {
		// 创建一个实体描述
		SdBean bean = new SdBean();
		SdColumn column = new SdColumn().setName("id").setType(SdType.NUMBER).setLength(10).setPrimary(true).setRemark("用户的id");
		SdColumn column2 = new SdColumn().setName("name").setType(SdType.VARCHAR2).setLength(30).setRemark("用户的名字");
		SdColumn column3 = new SdColumn().setName("pwd").setType(SdType.VARCHAR2).setLength(60).setRemark("用户的的密码");
		bean.setName("tuser").setRemark("用户").setColumns(SdUtil.asList(column, column2, column3));
		// 设置实体生成模板
		Map<String, SdTemplate> templates = new HashMap<String, SdTemplate>();
		templates.put("entity", new SdTemplate().setPath("mybatis").setFile("JavaEntity.ftl").setSourceFolder(Constant.MAVEN_SRC).setPackageName("entity").setClassName("User"));
		// 初始化SQL执行生成工具
		SdDatabaseOptions databaseOptions = new SdDatabaseOptions(Oracle.ORACLE_DERVER, "jdbc:oracle:thin:@127.0.0.1:1521:orcl");
		databaseOptions.setUser("scott");
		databaseOptions.setPassword("tiger");
		ScrewDriver screwDriver = ScrewDriver.instance(new ScrewDriverOracleOptions(databaseOptions));
		screwDriver.createTable(bean);
		//screwDriver.createCode(bean);
		
	}

}
