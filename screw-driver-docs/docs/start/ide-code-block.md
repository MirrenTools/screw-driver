# 在IDE中定义快捷键
## 在Eclipse定义创建快捷键
在Eclipse中创建代码块方式如下:
```
方式一. 在编辑页面使用快捷键 Shift+Alt+Z 选择 Configure Templates
方式二. 选择Window > Preferences > Java > Editor > Templates 
```
1. 选择 New...
2. Name: 输入sdc(可以改成自己喜欢的名称)
3. Context:选择Java,其他默认
4. Pattern: 输入以下内容
``` java
${imp:import(
java.util.HashMap,
java.util.Map,
org.mirrentools.sd.ScrewDriver,
org.mirrentools.sd.SdType,
org.mirrentools.sd.common.SdUtil,
org.mirrentools.sd.constant.MySQL, 
org.mirrentools.sd.models.SdBean, 
org.mirrentools.sd.models.SdColumn, 
org.mirrentools.sd.models.SdTemplate, 
org.mirrentools.sd.options.ScrewDriverOptions, 
org.mirrentools.sd.options.SdDatabaseOptions)}
// 创建一个实体描述
String tableName = "${tname}";
SdBean bean = new SdBean();
bean.setName(tableName).setRemark("${comment}");
bean.addColumn(new SdColumn().setName("${id}").setType(SdType.LONG));

String packageName = "${com}";// 实体类包名
String entityName = SdUtil.toPascalCase(tableName);// 实体类名称
// 设置实体生成模板
Map<String, SdTemplate> templates = new HashMap<String, SdTemplate>();
//TODO 去掉这一行并参考 模板与匹配规则说明添加要生成的模板
// 初始化数据库连接信息
SdDatabaseOptions databaseOptions = new SdDatabaseOptions(
		MySQL.MYSQL_8_DERVER, 
		"jdbc:mysql://localhost:3306/root?useUnicode=true&useSSL=false&serverTimezone=UTC"
		);
databaseOptions.setUser("root");
databaseOptions.setPassword("root");
// 初始化执行工具
ScrewDriver screwDriver = ScrewDriver.instance(new ScrewDriverOptions(databaseOptions));
// 创建代码
screwDriver.createCode(bean,templates);
// 生成表
screwDriver.createTable(bean);
```
在Main方法中输入sdc回车
## 在Eclipse定义读取快捷键
在Eclipse中创建代码块方式如下:
```
方式一. 在编辑页面使用快捷键 Shift+Alt+Z 选择 Configure Templates
方式二. 选择Window > Preferences > Java > Editor > Templates 
```
1. 选择 New...
2. Name: 输入sdr(可以改成自己喜欢的名称)
3. Context:选择Java,其他默认
4. Pattern: 输入以下内容
``` java
${imp:import(
java.util.HashMap,
java.util.Map,
org.mirrentools.sd.ScrewDriver,
org.mirrentools.sd.common.SdUtil,
org.mirrentools.sd.constant.MySQL, 
org.mirrentools.sd.models.SdClassContent, 
org.mirrentools.sd.models.SdTemplate, 
org.mirrentools.sd.options.ScrewDriverOptions, 
org.mirrentools.sd.options.SdDatabaseOptions)}

String tableName = "${tname}";// 表的名称
String packageName = "${com}";// 实体类包名
String entityName = SdUtil.toPascalCase(tableName);// 实体类名称
// 设置实体生成模板
Map<String, SdTemplate> templates = new HashMap<String, SdTemplate>();
// TODO 去掉这一行并参考 模板与匹配规则说明添加要生成的模板
// 初始化数据库连接信息
SdDatabaseOptions databaseOptions = new SdDatabaseOptions(MySQL.MYSQL_8_DERVER, "jdbc:mysql://localhost:3306/root?useUnicode=true&useSSL=false&serverTimezone=UTC");
databaseOptions.setUser("root");
databaseOptions.setPassword("root");

// 初始化执行工具
ScrewDriver screwDriver = ScrewDriver.instance(new ScrewDriverOptions(databaseOptions));
// 读取表信息
SdClassContent content = screwDriver.readTable(tableName);
// 创建代码
screwDriver.createCode(content,templates);
```
在Main方法中输入sdr回车
## 在IDEA定义创建快捷键
在IDEA中创建代码块方式如下:
```
方式一. 在编辑页面使用快捷键 Ctrl+Alt+S
方式二. 选择File > Settings > Editor > Live Templates 
```
1. 选择＋号 live template
2. Abbreviation: 输入sdc(可以改成自己喜欢的名称)
3. Template text: 输入以下内容,选择下方的提示No applicable contexts yet. [Define] 选择java
``` java
// 创建一个实体描述
String tableName = "$tname$";
org.mirrentools.sd.models.SdBean bean = new SdBean();
bean.setName(tableName).setRemark("$comment$");
bean.addColumn(new org.mirrentools.sd.models.SdColumn().setName("$id$").setType(org.mirrentools.sd.SdType.LONG));

String packageName = "$com$";// 实体类包名
String entityName = org.mirrentools.sd.common.SdUtil.toPascalCase(tableName);// 实体类名称
// 设置实体生成模板
java.util.Map<String, org.mirrentools.sd.models.SdTemplate> templates = new java.util.HashMap<String, SdTemplate>();
//TODO 去掉这一行并参考 模板与匹配规则说明添加要生成的模板
// 初始化数据库连接信息
org.mirrentools.sd.options.SdDatabaseOptions databaseOptions = new SdDatabaseOptions(
		org.mirrentools.sd.constant.MySQL.MYSQL_8_DERVER, 
		"jdbc:mysql://localhost:3306/root?useUnicode=true&useSSL=false&serverTimezone=UTC"
		);
databaseOptions.setUser("root");
databaseOptions.setPassword("root");
// 初始化执行工具
org.mirrentools.sd.ScrewDriver screwDriver = ScrewDriver.instance(new org.mirrentools.sd.options.ScrewDriverOptions(databaseOptions));
// 创建代码
screwDriver.createCode(bean,templates);
// 生成表
screwDriver.createTable(bean);
```
在Main方法中输入sdc回车
## 在IDEA定义读取快捷键
在IDEA中创建代码块方式如下:
```
方式一. 在编辑页面使用快捷键 Ctrl+Alt+S
方式二. 选择File > Settings > Editor > Live Templates 
```
1. 选择＋号 live template
2. Abbreviation: 输入sdr(可以改成自己喜欢的名称)
3. Template text: 输入以下内容,选择下方的提示No applicable contexts yet. [Define] 选择java
``` java
String tableName = "$tname$";
String packageName = "$com$";// 实体类包名
String entityName = org.mirrentools.sd.common.SdUtil.toPascalCase(tableName);// 实体类名称
// 设置实体生成模板
java.util.Map<String, org.mirrentools.sd.models.SdTemplate> templates = new java.util.HashMap<String, SdTemplate>();
//TODO 去掉这一行并参考 模板与匹配规则说明添加要生成的模板
// 初始化数据库连接信息
org.mirrentools.sd.options.SdDatabaseOptions databaseOptions = new SdDatabaseOptions(
		org.mirrentools.sd.constant.MySQL.MYSQL_8_DERVER, 
		"jdbc:mysql://localhost:3306/root?useUnicode=true&useSSL=false&serverTimezone=UTC"
		);
databaseOptions.setUser("root");
databaseOptions.setPassword("root");
// 初始化执行工具
org.mirrentools.sd.ScrewDriver screwDriver = ScrewDriver.instance(new org.mirrentools.sd.options.ScrewDriverOptions(databaseOptions));
// 读取表信息
org.mirrentools.sd.models.SdClassContent content = screwDriver.readTable(tableName);
// 创建代码
screwDriver.createCode(content,templates);
```
在Main方法中输入sdr回车