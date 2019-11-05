package org.mirrentools.sd.converter.impl.postgresql;

import org.mirrentools.sd.SdType;
import org.mirrentools.sd.constant.Java;
import org.mirrentools.sd.converter.SdBasicClassConverter;
import org.mirrentools.sd.converter.SdBasicTypeConverter;
import org.mirrentools.sd.converter.SdTypeConverter;
import org.mirrentools.sd.enums.SdTypeMode;

/**
 * SdBean转换器转换为Java类属性PostgreSql版实现
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class SdClassConverterPostgreSqlImpl extends SdBasicClassConverter {

	public SdClassConverterPostgreSqlImpl() {
		super(new SdBasicTypeConverter(Java.OBJECT, SdType.getDictionary(SdTypeMode.JAVA)));
	}

	public SdClassConverterPostgreSqlImpl(SdTypeConverter typeConverter) {
		super(typeConverter);
	}

}
