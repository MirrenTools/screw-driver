package org.mirrentools.sd.models;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.mirrentools.sd.common.SdUtil;

import com.google.protobuf.Method;

/**
 * 工具生成所需要的模板材料
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class SdTemplate {
	/**
	 * 模板的所在路径<br>
	 * 1. 默认寻找项目根路径的template<br>
	 * 2. 如果不存在寻找classpath<br>
	 * 3. 如果还不存在则寻找Jsg工具jar包的resource目录,所以在一般都不需要自己设置路径
	 */
	private String path;
	/** 模板的名字 */
	private String name;
	/** 如果文件已经存在是否覆盖,默认覆盖 */
	private boolean override = true;
	/** 项目的源码目录,比如java版maven项目的src/main/java */
	private String sourceFolder;
	/** 类的包名 */
	private String packageName;
	/** 类的名字 */
	private String className;
	/** 类的方法 */
	private List<Method> methods;

	/** 拓展属性 */
	private Map<String, Object> extensions;

	public String getPath() {
		return path;
	}

	/**
	 * 模板的所在路径<br>
	 * 1. 默认寻找项目根路径的template<br>
	 * 2. 如果不存在寻找classpath<br>
	 * 3. 如果还不存在则寻找Jsg工具jar包的resource目录,所以在一般都不需要自己设置路径
	 * 
	 * @param path
	 * @return
	 */
	public SdTemplate setPath(String path) {
		this.path = path;
		return this;
	}

	public String getName() {
		return name;
	}

	/**
	 * 设置模板的名字
	 * 
	 * @param name
	 * @return
	 */
	public SdTemplate setName(String name) {
		this.name = name;
		return this;
	}

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

	public String getSourceFolder() {
		return sourceFolder;
	}

	/**
	 * 设置项目的源码目录,比如java版maven项目的代码源目录src/main/java
	 * 
	 * @param sourceFolder
	 * @return
	 */
	public SdTemplate setSourceFolder(String sourceFolder) {
		this.sourceFolder = sourceFolder;
		return this;
	}

	public String getPackageName() {
		return packageName;
	}

	/**
	 * 设置文件的包名
	 * 
	 * @param packageName
	 * @return
	 */
	public SdTemplate setPackageName(String packageName) {
		this.packageName = packageName;
		return this;
	}

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

	public List<Method> getMethods() {
		return methods;
	}

	/**
	 * 添加模板需要用到类办法属性
	 * 
	 * @param method
	 * @return
	 */
	public SdTemplate addMethod(Method method) {
		if (this.methods == null) {
			this.methods = new ArrayList<Method>();
		}
		this.methods.add(method);
		return this;
	}

	/**
	 * 设置模板需要用到类方法属性
	 * 
	 * @param methods
	 */
	public SdTemplate setMethods(List<Method> methods) {
		this.methods = methods;
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
	public SdTemplate addExtension(String key, Object value) {
		if (SdUtil.isNullOrEmpty(key)) {
			return this;
		}
		if (this.extensions == null) {
			this.extensions = new LinkedHashMap<String, Object>();
		}
		this.extensions.put(key, value);
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
		return "JsgTemplate [path=" + path + ", name=" + name + ", override=" + override + ", sourceFolder=" + sourceFolder + ", packageName=" + packageName + ", className=" + className + ", extensions="
				+ extensions + "]";
	}

}
