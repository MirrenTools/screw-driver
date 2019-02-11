package org.mirrentools.sd.models.db.update.impl.mysql;

import org.mirrentools.sd.models.db.update.SdAbstractPrimaryKeyContent;

/**
 * 主键属性的MySQL版实现
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class SdPrimaryKeyContentByMySQL extends SdAbstractPrimaryKeyContent {

	@Override
	public String createSQL() {
		StringBuilder sb = new StringBuilder();
		sb.append(" PRIMARY KEY (");
		for (int i = 0; i < getColumns().size(); i++) {
			sb.append("`" + getColumns().get(i) + "`");
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
		return deleteSQL() + " , " + createSQL();
	}
	@Override
	public String deleteSQL() {
		return " DROP PRIMARY KEY";
	}

}
