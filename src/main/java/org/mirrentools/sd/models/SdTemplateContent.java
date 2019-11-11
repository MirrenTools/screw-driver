package org.mirrentools.sd.models;

import java.util.LinkedHashMap;
import java.util.Map;

import org.mirrentools.sd.common.SdUtil;

/**
 * 代码文件等生成所需要的模板属性
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public class SdTemplateContent {
	/** 模板的所在路径 */
	private String path;
	/** 模板的名字 */
	private String file;
	/** 如果文件已经存在是否覆盖 */
	private boolean override;
	/** 项目的源码目录,比如java版maven项目的src/main/java */
	private String sourceFolder;
	/** 类的包名 */
	private String packageName;
	/** 类的名字 */
	private String className;
	/** 类的名字全部小写 */
	private String lowerName;
	/** 类的名字全部大写 */
	private String upperName;
	/** 驼峰命名规则的类名字 */
	private String camelName;
	/** 连字符命名规则的类名字 */
	private String hyphenName;
	/** 下划线命名规则的类名字 */
	private String underScoreName;
	/** 文件的后缀名 */
	private String suffix;
	/** 该模板中需要用到的属性,map的key为属性的key */
	private Map<String, SdTemplateAttribute> attrs;
	/** 拓展属性 */
	private Map<String, Object> extensions;

	/**
	 * 获取模板所在路径
	 * 
	 * @return
	 */
	public String getPath() {
		return path;
	}

	/**
	 * 设置模板所在路径
	 * 
	 * @param path
	 * @return
	 */
	public SdTemplateContent setPath(String path) {
		this.path = path;
		return this;
	}

	/**
	 * 获取模板文件名字
	 * 
	 * @return
	 */
	public String getFile() {
		return file;
	}

	/**
	 * 设置模板文件名字
	 * 
	 * @param file
	 * @return
	 */
	public SdTemplateContent setFile(String file) {
		this.file = file;
		return this;
	}

	/**
	 * 获取如果文件存在的话是否覆盖
	 * 
	 * @return
	 */
	public boolean isOverride() {
		return override;
	}

	/**
	 * 设置如果文件存在的话是否覆盖
	 * 
	 * @param override
	 * @return
	 */
	public SdTemplateContent setOverride(boolean override) {
		this.override = override;
		return this;
	}

	/**
	 * 获取文件的源码路径
	 * 
	 * @return
	 */
	public String getSourceFolder() {
		return sourceFolder;
	}

	/**
	 * 设置文件的源码路径
	 * 
	 * @param sourceFolder
	 * @return
	 */
	public SdTemplateContent setSourceFolder(String sourceFolder) {
		this.sourceFolder = sourceFolder;
		return this;
	}

	/**
	 * 获取软件的包名
	 * 
	 * @return
	 */
	public String getPackageName() {
		return packageName;
	}

	/**
	 * 设置软件的包名
	 * 
	 * @param packageName
	 * @return
	 */
	public SdTemplateContent setPackageName(String packageName) {
		this.packageName = packageName;
		return this;
	}

	/**
	 * 获取类的名字
	 * 
	 * @return
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * 设置类的名字
	 * 
	 * @param className
	 * @return
	 */
	public SdTemplateContent setClassName(String className) {
		this.className = className;
		return this;
	}

	/**
	 * 获取类的名字全部小写
	 * 
	 * @return
	 */
	public String getLowerName() {
		return lowerName;
	}

	/**
	 * 设置类的名字全部小写
	 * 
	 * @param lowerName
	 * @return
	 */
	public SdTemplateContent setLowerName(String lowerName) {
		this.lowerName = lowerName;
		return this;
	}

	/**
	 * 获取类的名字全部大写
	 * 
	 * @return
	 */
	public String getUpperName() {
		return upperName;
	}

	/**
	 * 设置类的名字全部大写
	 * 
	 * @param upperName
	 * @return
	 */
	public SdTemplateContent setUpperName(String upperName) {
		this.upperName = upperName;
		return this;
	}

	/**
	 * 获取驼峰命名规则的类名字
	 * 
	 * @return
	 */
	public String getCamelName() {
		return camelName;
	}

	/**
	 * 设置驼峰命名规则的类名字
	 * 
	 * @param camelName
	 * @return
	 */
	public SdTemplateContent setCamelName(String camelName) {
		this.camelName = camelName;
		return this;
	}

	/**
	 * 获取连字符命名规则的类名字
	 * 
	 * @return
	 */
	public String getHyphenName() {
		return hyphenName;
	}

	/**
	 * 设置连字符命名规则的类名字
	 * 
	 * @param hyphenName
	 * @return
	 */
	public SdTemplateContent setHyphenName(String hyphenName) {
		this.hyphenName = hyphenName;
		return this;
	}

	/**
	 * 获取下划线命名规则的类名字
	 * 
	 * @return
	 */
	public String getUnderScoreName() {
		return underScoreName;
	}

	/**
	 * 设置下划线命名规则的类名字
	 * 
	 * @param underScoreName
	 * @return
	 */
	public SdTemplateContent setUnderScoreName(String underScoreName) {
		this.underScoreName = underScoreName;
		return this;
	}

	/**
	 * 获取类的后缀名
	 * 
	 * @return
	 */
	public String getSuffix() {
		return suffix;
	}

	/**
	 * 设置类的后缀名
	 * 
	 * @param suffix
	 * @return
	 */
	public SdTemplateContent setSuffix(String suffix) {
		this.suffix = suffix;
		return this;
	}

	/**
	 * 获取该模板的属性
	 * 
	 * @return
	 */
	public Map<String, SdTemplateAttribute> getAttrs() {
		return attrs;
	}

	/**
	 * 添加该模板的属性
	 * 
	 * @param attrs
	 * @return
	 */
	public SdTemplateContent putAttr(SdTemplateAttribute attr) {
		if (getAttrs() == null) {
			setAttrs(new LinkedHashMap<String, SdTemplateAttribute>());
		}
		getAttrs().put(attr.getKey(), attr);
		return this;
	}

	/**
	 * 设置该模板的属性
	 * 
	 * @param attrs
	 * @return
	 */
	public SdTemplateContent setAttrs(Map<String, SdTemplateAttribute> attrs) {
		this.attrs = attrs;
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
	public SdTemplateContent putExtension(String key, Object value) {
		if (getExtensions() == null) {
			setExtensions(new LinkedHashMap<String, Object>());
		}
		getExtensions().put(key, value);
		return this;
	}

	public Map<String, Object> getExtensions() {
		return extensions;
	}

	/**
	 * 设置拓展属性
	 * 
	 * @param extensions
	 * @return
	 */
	public SdTemplateContent setExtensions(Map<String, Object> extensions) {
		this.extensions = extensions;
		return this;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("SdTemplateContent: \n");
		sb.append("┣━path = " + path + "\n");
		sb.append("┣━file = " + file + "\n");
		sb.append("┣━override = " + override + "\n");
		sb.append("┣━sourceFolder = " + sourceFolder + "\n");
		sb.append("┣━packageName = " + packageName + "\n");
		sb.append("┣━className = " + className + "\n");
		sb.append("┣━lowerName = " + lowerName + "\n");
		sb.append("┣━upperName = " + upperName + "\n");
		sb.append("┣━camelName = " + camelName + "\n");
		sb.append("┣━hyphenName = " + hyphenName + "\n");
		sb.append("┣━underScoreName = " + underScoreName + "\n");
		sb.append("┣━suffix = " + suffix + "\n");
		sb.append("┣━attrs = " + attrs + "\n");
		sb.append("┗━extensions = " + extensions + "\n");
		return sb.toString();

	}

}
