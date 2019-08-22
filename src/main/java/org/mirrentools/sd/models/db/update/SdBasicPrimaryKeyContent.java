package org.mirrentools.sd.models.db.update;

/**
 * 主键属性的基本实现版实现,实际数据库如果操作相同可以继承该类,不同可以选择重写
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class SdBasicPrimaryKeyContent extends SdAbstractPrimaryKeyContent {

	@Override
	public String createSQL() {
		StringBuilder sb = new StringBuilder();
		if (getName() != null) {
			sb.append(" CONSTRAINT " + getName() + " PRIMARY KEY (");
		} else {
			sb.append(" PRIMARY KEY (");
		}
		for (int i = 0; i < getColumns().size(); i++) {
			sb.append(getColumns().get(i));
			if (i != getColumns().size() - 1) {
				sb.append(",");
			}
		}
		sb.append(")");
		if (converterExtensions() != null) {
			sb.append(" " + converterExtensions());
		}
		return sb.toString();
	}

	@Override
	public String updateSQL() {
		return " ADD "+ createSQL();
	}

	@Override
	public String deleteSQL() {
		return " DROP CONSTRAINT " + (getName() == null ? "" : getName());
	}

}
