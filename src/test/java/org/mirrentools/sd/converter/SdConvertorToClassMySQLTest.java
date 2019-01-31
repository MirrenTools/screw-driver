package org.mirrentools.sd.converter;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mirrentools.sd.common.SdUtil;
import org.mirrentools.sd.constant.MySQL;
import org.mirrentools.sd.converter.SdBeanConverterToClass;
import org.mirrentools.sd.converter.impl.mysql.SdBeanConverterToClassImplByMySQL;
import org.mirrentools.sd.models.SdBean;
import org.mirrentools.sd.models.SdClassContent;
import org.mirrentools.sd.models.SdColumn;

/**
 * 将SdBean转换为MySQL需要的实体类测试
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public class SdConvertorToClassMySQLTest {
	/** 转换接口 */
	private SdBeanConverterToClass converter;
	/** 用于次数的SDBean */
	private SdBean bean;
	@Before
	public void setUp() {
		converter = new SdBeanConverterToClassImplByMySQL();
		SdBean classesBean = new SdBean();
		SdColumn cc1 = new SdColumn().setName("id").setType(MySQL.INT).setRemark("班级的id").setPrimary(true).setAutoIncrement(true);
		SdColumn cc2 = new SdColumn().setName("name").setType(MySQL.VARCHAR).setRemark("班级的名字").setLength(10).setNullable(false);
		SdColumn cc3 = new SdColumn().setName("teacher_id").setType(MySQL.BIGINT).setRemark("班主任的id").setNullable(false);
		classesBean.setName("classes").setRemark("班级").addColumn(cc1, cc2, cc3);

		bean = new SdBean();
		SdColumn column = new SdColumn().setName("id").setType(MySQL.BIGINT).setPrimary(true).setAutoIncrement(true).setRemark("用户的id");
		SdColumn column2 = new SdColumn().setName("name").setType(MySQL.VARCHAR).setLength("30").setRemark("用户的名字");
		SdColumn column3 = new SdColumn().setName("age").setType(MySQL.INT).setRemark("用户的年龄");
		SdColumn column4 = new SdColumn().setName("mobile_phone").setType(MySQL.VARCHAR).setNullable(false).setLength("30")
				.setRemark("用户的手机号码");
		column4.setIndex(true).setIndexType(MySQL.INDEX_KEY).setIndexName("idx_user_mobile_phone");
		SdColumn column5 = new SdColumn().setName("classes_id").setType(MySQL.INT).setNullable(false).setRemark("班级的id");
		bean.setName("user_student").setRemark("用户").setColumns(SdUtil.asList(column, column2, column3, column4, column5));

	}
	@Test
	public void testConverter() {
		SdClassContent content = converter.converter(bean);
		assertEquals("user_student", content.getTableName());
		assertEquals("user_student", content.getUnderScoreName());
		assertEquals("user-student", content.getHyphenName());
		assertEquals("userStudent", content.getCamelName());
		assertEquals("UserStudent", content.getPascalName());
		assertEquals(5, content.getFields().size());
		assertEquals(1, content.getPrimaryField().size());
		assertEquals(1, content.getIndexField().size());
		assertEquals(3, content.getCantNullField().size());
		assertEquals(2, content.getOtherField().size());
		System.out.println(content);
	}
}
