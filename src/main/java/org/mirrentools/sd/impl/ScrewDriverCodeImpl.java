package org.mirrentools.sd.impl;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;

import org.mirrentools.sd.ScrewDriverCode;
import org.mirrentools.sd.ScrewDriverException;
import org.mirrentools.sd.ScrewDriverTemplate;
import org.mirrentools.sd.common.SdUtil;
import org.mirrentools.sd.constant.Constant;
import org.mirrentools.sd.converter.SdClassConverter;
import org.mirrentools.sd.converter.SdTemplateContentConverter;
import org.mirrentools.sd.models.SdBean;
import org.mirrentools.sd.models.SdClassContent;
import org.mirrentools.sd.models.SdRenderContent;
import org.mirrentools.sd.models.SdTemplate;
import org.mirrentools.sd.models.SdTemplateContent;
import org.mirrentools.sd.options.ScrewDriverCodeOptions;
import org.mirrentools.sd.options.SdDatabaseOptions;

/**
 * 代码生成器的默认实现
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class ScrewDriverCodeImpl implements ScrewDriverCode {
	/** JUL日志 */
	private final Logger LOG = Logger.getLogger(this.getClass().getName());

	/** 创建类需要的属性 */
	private SdBean bean;
	/** 数据库连接属性 */
	private SdDatabaseOptions databaseOptions;
	/** 模板集合key为模板的名字,value为模板属性 */
	private Map<String, SdTemplate> templateMaps;

	/** 项目所在路径,默认当前项目 */
	private String projectPath;
	/** 生成使用编码格式,默认UTF-8 */
	private String codeFormat;
	/** SdBean转换器 */
	private SdClassConverter beanConverter;
	/** 模板内容转换器 */
	private SdTemplateContentConverter templateConverter;
	/** 模板生成工具 */
	private ScrewDriverTemplate templateUtil;

	/**
	 * 使用默认配置初始化工具
	 * 
	 * @param bean
	 *          生成代码所需要的实体属性
	 * @param templateMap
	 *          生成代码所需要的模板数据属性
	 */
	public ScrewDriverCodeImpl(SdBean bean, Map<String, SdTemplate> templateMaps) {
		super();
		this.bean = bean;
		this.templateMaps = templateMaps;
		init(new ScrewDriverCodeOptions());
	}

	/**
	 * 使用自定义配置初始化工具
	 * 
	 * @param bean
	 *          生成代码所需要的实体属性
	 * @param templateMap
	 *          生成代码所需要的模板
	 * @param options
	 *          生成代码所需要的数据库配置文件
	 */
	public ScrewDriverCodeImpl(SdBean bean, Map<String, SdTemplate> templateMaps, ScrewDriverCodeOptions options) {
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
	private void init(ScrewDriverCodeOptions options) {
		this.projectPath = options.getProjectPath();
		this.codeFormat = options.getCodeFormat();
		this.beanConverter = options.getBeanConverter();
		this.templateConverter = options.getTemplateContentConverter();
		this.templateUtil = options.getTemplateUtil();
	}

	@Override
	public boolean execute() {
		if (SdUtil.isNullOrEmpty(templateMaps)) {
			throw new NullPointerException(
					"SdTemplate cannot be null ,You need to create a SdTemplate first, because you need it to generate it.");
		}
		String path = getProjectPath();
		String format = getCodeFormat();

		SdClassContent clzContent = beanConverter.converter(getBean());
		Map<String, SdTemplateContent> templates = templateConverter.converter(clzContent, databaseOptions, templateMaps);
		SdRenderContent content = new SdRenderContent(clzContent, databaseOptions, templates);

		for (Entry<String, SdTemplate> temp : templateMaps.entrySet()) {
			LOG.info(String.format("Generating %s...", temp.getKey()));
			boolean render = templateUtil.render(path, format, content, temp.getValue());
			if (render) {
				LOG.info(String.format("Generated %s--> Successful!", temp.getKey()));
			} else {
				LOG.warning(String.format("Generated %s--> Failed,render result false!", temp.getKey()));
			}
		}
		return true;
	}

	@Override
	public String getProjectPath() {
		return projectPath == null ? SdUtil.getUserDir() : projectPath;
	}

	@Override
	public ScrewDriverCodeImpl setProjectPath(String projectPath) {
		this.projectPath = projectPath;
		return this;
	}

	@Override
	public String getCodeFormat() {
		return codeFormat == null ? Constant.UTF_8 : codeFormat;
	}

	@Override
	public ScrewDriverCodeImpl setCodeFormat(String codeFormat) {
		this.codeFormat = codeFormat;
		return this;
	}

	@Override
	public SdBean getBean() {
		return bean;
	}

	@Override
	public ScrewDriverCodeImpl setBean(SdBean bean) {
		this.bean = bean;
		return this;
	}

	@Override
	public SdDatabaseOptions getDatabaseOptions() {
		return databaseOptions;
	}

	@Override
	public ScrewDriverCodeImpl setDatabaseOptions(SdDatabaseOptions dbOptions) {
		this.databaseOptions = dbOptions;
		return this;
	}

	@Override
	public Map<String, SdTemplate> getTemplateMaps() {
		return templateMaps;
	}

	@Override
	public ScrewDriverCodeImpl addTemplate(String key, SdTemplate template) {
		if (getTemplateMaps() == null) {
			this.templateMaps = new LinkedHashMap<String, SdTemplate>();
		}
		this.templateMaps.put(key, template);
		return this;
	}

	@Override
	public ScrewDriverCodeImpl setTemplateMaps(Map<String, SdTemplate> templateMaps) {
		this.templateMaps = templateMaps;
		return this;
	}

	@Override
	public SdClassConverter getBeanConverter() {
		return beanConverter;
	}

	@Override
	public ScrewDriverCodeImpl setBeanConverter(SdClassConverter beanConverter) {
		this.beanConverter = beanConverter;
		return this;
	}

	@Override
	public SdTemplateContentConverter getTemplateConverter() {
		return templateConverter;
	}

	@Override
	public ScrewDriverCodeImpl setTemplateConverter(SdTemplateContentConverter templateConverter) {
		this.templateConverter = templateConverter;
		return this;
	}

	@Override
	public ScrewDriverTemplate getTemplateUtil() {
		return templateUtil;
	}

	@Override
	public ScrewDriverCodeImpl setTemplateUtil(ScrewDriverTemplate templateUtil) {
		this.templateUtil = templateUtil;
		return this;
	}

	@Override
	public ScrewDriverCode addExtension(String key, Object value) {
		throw new ScrewDriverException("This method expands the field as an alternate field, which can be inherited and rewritten if needed.");
	}

	@Override
	public Map<String, Object> getExtensions() {
		throw new ScrewDriverException("This method expands the field as an alternate field, which can be inherited and rewritten if needed.");
	}

	@Override
	public ScrewDriverCode setExtensions(Map<String, Object> extensions) {
		throw new ScrewDriverException("This method expands the field as an alternate field, which can be inherited and rewritten if needed.");
	}

}
