package org.mirrentools.sd.converter.impl.db2;

import org.mirrentools.sd.converter.SdAbstractClassConverter;
import org.mirrentools.sd.converter.SdTypeConverter;

public class SdClassConverterDB2Impl  extends SdAbstractClassConverter  {
	/** 将数据库数据类型转换为Java类型 */
	private SdTypeConverter typeConverter;

	/**
	 * 使用默认的SQL数据类型转换器初始化
	 */
	public SdClassConverterDB2Impl() {
		super();
		this.typeConverter = new SdTypeConverterDB2ToJavaImpl();
	}

	/**
	 * 使用自定义的SQL转实体类转换器初始化
	 * 
	 * @param typeConverter
	 */
	public SdClassConverterDB2Impl(SdTypeConverter typeConverter) {
		super();
		this.typeConverter = typeConverter;
	}

	@Override
	public SdTypeConverter getTypeConverter() {
		return typeConverter;
	}

	@Override
	public SdClassConverterDB2Impl setTypeConverter(SdTypeConverter typeConverter) {
		this.typeConverter = typeConverter;
		return this;
	}
}
