package org.mirrentools.sd.models.db.update;

import org.mirrentools.sd.models.db.update.SdAbstractConstraintContent;

/**
 * 约束的基本实现版实现,实际数据库如果操作相同可以继承该类,不同可以选择重写
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class SdBasicConstraintContent extends SdAbstractConstraintContent {

	@Override
	public String createSQL() {
		return String.format(" CONSTRAINT %s %s (%s) ", getName(), getType(), getExp());
	}

	@Override
	public String updateSQL() {
		return " ADD " + createSQL();
	}

	@Override
	public String deleteSQL() {
		if (getRemoveConstraint() == null) {
			return null;
		}
		return String.format(" DROP CONSTRAINT  IF EXISTS  " + getRemoveConstraint());
	}

	@Override
	public String getType() {
		return super.getType() == null ? "" : super.getType();
	}

	@Override
	public String getName() {
		return super.getName() == null ? "" : super.getName();
	}

	@Override
	public String getExp() {
		return super.getExp() == null ? "" : super.getExp();
	}

}
