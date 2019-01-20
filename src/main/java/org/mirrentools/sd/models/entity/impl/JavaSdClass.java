package org.mirrentools.sd.models.entity.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.mirrentools.sd.models.entity.SdClass;
import org.mirrentools.sd.models.entity.SdField;
import org.mirrentools.sd.models.entity.SdMethod;

/**
 * Java版类的配置
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class JavaSdClass extends SdClass {

	@Override
	public JavaSdClass setPackages(String packages) {
		super.setPackages(packages);
		return this;
	}

	@Override
	public JavaSdClass addImports(String imports) {
		super.addImports(imports);
		return this;
	}

	@Override
	public JavaSdClass setImports(Set<String> imports) {
		super.setImports(imports);
		return this;
	}

	@Override
	public JavaSdClass setModifier(String modifier) {
		super.setModifier(modifier);
		return this;
	}

	@Override
	public JavaSdClass setType(String type) {
		super.setType(type);
		return this;
	}

	@Override
	public JavaSdClass setRemark(String remark) {
		super.setRemark(remark);
		return this;
	}

	@Override
	public JavaSdClass setName(String name) {
		super.setName(name);
		return this;
	}

	@Override
	public JavaSdClass addFields(SdField field) {
		super.addFields(field);
		return this;
	}

	@Override
	public JavaSdClass setFields(List<SdField> fields) {
		super.setFields(fields);
		return this;
	}

	@Override
	public JavaSdClass addMethod(SdMethod method) {
		super.addMethod(method);
		return this;
	}

	@Override
	public JavaSdClass setMethods(List<SdMethod> methods) {
		super.setMethods(methods);
		return this;
	}

	@Override
	public JavaSdClass addExtension(String key, Object value) {
		super.addExtension(key, value);
		return this;
	}

	@Override
	public JavaSdClass setExtensions(Map<String, Object> extensions) {
		super.setExtensions(extensions);
		return this;
	}

}
