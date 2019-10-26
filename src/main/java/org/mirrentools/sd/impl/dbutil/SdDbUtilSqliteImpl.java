package org.mirrentools.sd.impl.dbutil;

import java.io.File;
import java.sql.Connection;

import org.mirrentools.sd.ScrewDriverException;
import org.mirrentools.sd.models.db.update.SdAbstractDatabaseContent;
import org.mirrentools.sd.options.SdDatabaseOptions;

/**
 * 数据库操作相关的工具接口,SQLite的抽象实现,其他数据库或者不兼容可以重写该类
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class SdDbUtilSqliteImpl extends SdAbstractDbUtil {

	/**
	 * 初始化
	 * 
	 * @param options
	 */
	public SdDbUtilSqliteImpl(SdDatabaseOptions options) {
		super(options);
	}

	@Override
	public boolean existDatabase(String dbName) throws Exception {
		return existDatabase(getBaseUrlConfig(), dbName);
	}

	@Override
	public boolean existDatabase(SdDatabaseOptions config, String dbName) throws Exception {
		int index = config.getUrl().indexOf(":", config.getUrl().indexOf(":") + 1) + 1;
		String name = dbName.trim().endsWith(".db") ? dbName.trim() : dbName + ".db";
		String url = config.getUrl().substring(index) + name;
		return new File(url).exists();
	}

	@Override
	public boolean createDatabase(SdAbstractDatabaseContent content) throws Exception {
		return createDatabase(getBaseUrlConfig(), content);
	}

	@Override
	public boolean createDatabase(SdDatabaseOptions config, SdAbstractDatabaseContent content) throws Exception {
		boolean urlHasDb = config.getUrl().trim().endsWith(".db");
		if (!urlHasDb) {
			if (!config.getUrl().trim().endsWith("/")) {
				config.setUrl(config.getUrl().trim() + "/");
			}
			config.setUrl(config.getUrl().trim() + content.getDatabaseName() + ".db");
		}
		Connection connection = null;
		try {
			connection = getConnection(config);
			return true;
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}
	@Override
	public boolean updateDatabase(SdDatabaseOptions config, SdAbstractDatabaseContent content) throws Exception {
		throw new ScrewDriverException("The SQLite DB in ScrewDriver does not support update,you can modify it through the SQLite client ");
	}

}
