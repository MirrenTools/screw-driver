# screw-driver
ScrewDriver是一款可以在支持java运行环境中生成数据库表并生成代码的工具  
ScrewDriver is a tool that generates database tables and code in a Java-enabled runtime environment  
# 使用教程 	Manual
SdBean 一个表或类的描述  A description of a table or class  
SdColumn 列的描述  A description of column  
ScrewDriver 工具类,用于生成代码和SQL   create code and SQL

```java
public static void main(String[] args) throws Exception {
  // 创建一个实体描述  Create an entity description
  SdBean bean = new SdBean().setName("user").setRemark("用户");
  SdColumn id = new SdColumn()
    .setName("id")
    .setType(MySQL.BIGINT)
    .setPrimary(true)
    .setAutoIncrement(true)
    .setRemark("用户的id");
  SdColumn name = new SdColumn()
    .setName("name")
    .setType(MySQL.VARCHAR)
    .setLength(30)
    .setRemark("用户的名字");
  SdColumn pwd = new SdColumn()
    .setName("pwd")
    .setType(MySQL.VARCHAR)
    .setLength(60)
    .setRemark("用户的的密码");
  bean.setColumns(SdUtil.asList(id, name, pwd));
  // 设置实体生成模板  Setting Entity Generation Template
  Map<String, SdTemplate> templates = new HashMap<String, SdTemplate>();
  templates.put("entity", new SdTemplate()
    .setPath("mybatis")
    .setFile("JavaEntity.ftl")
    .setSourceFolder(Constant.MAVEN_SRC)
    .setPackageName("entity")
    .setClassName("User"));
  // 初始化数据库连接信息   Initialize database connection information
  SdDatabaseOptions databaseOptions = new SdDatabaseOptions(
    MySQL.MYSQL_8_DERVER,
    "jdbc:mysql://localhost:3306/root?useUnicode=true&useSSL=false&characterEncoding=UTF-8&serverTimezone=UTC")
    .setUser("root")
    .setPassword("root");
  // 初始化执行工具   Initialization Execution Generation Tool
  ScrewDriver screwDriver = ScrewDriver.instance(new ScrewDriverOptions(templates, databaseOptions));
  // 创建代码   Generate class
  screwDriver.createCode(bean);
  // 生成表  Create table
  screwDriver.createTable(bean);
}
``` 

# build
```java
mvn clean package -DskipTests
```
