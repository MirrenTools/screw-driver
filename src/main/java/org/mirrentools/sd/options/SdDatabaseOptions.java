package org.mirrentools.sd.options;

/**
 * 数据库连接的配置文件
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public class SdDatabaseOptions {
	/** 模式的连接超时时间 */
	public static final int DEFAULT_LOGIN_TIMEOUTS_SECONDS = 3;

	/** 连接超时时间 单位秒 */
	private int loginTimeout = DEFAULT_LOGIN_TIMEOUTS_SECONDS;
	/** 数据库驱动 */
	private String driverClass;
	/** 数据库连接地址 */
	private String url;
	/** 数据库连接用户 */
	private String user;
	/** 数据库连接密码 */
	private String password;
	/**
	 * 初始化一个数据库配置
	 * 
	 * @param driverClass
	 *          驱动类
	 * @param url
	 *          完整的数据库连接地址
	 */
	public SdDatabaseOptions(String driverClass, String url) {
		super();
		this.driverClass = driverClass;
		this.url = url;
	}
	/**
	 * 初始化一个数据库配置
	 * 
	 * @param driverClass
	 *          驱动类
	 * @param url
	 *          完整的数据库连接地址
	 * @param user
	 *          用户名
	 * @param password
	 *          密码
	 */
	public SdDatabaseOptions(String driverClass, String url, String user, String password) {
		super();
		this.driverClass = driverClass;
		this.url = url;
		this.user = user;
		this.password = password;
	}

	/**
	 * 初始化一个数据库配置
	 * 
	 * @param loginTimeout
	 *          请求连接数据库超时时间,单位秒
	 * @param driverClass
	 *          驱动类
	 * @param url
	 *          完整的数据库连接地址
	 * @param user
	 *          用户名
	 * @param password
	 *          密码
	 */
	public SdDatabaseOptions(int loginTimeout, String driverClass, String url, String user, String password) {
		super();
		this.loginTimeout = loginTimeout;
		this.driverClass = driverClass;
		this.url = url;
		this.user = user;
		this.password = password;
	}
	public int getLoginTimeout() {
		return loginTimeout;
	}
	public SdDatabaseOptions setLoginTimeout(int loginTimeout) {
		this.loginTimeout = loginTimeout;
		return this;
	}
	public String getDriverClass() {
		return driverClass;
	}
	public SdDatabaseOptions setDriverClass(String driverClass) {
		this.driverClass = driverClass;
		return this;
	}
	public String getUrl() {
		return url;
	}
	public SdDatabaseOptions setUrl(String url) {
		this.url = url;
		return this;
	}
	public String getUser() {
		return user;
	}
	public SdDatabaseOptions setUser(String user) {
		this.user = user;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public SdDatabaseOptions setPassword(String password) {
		this.password = password;
		return this;
	}
	@Override
	public String toString() {
		return "DatabaseConfig [loginTimeout=" + loginTimeout + ", driverClass=" + driverClass + ", url=" + url + ", user=" + user
				+ ", password=" + password + "]";
	}

}
