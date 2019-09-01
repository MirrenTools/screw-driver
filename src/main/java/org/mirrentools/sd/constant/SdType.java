package org.mirrentools.sd.constant;

import java.util.HashMap;
import java.util.Map;

import org.mirrentools.sd.ScrewDriverException;
import org.mirrentools.sd.common.SdUtil;
import org.mirrentools.sd.enums.SdTypeMode;

/**
 * SdColumn数据类型常量,该常量中的数据类型会自动转换为java与不同数据库语言类型,特殊的数据类型需要先调用put,获取时使用字符串
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class SdType {
	// ***********************************************************
	// **********************通用数据类型***************************
	// ***********************************************************
	/**
	 * 数据类型String,对应类型:<br>
	 * Java=String<br>
	 * 所有数据库=VARCHAR
	 */
	public final static String STRING = Java.STRING;
	/**
	 * 数据类型char,对应类型:<br>
	 * Java=String<br>
	 * 所有数据库=CHAR
	 */
	public final static String CHAR = SQL.CHAR;
	/**
	 * 数据类型varchar,对应类型:<br>
	 * Java=String<br>
	 * 所有数据库=VARCHAR
	 */
	public final static String VARCHAR = SQL.VARCHAR;

	/**
	 * 数据类型short,对应类型:<br>
	 * Java=short<br>
	 * 所有数据库=SMALLINT<br>
	 */
	public final static String SHORT = SQL.SMALLINT;
	/**
	 * 数据类型Short,对应类型:<br>
	 * Java=Short<br>
	 * 所有数据库=SMALLINT<br>
	 */
	public final static String SHORT_OBJ = SQL.SMALLINT;

	/**
	 * 数据类型int,对应类型:<br>
	 * Java=int<br>
	 * 所有数据库=INT
	 */
	public final static String INT = SQL.INT;
	/**
	 * 数据类型integer,对应类型:<br>
	 * Java=Integer<br>
	 * 所有数据库=INTEGER<br>
	 */
	public final static String INTEGER = SQL.INTEGER;

	/**
	 * 数据类型long,对应类型:<br>
	 * Java=long<br>
	 * 所有数据库=BIGINT<br>
	 */
	public final static String LONG = SQL.BIGINT;
	/**
	 * 数据类型long,对应类型:<br>
	 * Java=Long<br>
	 * 所有数据库=BIGINT<br>
	 */
	public final static String LONG_OBJ = SQL.BIGINT;
	/**
	 * 数据类型float,对应类型:<br>
	 * Java=float<br>
	 * 所有数据库=FLOAT<br>
	 */
	public final static String FLOAT = SQL.FLOAT;
	/**
	 * 数据类型float,对应类型:<br>
	 * Java=Float<br>
	 * 所有数据库=FLOAT<br>
	 */
	public final static String FLOAT_OBJ = SQL.FLOAT;
	/**
	 * 数据类型real,对应类型:<br>
	 * Java=Number<br>
	 * 所有数据库=REAL<br>
	 */
	public final static String REAL = SQL.REAL;

	/**
	 * 数据类型double,对应类型:<br>
	 * Java=double<br>
	 * 所有数据库=DOUBLE<br>
	 */
	public final static String DOUBLE = SQL.DOUBLE;

	/**
	 * 数据类型double,对应类型:<br>
	 * Java=Double<br>
	 * 所有数据库=DOUBLE<br>
	 */
	public final static String DOUBLE_OBJ = SQL.DOUBLE;

	/**
	 * 数据类型numeric,对应类型:<br>
	 * Java=Number<br>
	 * 所有数据库=NUMERIC<br>
	 */
	public final static String NUMERIC = SQL.NUMERIC;
	/**
	 * 数据类型decimal,对应类型:<br>
	 * Java=BigDecimal<br>
	 * 所有数据库=DECIMAL<br>
	 */
	public final static String DECIMAL = SQL.DECIMAL;
	/**
	 * 数据类型datetime,对应类型:<br>
	 * Java=java.time.LocalDateTime<br>
	 * 所有数据库=DATETIME<br>
	 */
	public final static String DATETIME = SQL.DATETIME;
	/**
	 * 数据类型date,对应类型:<br>
	 * Java=java.time.LocalDate<br>
	 * 所有数据库=DATE<br>
	 */
	public final static String DATE = SQL.DATE;
	/**
	 * 数据类型time,对应类型:<br>
	 * Java=java.time.LocalTime<br>
	 * 所有数据库=DATE<br>
	 */
	public final static String TIME = SQL.TIME;
	/**
	 * 数据类型timestamp,对应类型:<br>
	 * Java=java.time.Instant<br>
	 * 所有数据库=DATE<br>
	 */
	public final static String TIMESTAMP = SQL.TIMESTAMP;

	// ***********************************************************
	// **********************不通用数据类型***************************
	// ***********************************************************
	/**
	 * 数据类型byte,对应类型:<br>
	 * Java=byte<br>
	 * MySQL=TINYINT<br>
	 * PostgreSQL=SMALLINT
	 */
	public final static String BYTE = SQL.TINYINT;
	/**
	 * 数据类型char,对应类型:<br>
	 * Java=boolean<br>
	 * MySQL=BOOLEAN<br>
	 * PostgreSQL=BOOLEAN<br>
	 */
	public final static String BOOLEAN = SQL.BOOLEAN;
	/**
	 * 数据类型char,对应类型:<br>
	 * Java=String<br>
	 * MySQL=char<br>
	 * PostgreSQL=char<br>
	 */
	public final static String BOOLEAN_OBJ = SQL.BOOLEAN;

	/**
	 * 数据类型char,对应类型:<br>
	 * Java=String<br>
	 * MySQL=char<br>
	 * PostgreSQL=char<br>
	 */
	public final static String NCHAR = SQL.NCHAR;
	/**
	 * 数据类型nvarchar,对应类型:<br>
	 * Java=String<br>
	 * MySQL=varchar<br>
	 * PostgreSQL=varchar<br>
	 */
	public final static String NVARCHAR = SQL.NVARCHAR;
	/**
	 * 数据类型varchar2,对应类型:<br>
	 * Java=String<br>
	 * MySQL=varchar<br>
	 * PostgreSQL=varchar<br>
	 */
	public final static String VARCHAR2 = SQL.VARCHAR2;
	/**
	 * 数据类型number,对应类型:<br>
	 * Java=Number<br>
	 * MySQL=NUMERIC<br>
	 * PostgreSQL=NUMERIC<br>
	 */
	public final static String NUMBER = SQL.NUMERIC;
	/**
	 * 数据类型money,对应类型:<br>
	 * Java=BigDecimal<br>
	 * MySQL=DECIMAL<br>
	 * PostgreSQL=MONEY<br>
	 */
	public final static String MONEY = SQL.MONEY;
	/**
	 * 数据类型text,对应类型:<br>
	 * Java=String<br>
	 * MySQL=TEXT PostgreSQL=text
	 */
	public final static String TEXT = SQL.TEXT;
	/**
	 * 数据类型longtext,对应类型:<br>
	 * Java=String<br>
	 * MySQL=LONGTEXT PostgreSQL=text
	 */
	public final static String LONGTEXT = SQL.LONGTEXT;

	// ***********************************************************
	// ************************数据类型映射**************************
	// ***********************************************************
	/** Java数据类型映射 */
	public static final Map<String, String> JAVA_MAPS;
	/** 通用数据库数据类型映射 */
	public static final Map<String, String> COMMON_MAPS;
	/** MySQL数据类型映射 */
	public static final Map<String, String> MYSQL_MAPS;
	/** PostgreSQL数据类型映射 */
	public static final Map<String, String> POSTGRE_SQL_MAPS;
	/** DB2数据类型映射 */
	public static final Map<String, String> DB2_MAPS;
	/** Oracle数据类型映射 */
	public static final Map<String, String> ORACLE_MAPS;
	/** SqlServer数据类型映射 */
	public static final Map<String, String> SQL_SERVER_MAPS;
	/** Sqlite数据类型映射 */
	public static final Map<String, String> SQLITE_MAPS;
	/** 自定义数据类型映射 */
	public static final Map<String, String> CUSTOM_MAPS;
	static {
		JAVA_MAPS = new HashMap<String, String>();
		COMMON_MAPS = new HashMap<String, String>();
		MYSQL_MAPS = new HashMap<String, String>();
		POSTGRE_SQL_MAPS = new HashMap<String, String>();
		DB2_MAPS = new HashMap<String, String>();
		ORACLE_MAPS = new HashMap<String, String>();
		SQL_SERVER_MAPS = new HashMap<String, String>();
		SQLITE_MAPS = new HashMap<String, String>();
		CUSTOM_MAPS = new HashMap<String, String>();

		// 通用数据库类型设置
		JAVA_MAPS.put(STRING, Java.STRING);
		COMMON_MAPS.put(STRING, SQL.VARCHAR);
		JAVA_MAPS.put(CHAR, Java.STRING);
		COMMON_MAPS.put(CHAR, SQL.CHAR);
		JAVA_MAPS.put(VARCHAR, Java.STRING);
		COMMON_MAPS.put(VARCHAR, SQL.VARCHAR);
		JAVA_MAPS.put(SHORT, Java.SHORT);
		COMMON_MAPS.put(SHORT, SQL.SMALLINT);
		JAVA_MAPS.put(SHORT_OBJ, Java.SHORT_OBJ);
		COMMON_MAPS.put(SHORT_OBJ, SQL.SMALLINT);
		JAVA_MAPS.put(INT, Java.INT);
		COMMON_MAPS.put(INT, SQL.INT);
		JAVA_MAPS.put(INTEGER, Java.INTEGER);
		COMMON_MAPS.put(INTEGER, SQL.INTEGER);
		JAVA_MAPS.put(LONG, Java.LONG);
		COMMON_MAPS.put(LONG, SQL.BIGINT);
		JAVA_MAPS.put(LONG_OBJ, Java.LONG_OBJ);
		COMMON_MAPS.put(LONG_OBJ, SQL.BIGINT);
		JAVA_MAPS.put(FLOAT, Java.FLOAT);
		COMMON_MAPS.put(FLOAT, SQL.FLOAT);
		JAVA_MAPS.put(FLOAT_OBJ, Java.FLOAT_OBJ);
		COMMON_MAPS.put(FLOAT_OBJ, SQL.FLOAT);
		JAVA_MAPS.put(REAL, Java.NUMBER);
		COMMON_MAPS.put(REAL, SQL.REAL);
		JAVA_MAPS.put(DOUBLE, Java.DOUBLE);
		COMMON_MAPS.put(DOUBLE, SQL.DOUBLE);
		JAVA_MAPS.put(DOUBLE_OBJ, Java.DOUBLE_OBJ);
		COMMON_MAPS.put(DOUBLE_OBJ, SQL.DOUBLE);
		JAVA_MAPS.put(NUMERIC, Java.NUMBER);
		COMMON_MAPS.put(NUMERIC, SQL.NUMERIC);
		JAVA_MAPS.put(DECIMAL, Java.BIG_DECIMAL);
		COMMON_MAPS.put(DECIMAL, SQL.DECIMAL);
		JAVA_MAPS.put(DATETIME, Java.LOCAL_DATE_TIME);
		COMMON_MAPS.put(DATETIME, SQL.DATETIME);
		JAVA_MAPS.put(DATE, Java.LOCAL_DATE);
		COMMON_MAPS.put(DATE, SQL.DATE);
		JAVA_MAPS.put(TIME, Java.LOCAL_TIME);
		COMMON_MAPS.put(TIME, SQL.TIME);
		JAVA_MAPS.put(TIMESTAMP, Java.INSTANT);
		COMMON_MAPS.put(TIMESTAMP, SQL.TIMESTAMP);
		// TODO 添加通用类型到map中

		
		
		// 不通用的数据类型
		JAVA_MAPS.put(BYTE, Java.BYTE);
		MYSQL_MAPS.put(BYTE, MySQL.TINYINT);
		POSTGRE_SQL_MAPS.put(BYTE, PostgreSQL.SMALLINT);

		JAVA_MAPS.put(BOOLEAN, Java.BOOLEAN);
		MYSQL_MAPS.put(BOOLEAN, MySQL.BOOLEAN);
		POSTGRE_SQL_MAPS.put(BOOLEAN, PostgreSQL.BOOLEAN);

		JAVA_MAPS.put(BOOLEAN_OBJ, Java.BOOLEAN_OBJ);
		MYSQL_MAPS.put(BOOLEAN_OBJ, MySQL.BOOLEAN);
		POSTGRE_SQL_MAPS.put(BOOLEAN_OBJ, PostgreSQL.BOOLEAN);

		JAVA_MAPS.put(NCHAR, Java.STRING);
		MYSQL_MAPS.put(NCHAR, MySQL.CHAR);
		POSTGRE_SQL_MAPS.put(NCHAR, PostgreSQL.CHAR);

		JAVA_MAPS.put(NVARCHAR, Java.STRING);
		MYSQL_MAPS.put(NVARCHAR, MySQL.VARCHAR);
		POSTGRE_SQL_MAPS.put(NVARCHAR, PostgreSQL.VARCHAR);

		JAVA_MAPS.put(VARCHAR2, Java.STRING);
		MYSQL_MAPS.put(VARCHAR2, MySQL.VARCHAR);
		POSTGRE_SQL_MAPS.put(VARCHAR2, PostgreSQL.VARCHAR);

		JAVA_MAPS.put(MONEY, Java.BIG_DECIMAL);
		MYSQL_MAPS.put(MONEY, MySQL.DECIMAL);
		POSTGRE_SQL_MAPS.put(MONEY, PostgreSQL.MONEY);

		JAVA_MAPS.put(NUMBER, Java.NUMBER);
		MYSQL_MAPS.put(NUMBER, MySQL.NUMERIC);
		POSTGRE_SQL_MAPS.put(NUMBER, PostgreSQL.NUMERIC);

		JAVA_MAPS.put(TEXT, Java.STRING);
		MYSQL_MAPS.put(TEXT, MySQL.TEXT);
		POSTGRE_SQL_MAPS.put(TEXT, PostgreSQL.TEXT);

		JAVA_MAPS.put(LONGTEXT, Java.STRING);
		MYSQL_MAPS.put(LONGTEXT, MySQL.LONGTEXT);
		POSTGRE_SQL_MAPS.put(LONGTEXT, PostgreSQL.TEXT);
		// TODO 添加不通用不同数据库到map中
	}

	/**
	 * 获取对应的数据类型
	 * 
	 * @param type
	 *          数据类型
	 * @param mode
	 *          对应那个类型的数据
	 * @return
	 */
	public static String get(String type, SdTypeMode mode) {
		SdUtil.requireNonEmpty(type, "The type cannot be null");
		SdUtil.requireNonEmpty(mode, "The mode cannot be null");
		switch (mode) {
		case JAVA:
			return JAVA_MAPS.get(type);
		case COMMON:
			COMMON_MAPS.get(type);
		case MYSQL:
			return MYSQL_MAPS.get(type);
		case POSTGRE_SQL:
			return POSTGRE_SQL_MAPS.get(type);
		case DB2:
			return DB2_MAPS.get(type);
		case ORACLE:
			return ORACLE_MAPS.get(type);
		case SQL_SERVER:
			return SQL_SERVER_MAPS.get(type);
		case SELITE:
			return SQLITE_MAPS.get(type);
		case CUSTOM:
			return CUSTOM_MAPS.get(type);
		default:
			return null;
		}
	}

	/**
	 * 添加数据
	 * 
	 * @param mode
	 *          添加到那个类型中
	 * @param type
	 *          类型的对应的key
	 * @param value
	 *          类型对应的值
	 */
	public static void put(SdTypeMode mode, String type, String value) {
		switch (mode) {
		case JAVA:
			JAVA_MAPS.put(type, value);
		case COMMON:
			COMMON_MAPS.put(type, value);
		case MYSQL:
			MYSQL_MAPS.put(type, value);
		case POSTGRE_SQL:
			POSTGRE_SQL_MAPS.put(type, value);
		case DB2:
			DB2_MAPS.put(type, value);
		case ORACLE:
			ORACLE_MAPS.put(type, value);
		case SQL_SERVER:
			SQL_SERVER_MAPS.put(type, value);
		case SELITE:
			SQLITE_MAPS.put(type, value);
		case CUSTOM:
			CUSTOM_MAPS.put(type, value);
		default:
			throw new ScrewDriverException("The mode invalid");
		}
	}

}
