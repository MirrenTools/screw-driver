package org.mirrentools.sd.converter;

/**
 * 将SdTable转换为SdClassContent的基本实现
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class SdBasicTableToClassConverter extends SdAbstractTableToClassConverter {
	/** 将Bean转换为内容的类转换器 */
	private SdClassConverter classConverter;

	/**
	 * 初始化
	 * 
	 * @param classConverter
	 *          实体类转换器
	 */
	public SdBasicTableToClassConverter(SdClassConverter classConverter) {
		super();
		this.classConverter = classConverter;
	}

	@Override
	public SdClassConverter getClassConverter() {
		return classConverter;
	}

	@Override
	public SdTableToClassConverter setClassConverter(SdClassConverter classConverter) {
		this.classConverter = classConverter;
		return this;
	}

}
