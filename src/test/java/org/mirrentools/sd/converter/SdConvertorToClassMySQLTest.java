package org.mirrentools.sd.converter;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mirrentools.sd.converter.impl.mysql.SdBeanConverterToClassImplByMySQL;
import org.mirrentools.sd.models.SdBean;
import org.mirrentools.sd.models.SdClassContent;
import org.mirrentools.sd.models.SdColumn;
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
	/** 用于班级的SDBean */
	private SdBean classesBean;
	/** 用于学生的SDBean */
	private SdBean studentBean;
	@Before
	public void setUp() {
		converter = new SdBeanConverterToClassImplByMySQL();
		classesBean = TestConstant.classesBean;
		studentBean = TestConstant.studentBean;
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
	public void testRelationalAdditional() {
		SdClassContent classesContent = converter.converter(classesBean);
		assertEquals(1, classesContent.getAdditionalField().size());
		SdColumn column = classesContent.getAdditionalField().get(0);
		assertEquals("teacherName", column.getFieldName());
		assertEquals("String", column.getFieldType());
		assertEquals("班主任的名字", column.getFieldRemark());
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
