package org.mirrentools.sd.converter.impl.sqlite;

import org.mirrentools.sd.converter.SdBasicTableToClassConverter;
import org.mirrentools.sd.converter.SdClassConverter;

/**
 * 将SdTable转换为SdClassContent的转换器的SQLite版
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public class SdTableToClassConverterSqliteImpl extends SdBasicTableToClassConverter {

	public SdTableToClassConverterSqliteImpl() {
		super(new SdClassConverterSqliteImpl());
	}

	public SdTableToClassConverterSqliteImpl(SdClassConverter classConverter) {
		super(classConverter);
	}

}
