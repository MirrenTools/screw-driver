package org.mirrentools.sd.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.mirrentools.sd.ScrewDriverException;
import org.mirrentools.sd.ScrewDriverTemplateEngine;
import org.mirrentools.sd.common.SdTemplatePathUtil;
import org.mirrentools.sd.common.SdUtil;
import org.mirrentools.sd.models.SdRenderContent;
import org.mirrentools.sd.models.SdTemplate;
import org.mvel2.templates.TemplateRuntime;

/**
 * 模板生成工具MVEL版实现
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class ScrewDriverTemplateMvelImpl extends ScrewDriverTemplateEngine {
	/** JUL日志 */
	private final Logger LOG = Logger.getLogger(this.getClass().getName());

	@Override
	public boolean render(String outputPath, String format, SdRenderContent content, SdTemplate template) {
		StringBuilder path = new StringBuilder();
		String projectPath = SdUtil.isNullOrEmpty(outputPath) ? SdUtil.getUserDir() : outputPath;
		if (!projectPath.endsWith("/") && !projectPath.endsWith("\\")) {
			path.append(projectPath + "/");
		} else {
			path.append(projectPath);
		}
		if (!template.getSourceFolder().endsWith("/") && !template.getSourceFolder().endsWith("\\")) {
			path.append(template.getSourceFolder() + "/");
		} else {
			path.append(template.getSourceFolder());
		}
		path.append(template.getPackageName().replace(".", "/"));
		String outputDirPath = path.toString();
		if (!outputDirPath.endsWith("/") && !outputDirPath.endsWith("\\")) {
			outputDirPath += "/";
		}
		String outputFilePath = outputDirPath + template.getClassName() + template.getSuffix();
		if (!template.isOverride()) {
			if (new File(outputFilePath).exists()) {
				LOG.info("设置了文件存在不覆盖,文件已经存在,忽略本文件的创建");
				return false;
			}
		}

		Writer writer = null;
		try {
			Map<String, Object> dataModel = new HashMap<String, Object>();
			dataModel.put("content", content);
			File outDir = new File(outputDirPath);
			if (!outDir.exists()) {
				boolean mkdirs = outDir.mkdirs();
				if (!mkdirs) {
					LOG.warning("执行创建文件输出文件夹结果: " + mkdirs);
				}
			}
			File file = SdTemplatePathUtil.getFile(template.getPath(), template.getFile());
			String templateStr = SdUtil.readFileToString(file);
			writer = new OutputStreamWriter(new FileOutputStream(outputFilePath), format);
			Object result = TemplateRuntime.eval(templateStr, dataModel);
			writer.write(result.toString());
			return true;
		} catch (Exception e) {
			throw new ScrewDriverException(e);
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
					LOG.warning(e.getMessage());
				}
			}
		}
	}
}
