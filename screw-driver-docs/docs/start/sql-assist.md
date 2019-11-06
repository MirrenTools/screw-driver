# SqlAssist帮助类说明
SqlAssist是为ScrewDriver生成SQL所定制的查询帮助类,可以用于简化工具生成的Vert.x或MyBatis的SQL查询,在Vert.x于MyBatis中具体方法可能存在差异,但使用方法基本一致!

具体使用方式可以查看SqlAssist类的方法注释,如果不清楚的可以在群里资讯
## 使用示例
``` java
// (1)创建Assist帮助类
SqlAssist assist = new SqlAssist();
// (2)添加条件type=1或3,相当于SQL: where type=1 or type=3
assist.orEq("type", 1).orEq("type", 3);
// (3)去掉重复的数据,相当于SQL: select distinct ...
assist.setDistincts(true);
// (4)自定义只返回id,type,name,seq列
assist.setResultColumn("id,type,name,seq");
// (5)通过seq类倒序排序,相当于SQL: order by seq desc
assist.setOrders(SqlAssist.order("seq", false));
// (6)获取数据库中第20-35行的数据,你也可以使用setPage(第几页)的方式进行分页获取,相当于SQL: limit 20,15
assist.setStartRow(20).setRowSize(15);
// (7)执行获取数据
List<Items> result = itemsDao.selectAll(assist);
```





