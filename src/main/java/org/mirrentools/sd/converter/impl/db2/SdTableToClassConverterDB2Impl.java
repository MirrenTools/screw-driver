package org.mirrentools.sd.converter.impl.db2;

import org.mirrentools.sd.converter.SdAbstractTableToClassConverter;
import org.mirrentools.sd.converter.SdClassConverter;

public class SdTableToClassConverterDB2Impl extends SdAbstractTableToClassConverter{
	/** 将Bean转换为内容的类转换器 */
	private SdClassConverter classConverter;

	/**
	 * 实例化一个默认的类型转换
	 */
	public SdTableToClassConverterDB2Impl() {
		super();
		this.classConverter = new SdClassConverterDB2Impl();
	}

	/**
	 * 实例化一个指定类转换器
	 * 
	 * @param classConverter
	 */
	public SdTableToClassConverterDB2Impl(SdClassConverter classConverter) {
		super();
		this.classConverter = classConverter;
	}

	@Override
	public SdClassConverter getClassConverter() {
		return classConverter;
	}

	@Override
	public SdTableToClassConverterDB2Impl setClassConverter(SdClassConverter classConverter) {
		this.classConverter = classConverter;
		return this;
	}
}
