package org.mirrentools.sd.converter.impl.mysql;

import org.mirrentools.sd.converter.SdAbstractTableToClassConverter;
import org.mirrentools.sd.converter.SdClassConverter;

/**
 * 将SdTable转换为SdClassContent的转换器的MySQL版
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public class SdTableToClassConverterMySqlImpl extends SdAbstractTableToClassConverter {

	/** 将Bean转换为内容的类转换器 */
	private SdClassConverter classConverter;
	/**
	 * 实例化一个默认的类型转换
	 */
	public SdTableToClassConverterMySqlImpl() {
		super();
		this.classConverter = new SdClassConverterMySqlImpl();
	}
	/**
	 * 实例化一个指定类转换器
	 * 
	 * @param classConverter
	 */
	public SdTableToClassConverterMySqlImpl(SdClassConverter classConverter) {
		super();
		this.classConverter = classConverter;
	}

	@Override
	public SdClassConverter getClassConverter() {
		return classConverter;
	}

	@Override
	public SdTableToClassConverterMySqlImpl setClassConverter(SdClassConverter classConverter) {
		this.classConverter = classConverter;
		return this;
	}

}
