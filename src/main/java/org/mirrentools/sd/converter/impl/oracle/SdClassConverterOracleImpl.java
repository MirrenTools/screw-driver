package org.mirrentools.sd.converter.impl.oracle;

import org.mirrentools.sd.constant.Java;
import org.mirrentools.sd.constant.SdType;
import org.mirrentools.sd.converter.SdBasicClassConverter;
import org.mirrentools.sd.converter.SdBasicTypeConverter;
import org.mirrentools.sd.converter.SdTypeConverter;
import org.mirrentools.sd.enums.SdTypeMode;

public class SdClassConverterOracleImpl  extends SdBasicClassConverter {

	/**
	 * 使用默认的SQL数据类型转换器初始化
	 */
	public SdClassConverterOracleImpl() {
		super(new SdBasicTypeConverter(Java.OBJECT, SdType.getDictionary(SdTypeMode.JAVA)));
	}
	/**
	 * 使用自定义的SQL转实体类转换器初始化
	 * 
	 * @param typeConverter
	 */
	public SdClassConverterOracleImpl(SdTypeConverter typeConverter) {
		super(typeConverter);
	}

}
