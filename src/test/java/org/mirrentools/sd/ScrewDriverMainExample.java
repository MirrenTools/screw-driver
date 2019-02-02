package org.mirrentools.sd;

import java.util.HashMap;
import java.util.Map;

import org.mirrentools.sd.common.SdUtil;
import org.mirrentools.sd.constant.Constant;
import org.mirrentools.sd.constant.MySQL;
import org.mirrentools.sd.converter.impl.mysql.SdBeanConverterToTableContentImplByMySQL;
import org.mirrentools.sd.dbutil.impl.SdDbUtilImplByMySQL;
import org.mirrentools.sd.models.SdBean;
import org.mirrentools.sd.models.SdColumn;
import org.mirrentools.sd.models.SdTemplate;
import org.mirrentools.sd.options.SdDatabaseOptions;
import org.mirrentools.sd.util.SdCodeUtil;
import org.mirrentools.sd.util.SdSqlUtil;
import org.mirrentools.sd.util.impl.SdCodeUtilImpl;
import org.mirrentools.sd.util.impl.SdSqlUtilImpl;

public class ScrewDriverMainExample {

	public static void main(String[] args) throws Exception {
		// 创建一个实体描述
		SdBean bean = new SdBean();
		SdColumn column = new SdColumn().setName("id").setType(MySQL.BIGINT).setPrimary(true).setNullable(false).setAutoIncrement(true)
				.setRemark("用户的id");
		SdColumn column2 = new SdColumn().setName("name").setType(MySQL.VARCHAR).setLength("30").setRemark("用户的名字");
		SdColumn column3 = new SdColumn().setName("pwd").setType(MySQL.VARCHAR).setLength("60").setRemark("用户的的密码");
		bean.setName("user").setRemark("用户").setColumns(SdUtil.asList(column, column2, column3));
		// 设置实体生成模板
		Map<String, SdTemplate> templates = new HashMap<String, SdTemplate>();
		templates.put("entity",
				new SdTemplate().setFile("entity.ftl").setSourceFolder(Constant.MAVEN_SRC).setPackageName("entity").setClassName("User"));
		templates.put("dao",
				new SdTemplate().setFile("dao.ftl").setSourceFolder(Constant.MAVEN_SRC).setPackageName("dao").setClassName("UserDao"));
		// 初始化代码执行生成工具
		SdCodeUtil codeUtil = new SdCodeUtilImpl(bean, templates);
		// 初始化SQL执行生成工具
		SdDatabaseOptions config = new SdDatabaseOptions(MySQL.MYSQL_8_DERVER,
				"jdbc:mysql://localhost:3306/root?useUnicode=true&useSSL=false&characterEncoding=UTF-8&serverTimezone=UTC");
		config.setUser("root");
		config.setPassword("root");
		SdSqlUtil sqlUtil = new SdSqlUtilImpl(bean, new SdDbUtilImplByMySQL(config), new SdBeanConverterToTableContentImplByMySQL());
		// 执行代码
		ScrewDriver sd = new ScrewDriverImpl(codeUtil, sqlUtil);
		sd.createCode();
		sd.createSQL();
	}
}
