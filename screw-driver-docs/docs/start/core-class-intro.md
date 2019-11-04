# 核心类介绍
## SdBean
SdBean类用来描述一个实体信息,你可以用它来描述一张数据库表(主要)或一个实体类,属性说明:

该类对应的模板数据为 [SdClassContent](./template-attr.md#sdclasscontent) 
|属性名称	|数据类型	|属性描述	|
|--	|--	|--	|
|name	|String	|名称	|
|alias	|String	|别名	|
|remark	|String	|注释	|
|schema	|String	|模式	|
|owner	|String	|拥有者	|
|tablespace	|String	|表空间	|
|indexspace	|String	|索引表空间	|
|compressable	|Boolean	|是否压缩	|
|columns	|List&lt;[SdColumn](./template-attr.md#sdcolumn)&gt;	|列属性	|
|additionalColumns	|List&lt;[SdColumn](./template-attr.md#sdcolumn)&gt;	|附加的列属性,该属性一般用于只需要创建类属性而不需要创建表属性时使用	|
|relationals	|List&lt;SdRelational&gt;	|表或类的关系属性	|
|sequences	|List&lt;SdSequence&gt;	|序列属性	|
|extensions	|Map&lt;String,Object&gt;	|自定义属性	|

## SdColumn
SdColumn用来描述一个类或表的字段,该类中主要有两种属性:类属性与表属性,类属性如果不定义或为空时就会自动将表属性转换为类属性

该类对应的模板数据为 [SdColumn](./template-attr.md#sdcolumn) 

**类属性**
|属性名称	|数据类型	|属性描述	|
|--	|--	|--	|
|imports	|Set&lt;String&gt;	|类需要引入的包	|
|annotations	|Set&lt;String&gt;	|属性需要添加的注解	|
|relationalContent	|[SdRelationalContent](./template-attr.md#sdrelationalcontent)	|属性的关系属性	|
|fieldType	|String	|属性的数据类型	|
|fieldName	|String	|属性的名称,驼峰命名,如 mirrenTools	|
|fieldNamePascal	|String	|属性的名称帕斯卡命名,如 MirrenTools	|
|fieldNameHyphen	|String	|属性的名称连字符命名,如 mirren-tools	|
|fieldNameUnderScore	|String	|属性的名字下划线命名,如 mirren_tools	|
|fieldRemark	|String	|属性的注释	|

**类属性**
|属性名称	|数据类型	|属性描述	|
|--	|--	|--	|
|name	|String	|列的名字	|
|type	|String	|列的数据类型	|
|remark	|String	|列的注释	|
|length	|String	|列的长度	|
|_default	|String	|列的默认值	|
|primary	|boolean	|列是否为主键	|
|primaryName	|String	|列的主键名称	|
|foreignKey	|boolean	|列是否为外键	|
|foreignConstraint	|String	|外键的名字	|
|foreignReferencesDB	|String	|外键引用那个库或模式	|
|foreignReferencesTable	|String	|外键引用那个表	|
|foreignReferencesColumn	|String	|外键引用那个表的列	|
|index	|boolean	|是否为索引	|
|unique	|boolean	|索引是否为唯一	|
|concurrently	|boolean	|索引是否并发	|
|indexType	|String	|索引的类型	|
|indexName	|String	|索引的名字	|
|indexRemark	|String	|索引的备注信息	|
|nullable	|boolean	|列是否允许为空,默认true,当primary为true时该属性为false	|
|unsigned	|boolean	|列是否为无符号	|
|autoIncrement	|boolean	|列是否自增量	|
|identity	|boolean	|列是否为标识	|
|identitySeed	|Integer	|标识种子	|
|identityIncrement	|Integer	|标识增量	|
|sequenceName	|String	|自增采用的序列名称	|
|constraintType	|String	|约束条件的类型	|
|constraintName	|String	|约束条件的名称	|
|constraintExp	|String	|约束条件的条件,比如: id &gt; 10	|
|collate	|String	|字符排序	|
|ordinalPosition	|int	|列在表中的顺序	|
|extensions	|Map&lt;String,Object&gt;	|拓展属性	|

## SdRelational
SdRelational 用于描述属性的关系共有4种属性:OneToOne, OneToMany, ManyToOne, ManyToMany

该类对应的模板数据为 [SdRelationalContent](./template-attr.md#sdrelationalcontent) 
|属性名称	|数据类型	|属性描述	|
|--	|--	|--	|
|imports	|Set&lt;String&gt;	|类需要引入的包	|
|annotations	|Set&lt;String&gt;	|属性需要的注解	|
|relationalType	|Relational	|枚举类,对应4种关系类型	|
|fieldRemark	|String	|关系属性的注释	|
|fieldType	|String	|属性数据类型,比如List&lt;Type&gt;	|
|fieldName	|String	|属性的名字	|
|bean	|SdBean	|创建类与表所需要的属性	|
|extensions	|Map&lt;String,Object&gt;	|拓展属性	|

## SdTemplate
SdTemplate用于设置生成模板,比如你想生成3个文件就需要设置3个SdTemplate

该类对应的模板数据为 [SdTemplateContent](./template-attr.md#sdtemplatecontent) 
|属性名称	|数据类型	|属性描述	|
|--	|--	|--	|
|path	|String	|模板所在的路径,获取完整的path可以通过SdTemplatePathUtil	|
|file	|String	|模板的名称	|
|override	|boolean	|如果文件已经存在是否覆盖,默认覆盖	|
|sourceFolder	|String	|项目的源码目录,默认值src/main/java/	|
|packageName	|String	|类的包名	|
|className	|String	|类的名字	|
|suffix	|String	|类的后缀名默 .java	|
|attributes	|List&lt;SdTemplateAttribute&gt;	|模板中需要用到的属性	|
|extensions	|Map&lt;String,Object&gt;	|拓展属性	|
## SdDatabaseOptions
SdDatabaseOptions为连接数据库的配置信息

该类对应的模板数据为 [SdDatabaseOptions](./template-attr.md#sddatabaseoptions) 
|属性名称	|数据类型	|属性描述	|
|--	|--	|--	|
|loginTimeout	|int	|连接超时时间 单位秒,默认60秒	|
|driverClass	|String	|数据库驱动	|
|url	|String	|数据库连接地址	|
|user	|String	|数据库连接用户	|
|password	|String	|数据库连接密码	|
|schema	|String	|模式	|
|extensions	|Map&lt;String,Object&gt;	|拓展属性	|
## ScrewDriverOptions
ScrewDriverOptions为核心工具的配置信息,在org.mirrentools.sd.options.def中已经创建了不同数据库的默认配置,带有SdDatabaseOptions构造参数的会自动判断不同数据库类型并初始化不同数据库类型的配置
|属性名称	|数据类型	|属性描述	|
|--	|--	|--	|
|databaseOptions	|SdDatabaseOptions	|连接数据库的配置信息	|
|templateMaps	|Map&lt;String,SdTemplate&gt;	|创建代码模板集合,key为模板的名字,value为模板属性	|
|outputPath	|String	|项目所在路径,默认当前项目	|
|codeFormat	|String	|生成使用编码格式,默认UTF-8	|
|beanConverter	|SdClassConverter	|将SdBean转换成类属性的转换器	|
|templateContentConverter	|SdTemplateContentConverter	|模板转换器	|
|templateEngine	|ScrewDriverTemplateEngine	|模板生成工具	|
|dbUtil	|ScrewDriverDbUtil	|数据库相关操作执行工具	|
|tableConverter	|SdTableContentConverter	|将SdBean转换为数据库表的操作属性的转换器	|
|classConverter	|SdTableToClassConverter	|将SdTable转换ClassContent的转换器	|
|databaseConverter	|SdDatabaseContentConverter	|将SdDatabase转换为数据库的操作属性	|
|extensions	|Map&lt;String,Object&gt;	|拓展属性	|
## ScrewDriver
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

