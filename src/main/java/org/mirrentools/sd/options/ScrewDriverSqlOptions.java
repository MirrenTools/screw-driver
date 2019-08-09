package org.mirrentools.sd.options;

import org.mirrentools.sd.converter.SdTableContentConverter;
import org.mirrentools.sd.converter.impl.mysql.SdTableContentConverterImplByMySQL;
import org.mirrentools.sd.dbutil.SdDbUtil;
import org.mirrentools.sd.dbutil.impl.SdDbUtilImplByMySQL;

/**
 * 代码SQL相关工具的配置
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class ScrewDriverSqlOptions {
	/** 如果数据库不存在是否创建, 如果支持默认创建 */
	private boolean createDatabase = true;
	/** 如果表已经存在是否修改表,默认不修改表 */
	private boolean alterTable;
	/** 数据库连接属性 */
	private SdDatabaseOptions databaseOptions;
	/** 数据库执行工具, 默认MySQL版实现 */
	private SdDbUtil dbUtil;
	/** SdBean转换器, 默认MySQL版实现 */
	private SdTableContentConverter converter = new SdTableContentConverterImplByMySQL();

	/**
	 * 初始化一个配置
	 * 
	 * @param databaseOptions
	 *          数据库配置文件
	 */
	public ScrewDriverSqlOptions(SdDatabaseOptions databaseOptions) {
		super();
		this.databaseOptions = databaseOptions;
		setDbUtil(new SdDbUtilImplByMySQL(databaseOptions));
	}

	/**
	 * 获取如果数据库不存在是否创建数据库
	 * 
	 * @return
	 */
	public boolean isCreateDatabase() {
		return createDatabase;
	}

	/**
	 * 设置如果数据库不存在是否创建数据库
	 * 
	 * @param createDatabase
	 * @return
	 */
	public ScrewDriverSqlOptions setCreateDatabase(boolean createDatabase) {
		this.createDatabase = createDatabase;
		return this;
	}

	/**
	 * 获取如果表存在是否修改表
	 * 
	 * @return
	 */
	public boolean isAlterTable() {
		return alterTable;
	}

	/**
	 * 设置如果表存在是否修改表,默认不修改
	 * 
	 * @param alterTable
	 * @return
	 */
	public ScrewDriverSqlOptions setAlterTable(boolean alterTable) {
		this.alterTable = alterTable;
		return this;
	}

	/**
	 * 获取数据库配置文件
	 * 
	 * @return
	 */
	public SdDatabaseOptions getDatabaseOptions() {
		return databaseOptions;
	}

	/**
	 * 设置数据库配置文件
	 * 
	 * @param databaseOptions
	 * @return
	 */
	public ScrewDriverSqlOptions setDatabaseOptions(SdDatabaseOptions databaseOptions) {
		this.databaseOptions = databaseOptions;
		return this;
	}

	/**
	 * 获取数据库执行工具
	 * 
	 * @return
	 */
	public SdDbUtil getDbUtil() {
		return dbUtil;
	}

	/**
	 * 设置数据库执行工具
	 * 
	 * @param dbUtil
	 * @return
	 */
	public ScrewDriverSqlOptions setDbUtil(SdDbUtil dbUtil) {
		this.dbUtil = dbUtil;
		return this;
	}

	/**
	 * 获取数据库内容转换器
	 * 
	 * @return
	 */
	public SdTableContentConverter getConverter() {
		return converter;
	}

	/**
	 * 设置数据库内容转换器
	 * 
	 * @param converter
	 * @return
	 */
	public ScrewDriverSqlOptions setConverter(SdTableContentConverter converter) {
		this.converter = converter;
		return this;
	}

	@Override
	public String toString() {
		return "ScrewDriverSqlOptions [createDatabase=" + createDatabase + ", alterTable=" + alterTable + ", databaseOptions=" + databaseOptions + ", dbUtil=" + dbUtil + ", converter=" + converter + "]";
	}

}
