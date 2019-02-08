package org.mirrentools.sd.util;

import java.util.Map;

import org.mirrentools.sd.converter.SdTableContentConverter;
import org.mirrentools.sd.dbutil.SdDbUtil;
import org.mirrentools.sd.models.SdBean;
import org.mirrentools.sd.options.SdDatabaseOptions;

/**
 * 数据库生成工具
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public interface SdSqlUtil {
	/**
	 * 执行生成
	 * 
	 * @return
	 */
	boolean execute();

	/**
	 * 获取创建所需要的属性
	 * 
	 * @return
	 */
	SdBean getBean();

	/**
	 * 设置创建所需要的属性
	 * 
	 * @param bean
	 * @return
	 */
	SdSqlUtil setBean(SdBean bean);

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
	SdSqlUtil setDatabaseOptions(SdDatabaseOptions dbOptions);

	/**
	 * 获取如果数据库不存在,是否创建数据库(如果支持创建)
	 * 
	 * @return
	 */
	boolean isCreateDatabase();

	/**
	 * 设置如果数据库不存在,是否创建数据库(如果支持创建)
	 * 
	 * @param createDatabase
	 * @return
	 */
	SdSqlUtil setCreateDatabase(boolean createDatabase);

	/**
	 * 获取如果数据库中已经存在该表是否修改
	 * 
	 * @return
	 */
	boolean isAlterTable();

	/**
	 * 设置如果数据库中已经存在该表是否修改
	 * 
	 * @param alterTable
	 * @return
	 */
	SdSqlUtil setAlterTable(boolean alterTable);

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
	SdSqlUtil setDbUtil(SdDbUtil dbUtil);

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
	SdSqlUtil setConverter(SdTableContentConverter converter);

	/**
	 * 添加附加属性
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	SdCodeUtil addExtension(String key, Object value);

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
	SdCodeUtil setExtensions(Map<String, Object> extensions);

}
