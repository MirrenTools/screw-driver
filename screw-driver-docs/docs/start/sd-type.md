# 数据类型说明
为了屏蔽不同数据库数据类型的差异ScrewDriver提供了**SdType**类,该类为SdColumn数据类型常量,
它会根据不同的数据库自动转换为java与不同数据库对应的类型,你也可以在ScrewDriver.instance之前通过put方法添加自定义类型或覆盖默认提供的类型,示例:
```
// 将MyType转换为数据库的VARCHAR与java的String
SdType.put("MyType","VARCHAR", "String");
// 初始化执行工具
ScrewDriver screwDriver = ScrewDriver.instance(options);

```

**该类的方法**
|方法名称	|接收参数	|返回结果	|说明	|
|--	|--	|--	|--	|
|put	|String key, String 数据库类型, String java类型	|void	|添加自定义数据类型,如果key已经存在则覆盖原有的,如果不存在则为新增类型	|
|getDictionary	|SdTypeMode 数据类型的模式	|Map&lt;String,String&gt;	|获取数据类型词典	|

**SQL通用数据类型**
|数据类型	|java类型	|所有数据库类型	|
|--	|--	|--	|
|CHAR	|String	|CHAR	|
|VARCHAR	|String	|VARCHAR	|
|REAL	|Number	|REAL	|
|NUMERIC	|Number	|NUMERIC	|

**数据类型对应**
|数据类型	|java	|SQLite	|MySQL	|PostgreSQL	|SQL_Server	|DB2	|ORACLE	|
|--	|--	|--	|--	|--	|--	|--	|--	|
|BYTE	|byte	|TINYINT	|TINYINT	|SMALLINT	|TINYINT	|SMALLINT	|BLOB	|
|BYTE_ARRAY	|byte[]	|BLOB	|BLOB	|BYTEA	|IMAGE	|BLOB	|BLOB	|
|BOOLEAN_BASIC	|boolean	|BOOLEAN	|BOOLEAN	|BOOLEAN	|BIT	|CHAR	|CHAR	|
|BOOLEAN	|Boolean	|BOOLEAN	|BOOLEAN	|BOOLEAN	|BIT	|CHAR	|CHAR	|
|STRING	|String	|NVARCHAR	|VARCHAR	|VARCHAR	|NVARCHAR	|VARCHAR	|VARCHAR2	|
|SHORT_BASIC	|short	|SMALLINT	|SMALLINT	|SMALLINT	|SMALLINT	|SMALLINT	|SMALLINT	|
|SHORT	|Short	|SMALLINT	|SMALLINT	|SMALLINT	|SMALLINT	|SMALLINT	|SMALLINT	|
|INT_BASIC	|int	|INTEGER	|INT	|INTEGER	|INT	|INTEGER	|NUMBER	|
|INT	|Integer	|INTEGER	|INT	|INTEGER	|INT	|INTEGER	|NUMBER	|
|LONG_BASIC	|long	|BIGINT	|BIGINT	|BIGINT	|BIGINT	|BIGINT	|NUMBER	|
|LONG	|Long	|BIGINT	|BIGINT	|BIGINT	|BIGINT	|BIGINT	|NUMBER	|
|FLOAT_BASIC	|float	|FLOAT	|FLOAT	|REAL	|FLOAT	|REAL	|NUMBER	|
|FLOAT	|Float	|FLOAT	|FLOAT	|REAL	|FLOAT	|REAL	|NUMBER	|
|DOUBLE_BASIC	|double	|DOUBLE	|DOUBLE	|DOUBLE PRECISION	|FLOAT	|DOUBLE	|NUMBER	|
|DOUBLE	|Double	|DOUBLE	|DOUBLE	|DOUBLE PRECISION	|FLOAT	|DOUBLE	|NUMBER	|
|NUMBER	|Number	|NUMERIC	|NUMERIC	|NUMERIC	|NUMERIC	|DECIMAL	|NUMBER	|
|DECIMAL	|BigDecimal	|DECIMAL	|DECIMAL	|DECIMAL	|DECIMAL	|DECIMAL	|DECIMAL	|
|ZONED_DATE_TIME	|java.time.ZonedDateTime	|TIMESTAMP	|TIMESTAMP	|TIMESTAMP WITH TIME ZONE	|DATETIMEOFFSET	|TIMESTAMP	|TIMESTAMP	|
|GREGORIAN_CALENDAR	|java.util.GregorianCalendar	|TIMESTAMP	|TIMESTAMP	|TIMESTAMP WITH TIME ZONE	|DATETIMEOFFSET	|TIMESTAMP	|TIMESTAMP	|
|DATETIME	|java.time.LocalDateTime	|DATETIME	|DATETIME	|TIMESTAMP	|DATETIME	|TIMESTAMP	|TIMESTAMP	|
|DATE	|java.time.LocalDate	|DATE	|DATE	|DATE	|DATE	|DATE	|DATE	|
|TIME	|TIME	|TIME	|TIME	|TIME	|TIME	|TIME	|TIME	|
|TIMESTAMP	|java.time.Instant	|TIMESTAMP	|TIMESTAMP	|TIMESTAMP	|TIMESTAMP	|TIMESTAMP	|TIMESTAMP	|
|DATE_UTIL	|java.util.Date	|DATETIME	|DATETIME	|TIMESTAMP	|DATETIME	|TIMESTAMP	|TIMESTAMP	|
|CALENDAR	|java.util.Calendar	|DATE	|DATE	|DATE	|DATE	|DATE	|DATE	|
|DATE_SQL	|java.sql.Date	|DATE	|DATE	|DATE	|DATEDATE	|DATE	|DATE	|
|TIME_SQL	|java.sql.Time	|TIME	|TIME	|TIME	|TIME	|TIME	|TIMESTAMP	|
|TIMESTAMP_SQL	|java.sql.Timestamp	|TIMESTAMP	|TIMESTAMP	|TIMESTAMP	|TIMESTAMP	|TIMESTAMP	|TIMESTAMP	|

**JDBC与java类型映射**
|SQL	|Java	|
|--	|--	|
|NULL	|null	|
|JAVA_OBJECT	|Object	|
|BOOL	|Boolean	|
|BOOLEAN	|Boolean	|
|BIT	|Boolean	|
|TINYINT	|byte	|
|SMALLINT	|Short	|
|INT2	|Short	|
|SMALLSERIAL	|Short	|
|SERIAL2	|Short	|
|INT	|Integer	|
|INT4	|Integer	|
|INTEGER	|Integer	|
|SERIAL	|Integer	|
|SERIAL4	|Integer	|
|BIGINT	|Long	|
|INT8	|Long	|
|SERIAL8	|Long	|
|BIGSERIAL	|Long	|
|DECIMAL	|Number	|
|REAL	|Number	|
|FLOAT	|Float	|
|DOUBLE	|Double	|
|NUMERIC	|java.math.BigDecimal	|
|MONEY	|java.math.BigDecimal	|
|CHAR	|String	|
|NCHAR	|String	|
|VARCHAR	|String	|
|NVARCHAR	|String	|
|VARCHAR2	|String	|
|LONGVARCHAR	|String	|
|CLOB	|String	|
|TEXT	|String	|
|TINYTEXT	|String	|
|MEDIUMTEXT	|String	|
|LONGTEXT	|String	|
|CHARACTER	|String	|
|CHARACTER_VARYING	|String	|
|GRAPHIC	|String	|
|VARGRAPHIC	|String	|
|JSON	|String	|
|JSONB	|String	|
|SQLXML	|String	|
|SET	|String	|
|ENUM	|String	|
|BINARY	|byte[]	|
|VARBINARY	|byte[]	|
|LONGVARBINARY	|byte[]	|
|BLOB	|byte[]	|
|DATETIME	|java.time.LocalDateTime	|
|DATE	|java.time.LocalDate	|
|TIME	|java.time.LocalTime	|
|TIMESTAMP	|java.time.Instant	|
|TIME_WITH_TIMEZONE	|java.time.ZonedDateTime	|
|OTHER	|Object	|