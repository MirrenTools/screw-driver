package org.mirrentools.sd.models.entity.impl;

import java.util.Map;
import java.util.Set;

import org.mirrentools.sd.models.entity.Method;

/**
 * Java版累的方法配置
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class JavaMethod extends Method {

	@Override
	public JavaMethod setImports(Set<String> imports) {
		super.setImports(imports);
		return this;
	}

	@Override
	public JavaMethod setAnnotations(Set<String> annotations) {
		super.setAnnotations(annotations);
		return this;
	}

	@Override
	public JavaMethod setRemark(String remark) {
		super.setRemark(remark);
		return this;
	}

	@Override
	public JavaMethod setModifier(String modifier) {
		super.setModifier(modifier);
		return this;
	}

	@Override
	public JavaMethod setAbs(boolean abs) {
		super.setAbs(abs);
		return this;
	}

	@Override
	public JavaMethod setType(String type) {
		super.setType(type);
		return this;
	}

	@Override
	public JavaMethod setName(String name) {
		super.setName(name);
		return this;
	}

	@Override
	public JavaMethod setBody(String body) {
		super.setBody(body);
		return this;
	}

	@Override
	public JavaMethod addExtension(String key, Object value) {
		super.addExtension(key, value);
		return this;
	}

	@Override
	public JavaMethod setExtensions(Map<String, Object> extensions) {
		super.setExtensions(extensions);
		return this;
	}

}
