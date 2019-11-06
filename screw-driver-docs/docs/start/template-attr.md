# 模板数据说明
## SdRenderContent 模板数据
SdRenderContent是模板数据的上下文,上下文的结构为
```
SdRenderContent 名称为: content
	┣━ SdClassContent (实体类描述属性)名称为: content
	┣━ SdDatabaseOptions(数据库配置信息)名称为: dbOptions
	┣━ Map<String, SdTemplateContent>(模板渲染中需要用到哪些模板内容)名称为: items
	┗━ Map<String, Object>(拓展属性)名称为: extensions
	
示例: content.content.pascalName 等于获取模板数据上下文的实体类描述信息的表的名字帕斯卡命名
```
## SdClassContent 实体类属性
实体类模板属性,名称为content,属性说明
|数据类型	|属性名称	|属性描述	|
|--	|--	|--	|
|String	|tableName	|表的名字	|
|String	|alias	|别名	|
|String	|pascalName	|表的名字帕斯卡命名	|
|String	|camelName	|表的名字驼峰命名	|
|String	|hyphenName	|表的名字连字符命名	|
|String	|underScoreName	|表的名字下划线命名	|
|String	|remark	|表的注释	|
|Set&lt;String&gt;|imports	|需要导入的包	|
|Set&lt;String&gt;|annotations	|类的注解	|
|List&lt;[SdColumn](#sdcolumn-实体类的列属性)&gt;	|fields	|属性集(包含下方主键.外键.索引.其他普通属性集,不包含不能为空以及附加属性)	|
|List&lt;[SdColumn](#sdcolumn-实体类的列属性)&gt;	|primaryField	|所有主键属性集	|
|List&lt;[SdColumn](#sdcolumn-实体类的列属性)&gt;	|foreignField	|所有外键属性集	|
|List&lt;[SdColumn](#sdcolumn-实体类的列属性)&gt;	|indexField	|所有索引属性集	|
|List&lt;[SdColumn](#sdcolumn-实体类的列属性)&gt;	|otherField	|所有其他普通的属性集	|
|List&lt;[SdColumn](#sdcolumn-实体类的列属性)&gt;	|cantNullField	|所有不能为空的属性集	|
|List&lt;[SdColumn](#sdcolumn-实体类的列属性)&gt;	|additionalField	|附加的属性,该属性一般用于只需要创建类属性而不需要创建表属性时使用,可以直接定义Field属性	|
|List&lt;[SdRelationalContent](#sdrelationalcontent-关系属性)&gt;	|relationals	|类的关系属性	|
|Map&lt;String,Object&gt;	|extensions	|自定义属性	|
## SdColumn 实体类的列属性
**类属性**
|属性名称	|数据类型	|属性描述	|
|--	|--	|--	|
|Set&lt;String&gt;	|imports	|类需要引入的包	|
|Set&lt;String&gt;	|annotations	|属性需要添加的注解	|
|[SdRelationalContent](#sdrelationalcontent-关系属性)	|relationalContent	|属性的关系属性	|
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


## SdRelationalContent 关系属性
|属性名称	|数据类型	|属性描述	|
|--	|--	|--	|
|Set&lt;String&gt;|imports	|需要导入的包	|
|Set&lt;String&gt;|annotations	|类的注解	|
|Relational(enum)	|relationalType	|关系类型,OneToOne,OneToMany,ManyToOne,ManyToMany	|
|String	|fieldRemark	|关系属性的注释	|
|String	|fieldType	|关系属性数据类型,比如List&lt;Type&gt;	|
|String	|fieldName	|属性的名字	|
|String	|pascalName	|表的名字帕斯卡命名	|
|String	|camelName	|表的名字驼峰命名	|
|String	|hyphenName	|表的名字连字符命名	|
|String	|underScoreName	|表的名字下划线命名	|
|[SdClassContent](#sdclasscontent-实体类属性)	|classContent	|创建类与表所需要的属性	|
|Map&lt;String,Object&gt;	|extensions	|拓展属性	|
## SdDatabaseOptions 数据库连接信息
|属性名称	|数据类型	|属性描述	|
|--	|--	|--	|
|int	|loginTimeout	|连接超时时间 单位秒,默认60秒	|
|String	|driverClass	|数据库驱动	|
|String	|url	|数据库连接地址	|
|String	|user	|数据库连接用户	|
|String	|password	|数据库连接密码	|
|String	|schema	|模式	|
|Map&lt;String,Object&gt;	|extensions	|拓展属性	|
## SdTemplateContent 模板属性
|属性名称	|数据类型	|属性描述	|
|--	|--	|--	|
|String	|path	|模板的所在路径	|
|String	|file	|模板的名字	|
|boolean	|override	|如果文件已经存在是否覆盖	|
|String	|sourceFolder	|项目的源码目录,比如java版maven项目的src/main/java	|
|String	|packageName	|类的包名	|
|String	|className	|类的名字	|
|String	|suffix	|文件的后缀名,如.java	|
|Map&lt;String,[SdTemplateAttribute](#sdtemplateattribute-模板属性值)&gt;	|attrs	|该模板中需要用到的属性,map的key为属性值的key	|
|Map&lt;String,Object&gt;	|extensions	|拓展属性	|
## SdTemplateAttribute 模板属性值
|属性名称	|数据类型	|属性描述	|
|--	|--	|--	|
|String	|key	|属性值的key	|
|String	|value	|属性值的value ,如果需要用实体类名字可以使用占位符{c}=驼峰命名,{p}=帕斯卡命名,{u}=下划线命名,{h}=连字符命名	|
|String	|describe	|属性值的描述 ,如果需要用实体类名字可以使用占位符{c}=驼峰命名,{p}=帕斯卡命名,{u}=下划线命名,{h}=连字符命名	|