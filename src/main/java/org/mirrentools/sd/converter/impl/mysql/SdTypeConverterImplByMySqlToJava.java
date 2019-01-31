package org.mirrentools.sd.converter.impl.mysql;

import java.util.Map;
import java.util.Objects;

import org.mirrentools.sd.constant.Java;
import org.mirrentools.sd.constant.MySqlAndJavaTypeDictionary;
import org.mirrentools.sd.converter.SdAbstractTypeConverter;

/**
 * MySQL数据库类型转换为java数据类型
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public class SdTypeConverterImplByMySqlToJava extends SdAbstractTypeConverter {
	/** 数据类型 */
	private Map<String, String> dict;
	/**
	 * 使用默认的类型转换初始化一个实例
	 */
	public SdTypeConverterImplByMySqlToJava() {
		super(Java.OBJECT);
		dict = MySqlAndJavaTypeDictionary.MYSQL_JAVA;
	}
	/**
	 * 使用自定义的类型转换初始化一个实例,
	 * 
	 * @param dict
	 *          key=SQL类型,value=java数据类型
	 */
	public SdTypeConverterImplByMySqlToJava(Map<String, String> dict) {
		super(Java.OBJECT);
		Objects.requireNonNull(dict);
		this.dict = dict;
	}

	@Override
	public Map<String, String> getDict() {
		return dict;
	}

	@Override
	public SdTypeConverterImplByMySqlToJava setDict(Map<String, String> dict) {
		this.dict = dict;
		return this;
	}

}
