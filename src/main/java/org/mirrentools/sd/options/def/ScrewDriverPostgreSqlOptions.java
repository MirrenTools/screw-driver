package org.mirrentools.sd.options.def;

import java.util.Map;

import org.mirrentools.sd.converter.impl.SdTemplateContentConverterDefaultImpl;
import org.mirrentools.sd.converter.impl.postgresql.SdClassConverterPostgreSqlImpl;
import org.mirrentools.sd.converter.impl.postgresql.SdTableContentConverterPostgreSqlImpl;
import org.mirrentools.sd.dbutil.impl.SdDbUtilPostgreSqlImpl;
import org.mirrentools.sd.impl.ScrewDriverTemplateFreeMarkerImpl;
import org.mirrentools.sd.models.SdBean;
import org.mirrentools.sd.models.SdClassContent;
import org.mirrentools.sd.models.SdTemplate;
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
	 * @param bean
	 *          实体描述
	 * @param databaseOptions
	 *          数据库连接信息
	 */
	public ScrewDriverPostgreSqlOptions(SdBean bean, SdDatabaseOptions databaseOptions) {
		super();
		init(bean, null, null, databaseOptions);
	}

	/**
	 * 初始化一个PostgreSQL版的ScrewDriver配置,用于仅生成代码
	 * 
	 * @param classContent
	 *          实体类属性
	 * @param templateMaps
	 *          模板集
	 * @param databaseOptions
	 *          数据库连接信息
	 */
	public ScrewDriverPostgreSqlOptions(SdClassContent classContent, Map<String, SdTemplate> templateMaps, SdDatabaseOptions databaseOptions) {
		super();
		init(null, classContent, templateMaps, databaseOptions);
	}

	/**
	 * 初始化一个PostgreSQL版的ScrewDriver配置,用于生成代码与SQL
	 * 
	 * @param bean
	 *          实体描述
	 * @param databaseOptions
	 *          数据库连接信息
	 */
	public ScrewDriverPostgreSqlOptions(SdBean bean, Map<String, SdTemplate> templateMaps, SdDatabaseOptions databaseOptions) {
		super();
		init(bean, null, templateMaps, databaseOptions);
	}

	/**
	 * 初始化
	 * 
	 * @param bean
	 *          实体描述
	 * @param classContent
	 *          实体类属性
	 * @param templateMaps
	 *          模板集合
	 * @param databaseOptions
	 *          数据库连接信息
	 */
	private void init(SdBean bean, SdClassContent classContent, Map<String, SdTemplate> templateMaps, SdDatabaseOptions databaseOptions) {
		super.setBean(bean);
		super.setClassContent(classContent);
		super.setTemplateMaps(templateMaps);
		super.setDatabaseOptions(databaseOptions);
		super.setTemplateContentConverter(new SdTemplateContentConverterDefaultImpl());
		super.setTemplateUtil(new ScrewDriverTemplateFreeMarkerImpl());

		super.setBeanConverter(new SdClassConverterPostgreSqlImpl());

		super.setTableConverter(new SdTableContentConverterPostgreSqlImpl());
		super.setDbUtil(new SdDbUtilPostgreSqlImpl(databaseOptions));
	}

}
