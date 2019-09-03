package org.mirrentools.sd.converter.impl.mysql;

import org.mirrentools.sd.constant.Java;
import org.mirrentools.sd.constant.SdType;
import org.mirrentools.sd.converter.SdBasicClassConverter;
import org.mirrentools.sd.converter.SdBasicTypeConverter;
import org.mirrentools.sd.converter.SdTypeConverter;
import org.mirrentools.sd.enums.SdTypeMode;

/**
 * SdBean转换器转换为为Java类属性MySQL版实现
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class SdClassConverterMySqlImpl extends SdBasicClassConverter {

	/**
	 * 使用默认的SQL数据类型转换器初始化
	 */
	public SdClassConverterMySqlImpl() {
		super(new SdBasicTypeConverter(Java.OBJECT, SdType.getDictionary(SdTypeMode.JAVA)));
	}

	/**
	 * 使用自定义的SQL转实体类转换器初始化
	 * 
	 * @param typeConverter
	 */
	public SdClassConverterMySqlImpl(SdTypeConverter typeConverter) {
		super(typeConverter);
	}

}
