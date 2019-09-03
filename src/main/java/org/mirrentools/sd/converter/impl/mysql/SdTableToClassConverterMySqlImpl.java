package org.mirrentools.sd.converter.impl.mysql;

import org.mirrentools.sd.converter.SdBasicTableToClassConverter;
import org.mirrentools.sd.converter.SdClassConverter;

/**
 * 将SdTable转换为SdClassContent的转换器的PostgreSql版
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public class SdTableToClassConverterMySqlImpl extends SdBasicTableToClassConverter {
	public SdTableToClassConverterMySqlImpl() {
		super(new SdClassConverterMySqlImpl());
	}

	public SdTableToClassConverterMySqlImpl(SdClassConverter classConverter) {
		super(classConverter);
	}

}
