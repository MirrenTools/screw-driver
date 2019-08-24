package org.mirrentools.sd.models.db.update.impl.mysql;

import org.mirrentools.sd.models.db.update.SdBasicColumnContent;

/**
 * 数据列属性的MySQL实现
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public class SdColumnContentByMySQL extends SdBasicColumnContent {
	/** 字符排序 */
	private String collate;

	@Override
	public String createSQL() {
		StringBuilder sb = new StringBuilder();
		sb.append("`" + getName() + "`");
		sb.append(" " + getType());
		if (getLength() != null) {
			sb.append("(" + getLength() + ")");
		}
		if (getCollate() != null) {
			sb.append(" COLLATE " + getCollate());
		}
		if (isUnsigned()) {
			sb.append(" UNSIGNED");
		}
		if (isNotNull()) {
			sb.append(" NOT NULL");
		}
		if (isAutoIncrement()) {
			sb.append(" AUTO_INCREMENT");
		}
		if (getDefault() != null) {
			if (getDefault() instanceof Number) {
				sb.append(" DEFAULT " + getDefault());
			} else {
				sb.append(" DEFAULT '" + getDefault() + "'");
			}
		}
		if (getRemark() != null) {
			sb.append(" COMMENT '" + getRemark() + "'");
		}
		if (converterExtensions() != null) {
			sb.append(" " + converterExtensions());
		}
		return sb.toString();
	}

	public String getCollate() {
		return collate;
	}
	public SdColumnContentByMySQL setCollate(String collate) {
		this.collate = collate;
		return this;
	}

}
