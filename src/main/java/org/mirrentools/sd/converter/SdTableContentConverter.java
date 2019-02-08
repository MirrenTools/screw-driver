package org.mirrentools.sd.converter;

import java.util.Map;

import org.mirrentools.sd.models.SdBean;
import org.mirrentools.sd.models.db.update.SdAbstractTableContent;

/**
 * 将SdBean转换为数据库表的操作属性
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public interface SdTableContentConverter {

	/**
	 * 转换属性
	 * 
	 * @param bean
	 * @return
	 */
	SdAbstractTableContent converter(SdBean bean);

	/**
	 * 获取字符集
	 * 
	 * @return
	 */
	String getCharacterSet();

	/**
	 * 设置字符集
	 * 
	 * @param characterSet
	 * @return
	 */
	SdTableContentConverter setCharacterSet(String characterSet);

	/**
	 * 获取排序规则
	 * 
	 * @return
	 */
	String getCollate();

	/**
	 * 设置数据库排序规则
	 * 
	 * @param collate
	 * @return
	 */
	SdTableContentConverter setCollate(String collate);

	/**
	 * 获取拓展属性
	 * 
	 * @return
	 */
	Map<String, Object> getExtensions();

	/**
	 * 获取拓展属性值
	 * 
	 * @param key
	 * @return
	 */
	Object getExtension(String key);

	/**
	 * 添加拓展属性
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	SdTableContentConverter putExtension(String key, Object value);

	/**
	 * 设置拓展属性
	 * 
	 * @param extensions
	 * @return
	 */
	SdTableContentConverter setExtensions(Map<String, Object> extensions);
}
