package org.mirrentools.sd.converter.impl.db2;

import org.mirrentools.sd.SdType;
import org.mirrentools.sd.constant.Java;
import org.mirrentools.sd.converter.SdBasicClassConverter;
import org.mirrentools.sd.converter.SdBasicTypeConverter;
import org.mirrentools.sd.converter.SdTypeConverter;
import org.mirrentools.sd.enums.SdTypeMode;

public class SdClassConverterDB2Impl  extends SdBasicClassConverter {

	/**
	 * 使用默认的SQL数据类型转换器初始化
	 */
	public SdClassConverterDB2Impl() {
		super(new SdBasicTypeConverter(Java.OBJECT, SdType.getDictionary(SdTypeMode.JAVA)));
	}
	/**
	 * 使用自定义的SQL转实体类转换器初始化
	 * 
	 * @param typeConverter
	 */
	public SdClassConverterDB2Impl(SdTypeConverter typeConverter) {
		super(typeConverter);
	}

}
