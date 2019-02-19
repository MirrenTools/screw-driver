package org.mirrentools.sd.converter;

import java.util.HashMap;
import java.util.Map;

import org.mirrentools.sd.constant.Constant;
import org.mirrentools.sd.constant.MySQL;
import org.mirrentools.sd.converter.impl.mysql.SdClassConverterImplByMySQL;
import org.mirrentools.sd.enums.Relational;
import org.mirrentools.sd.models.SdBean;
import org.mirrentools.sd.models.SdClassContent;
import org.mirrentools.sd.models.SdColumn;
import org.mirrentools.sd.models.SdRelational;
import org.mirrentools.sd.models.SdTemplate;
import org.mirrentools.sd.models.SdTemplateAttribute;
import org.mirrentools.sd.models.db.query.SdTable;
import org.mirrentools.sd.models.db.query.SdTableAttribute;
import org.mirrentools.sd.models.db.query.SdTableColumnAttribute;
import org.mirrentools.sd.models.db.query.SdTableIndexKeyAttribute;
import org.mirrentools.sd.models.db.query.SdTablePortedKeysAttribute;
import org.mirrentools.sd.models.db.query.SdTablePrimaryKeyAttribute;
import org.mirrentools.sd.options.SdDatabaseOptions;

/**
 * 一些测试中可能灰反复使用的类
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public class TestConstant {
	/** 班级的SDBean */
	public static SdBean classesBean;
	/** 班级的内容 */
	public static SdClassContent classesBeanContent;
	/** 学生的SDBean */
	public static SdBean studentBean;
	/** 学生的SDBean */
	public static SdBean multireferenceBean;
	/** 学生的内容 */
	public static SdClassContent studentBeanContent;
	// 设置实体生成模板
	public static Map<String, SdTemplate> templates;
	// 数据库配置文件
	public static SdDatabaseOptions databaseOptions;
	// 数据库配置文件
	public static SdTable studentTable;

	static {
		initBean();
		initClassContent();
		initTemplates();
		initDatabaseOptions();
		initTable();
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
		SdColumn column2 = new SdColumn().setName("name").setType(MySQL.VARCHAR).setNullable(false).setLength(30).setRemark("学生的名字");
		SdColumn column3 = new SdColumn().setName("age").setUnsigned(true).setType(MySQL.INT).setNullable(false).setRemark("学生的年龄");
		SdColumn column4 = new SdColumn().setName("email").setType(MySQL.INT).setRemark("学生的邮箱");
		SdColumn column5 = new SdColumn().setName("mobile_phone").setType(MySQL.VARCHAR).setDefault("0086").setNullable(false).setLength(30)
				.setRemark("学生的手机号码");
		column5.setIndexType(MySQL.INDEX_KEY).setIndexName("idx_user_mobile_phone");
		SdColumn column6 = new SdColumn().setName("classes_id").setType(MySQL.INT).setNullable(false).setRemark("班级的id");
		column6.setForeignReferencesTable(classesBean.getName()).setForeignReferencesColumn(cc1.getName())
				.setForeignConstraint("FK_classes_student_id");
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

		// 初始化多引用的SdBean
		multireferenceBean = new SdBean();
		SdColumn mc1 = new SdColumn().setName("primary_key_1").setType(MySQL.INT).setRemark("复合主键").setPrimary(true).setAutoIncrement(true);
		SdColumn mc2 = new SdColumn().setName("primary_key_2").setType(MySQL.INT).setRemark("复合主键").setPrimary(true).setAutoIncrement(true);
		SdColumn mc3 = new SdColumn().setName("index_key_1").setType(MySQL.INT).setRemark("复合索引").setIndexName("UK_index_key_1_2")
				.setIndexType(MySQL.INDEX_KEY);
		SdColumn mc4 = new SdColumn().setName("index_key_2").setType(MySQL.INT).setRemark("复合索引").setIndexName("UK_index_key_1_2")
				.setIndexType(MySQL.INDEX_KEY);
		SdColumn mc5 = new SdColumn().setName("index_key_single").setType(MySQL.INT).setRemark("单独的索引").setIndexName("index_key_single")
				.setIndexRemark("testIndexKeyRemark").setIndexType(MySQL.INDEX_KEY);
		SdColumn mc6 = new SdColumn().setName("foreign_key_1").setType(MySQL.INT).setRemark("复合外键").setForeignConstraint("FK_foreig_key_1_2")
				.setForeignReferencesTable("test");
		SdColumn mc7 = new SdColumn().setName("foreign_key_2").setType(MySQL.INT).setRemark("复合外键").setForeignConstraint("FK_foreig_key_1_2")
				.setForeignReferencesTable("test");
		SdColumn mc8 = new SdColumn().setName("foreign_key_single").setType(MySQL.INT).setRemark("单独的外键")
				.setForeignConstraint("FK_foreig_key_single").setForeignReferencesTable("test");
		multireferenceBean.setName("multi_reference");
		multireferenceBean.addColumn(mc1, mc2, mc3, mc4, mc5, mc6, mc7, mc8);
	}

	/**
	 * 初始化内容
	 */
	private static void initClassContent() {
		SdClassConverter converter = new SdClassConverterImplByMySQL();
		classesBeanContent = converter.converter(classesBean);
		studentBeanContent = converter.converter(studentBean);
	}

	/**
	 * 初始化模板工具
	 */
	private static void initTemplates() {
		templates = new HashMap<String, SdTemplate>();
		SdTemplate entity = new SdTemplate().setFile("entity.ftl").setSourceFolder(Constant.MAVEN_TEST).setPackageName("com.entity")
				.setClassName("User");
		templates.put("entity", entity);
		SdTemplate dao = new SdTemplate().setFile("dao.ftl").setSourceFolder(Constant.MAVEN_TEST).setPackageName("com.dao")
				.setClassName("UserDao");
		dao.addAttribute(new SdTemplateAttribute("test", "{c}{p}", "测试驼峰与帕斯卡还有下划线{u},连字符{h}"));
		templates.put("dao", dao);
	}
	/**
	 * 初始化数据库配置
	 */
	private static void initDatabaseOptions() {
		databaseOptions = new SdDatabaseOptions(MySQL.MYSQL_8_DERVER,
				"jdbc:mysql://localhost:3306/root?useUnicode=true&useSSL=false&characterEncoding=UTF-8&serverTimezone=UTC");
		databaseOptions.setUser("root");
		databaseOptions.setPassword("root");
		databaseOptions.setLoginTimeout(10);
	}
	/**
	 * 初始化表
	 */
	private static void initTable() {
		studentTable = new SdTable();
		String tableName = "classes_student";

		studentTable.setInfo(new SdTableAttribute().setTableName(tableName).setRemarks("学生表"));
		SdTableColumnAttribute c1 = new SdTableColumnAttribute().setColumnName("id").setTypeName(MySQL.BIGINT).setAutoincrement("YES")
				.setRemarks("学生的id");
		SdTableColumnAttribute c2 = new SdTableColumnAttribute().setColumnName("name").setTypeName(MySQL.VARCHAR).setColumnSize(30)
				.setNullable(1).setRemarks("学生的id");
		SdTableColumnAttribute c3 = new SdTableColumnAttribute().setColumnName("mobile_phone").setTypeName(MySQL.VARCHAR).setColumnDef("0086")
				.setColumnSize(30).setNullable(1).setRemarks("学生的手机号码");
		SdTableColumnAttribute c4 = new SdTableColumnAttribute().setColumnName("classes_id").setTypeName(MySQL.INT)
				.setRemarks("班级的id");
		studentTable.addColumn(c1).addColumn(c2).addColumn(c3).addColumn(c4);
		studentTable.setPrimaryKey(new SdTablePrimaryKeyAttribute().setColumnName("id").setPkName("Primary").setTableName(tableName));
		studentTable.addIndexKey(
				new SdTableIndexKeyAttribute().setTableName(tableName).setColumnName("mobile_phone").setIndexName("idx_user_mobile_phone"));
		studentTable.addForeignKey(new SdTablePortedKeysAttribute().setFktableCat("root").setFktableName("classes").setFkName("classes_id")
				.setFkName("FK_classes_student_id").setFkcolumnName("classes_id"));
	}
}
