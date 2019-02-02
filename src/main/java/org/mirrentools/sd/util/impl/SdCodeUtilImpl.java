package org.mirrentools.sd.util.impl;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;

import org.mirrentools.sd.common.SdException;
import org.mirrentools.sd.common.SdUtil;
import org.mirrentools.sd.constant.Constant;
import org.mirrentools.sd.converter.SdBeanConverterToClass;
import org.mirrentools.sd.converter.SdTemplateContentConverter;
import org.mirrentools.sd.models.SdBean;
import org.mirrentools.sd.models.SdClassContent;
import org.mirrentools.sd.models.SdTemplate;
import org.mirrentools.sd.options.SdCodeUtilOptions;
import org.mirrentools.sd.options.SdDatabaseOptions;
import org.mirrentools.sd.util.SdCodeUtil;
import org.mirrentools.sd.util.SdTemplateUtil;

/**
 * 代码生成器的默认实现
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class SdCodeUtilImpl implements SdCodeUtil {
	/** JUL日志 */
	private final Logger LOG = Logger.getLogger(this.getClass().getName());

	/** 创建类需要的属性 */
	private SdBean bean;
	/** 数据库连接属性 */
	private SdDatabaseOptions databaseOptions;
	/** 模板集合key为模板的名字,value为模板属性 */
	private Map<String, SdTemplate> templateMaps;

	/** 项目所在路径 */
	private String projectPath;
	/** 生成使用编码格式,默认UTF-8 */
	private String codeFormat = Constant.UTF_8;
	/** SdBean转换器 */
	private SdBeanConverterToClass beanConverter;
	/** SdBean转换器 */
	private SdTemplateContentConverter contentConverter;
	/** 模板生成工具 */
	private SdTemplateUtil templateUtil;

	/**
	 * 使用默认配置初始化工具
	 * 
	 * @param bean
	 *          生成代码所需要的实体属性
	 * @param templateMap
	 *          生成代码所需要的模板数据属性
	 */
	public SdCodeUtilImpl(SdBean bean, Map<String, SdTemplate> templateMaps) {
		super();
		this.bean = bean;
		this.templateMaps = templateMaps;
		init(new SdCodeUtilOptions());
	}

	/**
	 * 使用自定义配置初始化工具
	 * 
	 * @param bean
	 *          生成代码所需要的实体属性
	 * @param templateMap
	 * @param options
	 */
	public SdCodeUtilImpl(SdBean bean, Map<String, SdTemplate> templateMaps, SdCodeUtilOptions options) {
		super();
		this.bean = bean;
		this.templateMaps = templateMaps;
		init(options);
	}

	/**
	 * 初始化配置
	 * 
	 * @param options
	 */
	private void init(SdCodeUtilOptions options) {
		this.projectPath = options.getProjectPath();
		this.codeFormat = options.getCodeFormat();
		this.beanConverter = options.getBeanConverter();
		this.contentConverter = options.getContentConverter();
		this.templateUtil = options.getTemplateUtil();
	}

	@Override
	public boolean execute() {
		if (SdUtil.isNullOrEmpty(templateMaps)) {
			throw new NullPointerException("SdTemplate 集合不能为空,你需要先创建一个SdTemplate,因为需要它来生成");
		}
		SdClassContent clz = beanConverter.converter(getBean());
		Object content = contentConverter.converter(clz, databaseOptions, templateMaps);
		String format = codeFormat == null ? Constant.UTF_8 : codeFormat;
		for (Entry<String, SdTemplate> temp : templateMaps.entrySet()) {
			LOG.info(String.format("执行生成%s...", temp.getKey()));
			boolean render = templateUtil.render(projectPath, format, content, temp.getValue());
			if (render) {
				LOG.info(String.format("执行生成%s-->成功!", temp.getKey()));
			} else {
				LOG.warning(String.format("执行生成%s-->异常,模板工具返回false!", temp.getKey()));
			}
		}
		return true;
	}

	@Override
	public String getProjectPath() {
		return projectPath;
	}

	@Override
	public SdCodeUtilImpl setProjectPath(String projectPath) {
		this.projectPath = projectPath;
		return this;
	}

	@Override
	public String getCodeFormat() {
		return codeFormat;
	}

	@Override
	public SdCodeUtilImpl setCodeFormat(String codeFormat) {
		this.codeFormat = codeFormat;
		return this;
	}

	@Override
	public SdBean getBean() {
		return bean;
	}

	@Override
	public SdCodeUtilImpl setBean(SdBean bean) {
		this.bean = bean;
		return this;
	}

	@Override
	public SdDatabaseOptions getDatabaseOptions() {
		return databaseOptions;
	}

	@Override
	public SdCodeUtilImpl setDatabaseOptions(SdDatabaseOptions dbOptions) {
		this.databaseOptions = dbOptions;
		return this;
	}

	@Override
	public Map<String, SdTemplate> getTemplateMaps() {
		return templateMaps;
	}

	@Override
	public SdCodeUtilImpl addTemplate(String key, SdTemplate template) {
		if (getTemplateMaps() == null) {
			this.templateMaps = new LinkedHashMap<String, SdTemplate>();
		}
		this.templateMaps.put(key, template);
		return this;
	}

	@Override
	public SdCodeUtilImpl setTemplateMaps(Map<String, SdTemplate> templateMaps) {
		this.templateMaps = templateMaps;
		return this;
	}

	@Override
	public SdBeanConverterToClass getBeanConverter() {
		return beanConverter;
	}

	@Override
	public SdCodeUtilImpl setBeanConverter(SdBeanConverterToClass beanConverter) {
		this.beanConverter = beanConverter;
		return this;
	}

	@Override
	public SdTemplateContentConverter getContentConverter() {
		return contentConverter;
	}

	@Override
	public SdCodeUtilImpl setContentConverter(SdTemplateContentConverter contentConverter) {
		this.contentConverter = contentConverter;
		return this;
	}

	@Override
	public SdTemplateUtil getTemplateUtil() {
		return templateUtil;
	}

	@Override
	public SdCodeUtilImpl setTemplateUtil(SdTemplateUtil templateUtil) {
		this.templateUtil = templateUtil;
		return this;
	}

	@Override
	public SdCodeUtil addExtension(String key, Object value) {
		throw new SdException("该方法为备用拓展字段,如果需要使用到该字段可以继承后重写");
	}

	@Override
	public Map<String, Object> getExtensions() {
		throw new SdException("该方法为备用拓展字段,如果需要使用到该字段可以继承后重写");
	}

	@Override
	public SdCodeUtil setExtensions(Map<String, Object> extensions) {
		throw new SdException("该方法为备用拓展字段,如果需要使用到该字段可以继承后重写");
	}

}
