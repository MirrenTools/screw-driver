package org.mirrentools.sd.models.entity;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.mirrentools.sd.common.SdUtil;

/**
 * 类
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public class Class {
	/** 包名 */
	private String packages;
	/** 类需要导入的包 */
	private Set<String> imports;
	/** 类的访问修饰符 */
	private String modifier;
	/** 类的类型 */
	private String type;
	/** 类的注释 */
	private String remark;
	/** 类名 */
	private String name;
	/** 类的属性 */
	private List<Field> fields;
	/** 类的方法 */
	private List<Method> methods;
	/** 拓展属性 */
	private Map<String, Object> extensions;

	public String getPackages() {
		return packages;
	}

	public Class setPackages(String packages) {
		this.packages = packages;
		return this;
	}

	public Set<String> getImports() {
		return imports;
	}

	/**
	 * 添加需要导入的包
	 * 
	 * @param annotation
	 */
	public Class addImports(String imports) {
		if (SdUtil.isNullOrEmpty(imports)) {
			return this;
		}
		if (this.imports == null) {
			this.imports = new LinkedHashSet<String>();
		}
		this.imports.add(imports);
		return this;
	}

	public Class setImports(Set<String> imports) {
		this.imports = imports;
		return this;
	}

	public String getModifier() {
		return modifier;
	}

	public Class setModifier(String modifier) {
		this.modifier = modifier;
		return this;
	}

	public String getType() {
		return type;
	}

	public Class setType(String type) {
		this.type = type;
		return this;
	}

	public String getRemark() {
		return remark;
	}

	public Class setRemark(String remark) {
		this.remark = remark;
		return this;
	}

	public String getName() {
		return name;
	}

	public Class setName(String name) {
		this.name = name;
		return this;
	}

	public List<Field> getFields() {
		return fields;
	}

	/**
	 * 添加属性
	 * 
	 * @param annotation
	 */
	public Class addFields(Field field) {
		if (SdUtil.isNullOrEmpty(field)) {
			return this;
		}
		if (this.fields == null) {
			this.fields = new ArrayList<Field>();
		}
		this.fields.add(field);
		return this;
	}

	public Class setFields(List<Field> fields) {
		this.fields = fields;
		return this;
	}

	public List<Method> getMethods() {
		return methods;
	}

	/**
	 * 添加方法
	 * 
	 * @param annotation
	 */
	public Class addMethod(Method method) {
		if (SdUtil.isNullOrEmpty(method)) {
			return this;
		}
		if (this.methods == null) {
			this.methods = new ArrayList<Method>();
		}
		this.methods.add(method);
		return this;
	}

	public Class setMethods(List<Method> methods) {
		this.methods = methods;
		return this;
	}

	public Map<String, Object> getExtensions() {
		return extensions;
	}

	/**
	 * 添加附加属性
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public Class addExtension(String key, Object value) {
		if (SdUtil.isNullOrEmpty(key)) {
			return this;
		}
		if (this.extensions == null) {
			this.extensions = new LinkedHashMap<String, Object>();
		}
		this.extensions.put(key, value);
		return this;
	}

	public Class setExtensions(Map<String, Object> extensions) {
		this.extensions = extensions;
		return this;
	}

	@Override
	public String toString() {
		return "Class [packages=" + packages + ", imports=" + imports + ", modifier=" + modifier + ", type=" + type + ", remark=" + remark + ", name=" + name + ", fields=" + fields + ", methods="
				+ methods + ", extensions=" + extensions + "]";
	}

}
