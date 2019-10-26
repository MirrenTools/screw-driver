package org.mirrentools.sd.models;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.mirrentools.sd.common.SdUtil;
import org.mirrentools.sd.constant.Constant;

/**
 * 工具生成所需要的模板材料
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class SdTemplate {

	/** 模板所在的路径,获取完整的path可以通过SdTemplatePathUtil */
	private String path;
	/** 模板的名称 */
	private String file;
	/** 如果文件已经存在是否覆盖,默认覆盖 */
	private boolean override = true;
	/** 项目的源码目录,默认值src/main/java/ */
	private String sourceFolder = Constant.MAVEN_SRC;
	/** 类的包名 */
	private String packageName;
	/** 类的名字 */
	private String className;
	/** 类的后缀名 */
	private String suffix = Constant.JAVA_SUFFIX;
	/** 模板中需要用到的属性 */
	private List<SdTemplateAttribute> attributes;
	/** 拓展属性 */
	private Map<String, Object> extensions;

	/**
	 * 获取模板文件夹所在路径
	 * 
	 * @return
	 */
	public String getPath() {
		return path;
	}

	/**
	 * 设置模板的所在路径
	 * 
	 * @param path
	 * @return
	 */
	public SdTemplate setPath(String path) {
		this.path = path;
		return this;
	}

	/**
	 * 获取模板文件的路径
	 * 
	 * @return
	 */
	public String getFile() {
		return file;
	}

	/**
	 * 设置模板的名字
	 * 
	 * @param file
	 * @return
	 */
	public SdTemplate setFile(String file) {
		this.file = file;
		return this;
	}

	/**
	 * 获取如果生成对象已经存在是否将其覆盖
	 * 
	 * @return
	 */
	public boolean isOverride() {
		return override;
	}

	/**
	 * 如果文件已经存在是否覆盖,默认覆盖
	 * 
	 * @param override
	 * @return
	 */
	public SdTemplate setOverride(boolean override) {
		this.override = override;
		return this;
	}

	/**
	 * 获取项目源码路径
	 * 
	 * @return
	 */
	public String getSourceFolder() {
		return sourceFolder;
	}

	/**
	 * 设置项目的源码目录,比如java版maven项目的代码源目录src/main/java/<br>
	 * 默认值: src/main/java/
	 * 
	 * @param sourceFolder
	 * @return
	 */
	public SdTemplate setSourceFolder(String sourceFolder) {
		this.sourceFolder = sourceFolder;
		return this;
	}

	/**
	 * 获取生成文件的包名
	 * 
	 * @return
	 */
	public String getPackageName() {
		return packageName;
	}

	/**
	 * 设置生成文件的包名
	 * 
	 * @param packageName
	 * @return
	 */
	public SdTemplate setPackageName(String packageName) {
		this.packageName = packageName;
		return this;
	}

	/**
	 * 获取生成文件的名字
	 * 
	 * @return
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * 设置生成文件的名字
	 * 
	 * @param className
	 * @return
	 */
	public SdTemplate setClassName(String className) {
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
	 * 设置类的后缀名,默认.java
	 * 
	 * @param suffix
	 * @return
	 */
	public SdTemplate setSuffix(String suffix) {
		this.suffix = suffix;
		return this;
	}

	/**
	 * 获取模板中需要用到的属性中的指定属性
	 * 
	 * @param index
	 * @return
	 */
	public SdTemplateAttribute getAttribute(int index) {
		if (SdUtil.isNullOrEmpty(getAttributes()) || index > getAttributes().size()) {
			return null;
		}
		return getAttributes().get(index);
	}

	/**
	 * 获取模板中需要用到的属性
	 * 
	 * @return
	 */
	public List<SdTemplateAttribute> getAttributes() {
		return attributes;
	}

	/**
	 * 添加模板中需要用到的属性
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public SdTemplate addAttribute(SdTemplateAttribute attr) {
		if (SdUtil.isNullOrEmpty(attr)) {
			return this;
		}
		if (this.attributes == null) {
			this.attributes = new ArrayList<SdTemplateAttribute>();
		}
		this.attributes.add(attr);
		return this;
	}

	/**
	 * 设置模板中需要用到的属性
	 * 
	 * @param attributes
	 * @return
	 */
	public SdTemplate setAttributes(List<SdTemplateAttribute> attributes) {
		this.attributes = attributes;
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
	public SdTemplate putExtension(String key, Object value) {
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
	public SdTemplate setExtensions(Map<String, Object> extensions) {
		this.extensions = extensions;
		return this;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("SdTemplate: \n");
		sb.append("┣━path = " + path + "\n");
		sb.append("┣━file = " + file + "\n");
		sb.append("┣━override = " + override + "\n");
		sb.append("┣━sourceFolder = " + sourceFolder + "\n");
		sb.append("┣━packageName = " + packageName + "\n");
		sb.append("┣━className = " + className + "\n");
		sb.append("┣━suffix = " + suffix + "\n");
		sb.append("┗━extensions = " + extensions + "\n");
		return sb.toString();

	}

}
