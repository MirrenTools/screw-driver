package org.mirrentools.sd.options.def;

import java.util.Map;

import org.mirrentools.sd.converter.impl.SdTemplateContentConverterDefaultImpl;
import org.mirrentools.sd.converter.impl.db2.SdTableContentConverterDB2Impl;
import org.mirrentools.sd.dbutil.impl.SdDbUtilDB2Impl;
import org.mirrentools.sd.impl.ScrewDriverTemplateFreeMarkerImpl;
import org.mirrentools.sd.models.SdBean;
import org.mirrentools.sd.models.SdClassContent;
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
	 * @param bean
	 *          实体描述
	 * @param databaseOptions
	 *          数据库连接信息
	 */
	public ScrewDriverDB2Options(SdBean bean, SdDatabaseOptions databaseOptions) {
		init(bean, null, null, databaseOptions);
	}

	/**
	 * 初始化一个DB2版的ScrewDriver配置,用于仅生成代码
	 * 
	 * @param classContent
	 *          实体类属性
	 * @param templateMaps
	 *          模板集
	 * @param databaseOptions
	 *          数据库连接信息
	 */
	public ScrewDriverDB2Options(SdClassContent classContent, Map<String, SdTemplate> templateMaps, SdDatabaseOptions databaseOptions) {
		init(null, classContent, templateMaps, databaseOptions);
	}

	/**
	 * 初始化一个DB2版的ScrewDriver配置,用于生成代码与SQL
	 * 
	 * @param bean
	 *          实体描述
	 * @param databaseOptions
	 *          数据库连接信息
	 */
	public ScrewDriverDB2Options(SdBean bean, Map<String, SdTemplate> templateMaps, SdDatabaseOptions databaseOptions) {
		init(bean, null, templateMaps, databaseOptions);
	}

	/**
	 * 初始化一个DB2版的ScrewDriver配置,用于生成代码与SQL
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
	public ScrewDriverDB2Options(SdBean bean, SdClassContent classContent, Map<String, SdTemplate> templateMaps, SdDatabaseOptions databaseOptions) {
		super();
		init(bean, classContent, templateMaps, databaseOptions);
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

		// TODO 创建响应的实现并取消注释
		// super.setBeanConverter(new SdClassConverterDB2Impl());

		super.setTableConverter(new SdTableContentConverterDB2Impl());
		super.setDbUtil(new SdDbUtilDB2Impl(databaseOptions));
	}

}
