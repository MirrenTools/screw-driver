package org.mirrentools.sd.models.entity.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.mirrentools.sd.models.entity.Class;
import org.mirrentools.sd.models.entity.Field;
import org.mirrentools.sd.models.entity.Method;

/**
 * Java版类的配置
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class JavaClass extends Class {

	@Override
	public JavaClass setPackages(String packages) {
		super.setPackages(packages);
		return this;
	}

	@Override
	public JavaClass addImports(String imports) {
		super.addImports(imports);
		return this;
	}

	@Override
	public JavaClass setImports(Set<String> imports) {
		super.setImports(imports);
		return this;
	}

	@Override
	public JavaClass setModifier(String modifier) {
		super.setModifier(modifier);
		return this;
	}

	@Override
	public JavaClass setType(String type) {
		super.setType(type);
		return this;
	}

	@Override
	public JavaClass setRemark(String remark) {
		super.setRemark(remark);
		return this;
	}

	@Override
	public JavaClass setName(String name) {
		super.setName(name);
		return this;
	}

	@Override
	public JavaClass addFields(Field field) {
		super.addFields(field);
		return this;
	}

	@Override
	public JavaClass setFields(List<Field> fields) {
		super.setFields(fields);
		return this;
	}

	@Override
	public JavaClass addMethod(Method method) {
		super.addMethod(method);
		return this;
	}

	@Override
	public JavaClass setMethods(List<Method> methods) {
		super.setMethods(methods);
		return this;
	}

	@Override
	public JavaClass addExtension(String key, Object value) {
		super.addExtension(key, value);
		return this;
	}

	@Override
	public JavaClass setExtensions(Map<String, Object> extensions) {
		super.setExtensions(extensions);
		return this;
	}

}
