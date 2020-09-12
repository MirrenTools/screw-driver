package org.mirrentools.sd;

import java.util.HashMap;
import java.util.Map;

import org.mirrentools.sd.models.SdBean;
import org.mirrentools.sd.models.SdColumn;
import org.mirrentools.sd.models.SdTemplate;
import org.mirrentools.sd.options.ScrewDriverOptions;

public class ScrewDriverCreateCodeOnlyExample {

	public static void main(String[] args) throws Exception {
		// 创建一个实体描述
		SdBean bean = new SdBean();
		bean.setName("user").setRemark("用户");
		bean.addColumn(new SdColumn().setName("id").setType(SdType.LONG).setPrimary(true).setRemark("用户的id"));
		bean.addColumn(new SdColumn().setName("name").setType(SdType.STRING).setLength(30).setRemark("用户的名字"));
		bean.addColumn(new SdColumn().setName("pwd").setType(SdType.STRING).setLength(60).setRemark("用户的的密码"));

		// 设置实体生成模板
		Map<String, SdTemplate> templates = new HashMap<String, SdTemplate>();
		templates.put("entity", new SdTemplate().setFile("JavaEntity.ftl").setPackageName("entity").setClassName("User"));

		// 初始化执行工具
		ScrewDriver screwDriver = ScrewDriver.instance(new ScrewDriverOptions());
		// 创建代码
		screwDriver.createCode(bean,templates);
				
	}

}
