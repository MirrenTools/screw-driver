package org.mirrentools.sd.models.entity.impl;

import java.util.Map;
import java.util.Set;

import org.mirrentools.sd.models.entity.Field;

/**
 * Java版类的属性配置
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public class JavaField extends Field {

	@Override
	public JavaField addImports(String imports) {
		super.addImports(imports);
		return this;
	}

	@Override
	public JavaField setImports(Set<String> imports) {
		super.setImports(imports);
		return this;
	}

	@Override
	public JavaField addAnnotation(String annotation) {
		super.addAnnotation(annotation);
		return this;
	}

	@Override
	public JavaField setAnnotations(Set<String> annotations) {
		super.setAnnotations(annotations);
		return this;
	}

	@Override
	public JavaField setRemark(String remark) {
		super.setRemark(remark);
		return this;
	}

	@Override
	public JavaField setModifier(String modifier) {
		super.setModifier(modifier);
		return this;
	}

	@Override
	public JavaField setType(String type) {
		super.setType(type);
		return this;
	}

	@Override
	public JavaField setName(String name) {
		super.setName(name);
		return this;
	}

	@Override
	public JavaField setGet(boolean get) {
		super.setGet(get);
		return this;
	}

	@Override
	public JavaField setSet(boolean set) {
		super.setSet(set);
		return this;
	}

	@Override
	public JavaField addExtension(String key, Object value) {
		super.addExtension(key, value);
		return this;
	}

	@Override
	public JavaField setExtensions(Map<String, Object> extensions) {
		super.setExtensions(extensions);
		return this;
	}

	@Override
	public JavaField setNullable(boolean nullable) {
		super.setNullable(nullable);
		return this;
	}

	@Override
	public JavaField setMin(String min) {
		super.setMin(min);
		return this;
	}

	@Override
	public JavaField setMax(String max) {
		super.setMax(max);
		return this;
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
