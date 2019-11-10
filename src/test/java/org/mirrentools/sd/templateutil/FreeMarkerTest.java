package org.mirrentools.sd.templateutil;

import java.util.HashMap;

import org.mirrentools.sd.ScrewDriver;
import org.mirrentools.sd.SdType;
import org.mirrentools.sd.models.SdBean;
import org.mirrentools.sd.models.SdColumn;
import org.mirrentools.sd.models.SdTemplate;
import org.mirrentools.sd.options.ScrewDriverOptions;

public class FreeMarkerTest {
	public static void main(String[] args) {
		String entityName="User"; 
		HashMap<String, SdTemplate> templates = new HashMap<String, SdTemplate>();
		templates.put("entity", new SdTemplate()
				.setPath("/SdTemplates/vertx/")
				.setFile("Entity.ftl")
				.setPackageName("entity")
				.setClassName(entityName));
		templates.put("sql", new SdTemplate()
				.setPath("/SdTemplates/vertx/")
				.setFile("SQL.ftl")
				.setPackageName("sql")
				.setClassName(entityName+"SQL"));

		// 初始化执行工具
		ScrewDriverOptions options = new ScrewDriverOptions(templates, Constant.DATABASEOPTIONS);
		options.setOutputPath("D:/TempJect/freemarker");
		ScrewDriver screwDriver = ScrewDriver.instance(options);
		SdBean bean = Constant.BEAN;
		bean.addColumn(new SdColumn().setType(SdType.FLOAT).setName("float_test"));
		bean.addColumn(new SdColumn().setType(SdType.DOUBLE).setName("double_test"));
		bean.addColumn(new SdColumn().setType(SdType.LONG).setName("long_test"));
		screwDriver.createCode(bean);

	}
}
