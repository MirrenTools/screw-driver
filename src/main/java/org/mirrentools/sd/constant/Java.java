package org.mirrentools.sd.constant;

/**
 * java的访问修饰器
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public interface Java {
	/** public修饰符 */
	public final static String PUBLIC = "public";
	/** protected修饰符 */
	public final static String PROTECTED = "protected";
	/** 没有修饰符 */
	public final static String NONE = "";
	/** private修饰符 */
	public final static String PRIVATE = "private";

	/*
	 * 数据类型
	 */
	/** Object数据类型 */
	public final static String OBJECT = "Object";
	/** Enum数据类型 */
	public final static String ENUM = "Enum";
	/** void数据类型 */
	public final static String VOID = "void";
	/** java.util.Map数据类型 */
	public final static String MAP = "java.util.Map";
	/** Iterable数据类型 */
	public final static String ITERABLE = "Iterable";
	/** java.util.Set数据类型 */
	public final static String SET = "java.util.Set";
	/** java.util.List数据类型 */
	public final static String List = "java.util.List";
	/** byte[]数据类型 */
	public final static String BYTE_ARRAYS = "byte[]";
	/** byte数据类型 */
	public final static String BYTE = "byte";
	/** Byte数据类型 */
	public final static String BYTE_OBJ = "Byte";
	/** java.nio.Buffer数据类型 */
	public final static String BUFFER = "java.nio.Buffer";

	/** CharSequence数据类型 */
	public final static String CHAR_SEQUENCE = "CharSequence";
	/** String数据类型 */
	public final static String STRING = "String";
	/** StringBuffer数据类型 */
	public final static String STRING_BUFFER = "StringBuffer";
	/** StringBuilder数据类型 */
	public final static String STRING_BUILDER = "StringBuilder";
	/** Character数据类型 */
	public final static String CHARACTER = "Character";
	/** char数据类型 */
	public final static String CHAR = "char";

	/** Number数据类型 */
	public final static String NUMBER = "Number";
	/** short数据类型 */
	public final static String SHORT = "short";
	/** Short数据类型 */
	public final static String SHORT_OBJ = "Short";
	/** int数据类型 */
	public final static String INT = "int";
	/** Integer数据类型 */
	public final static String INTEGER = "Integer";
	/** java.util.concurrent.atomic.AtomicInteger数据类型 */
	public final static String ATOMIC_INTEGER = "java.util.concurrent.atomic.AtomicInteger";
	/** java.math.BigInteger数据类型 */
	public final static String BIG_INTEGER = " java.math.BigInteger";
	/** long数据类型 */
	public final static String LONG = "long";
	/** Long数据类型 */
	public final static String LONG_OBJ = "Long";
	/** java.util.concurrent.atomic.AtomicLong数据类型 */
	public final static String ATOMIC_LONG = "java.util.concurrent.atomic.AtomicLong";
	/** java.math.BigDecimal数据类型 */
	public final static String BIG_DECIMAL = "java.math.BigDecimal";
	/** double数据类型 */
	public final static String DOUBLE = "double";
	/** Double数据类型 */
	public final static String DOUBLE_OBJ = "Double";
	/** float数据类型 */
	public final static String FLOAT = "float";
	/** Float数据类型 */
	public final static String FLOAT_OBJ = "Float";

	/** boolean数据类型 */
	public final static String BOOLEAN = "boolean";
	/** Boolean数据类型 */
	public final static String BOOLEAN_OBJ = "Boolean";

	/** java.util.uuid数据类型 */
	public final static String UUID = "java.util.uuid";
	
	/** java.util.Calendar数据类型 */
	public final static String CALENDAR = "java.util.Calendar";
	/** java.util.Date数据类型 */
	public final static String DATE = "java.util.Date";
	/** java.sql.Date数据类型 */
	public final static String DATE_SQL = "java.sql.Date";
	/** java.sql.Timestamp数据类型 */
	public final static String TIMESTAMP = "java.sql.Timestamp";

	/** java.time.LocalDate数据类型 */
	public final static String LOCAL_DATE = "java.time.LocalDate";
	/** java.time.LocalTime数据类型 */
	public final static String LOCAL_TIME = "java.time.LocalTime";
	/** java.time.LocalDateTime数据类型 */
	public final static String LOCAL_DATE_TIME = "java.time.LocalDateTime";
	/** java.time.Instant数据类型 */
	public final static String INSTANT = "java.time.Instant";
	/** java.time.ZonedDateTime数据类型 */
	public final static String ZONED_DATE_TIME = "java.time.ZonedDateTime";

	/** io.vertx.core.json.Json数据类型 */
	public final static String JSON_JSON_VERTX = "io.vertx.core.json.Json";
	/** io.vertx.core.json.JsonObject数据类型 */
	public final static String JSON_OBJECT_VERTX = "io.vertx.core.json.JsonObject";
	/** io.vertx.core.json.JsonArray数据类型 */
	public final static String JSON_ARRAY_VERTX = "io.vertx.core.json.JsonArray";

	/** com.alibaba.fastjson.JSON数据类型 */
	public final static String JSON_JSON_FASTJSON = "com.alibaba.fastjson.JSON";
	/** com.alibaba.fastjson.JSONObject数据类型 */
	public final static String JSON_OBJECT_FASTJSON = "com.alibaba.fastjson.JSONObject";
	/** com.alibaba.fastjson.JSONArray数据类型 */
	public final static String JSON_ARRAY_FASTJSON = "com.alibaba.fastjson.JSONArray";

	/** org.json.JSONObject数据类型 */
	public final static String JSON_OBJECT_ORG = "org.json.JSONObject";
	/** org.json.JSONArray数据类型 */
	public final static String JSON_ARRAY_ORG = "org.json.JSONArray";

	/** com.google.gson.JsonElement数据类型 */
	public final static String JSON_ELEMENT_GSON = "com.google.gson.JsonElement";
	/** com.google.gson.JsonObject数据类型 */
	public final static String JSON_OBJECT_GSON = "com.google.gson.JsonObject";
	/** com.google.gson.JsonArray数据类型 */
	public final static String JSON_ARRAY_GSON = "com.google.gson.JsonArray";
}
