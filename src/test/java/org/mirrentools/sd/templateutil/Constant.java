package org.mirrentools.sd.templateutil;

import org.mirrentools.sd.constant.MySQL;
import org.mirrentools.sd.constant.SdType;
import org.mirrentools.sd.models.SdBean;
import org.mirrentools.sd.models.SdColumn;
import org.mirrentools.sd.options.SdDatabaseOptions;

/**
 * 模板测试类的常量
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public class Constant {
	/** bean常量 */
	public final static SdBean BEAN;
	/** 数据库配置信息常量 */
	public final static SdDatabaseOptions DATABASEOPTIONS;
	static {
		// 创建一个实体描述
		BEAN = new SdBean();
		BEAN.setName("user").setRemark("用户");
		BEAN.addColumn(new SdColumn().setName("id").setType(SdType.LONG).setPrimary(true).setRemark("用户的id"));
		BEAN.addColumn(new SdColumn().setName("name").setType(SdType.STRING).setLength(30).setRemark("用户的名字"));
		BEAN.addColumn(new SdColumn().setName("pwd").setType(SdType.STRING).setLength(60).setRemark("用户的的密码"));

		// 初始化数据库连接信息
		DATABASEOPTIONS = new SdDatabaseOptions(MySQL.MYSQL_8_DERVER,
				"jdbc:mysql://localhost:3306/root?useUnicode=true&useSSL=false&serverTimezone=UTC");
		DATABASEOPTIONS.setUser("root");
		DATABASEOPTIONS.setPassword("root");
	}

}
