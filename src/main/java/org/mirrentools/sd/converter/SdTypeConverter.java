package org.mirrentools.sd.converter;

import java.util.Map;

/**
 * 数据类型转换用于将不同语言之间的转换,比如SQL数据类型转换为Java数据类型,或反过来
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public interface SdTypeConverter {
	/**
	 * 将类型进行转换,如果不存在转换类型就返回基类
	 * 
	 * @param type
	 *          SQL数据类型
	 * @return
	 */
	String converter(String type);
	/**
	 * 将类型进行转换,并设置不存在的默认值
	 * 
	 * @param type
	 *          SQL数据类型
	 * @param defaultt
	 *          如果词典中没有找到该类型对应的值就返回 defaultt
	 * @return
	 */
	String converter(String type, String defaultt);

	/**
	 * 获取类型集,key为SQL的数据类型,value为类的数据类型
	 * 
	 * @return
	 */
	Map<String, String> getDict();
	/**
	 * 添加类型集,如果key已经存在将其覆盖
	 * 
	 * @param key
	 *          SQL的数据类型
	 * @param value
	 *          类的数据类型
	 * @return
	 */
	SdTypeConverter putDict(String key, String value);
	/**
	 * 设置类型集
	 * 
	 * @param type
	 *          key为SQL的数据类型,value为类的数据类型
	 * @return
	 */
	SdTypeConverter setDict(Map<String, String> typeMaps);

}
