package org.mirrentools.sd.converter.impl.db2;

import org.mirrentools.sd.converter.SdBasicTableToClassConverter;
import org.mirrentools.sd.converter.SdClassConverter;

public class SdTableToClassConverterDB2Impl extends SdBasicTableToClassConverter {

	/**
	 * 实例化一个默认的类型转换
	 */
	public SdTableToClassConverterDB2Impl() {
		super(new SdClassConverterDB2Impl());
	}

	/**
	 * 实例化一个指定类转换器
	 * 
	 * @param classConverter
	 */
	public SdTableToClassConverterDB2Impl(SdClassConverter classConverter) {
		super(classConverter);
	}

}
