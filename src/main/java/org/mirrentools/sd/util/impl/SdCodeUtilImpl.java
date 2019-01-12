package org.mirrentools.sd.util.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mirrentools.sd.common.SdException;
import org.mirrentools.sd.common.SdUtil;
import org.mirrentools.sd.constant.Constant;
import org.mirrentools.sd.converter.SdBeanConverterToClass;
import org.mirrentools.sd.models.SdBean;
import org.mirrentools.sd.models.SdTemplate;
import org.mirrentools.sd.models.entity.Class;
import org.mirrentools.sd.util.SdCodeUtil;
import org.mirrentools.sd.util.SdTemplateUtil;

/**
 * 代码生成器的默认实现
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class SdCodeUtilImpl implements SdCodeUtil {
	/** 项目所在路径 */
	private String projectPath;
	/** 生成使用编码格式,默认UTF-8 */
	private String codeFormat = Constant.UTF_8;
	/** 创建类需要的属性 */
	private SdBean bean;
	/** 模板集合 */
	private List<SdTemplate> templates;
	/** SdBean转换器 */
	private SdBeanConverterToClass converter;
	/** 模板生成工具 */
	private SdTemplateUtil templateUtil;

	/**
	 * 初始化一个代码生成器
	 * 
	 * @param projectPath
	 *          项目所在目录
	 * @param templates
	 *          生成文件需要的模板
	 * @param converter
	 *          将SdBean转换为生成所需要的内容
	 * @param templateUtil
	 *          模板生成器
	 */
	public SdCodeUtilImpl(String projectPath, SdBean bean, List<SdTemplate> templates, SdBeanConverterToClass converter, SdTemplateUtil templateUtil) {
		super();
		this.projectPath = projectPath;
		this.bean = bean;
		this.templates = templates;
		this.converter = converter;
		this.templateUtil = templateUtil;
	}

	@Override
	public boolean execute() {
		if (SdUtil.isNullOrEmpty(templates)) {
			throw new NullPointerException("SdTemplate 集合不能为空,你需要先创建一个SdTemplate,因为需要它来生成");
		}

		Class content = converter.toClass();
		String format = codeFormat == null ? Constant.UTF_8 : codeFormat;
		for (SdTemplate temp : templates) {
			templateUtil.render(projectPath, format, content, temp);
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
	public List<SdTemplate> getTemplates() {
		return templates;
	}

	@Override
	public SdCodeUtilImpl addTemplates(SdTemplate template) {
		if (this.templates == null) {
			this.templates = new ArrayList<SdTemplate>();
		}
		this.templates.add(template);
		return this;
	}

	@Override
	public SdCodeUtilImpl setTemplates(List<SdTemplate> templates) {
		this.templates = templates;
		return this;
	}

	@Override
	public SdBeanConverterToClass getConverter() {
		return converter;
	}

	@Override
	public SdCodeUtilImpl setConverter(SdBeanConverterToClass converter) {
		this.converter = converter;
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

	@Override
	public String toString() {
		return "SdCodeUtilImpl [projectPath=" + projectPath + ", codeFormat=" + codeFormat + ", templates=" + templates + ", converter=" + converter + ", templateUtil=" + templateUtil + "]";
	}

}
