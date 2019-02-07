package org.mirrentools.sd.options;

import org.mirrentools.sd.common.SdUtil;
import org.mirrentools.sd.constant.Constant;
import org.mirrentools.sd.converter.SdBeanConverterToClass;
import org.mirrentools.sd.converter.SdTemplateContentConverter;
import org.mirrentools.sd.converter.impl.SdTemplateContentConverterDefaultImpl;
import org.mirrentools.sd.converter.impl.mysql.SdBeanConverterToClassImplByMySQL;
import org.mirrentools.sd.util.SdTemplateUtil;
import org.mirrentools.sd.util.impl.SdTemplateUtilImplFreeMarker;

/**
 * 代码创建工具的配置
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class SdCodeUtilOptions {
	/** 项目所在路径,默认当前项目 */
	private String projectPath = SdUtil.getUserDir();
	/** 生成使用编码格式,默认UTF-8 */
	private String codeFormat = Constant.UTF_8;
	/** 数据库连接属性 */
	private SdDatabaseOptions databaseOptions;
	/** SdBean转换器,默认MySQL实现 */
	private SdBeanConverterToClass beanConverter = new SdBeanConverterToClassImplByMySQL();
	/** 模板转换器,默认实现 */
	private SdTemplateContentConverter templateContentConverter = new SdTemplateContentConverterDefaultImpl();
	/** 模板生成工具,默认FreeMarker实现 */
	private SdTemplateUtil templateUtil = new SdTemplateUtilImplFreeMarker();

	/**
	 * 初始化一个默认值的配置
	 */
	public SdCodeUtilOptions() {
		super();
	}

	/**
	 * 初始化一个指定数据库属性的配置
	 * 
	 * @param databaseOptions
	 */
	public SdCodeUtilOptions(SdDatabaseOptions databaseOptions) {
		super();
		this.databaseOptions = databaseOptions;
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
	 * 设置项目所在路径,默认当前项目
	 * 
	 * @param projectPath
	 * @return
	 */
	public SdCodeUtilOptions setProjectPath(String projectPath) {
		this.projectPath = projectPath;
		return this;
	}

	/**
	 * 获取生成文件编码格式
	 * 
	 * @return
	 */
	public String getCodeFormat() {
		return codeFormat;
	}

	/**
	 * 设置生成文件编码格式,默认UTF-8
	 * 
	 * @param codeFormat
	 * @return
	 */
	public SdCodeUtilOptions setCodeFormat(String codeFormat) {
		this.codeFormat = codeFormat;
		return this;
	}

	/**
	 * 获取数据库连接属性
	 * 
	 * @return
	 */
	public SdDatabaseOptions getDatabaseOptions() {
		return databaseOptions;
	}

	/**
	 * 设置数据库连接属性
	 * 
	 * @param databaseOptions
	 * @return
	 */
	public SdCodeUtilOptions setDatabaseOptions(SdDatabaseOptions databaseOptions) {
		this.databaseOptions = databaseOptions;
		return this;
	}

	/**
	 * 获取属性转换器
	 * 
	 * @return
	 */
	public SdBeanConverterToClass getBeanConverter() {
		return beanConverter;
	}

	/**
	 * 设置属性转换器,默认MySQL版属性转换
	 * 
	 * @param beanConverter
	 * @return
	 */
	public SdCodeUtilOptions setBeanConverter(SdBeanConverterToClass beanConverter) {
		this.beanConverter = beanConverter;
		return this;
	}

	/**
	 * 获取模板需要的内容属性转换器
	 * 
	 * @return
	 */
	public SdTemplateContentConverter getTemplateContentConverter() {
		return templateContentConverter;
	}

	/**
	 * 设置模板需要的内容属性转换器,默认使用默认的实现实现
	 * 
	 * @param templateContentConverter
	 * @return
	 */
	public SdCodeUtilOptions setTemplateContentConverter(SdTemplateContentConverter templateContentConverter) {
		this.templateContentConverter = templateContentConverter;
		return this;
	}

	/**
	 * 获取模板工具
	 * 
	 * @return
	 */
	public SdTemplateUtil getTemplateUtil() {
		return templateUtil;
	}

	/**
	 * 设置模板工具,默认FreeMarker版实现
	 * 
	 * @param templateUtil
	 * @return
	 */
	public SdCodeUtilOptions setTemplateUtil(SdTemplateUtil templateUtil) {
		this.templateUtil = templateUtil;
		return this;
	}

}
