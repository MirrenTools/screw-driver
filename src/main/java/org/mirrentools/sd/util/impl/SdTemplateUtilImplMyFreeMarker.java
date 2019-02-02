package org.mirrentools.sd.util.impl;

import java.util.Map;

import org.mirrentools.sd.common.SdException;
import org.mirrentools.sd.models.SdTemplate;
import org.mirrentools.sd.util.SdCodeUtil;
import org.mirrentools.sd.util.SdTemplateUtil;

/**
 * 模板生成工具FreeMarker实现版
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class SdTemplateUtilImplMyFreeMarker implements SdTemplateUtil {

	@Override
	public <T> boolean render(String projectPath, String format, T content, SdTemplate template) {

		return false;
	}

	@Override
	public SdCodeUtil addExtension(String key, Object value) {
		throw new SdException("该方法为备用拓展字段,如果需要使用到该字段可以继承后重写");
	}

	@Override
	public Map<String, Object> getExtensions() {
		throw new SdException("该方法为备用拓展字段,如果需要使用到该字段可以继承后重写");
	}

	@Override
	public SdCodeUtil setExtensions(Map<String, Object> extensions) {
		throw new SdException("该方法为备用拓展字段,如果需要使用到该字段可以继承后重写");
	}

}
