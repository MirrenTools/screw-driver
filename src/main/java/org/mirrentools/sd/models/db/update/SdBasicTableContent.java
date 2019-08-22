package org.mirrentools.sd.models.db.update;

import org.mirrentools.sd.models.db.update.SdAbstractTableContent;

/**
 * 数据库表属性创建或者修改SQL语句的基本实现版实现,实际数据库如果操作相同可以继承该类,不同可以选择重写
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public abstract class SdBasicTableContent extends SdAbstractTableContent {

	@Override
	public String deleteSQL() {
		return " DROP TABLE " + getTableName() + ";";
	}

}
