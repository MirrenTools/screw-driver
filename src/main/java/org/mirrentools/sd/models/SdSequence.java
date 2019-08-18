package org.mirrentools.sd.models;

import java.util.LinkedHashMap;
import java.util.Map;

import org.mirrentools.sd.common.SdUtil;

/**
 * 数据库序列
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class SdSequence {
	/** 关机字NONE */
	public final static String NONE = "NONE";

	/** 序列的名称 */
	private String name;
	/** 制定序列的数据类型 */
	private String dataType;
	/** 最小值,null=NO MINVALUE */
	private Long minValue;
	/** 最大值,null=NO MAXVALUE */
	private Long maxValue;
	/** 每次累加多少 */
	private Long incrementBy;
	/** 开始计数 */
	private Long start;
	/** 最大值 */
	private Long cache;
	/** 是否循环,true=CYCLE,false=NO CYCLE */
	private Boolean cycle;
	/* 关联列 */
	private String ownedBy;

	/** 拓展属性 */
	private Map<String, Object> extensions;

	/**
	 * 获取序列的名称
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置序列的名称
	 * 
	 * @param name
	 * @return
	 */
	public SdSequence setName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * 序列的数据类型
	 * 
	 * @return
	 */
	public String getDataType() {
		return dataType;
	}

	/**
	 * 制定序列的数据类型
	 * 
	 * @param dataType
	 * @return
	 */
	public SdSequence setDataType(String dataType) {
		this.dataType = dataType;
		return this;
	}

	/**
	 * 获取最小值,null=NO MINVALUE
	 * 
	 * @return
	 */
	public Long getMinValue() {
		return minValue;
	}

	/**
	 * 设置最小值
	 * 
	 * @param minValue
	 * @return
	 */
	public SdSequence setMinValue(Long minValue) {
		this.minValue = minValue;
		return this;
	}

	/**
	 * 获取最大值,null=NO MAXVALUE
	 * 
	 * @return
	 */
	public Long getMaxValue() {
		return maxValue;
	}

	/**
	 * 设置最大值
	 * 
	 * @param maxValue
	 * @return
	 */
	public SdSequence setMaxValue(Long maxValue) {
		this.maxValue = maxValue;
		return this;
	}

	/**
	 * 获取增量
	 * 
	 * @return
	 */
	public Long getIncrementBy() {
		return incrementBy;
	}

	/**
	 * 设置增量
	 * 
	 * @param incrementBy
	 * @return
	 */
	public SdSequence setIncrementBy(Long incrementBy) {
		this.incrementBy = incrementBy;
		return this;
	}

	/**
	 * 获取开始值
	 * 
	 * @return
	 */
	public Long getStart() {
		return start;
	}

	/**
	 * 设置开始值
	 * 
	 * @param start
	 * @return
	 */
	public SdSequence setStart(Long start) {
		this.start = start;
		return this;
	}

	/**
	 * 获取缓存值
	 * 
	 * @return
	 */
	public Long getCache() {
		return cache;
	}

	/**
	 * 设置缓存值
	 * 
	 * @param cache
	 * @return
	 */
	public SdSequence setCache(Long cache) {
		this.cache = cache;
		return this;
	}

	/**
	 * 获取是否循环
	 * 
	 * @return
	 */
	public Boolean getCycle() {
		return cycle;
	}

	/**
	 * 设置是否循环,true=CYCLE,false=NO CYCLE
	 * 
	 * @param cycle
	 * @return
	 */
	public SdSequence setCycle(Boolean cycle) {
		this.cycle = cycle;
		return this;
	}

	/**
	 * 获取关联列
	 * 
	 * @return
	 */
	public String getOwnedBy() {
		return ownedBy;
	}

	/**
	 * 设置关联列
	 * 
	 * @param ownedBy
	 * @return
	 */
	public SdSequence setOwnedBy(String ownedBy) {
		this.ownedBy = ownedBy;
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
	public SdSequence addExtension(String key, Object value) {
		if (getExtensions() == null) {
			setExtensions(new LinkedHashMap<String, Object>());
		}
		this.extensions.put(key, value);
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
	public SdSequence setExtensions(Map<String, Object> extensions) {
		this.extensions = extensions;
		return this;
	}

	@Override
	public String toString() {
		return "SdSequence [name=" + name + ", dataType=" + dataType + ", minValue=" + minValue + ", maxValue=" + maxValue + ", incrementBy=" + incrementBy + ", start=" + start + ", cache=" + cache
				+ ", cycle=" + cycle + ", ownedBy=" + ownedBy + ", extensions=" + extensions + "]";
	}

}
