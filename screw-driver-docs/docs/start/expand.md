# 拓展与自定义
## 目录结构
```
screw-driver
┣━ screw-driver-docs 工具的使用帮助文档,使用vuepress编写(https://www.vuepress.cn/)
┣━ src/main/resources/SdTemplates 为模板目录,模板通常不会被直接使用,因为当需要该目录的模板时就会copy模板到根目录的SdTemplates文件夹中,如果不存在就创建
┗━ src/main/java/org/mirrentools/sd/ 代码,基于java1.6编写,maven管理
	┣━ common [包]一些通用的工具
	┣━ constant [包]一些常量
	┣━ converter [包]转换器的接口与实现,分别为接口 > 抽象类(SdAbstract) > 基础实现(SdBasic) > 具体实现(impl包)
	┣━ enums [包]一些枚举类
	┣━ impl [包]核心工具的基础实现
	┣━ models [包]工具的实体类其中db包中update用于创建或修改数据库表信息,query用于查询数据库表信息
	┣━ options [包]一些配置信息,其中def包为不同数据库的默认配置
	┣━ ScrewDriver (类)核心接口
	┣━ ScrewDriverCode (类)生成代码的接口
	┣━ ScrewDriverDbUtil (类)数据库相关操作工具
	┣━ ScrewDriverException (类)异常类
	┣━ ScrewDriverProject (类)创建项目的接口
	┣━ ScrewDriverSQL (类)创建或读取操作数据库的接口
	┣━ ScrewDriverTemplateEngine (类)模板渲染引擎(生成文件)的接口
	┗━ SdType (类)自适应数据类型
```

## 数据库支持
如果数据库相关操作不兼容,你可以继承ScrewDriverDbUtil接口的实现或converter包中的实现,并重写不兼容的方法后设置 [ScrewDriverOptions](./core-class-intro.md#screwdriveroptions-工具配置) 为你重写后的实现。

如果你想新增其他数据库支持,大楷你需要做这些操作
1.	在org.mirrentools.sd.impl.dbutil包中创建ScrewDriverDbUtil的实现类,可继承SdAbstractDbUtil抽象类,重写抽象类不兼容的方法,可以参考同级实现,推荐命名规则为SdDbUtil新数据库名Impl
2.	在org.mirrentools.sd.converter.impl中创建新数据库名相同的包名,并实现converter中的几个转换器,可以参考同级实现,推荐命名SdXxxConverter新数据库名称Impl
3.	在org.mirrentools.sd.options.def中创建新数据库配置文件,并在ScrewDriverOptions的init方法中判断配置并初始化新数据库配置,可以参考同级实现,推荐命名规则为ScrewDriver新数据库名Options
4.	在org.mirrentools.sd.constant中添加新数据库的常量类
5.	在org.mirrentools.sd.enums.SdTypeMode枚举类中添加新数据库类型,并在 [SdType](./sd-type.md) 类中添加新数据库词典以及对应的数据类型


## 自定义模板引擎 
软件目前提供了FreeMarker与MVEL开箱即用的模板引擎,如果这两个不满足或需要自定义模板,

你可以继承**org.mirrentools.sd.ScrewDriverTemplateEngine**抽象类并实现render方法,

具体实现可以参考**org.mirrentools.sd.impl.ScrewDriverTemplateFreeMarkerImpl** 或 **ScrewDriverTemplateMvelImpl**。

启用自定义模板渲染引擎需要设置 [ScrewDriverOptions](./core-class-intro.md#screwdriveroptions) 的templateEngine属性,既调用setTemplateEngine(你的实现类)