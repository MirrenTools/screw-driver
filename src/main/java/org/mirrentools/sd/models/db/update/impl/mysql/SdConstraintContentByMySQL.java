package org.mirrentools.sd.models.db.update.impl.mysql;

import org.mirrentools.sd.models.db.update.SdAbstractConstraintContent;

/**
 * 外键属性的MySQL版实现
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class SdConstraintContentByMySQL extends SdAbstractConstraintContent {

	@Override
	public String createSQL() {
		return String.format(" CONSTRAINT %s %s (%s) ", getName(), getType(), getExp());
	}

	@Override
	public String updateSQL() {
		return 
				deleteSQL() == null 
				? " ADD " + createSQL() 
				: deleteSQL() + ", ADD " + createSQL() ;
	}

	@Override
	public String deleteSQL() {
		if (getRemoveConstraint() == null) {
			return null;
		}
		return String.format(" DROP %s %s", getType(), getName());
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
