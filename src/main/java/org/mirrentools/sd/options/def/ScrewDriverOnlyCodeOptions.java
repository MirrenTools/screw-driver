package org.mirrentools.sd.options.def;

import java.util.Map;

import org.mirrentools.sd.SdType;
import org.mirrentools.sd.constant.Java;
import org.mirrentools.sd.converter.SdBasicClassConverter;
import org.mirrentools.sd.converter.SdBasicTypeConverter;
import org.mirrentools.sd.converter.impl.SdTemplateContentConverterDefaultImpl;
import org.mirrentools.sd.enums.SdTypeMode;
import org.mirrentools.sd.impl.ScrewDriverTemplateFreeMarkerImpl;
import org.mirrentools.sd.models.SdTemplate;
import org.mirrentools.sd.options.ScrewDriverOptions;
import org.mirrentools.sd.options.SdDatabaseOptions;

/**
 * ScrewDriver配置类,该配置只用于创建代码
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class ScrewDriverOnlyCodeOptions extends ScrewDriverOptions {

	/**
	 * 实例化一个空的配置,后续添加自定义配置
	 */
	public ScrewDriverOnlyCodeOptions() {
		super();
	}

	/**
	 * 实例化
	 */
	public ScrewDriverOnlyCodeOptions(ScrewDriverOnlyCodeOptions options) {
		wrap(options);
	}

	/**
	 * 实例化
	 * 
	 * @param templateMaps
	 *          模板集合
	 */
	public ScrewDriverOnlyCodeOptions(Map<String, SdTemplate> templateMaps) {
		init(templateMaps, null);
	}

	/**
	 * 实例化
	 * 
	 * @param templateMaps
	 *          模板集合
	 * @param databaseOptions
	 *          数据库连接信息
	 */
	public ScrewDriverOnlyCodeOptions(Map<String, SdTemplate> templateMaps, SdDatabaseOptions databaseOptions) {
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
		super.setTemplateEngine(new ScrewDriverTemplateFreeMarkerImpl());
		super.setBeanConverter(new SdBasicClassConverter(new SdBasicTypeConverter(Java.OBJECT, SdType.getDictionary(SdTypeMode.JAVA))));
	}

	/**
	 * 通过别的配置初始化该配置
	 * 
	 * @param options
	 */
	public void wrap(ScrewDriverOnlyCodeOptions options) {
		super.setDatabaseOptions(options.getDatabaseOptions());
		super.setTemplateMaps(options.getTemplateMaps());
		super.setOutputPath(options.getOutputPath());
		super.setCodeFormat(options.getCodeFormat());
		super.setExtensions(options.getExtensions());
		super.setBeanConverter(options.getBeanConverter());
		super.setTemplateContentConverter(options.getTemplateContentConverter());
		super.setTemplateEngine(options.getTemplateEngine());
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("ScrewDriverOptions:" + "\n");
		result.append("  ┣━databaseOptions= " + getDatabaseOptions() + "\n");
		result.append("  ┣━outputPath= " + getOutputPath() + "\n");
		result.append("  ┣━codeFormat= " + getCodeFormat() + "\n");
		result.append("  ┣━beanConverter= " + (getBeanConverter() == null ? "null" : getBeanConverter().getClass().getName()) + "\n");
		result.append("  ┣━templateContentConverter= " + (getTemplateContentConverter() == null ? "null" : getTemplateContentConverter().getClass().getName()) + "\n");
		result.append("  ┣━templateEngine= " + (getTemplateEngine() == null ? "null" : getTemplateEngine().getClass().getName()) + "\n");
		result.append("  ┣━templateMaps= " + getTemplateMaps() + "\n");
		result.append("  ┗━extensions= " + getExtensions());
		return result.toString();
	}

}
