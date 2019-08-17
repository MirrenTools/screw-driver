package org.mirrentools.sd.constant;

/**
 * PostgreSQL的常量
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public interface PostgreSQL {
	/** PostgreSQL名字常量=PostgreSQL */
	public final static String POSTGRE_SQL = "PostgreSQL";
	/** PostgreSQL数据库驱动包常量=org.postgresql.Driver */
	public final static String POSTGRE_SQL_DERVER = "org.postgresql.Driver";

	/** PostgreSQL数据类型character 定长字符串 */
	public final static String CHARACTER = "character";
	/** PostgreSQL数据类型char 定长字符串 */
	public final static String CHAR = "char";
	/** PostgreSQL数据类型character varying 变长字符串 */
	public final static String CHARACTER_VARYING = "character varying";
	/** PostgreSQL数据类型varchar 变长字符串 */
	public final static String VARCHAR = "varchar";
	/** PostgreSQL数据类型text 变长字符串 */
	public final static String TEXT = "text";

	/** PostgreSQL数据类型smallint 有符号2字节整数 */
	public final static String SMALLINT = "smallint";
	/** PostgreSQL数据类型int2 有符号2字节整数 */
	public final static String INT2 = "int2";
	/** PostgreSQL数据类型integer 有符号4字节整数 */
	public final static String INTEGER = "integer";
	/** PostgreSQL数据类型int 有符号4字节整数 */
	public final static String INT = "int";
	/** PostgreSQL数据类型int4 有符号4字节整数 */
	public final static String INT4 = "int4";
	/** PostgreSQL数据类型bigint 有符号的8字节整数 */
	public final static String BIGINT = "bigint";
	/** PostgreSQL数据类型int8 有符号的8字节整数 */
	public final static String INT8 = "int8";

	/** PostgreSQL数据类型smallserial 自动增长的2字节整数 */
	public final static String SMALLSERIAL = "smallserial";
	/** PostgreSQL数据类型serial2 自动增长的2字节整数 */
	public final static String SERIAL2 = "serial2";
	/** PostgreSQL数据类型serial 自动增长的4字节整数 */
	public final static String SERIAL = "serial";
	/** PostgreSQL数据类型serial4 自动增长的4字节整数 */
	public final static String SERIAL4 = "serial4";
	/** PostgreSQL数据类型bigserial 自动增长的8字节整数 */
	public final static String BIGSERIAL = "bigserial";
	/** PostgreSQL数据类型serial8 自动增长的8字节整数 */
	public final static String SERIAL8 = "serial8";
	
	/** PostgreSQL数据类型real 单精度浮点数（4字节） */
	public final static String REAL = "real";
	/** PostgreSQL数据类型float4 单精度浮点数（4字节） */
	public final static String FLOAT4 = "float4";
	/** PostgreSQL数据类型double precision 双精度浮点数（8字节） */
	public final static String DOUBLE_PRECISION = "double precision";
	/** PostgreSQL数据类型float8 双精度浮点数（8字节） */
	public final static String FLOAT8 = "float8";
	/** PostgreSQL数据类型money 货币数量 */
	public final static String MONEY = "money";
	/** PostgreSQL数据类型numeric 可选择精度的精确数字 */
	public final static String NUMERIC = "numeric";
	/** PostgreSQL数据类型decimal 可选择精度的精确数字 */
	public final static String DECIMAL = "decimal ";

	/** PostgreSQL数据类型boolean 逻辑布尔值（真/假） */
	public final static String BOOLEAN = "boolean";
	/** PostgreSQL数据类型bool 逻辑布尔值（真/假） */
	public final static String BOOL = "bool";

	/** PostgreSQL数据类型json 文本 JSON 数据 */
	public final static String JSON = "json";
	/** PostgreSQL数据类型jsonb 二进制 JSON 数据，已分解 */
	public final static String JSONB = "jsonb";
	/** PostgreSQL数据类型xml XML数据 */
	public final static String XML = "xml";
	/** PostgreSQL数据类型enum 枚举类型 */
	public final static String ENUM = "enum";

	/** PostgreSQL数据类型date 日历日期（年、月、日） */
	public final static String DATE = "date";
	/** PostgreSQL数据类型interval 时间段 */
	public final static String INTERVAL = "interval";
	/** PostgreSQL数据类型time 一天中的时间（无时区） */
	public final static String TIME = "time";
	/** PostgreSQL数据类型timetz 一天中的时间，包括时区 */
	public final static String TIMETZ = "timetz";
	/** PostgreSQL数据类型timestamp 日期和时间（无时区） */
	public final static String TIMESTAMP = "timestamp";
	/** PostgreSQL数据类型timestamptz 日期和时间，包括时区 */
	public final static String TIMESTAMPTZ = "timestamptz";

	/** PostgreSQL数据类型bit 定长位串 */
	public final static String BIT = "bit";
	/** PostgreSQL数据类型bit varying 变长位串 */
	public final static String BIT_VARYING = "bit varying";
	/** PostgreSQL数据类型varbit 变长位串 */
	public final static String VARBIT = "varbit";
	/** PostgreSQL数据类型bytea 二进制数据（“字节数 组”） */
	public final static String BYTEA = "bytea";

	/** PostgreSQL数据类型uuid 通用唯一标识码 */
	public final static String UUID = "uuid";

	/** PostgreSQL数据类型cidr IPv4或IPv6网络地址 */
	public final static String CIDR = "cidr";
	/** PostgreSQL数据类型inet IPv4或IPv6网络地址 */
	public final static String INET = "inet";
	/** PostgreSQL数据类型macaddr MAC（Media Access Control） 地址 */
	public final static String MACADDR = "macaddr";
	/** PostgreSQL数据类型macaddr8 MAC (Media Access Control) 地址 (EUI-64 格式) */
	public final static String MACADDR8 = "macaddr8";

	/** PostgreSQL数据类型box 平面上的普通方框 */
	public final static String BOX = "box";
	/** PostgreSQL数据类型circle 平面上的圆 */
	public final static String CIRCLE = "circle";
	/** PostgreSQL数据类型line 平面上的无限长的线 */
	public final static String LINE = "line";
	/** PostgreSQL数据类型lseg 平面上的线段 */
	public final static String LSEG = "lseg";
	/** PostgreSQL数据类型path 平面上的几何路径 */
	public final static String PATH = "path";
	/** PostgreSQL数据类型pg_lsn PostgreSQL日志序列号 */
	public final static String PG_LSN = "pg_lsn";
	/** PostgreSQL数据类型point 平面上的几何点 */
	public final static String POINT = "point";
	/** PostgreSQL数据类型polygon 平面上的封闭几何路径 */
	public final static String POLYGON = "polygon";

	/** PostgreSQL数据类型tsquery 文本搜索查询 */
	public final static String TSQUERY = "tsquery";
	/** PostgreSQL数据类型tsvector 文本搜索文档 */
	public final static String TSVECTOR = "tsvector";

	/** PostgreSQL数据类型txid_snapshot 用户级别事务ID快照 */
	public final static String TXID_SNAPSHOT = "txid_snapshot";

}
