package org.mirrentools.sd.models.db.update.impl.sqlserver;

import org.mirrentools.sd.models.db.update.SdBasicColumnContent;

/**
 * 数据列属性的SQL Server实现
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public class SdColumnContentBySqlServer extends SdBasicColumnContent {
	@Override
	public String createSQL() {
		StringBuilder sb = new StringBuilder();
		sb.append(getName());
		sb.append(" " + getType());
		if (getLength() != null) {
			sb.append("(" + getLength() + ")");
		}
		if (isIdentity()) {
			sb.append(String.format(" IDENTITY(%d,%d)", (getIdentitySeed() == null ? 1 : getIdentitySeed()), (getIdentityIncrement() == null ? 1 : getIdentityIncrement())));
		}
		if (isNotNull()) {
			sb.append(" NOT NULL");
		}
		if (getDefault() != null) {
			if (getDefault() instanceof Number) {
				sb.append(" DEFAULT " + getDefault());
			} else {
				sb.append(" DEFAULT '" + getDefault() + "'");
			}
		}
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
		return " DROP COLUMN " + getName();
	}
}
