package org.mirrentools.sd.models.db.update.impl.oracle;

import org.mirrentools.sd.common.SdUtil;
import org.mirrentools.sd.models.db.update.SdBasicIndexKeyContent;

public class SdIndexKeyContentByOracle extends SdBasicIndexKeyContent {
	@Override
	public String createSQL() {
		return "CREATE INDEX  " + getSchema() + "." + getName() + " ON " + getSchema() + "." + getTable() + "(" + SdUtil.join(getColumns(), ",") + ")";
	}
}
