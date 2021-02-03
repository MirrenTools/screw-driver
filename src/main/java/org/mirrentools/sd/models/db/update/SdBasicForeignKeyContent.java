package org.mirrentools.sd.models.db.update;

/**
 * 外键属性的基本实现版实现,实际数据库如果操作相同可以继承该类,不同可以选择重写
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class SdBasicForeignKeyContent extends SdAbstractForeignKeyContent {

	@Override
	public String createSQL() {
		StringBuilder sb = new StringBuilder();
		if (getConstraint() != null) {
			sb.append(" CONSTRAINT " + getConstraint());
		}
		sb.append(" FOREIGN KEY (");
		for (int i = 0; i < getForeignKeys().size(); i++) {
			sb.append(getForeignKeys().get(i));
			if (i != getForeignKeys().size() - 1) {
				sb.append(",");
			}
		}
		sb.append(")");

		sb.append(" REFERENCES ");
		if (getReferencesDB() != null) {
			sb.append(" " + getReferencesDB() + "." + getReferencesTable());
		} else {
			sb.append(" " + getReferencesTable());
		}
		sb.append("(");
		for (int i = 0; i < getReferencesColumns().size(); i++) {
			sb.append(" " + getReferencesColumns().get(i));
			if (i != getReferencesColumns().size() - 1) {
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
		return " ADD " + createSQL();
	}

	@Override
	public String deleteSQL() {
		if (getRemoveConstraint() == null) {
			return null;
		}
		return " DROP CONSTRAINT  IF EXISTS  " + getRemoveConstraint();
	}

}
