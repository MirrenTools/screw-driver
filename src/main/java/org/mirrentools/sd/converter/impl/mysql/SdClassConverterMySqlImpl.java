package org.mirrentools.sd.converter.impl.mysql;

import org.mirrentools.sd.constant.Java;
import org.mirrentools.sd.constant.SdType;
import org.mirrentools.sd.converter.SdAbstractClassConverter;
import org.mirrentools.sd.converter.SdBasicTypeConverter;
import org.mirrentools.sd.converter.SdTypeConverter;
import org.mirrentools.sd.enums.SdTypeMode;

/**
 * SdBean转换器MySQL版实现
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class SdClassConverterMySqlImpl extends SdAbstractClassConverter {
	/** 将数据库数据类型转换为Java类型 */
	private SdTypeConverter typeConverter;

	/**
	 * 使用默认的SQL数据类型转换器初始化
	 */
	public SdClassConverterMySqlImpl() {
		super();
		this.typeConverter = new SdBasicTypeConverter(Java.OBJECT, SdType.getDictionary(SdTypeMode.JAVA));
	}

	/**
	 * 使用自定义的SQL转实体类转换器初始化
	 * 
	 * @param typeConverter
	 */
	public SdClassConverterMySqlImpl(SdTypeConverter typeConverter) {
		super();
		this.typeConverter = typeConverter;
	}

	@Override
	public SdTypeConverter getTypeConverter() {
		return typeConverter;
	}

	@Override
	public SdClassConverterMySqlImpl setTypeConverter(SdTypeConverter typeConverter) {
		this.typeConverter = typeConverter;
		return this;
	}

}
