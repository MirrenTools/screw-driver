package org.mirrentools.sd.models.db.update.impl.oracle;

import org.mirrentools.sd.common.SdUtil;
import org.mirrentools.sd.models.db.update.SdAbstractPrimaryKeyContent;

public class SdPrimaryKeyContentByOracle extends SdAbstractPrimaryKeyContent {
	@Override
	public String createSQL() {
		return "ALTER TABLE "+getSchema()+"."+getTable() +" ADD constraint "+getName()+" primary key("+	SdUtil.join(getColumns(),",")+")";
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
