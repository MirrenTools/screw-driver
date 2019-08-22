package org.mirrentools.sd.models.db.update;

/**
 * 数据列属性的基本实现版实现,实际数据库如果操作相同可以继承该类,不同可以选择重写
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public abstract class SdBasicColumnContent extends SdAbstractColumnContent {

	@Override
	public String updateSQL() {
		return " ADD COLUMN " + createSQL();
	}

	@Override
	public String deleteSQL() {
		return " DROP COLUMN " + getName();
	}
}
