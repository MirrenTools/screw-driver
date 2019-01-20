package org.mirrentools.sd.models.entity.impl;

import java.util.Map;
import java.util.Set;

import org.mirrentools.sd.models.entity.SdField;

/**
 * Java版类的属性配置
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public class JavaSdField extends SdField {

	@Override
	public JavaSdField addImports(String imports) {
		super.addImports(imports);
		return this;
	}

	@Override
	public JavaSdField setImports(Set<String> imports) {
		super.setImports(imports);
		return this;
	}

	@Override
	public JavaSdField addAnnotation(String annotation) {
		super.addAnnotation(annotation);
		return this;
	}

	@Override
	public JavaSdField setAnnotations(Set<String> annotations) {
		super.setAnnotations(annotations);
		return this;
	}

	@Override
	public JavaSdField setRemark(String remark) {
		super.setRemark(remark);
		return this;
	}

	@Override
	public JavaSdField setModifier(String modifier) {
		super.setModifier(modifier);
		return this;
	}

	@Override
	public JavaSdField setType(String type) {
		super.setType(type);
		return this;
	}

	@Override
	public JavaSdField setName(String name) {
		super.setName(name);
		return this;
	}

	@Override
	public JavaSdField setGet(boolean get) {
		super.setGet(get);
		return this;
	}

	@Override
	public JavaSdField setSet(boolean set) {
		super.setSet(set);
		return this;
	}

	@Override
	public JavaSdField addExtension(String key, Object value) {
		super.addExtension(key, value);
		return this;
	}

	@Override
	public JavaSdField setExtensions(Map<String, Object> extensions) {
		super.setExtensions(extensions);
		return this;
	}

	@Override
	public JavaSdField setNullable(boolean nullable) {
		super.setNullable(nullable);
		return this;
	}

	@Override
	public JavaSdField setMin(String min) {
		super.setMin(min);
		return this;
	}

	@Override
	public JavaSdField setMax(String max) {
		super.setMax(max);
		return this;
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
