package org.mirrentools.sd.converter;

import org.mirrentools.sd.models.SdClassContent;
import org.mirrentools.sd.models.db.query.SdTable;

/**
 * 将SdTable转换为SdClassContent的转换器
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public interface SdTableToClassConverter {
	/**
	 * 转换属性
	 * 
	 * @param table
	 * @return
	 */
	SdClassContent converter(SdTable table);
	/**
	 * 获取数据类型转换器
	 * 
	 * @return
	 */
	SdClassConverter getClassConverter();
	/**
	 * 设置数据类型转换器
	 * 
	 * @param classConverter
	 * @return
	 */
	SdTableToClassConverter setClassConverter(SdClassConverter classConverter);
}
