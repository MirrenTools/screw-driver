package org.mirrentools.sd.models.entity;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.mirrentools.sd.common.SdUtil;

/**
 * 类的方法
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public abstract class Method {
	/** 方法需要导入的包 */
	private Set<String> imports;
	/** 方法的注解 */
	private Set<String> annotations;
	/** 方法的注释 */
	private String remark;
	/** 方法的访问修饰符 */
	private String modifier;
	/** 方法是否为抽象方法 */
	private boolean abs;
	/** 方法数据类型 */
	private String type;
	/** 方法的名字 */
	private String name;
	/** 方法的名字 */
	private String body;
	/** 拓展属性 */
	private Map<String, Object> extensions;

	public Set<String> getImports() {
		return imports;
	}

	public Method setImports(Set<String> imports) {
		this.imports = imports;
		return this;
	}

	public Set<String> getAnnotations() {
		return annotations;
	}

	public Method setAnnotations(Set<String> annotations) {
		this.annotations = annotations;
		return this;
	}

	public String getRemark() {
		return remark;
	}

	public Method setRemark(String remark) {
		this.remark = remark;
		return this;
	}

	public String getModifier() {
		return modifier;
	}

	public Method setModifier(String modifier) {
		this.modifier = modifier;
		return this;
	}

	public boolean isAbs() {
		return abs;
	}

	public Method setAbs(boolean abs) {
		this.abs = abs;
		return this;
	}

	public String getType() {
		return type;
	}

	public Method setType(String type) {
		this.type = type;
		return this;
	}

	public String getName() {
		return name;
	}

	public Method setName(String name) {
		this.name = name;
		return this;
	}

	public String getBody() {
		return body;
	}

	public Method setBody(String body) {
		this.body = body;
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
	public Method addExtension(String key, Object value) {
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

	public Method setExtensions(Map<String, Object> extensions) {
		this.extensions = extensions;
		return this;
	}

	@Override
	public String toString() {
		return "Method [imports=" + imports + ", annotations=" + annotations + ", remark=" + remark + ", modifier=" + modifier + ", abs=" + abs + ", type=" + type + ", name=" + name + ", body=" + body
				+ ", extensions=" + extensions + "]";
	}

}
