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
import org.mirrentools.sd.constant.SdConstant;
import org.mirrentools.sd.models.SdRenderContent;
import org.mirrentools.sd.models.SdTemplate;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

/**
 * 模板生成工具FreeMarker实现版
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class ScrewDriverTemplateFreeMarkerImpl extends ScrewDriverTemplateEngine {
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
			Configuration config = new Configuration(Configuration.VERSION_2_3_23);
			config.setDirectoryForTemplateLoading(new File(SdTemplatePathUtil.getPath(template.getPath())));
			config.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_23));
			config.setDefaultEncoding(SdConstant.UTF_8);
			Map<String, Object> dataModel = new HashMap<String, Object>();
			dataModel.put("content", content);
			File outDir = new File(outputDirPath);
			if (!outDir.exists()) {
				boolean mkdirs = outDir.mkdirs();
				if (!mkdirs) {
					LOG.warning("执行创建文件输出文件夹结果: " + mkdirs);
				}
			}
			writer = new OutputStreamWriter(new FileOutputStream(outputFilePath), format);
			// 检查文件是否存在,如果不存在检查默认模板中是否存在,如果存在就创建默认模板文件夹并负责到模板文件夹中
			SdTemplatePathUtil.getFile(template.getPath(), template.getFile());
			Template freeTemplate = config.getTemplate(template.getFile());
			freeTemplate.process(dataModel, writer);
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
