package org.mirrentools.sd.options.def;

import java.util.Map;

import org.mirrentools.sd.converter.impl.SdTemplateContentConverterDefaultImpl;
import org.mirrentools.sd.converter.impl.sqlserver.SdClassConverterSqlServerImpl;
import org.mirrentools.sd.converter.impl.sqlserver.SdTableContentConverterSqlServerImpl;
import org.mirrentools.sd.dbutil.impl.SdDbUtilSqlServerImpl;
import org.mirrentools.sd.impl.ScrewDriverTemplateFreeMarkerImpl;
import org.mirrentools.sd.models.SdTemplate;
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
		init(null, databaseOptions);
	}

	/**
	 * 初始化一个SqlServer版的ScrewDriver配置,用于仅生成代码
	 * 
	 * @param templateMaps
	 *          模板集
	 * 
	 */
	public ScrewDriverSqlServerOptions(Map<String, SdTemplate> templateMaps) {
		init(templateMaps, null);
	}

	/**
	 * 初始化一个SqlServer版的ScrewDriver配置,用于生成代码与SQL
	 * 
	 * @param templateMaps
	 *          模板集
	 * @param databaseOptions
	 *          数据库连接信息
	 */
	public ScrewDriverSqlServerOptions(Map<String, SdTemplate> templateMaps, SdDatabaseOptions databaseOptions) {
		init(templateMaps, databaseOptions);
	}

	/**
	 * 初始化
	 * 
	 * @param templateMaps
	 *          模板集合
	 * @param databaseOptions
	 *          数据库连接信息
	 */
	private void init(Map<String, SdTemplate> templateMaps, SdDatabaseOptions databaseOptions) {
		super.setTemplateMaps(templateMaps);
		super.setDatabaseOptions(databaseOptions);
		super.setTemplateContentConverter(new SdTemplateContentConverterDefaultImpl());
		super.setTemplateUtil(new ScrewDriverTemplateFreeMarkerImpl());

		super.setBeanConverter(new SdClassConverterSqlServerImpl());

		super.setTableConverter(new SdTableContentConverterSqlServerImpl());
		super.setDbUtil(new SdDbUtilSqlServerImpl(databaseOptions));
	}

}
