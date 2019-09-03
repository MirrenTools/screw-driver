package org.mirrentools.sd.constant;

import java.util.HashMap;
import java.util.Map;

import org.mirrentools.sd.common.SdUtil;
import org.mirrentools.sd.enums.SdTypeMode;

/**
 * SdColumn数据类型常量,该常量中的数据类型会自动转换为java与不同数据库语言类型,可以通过put添加自定义类型
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class SdType {
	// ***********************************************************
	// **********************JAVA数据类型***************************
	// ***********************************************************
	/**
	 * 数据类型byte,对应类型:<br>
	 * Java=byte<br>
	 * MySQL=TINYINT<br>
	 * PostgreSQL=SMALLINT
	 */
	public final static String BYTE = "byte";
	/**
	 * 数据类型byte array,对应类型:<br>
	 * Java=byte[]<br>
	 * MySQL=BLOB<br>
	 * PostgreSQL=BYTEA
	 */
	public final static String BYTE_ARRAY = "byte_array";
	/**
	 * 数据类型boolean,对应类型:<br>
	 * Java=boolean<br>
	 * MySQL=BOOLEAN<br>
	 * PostgreSQL=BOOLEAN<br>
	 */
	public final static String BOOLEAN_BASIC = "boolean_basic";
	/**
	 * 数据类型Boolean,对应类型:<br>
	 * Java=Boolean<br>
	 * MySQL=BOOLEAN<br>
	 * PostgreSQL=BOOLEAN<br>
	 */
	public final static String BOOLEAN = "Boolean";
	/**
	 * 数据类型String,对应类型:<br>
	 * Java=String<br>
	 * MySQL=VARCHAR<br>
	 * PostgreSQL=VARCHAR<br>
	 */
	public final static String STRING = "String";
	/**
	 * 数据类型short,对应类型:<br>
	 * Java=short<br>
	 * MySQL=SMALLINT<br>
	 * PostgreSQL=SMALLINT<br>
	 */
	public final static String SHORT_BASIC = "short_basic";
	/**
	 * 数据类型Short,对应类型:<br>
	 * Java=Short<br>
	 * MySQL=SMALLINT<br>
	 * PostgreSQL=SMALLINT<br>
	 */
	public final static String SHORT = "Short";

	/**
	 * 数据类型int,对应类型:<br>
	 * Java=int<br>
	 * MySQL=INT<br>
	 * PostgreSQL=INTEGER<br>
	 */
	public final static String INT_BASIC = "int_basic";
	/**
	 * 数据类型Integer,对应类型:<br>
	 * Java=Integer<br>
	 * MySQL=INT<br>
	 * PostgreSQL=INTEGER<br>
	 */
	public final static String INTEGER = "Integer";
	/**
	 * 数据类型long,对应类型:<br>
	 * Java=long<br>
	 * MySQL=BIGINT<br>
	 * PostgreSQL=BIGINT<br>
	 */
	public final static String LONG_BASIC = "long_basic";
	/**
	 * 数据类型Long,对应类型:<br>
	 * Java=Long<br>
	 * MySQL=BIGINT<br>
	 * PostgreSQL=BIGINT<br>
	 */
	public final static String LONG = "Long";
	/**
	 * 数据类型float,对应类型:<br>
	 * Java=float<br>
	 * MySQL=FLOAT<br>
	 * PostgreSQL=REAL<br>
	 */
	public final static String FLOAT_BASIC = "float_basic";
	/**
	 * 数据类型Float,对应类型:<br>
	 * Java=Float<br>
	 * MySQL=FLOAT<br>
	 * PostgreSQL=REAL<br>
	 */
	public final static String FLOAT = "Float";
	/**
	 * 数据类型double,对应类型:<br>
	 * Java=double<br>
	 * MySQL=DOUBLE<br>
	 * PostgreSQL=DOUBLE PRECISION<br>
	 */
	public final static String DOUBLE_BASIC = "double_basic";

	/**
	 * 数据类型Double,对应类型:<br>
	 * Java=Double<br>
	 * 所有数据库=DOUBLE PRECISION<br>
	 */
	public final static String DOUBLE = "Double";
	/**
	 * 数据类型Number,对应类型:<br>
	 * Java=Number<br>
	 * MySQL=NUMERIC<br>
	 * PostgreSQL=NUMERIC<br>
	 */
	public final static String NUMBER = "Number";

	/**
	 * 数据类型Decimal,对应类型:<br>
	 * Java=BigDecimal<br>
	 * MySQL=DECIMAL<br>
	 * PostgreSQL=DECIMAL<br>
	 */
	public final static String DECIMAL = "Decimal";

	/**
	 * 数据类型ZonedDateTime,对应类型:<br>
	 * Java=java.time.ZonedDateTime<br>
	 * MySQL=TIMESTAMP<br>
	 * PostgreSQL=TIMESTAMP WITH TIME ZONE<br>
	 */
	public final static String ZONED_DATE_TIME = "ZonedDateTime";
	/**
	 * 数据类型GregorianCalendar,对应类型:<br>
	 * Java=java.util.GregorianCalendar<br>
	 * MySQL=TIMESTAMP<br>
	 * PostgreSQL=TIMESTAMP WITH TIME ZONE<br>
	 */
	public final static String GREGORIAN_CALENDAR = "java.util.GregorianCalendar";
	/**
	 * 数据类型DateTime,对应类型:<br>
	 * Java=java.time.LocalDateTime<br>
	 * MySQL=DATETIME<br>
	 * PostgreSQL=TIMESTAMP<br>
	 */
	public final static String DATETIME = "DateTime";
	/**
	 * 数据类型Date,对应类型:<br>
	 * Java=java.time.LocalDate<br>
	 * MySQL=DATE<br>
	 * PostgreSQL=DATE<br>
	 */
	public final static String DATE = "Date";
	/**
	 * 数据类型Time,对应类型:<br>
	 * Java=java.time.LocalTime<br>
	 * MySQL=TIME<br>
	 * PostgreSQL=TIME<br>
	 */
	public final static String TIME = "Time";
	/**
	 * 数据类型Timestamp,对应类型:<br>
	 * Java=java.time.Instant<br>
	 * MySQL=TIMESTAMP<br>
	 * PostgreSQL=TIMESTAMP<br>
	 */
	public final static String TIMESTAMP = "Timestamp";
	/**
	 * 数据类型java.util.Date,对应类型:<br>
	 * Java=java.util.Date<br>
	 * MySQL=DATETIME<br>
	 * PostgreSQL=TIMESTAMP<br>
	 */
	public final static String DATE_UTIL = "java.util.Date";
	/**
	 * 数据类型java.util.Calendar,对应类型:<br>
	 * Java=java.util.Calendar<br>
	 * MySQL=DATE<br>
	 * PostgreSQL=DATE<br>
	 */
	public final static String CALENDAR = "java.util.Calendar";

	/**
	 * 数据类型java.sql.Time,对应类型:<br>
	 * Java=java.sql.Date<br>
	 * MySQL=DATE<br>
	 * PostgreSQL=DATE<br>
	 */
	public final static String DATE_SQL = "java.sql.Date";

	/**
	 * 数据类型java.sql.Time,对应类型:<br>
	 * Java=java.sql.Time<br>
	 * MySQL=TIME<br>
	 * PostgreSQL=TIME<br>
	 */
	public final static String TIME_SQL = "java.sql.Time";
	/**
	 * 数据类型java.sql.Timestamp,对应类型:<br>
	 * Java=java.sql.Timestamp<br>
	 * MySQL=DATETIME<br>
	 * PostgreSQL=TIMESTAMP<br>
	 */
	public final static String TIMESTAMP_SQL = "java.sql.Timestamp";

	// ***********************************************************
	// **********************SQL数据类型***********************
	// ***********************************************************

	/**
	 * 数据类型nchar,对应类型:<br>
	 * Java=String<br>
	 * MySQL=char<br>
	 * PostgreSQL=char<br>
	 */
	public final static String NCHAR = "nchar";
	/**
	 * 数据类型nvarchar,对应类型:<br>
	 * Java=String<br>
	 * MySQL=varchar<br>
	 * PostgreSQL=varchar<br>
	 */
	public final static String NVARCHAR = "nvarchar";
	/**
	 * 数据类型varchar2,对应类型:<br>
	 * Java=String<br>
	 * MySQL=varchar<br>
	 * PostgreSQL=varchar<br>
	 */
	public final static String VARCHAR2 = "varchar2";

	/**
	 * 数据类型Money,对应类型:<br>
	 * Java=BigDecimal<br>
	 * MySQL=DECIMAL<br>
	 * PostgreSQL=MONEY<br>
	 */
	public final static String MONEY = "money";
	/**
	 * 数据类型text,对应类型:<br>
	 * Java=String<br>
	 * MySQL=TEXT<br>
	 * PostgreSQL=text
	 */
	public final static String TEXT = "text";
	/**
	 * 数据类型longtext,对应类型:<br>
	 * Java=String<br>
	 * MySQL=LONGTEXT<br>
	 * PostgreSQL=text
	 */
	public final static String LONGTEXT = "longtext";

	/**
	 * 数据类型json,对应类型:<br>
	 * Java=String<br>
	 * MySQL=JSON<br>
	 * PostgreSQL=JSON
	 */
	public final static String JSON = "json";

	/**
	 * 数据类型jsonb,对应类型:<br>
	 * Java=String<br>
	 * MySQL=JSON<br>
	 * PostgreSQL=JSONB
	 */
	public final static String JSONB = "jsonb";

	// ***********************************************************
	// ************************SQL通用类型***********************
	// ***********************************************************
	/**
	 * 数据类型char,对应类型:<br>
	 * Java=String<br>
	 * 所有数据库=CHAR
	 */
	public final static String CHAR = "char";
	/**
	 * 数据类型varchar,对应类型:<br>
	 * Java=String<br>
	 * 所有数据库=VARCHAR
	 */
	public final static String VARCHAR = "varchar";

	/**
	 * 数据类型real,对应类型:<br>
	 * Java=Number<br>
	 * 所有数据库=REAL<br>
	 */
	public final static String REAL = "real";

	/**
	 * 数据类型Numeric,对应类型:<br>
	 * Java=Number<br>
	 * 所有数据库=NUMERIC<br>
	 */
	public final static String NUMERIC = "Numeric";

	// ***********************************************************
	// ************************数据类型映射***********************
	// ***********************************************************
	/** 自定义数据库类型映射 */
	public static final Map<String, String> CUSTOM_SQL_MAPS;
	/** 自定义java类型映射 */
	public static final Map<String, String> CUSTOM_JAVA_MAPS;

	/** 通用映射到数据库的类型 */
	public static final Map<String, String> COMMON_SQL_MAPS;
	/** 通用映射到JAVA的类型 */
	public static final Map<String, String> COMMON_JAVA_MAPS;

	/** Java数据类型映射 */
	public static final Map<String, String> JAVA_MAPS;

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
	static {
		JAVA_MAPS = new HashMap<String, String>();
		COMMON_SQL_MAPS = new HashMap<String, String>();
		COMMON_JAVA_MAPS = new HashMap<String, String>();
		MYSQL_MAPS = new HashMap<String, String>();
		POSTGRE_SQL_MAPS = new HashMap<String, String>();
		DB2_MAPS = new HashMap<String, String>();
		ORACLE_MAPS = new HashMap<String, String>();
		SQL_SERVER_MAPS = new HashMap<String, String>();
		SQLITE_MAPS = new HashMap<String, String>();
		CUSTOM_SQL_MAPS = new HashMap<String, String>();
		CUSTOM_JAVA_MAPS = new HashMap<String, String>();

		initJavaMap();
		initJdbcToJavaMaps();
		initCommonSQLMaps();

		initMySQLMaps();
		initPostgreSQLMaps();
		initDB2Maps();
		initOracleMaps();
		initSqlServerMaps();
		initSqliteMaps();
	}

	/**
	 * 添加类型到自定义词典中,同时覆盖相同key的其他词典
	 * 
	 * @param key
	 *          类型的名称
	 * @param sqlType
	 *          映射为SQL什么类型
	 * @param javaType
	 *          映射为Java什么类型
	 */
	public static void put(String key, String sqlType, String javaType) {
		CUSTOM_SQL_MAPS.put(key, sqlType);
		CUSTOM_JAVA_MAPS.put(key, javaType);
	}

	/**
	 * 获取数据类型词典
	 * 
	 * @param mode
	 * @return
	 */
	public static Map<String, String> getDictionary(SdTypeMode mode) {
		SdUtil.requireNonNull(mode, "The mode connot be null");
		Map<String, String> result = new HashMap<String, String>();
		if (mode == SdTypeMode.COMMON) {
			result.putAll(COMMON_JAVA_MAPS);
			result.putAll(COMMON_SQL_MAPS);
			result.putAll(CUSTOM_JAVA_MAPS);
			result.putAll(CUSTOM_SQL_MAPS);
		} else if (mode == SdTypeMode.CUSTOM) {
			result.putAll(CUSTOM_SQL_MAPS);
			result.putAll(CUSTOM_JAVA_MAPS);
		} else if (mode == SdTypeMode.JAVA) {
			result.putAll(COMMON_JAVA_MAPS);
			result.putAll(JAVA_MAPS);
			result.putAll(CUSTOM_JAVA_MAPS);
		} else {
			result.putAll(COMMON_SQL_MAPS);
			switch (mode) {
			case MYSQL:
				result.putAll(MYSQL_MAPS);
				break;
			case POSTGRE_SQL:
				result.putAll(POSTGRE_SQL_MAPS);
				break;
			case DB2:
				result.putAll(DB2_MAPS);
				break;
			case ORACLE:
				result.putAll(ORACLE_MAPS);
				break;
			case SQL_SERVER:
				result.putAll(SQL_SERVER_MAPS);
				break;
			case SELITE:
				result.putAll(SQLITE_MAPS);
				break;
			default:
				break;
			}
			result.putAll(CUSTOM_SQL_MAPS);
		}
		return result;
	}

	/**
	 * 初始化通用SQL
	 */
	private static void initCommonSQLMaps() {
		// 通用数据库类型设置
		COMMON_SQL_MAPS.put(CHAR, SQL.CHAR);
		COMMON_SQL_MAPS.put(VARCHAR, SQL.VARCHAR);
		COMMON_SQL_MAPS.put(REAL, SQL.REAL);
		COMMON_SQL_MAPS.put(NUMERIC, SQL.NUMERIC);

	}

	/**
	 * 初始化MySQL类型映射
	 */
	private static void initMySQLMaps() {
		MYSQL_MAPS.put(BYTE, MySQL.TINYINT);
		MYSQL_MAPS.put(BYTE_ARRAY, MySQL.BLOB);
		MYSQL_MAPS.put(BOOLEAN, MySQL.BOOLEAN);
		MYSQL_MAPS.put(BOOLEAN_BASIC, MySQL.BOOLEAN);
		MYSQL_MAPS.put(STRING, MySQL.VARCHAR);
		MYSQL_MAPS.put(SHORT, MySQL.SMALLINT);
		MYSQL_MAPS.put(SHORT_BASIC, MySQL.SMALLINT);
		MYSQL_MAPS.put(INT_BASIC, MySQL.INT);
		MYSQL_MAPS.put(INTEGER, MySQL.INT);
		MYSQL_MAPS.put(LONG, MySQL.BIGINT);
		MYSQL_MAPS.put(LONG_BASIC, SQL.BIGINT);
		MYSQL_MAPS.put(FLOAT, MySQL.FLOAT);
		MYSQL_MAPS.put(FLOAT_BASIC, MySQL.FLOAT);
		MYSQL_MAPS.put(DOUBLE, MySQL.DOUBLE);
		MYSQL_MAPS.put(DOUBLE_BASIC, MySQL.DOUBLE);
		MYSQL_MAPS.put(NUMBER, MySQL.NUMERIC);
		MYSQL_MAPS.put(MONEY, MySQL.DECIMAL);
		MYSQL_MAPS.put(DECIMAL, MySQL.DECIMAL);

		MYSQL_MAPS.put(NCHAR, MySQL.CHAR);
		MYSQL_MAPS.put(NVARCHAR, MySQL.VARCHAR);
		MYSQL_MAPS.put(VARCHAR2, MySQL.VARCHAR);
		MYSQL_MAPS.put(TEXT, MySQL.TEXT);
		MYSQL_MAPS.put(LONGTEXT, MySQL.LONGTEXT);
		MYSQL_MAPS.put(JSON, MySQL.JSON);
		MYSQL_MAPS.put(JSONB, MySQL.JSON);

		MYSQL_MAPS.put(ZONED_DATE_TIME, MySQL.TIMESTAMP);
		MYSQL_MAPS.put(GREGORIAN_CALENDAR, MySQL.TIMESTAMP);
		MYSQL_MAPS.put(DATETIME, MySQL.DATETIME);
		MYSQL_MAPS.put(DATE, MySQL.DATE);
		MYSQL_MAPS.put(CALENDAR, MySQL.DATE);
		MYSQL_MAPS.put(DATE_SQL, MySQL.DATE);
		MYSQL_MAPS.put(DATE_UTIL, MySQL.DATE);
		MYSQL_MAPS.put(TIME, MySQL.TIME);
		MYSQL_MAPS.put(TIME_SQL, MySQL.TIME);
		MYSQL_MAPS.put(TIMESTAMP, MySQL.TIMESTAMP);
		MYSQL_MAPS.put(TIMESTAMP_SQL, MySQL.TIMESTAMP);

		// TODO MySQL添加映射的模块
	}

	/**
	 * 初始化PostgreSQL类型映射
	 */
	private static void initPostgreSQLMaps() {
		POSTGRE_SQL_MAPS.put(BYTE, PostgreSQL.SMALLINT);
		POSTGRE_SQL_MAPS.put(BYTE_ARRAY, PostgreSQL.BYTEA);
		POSTGRE_SQL_MAPS.put(BOOLEAN, PostgreSQL.BOOLEAN);
		POSTGRE_SQL_MAPS.put(BOOLEAN_BASIC, PostgreSQL.BOOLEAN);
		POSTGRE_SQL_MAPS.put(STRING, PostgreSQL.VARCHAR);
		POSTGRE_SQL_MAPS.put(SHORT, PostgreSQL.SMALLINT);
		POSTGRE_SQL_MAPS.put(SHORT_BASIC, PostgreSQL.SMALLINT);
		POSTGRE_SQL_MAPS.put(INT_BASIC, PostgreSQL.INTEGER);
		POSTGRE_SQL_MAPS.put(INTEGER, PostgreSQL.INTEGER);
		POSTGRE_SQL_MAPS.put(LONG, PostgreSQL.BIGINT);
		POSTGRE_SQL_MAPS.put(LONG_BASIC, PostgreSQL.BIGINT);
		POSTGRE_SQL_MAPS.put(FLOAT, PostgreSQL.REAL);
		POSTGRE_SQL_MAPS.put(FLOAT_BASIC, PostgreSQL.REAL);
		POSTGRE_SQL_MAPS.put(DOUBLE, PostgreSQL.DOUBLE_PRECISION);
		POSTGRE_SQL_MAPS.put(DOUBLE_BASIC, PostgreSQL.DOUBLE_PRECISION);
		POSTGRE_SQL_MAPS.put(NUMBER, PostgreSQL.NUMERIC);
		POSTGRE_SQL_MAPS.put(MONEY, PostgreSQL.MONEY);
		POSTGRE_SQL_MAPS.put(DECIMAL, PostgreSQL.DECIMAL);

		POSTGRE_SQL_MAPS.put(NCHAR, PostgreSQL.CHAR);
		POSTGRE_SQL_MAPS.put(NVARCHAR, PostgreSQL.VARCHAR);
		POSTGRE_SQL_MAPS.put(VARCHAR2, PostgreSQL.VARCHAR);
		POSTGRE_SQL_MAPS.put(TEXT, PostgreSQL.TEXT);
		POSTGRE_SQL_MAPS.put(LONGTEXT, PostgreSQL.TEXT);
		POSTGRE_SQL_MAPS.put(JSON, PostgreSQL.JSON);
		POSTGRE_SQL_MAPS.put(JSONB, PostgreSQL.JSONB);

		POSTGRE_SQL_MAPS.put(ZONED_DATE_TIME, PostgreSQL.TIMESTAMP_WITH_TIME_ZONE);
		POSTGRE_SQL_MAPS.put(GREGORIAN_CALENDAR, PostgreSQL.TIMESTAMP_WITH_TIME_ZONE);
		POSTGRE_SQL_MAPS.put(DATETIME, PostgreSQL.TIMESTAMP);
		POSTGRE_SQL_MAPS.put(DATE, PostgreSQL.DATE);
		POSTGRE_SQL_MAPS.put(CALENDAR, PostgreSQL.DATE);
		POSTGRE_SQL_MAPS.put(DATE_SQL, PostgreSQL.DATE);
		POSTGRE_SQL_MAPS.put(DATE_UTIL, PostgreSQL.DATE);
		POSTGRE_SQL_MAPS.put(TIME, PostgreSQL.TIME);
		POSTGRE_SQL_MAPS.put(TIME_SQL, PostgreSQL.TIME);
		POSTGRE_SQL_MAPS.put(TIMESTAMP, PostgreSQL.TIMESTAMP);
		POSTGRE_SQL_MAPS.put(TIMESTAMP_SQL, PostgreSQL.TIMESTAMP);

		// TODO PostgreSQL添加映射的模块
	}

	/**
	 * 初始化DB2类型映射
	 */
	private static void initDB2Maps() {

		// TODO DB2添加映射的模块
	}

	/**
	 * 初始化Oracle类型映射
	 */
	private static void initOracleMaps() {

		// TODO Oracle添加映射的模块
	}

	/**
	 * 初始化SqlServer类型映射
	 */
	private static void initSqlServerMaps() {

		// TODO SqlServer添加映射的模块
	}

	/**
	 * 初始化Sqlite类型映射
	 */
	private static void initSqliteMaps() {

		// TODO Sqlite添加映射的模块
	}

	/**
	 * 初始化Java字典
	 */
	private static void initJavaMap() {
		JAVA_MAPS.put(BYTE, Java.BYTE);
		JAVA_MAPS.put(BYTE_ARRAY, Java.BYTE_ARRAYS);
		JAVA_MAPS.put(BOOLEAN_BASIC, Java.BOOLEAN);
		JAVA_MAPS.put(BOOLEAN, Java.BOOLEAN_OBJ);

		JAVA_MAPS.put(STRING, Java.STRING);
		JAVA_MAPS.put(SHORT_BASIC, Java.SHORT);
		JAVA_MAPS.put(SHORT, Java.SHORT_OBJ);
		JAVA_MAPS.put(INT_BASIC, Java.INT);
		JAVA_MAPS.put(INTEGER, Java.INTEGER);
		JAVA_MAPS.put(LONG_BASIC, Java.LONG);
		JAVA_MAPS.put(LONG, Java.LONG_OBJ);
		JAVA_MAPS.put(FLOAT_BASIC, Java.FLOAT);
		JAVA_MAPS.put(FLOAT, Java.FLOAT_OBJ);
		JAVA_MAPS.put(REAL, Java.NUMBER);
		JAVA_MAPS.put(DOUBLE_BASIC, Java.DOUBLE);
		JAVA_MAPS.put(DOUBLE, Java.DOUBLE_OBJ);

		JAVA_MAPS.put(NUMERIC, Java.NUMBER);
		JAVA_MAPS.put(DECIMAL, Java.BIG_DECIMAL);
		JAVA_MAPS.put(NUMBER, Java.NUMBER);
		JAVA_MAPS.put(MONEY, Java.BIG_DECIMAL);

		JAVA_MAPS.put(DATETIME, Java.LOCAL_DATE_TIME);
		JAVA_MAPS.put(DATE_UTIL, Java.DATE);
		JAVA_MAPS.put(DATE_SQL, Java.DATE_SQL);
		JAVA_MAPS.put(DATE, Java.LOCAL_DATE);
		JAVA_MAPS.put(CALENDAR, Java.CALENDAR);
		JAVA_MAPS.put(TIME, Java.LOCAL_TIME);
		JAVA_MAPS.put(TIME_SQL, Java.TIME_SQL);
		JAVA_MAPS.put(TIMESTAMP, Java.INSTANT);
		JAVA_MAPS.put(TIMESTAMP_SQL, Java.TIMESTAMP);
		JAVA_MAPS.put(ZONED_DATE_TIME, Java.ZONED_DATE_TIME);
		JAVA_MAPS.put(GREGORIAN_CALENDAR, Java.GREGORIAN_CALENDAR);

		JAVA_MAPS.put(CHAR, Java.STRING);
		JAVA_MAPS.put(VARCHAR, Java.STRING);
		JAVA_MAPS.put(NCHAR, Java.STRING);
		JAVA_MAPS.put(NVARCHAR, Java.STRING);
		JAVA_MAPS.put(VARCHAR2, Java.STRING);
		JAVA_MAPS.put(TEXT, Java.STRING);
		JAVA_MAPS.put(LONGTEXT, Java.STRING);

		JAVA_MAPS.put(JSON, Java.STRING);
		JAVA_MAPS.put(JSONB, Java.STRING);

	}

	/**
	 * 初始化JdbcType类型到Java类型
	 */
	private static void initJdbcToJavaMaps() {
		JAVA_MAPS.put(SQL.NULL, Java.NULL);
		JAVA_MAPS.put(SQL.JAVA_OBJECT, Java.OBJECT);

		JAVA_MAPS.put(SQL.BOOL, Java.BOOLEAN_OBJ);
		JAVA_MAPS.put(SQL.BOOLEAN, Java.BOOLEAN_OBJ);

		JAVA_MAPS.put(SQL.BIT, Java.BOOLEAN_OBJ);
		JAVA_MAPS.put(SQL.TINYINT, Java.BYTE);

		JAVA_MAPS.put(SQL.SMALLINT, Java.SHORT_OBJ);
		JAVA_MAPS.put(SQL.INT2, Java.SHORT_OBJ);
		JAVA_MAPS.put(SQL.SMALLSERIAL, Java.SHORT_OBJ);
		JAVA_MAPS.put(SQL.SERIAL2, Java.SHORT_OBJ);

		JAVA_MAPS.put(SQL.INT, Java.INTEGER);
		JAVA_MAPS.put(SQL.INT4, Java.INTEGER);
		JAVA_MAPS.put(SQL.INTEGER, Java.INTEGER);
		JAVA_MAPS.put(SQL.SERIAL, Java.INTEGER);
		JAVA_MAPS.put(SQL.SERIAL4, Java.INTEGER);

		JAVA_MAPS.put(SQL.BIGINT, Java.LONG_OBJ);
		JAVA_MAPS.put(SQL.INT8, Java.LONG_OBJ);
		JAVA_MAPS.put(SQL.SERIAL8, Java.LONG_OBJ);
		JAVA_MAPS.put(SQL.BIGSERIAL, Java.LONG_OBJ);

		JAVA_MAPS.put(SQL.DECIMAL, Java.NUMBER);
		JAVA_MAPS.put(SQL.REAL, Java.NUMBER);
		JAVA_MAPS.put(SQL.FLOAT, Java.FLOAT_OBJ);
		JAVA_MAPS.put(SQL.DOUBLE, Java.DOUBLE_OBJ);

		JAVA_MAPS.put(SQL.NUMERIC, Java.BIG_DECIMAL);
		JAVA_MAPS.put(SQL.MONEY, Java.BIG_DECIMAL);

		JAVA_MAPS.put(SQL.CHAR, Java.STRING);
		JAVA_MAPS.put(SQL.NCHAR, Java.STRING);
		JAVA_MAPS.put(SQL.VARCHAR, Java.STRING);
		JAVA_MAPS.put(SQL.NVARCHAR, Java.STRING);
		JAVA_MAPS.put(SQL.VARCHAR2, Java.STRING);
		JAVA_MAPS.put(SQL.LONGVARCHAR, Java.STRING);
		JAVA_MAPS.put(SQL.CLOB, Java.STRING);
		JAVA_MAPS.put(SQL.TEXT, Java.STRING);
		JAVA_MAPS.put(SQL.TINYTEXT, Java.STRING);
		JAVA_MAPS.put(SQL.MEDIUMTEXT, Java.STRING);
		JAVA_MAPS.put(SQL.LONGTEXT, Java.STRING);
		JAVA_MAPS.put(SQL.CHARACTER, Java.STRING);
		JAVA_MAPS.put(SQL.CHARACTER_VARYING, Java.STRING);
		JAVA_MAPS.put(SQL.GRAPHIC, Java.STRING);
		JAVA_MAPS.put(SQL.VARGRAPHIC, Java.STRING);

		JAVA_MAPS.put(SQL.JSON, Java.STRING);
		JAVA_MAPS.put(SQL.JSONB, Java.STRING);
		JAVA_MAPS.put(SQL.XML, Java.STRING);
		JAVA_MAPS.put(SQL.SQLXML, Java.STRING);
		JAVA_MAPS.put(SQL.SET, Java.STRING);
		JAVA_MAPS.put(SQL.ENUM, Java.STRING);

		JAVA_MAPS.put(SQL.BINARY, Java.BYTE_ARRAYS);
		JAVA_MAPS.put(SQL.VARBINARY, Java.BYTE_ARRAYS);
		JAVA_MAPS.put(SQL.LONGVARBINARY, Java.BYTE_ARRAYS);
		JAVA_MAPS.put(SQL.BLOB, Java.BYTE_ARRAYS);

		JAVA_MAPS.put(SQL.DATETIME, Java.LOCAL_DATE_TIME);
		JAVA_MAPS.put(SQL.DATE, Java.LOCAL_DATE);
		JAVA_MAPS.put(SQL.TIME, Java.LOCAL_TIME);
		JAVA_MAPS.put(SQL.TIMESTAMP, Java.INSTANT);
		JAVA_MAPS.put(SQL.TIME_WITH_TIMEZONE, Java.ZONED_DATE_TIME);

		JAVA_MAPS.put(SQL.OTHER, Java.OBJECT);

	}

}
