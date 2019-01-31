package org.mirrentools.sd.converter.impl.mysql;

import org.mirrentools.sd.converter.SdAbstractBeanConverterToClass;
import org.mirrentools.sd.converter.SdTypeConverter;

/**
 * SdBean装换器MySQL版实现
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class SdBeanConverterToClassImplByMySQL extends SdAbstractBeanConverterToClass {
	/** 将数据库数据类型转换为Java类型 */
	private SdTypeConverter typeConverter;

	/**
	 * 使用默认的SQL数据类型转换器初始化
	 */
	public SdBeanConverterToClassImplByMySQL() {
		super();
		this.typeConverter = new SdTypeConverterImplByMySqlToJava();
	}
	/**
	 * 使用自定义的SQL转实体类转换器初始化
	 * 
	 * @param typeConverter
	 */
	public SdBeanConverterToClassImplByMySQL(SdTypeConverter typeConverter) {
		super();
		this.typeConverter = typeConverter;
	}

	@Override
	public SdTypeConverter getTypeConverter() {
		return typeConverter;
	}
	@Override
	public SdBeanConverterToClassImplByMySQL setTypeConverter(SdTypeConverter typeConverter) {
		this.typeConverter = typeConverter;
		return this;
	}

}
