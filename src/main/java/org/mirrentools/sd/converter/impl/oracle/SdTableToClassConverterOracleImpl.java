package org.mirrentools.sd.converter.impl.oracle;

import org.mirrentools.sd.converter.SdAbstractTableToClassConverter;
import org.mirrentools.sd.converter.SdClassConverter;

public class SdTableToClassConverterOracleImpl extends SdAbstractTableToClassConverter{
	/** 将Bean转换为内容的类转换器 */
	private SdClassConverter classConverter;

	/**
	 * 实例化一个默认的类型转换
	 */
	public SdTableToClassConverterOracleImpl() {
		super();
		this.classConverter = new SdClassConverterOracleImpl();
	}

	/**
	 * 实例化一个指定类转换器
	 * 
	 * @param classConverter
	 */
	public SdTableToClassConverterOracleImpl(SdClassConverter classConverter) {
		super();
		this.classConverter = classConverter;
	}

	@Override
	public SdClassConverter getClassConverter() {
		return classConverter;
	}

	@Override
	public SdTableToClassConverterOracleImpl setClassConverter(SdClassConverter classConverter) {
		this.classConverter = classConverter;
		return this;
	}
}
