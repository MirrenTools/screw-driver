package org.mirrentools.sd.impl;

import java.util.Map;

import org.mirrentools.sd.ScrewDriverCode;
import org.mirrentools.sd.ScrewDriverException;
import org.mirrentools.sd.ScrewDriverSQL;
import org.mirrentools.sd.converter.SdTableContentConverter;
import org.mirrentools.sd.dbutil.SdDbUtil;
import org.mirrentools.sd.models.SdBean;
import org.mirrentools.sd.models.db.update.SdAbstractTableContent;
import org.mirrentools.sd.options.ScrewDriverSqlOptions;
import org.mirrentools.sd.options.SdDatabaseOptions;

/**
 * SQL生成器的默认实现
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class ScrewDriverSqlImpl implements ScrewDriverSQL {
	/** 创建类需要的属性 */
	private SdBean bean;
	/** 数据库连接属性 */
	private SdDatabaseOptions databaseOptions;

	/** 如果数据库不存在是否创建, 如果支持默认创建 */
	private boolean createDatabase = true;
	/** 如果表已经存在是否修改表,默认不修改表 */
	private boolean alterTable;
	/** 数据库执行工具 */
	private SdDbUtil dbUtil;
	/** SdBean转换器 */
	private SdTableContentConverter converter;

	/**
	 * 初始化一个数据库相关执行器
	 * 
	 * @param bean
	 *          生成所需要的实体属性
	 * @param databaseOptions
	 *          数据库连接属性
	 */
	public ScrewDriverSqlImpl(SdBean bean, SdDatabaseOptions databaseOptions) {
		super();
		this.bean = bean;
		this.init(new ScrewDriverSqlOptions(databaseOptions));
	}

	/**
	 * 初始化一个数据库相关执行器
	 * 
	 * @param bean
	 *          生成所需要的实体属性
	 * @param options
	 *          执行器配置
	 */
	public ScrewDriverSqlImpl(SdBean bean, ScrewDriverSqlOptions options) {
		super();
		this.bean = bean;
		init(options);
	}

	/**
	 * 初始化工具
	 * 
	 * @param options
	 */
	private void init(ScrewDriverSqlOptions options) {
		setDatabaseOptions(options.getDatabaseOptions());
		setCreateDatabase(options.isCreateDatabase());
		setAlterTable(options.isAlterTable());
		setDbUtil(options.getDbUtil());
		setConverter(options.getConverter());
	}

	@Override
	public boolean execute() {
		SdAbstractTableContent content = converter.converter(bean);
		try {
			return dbUtil.createTable(content);
		} catch (Exception e) {
			throw new ScrewDriverException(e);
		}
	}

	@Override
	public SdBean getBean() {
		return bean;
	}

	@Override
	public ScrewDriverSqlImpl setBean(SdBean bean) {
		this.bean = bean;
		return this;
	}

	@Override
	public SdDatabaseOptions getDatabaseOptions() {
		return databaseOptions;
	}

	@Override
	public ScrewDriverSqlImpl setDatabaseOptions(SdDatabaseOptions dbOptions) {
		this.databaseOptions = dbOptions;
		return this;
	}

	@Override
	public boolean isCreateDatabase() {
		return createDatabase;
	}

	@Override
	public ScrewDriverSqlImpl setCreateDatabase(boolean createDatabase) {
		this.createDatabase = createDatabase;
		return this;
	}

	@Override
	public boolean isAlterTable() {
		return alterTable;
	}

	@Override
	public ScrewDriverSqlImpl setAlterTable(boolean alterTable) {
		this.alterTable = alterTable;
		return this;
	}

	@Override
	public SdDbUtil getDbUtil() {
		return dbUtil;
	}

	@Override
	public ScrewDriverSqlImpl setDbUtil(SdDbUtil dbUtil) {
		this.dbUtil = dbUtil;
		return this;
	}

	@Override
	public SdTableContentConverter getConverter() {
		return converter;
	}

	@Override
	public ScrewDriverSqlImpl setConverter(SdTableContentConverter converter) {
		this.converter = converter;
		return this;
	}

	@Override
	public ScrewDriverCode addExtension(String key, Object value) {
		throw new ScrewDriverException("This method expands the field as an alternate field, which can be inherited and rewritten if needed.");
	}

	@Override
	public Map<String, Object> getExtensions() {
		throw new ScrewDriverException("This method expands the field as an alternate field, which can be inherited and rewritten if needed.");
	}

	@Override
	public ScrewDriverCode setExtensions(Map<String, Object> extensions) {
		throw new ScrewDriverException("This method expands the field as an alternate field, which can be inherited and rewritten if needed.");
	}

	@Override
	public String toString() {
		return "SdSqlUtillImpl [bean=" + bean + ", dbUtil=" + dbUtil + ", converter=" + converter + "]";
	}

}
