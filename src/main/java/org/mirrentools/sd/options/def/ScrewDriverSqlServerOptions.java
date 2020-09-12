package org.mirrentools.sd.options.def;

import org.mirrentools.sd.converter.impl.SdTemplateContentConverterDefaultImpl;
import org.mirrentools.sd.converter.impl.sqlite.SdTableToClassConverterSqliteImpl;
import org.mirrentools.sd.converter.impl.sqlserver.SdClassConverterSqlServerImpl;
import org.mirrentools.sd.converter.impl.sqlserver.SdTableContentConverterSqlServerImpl;
import org.mirrentools.sd.impl.ScrewDriverTemplateFreeMarkerImpl;
import org.mirrentools.sd.impl.dbutil.SdDbUtilSqlServerImpl;
import org.mirrentools.sd.options.ScrewDriverOptions;
import org.mirrentools.sd.options.SdDatabaseOptions;

/**
 * SqlServer版配置
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class ScrewDriverSqlServerOptions extends ScrewDriverOptions {
	/**
	 * 初始化一个SqlServer版的ScrewDriver配置,用于仅生成SQL
	 * 
	 * 
	 * @param databaseOptions
	 *          数据库连接信息
	 */
	public ScrewDriverSqlServerOptions(SdDatabaseOptions databaseOptions) {
		init( databaseOptions);
	}

	/**
	 * 初始化
	 * 
	 * @param databaseOptions
	 *          数据库连接信息
	 */
	private void init(SdDatabaseOptions databaseOptions) {
		super.setDatabaseOptions(databaseOptions);
		super.setTemplateContentConverter(new SdTemplateContentConverterDefaultImpl());
		super.setTemplateEngine(new ScrewDriverTemplateFreeMarkerImpl());

		super.setBeanConverter(new SdClassConverterSqlServerImpl());

		super.setTableConverter(new SdTableContentConverterSqlServerImpl());
		super.setClassConverter(new SdTableToClassConverterSqliteImpl());
		super.setDbUtil(new SdDbUtilSqlServerImpl(databaseOptions));
	}

}
