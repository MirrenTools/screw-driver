---
home: true
heroImage: logo.png
actionText: 使用文档
actionLink: /start/introduction
features:
- title: 基于模板引擎
  details: 生成代码的风格由你自由编写模板,已实现FreeMarker、MVEL等模板引擎
- title: 支持多种数据库
  details: 支持MySQL、PostgreSQL、Oracle、DB2、SQL Server、SQLite等数据库
- title: 插拔式
  details: 插拔式设计二次开发、拓展更简单
footer: MIT Licensed | Copyright © 2019-present mirrentools.org
---
## 快速了解ScrewDriver的作用
如果不能观看你可以在 [哔哩哔哩中查看视频](https://www.bilibili.com/video/BV1h54y1s7Zr)

<iframe src="//player.bilibili.com/player.html?aid=843721163&bvid=BV1h54y1s7Zr&cid=283393081&page=1" width='100%' height='600px' scrolling="no" border="0" frameborder="no" framespacing="0" allowfullscreen="true"> </iframe>

ScrewDriver是一个用于生成代码、创建或读取数据库表信息的工具包,可用于IDE编程式生成代码(包括数据库表的读取与创建)或作为其他工具的支持包!
``` XML
<dependency>
    <groupId>org.mirrentools</groupId>
    <artifactId>screw-driver</artifactId>
    <version>[1.0.0,2.0.0)</version>
</dependency>
```
::: warning 运行环境要求
java >= 1.6
:::