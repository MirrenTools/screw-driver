# 模板数据说明
## SdRenderContent 
SdRenderContent是模板数据的上下文,上下文的结构为
```
SdRenderContent 名称为: content
	┣━ SdClassContent (实体类描述属性)名称为: content
	┣━ SdDatabaseOptions(数据库配置信息)名称为: dbOptions
	┣━ Map<String, SdTemplateContent>(模板渲染中需要用到哪些模板内容)名称为: items
	┗━ Map<String, Object>(拓展属性)名称为: extensions
	
示例: content.content.pascalName 等于获取模板数据上下文的实体类描述信息的表的名字帕斯卡命名
```
## SdClassContent
实体类的描述,属性说明
|属性名称	|数据类型	|属性描述	|
|--	|--	|--	|
|tableName	|String	|表的名字	|
|alias	|String	|别名	|
|pascalName	|String	|表的名字帕斯卡命名	|
|camelName	|String	|表的名字驼峰命名	|
|hyphenName	|String	|表的名字连字符命名	|
|underScoreName	|String	|表的名字下划线命名	|
|remark	|String	|表的注释	|
|imports	|Set&lt;String&gt;|需要导入的包	|
|	|	|	|
|	|	|	|
|	|	|	|
|	|	|	|
|	|	|	|
## SdColumn
实体类属性的描述
## SdRelationalContent
实体类属性的描述
## SdDatabaseOptions
实体类属性的描述
## SdTemplateContent
实体类属性的描述