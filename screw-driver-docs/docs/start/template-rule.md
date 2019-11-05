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


## 通用模板
ScrewDriver默认使用FreeMarker编写了部分常用的模板,同时也实现了MVEL模板渲染,你可以自己编写模板,其他模板你可以参考 [自定义模板引擎](./expand.md#自定义模板引擎)


## Vert.x模板
实体类属性的描述
## JPA 模板
实体类属性的描述
## MyBatis模板
实体类属性的描述
## MyBatis-Plus 模板
实体类属性的描述