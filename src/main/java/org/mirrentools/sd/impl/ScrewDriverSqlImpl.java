package org.mirrentools.sd.impl;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.mirrentools.sd.ScrewDriverException;
import org.mirrentools.sd.ScrewDriverSQL;
import org.mirrentools.sd.converter.SdTableContentConverter;
import org.mirrentools.sd.dbutil.SdDbUtil;
import org.mirrentools.sd.models.SdBean;
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
	/** 拓展属性 */
	private Map<String, Object> extensions;

	/**
	 * 初始化
	 * 
	 * @param options
	 */
	public ScrewDriverSqlImpl(ScrewDriverOptions options) {
		super();
		this.bean = options.getBean();
		this.databaseOptions = options.getDatabaseOptions();
		this.createDatabase = options.isCreateDatabase();
		this.alterTable = options.isAlterTable();
		this.dbUtil = options.getDbUtil();
		this.converter = options.getTableConverter();
		this.extensions = options.getExtensions();
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
		return "ScrewDriverSqlImpl [bean=" + bean + ", databaseOptions=" + databaseOptions + ", createDatabase=" + createDatabase + ", alterTable=" + alterTable + ", dbUtil=" + dbUtil + ", converter="
				+ converter + ", extensions=" + extensions + "]";
	}

}
