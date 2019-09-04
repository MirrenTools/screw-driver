package org.mirrentools.sd.models.db.update;

/**
 * 数据列属性的基本实现版实现,实际数据库如果操作相同可以继承该类,不同可以选择重写
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public abstract class SdBasicColumnContent extends SdAbstractColumnContent {

	@Override
	public String createSQL() {
		StringBuilder sb = new StringBuilder();
		sb.append(getName());
		sb.append(" " + getType());
		if (getLength() != null) {
			sb.append("(" + getLength() + ")");
		}
		if (isUnsigned()) {
			sb.append(" UNSIGNED");
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
		return " ADD COLUMN " + createSQL();
	}

	@Override
	public String deleteSQL() {
		return " DROP COLUMN IF EXISTS " + getName();
	}

}
