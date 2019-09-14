package org.mirrentools.sd.enums;

/**
 * SdColumn数据类型的模式
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public enum SdTypeMode {
	/** common通用数据库数据类型,该类型最低级会被其他类型覆盖 */
	COMMON,
	/** Java数据类型 */
	JAVA,
	/** MySQL数据类型 */
	MYSQL,
	/** PostgreSQL数据类型 */
	POSTGRE_SQL,
	/** DB2数据类型 */
	DB2,
	/** Oracle数据类型 */
	ORACLE,
	/** SQL Server数据类型 */
	SQL_SERVER,
	/** Sqlite数据类型 */
	SQLITE,
	/** 自定义数据类型,该类型最高级会覆盖其他类型 */
	CUSTOM;
}
