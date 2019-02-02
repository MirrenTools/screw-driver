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
		if (SdUtil.isNullOrEmpty(getExtensions(), key)) {
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
		if (SdUtil.isNullOrEmpty(key)) {
			return this;
		}
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
		sb.append("┣━suffix = " + suffix + "\n");
		sb.append("┣━attrs = " + attrs + "\n");
		sb.append("┗━extensions = " + extensions + "\n");
		return sb.toString();

	}

}
