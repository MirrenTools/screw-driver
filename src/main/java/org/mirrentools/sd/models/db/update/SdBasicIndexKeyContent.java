package org.mirrentools.sd.models.db.update;

import org.mirrentools.sd.models.db.update.SdAbstractIndexKeyContent;

/**
 * 索引属性的基本实现版实现,实际数据库如果操作相同可以继承该类,不同可以选择重写
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class SdBasicIndexKeyContent extends SdAbstractIndexKeyContent {

	@Override
	public String createSQL() {
		StringBuilder sb = new StringBuilder();
		sb.append(" " + getType());
		sb.append(" " + getName());
		sb.append(" (");
		for (int i = 0; i < getColumns().size(); i++) {
			sb.append(getColumns().get(i));
			if (i != getColumns().size() - 1) {
				sb.append(",");
			}
		}
		sb.append(")");
		if (getRemark() != null) {
			sb.append("  COMMENT '" + getRemark() + "'");
		}
		if (converterExtensions() != null) {
			sb.append(" " + converterExtensions());
		}
		return sb.toString();
	}

	@Override
	public String updateSQL() {
		return deleteSQL() == null 
													? " ADD " + createSQL() 
													: deleteSQL() + " , ADD " + createSQL();
	}

	@Override
	public String deleteSQL() {
		if (getRemoveIndexName() == null) {
			return null;
		}
		return " DROP CONSTRAINT " + getRemoveIndexName();
	}

}
