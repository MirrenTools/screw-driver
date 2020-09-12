package org.mirrentools.sd.options.def;

import org.mirrentools.sd.converter.impl.SdTemplateContentConverterDefaultImpl;
import org.mirrentools.sd.converter.impl.db2.SdClassConverterDB2Impl;
import org.mirrentools.sd.converter.impl.db2.SdTableContentConverterDB2Impl;
import org.mirrentools.sd.converter.impl.db2.SdTableToClassConverterDB2Impl;
import org.mirrentools.sd.impl.ScrewDriverTemplateFreeMarkerImpl;
import org.mirrentools.sd.impl.dbutil.SdDbUtilDB2Impl;
import org.mirrentools.sd.options.ScrewDriverOptions;
import org.mirrentools.sd.options.SdDatabaseOptions;

/**
 * DB2版配置
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class ScrewDriverDB2Options extends ScrewDriverOptions {
	/**
	 * 初始化一个DB2版的ScrewDriver配置,用于仅生成SQL
	 * 
	 * @param databaseOptions 数据库连接信息
	 */
	public ScrewDriverDB2Options(SdDatabaseOptions databaseOptions) {
		init(databaseOptions);
	}

	/**
	 * 初始化
	 * 
	 * @param databaseOptions 数据库连接信息
	 */
	private void init(SdDatabaseOptions databaseOptions) {
		super.setDatabaseOptions(databaseOptions);
		super.setTemplateContentConverter(new SdTemplateContentConverterDefaultImpl());
		super.setTemplateEngine(new ScrewDriverTemplateFreeMarkerImpl());

		super.setBeanConverter(new SdClassConverterDB2Impl());
		super.setClassConverter(new SdTableToClassConverterDB2Impl());

		super.setTableConverter(new SdTableContentConverterDB2Impl());
		super.setDbUtil(new SdDbUtilDB2Impl(databaseOptions));
	}

}
