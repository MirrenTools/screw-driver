package org.mirrentools.sd.options;

import java.util.LinkedHashMap;
import java.util.Map;

import org.mirrentools.sd.ScrewDriverDbUtil;
import org.mirrentools.sd.ScrewDriverTemplateEngine;
import org.mirrentools.sd.SdType;
import org.mirrentools.sd.common.SdUtil;
import org.mirrentools.sd.constant.Java;
import org.mirrentools.sd.constant.SdConstant;
import org.mirrentools.sd.converter.SdBasicClassConverter;
import org.mirrentools.sd.converter.SdBasicTypeConverter;
import org.mirrentools.sd.converter.SdClassConverter;
import org.mirrentools.sd.converter.SdDatabaseContentConverter;
import org.mirrentools.sd.converter.SdTableContentConverter;
import org.mirrentools.sd.converter.SdTableToClassConverter;
import org.mirrentools.sd.converter.SdTemplateContentConverter;
import org.mirrentools.sd.converter.impl.SdTemplateContentConverterDefaultImpl;
import org.mirrentools.sd.enums.SdTypeMode;
import org.mirrentools.sd.impl.ScrewDriverTemplateFreeMarkerImpl;
import org.mirrentools.sd.options.def.ScrewDriverDB2Options;
import org.mirrentools.sd.options.def.ScrewDriverMySqlOptions;
import org.mirrentools.sd.options.def.ScrewDriverOracleOptions;
import org.mirrentools.sd.options.def.ScrewDriverPostgreSqlOptions;
import org.mirrentools.sd.options.def.ScrewDriverSqlServerOptions;
import org.mirrentools.sd.options.def.ScrewDriverSqliteOptions;

/**
 * ScrewDriver配置类
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class ScrewDriverOptions {
	// ***************基本配置*******************
	/** 数据库配置 */
	private SdDatabaseOptions databaseOptions;
	/** 项目所在路径,默认当前项目 */
	private String outputPath = SdUtil.getUserDir();
	/** 生成使用编码格式,默认UTF-8 */
	private String codeFormat = SdConstant.UTF_8;
	/** 将SdBean转换成类属性的转换器 */
	private SdClassConverter beanConverter = new SdBasicClassConverter(new SdBasicTypeConverter(Java.OBJECT, SdType.getDictionary(SdTypeMode.JAVA)));
	/** 模板转换器 */
	private SdTemplateContentConverter templateContentConverter = new SdTemplateContentConverterDefaultImpl();
	/** 模板生成工具 */
	private ScrewDriverTemplateEngine templateEngine = new ScrewDriverTemplateFreeMarkerImpl();

	// ***************SQL配置*******************
	/** 数据库相关操作执行工具 */
	private ScrewDriverDbUtil dbUtil;
	/** 将SdBean转换为数据库表的操作属性的转换器 */
	private SdTableContentConverter tableConverter;
	/** 将SdTable转换ClassContent的转换器 */
	private SdTableToClassConverter classConverter;
	/** 将SdDatabase转换为数据库的操作属性 */
	private SdDatabaseContentConverter databaseConverter;

	// ***************拓展配置*******************
	/** 拓展属性 */
	private Map<String, Object> extensions;

	/**
	 * 实例化一个空的配置,后续添加自定义配置
	 */
	public ScrewDriverOptions() {
		super();
	}

	/**
	 * 实例化
	 */
	public ScrewDriverOptions(ScrewDriverOptions options) {
		wrap(options);
	}

	/**
	 * 根据数据库配置信息实例化SQL的配置
	 * 
	 * @param databaseOptions 数据库连接信息
	 */
	public ScrewDriverOptions(SdDatabaseOptions databaseOptions) {
		super();
		init(databaseOptions);
	}

	/**
	 * 初始化
	 * 
	 * @param templateMaps    模板
	 * @param databaseOptions 数据库连接信息
	 */
	private void init(SdDatabaseOptions databaseOptions) {
		String groupId = databaseOptions.getDriverClass();
		if (groupId.contains("mysql")) {
			wrap(new ScrewDriverMySqlOptions(databaseOptions));
		} else if (groupId.contains("postgresql")) {
			wrap(new ScrewDriverPostgreSqlOptions(databaseOptions));
		} else if (groupId.contains("db2")) {
			wrap(new ScrewDriverDB2Options(databaseOptions));
		} else if (groupId.contains("oracle")) {
			wrap(new ScrewDriverOracleOptions(databaseOptions));
		} else if (groupId.contains("sqlserver")) {
			wrap(new ScrewDriverSqlServerOptions(databaseOptions));
		} else if (groupId.contains("sqlite")) {
			wrap(new ScrewDriverSqliteOptions(databaseOptions));
		}
	}

	/**
	 * 通过别的配置初始化该配置
	 * 
	 * @param options
	 */
	public void wrap(ScrewDriverOptions options) {
		setDatabaseOptions(options.getDatabaseOptions());
		setOutputPath(options.getOutputPath());
		setCodeFormat(options.getCodeFormat());
		setExtensions(options.getExtensions());
		setBeanConverter(options.getBeanConverter());
		setTableConverter(options.getTableConverter());
		setClassConverter(options.getClassConverter());
		setDatabaseConverter(options.getDatabaseConverter());
		setTemplateContentConverter(options.getTemplateContentConverter());
		setTemplateEngine(options.getTemplateEngine());
		setDbUtil(options.getDbUtil());
	}

	/**
	 * 获取数据库配置
	 * 
	 * @return
	 */
	public SdDatabaseOptions getDatabaseOptions() {
		return databaseOptions;
	}

	/**
	 * 设置数据库配置
	 * 
	 * @param databaseOptions
	 * @return
	 */
	public ScrewDriverOptions setDatabaseOptions(SdDatabaseOptions databaseOptions) {
		this.databaseOptions = databaseOptions;
		return this;
	}

	/**
	 * 获取项目所在路径
	 * 
	 * @return
	 */
	public String getOutputPath() {
		return outputPath;
	}

	/**
	 * 设置项目所在路径
	 * 
	 * @param projectPath
	 * @return
	 */
	public ScrewDriverOptions setOutputPath(String outputPath) {
		this.outputPath = outputPath;
		return this;
	}

	/**
	 * 获取生成代码的字符编码
	 * 
	 * @return
	 */
	public String getCodeFormat() {
		return codeFormat;
	}

	/**
	 * 设置生成代码的字符编码
	 * 
	 * @param codeFormat
	 * @return
	 */
	public ScrewDriverOptions setCodeFormat(String codeFormat) {
		this.codeFormat = codeFormat;
		return this;
	}

	/**
	 * 获取将实体描述转换为类描述的工具
	 * 
	 * @return
	 */
	public SdClassConverter getBeanConverter() {
		return beanConverter;
	}

	/**
	 * 设置将实体描述转换为类描述的工具
	 * 
	 * @param beanConverter
	 * @return
	 */
	public ScrewDriverOptions setBeanConverter(SdClassConverter beanConverter) {
		this.beanConverter = beanConverter;
		return this;
	}

	/**
	 * 获取模板转换器工具,用于将实体描述转换为渲染模板需要的数据
	 * 
	 * @return
	 */
	public SdTemplateContentConverter getTemplateContentConverter() {
		return templateContentConverter;
	}

	/**
	 * 设置模板转换器工具,用于将实体描述转换为渲染模板需要的数据
	 * 
	 * @param templateContentConverter
	 * @return
	 */
	public ScrewDriverOptions setTemplateContentConverter(SdTemplateContentConverter templateContentConverter) {
		this.templateContentConverter = templateContentConverter;
		return this;
	}

	/**
	 * 获取模板渲染工具
	 * 
	 * @return
	 */
	public ScrewDriverTemplateEngine getTemplateEngine() {
		return templateEngine;
	}

	/**
	 * 设置模板渲染工具
	 * 
	 * @param templateEngine
	 * @return
	 */
	public ScrewDriverOptions setTemplateEngine(ScrewDriverTemplateEngine templateEngine) {
		this.templateEngine = templateEngine;
		return this;
	}

	/**
	 * 获取数据库相关操作执行工具
	 * 
	 * @return
	 */
	public ScrewDriverDbUtil getDbUtil() {
		return dbUtil;
	}

	/**
	 * 设置数据库相关操作执行工具
	 * 
	 * @param dbUtil
	 * @return
	 */
	public ScrewDriverOptions setDbUtil(ScrewDriverDbUtil dbUtil) {
		this.dbUtil = dbUtil;
		return this;
	}

	/**
	 * 获取将SdBean转换为数据库表的操作属性的转换器
	 * 
	 * @return
	 */
	public SdTableContentConverter getTableConverter() {
		return tableConverter;
	}

	/**
	 * 设置将SdBean转换为数据库表的操作属性的转换器
	 * 
	 * @param tableConverter
	 * @return
	 */
	public ScrewDriverOptions setTableConverter(SdTableContentConverter tableConverter) {
		this.tableConverter = tableConverter;
		return this;
	}

	/**
	 * 获取将SdTable转换ClassContent的转换器
	 * 
	 * @return
	 */
	public SdTableToClassConverter getClassConverter() {
		return classConverter;
	}

	/**
	 * 设置将SdTable转换ClassContent的转换器
	 * 
	 * @param classConverter
	 * @return
	 */
	public ScrewDriverOptions setClassConverter(SdTableToClassConverter classConverter) {
		this.classConverter = classConverter;
		return this;
	}

	/**
	 * 获取数据库属性转换器
	 * 
	 * @return
	 */
	public SdDatabaseContentConverter getDatabaseConverter() {
		return databaseConverter;
	}

	/**
	 * 设置数据库属性转换器
	 * 
	 * @param databaseConverter
	 * @return
	 */
	public ScrewDriverOptions setDatabaseConverter(SdDatabaseContentConverter databaseConverter) {
		this.databaseConverter = databaseConverter;
		return this;
	}

	/**
	 * 获得拓展属性值
	 * 
	 * @return
	 */
	public Object getExtension(String key) {
		if (SdUtil.isNullOrEmpty(getExtensions())) {
			return null;
		}
		return getExtensions().get(key);
	}

	/**
	 * 添加附加属性
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public ScrewDriverOptions addExtension(String key, Object value) {
		if (getExtensions() == null) {
			setExtensions(new LinkedHashMap<String, Object>());
		}
		this.extensions.put(key, value);
		return this;
	}

	/**
	 * 获取拓展属性
	 * 
	 * @return
	 */
	public Map<String, Object> getExtensions() {
		return extensions;
	}

	/**
	 * 设置拓展属性
	 * 
	 * @param extensions
	 * @return
	 */
	public ScrewDriverOptions setExtensions(Map<String, Object> extensions) {
		this.extensions = extensions;
		return this;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("ScrewDriverOptions:" + "\n");
		result.append("  ┣━databaseOptions= " + getDatabaseOptions() + "\n");
		result.append("  ┣━outputPath= " + getOutputPath() + "\n");
		result.append("  ┣━codeFormat= " + getCodeFormat() + "\n");
		result.append(
				"  ┣━beanConverter= " + (getBeanConverter() == null ? "null" : getBeanConverter().getClass().getName()) + "\n");
		result.append("  ┣━templateContentConverter= "
				+ (getTemplateContentConverter() == null ? "null" : getTemplateContentConverter().getClass().getName()) + "\n");
		result.append("  ┣━templateEngine= "
				+ (getTemplateEngine() == null ? "null" : getTemplateEngine().getClass().getName()) + "\n");
		result.append("  ┣━dbUtil= " + (getDbUtil() == null ? "null" : getDbUtil().getClass().getName()) + "\n");
		result.append("  ┣━tableConverter= "
				+ (getTableConverter() == null ? "null" : getTableConverter().getClass().getName()) + "\n");
		result.append("  ┣━databaseConverter= "
				+ (getDatabaseConverter() == null ? "null" : getDatabaseConverter().getClass().getName()) + "\n");
		result.append("  ┗━extensions= " + getExtensions());
		return result.toString();
	}

}
