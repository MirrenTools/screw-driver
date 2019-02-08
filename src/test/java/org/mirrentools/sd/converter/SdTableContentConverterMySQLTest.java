package org.mirrentools.sd.converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.mirrentools.sd.constant.MySQL;
import org.mirrentools.sd.converter.impl.mysql.SdTableContentConverterImplByMySQL;
import org.mirrentools.sd.models.SdBean;
import org.mirrentools.sd.models.db.update.SdAbstractTableContent;

/**
 * 将SdBean转换为MySQL需要的表属性测试
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class SdTableContentConverterMySQLTest {
	/** 表内容文转换器 */
	private SdTableContentConverter converter;
	/** 学生的SdBean */
	private SdBean multireferenceBean;

	@Before
	public void setUp() {
		converter = new SdTableContentConverterImplByMySQL();
		multireferenceBean = TestConstant.multireferenceBean;
	}

	@Test
	public void testConverter() {
		SdAbstractTableContent content = converter.converter(multireferenceBean);
		assertEquals("multi_reference", content.getTableName());
		assertNull(content.getPrimaryKeys().getName());
		assertEquals(8, content.getColums().size());
		assertEquals(2, content.getPrimaryKeys().getColumns().size());
		assertEquals(2, content.getIndexKeys().size());
		assertEquals(MySQL.INDEX_KEY, content.getIndexKeys().get(0).getType());
		assertEquals("UK_index_key_1_2", content.getIndexKeys().get(0).getName());
		assertEquals("testIndexKeyRemark", content.getIndexKeys().get(1).getRemark());
		assertEquals(2, content.getForeignKeys().size());
		assertEquals("FK_foreig_key_single", content.getForeignKeys().get(1).getConstraint());
		assertEquals("test", content.getForeignKeys().get(1).getReferencesTable());
	}

}
