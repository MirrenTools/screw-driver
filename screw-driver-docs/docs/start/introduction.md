# 起步
ScrewDriver是一个用于生成代码、创建或读取数据库表信息的工具包,该工具想达到的目的是藉着IDE的代码块,通过快捷键快速生成代码,或成为其他生成工具的基础工具!

QQ交流群:519714660  <a target="_blank" href="//shang.qq.com/wpa/qunwpa?idkey=a3a3b32d79453bd9d740662a622d3b620e6adf0488f670a228186a41fbadb257"><img border="0" src="//pub.idqqimg.com/wpa/images/group.png" alt="QQ交流群" title="QQ交流群"></a>

基本说明: [哔哩哔哩中查看视频](https://www.bilibili.com/video/BV1h54y1s7Zr)

## 添加依赖
``` XML
<dependency>
    <groupId>org.mirrentools</groupId>
    <artifactId>screw-driver</artifactId>
    <version>最新版</version>
</dependency>
```

## 读取数据库表信息并生成代码示例
1. 初始化	[ScrewDriver](./core-class-intro.md#ScrewDriver) 
2. 读取表信息并执行创建
``` java
public static void main(String[] args) throws Exception {
	// 初始化执行工具
	ScrewDriver screwDriver = ScrewDriver.instance(new ScrewDriverOptions(SdDatabaseOptions));
	// 读取表信息
	SdClassContent content = screwDriver.readTable("table");
	// 创建代码
	screwDriver.createCode(content,templates);
}
```
提示: SdDatabaseOptions与templates参考底部[常量说明](#%E5%B8%B8%E9%87%8F%E8%AF%B4%E6%98%8E)

## 仅创建代码示例
1. 定义 [SdBean](http://mirren.gitee.io/screw-driver-docs/start/core-class-intro.html#sdbean-%E5%AE%9E%E4%BD%93%E6%8F%8F%E8%BF%B0)
2. 初始化 ScrewDriver 并执行
``` java
public static void main(String[] args) throws Exception {
	// 创建一个实体描述
	SdBean bean = new SdBean();
	bean.setName("user").setRemark("用户");
	bean.addColumn(new SdColumn().setName("id").setType(SdType.LONG).setPrimary(true).setRemark("用户的id"));
	bean.addColumn(new SdColumn().setName("name").setType(SdType.STRING).setLength(30).setRemark("用户的名字"));
	bean.addColumn(new SdColumn().setName("pwd").setType(SdType.STRING).setLength(60).setRemark("用户的的密码"));

	// 初始化执行工具
	ScrewDriver screwDriver = ScrewDriver.instance(new ScrewDriverOptions());
	// 创建代码
	screwDriver.createCode(bean,templates);
}
```
提示: SdDatabaseOptions与templates参考底部[常量说明](#%E5%B8%B8%E9%87%8F%E8%AF%B4%E6%98%8E)

## 创建代码与生成表示例
1. 定义 [SdBean](./core-class-intro.md#SdBean)
2. 初始化 ScrewDriver 并执行
``` java
public static void main(String[] args) throws Exception {
	// 创建一个实体描述
	SdBean bean = new SdBean();
	bean.setName("user").setRemark("用户");
	bean.addColumn(new SdColumn().setName("id").setType(SdType.LONG).setPrimary(true).setRemark("用户的id"));
	bean.addColumn(new SdColumn().setName("name").setType(SdType.STRING).setLength(30).setRemark("用户的名字"));
	bean.addColumn(new SdColumn().setName("pwd").setType(SdType.STRING).setLength(60).setRemark("用户的的密码"));

	// 初始化执行工具
	ScrewDriver screwDriver = ScrewDriver.instance(new ScrewDriverOptions(SdDatabaseOptions));
	// 创建代码
	screwDriver.createCode(bean,templates);
	// 生成表
	screwDriver.createTable(bean);
}
```
提示: SdDatabaseOptions与templates参考下方[常量说明](#%E5%B8%B8%E9%87%8F%E8%AF%B4%E6%98%8E)

## 常量说明
1. 数据库连接信息 [SdDatabaseOptions](./core-class-intro.md#sddatabaseoptions-%E6%95%B0%E6%8D%AE%E5%BA%93%E8%BF%9E%E6%8E%A5%E4%BF%A1%E6%81%AF)
2. 生成代码模板 [SdTemplate](./core-class-intro.html#sdtemplate-%E6%A8%A1%E6%9D%BF%E4%BF%A1%E6%81%AF)
```
	// 数据库连接信息
	SdDatabaseOptions databaseOptions = new SdDatabaseOptions(MySQL.MYSQL_8_DERVER, "jdbc:mysql://localhost:3306/root?useUnicode=true&useSSL=false&serverTimezone=UTC");
	databaseOptions.setUser("root");
	databaseOptions.setPassword("root");
	
	// 设置代码生成模板
	Map<String, SdTemplate> templates = new HashMap<String, SdTemplate>();
	templates.put("entity", new SdTemplate().setFile("JavaEntity.ftl").setPackageName("entity").setClassName("User"));
	templates.put("dao", new SdTemplate().setFile("Dao.ftl").setPackageName("dao").setClassName("Dao"));
	templates.put("service", new SdTemplate().setFile("Service.ftl").setPackageName("service").setClassName("Service"));
	templates.put("controller", new SdTemplate().setFile("Controller.ftl").setPackageName("controller").setClassName("Controller"));
	
```
