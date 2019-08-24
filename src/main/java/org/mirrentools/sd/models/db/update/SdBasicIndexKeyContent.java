package org.mirrentools.sd.models.db.update;

/**
 * 索引属性的基本实现版实现,实际数据库如果操作相同可以继承该类,不同可以选择重写
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public abstract class SdBasicIndexKeyContent extends SdAbstractIndexKeyContent {

	@Override
	public String updateSQL() {
		return deleteSQL() == null ? " ADD " + createSQL() : deleteSQL() + " , ADD " + createSQL();
	}

	@Override
	public String deleteSQL() {
		if (getRemoveIndexName() == null) {
			return null;
		}
		return " DROP CONSTRAINT " + getRemoveIndexName();
	}

}
