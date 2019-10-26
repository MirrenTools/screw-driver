package org.mirrentools.sd.options.def;

import java.util.Map;

import org.mirrentools.sd.converter.impl.SdTemplateContentConverterDefaultImpl;
import org.mirrentools.sd.converter.impl.db2.SdClassConverterDB2Impl;
import org.mirrentools.sd.converter.impl.db2.SdTableContentConverterDB2Impl;
import org.mirrentools.sd.impl.ScrewDriverTemplateFreeMarkerImpl;
import org.mirrentools.sd.impl.dbutil.SdDbUtilDB2Impl;
import org.mirrentools.sd.models.SdTemplate;
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
	 * @param databaseOptions
	 *          数据库连接信息
	 */
	public ScrewDriverDB2Options(SdDatabaseOptions databaseOptions) {
		init(null, databaseOptions);
	}

	/**
	 * 初始化一个DB2版的ScrewDriver配置,用于生成代码
	 * 
	 * @param templateMaps
	 *          模板集合
	 */
	public ScrewDriverDB2Options(Map<String, SdTemplate> templateMaps) {
		init(templateMaps, null);
	}

	/**
	 * 初始化一个DB2版的ScrewDriver配置,用于生成代码与SQL
	 * 
	 * @param templateMaps
	 *          模板集合
	 * @param databaseOptions
	 *          数据库连接信息
	 */
	public ScrewDriverDB2Options(Map<String, SdTemplate> templateMaps, SdDatabaseOptions databaseOptions) {
		super();
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

		super.setBeanConverter(new SdClassConverterDB2Impl());

		super.setTableConverter(new SdTableContentConverterDB2Impl());
		super.setDbUtil(new SdDbUtilDB2Impl(databaseOptions));
	}

}
