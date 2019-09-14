package org.mirrentools.sd.converter.impl.sqlite;

import org.mirrentools.sd.constant.Java;
import org.mirrentools.sd.constant.SdType;
import org.mirrentools.sd.converter.SdBasicClassConverter;
import org.mirrentools.sd.converter.SdBasicTypeConverter;
import org.mirrentools.sd.converter.SdTypeConverter;
import org.mirrentools.sd.enums.SdTypeMode;

/**
 * SdBean转换器转换为Java类属性SQLite版实现
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class SdClassConverterSqliteImpl extends SdBasicClassConverter {

	public SdClassConverterSqliteImpl() {
		super(new SdBasicTypeConverter(Java.OBJECT, SdType.getDictionary(SdTypeMode.JAVA)));
	}

	public SdClassConverterSqliteImpl(SdTypeConverter typeConverter) {
		super(typeConverter);
	}

}
