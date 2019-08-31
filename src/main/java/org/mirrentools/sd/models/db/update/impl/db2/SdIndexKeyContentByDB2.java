package org.mirrentools.sd.models.db.update.impl.db2;

import org.apache.commons.lang.StringUtils;
import org.mirrentools.sd.models.db.update.SdBasicIndexKeyContent;

public class SdIndexKeyContentByDB2  extends SdBasicIndexKeyContent{
	@Override
	public String createSQL() {
		return "CREATE INDEX  "+ getSchema() + "."+getName() + " ON " + getSchema() + "." + getTable()+"("+
	StringUtils.join(getColumns(),",")
				+")";
	}
}
