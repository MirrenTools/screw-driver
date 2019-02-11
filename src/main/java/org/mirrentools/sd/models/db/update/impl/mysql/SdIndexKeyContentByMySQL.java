package org.mirrentools.sd.models.db.update.impl.mysql;

import org.mirrentools.sd.models.db.update.SdAbstractIndexKeyContent;

/**
 * 索引属性MySQL版实现
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class SdIndexKeyContentByMySQL extends SdAbstractIndexKeyContent {

	@Override
	public String createSQL() {
		StringBuilder sb = new StringBuilder();
		sb.append(" " + getType());
		sb.append(" `" + getName() + "`");
		sb.append(" (");
		for (int i = 0; i < getColumns().size(); i++) {
			sb.append("`" + getColumns().get(i) + "`");
			if (i != getColumns().size() - 1) {
				sb.append(",");
			}
		}
		sb.append(")");
		if (converterExtensions() != null) {
			sb.append(" " + converterExtensions());
		}
		return sb.toString();
	}

	@Override
	public String updateSQL() {
		return 
				deleteSQL() == null 
				? " ADD " + createSQL() 
				: deleteSQL() + " , ADD " + createSQL();
	}

	@Override
	public String deleteSQL() {
		if (getRemoveIndexName() == null) {
			return null;
		}
		return " DROP INDEX " + getRemoveIndexName();
	}

}
