package org.mirrentools.sd.util;

import java.util.Map;

import org.mirrentools.sd.ScrewDriverCode;
import org.mirrentools.sd.constant.MySQL;
import org.mirrentools.sd.converter.TestConstant;
import org.mirrentools.sd.impl.ScrewDriverCodeImpl;
import org.mirrentools.sd.models.SdBean;
import org.mirrentools.sd.models.SdTemplate;
import org.mirrentools.sd.options.SdDatabaseOptions;
import org.mirrentools.sd.options.def.ScrewDriverMySqlOptions;

/**
 * FreeMarker模板生成文件的测试
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class CodeUtilByFreeMarkerTest {
	public static void main(String[] args) {
		// 创建一个实体描述
		SdBean bean = TestConstant.studentBean;
		// 设置实体生成模板
		Map<String, SdTemplate> templates = TestConstant.templates;
		// 数据库配置信息
		SdDatabaseOptions config = new SdDatabaseOptions(MySQL.MYSQL_8_DERVER, "jdbc:mysql://localhost:3306/root?useUnicode=true&useSSL=false&characterEncoding=UTF-8&serverTimezone=UTC");
		config.setUser("root");
		config.setPassword("root");

		// 初始化代码执行生成工具
		ScrewDriverCode codeUtil = new ScrewDriverCodeImpl(new ScrewDriverMySqlOptions(bean, templates, config));
		codeUtil.execute();
	}
}
