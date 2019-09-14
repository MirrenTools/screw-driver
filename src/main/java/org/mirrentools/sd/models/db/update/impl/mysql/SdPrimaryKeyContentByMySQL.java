package org.mirrentools.sd.models.db.update.impl.mysql;

import org.mirrentools.sd.common.SdUtil;
import org.mirrentools.sd.models.db.update.SdBasicPrimaryKeyContent;

/**
 * 主键属性的MySQL版实现
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class SdPrimaryKeyContentByMySQL extends SdBasicPrimaryKeyContent {

	@Override
	public String createSQL() {
		StringBuilder sb = new StringBuilder();
		sb.append(" PRIMARY KEY (");
		sb.append(SdUtil.join(getColumns(), ","));
		sb.append(")");
		if (converterExtensions() != null) {
			sb.append(" " + converterExtensions());
		}
		return sb.toString();
	}

	@Override
	public String updateSQL() {
		return deleteSQL() + " , ADD " + createSQL();
	}

	@Override
	public String deleteSQL() {
		return " DROP PRIMARY KEY " + (getName() == null ? "" : getName());
	}

}
