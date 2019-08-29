package org.mirrentools.sd.models.db.update;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 抽象序列,用于新建与修改
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public abstract class SdAbstractSequenceContent {
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
	/** 重新计数 */
	private Long restart;
	/** 缓存值 */
	private Long cache;
	/** 是否循环,true=CYCLE,false=NO CYCLE */
	private Boolean cycle;
	/** 关联列 */
	private String ownedBy;
	/** 拓展属性 */
	private Map<String, Object> extensions;

	/**
	 * 创建的SQL语句
	 * 
	 * @return
	 */
	public abstract String createSQL();

	/**
	 * 修改的SQL语句,仅可以添加或删除
	 * 
	 * @return
	 */
	public abstract String updateSQL();

	/**
	 * 删除的SQL语句
	 * 
	 * @return
	 */
	public abstract String deleteSQL();

	/**
	 * 转换拓展字段,该方法用户转换拓展字段,如果基础的getBasicSQL方法可以用但是需要用到拓展字段时可以重写该方法,给方法的内容如果不为空会被追加到最后
	 * 
	 * @return
	 */
	public String converterExtensions() {
		return null;
	}

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
	public SdAbstractSequenceContent setName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * 获取序列的数据类型
	 * 
	 * @return
	 */
	public String getDataType() {
		return dataType;
	}

	/**
	 * 序列的数据类型
	 * 
	 * @param dataType
	 * @return
	 */
	public SdAbstractSequenceContent setDataType(String dataType) {
		this.dataType = dataType;
		return this;
	}

	/**
	 * 获取最小值
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
	public SdAbstractSequenceContent setMinValue(Long minValue) {
		this.minValue = minValue;
		return this;
	}

	/**
	 * 获取最大值
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
	public SdAbstractSequenceContent setMaxValue(Long maxValue) {
		this.maxValue = maxValue;
		return this;
	}

	/**
	 * 获取每次累加多少
	 * 
	 * @return
	 */
	public Long getIncrementBy() {
		return incrementBy;
	}

	/**
	 * 设置每次累加多少
	 * 
	 * @param incrementBy
	 * @return
	 */
	public SdAbstractSequenceContent setIncrementBy(Long incrementBy) {
		this.incrementBy = incrementBy;
		return this;
	}

	/**
	 * 获取开始计数
	 * 
	 * @return
	 */
	public Long getStart() {
		return start;
	}

	/**
	 * 设置开始计数
	 * 
	 * @param start
	 * @return
	 */
	public SdAbstractSequenceContent setStart(Long start) {
		this.start = start;
		return this;
	}

	/**
	 * 获取重新计数
	 * 
	 * @return
	 */
	public Long getRestart() {
		return restart;
	}

	/**
	 * 设置重新计数
	 * 
	 * @param restart
	 * @return
	 */
	public SdAbstractSequenceContent setRestart(Long restart) {
		this.restart = restart;
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
	public SdAbstractSequenceContent setCache(Long cache) {
		this.cache = cache;
		return this;
	}

	/**
	 * 获取是否循环,true=CYCLE,false=NO CYCLE
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
	public SdAbstractSequenceContent setCycle(Boolean cycle) {
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
	public SdAbstractSequenceContent setOwnedBy(String ownedBy) {
		this.ownedBy = ownedBy;
		return this;
	}

	/**
	 * 获得拓展属性
	 * 
	 * @return
	 */
	public Map<String, Object> getExtensions() {
		return extensions;
	}

	/**
	 * 获得拓展属性值
	 * 
	 * @return
	 */
	public Object getExtension(String key) {
		return getExtensions().get(key);
	}

	/**
	 * 添加附加属性
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public SdAbstractSequenceContent addExtension(String key, Object value) {
		if (getExtensions() == null) {
			setExtensions(new LinkedHashMap<String, Object>());
		}
		getExtensions().put(key, value);
		return this;
	}

	/**
	 * 设置附加属性
	 * 
	 * @param extensions
	 * @return
	 */
	public SdAbstractSequenceContent setExtensions(Map<String, Object> extensions) {
		this.extensions = extensions;
		return this;
	}

	@Override
	public String toString() {
		return "SdAbstractSequenceContent [name=" + name + ", dataType=" + dataType + ", minValue=" + minValue + ", maxValue=" + maxValue + ", incrementBy=" + incrementBy + ", start=" + start
				+ ", restart=" + restart + ", cache=" + cache + ", cycle=" + cycle + ", ownedBy=" + ownedBy + ", extensions=" + extensions + "]";
	}
}
