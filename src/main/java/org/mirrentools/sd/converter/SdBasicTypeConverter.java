package org.mirrentools.sd.converter;

import java.util.HashMap;
import java.util.Map;

import org.mirrentools.sd.common.SdUtil;

/**
 * 数据类型转换的基本实现
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class SdBasicTypeConverter extends SdAbstractTypeConverter {
	/** 数据类型对应的字典 */
	private Map<String, String> dictionaryMap = new HashMap<String, String>();

	/**
	 * 初始化
	 * 
	 * @param baseType
	 *          基础数据类型,既如果dictionary中找不到时就使用该类型
	 * @param dictionary
	 *          数据类型对应的字典
	 */
	public SdBasicTypeConverter(String baseType, Map<String, String> dictionary) {
		super(baseType);
		SdUtil.requireNonNull(dictionary, "The dictionary cannot be null");
		this.dictionaryMap = dictionary;
	}

	@Override
	public Map<String, String> getDict() {
		return dictionaryMap;
	}

	@Override
	public SdTypeConverter setDict(Map<String, String> typeMaps) {
		this.dictionaryMap = typeMaps;
		return this;
	}

}
