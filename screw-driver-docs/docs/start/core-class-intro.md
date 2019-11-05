# 核心类介绍
## SdBean 实体描述
SdBean类用来描述一个实体信息,你可以用它来描述一张数据库表(主要)或一个实体类,属性说明:

该类对应的模板数据为 [SdClassContent](./template-attr.md#sdclasscontent-实体类属性) 
|属性名称	|数据类型	|属性描述	|
|--	|--	|--	|
|String	|name	|名称	|
|String	|alias	|别名	|
|String	|remark	|注释	|
|String	|schema	|模式	|
|String	|owner	|拥有者	|
|String	|tablespace	|表空间	|
|String	|indexspace	|索引表空间	|
|Boolean	|compressable	|是否压缩	|
|Set&lt;String&gt;|imports	|需要导入的包	|
|Set&lt;String&gt;|annotations	|类的注解	|
|List&lt;[SdColumn](./template-attr.md#sdcolumn-实体类的列属性)&gt;	|columns	|列属性	|
|List&lt;[SdColumn](./template-attr.md#sdcolumn-实体类的列属性)&gt;	|additionalColumns	|附加的列属性,该属性一般用于只需要创建类属性而不需要创建表属性时使用	|
|List&lt;SdRelational&gt;	|relationals	|表或类的关系属性	|
|List&lt;SdSequence&gt;	|sequences	|序列属性	|
|Map&lt;String,Object&gt;	|extensions	|自定义属性	|

## SdColumn 属性描述
SdColumn用来描述一个类或表的字段,该类中主要有两种属性:类属性与表属性,类属性如果不定义或为空时就会自动将表属性转换为类属性

该类对应的模板数据为 [SdColumn](./template-attr.md#sdcolumn-实体类的列属性) 

**类属性**
|属性名称	|数据类型	|属性描述	|
|--	|--	|--	|
|Set&lt;String&gt;	|imports	|类需要引入的包	|
|Set&lt;String&gt;	|annotations	|属性需要添加的注解	|
|[SdRelationalContent](./template-attr.md#sdrelationalcontent-关系属性)	|relationalContent	|属性的关系属性	|
|String	|fieldType	|属性的数据类型	|
|String	|fieldName	|属性的名称,驼峰命名,如 mirrenTools	|
|String	|fieldNamePascal	|属性的名称帕斯卡命名,如 MirrenTools	|
|String	|fieldNameHyphen	|属性的名称连字符命名,如 mirren-tools	|
|String	|fieldNameUnderScore	|属性的名字下划线命名,如 mirren_tools	|
|String	|fieldRemark	|属性的注释	|

**类属性**
|属性名称	|数据类型	|属性描述	|
|--	|--	|--	|
|String	|name	|列的名字	|
|String	|type	|列的数据类型	|
|String	|remark	|列的注释	|
|String	|length	|列的长度	|
|String	|_default	|列的默认值	|
|boolean	|primary	|列是否为主键	|
|String	|primaryName	|列的主键名称	|
|boolean	|foreignKey	|列是否为外键	|
|String	|foreignConstraint	|外键的名字	|
|String	|foreignReferencesDB	|外键引用那个库或模式	|
|String	|foreignReferencesTable	|外键引用那个表	|
|String	|foreignReferencesColumn	|外键引用那个表的列	|
|boolean	|index	|是否为索引	|
|boolean	|unique	|索引是否为唯一	|
|boolean	|concurrently	|索引是否并发	|
|String	|indexType	|索引的类型	|
|String	|indexName	|索引的名字	|
|String	|indexRemark	|索引的备注信息	|
|boolean	|nullable	|列是否允许为空,默认true,当primary为true时该属性为false	|
|boolean	|unsigned	|列是否为无符号	|
|boolean	|autoIncrement	|列是否自增量	|
|boolean	|identity	|列是否为标识	|
|Integer	|identitySeed	|标识种子	|
|Integer	|identityIncrement	|标识增量	|
|String	|sequenceName	|自增采用的序列名称	|
|String	|constraintType	|约束条件的类型	|
|String	|constraintName	|约束条件的名称	|
|String	|constraintExp	|约束条件的条件,比如: id &gt; 10	|
|String	|collate	|字符排序	|
|int	|ordinalPosition	|列在表中的顺序	|
|Map&lt;String,Object&gt;	|extensions	|拓展属性	|

## SdRelational 关系描述
SdRelational 用于描述属性的关系共有4种属性:OneToOne, OneToMany, ManyToOne, ManyToMany

该类对应的模板数据为 [SdRelationalContent](./template-attr.md#sdrelationalcontent-关系属性) 
|属性名称	|数据类型	|属性描述	|
|--	|--	|--	|
|Set&lt;String&gt;	|imports	|类需要引入的包	|
|Set&lt;String&gt;	|annotations	|属性需要的注解	|
|Relational	|relationalType	|枚举类,对应4种关系类型	|
|String	|fieldRemark	|关系属性的注释	|
|String	|fieldType	|属性数据类型,比如List&lt;Type&gt;	|
|String	|fieldName	|属性的名字	|
|SdBean	|bean	|创建类与表所需要的属性	|
|Map&lt;String,Object&gt;	|extensions	|拓展属性	|

## SdTemplate 模板信息
SdTemplate用于设置生成模板,比如你想生成3个文件就需要设置3个SdTemplate

该类对应的模板数据为 [SdTemplateContent](./template-attr.md#sdtemplatecontent-模板属性) 
|属性名称	|数据类型	|属性描述	|
|--	|--	|--	|
|String	|path	|模板所在的路径,获取完整的path可以通过SdTemplatePathUtil	|
|String	|file	|模板的名称	|
|boolean	|override	|如果文件已经存在是否覆盖,默认覆盖	|
|String	|sourceFolder	|项目的源码目录,默认值src/main/java/	|
|String	|packageName	|类的包名	|
|String	|className	|类的名字	|
|String	|suffix	|类的后缀名默 .java	|
|List&lt;[SdTemplateAttribute](./template-attr.md#sdtemplateattribute-模板属性值)&gt;	|attributes	|模板中需要用到的属性	|
|Map&lt;String,Object&gt;	|extensions	|拓展属性	|

## SdDatabaseOptions 数据库连接信息
SdDatabaseOptions为连接数据库的配置信息

该类对应的模板数据为 [SdDatabaseOptions](./template-attr.md#sddatabaseoptions-数据库连接信息) 
|属性名称	|数据类型	|属性描述	|
|--	|--	|--	|
|int	|loginTimeout	|连接超时时间 单位秒,默认60秒	|
|String	|driverClass	|数据库驱动	|
|String	|url	|数据库连接地址	|
|String	|user	|数据库连接用户	|
|String	|password	|数据库连接密码	|
|String	|schema	|模式	|
|Map&lt;String,Object&gt;	|extensions	|拓展属性	|

## ScrewDriverOptions 工具配置
ScrewDriverOptions为核心工具的配置信息,在org.mirrentools.sd.options.def中已经创建了不同数据库的默认配置,带有SdDatabaseOptions构造参数的会自动判断不同数据库类型并初始化不同数据库类型的配置
|属性名称	|数据类型	|属性描述	|
|--	|--	|--	|
|SdDatabaseOptions	|databaseOptions	|连接数据库的配置信息	|
|Map&lt;String,SdTemplate&gt;	|templateMaps	|创建代码模板集合,key为模板的名字,value为模板属性	|
|String	|outputPath	|项目所在路径,默认当前项目	|
|String	|codeFormat	|生成使用编码格式,默认UTF-8	|
|SdClassConverter	|beanConverter	|SdClassConverter	|将SdBean转换成类属性的转换器	|
|SdTemplateContentConverter	|templateContentConverter	|模板转换器	|
|ScrewDriverTemplateEngine	|templateEngine	|模板生成工具	|
|ScrewDriverDbUtil	|dbUtil	|数据库相关操作执行工具	|
|SdTableContentConverter	|tableConverter	|将SdBean转换为数据库表的操作属性的转换器	|
|SdTableToClassConverter	|classConverter	|将SdTable转换ClassContent的转换器	|
|SdDatabaseContentConverter	|databaseConverter	|将SdDatabase转换为数据库的操作属性	|
|Map&lt;String,Object&gt;	|extensions	|拓展属性	|

## ScrewDriver 工具
ScrewDriver抽象类是本工具的核心, 用于生成代码与数据库操作
**实例化方法**
通过静态方法 instance获取实例,instance接收一个ScrewDriverOptions参数
|方法名称	|接收参数	|返回结果	|说明	|
|--	|--	|--	|--	|
|createCode	|SdBean 实体类描述	|boolean	|执行生成代码,成功返回true,失败返回false	|
|createCode	|SdClassContent 实体类描述上下文	|boolean	|执行生成代码,成功返回true,失败返回false	|
|createDatabase	|SdDatabase 数据库描述	|boolean	|执行创建数据库,成功返回true,失败返回false	|
|createTable	|SdBean 实体类描述	|boolean	|执行创建表,成功返回true,失败返回false	|
|readTable	|String 表的名称	|SdClassContent	|执行读取表信息,读取成功返回实体描述上下文	|

