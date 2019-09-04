package org.mirrentools.sd.models.db.update;

/**
 * 序列的基本实现版实现,实际数据库如果操作相同可以继承该类,不同可以选择重写
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class SdBasicSequenceContent extends SdAbstractSequenceContent {

	@Override
	public String createSQL() {
		StringBuilder sb = new StringBuilder();
		sb.append(" CREATE SEQUENCE " + getName());
		if (getDataType() != null) {
			sb.append(" AS " + getDataType());
		}
		if (getIncrementBy() != null) {
			sb.append(" INCREMENT BY " + getIncrementBy());
		}
		if (getMinValue() != null) {
			sb.append(" MINVALUE " + getMinValue());
		} else {
			sb.append(" MINVALUE NO MINVALUE ");
		}
		if (getMaxValue() != null) {
			sb.append(" MAXVALUE " + getMaxValue());
		} else {
			sb.append(" MAXVALUE NO MAXVALUE ");
		}
		if (getStart() != null) {
			sb.append(" START WITH " + getStart());
		}
		if (getCache() != null) {
			sb.append("  CACHE " + getCache());
		} else {
			sb.append("  CACHE NO CYCLE ");
		}
		if (getOwnedBy() != null) {
			sb.append(" OWNED BY " + getOwnedBy());
		}
		return sb.toString();
	}

	@Override
	public String updateSQL() {
		StringBuilder sb = new StringBuilder();
		sb.append("ALTER SEQUENCE " + getName());
		if (getDataType() != null) {
			sb.append(" AS " + getDataType());
		}
		if (getIncrementBy() != null) {
			sb.append(" INCREMENT BY " + getIncrementBy());
		}
		if (getMinValue() != null) {
			sb.append(" MINVALUE " + getMinValue());
		} else {
			sb.append(" MINVALUE NO MINVALUE ");
		}
		if (getMaxValue() != null) {
			sb.append(" MAXVALUE " + getMaxValue());
		} else {
			sb.append(" MAXVALUE NO MAXVALUE ");
		}
		if (getStart() != null) {
			sb.append(" START WITH " + getStart());
		}
		if (getRestart() != null) {
			sb.append(" RESTART WITH " + getRestart());
		}
		if (getCache() != null) {
			sb.append("  CACHE " + getCache());
		} else {
			sb.append("  CACHE NO CYCLE ");
		}
		if (getOwnedBy() != null) {
			sb.append(" OWNED BY " + getOwnedBy());
		}
		return sb.toString();
	}

	@Override
	public String deleteSQL() {
		return String.format("DROP SEQUENCE  IF EXISTS %s", getName());
	}

}
