package org.mirrentools.sd.impl;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.mirrentools.sd.ScrewDriverDbUtil;
import org.mirrentools.sd.ScrewDriverException;
import org.mirrentools.sd.ScrewDriverSQL;
import org.mirrentools.sd.common.SdUtil;
import org.mirrentools.sd.converter.SdDatabaseContentConverter;
import org.mirrentools.sd.converter.SdTableContentConverter;
import org.mirrentools.sd.models.SdBean;
import org.mirrentools.sd.models.SdDatabase;
import org.mirrentools.sd.models.db.update.SdAbstractDatabaseContent;
import org.mirrentools.sd.models.db.update.SdAbstractTableContent;
import org.mirrentools.sd.options.ScrewDriverOptions;
import org.mirrentools.sd.options.SdDatabaseOptions;

/**
 * SQL生成器的默认实现
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class ScrewDriverSqlImpl implements ScrewDriverSQL {
	/** JUL日志 */
	private final Logger LOG = Logger.getLogger(this.getClass().getName());

	/** 数据库连接属性 */
	private SdDatabaseOptions databaseOptions;

	/** 数据库执行工具 */
	private ScrewDriverDbUtil dbUtil;
	/** SdBean转换器 */
	private SdTableContentConverter converter;
	/** SdDatabase转换器 */
	private SdDatabaseContentConverter databaseConverter;
	/** 拓展属性 */
	private Map<String, Object> extensions;

	/**
	 * 初始化
	 * 
	 * @param options
	 */
	public ScrewDriverSqlImpl(ScrewDriverOptions options) {
		super();
		this.databaseOptions = options.getDatabaseOptions();
		this.dbUtil = options.getDbUtil();
		this.converter = options.getTableConverter();
		this.databaseConverter = options.getDatabaseConverter();
		this.extensions = options.getExtensions();
	}

	@Override
	public boolean createDatabase(SdDatabase database) {
		SdUtil.requireNonNull(databaseConverter, "This database does not support database creation or SdDatabaseContentConverter options is null");
		SdAbstractDatabaseContent dbContent = databaseConverter.converter(database);
		if (dbContent != null) {
			try {
				return dbUtil.createDatabase(dbContent);
			} catch (Exception e) {
				throw new ScrewDriverException(e);
			}
		}
		return false;
	}

	@Override
	public boolean createTable(SdBean bean) {
		try {
			SdAbstractTableContent content = converter.converter(bean);
			return dbUtil.createTable(content);
		} catch (Exception e) {
			throw new ScrewDriverException(e);
		}
	}

	@Override
	public boolean alterTable(SdBean bean) {
		try {
			SdAbstractTableContent content = converter.converter(bean);
			return dbUtil.updateTable(content);
		} catch (Exception e) {
			throw new ScrewDriverException(e);
		}
	}

	@Override
	public boolean deleteTable(SdBean bean) {
		try {
			SdAbstractTableContent content = converter.converter(bean);
			return dbUtil.deleteTable(content);
		} catch (Exception e) {
			throw new ScrewDriverException(e);
		}
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
	public ScrewDriverDbUtil getDbUtil() {
		return dbUtil;
	}

	@Override
	public ScrewDriverSqlImpl setDbUtil(ScrewDriverDbUtil dbUtil) {
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
	public ScrewDriverSqlImpl addExtension(String key, Object value) {
		LOG.warning("This method expands the field as an alternate field, which can be inherited and rewritten if needed.");
		if (getExtensions() == null) {
			setExtensions(new LinkedHashMap<String, Object>());
		}
		getExtensions().put(key, value);
		return this;
	}

	@Override
	public Map<String, Object> getExtensions() {
		LOG.warning("This method expands the field as an alternate field, which can be inherited and rewritten if needed.");
		return extensions;
	}

	@Override
	public ScrewDriverSqlImpl setExtensions(Map<String, Object> extensions) {
		LOG.warning("This method expands the field as an alternate field, which can be inherited and rewritten if needed.");
		this.extensions = extensions;
		return this;
	}

	@Override
	public String toString() {
		return "ScrewDriverSqlImpl [databaseOptions=" + databaseOptions + ", dbUtil=" + dbUtil + ", converter=" + converter + ", extensions=" + extensions + "]";
	}

}
