# screw-driver
ScrewDriver是一款可以在支持java运行环境中生成数据库表并生成代码的工具
ScrewDriver is a tool that generates database tables and code in a Java-enabled runtime environment
# 使用教程 	Manual
SdBean 是一个表或类的描述  A description of a table or class
SdCodeUtil 用于生成代码 create code
SdSqlUtil 用于生成SQL create SQL
SdProjectUtil 用于生成项目 create Project

```html
	public static void main(String[] args) throws Exception {
		// 创建一个实体描述 <> Create an entity description
		SdBean bean = new SdBean().setName("user").setRemark("用户");
		SdColumn id = new SdColumn()
									.setName("id")
									.setType(MySQL.BIGINT)
									.setPrimary(true)
									.setNullable(false)
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
		// 设置实体生成模板 <> Setting Entity Generation Template
		Map<String, SdTemplate> templates = new HashMap<String, SdTemplate>();
		templates.put("entity", new SdTemplate()
																.setPath("mybatis")
																.setFile("JavaEntity.ftl")
																.setSourceFolder(Constant.MAVEN_SRC)
																.setPackageName("entity")
																.setClassName("User"));
		// 初始化代码执行生成工具 <> Initialization Code Execution Generation Tool
		SdCodeUtil codeUtil = new SdCodeUtilImpl(bean, templates);
		// 创建代码 <> Generate class
		codeUtil.execute();
		// 初始化SQL执行生成工具 <> Initialize the SQL Execution Generation Tool
		SdDatabaseOptions databaseOptions = new SdDatabaseOptions(
				MySQL.MYSQL_8_DERVER,
				"jdbc:mysql://localhost:3306/root?useUnicode=true&useSSL=false&characterEncoding=UTF-8&serverTimezone=UTC")
				.setUser("root")
				.setPassword("root");
		ScrewDriverSQL sqlUtil = new ScrewDriverSqlImpl(bean, databaseOptions);
		// 创建表 <> Create table
		sqlUtil.execute();
	}
``` 

# build
```html
mvn clean package -DskipTests
```
