package org.mirrentools.sd.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;

import org.mirrentools.sd.models.db.update.AbstractDatabaseContent;
import org.mirrentools.sd.options.DatabaseOptions;

/**
 * 数据库操作相关的工具接口的抽象类,默认以MySQL为基准的实现,<br>
 * 如果其他数据库或不兼容可以继承该类并重写相应的方法
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public abstract class AbstractSdDbUtil implements SdDbUtil {
	/** 数据库配置 */
	private DatabaseOptions config;

	/**
	 * 初始化一个默认的数据库管理实现类
	 */
	public AbstractSdDbUtil(DatabaseOptions config) {
		super();
		this.config = config;
	}

	@Override
	public Connection getConnection() throws Exception {
		return getConnection(config);
	}

	@Override
	public Connection getConnection(DatabaseOptions config) throws Exception {
		DriverManager.setLoginTimeout(config.getLoginTimeout());
		Class.forName(config.getDriverClass());
		return DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword());
	}

	@Override
	public boolean createDatabase(AbstractDatabaseContent content) throws Exception {
		int result = 0;
		Connection connection = getConnection();
		try {
			result = connection.createStatement().executeUpdate(content.createSQL());
		} catch (Exception e) {

			throw e;
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
		return result == 1;
	}

	@Override
	public boolean updateDatabase(AbstractDatabaseContent content) throws Exception {
		int result = 0;
		Connection connection = getConnection();
		try {
			result = connection.createStatement().executeUpdate(content.updateSQL());
		} catch (Exception e) {
			throw e;
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
		return result == 1;
	}

}
