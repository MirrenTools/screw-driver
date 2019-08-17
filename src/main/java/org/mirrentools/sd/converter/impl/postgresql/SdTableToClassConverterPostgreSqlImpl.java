package org.mirrentools.sd.converter.impl.postgresql;

import org.mirrentools.sd.converter.SdAbstractTableToClassConverter;
import org.mirrentools.sd.converter.SdClassConverter;

/**
 * 将SdTable转换为SdClassContent的转换器的PostgreSql版
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public class SdTableToClassConverterPostgreSqlImpl extends SdAbstractTableToClassConverter {

	/** 将Bean转换为内容的类转换器 */
	private SdClassConverter classConverter;

	/**
	 * 实例化一个默认的类型转换
	 */
	public SdTableToClassConverterPostgreSqlImpl() {
		super();
		this.classConverter = new SdClassConverterPostgreSqlImpl();
	}

	/**
	 * 实例化一个指定类转换器
	 * 
	 * @param classConverter
	 */
	public SdTableToClassConverterPostgreSqlImpl(SdClassConverter classConverter) {
		super();
		this.classConverter = classConverter;
	}

	@Override
	public SdClassConverter getClassConverter() {
		return classConverter;
	}

	@Override
	public SdTableToClassConverterPostgreSqlImpl setClassConverter(SdClassConverter classConverter) {
		this.classConverter = classConverter;
		return this;
	}

}
