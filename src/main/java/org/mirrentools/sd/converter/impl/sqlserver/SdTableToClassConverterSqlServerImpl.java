package org.mirrentools.sd.converter.impl.sqlserver;

import org.mirrentools.sd.converter.SdBasicTableToClassConverter;
import org.mirrentools.sd.converter.SdClassConverter;

/**
 * 将SdTable转换为SdClassContent的转换器的PostgreSql版
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public class SdTableToClassConverterSqlServerImpl extends SdBasicTableToClassConverter {

	public SdTableToClassConverterSqlServerImpl() {
		super(new SdClassConverterSqlServerImpl());
	}

	public SdTableToClassConverterSqlServerImpl(SdClassConverter classConverter) {
		super(classConverter);
	}

}
