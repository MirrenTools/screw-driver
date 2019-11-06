# SqlAssist帮助类说明
SqlAssist是为ScrewDriver生成SQL所定制的查询帮助类,可以用于简化工具生成的Vert.x或MyBatis的SQL查询,在Vert.x于MyBatis中具体方法可能存在差异,但使用方法基本一致!

具体使用方式可以查看SqlAssist类的方法注释,如果不清楚的可以在群里咨询
## 方法说明
* **setOrders** 设置排序,通过SqlAssist.order(列名,排序方式)
* **setGroupBy** 设置分组
* **setHaving** 设置分组条件
* **setDistincts** 设置是否去重,true去重
* **setPage** 设置第几页,该值仅在limitAll方法中有效,最终会被转换为startRow
* **setStartRow** 设置从第几行开始取数据
* **setRowSize** 设置每次取多少很数据
* **setResultColumn** 设置返回指定列多个列以,逗号隔开
* **setJoinOrReference** 设置连接查询或多表查询语句
* **and** 添加并且条件
* **or** 添加或者条件
* **andEq** 添加并且等于条件
* **orEq** 添加或者等于条件
* **andNeq** 添加并且不等于条件
* **orNeq** 添加或者不等于条件
* **andLt** 添加并且小于条件
* **orLt** 添加或者小于条件
* **andLte** 添加并且小于等于条件
* **orLte** 添加或者小于等于条件
* **andGt** 添加并且大于条件
* **orGt** 添加或者大于条件
* **andGte** 添加并且大于等于条件
* **orGte** 添加或者大于等于条件
* **andLike** 添加并且like条件
* **orLike** 添加或者like条件
* **setConditions** 添加查询条件
* **customCondition** 添加自定义查询条件
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
