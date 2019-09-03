package org.mirrentools.sd.converter;

/**
 * SdBean转换器的基本实现
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class SdBasicClassConverter extends SdAbstractClassConverter {
	/** 将数据库数据类型转换为Java类型 */
	private SdTypeConverter typeConverter;

	/**
	 * 初始化
	 * 
	 * @param typeConverter
	 *          类型转换器
	 */
	public SdBasicClassConverter(SdTypeConverter typeConverter) {
		super();
		this.typeConverter = typeConverter;
	}

	@Override
	public SdTypeConverter getTypeConverter() {
		return typeConverter;
	}

	@Override
	public SdBasicClassConverter setTypeConverter(SdTypeConverter typeConverter) {
		this.typeConverter = typeConverter;
		return this;
	}

}
