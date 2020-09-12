package org.mirrentools.sd.options.def;

import org.mirrentools.sd.converter.impl.SdTemplateContentConverterDefaultImpl;
import org.mirrentools.sd.converter.impl.oracle.SdClassConverterOracleImpl;
import org.mirrentools.sd.converter.impl.oracle.SdTableContentConverterOracleImpl;
import org.mirrentools.sd.converter.impl.oracle.SdTableToClassConverterOracleImpl;
import org.mirrentools.sd.impl.ScrewDriverTemplateFreeMarkerImpl;
import org.mirrentools.sd.impl.dbutil.SdDbUtilOracleImpl;
import org.mirrentools.sd.options.ScrewDriverOptions;
import org.mirrentools.sd.options.SdDatabaseOptions;

/**
 * Oracle版配置
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class ScrewDriverOracleOptions extends ScrewDriverOptions {
	/**
	 * 初始化一个Oracle版的ScrewDriver配置,用于仅生成SQL
	 * 
	 * 
	 * @param databaseOptions 数据库连接信息
	 */
	public ScrewDriverOracleOptions(SdDatabaseOptions databaseOptions) {
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

		super.setBeanConverter(new SdClassConverterOracleImpl());
		super.setClassConverter(new SdTableToClassConverterOracleImpl());
		super.setTableConverter(new SdTableContentConverterOracleImpl());
		super.setDbUtil(new SdDbUtilOracleImpl(databaseOptions));
	}

}
