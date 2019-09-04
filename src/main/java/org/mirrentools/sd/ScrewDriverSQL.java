package org.mirrentools.sd;

import java.util.Map;

import org.mirrentools.sd.converter.SdTableContentConverter;
import org.mirrentools.sd.dbutil.SdDbUtil;
import org.mirrentools.sd.models.SdBean;
import org.mirrentools.sd.models.SdDatabase;
import org.mirrentools.sd.options.SdDatabaseOptions;

/**
 * 数据库生成工具
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public interface ScrewDriverSQL {
	/**
	 * 创建数据库
	 * 
	 * @param database
	 *          数据库属性描述
	 * @return
	 */
	boolean createDatabase(SdDatabase database);

	/**
	 * 创建表
	 * 
	 * @param bean
	 *          表属性的描述
	 * @return
	 */
	boolean createTable(SdBean bean);

	/**
	 * 修改表
	 * 
	 * @param bean
	 *          表属性的描述
	 * @return
	 */
	boolean alterTable(SdBean bean);

	/**
	 * 删除表
	 * 
	 * @param bean
	 *          表属性的描述
	 * @return
	 */
	boolean deleteTable(SdBean bean);

	/**
	 * 获取数据库连接属性
	 * 
	 * @return
	 */
	SdDatabaseOptions getDatabaseOptions();

	/**
	 * 设置数据库连接属性
	 * 
	 * @param dbOptions
	 * @return
	 */
	ScrewDriverSQL setDatabaseOptions(SdDatabaseOptions dbOptions);

	/**
	 * 获取数据库操作工具
	 * 
	 * @return
	 */
	SdDbUtil getDbUtil();

	/**
	 * 数据库操作工具
	 * 
	 * @param dbUtil
	 * @return
	 */
	ScrewDriverSQL setDbUtil(SdDbUtil dbUtil);

	/**
	 * 获取转换器
	 * 
	 * @return
	 */
	SdTableContentConverter getConverter();

	/**
	 * 设置转换器
	 * 
	 * @param converter
	 * @return
	 */
	ScrewDriverSQL setConverter(SdTableContentConverter converter);

	/**
	 * 添加附加属性
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	ScrewDriverSQL addExtension(String key, Object value);

	/**
	 * 获取附加属性集合
	 * 
	 * @return
	 */
	Map<String, Object> getExtensions();

	/**
	 * 设置附加属性集合
	 * 
	 * @param extensions
	 * @return
	 */
	ScrewDriverSQL setExtensions(Map<String, Object> extensions);

}
