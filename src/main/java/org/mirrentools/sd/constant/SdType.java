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
	// **********************通用数据类型*************************
	// ***********************************************************
	/**
	 * 数据类型String,对应类型:<br>
	 * Java=String<br>
	 * 所有数据库=VARCHAR
	 */
	public final static String STRING = "String";
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
	 * 数据类型short,对应类型:<br>
	 * Java=short<br>
	 * 所有数据库=SMALLINT<br>
	 */
	public final static String SHORT_BASIC = "short_basic";
	/**
	 * 数据类型Short,对应类型:<br>
	 * Java=Short<br>
	 * 所有数据库=SMALLINT<br>
	 */
	public final static String SHORT = "Short";

	/**
	 * 数据类型int,对应类型:<br>
	 * Java=int<br>
	 * 所有数据库=INT
	 */
	public final static String INT_BASIC = "int_basic";
	/**
	 * 数据类型Integer,对应类型:<br>
	 * Java=Integer<br>
	 * 所有数据库=INTEGER<br>
	 */
	public final static String INTEGER = "Integer";

	/**
	 * 数据类型long,对应类型:<br>
	 * Java=long<br>
	 * 所有数据库=BIGINT<br>
	 */
	public final static String LONG_BASIC = "long_basic";
	/**
	 * 数据类型Long,对应类型:<br>
	 * Java=Long<br>
	 * 所有数据库=BIGINT<br>
	 */
	public final static String LONG = "Long";
	/**
	 * 数据类型float,对应类型:<br>
	 * Java=float<br>
	 * 所有数据库=FLOAT<br>
	 */
	public final static String FLOAT_BASIC = "float_basic";
	/**
	 * 数据类型Float,对应类型:<br>
	 * Java=Float<br>
	 * 所有数据库=FLOAT<br>
	 */
	public final static String FLOAT = "Float";
	/**
	 * 数据类型real,对应类型:<br>
	 * Java=Number<br>
	 * 所有数据库=REAL<br>
	 */
	public final static String REAL = "real";

	/**
	 * 数据类型double,对应类型:<br>
	 * Java=double<br>
	 * 所有数据库=DOUBLE<br>
	 */
	public final static String DOUBLE_BASIC = "double_basic";

	/**
	 * 数据类型Double,对应类型:<br>
	 * Java=Double<br>
	 * 所有数据库=DOUBLE<br>
	 */
	public final static String DOUBLE = "Double";

	/**
	 * 数据类型Numeric,对应类型:<br>
	 * Java=Number<br>
	 * 所有数据库=NUMERIC<br>
	 */
	public final static String NUMERIC = "Numeric";
	/**
	 * 数据类型Decimal,对应类型:<br>
	 * Java=BigDecimal<br>
	 * 所有数据库=DECIMAL<br>
	 */
	public final static String DECIMAL = "Decimal";
	/**
	 * 数据类型DateTime,对应类型:<br>
	 * Java=java.time.LocalDateTime<br>
	 * 所有数据库=DATETIME<br>
	 */
	public final static String DATETIME = "DateTime";
	/**
	 * 数据类型Date,对应类型:<br>
	 * Java=java.time.LocalDate<br>
	 * 所有数据库=DATE<br>
	 */
	public final static String DATE = "Date";
	/**
	 * 数据类型Time,对应类型:<br>
	 * Java=java.time.LocalTime<br>
	 * 所有数据库=DATE<br>
	 */
	public final static String TIME = "Time";
	/**
	 * 数据类型Timestamp,对应类型:<br>
	 * Java=java.time.Instant<br>
	 * 所有数据库=DATE<br>
	 */
	public final static String TIMESTAMP = "Timestamp";

	// ***********************************************************
	// **********************不通用数据类型***********************
	// ***********************************************************
	/**
	 * 数据类型byte,对应类型:<br>
	 * Java=byte<br>
	 * MySQL=TINYINT<br>
	 * PostgreSQL=SMALLINT
	 */
	public final static String BYTE = "byte";
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
	 * 数据类型Number,对应类型:<br>
	 * Java=Number<br>
	 * MySQL=NUMERIC<br>
	 * PostgreSQL=NUMERIC<br>
	 */
	public final static String NUMBER = "Number";
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
	 * 初始化MySQL类型映射
	 */
	private static void initMySQLMaps() {
		MYSQL_MAPS.put(BYTE, MySQL.TINYINT);
		MYSQL_MAPS.put(BOOLEAN, MySQL.BOOLEAN);
		MYSQL_MAPS.put(BOOLEAN_BASIC, MySQL.BOOLEAN);
		MYSQL_MAPS.put(NCHAR, MySQL.CHAR);
		MYSQL_MAPS.put(NVARCHAR, MySQL.VARCHAR);
		MYSQL_MAPS.put(VARCHAR2, MySQL.VARCHAR);
		MYSQL_MAPS.put(MONEY, MySQL.DECIMAL);
		MYSQL_MAPS.put(NUMBER, MySQL.NUMERIC);
		MYSQL_MAPS.put(TEXT, MySQL.TEXT);
		MYSQL_MAPS.put(LONGTEXT, MySQL.LONGTEXT);
		MYSQL_MAPS.put(JSON, MySQL.JSON);
		MYSQL_MAPS.put(JSONB, MySQL.JSON);
		// TODO MySQL添加映射的模块
	}

	/**
	 * 初始化PostgreSQL类型映射
	 */
	private static void initPostgreSQLMaps() {
		POSTGRE_SQL_MAPS.put(BYTE, PostgreSQL.SMALLINT);
		POSTGRE_SQL_MAPS.put(BOOLEAN, PostgreSQL.BOOLEAN);
		POSTGRE_SQL_MAPS.put(BOOLEAN_BASIC, PostgreSQL.BOOLEAN);
		POSTGRE_SQL_MAPS.put(NCHAR, PostgreSQL.CHAR);
		POSTGRE_SQL_MAPS.put(NVARCHAR, PostgreSQL.VARCHAR);
		POSTGRE_SQL_MAPS.put(VARCHAR2, PostgreSQL.VARCHAR);
		POSTGRE_SQL_MAPS.put(MONEY, PostgreSQL.MONEY);
		POSTGRE_SQL_MAPS.put(NUMBER, PostgreSQL.NUMERIC);
		POSTGRE_SQL_MAPS.put(TEXT, PostgreSQL.TEXT);
		POSTGRE_SQL_MAPS.put(LONGTEXT, PostgreSQL.TEXT);
		POSTGRE_SQL_MAPS.put(JSON, PostgreSQL.JSON);
		POSTGRE_SQL_MAPS.put(JSONB, PostgreSQL.JSONB);
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
	 * 初始化通用SQL
	 */
	private static void initCommonSQLMaps() {
		// 通用数据库类型设置
		COMMON_SQL_MAPS.put(STRING, SQL.VARCHAR);
		COMMON_SQL_MAPS.put(CHAR, SQL.CHAR);
		COMMON_SQL_MAPS.put(VARCHAR, SQL.VARCHAR);
		COMMON_SQL_MAPS.put(SHORT, SQL.SMALLINT);
		COMMON_SQL_MAPS.put(SHORT_BASIC, SQL.SMALLINT);
		COMMON_SQL_MAPS.put(INT_BASIC, SQL.INT);
		COMMON_SQL_MAPS.put(INTEGER, SQL.INTEGER);
		COMMON_SQL_MAPS.put(LONG, SQL.BIGINT);
		COMMON_SQL_MAPS.put(LONG_BASIC, SQL.BIGINT);
		COMMON_SQL_MAPS.put(FLOAT, SQL.FLOAT);
		COMMON_SQL_MAPS.put(FLOAT_BASIC, SQL.FLOAT);
		COMMON_SQL_MAPS.put(REAL, SQL.REAL);
		COMMON_SQL_MAPS.put(DOUBLE, SQL.DOUBLE);
		COMMON_SQL_MAPS.put(DOUBLE_BASIC, SQL.DOUBLE);
		COMMON_SQL_MAPS.put(NUMERIC, SQL.NUMERIC);
		COMMON_SQL_MAPS.put(DECIMAL, SQL.DECIMAL);
		COMMON_SQL_MAPS.put(DATETIME, SQL.DATETIME);
		COMMON_SQL_MAPS.put(DATE, SQL.DATE);
		COMMON_SQL_MAPS.put(TIME, SQL.TIME);
		COMMON_SQL_MAPS.put(TIMESTAMP, SQL.TIMESTAMP);

	}

	/**
	 * 初始化Java字典
	 */
	private static void initJavaMap() {
		JAVA_MAPS.put(STRING, Java.STRING);
		JAVA_MAPS.put(CHAR, Java.STRING);
		JAVA_MAPS.put(VARCHAR, Java.STRING);
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
		JAVA_MAPS.put(DATETIME, Java.LOCAL_DATE_TIME);
		JAVA_MAPS.put(DATE, Java.LOCAL_DATE);
		JAVA_MAPS.put(TIME, Java.LOCAL_TIME);
		JAVA_MAPS.put(TIMESTAMP, Java.INSTANT);

		JAVA_MAPS.put(BYTE, Java.BYTE);
		JAVA_MAPS.put(BOOLEAN_BASIC, Java.BOOLEAN);
		JAVA_MAPS.put(BOOLEAN, Java.BOOLEAN_OBJ);
		JAVA_MAPS.put(NCHAR, Java.STRING);
		JAVA_MAPS.put(NVARCHAR, Java.STRING);
		JAVA_MAPS.put(VARCHAR2, Java.STRING);
		JAVA_MAPS.put(MONEY, Java.BIG_DECIMAL);
		JAVA_MAPS.put(NUMBER, Java.NUMBER);
		JAVA_MAPS.put(TEXT, Java.STRING);
		JAVA_MAPS.put(LONGTEXT, Java.STRING);
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

		JAVA_MAPS.put(SQL.DATE, Java.DATE_SQL);
		JAVA_MAPS.put(SQL.TIME, Java.DIME_SQL);
		JAVA_MAPS.put(SQL.TIMESTAMP, Java.TIMESTAMP);
		JAVA_MAPS.put(SQL.TIME_WITH_TIMEZONE, Java.TIMEZONE);

		JAVA_MAPS.put(SQL.OTHER, Java.OBJECT);

	}

}
