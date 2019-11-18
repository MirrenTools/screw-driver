package org.mirrentools.sd.converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mirrentools.sd.constant.CommonConstant;
import org.mirrentools.sd.constant.MySqlConstant;
import org.mirrentools.sd.converter.impl.SdTemplateContentConverterDefaultImpl;
import org.mirrentools.sd.models.SdClassContent;
import org.mirrentools.sd.models.SdTemplate;
import org.mirrentools.sd.models.SdTemplateAttribute;
import org.mirrentools.sd.models.SdTemplateContent;
import org.mirrentools.sd.options.SdDatabaseOptions;

/**
 * 模板转换工具的测试
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public class SdTemplateContentConverterTest {
	/** 模板转换器 */
	private SdTemplateContentConverter converter;
	/** 模板属性 */
	private Map<String, SdTemplate> templates;
	/** 用于班级的内容 */
	private SdClassContent studentContent;
	/** 数据库配置文件 */
	private SdDatabaseOptions databaseOptions;

	@Before
	public void setUp() {
		converter = new SdTemplateContentConverterDefaultImpl();
		templates = CommonConstant.templates;
		studentContent = MySqlConstant.studentBeanContent;
		databaseOptions = MySqlConstant.databaseOptions;
	}

	@Test
	public void testConverter() {
		Map<String, SdTemplateContent> content = converter.converter(studentContent, databaseOptions, templates);
		assertEquals(2, content.size());
		SdTemplateContent dao = content.get("dao");
		assertNotNull(dao);
		assertEquals("dao.ftl", dao.getFile());
		assertEquals("com.dao", dao.getPackageName());
		assertEquals("UserDao", dao.getClassName());
		assertEquals(".java", dao.getSuffix());
		assertEquals(1, dao.getAttrs().size());
		SdTemplateAttribute attribute = dao.getAttrs().get("test");
		assertEquals("userDaoUserDao", attribute.getValue());
		assertEquals("测试驼峰与帕斯卡还有下划线user_dao,连字符user-dao", attribute.getDescribe());
	}

}
