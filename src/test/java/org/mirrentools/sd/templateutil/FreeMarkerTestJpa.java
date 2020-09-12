package org.mirrentools.sd.templateutil;

import java.util.HashMap;
import java.util.Map;

import org.mirrentools.sd.ScrewDriver;
import org.mirrentools.sd.SdType;
import org.mirrentools.sd.models.SdBean;
import org.mirrentools.sd.models.SdColumn;
import org.mirrentools.sd.models.SdTemplate;
import org.mirrentools.sd.options.ScrewDriverOptions;

public class FreeMarkerTestJpa {
	public static void main(String[] args) {
		String packageName="com.example.demo."; 
		String entityName="Users"; 
		Map<String, SdTemplate> templates = new HashMap<String, SdTemplate>();
		templates.put("entity", new SdTemplate()
				.setPath("/SdTemplates/jpa/")
				.setFile("Entity.ftl")
				.setPackageName(packageName + "entity")
				.setClassName(entityName));
		templates.put("dao", new SdTemplate()
				.setPath("/SdTemplates/jpa/")
				.setFile("Dao.ftl")
				.setPackageName(packageName + "repository")
				.setClassName(entityName + "Repository"));
		templates.put("service", new SdTemplate()
				.setPath("/SdTemplates/jpa/")
				.setFile("Service.ftl")
				.setPackageName(packageName + "service")
				.setClassName(entityName + "Service"));
		templates.put("serviceImpl", new SdTemplate()
				.setPath("/SdTemplates/jpa/")
				.setFile("ServiceImpl.ftl")
				.setPackageName(packageName + "service.impl")
				.setClassName(entityName + "ServiceImpl"));
		templates.put("controller", new SdTemplate()
				.setPath("/SdTemplates/jpa/")
				.setFile("Controller.ftl")
				.setPackageName(packageName + "controller")
				.setClassName(entityName + "Controller"));
		templates.put("test", new SdTemplate()
				.setPath("/SdTemplates/jpa/")
				.setFile("Test.ftl")
				.setSourceFolder(org.mirrentools.sd.constant.SdConstant.MAVEN_TEST)
				.setPackageName(packageName + "test")
				.setClassName(entityName + "ControllerTest")
				);

		// 初始化执行工具
		ScrewDriverOptions options = new ScrewDriverOptions( Constant.DATABASEOPTIONS);
		options.setOutputPath("D:/TempJect/freemarker");
		ScrewDriver screwDriver = ScrewDriver.instance(options);
		SdBean bean = Constant.BEAN;
		bean.addColumn(new SdColumn().setType(SdType.FLOAT).setNullable(false).setName("float_test"));
		bean.addColumn(new SdColumn().setType(SdType.DOUBLE).setLength(10, 2).setNullable(false).setName("double_test"));
		bean.addColumn(new SdColumn().setType(SdType.LONG).setNullable(false).setName("long_test"));
		screwDriver.createCode(bean,templates);

	}
}
