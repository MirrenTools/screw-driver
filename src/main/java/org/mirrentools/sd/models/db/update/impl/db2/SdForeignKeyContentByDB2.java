package org.mirrentools.sd.models.db.update.impl.db2;

import org.mirrentools.sd.common.SdUtil;
import org.mirrentools.sd.models.db.update.SdBasicForeignKeyContent;

public class SdForeignKeyContentByDB2 extends SdBasicForeignKeyContent {
	@Override
	public String createSQL() {
		return "ALTER TABLE " + getSchema() + "." + getTable() + " ADD CONSTRAINT " + getConstraint() + "  FOREIGN KEY(" + SdUtil.join(getForeignKeys(), ",") + ") REFERENCES " + getSchema() + "."
				+ getReferencesTable() + "(" + SdUtil.join(getReferencesColumns(), ",") + ")";
	}

	@Override
	public String updateSQL() {
		return deleteSQL() == null ? " ADD " + createSQL() : deleteSQL() + ", ADD " + createSQL();
	}

	@Override
	public String deleteSQL() {
		if (getRemoveConstraint() == null) {
			return null;
		}
		return " DROP CONSTRAINT  " + getRemoveConstraint();
	}

}
