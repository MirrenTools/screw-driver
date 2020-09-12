package org.mirrentools.sd.options.def;

import org.mirrentools.sd.converter.impl.SdTemplateContentConverterDefaultImpl;
import org.mirrentools.sd.converter.impl.postgresql.SdClassConverterPostgreSqlImpl;
import org.mirrentools.sd.converter.impl.postgresql.SdDatabaseConverterPostgreSqlImpl;
import org.mirrentools.sd.converter.impl.postgresql.SdTableContentConverterPostgreSqlImpl;
import org.mirrentools.sd.converter.impl.postgresql.SdTableToClassConverterPostgreSqlImpl;
import org.mirrentools.sd.impl.ScrewDriverTemplateFreeMarkerImpl;
import org.mirrentools.sd.impl.dbutil.SdDbUtilPostgreSqlImpl;
import org.mirrentools.sd.options.ScrewDriverOptions;
import org.mirrentools.sd.options.SdDatabaseOptions;

/**
 * PostgreSQL版配置
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class ScrewDriverPostgreSqlOptions extends ScrewDriverOptions {
	/**
	 * 初始化一个PostgreSQL版的ScrewDriver配置,用于仅生成SQL
	 * 
	 * @param databaseOptions 数据库连接信息
	 */
	public ScrewDriverPostgreSqlOptions(SdDatabaseOptions databaseOptions) {
		super();
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

		super.setBeanConverter(new SdClassConverterPostgreSqlImpl());

		super.setTableConverter(new SdTableContentConverterPostgreSqlImpl());
		super.setClassConverter(new SdTableToClassConverterPostgreSqlImpl());
		super.setDatabaseConverter(new SdDatabaseConverterPostgreSqlImpl());

		super.setDbUtil(new SdDbUtilPostgreSqlImpl(databaseOptions));
	}

}
