package org.mirrentools.sd.util.impl;

import java.util.Map;

import org.mirrentools.sd.common.SdException;
import org.mirrentools.sd.converter.SdBeanConverterToTableContent;
import org.mirrentools.sd.dbutil.SdDbUtil;
import org.mirrentools.sd.models.SdBean;
import org.mirrentools.sd.models.db.update.AbstractTableContent;
import org.mirrentools.sd.options.SdDatabaseOptions;
import org.mirrentools.sd.util.SdCodeUtil;
import org.mirrentools.sd.util.SdSqlUtil;

/**
 * SQL生成器的默认实现
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class SdSqlUtilImpl implements SdSqlUtil {
	/** 创建类需要的属性 */
	private SdBean bean;
	/** 数据库连接属性 */
	private SdDatabaseOptions databaseOptions;
	/** 数据库执行工具 */
	private SdDbUtil dbUtil;
	/** SdBean转换器 */
	private SdBeanConverterToTableContent converter;

	/**
	 * 初始化一个数据库代码默认实现
	 * 
	 * @param bean
	 * @param dbUtil
	 * @param converter
	 */
	public SdSqlUtilImpl(SdBean bean, SdDbUtil dbUtil, SdBeanConverterToTableContent converter) {
		super();
		this.bean = bean;
		this.dbUtil = dbUtil;
		this.converter = converter;
	}

	@Override
	public boolean execute() {
		AbstractTableContent content = converter.converter(bean);
		try {
			return dbUtil.createTable(content);
		} catch (Exception e) {
			throw new SdException(e);
		}
	}

	@Override
	public SdBean getBean() {
		return bean;
	}

	@Override
	public SdSqlUtilImpl setBean(SdBean bean) {
		this.bean = bean;
		return this;
	}
	@Override
	public SdDatabaseOptions getDatabaseOptions() {
		return databaseOptions;
	}

	@Override
	public SdSqlUtilImpl setDatabaseOptions(SdDatabaseOptions dbOptions) {
		this.databaseOptions = dbOptions;
		return this;
	}
	@Override
	public SdDbUtil getDbUtil() {
		return dbUtil;
	}

	@Override
	public SdSqlUtilImpl setDbUtil(SdDbUtil dbUtil) {
		this.dbUtil = dbUtil;
		return this;
	}

	@Override
	public SdBeanConverterToTableContent getConverter() {
		return converter;
	}

	@Override
	public SdSqlUtilImpl setConverter(SdBeanConverterToTableContent converter) {
		this.converter = converter;
		return this;
	}

	@Override
	public SdCodeUtil addExtension(String key, Object value) {
		throw new SdException("该方法为备用拓展字段,如果需要使用到该字段可以继承后重写");
	}

	@Override
	public Map<String, Object> getExtensions() {
		throw new SdException("该方法为备用拓展字段,如果需要使用到该字段可以继承后重写");
	}

	@Override
	public SdCodeUtil setExtensions(Map<String, Object> extensions) {
		throw new SdException("该方法为备用拓展字段,如果需要使用到该字段可以继承后重写");
	}

	@Override
	public String toString() {
		return "SdSqlUtillImpl [bean=" + bean + ", dbUtil=" + dbUtil + ", converter=" + converter + "]";
	}

}
