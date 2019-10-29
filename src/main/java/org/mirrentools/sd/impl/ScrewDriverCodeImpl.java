package org.mirrentools.sd.impl;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;

import org.mirrentools.sd.ScrewDriverCode;
import org.mirrentools.sd.ScrewDriverTemplateEngine;
import org.mirrentools.sd.common.SdUtil;
import org.mirrentools.sd.constant.Constant;
import org.mirrentools.sd.converter.SdClassConverter;
import org.mirrentools.sd.converter.SdTemplateContentConverter;
import org.mirrentools.sd.models.SdBean;
import org.mirrentools.sd.models.SdClassContent;
import org.mirrentools.sd.models.SdRenderContent;
import org.mirrentools.sd.models.SdTemplate;
import org.mirrentools.sd.models.SdTemplateContent;
import org.mirrentools.sd.options.ScrewDriverOptions;
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

	/** 数据库连接属性 */
	private SdDatabaseOptions databaseOptions;
	/** 模板集合key为模板的名字,value为模板属性 */
	private Map<String, SdTemplate> templateMaps;

	/** 文件生成输出路径 */
	private String outputPath;
	/** 生成使用编码格式,默认UTF-8 */
	private String codeFormat;
	/** SdBean转换器 */
	private SdClassConverter beanConverter;
	/** 模板内容转换器 */
	private SdTemplateContentConverter templateConverter;
	/** 模板生成工具 */
	private ScrewDriverTemplateEngine templateEngine;
	/** 拓展属性 */
	private Map<String, Object> extensions;

	public ScrewDriverCodeImpl(ScrewDriverOptions options) {
		super();
		SdUtil.requireNonNull(options, "The ScrewDriverOptions cannot be null ,you can new ScrewDriver(db name)Options");
		this.databaseOptions = options.getDatabaseOptions();
		this.templateMaps = options.getTemplateMaps();
		this.outputPath = options.getOutputPath();
		this.beanConverter = options.getBeanConverter();
		this.templateConverter = options.getTemplateContentConverter();
		this.templateEngine = options.getTemplateEngine();
		this.extensions = options.getExtensions();
	}

	@Override
	public boolean execute(SdBean bean) {
		SdUtil.requireNonNull(bean, "The bean cannot ba null");
		return execute(beanConverter.converter(bean));
	}

	@Override
	public boolean execute(SdClassContent classContent) {
		SdUtil.requireNonNull(templateMaps,
				"SdTemplate cannot be null ,You need to create a SdTemplate first, because you need it to generate it.");
		String path = getOutputPath();
		String format = getCodeFormat();
		Map<String, SdTemplateContent> templates = templateConverter.converter(classContent, databaseOptions, templateMaps);
		SdRenderContent content = new SdRenderContent(classContent, databaseOptions, templates);
		for (Entry<String, SdTemplate> temp : templateMaps.entrySet()) {
			LOG.info(String.format("Generating %s...", temp.getKey()));
			boolean render = templateEngine.render(path, format, content, temp.getValue());
			if (render) {
				LOG.info(String.format("Generated %s--> Successful!", temp.getKey()));
			} else {
				LOG.warning(String.format("Generated %s--> Failed,render result false!", temp.getKey()));
			}
		}
		return true;
	}

	@Override
	public String getOutputPath() {
		return outputPath;
	}

	@Override
	public ScrewDriverCodeImpl setOutputPath(String outputPath) {
		this.outputPath = outputPath;
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
	public ScrewDriverTemplateEngine getTemplateEngine() {
		return templateEngine;
	}

	@Override
	public ScrewDriverCodeImpl setTemplateEngine(ScrewDriverTemplateEngine templateEngine) {
		this.templateEngine = templateEngine;
		return this;
	}

	@Override
	public ScrewDriverCode addExtension(String key, Object value) {
		LOG.warning("This method expands the field as an alternate field, which can be inherited and rewritten if needed.");
		if (getExtensions() == null) {
			setExtensions(new LinkedHashMap<String, Object>());
		}
		getExtensions().put(key, value);
		return this;
	}

	@Override
	public Map<String, Object> getExtensions() {
		LOG.warning("This method expands the field as an alternate field, which can be inherited and rewritten if needed.");
		return extensions;
	}

	@Override
	public ScrewDriverCode setExtensions(Map<String, Object> extensions) {
		LOG.warning("This method expands the field as an alternate field, which can be inherited and rewritten if needed.");
		this.extensions = extensions;
		return this;
	}

}
