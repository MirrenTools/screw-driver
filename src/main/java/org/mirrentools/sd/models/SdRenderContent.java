package org.mirrentools.sd.models;

import java.util.LinkedHashMap;
import java.util.Map;

import org.mirrentools.sd.common.SdUtil;
import org.mirrentools.sd.options.SdDatabaseOptions;

/**
 * 模板渲染需要的内容
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public class SdRenderContent {
	/** 生成表或类需要的属性内容 */
	private SdClassContent content;
	/** 数据库配置信息 */
	private SdDatabaseOptions dbOptions;
	/** 模板渲染中需要用到哪些模板内容 */
	private Map<String, SdTemplateContent> items;
	/** 拓展属性 */
	private Map<String, Object> extensions;
	/**
	 * 模板渲染需要的上下文
	 */
	public SdRenderContent() {
		super();
	}

	/**
	 * 模板渲染需要的上下文
	 * 
	 * @param content
	 *          类相关属性
	 * @param dbOptions
	 *          数据库相关属性
	 * @param items
	 *          模板相关属性
	 */
	public SdRenderContent(SdClassContent content, SdDatabaseOptions dbOptions, Map<String, SdTemplateContent> items) {
		super();
		this.content = content;
		this.dbOptions = dbOptions;
		this.items = items;
	}

	/**
	 * 获取生成表或类需要的属性内容
	 * 
	 * @return
	 */
	public SdClassContent getContent() {
		return content;
	}

	/**
	 * 设置生成表或类需要的属性内容
	 * 
	 * @param content
	 * @return
	 */
	public SdRenderContent setContent(SdClassContent content) {
		this.content = content;
		return this;
	}

	/**
	 * 获取数据库配置信息
	 * 
	 * @return
	 */
	public SdDatabaseOptions getDbOptions() {
		return dbOptions;
	}

	/**
	 * 设置数据库配置信息
	 * 
	 * @param dbOptions
	 * @return
	 */
	public SdRenderContent setDbOptions(SdDatabaseOptions dbOptions) {
		this.dbOptions = dbOptions;
		return this;
	}

	/**
	 * 获取模板渲染中需要用到哪些模板内容
	 * 
	 * @return
	 */
	public Map<String, SdTemplateContent> getItems() {
		return items;
	}

	/**
	 * 模板渲染中需要用到哪些模板内容
	 * 
	 * @param items
	 * @return
	 */
	public SdRenderContent putItem(String key, SdTemplateContent item) {
		if (getItems() == null) {
			setItems(new LinkedHashMap<String, SdTemplateContent>());
		}
		getItems().put(key, item);
		return this;
	}

	/**
	 * 模板渲染中需要用到哪些模板内容
	 * 
	 * @param items
	 * @return
	 */
	public SdRenderContent setItems(Map<String, SdTemplateContent> items) {
		this.items = items;
		return this;
	}
	/**
	 * 获得拓展属性值
	 * 
	 * @return
	 */
	public Object getExtension(String key) {
		if (SdUtil.isNullOrEmpty(getExtensions())) {
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
	public SdRenderContent addExtension(String key, Object value) {
		if (getExtensions() == null) {
			setExtensions(new LinkedHashMap<String, Object>());
		}
		getExtensions().put(key, value);
		return this;
	}
	/**
	 * 获取拓展属性
	 * 
	 * @return
	 */
	public Map<String, Object> getExtensions() {
		return extensions;
	}
	/**
	 * 设置拓展属性
	 * 
	 * @param extensions
	 * @return
	 */
	public SdRenderContent setExtensions(Map<String, Object> extensions) {
		this.extensions = extensions;
		return this;
	}

	@Override
	public String toString() {
		return "SdRenderContent [content=" + content + ", dbOptions=" + dbOptions + ", items=" + items + "]";
	}

}
