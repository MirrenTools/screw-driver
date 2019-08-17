package org.mirrentools.sd.models;

/**
 * 数据库序列
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class SdSequence {
	/** 最小值 */
	private Long minValue;
	/** 最大值 */
	private Long maxValue;
	/** 每次累加多少 */
	private Long incrementBy;
	/** 开始计数 */
	private Long start;
	/** 最大值 */
	private Long cache;
	/** 是否循环 */
	private Boolean cycle;

	public Long getMinValue() {
		return minValue;
	}

	public SdSequence setMinValue(Long minValue) {
		this.minValue = minValue;
		return this;
	}

	public Long getMaxValue() {
		return maxValue;
	}

	public SdSequence setMaxValue(Long maxValue) {
		this.maxValue = maxValue;
		return this;
	}

	public Long getIncrementBy() {
		return incrementBy;
	}

	public SdSequence setIncrementBy(Long incrementBy) {
		this.incrementBy = incrementBy;
		return this;
	}

	public Long getStart() {
		return start;
	}

	public SdSequence setStart(Long start) {
		this.start = start;
		return this;
	}

	public Long getCache() {
		return cache;
	}

	public SdSequence setCache(Long cache) {
		this.cache = cache;
		return this;
	}

	public Boolean getCycle() {
		return cycle;
	}

	public SdSequence setCycle(Boolean cycle) {
		this.cycle = cycle;
		return this;
	}

	@Override
	public String toString() {
		return "SdSequence [minValue=" + minValue + ", maxValue=" + maxValue + ", incrementBy=" + incrementBy + ", start=" + start + ", cache=" + cache + ", cycle=" + cycle + "]";
	}

}
