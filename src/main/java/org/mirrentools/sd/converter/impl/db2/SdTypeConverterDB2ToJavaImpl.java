package org.mirrentools.sd.converter.impl.db2;

import java.util.Map;

import org.mirrentools.sd.common.SdUtil;
import org.mirrentools.sd.constant.DB2AndJavaTypeDictionary;
import org.mirrentools.sd.constant.Java;
import org.mirrentools.sd.converter.SdAbstractTypeConverter;

public class SdTypeConverterDB2ToJavaImpl  extends SdAbstractTypeConverter{
	/** 数据类型 */
	private Map<String, String> dict;

	/**
	 * 使用默认的类型转换初始化一个实例
	 */
	public SdTypeConverterDB2ToJavaImpl() {
		super(Java.OBJECT);
		dict = DB2AndJavaTypeDictionary.POSTGRESQL_JAVA;
	}

	/**
	 * 使用自定义的类型转换初始化一个实例,
	 * 
	 * @param dict
	 *          key=SQL类型,value=java数据类型
	 */
	public SdTypeConverterDB2ToJavaImpl(Map<String, String> dict) {
		super(Java.OBJECT);
		SdUtil.requireNonNull(dict);
		this.dict = dict;
	}

	@Override
	public Map<String, String> getDict() {
		return dict;
	}

	@Override
	public SdTypeConverterDB2ToJavaImpl setDict(Map<String, String> dict) {
		this.dict = dict;
		return this;
	}
}
