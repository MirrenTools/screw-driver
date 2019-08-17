package org.mirrentools.sd.converter.impl.postgresql;

import org.mirrentools.sd.converter.SdAbstractClassConverter;
import org.mirrentools.sd.converter.SdTypeConverter;

/**
 * SdBean转换器PostgreSql版实现
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class SdClassConverterPostgreSqlImpl extends SdAbstractClassConverter {
	/** 将数据库数据类型转换为Java类型 */
	private SdTypeConverter typeConverter;

	/**
	 * 使用默认的SQL数据类型转换器初始化
	 */
	public SdClassConverterPostgreSqlImpl() {
		super();
		this.typeConverter = new SdTypeConverterPostgreSqlToJavaImpl();
	}

	/**
	 * 使用自定义的SQL转实体类转换器初始化
	 * 
	 * @param typeConverter
	 */
	public SdClassConverterPostgreSqlImpl(SdTypeConverter typeConverter) {
		super();
		this.typeConverter = typeConverter;
	}

	@Override
	public SdTypeConverter getTypeConverter() {
		return typeConverter;
	}

	@Override
	public SdClassConverterPostgreSqlImpl setTypeConverter(SdTypeConverter typeConverter) {
		this.typeConverter = typeConverter;
		return this;
	}

}
