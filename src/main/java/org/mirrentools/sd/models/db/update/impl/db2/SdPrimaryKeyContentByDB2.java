package org.mirrentools.sd.models.db.update.impl.db2;

import org.mirrentools.sd.models.db.update.SdAbstractPrimaryKeyContent;

public class SdPrimaryKeyContentByDB2 extends SdAbstractPrimaryKeyContent {
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
