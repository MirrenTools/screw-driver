# 模板与匹配规则说明
模板定义使用 [SdTemplate](./core-class-intro.md#sdtemplate) 通过path属性定义模板所在目录,通过file属性定义模板的名称,模板目录获取规则如下:

**如果path为空则获取**
1. classPath/SdTemplates
2. user.dir/SdTemplates
3. 创建user.dir/SdTemplates

**如果path不为空则获取**
1. path
2. user.dir/path
3. user.dir/SdTemplates/path
4. 创建user.dir/SdTemplates/path

**如果file为空获取规则**

获取模板的规则,获取顺序获取,如果到最后还获取不到则抛出异常
1. SdTemplates/file
2. user.dir/SdTemplates/file
3. 复制screw-driver-X.jar/SdTemplates/file 到 user.dir/SdTemplates/file

**如果file不为空获取规则**

获取模板的规则,获取顺序获取,如果到最后还获取不到则抛出异常
1. path/file
2. user.dir/SdTemplates/path/file
3. 复制screw-driver-X.jar/SdTemplates/path/file 到 user.dir/SdTemplates/path/file
4. 复制screw-driver-X.jar/SdTemplates/file 到 user.dir/SdTemplates/path/file


## 通用模板
ScrewDriver默认使用FreeMarker编写了部分常用的模板,同时也实现了MVEL模板渲染,你可以自己编写模板,其他模板你可以参考 [自定义模板引擎](./expand.md#自定义模板引擎)<br>
**普通的java类**<br>
path=null,file=JavaEntity.ftl,生成效果:
``` java
package entity;
/**
 * 用户
 * @author 
 */ 
public class User {
  /** 用户的id */
  private Long id ; 
  /**
   * 获取用户的id
   * 
   * @return
   */
  public Long getId() {
    return id;
  }
  /**
   * 设置用户的id
   * 
   * @param id
   */
  public void setId(Long id) {
    this.id = id;
  }
  @Override
  public String toString() {
    return "User [id=" + id +"]";
  }
}
```

**Lombok的java类**
path=null,file=JavaLombokEntity.ftl,生成效果:
``` java
package entity;
import lombok.Data;
/**
 * 用户
 * @author 
 */ 
@Data
public class User {
	/** 用户的id */
	private Long id ; 
}
```
**流式的java类**<br>
path=null,file=JavaFluentEntity.ftl,生成效果:
``` java
package entity;
/**
 * 用户
 * @author 
 */ 
public class User {
  /** 用户的id */
  private Long id ; 
  /**
   * 获取用户的id
   * 
   * @return
   */
  public Long getId() {
    return id;
  }
  /**
   * 设置用户的id
   * 
   * @param id
   */
  public User setId(Long id) {
    this.id = id;
    return this;
  }
  @Override
  public String toString() {
    return "User [id=" + id +"]";
  }
}
```

## Vert.x模板
[Vert.x](https://vertx.io/) 模板,生成后的代码依赖[vertx-sql-assist](https://github.com/MirrenTools/vertx-sql-assist) 通用SQL操作,也就是你需要添加依赖:
``` xml
<dependency>
  <groupId>org.mirrentools</groupId>
  <artifactId>vertx-sql-assist</artifactId>
  <version>${version}</version>
</dependency>
```
模板路径:
``` java
String entityName="Users"; 
Map<String, SdTemplate> templates = new HashMap<String, SdTemplate>();
templates.put("entity", new SdTemplate()
	.setFile("Entity.ftl")
	.setPackageName("entity")
	.setClassName(entityName));
templates.put("sql", new SdTemplate()
	.setFile("SQL.ftl")
	.setPackageName("sql")
	.setClassName(entityName + "SQL"));
templates.put("service", new SdTemplate()
	.setFile("Service.ftl")
	.setPackageName("service")
	.setClassName(entityName + "Service"));
templates.put("serviceImpl", new SdTemplate()
	.setFile("ServiceImpl.ftl")
	.setPackageName("service.impl")
	.setClassName(entityName + "ServiceImpl"));
templates.put("router", new SdTemplate()
	.setFile("Router.ftl")
	.setPackageName("router")
	.setClassName(entityName + "Router"));
templates.put("test", new SdTemplate()
	.setPath("/SdTemplates/vertx/")
	.setFile("Test.ftl")
	.setSourceFolder(SdConstant.MAVEN_TEST)
	.setPackageName("test")
	.setClassName(entityName+"RouterTest"));
```

## Spring JPA 模板
实体类属性的描述
## MyBatis模板
实体类属性的描述
## MyBatis-Plus 模板
实体类属性的描述