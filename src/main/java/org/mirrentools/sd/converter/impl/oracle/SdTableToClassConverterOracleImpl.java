package org.mirrentools.sd.converter.impl.oracle;

import org.mirrentools.sd.converter.SdBasicTableToClassConverter;
import org.mirrentools.sd.converter.SdClassConverter;

public class SdTableToClassConverterOracleImpl extends SdBasicTableToClassConverter {

	/**
	 * 实例化一个默认的类型转换
	 */
	public SdTableToClassConverterOracleImpl() {
		super(new SdClassConverterOracleImpl());
	}

	/**
	 * 实例化一个指定类转换器
	 * 
	 * @param classConverter
	 */
	public SdTableToClassConverterOracleImpl(SdClassConverter classConverter) {
		super(classConverter);
	}

}
