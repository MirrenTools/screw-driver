package org.mirrentools.sd.models.db.update.impl.sqlite;

import org.mirrentools.sd.models.db.update.SdAbstractDatabaseContent;

/**
 * SQLite数据库的数据库属性
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public class SdDatabaseContentBySqlite extends SdAbstractDatabaseContent {

	public SdDatabaseContentBySqlite(String databaseName) {
		super(databaseName);
	}

	@Override
	public String createSQL() {
		return "";
	}

	@Override
	public String updateSQL() throws UnsupportedOperationException {
		return "";
	}

	@Override
	public String deleteSQL() {
		return "";
	}

}
