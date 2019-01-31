package org.mirrentools.sd.converter;

import java.util.HashMap;

/**
 * 数据类型转换的抽象实现
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public abstract class SdAbstractTypeConverter implements SdTypeConverter {
	/** 基类的数据类型 */
	private String baseType;

	public SdAbstractTypeConverter(String baseType) {
		super();
		this.baseType = baseType;
	}

	@Override
	public String converter(String type) {
		String result = getDict().get(type);
		return result == null ? baseType : result;
	}

	@Override
	public String converter(String type, String defaultt) {
		String result = getDict().get(type);
		return result == null ? defaultt : result;
	}

	@Override
	public SdAbstractTypeConverter putDict(String key, String value) {
		if (getDict() == null) {
			setDict(new HashMap<String, String>());
		}
		getDict().put(key, value);
		return this;
	}

}
