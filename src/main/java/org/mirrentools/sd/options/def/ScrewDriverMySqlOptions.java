package org.mirrentools.sd.options.def;

import java.util.Map;

import org.mirrentools.sd.converter.impl.SdTemplateContentConverterDefaultImpl;
import org.mirrentools.sd.converter.impl.mysql.SdClassConverterMySqlImpl;
import org.mirrentools.sd.converter.impl.mysql.SdDatabaseConverterMySqlImpl;
import org.mirrentools.sd.converter.impl.mysql.SdTableContentConverterMySqlImpl;
import org.mirrentools.sd.dbutil.impl.SdDbUtilMySqlImpl;
import org.mirrentools.sd.impl.ScrewDriverTemplateFreeMarkerImpl;
import org.mirrentools.sd.models.SdTemplate;
import org.mirrentools.sd.options.ScrewDriverOptions;
import org.mirrentools.sd.options.SdDatabaseOptions;

/**
 * MySQL版配置
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class ScrewDriverMySqlOptions extends ScrewDriverOptions {
	/**
	 * 初始化一个MySQL版的ScrewDriver配置,用于仅生成SQL
	 * 
	 * @param databaseOptions
	 *          数据库连接信息
	 */
	public ScrewDriverMySqlOptions(SdDatabaseOptions databaseOptions) {
		init(null, databaseOptions);

	}

	/**
	 * 初始化一个MySQL版的ScrewDriver配置,用于仅生成代码
	 * 
	 * @param templateMaps
	 *          模板集
	 */
	public ScrewDriverMySqlOptions(Map<String, SdTemplate> templateMaps) {
		init(templateMaps, null);
	}

	/**
	 * 初始化一个MySQL版的ScrewDriver配置,用于生成代码与SQL
	 * 
	 * @param templateMaps
	 *          模板集
	 * @param databaseOptions
	 *          数据库连接信息
	 */
	public ScrewDriverMySqlOptions(Map<String, SdTemplate> templateMaps, SdDatabaseOptions databaseOptions) {
		init(templateMaps, databaseOptions);
	}

	/**
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

		super.setBeanConverter(new SdClassConverterMySqlImpl());

		super.setTableConverter(new SdTableContentConverterMySqlImpl());
		super.setDatabaseConverter(new SdDatabaseConverterMySqlImpl());
		
		super.setDbUtil(new SdDbUtilMySqlImpl(databaseOptions));
	}
}
