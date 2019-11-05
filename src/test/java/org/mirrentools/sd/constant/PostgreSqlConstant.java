package org.mirrentools.sd.constant;

import org.mirrentools.sd.SdType;
import org.mirrentools.sd.converter.SdClassConverter;
import org.mirrentools.sd.converter.impl.mysql.SdClassConverterMySqlImpl;
import org.mirrentools.sd.enums.Relational;
import org.mirrentools.sd.models.SdBean;
import org.mirrentools.sd.models.SdClassContent;
import org.mirrentools.sd.models.SdColumn;
import org.mirrentools.sd.models.SdRelational;
import org.mirrentools.sd.models.SdSequence;
import org.mirrentools.sd.options.SdDatabaseOptions;

/**
 * 一些测试中可能灰反复使用的类
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public class PostgreSqlConstant {

	/** 班级的SDBean */
	public static SdBean classesBean;
	/** 班级的内容 */
	public static SdClassContent classesBeanContent;
	/** 学生的SDBean */
	public static SdBean studentBean;
	/** 学生的内容 */
	public static SdClassContent studentBeanContent;

	/** 数据库配置文件 */
	public static SdDatabaseOptions databaseOptions;

	static {
		initBean();
		initClassContent();
		databaseOptions = new SdDatabaseOptions(PostgreSQL.POSTGRE_SQL_DERVER, "jdbc:postgresql://localhost:5432/item");
		databaseOptions.setUser("postgres");
		databaseOptions.setPassword("root");
	}

	/**
	 * 初始化学生与班级bean
	 */
	private static void initBean() {
		// 初始化班级bean
		classesBean = new SdBean();
		SdColumn cc1 = new SdColumn().setName("id").setType(SdType.INTEGER).setRemark("班级的id").setPrimary(true);
		SdColumn cc2 = new SdColumn().setName("name").setType(SdType.STRING).setRemark("班级的名字").setLength(10).setNullable(false);
		SdColumn cc3 = new SdColumn().setName("teacher_id").setType(SdType.LONG).setRemark("班主任的id").setNullable(false);
		SdColumn cc4 = new SdColumn().setName("teacherName").setFieldType(SdType.STRING).setRemark("班主任的名字");
		classesBean.setName("classes").setRemark("班级").addColumn(cc1, cc2, cc3).addAdditionalColumn(cc4);

		// 初始化班级用的序列
		SdSequence sequence = new SdSequence();
		sequence.setName("seq_classes_id").setMinValue(1001L);
		classesBean.addSequence(sequence);

		// 初始化学生bean
		studentBean = new SdBean();
		SdColumn column = new SdColumn().setName("id").setType(SdType.LONG).setPrimary(true).setAutoIncrement(true).setRemark("学生的id");
		SdColumn column2 = new SdColumn().setName("name").setType(SdType.STRING).setNullable(false).setLength(30).setRemark("学生的名字");
		SdColumn column3 = new SdColumn().setName("age").setUnsigned(true).setType(SdType.INTEGER).setNullable(false).setRemark("学生的年龄");
		SdColumn column4 = new SdColumn().setName("email").setType(SdType.INTEGER).setRemark("学生的邮箱");
		SdColumn column5 = new SdColumn().setName("mobile_area").setType(SdType.STRING).setDefault("0086").setNullable(false).setLength(30).setRemark("学生的手机区号");
		SdColumn column6 = new SdColumn().setName("mobile_phone").setType(SdType.STRING).setNullable(false).setLength(30).setRemark("学生的手机号码");
		column5.setUnique(true).setIndexType(PostgreSQL.INDEX_BTREE).setIndexName("idx_user_mobile_phone");
		column6.setUnique(true).setIndexRemark("测试注释").setIndexType(PostgreSQL.INDEX_BTREE).setIndexName("idx_user_mobile_phone");
		SdColumn column7 = new SdColumn().setName("classes_id").setType(SdType.INTEGER).setNullable(false).setRemark("班级的id");
		column7.setForeignReferencesTable(classesBean.getName()).setForeignReferencesColumn(cc1.getName()).setForeignConstraint("FK_classes_student_id");
		studentBean.setName("classes_student").setRemark("班级里面的学生").addColumn(column, column2, column3, column4, column5, column6, column7);

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
	 * 初始化内容
	 */
	private static void initClassContent() {
		SdClassConverter converter = new SdClassConverterMySqlImpl();
		classesBeanContent = converter.converter(classesBean);
		studentBeanContent = converter.converter(studentBean);
	}

}
