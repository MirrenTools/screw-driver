package org.mirrentools.sd.converter;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mirrentools.sd.constant.MySQL;
import org.mirrentools.sd.converter.impl.mysql.SdBeanConverterToClassImplByMySQL;
import org.mirrentools.sd.enums.Relational;
import org.mirrentools.sd.models.SdBean;
import org.mirrentools.sd.models.SdClassContent;
import org.mirrentools.sd.models.SdColumn;
import org.mirrentools.sd.models.SdRelational;
import org.mirrentools.sd.models.SdRelationalContent;

/**
 * 将SdBean转换为MySQL需要的实体类测试
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public class SdConvertorToClassMySQLTest {
	/** 转换接口 */
	private SdBeanConverterToClass converter;
	/** 用于次数的班级的Bean */
	private SdBean classesBean;
	/** 用于次数的SDBean */
	private SdBean studentBean;
	@Before
	public void setUp() {
		converter = new SdBeanConverterToClassImplByMySQL();
		// 初始化班级bean
		classesBean = new SdBean();
		SdColumn cc1 = new SdColumn().setName("id").setType(MySQL.INT).setRemark("班级的id").setPrimary(true).setAutoIncrement(true);
		SdColumn cc2 = new SdColumn().setName("name").setType(MySQL.VARCHAR).setRemark("班级的名字").setLength(10).setNullable(false);
		SdColumn cc3 = new SdColumn().setName("teacher_id").setType(MySQL.BIGINT).setRemark("班主任的id").setNullable(false);
		classesBean.setName("classes").setRemark("班级").addColumn(cc1, cc2, cc3);

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
	@Test
	public void testConverter() {
		SdClassContent content = converter.converter(studentBean);
		assertEquals("classes_student", content.getTableName());
		assertEquals("classes_student", content.getUnderScoreName());
		assertEquals("classes-student", content.getHyphenName());
		assertEquals("classesStudent", content.getCamelName());
		assertEquals("ClassesStudent", content.getPascalName());
		assertEquals(6, content.getFields().size());

		assertEquals(1, content.getPrimaryField().size());
		assertEquals(1, content.getForeignField().size());
		assertEquals(1, content.getIndexField().size());
		assertEquals(3, content.getOtherField().size());
		assertEquals(5, content.getCantNullField().size());
	}

	@Test
	public void testRelationalSizeAndCount() {
		SdClassContent content = converter.converter(classesBean);
		assertEquals(1, content.getRelationals().size());
		SdClassContent content1 = content.getRelationals().get(0).getClassContent();
		assertEquals(1, content1.getRelationals().size());
		SdClassContent content2 = content1.getRelationals().get(0).getClassContent();
		assertEquals(1, content2.getRelationals().size());
		SdClassContent content3 = content2.getRelationals().get(0).getClassContent();
		assertEquals(1, content3.getRelationals().size());
		SdClassContent content4 = content3.getRelationals().get(0).getClassContent();
		assertEquals(null, content4.getRelationals());
	}
	@Test
	public void testRelational() {
		SdClassContent content = converter.converter(classesBean);
		assertEquals(1, content.getRelationals().size());
		// 获取关系的名称是不是学生类并检查学生类的关系对应的是否班级
		SdRelationalContent content1 = content.getRelationals().get(0);
		assertEquals("students", content1.getFieldName());
		assertEquals("List<ClassesStudent>", content1.getFieldType());
		SdRelationalContent content2 = content1.getClassContent().getRelationals().get(0);
		assertEquals("classes", content2.getFieldName());
		assertEquals("Classes", content2.getFieldType());
		SdRelationalContent content3 = content2.getClassContent().getRelationals().get(0);
		assertEquals("students", content3.getFieldName());
		assertEquals("List<ClassesStudent>", content3.getFieldType());
	}
}
