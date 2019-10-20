package org.mirrentools.sd.models.db.update.impl.oracle;

import org.mirrentools.sd.models.db.update.SdBasicColumnContent;
/**
 * 数据列属性的Oracle实现
 * 
 * @author likk
 *
 */

public class SdColumnContentByOracle  extends SdBasicColumnContent{
	/** 字符排序 */
	private String collate;

	@Override
	public String createSQL() {
		StringBuilder sb = new StringBuilder();
		sb.append("" + getName() + "");
		sb.append(" " + getType());
		if (getLength() != null) {
			sb.append("(" + getLength() + ")");
		}
		if (isNotNull()) {
			sb.append(" NOT NULL");
		}
		if (isPrimary()) {
			sb.append(" PRIMARY KEY");
		}
		if (isAutoIncrement()) {
			sb.append(" GENERATED ALWAYS AS IDENTITY ");
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

	public String getCollate() {
		return collate;
	}
	public SdColumnContentByOracle setCollate(String collate) {
		this.collate = collate;
		return this;
	}


}
