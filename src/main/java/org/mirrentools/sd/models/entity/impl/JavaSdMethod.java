package org.mirrentools.sd.models.entity.impl;

import java.util.Map;
import java.util.Set;

import org.mirrentools.sd.models.entity.SdMethod;

/**
 * Java版累的方法配置
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class JavaSdMethod extends SdMethod {

	@Override
	public JavaSdMethod setImports(Set<String> imports) {
		super.setImports(imports);
		return this;
	}

	@Override
	public JavaSdMethod setAnnotations(Set<String> annotations) {
		super.setAnnotations(annotations);
		return this;
	}

	@Override
	public JavaSdMethod setRemark(String remark) {
		super.setRemark(remark);
		return this;
	}

	@Override
	public JavaSdMethod setModifier(String modifier) {
		super.setModifier(modifier);
		return this;
	}

	@Override
	public JavaSdMethod setAbs(boolean abs) {
		super.setAbs(abs);
		return this;
	}

	@Override
	public JavaSdMethod setType(String type) {
		super.setType(type);
		return this;
	}

	@Override
	public JavaSdMethod setName(String name) {
		super.setName(name);
		return this;
	}

	@Override
	public JavaSdMethod setBody(String body) {
		super.setBody(body);
		return this;
	}

	@Override
	public JavaSdMethod addExtension(String key, Object value) {
		super.addExtension(key, value);
		return this;
	}

	@Override
	public JavaSdMethod setExtensions(Map<String, Object> extensions) {
		super.setExtensions(extensions);
		return this;
	}

}
