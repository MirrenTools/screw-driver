package org.mirrentools.sd.converter.impl.postgresql;

import org.mirrentools.sd.converter.SdBasicTableToClassConverter;
import org.mirrentools.sd.converter.SdClassConverter;

/**
 * 将SdTable转换为SdClassContent的转换器的PostgreSql版
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public class SdTableToClassConverterPostgreSqlImpl extends SdBasicTableToClassConverter {

	public SdTableToClassConverterPostgreSqlImpl() {
		super(new SdClassConverterPostgreSqlImpl());
	}

	public SdTableToClassConverterPostgreSqlImpl(SdClassConverter classConverter) {
		super(classConverter);
	}

}
