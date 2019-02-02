package org.mirrentools.sd.converter;

import java.util.HashMap;
import java.util.Map;

import org.mirrentools.sd.constant.Constant;
import org.mirrentools.sd.constant.MySQL;
import org.mirrentools.sd.enums.Relational;
import org.mirrentools.sd.models.SdBean;
import org.mirrentools.sd.models.SdColumn;
import org.mirrentools.sd.models.SdRelational;
import org.mirrentools.sd.models.SdTemplate;
import org.mirrentools.sd.models.SdTemplateAttribute;

/**
 * 一些测试中可能灰反复使用的类
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public class TestConstant {
	/** 用于班级的SDBean */
	public static SdBean classesBean;
	/** 用于学生的SDBean */
	public static SdBean studentBean;
	// 设置实体生成模板
	public static Map<String, SdTemplate> templates;

	static {
		initBean();
		initTemplates();
	}
	/**
	 * 初始化学生与班级bean
	 */
	private static void initBean() {
		// 初始化班级bean
		classesBean = new SdBean();
		SdColumn cc1 = new SdColumn().setName("id").setType(MySQL.INT).setRemark("班级的id").setPrimary(true).setAutoIncrement(true);
		SdColumn cc2 = new SdColumn().setName("name").setType(MySQL.VARCHAR).setRemark("班级的名字").setLength(10).setNullable(false);
		SdColumn cc3 = new SdColumn().setName("teacher_id").setType(MySQL.BIGINT).setRemark("班主任的id").setNullable(false);
		SdColumn cc4 = new SdColumn().setName("teacherName").setFieldType("String").setRemark("班主任的名字");
		classesBean.setName("classes").setRemark("班级").addColumn(cc1, cc2, cc3).addAdditionalColumn(cc4);

		// 初始化学生bean
		studentBean = new SdBean();
		SdColumn column = new SdColumn().setName("id").setType(MySQL.BIGINT).setPrimary(true).setAutoIncrement(true).setRemark("学生的id");
		SdColumn column2 = new SdColumn().setName("name").setType(MySQL.VARCHAR).setNullable(false).setLength("30").setRemark("学生的名字");
		SdColumn column3 = new SdColumn().setName("age").setType(MySQL.INT).setNullable(false).setRemark("学生的年龄");
		SdColumn column4 = new SdColumn().setName("age").setType(MySQL.INT).setRemark("学生的年龄");
		SdColumn column5 = new SdColumn().setName("mobile_phone").setType(MySQL.VARCHAR).setNullable(false).setLength("30")
				.setRemark("学生的手机号码");
		column5.setIndex(true).setIndexType(MySQL.INDEX_KEY).setIndexName("idx_user_mobile_phone");
		SdColumn column6 = new SdColumn().setName("classes_id").setType(MySQL.INT).setNullable(false).setRemark("班级的id");
		column6.setForeignKey(true).setForeignReferences(classesBean.getName()).setForeignConstraint("FK_classes_student_id");
		studentBean.setName("classes_student").setRemark("班级里面的学生").addColumn(column, column2, column3, column4, column5, column6);

		// 添加学生与班级的关系
		SdRelational relational = new SdRelational();
		relational.setRelationalType(Relational.ManyToOne);
		relational.addImport("org.mirrentools.entity");
		relational.setFieldRemark("学生所属的班级");
		relational.setFieldType("Classes");
		relational.setFieldName("classes");
		relational.setBean(classesBean);
		studentBean.addRelational(relational);

		// 添加班级与学生的关系
		SdRelational classesRelational = new SdRelational();
		classesRelational.setRelationalType(Relational.OneToMany);
		classesRelational.addImport("java.util.List");
		classesRelational.setFieldRemark("当前班级里面的所有学生");
		classesRelational.setFieldType("List<ClassesStudent>");
		classesRelational.setFieldName("students");
		classesRelational.setBean(studentBean);
		classesBean.addRelational(classesRelational);
	}
	/**
	 * 初始化模板工具
	 */
	private static void initTemplates() {
		templates = new HashMap<String, SdTemplate>();
		SdTemplate entity = new SdTemplate().setFile("entity.ftl").setSourceFolder(Constant.MAVEN_SRC).setPackageName("entity")
				.setClassName("User");
		templates.put("entity", entity);
		SdTemplate dao = new SdTemplate().setFile("dao.ftl").setSourceFolder(Constant.MAVEN_SRC).setPackageName("dao").setClassName("UserDao");
		dao.addAttribute(new SdTemplateAttribute("test", "{c}{p}", "测试驼峰与帕斯卡还有下划线{u},连字符{h}"));
		templates.put("dao", dao);
	}

}
