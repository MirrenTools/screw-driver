# 起步
ScrewDriver是一个用于生成代码、创建或读取数据库表信息的工具包,该工具想达到的目的是藉着IDE的代码块,通过快捷键快速生成代码,或成为其他生成工具的基础工具!

QQ交流群:519714660  <a target="_blank" href="//shang.qq.com/wpa/qunwpa?idkey=a3a3b32d79453bd9d740662a622d3b620e6adf0488f670a228186a41fbadb257"><img border="0" src="//pub.idqqimg.com/wpa/images/group.png" alt="QQ交流群" title="QQ交流群"></a>

## 添加依赖
``` XML
<dependency>
    <groupId>org.mirrentools</groupId>
    <artifactId>screw-driver</artifactId>
    <version>1.1.0</version>
</dependency>
```

## 创建代码与生成表示例
1. 定义 [SdBean](./core-class-intro.md#SdBean)
2. 添加生成模板 [SdTemplate](./core-class-intro.md#SdTemplate)
3. 设置数据库连接信息 [SdDatabaseOptions](./core-class-intro.md#SdDatabaseOptions)
4. 初始化	[ScrewDriver](./core-class-intro.md#ScrewDriver) 并执行创建
``` java
public static void main(String[] args) throws Exception {
	// 创建一个实体描述
	SdBean bean = new SdBean();
	bean.setName("user").setRemark("用户");
	bean.addColumn(new SdColumn().setName("id").setType(SdType.LONG).setPrimary(true).setRemark("用户的id"));
	bean.addColumn(new SdColumn().setName("name").setType(SdType.STRING).setLength(30).setRemark("用户的名字"));
	bean.addColumn(new SdColumn().setName("pwd").setType(SdType.STRING).setLength(60).setRemark("用户的的密码"));

	// 设置实体生成模板
	Map<String, SdTemplate> templates = new HashMap<String, SdTemplate>();
	templates.put("entity", new SdTemplate().setFile("JavaEntity.ftl").setPackageName("entity").setClassName("User"));
	templates.put("dao", new SdTemplate().setFile("Dao.ftl").setPackageName("dao").setClassName("Dao"));
	templates.put("service", new SdTemplate().setFile("Service.ftl").setPackageName("service").setClassName("Service"));
	templates.put("controller", new SdTemplate().setFile("Controller.ftl").setPackageName("controller").setClassName("Controller"));

	// 初始化数据库连接信息
	SdDatabaseOptions databaseOptions = new SdDatabaseOptions(MySQL.MYSQL_8_DERVER, "jdbc:mysql://localhost:3306/root?useUnicode=true&useSSL=false&serverTimezone=UTC");
	databaseOptions.setUser("root");
	databaseOptions.setPassword("root");
	
	// 初始化执行工具
	ScrewDriver screwDriver = ScrewDriver.instance(new ScrewDriverOptions(templates, databaseOptions));
	// 创建代码
	screwDriver.createCode(bean);
	// 生成表
	screwDriver.createTable(bean);
}
```

## 读取数据库表信息并生成代码示例
1. 添加生成模板 [SdTemplate](./core-class-intro.md#SdTemplate)
2. 设置数据库连接信息 [SdDatabaseOptions](./core-class-intro.md#SdDatabaseOptions)
3. 初始化	[ScrewDriver](./core-class-intro.md#ScrewDriver) 
4. 读取表信息并执行创建
``` java
public static void main(String[] args) throws Exception {
	// 设置实体生成模板
	Map<String, SdTemplate> templates = new HashMap<String, SdTemplate>();
	templates.put("entity", new SdTemplate().setFile("JavaEntity.ftl").setPackageName("entity").setClassName("User"));
	templates.put("dao", new SdTemplate().setFile("Dao.ftl").setPackageName("dao").setClassName("Dao"));
	templates.put("service", new SdTemplate().setFile("Service.ftl").setPackageName("service").setClassName("Service"));
	templates.put("controller", new SdTemplate().setFile("Controller.ftl").setPackageName("controller").setClassName("Controller"));
	
	// 初始化数据库连接信息
	SdDatabaseOptions databaseOptions = new SdDatabaseOptions(MySQL.MYSQL_8_DERVER, "jdbc:mysql://localhost:3306/root?useUnicode=true&useSSL=false&serverTimezone=UTC");
	databaseOptions.setUser("root");
	databaseOptions.setPassword("root");
	
	// 初始化执行工具
	ScrewDriver screwDriver = ScrewDriver.instance(new ScrewDriverOptions(templates, databaseOptions));
	// 读取表信息
	SdClassContent content = screwDriver.readTable("root");
	// 创建代码
	screwDriver.createCode(content);
}
```