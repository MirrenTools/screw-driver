# 模板匹配规则说明
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

## 自定义模板实现 
软件目前提供了FreeMarker与MVEL开箱即用的模板引擎,如果这两个不满足或需要自定义模板,

你可以继承**org.mirrentools.sd.ScrewDriverTemplateEngine**抽象类并实现render方法,

具体实现可以参考**org.mirrentools.sd.impl.ScrewDriverTemplateFreeMarkerImpl** 或 **ScrewDriverTemplateMvelImpl**。

启用自定义模板需要设置 [ScrewDriverOptions](./core-class-intro.md#screwdriveroptions)的templateEngine属性,既调用setTemplateEngine(你的实现类)

## 通用模板
实体类的描述
## Vert.x模板
实体类属性的描述
## JPA 模板
实体类属性的描述
## MyBatis模板
实体类属性的描述
## MyBatis-Plus 模板
实体类属性的描述