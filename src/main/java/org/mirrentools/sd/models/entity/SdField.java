package org.mirrentools.sd.models.entity;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.mirrentools.sd.common.SdUtil;

/**
 * 类的属性
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public abstract class SdField {
	/** 属性需要导入的包 */
	private Set<String> imports;
	/** 属性的注解 */
	private Set<String> annotations;
	/** 属性的注释 */
	private String remark;
	/** 属性的访问修饰符 */
	private String modifier;
	/** 属性数据类型 */
	private String type;
	/** 属性的名字 */
	private String name;
	/** 是否创建get方法 */
	private boolean get;
	/** 是否创建set方法 */
	private boolean set;
	/** 是否可以为空 */
	private boolean nullable;
	/** 最小值 */
	private String min;
	/** 最大值 */
	private String max;
	/** 拓展属性 */
	private Map<String, Object> extensions;

	/**
	 * 添加需要导入的包
	 * 
	 * @param annotation
	 */
	public SdField addImports(String imports) {
		if (SdUtil.isNullOrEmpty(imports)) {
			return this;
		}
		if (this.imports == null) {
			this.imports = new LinkedHashSet<String>();
		}
		this.imports.add(imports);
		return this;
	}

	public Set<String> getImports() {
		return imports;
	}

	public SdField setImports(Set<String> imports) {
		this.imports = imports;
		return this;
	}

	/**
	 * 添加注解
	 * 
	 * @param annotation
	 */
	public SdField addAnnotation(String annotation) {
		if (SdUtil.isNullOrEmpty(annotation)) {
			return this;
		}
		if (this.annotations == null) {
			this.annotations = new LinkedHashSet<String>();
		}
		this.annotations.add(annotation);
		return this;
	}

	public Set<String> getAnnotations() {
		return annotations;
	}

	public SdField setAnnotations(Set<String> annotations) {
		this.annotations = annotations;
		return this;
	}

	public String getRemark() {
		return remark;
	}

	public SdField setRemark(String remark) {
		this.remark = remark;
		return this;
	}

	public String getModifier() {
		return modifier;
	}

	public SdField setModifier(String modifier) {
		this.modifier = modifier;
		return this;
	}

	public String getType() {
		return type;
	}

	public SdField setType(String type) {
		this.type = type;
		return this;
	}

	public String getName() {
		return name;
	}

	public SdField setName(String name) {
		this.name = name;
		return this;
	}

	public boolean isGet() {
		return get;
	}

	public SdField setGet(boolean get) {
		this.get = get;
		return this;
	}

	public boolean isSet() {
		return set;
	}

	public SdField setSet(boolean set) {
		this.set = set;
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
	public SdField addExtension(String key, Object value) {
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

	public SdField setExtensions(Map<String, Object> extensions) {
		this.extensions = extensions;
		return this;
	}

	public boolean isNullable() {
		return nullable;
	}

	public SdField setNullable(boolean nullable) {
		this.nullable = nullable;
		return this;
	}

	/**
	 * 获取最小值,改属性对于字符串类型代表字符串的长度,数值代表数值的大小
	 * 
	 * @return
	 */
	public String getMin() {
		return min;
	}

	/**
	 * 设置最小值,改属性对于字符串类型代表字符串的长度,数值代表数值的大小
	 * 
	 * @param min
	 */
	public SdField setMin(String min) {
		this.min = min;
		return this;
	}

	/**
	 * 获取最大值,改属性对于字符串类型代表字符串的长度,数值代表数值的大小
	 * 
	 * @return
	 */
	public String getMax() {
		return max;
	}

	/**
	 * 设置最大值,改属性对于字符串类型代表字符串的长度,数值代表数值的大小
	 * 
	 * @param max
	 */
	public SdField setMax(String max) {
		this.max = max;
		return this;
	}

	@Override
	public String toString() {
		return "Field [imports=" + imports + ", annotations=" + annotations + ", remark=" + remark + ", modifier=" + modifier + ", type=" + type + ", name=" + name + ", get=" + get + ", set=" + set
				+ ", extensions=" + extensions + "]";
	}

}
