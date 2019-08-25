package org.mirrentools.sd.options;

import java.util.LinkedHashMap;
import java.util.Map;

import org.mirrentools.sd.ScrewDriverException;
import org.mirrentools.sd.ScrewDriverTemplate;
import org.mirrentools.sd.common.SdUtil;
import org.mirrentools.sd.constant.Constant;
import org.mirrentools.sd.converter.SdClassConverter;
import org.mirrentools.sd.converter.SdTableContentConverter;
import org.mirrentools.sd.converter.SdTemplateContentConverter;
import org.mirrentools.sd.dbutil.SdDbUtil;
import org.mirrentools.sd.models.SdBean;
import org.mirrentools.sd.models.SdClassContent;
import org.mirrentools.sd.models.SdTemplate;
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

	/** 实体描述 */
	private SdBean bean;
	/** 实体类的属性,生成代码是该属性与bean二选一 */
	private SdClassContent classContent;
	/** 数据库配置 */
	private SdDatabaseOptions databaseOptions;

	// ***************code配置*******************
	/** 创建代码模板集合,key为模板的名字,value为模板属性 */
	private Map<String, SdTemplate> templateMaps;
	/** 项目所在路径,默认当前项目 */
	private String projectPath = SdUtil.getUserDir();
	/** 生成使用编码格式,默认UTF-8 */
	private String codeFormat = Constant.UTF_8;
	/** 将SdBean转换成类属性的转换器 */
	private SdClassConverter beanConverter;
	/** 模板转换器 */
	private SdTemplateContentConverter templateContentConverter;
	/** 模板生成工具 */
	private ScrewDriverTemplate templateUtil;

	// ***************SQL配置*******************
	/** 如果数据库不存在是否创建, 如果支持默认创建 */
	private boolean createDatabase = true;
	/** 如果表已经存在是否修改表,默认不修改表 */
	private boolean alterTable;
	/** 数据库执行工具 */
	private SdDbUtil dbUtil;
	/** 将SdBean转换为数据库表的操作属性的转换器 */
	private SdTableContentConverter tableConverter;

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
	 * 实例化仅生成SQL的配置
	 * 
	 * @param bean
	 *          实体描述
	 * @param databaseOptions
	 *          数据库连接信息
	 */
	public ScrewDriverOptions(SdBean bean, SdDatabaseOptions databaseOptions) {
		super();
		init(bean, null, null, databaseOptions);
	}

	/**
	 * 实例化仅生成代码的配置
	 * 
	 * @param classContent
	 *          实体类属性
	 * @param templateMaps
	 *          模板
	 * @param databaseOptions
	 *          数据库连接信息
	 */
	public ScrewDriverOptions(SdClassContent classContent, Map<String, SdTemplate> templateMaps, SdDatabaseOptions databaseOptions) {
		super();
		init(null, classContent, templateMaps, databaseOptions);
	}

	/**
	 * 实例化生成代码与SQL的配置
	 * 
	 * @param bean
	 *          实体描述
	 * @param templateMaps
	 *          模板
	 * @param databaseOptions
	 *          数据库连接信息
	 */
	public ScrewDriverOptions(SdBean bean, Map<String, SdTemplate> templateMaps, SdDatabaseOptions databaseOptions) {
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
	 *          模板
	 * @param databaseOptions
	 *          数据库连接信息
	 */
	private void init(SdBean bean, SdClassContent classContent, Map<String, SdTemplate> templateMaps, SdDatabaseOptions databaseOptions) {
		SdUtil.requireNonNull(databaseOptions, "数据库连接信息不能为空!");
		String groupId = databaseOptions.getDriverClass();
		if (groupId.contains("mysql")) {
			wrap(new ScrewDriverMySqlOptions(bean, classContent, templateMaps, databaseOptions));
		} else if (groupId.contains("postgresql")) {
			wrap(new ScrewDriverPostgreSqlOptions(bean, classContent, templateMaps, databaseOptions));
		} else if (groupId.contains("db2")) {
			wrap(new ScrewDriverDB2Options(bean, classContent, templateMaps, databaseOptions));
		} else if (groupId.contains("oracle")) {
			wrap(new ScrewDriverOracleOptions(bean, classContent, templateMaps, databaseOptions));
		} else if (groupId.contains("sqlserver")) {
			wrap(new ScrewDriverSqlServerOptions(bean, classContent, templateMaps, databaseOptions));
		} else if (groupId.contains("sqlite")) {
			wrap(new ScrewDriverSqliteOptions(bean, classContent, templateMaps, databaseOptions));
		} else {
			throw new ScrewDriverException("Unable to recognize database types through DriverClass,You can try new ScrewDriver(DB name)Options and complete the initialization");
		}
	}

	/**
	 * 通过别的配置初始化该配置
	 * 
	 * @param options
	 */
	public void wrap(ScrewDriverOptions options) {
		setBean(options.getBean());
		setClassContent(options.getClassContent());
		setDatabaseOptions(options.getDatabaseOptions());
		setTemplateMaps(options.getTemplateMaps());
		setProjectPath(options.getProjectPath());
		setCodeFormat(options.getCodeFormat());
		setCreateDatabase(options.isCreateDatabase());
		setAlterTable(options.isAlterTable());
		setExtensions(options.getExtensions());
		setBeanConverter(options.getBeanConverter());
		setTableConverter(options.getTableConverter());
		setTemplateContentConverter(options.getTemplateContentConverter());
		setTemplateUtil(options.getTemplateUtil());
		setDbUtil(options.getDbUtil());
	}

	/**
	 * 获取实体描述
	 * 
	 * @return
	 */
	public SdBean getBean() {
		return bean;
	}

	/**
	 * 设置实体描述
	 * 
	 * @param bean
	 * @return
	 */
	public ScrewDriverOptions setBean(SdBean bean) {
		this.bean = bean;
		return this;
	}

	/**
	 * 获取实体类的属性,生成代码是该属性与bean二选一
	 * 
	 * @return
	 */
	public SdClassContent getClassContent() {
		return classContent;
	}

	/**
	 * 设置实体类的属性,生成代码是该属性与bean二选一
	 * 
	 * @param classContent
	 * @return
	 */
	public ScrewDriverOptions setClassContent(SdClassContent classContent) {
		this.classContent = classContent;
		return this;
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
	public String getProjectPath() {
		return projectPath;
	}

	/**
	 * 设置项目所在路径
	 * 
	 * @param projectPath
	 * @return
	 */
	public ScrewDriverOptions setProjectPath(String projectPath) {
		this.projectPath = projectPath;
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
	public ScrewDriverTemplate getTemplateUtil() {
		return templateUtil;
	}

	/**
	 * 设置模板渲染工具
	 * 
	 * @param templateUtil
	 * @return
	 */
	public ScrewDriverOptions setTemplateUtil(ScrewDriverTemplate templateUtil) {
		this.templateUtil = templateUtil;
		return this;
	}

	/**
	 * 获取创建代码模板集合,key为模板的名字,value为模板属性
	 * 
	 * @return
	 */
	public Map<String, SdTemplate> getTemplateMaps() {
		return templateMaps;
	}

	/**
	 * 设置创建代码模板集合,key为模板的名字,value为模板属性
	 * 
	 * @param templateMaps
	 * @return
	 */
	public ScrewDriverOptions setTemplateMaps(Map<String, SdTemplate> templateMaps) {
		this.templateMaps = templateMaps;
		return this;
	}

	/**
	 * 如果数据库不存在是否创建
	 * 
	 * @return
	 */
	public boolean isCreateDatabase() {
		return createDatabase;
	}

	/**
	 * 设置如果数据库不存在是否创建,默认true创建
	 * 
	 * @param createDatabase
	 * @return
	 */
	public ScrewDriverOptions setCreateDatabase(boolean createDatabase) {
		this.createDatabase = createDatabase;
		return this;
	}

	/**
	 * 如果表已经存在是否修改表
	 * 
	 * @return
	 */
	public boolean isAlterTable() {
		return alterTable;
	}

	/**
	 * 如果表已经存在是否修改表,默认不修改表
	 * 
	 * @param alterTable
	 * @return
	 */
	public ScrewDriverOptions setAlterTable(boolean alterTable) {
		this.alterTable = alterTable;
		return this;
	}

	/**
	 * 获取数据库操作工具
	 * 
	 * @return
	 */
	public SdDbUtil getDbUtil() {
		return dbUtil;
	}

	/**
	 * 设置数据库操作工具
	 * 
	 * @param dbUtil
	 * @return
	 */
	public ScrewDriverOptions setDbUtil(SdDbUtil dbUtil) {
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
		result.append("  ┣━bean= " + getBean() + "\n");
		result.append("  ┣━classContent= " + getClassContent() + "\n");
		result.append("  ┣━databaseOptions= " + getDatabaseOptions() + "\n");
		result.append("  ┣━projectPath= " + getProjectPath() + "\n");
		result.append("  ┣━codeFormat= " + getCodeFormat() + "\n");
		result.append("  ┣━beanConverter= " + (getBeanConverter() == null ? "null" : getBeanConverter().getClass().getName()) + "\n");
		result.append("  ┣━templateContentConverter= " + (getTemplateContentConverter() == null ? "null" : getTemplateContentConverter().getClass().getName()) + "\n");
		result.append("  ┣━templateUtil= " + (getTemplateUtil() == null ? "null" : getTemplateUtil().getClass().getName()) + "\n");
		result.append("  ┣━templateMaps= " + getTemplateMaps() + "\n");
		result.append("  ┣━createDatabase= " + isCreateDatabase() + "\n");
		result.append("  ┣━alterTable= " + isAlterTable() + "\n");
		result.append("  ┣━dbUtil= " + (getDbUtil() == null ? "null" : getDbUtil().getClass().getName()) + "\n");
		result.append("  ┣━tableConverter= " + (getTableConverter() == null ? "null" : getTableConverter().getClass().getName()) + "\n");
		result.append("  ┗━extensions= " + getExtensions());
		return result.toString();
	}

}
