package org.mirrentools.sd;

import java.util.ArrayList;

import org.mirrentools.sd.common.SdUtil;
import org.mirrentools.sd.constant.Constant;
import org.mirrentools.sd.constant.MySQL;
import org.mirrentools.sd.converter.impl.SdBeanConverterToClassImplByMySQL;
import org.mirrentools.sd.converter.impl.SdBeanConverterToTableContentImplByMySQL;
import org.mirrentools.sd.dbutil.impl.SdDbUtilImplByMySQL;
import org.mirrentools.sd.models.SdBean;
import org.mirrentools.sd.models.SdColumn;
import org.mirrentools.sd.models.SdTemplate;
import org.mirrentools.sd.options.DatabaseOptions;
import org.mirrentools.sd.util.impl.SdCodeUtilImpl;
import org.mirrentools.sd.util.impl.SdSqlUtillImpl;
import org.mirrentools.sd.util.impl.SdTemplateUtilImplMyFreeMarker;

public class ScrewDriverTest {

	public static void main(String[] args) throws Exception {
		// 创建一个实体描述
		SdBean bean = new SdBean();
		SdColumn column = new SdColumn().setName("id").setType(MySQL.BIGINT).setPrimary(true).setNullable(false).setAutoIncrement(true).setRemark("用户的id");
		SdColumn column2 = new SdColumn().setName("name").setType(MySQL.VARCHAR).setLength("30").setRemark("用户的名字");
		SdColumn column3 = new SdColumn().setName("pwd").setType(MySQL.VARCHAR).setLength("60").setRemark("用户的的密码");
		bean.setName("user").setRemark("用户").setColumns(SdUtil.asList(column, column2, column3));
		// 设置实体生成模板
		ArrayList<SdTemplate> templates = new ArrayList<>();
		templates.add(new SdTemplate().setSourceFolder(Constant.MAVEN_SRC).setName("entity.ftl").setPackageName("entity").setClassName("User.java"));
		templates.add(new SdTemplate().setSourceFolder(Constant.MAVEN_SRC).setName("dao.ftl").setPackageName("dao").setClassName("UserDao.java"));
		// 初始化代码执行生成工具
		SdCodeUtilImpl codeUtil = new SdCodeUtilImpl(SdUtil.getUserDir(), bean, templates, new SdBeanConverterToClassImplByMySQL(), new SdTemplateUtilImplMyFreeMarker());
		// 初始化SQL执行生成工具
		DatabaseOptions config = new DatabaseOptions(MySQL.MYSQL_8_DERVER, "jdbc:mysql://localhost:3306/root?useUnicode=true&useSSL=false&characterEncoding=UTF-8&serverTimezone=UTC");
		config.setUser("root");
		config.setPassword("root");
		SdSqlUtillImpl sqlUtil = new SdSqlUtillImpl(bean, new SdDbUtilImplByMySQL(config), new SdBeanConverterToTableContentImplByMySQL());
		// 执行代码
		ScrewDriver sd = new ScrewDriverImpl(codeUtil, sqlUtil);
		sd.createCode();
		sd.createSQL();
	}
}
