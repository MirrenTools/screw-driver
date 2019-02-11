package org.mirrentools.sd.models.db.update.impl.mysql;

import org.mirrentools.sd.models.db.update.SdAbstractForeignKeyContent;

/**
 * 外键属性的MySQL版实现
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class SdForeignKeyContentByMySQL extends SdAbstractForeignKeyContent {

	@Override
	public String createSQL() {
		StringBuilder sb = new StringBuilder();
		sb.append(" CONSTRAINT `" + getConstraint() + "`");

		sb.append(" FOREIGN KEY (");
		for (int i = 0; i < getForeignKeys().size(); i++) {
			sb.append("`" + getForeignKeys().get(i) + "`");
			if (i != getForeignKeys().size() - 1) {
				sb.append(",");
			}
		}
		sb.append(")");

		sb.append(" REFERENCES ");
		if (getReferencesDB() != null) {
			sb.append(" `" + getReferencesDB() + "`.`" + getReferencesTable() + "`");
		} else {
			sb.append(" `" + getReferencesTable() + "`");
		}
		sb.append("(");
		for (int i = 0; i < getReferencesColumns().size(); i++) {
			sb.append("`" + getReferencesColumns().get(i) + "`");
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
		return 
				deleteSQL() == null 
				? " ADD " + createSQL() 
				: deleteSQL() + ", ADD " + createSQL() ;
	}

	@Override
	public String deleteSQL() {
		if (getRemoveConstraint() == null) {
			return null;
		}
		return " DROP FOREIGN KEY `" + getRemoveConstraint() + "`";
	}

}
