package org.mirrentools.sd.converter;

import org.mirrentools.sd.models.SdBean;
import org.mirrentools.sd.models.db.query.SdTable;

/**
 * 将SdTable转换为SdBean的转换器
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public interface SdBeanConverter {
	/**
	 * 转换属性
	 * 
	 * @param table
	 * @return
	 */
	SdBean converter(SdTable table);
	/**
	 * 获取数据类型转换器
	 * 
	 * @return
	 */
	SdTypeConverter getTypeConverter();
	/**
	 * 设置数据类型转换器
	 * 
	 * @param typeConverter
	 * @return
	 */
	SdBeanConverter setTypeConverter(SdTypeConverter typeConverter);
}
