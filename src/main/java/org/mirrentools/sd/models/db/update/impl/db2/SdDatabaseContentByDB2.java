package org.mirrentools.sd.models.db.update.impl.db2;

import org.mirrentools.sd.models.db.update.SdAbstractDatabaseContent;

public class SdDatabaseContentByDB2 extends SdAbstractDatabaseContent{
	/** 新的数据库名称 */
	private String newDatabaseName;
	/** 用户的角色名 */
	private String userName;
	/** 数据库的模板名称 */
	private String template;
	/** 字符集编码 */
	private String encoding;
	/** 排序规则顺序 */
	private String collate;
	/** 数据库中使用的字符分类 */
	private String ctype;
	/** 数据库相关联的表空间名称 */
	private String tablespaceName;
	/** 如果为假，则没有人能连接到这个数据库。默认为真，表示允许连接（除了被其他机制约束以外，例如GRANT/REVOKE CONNECT） */
	private String allowconn;
	/** 这个数据库允许多少并发连接。-1（默认值）表示没有限制。 */
	private String connlimit;
	/** 如果为真，则任何具有CREATEDB特权的用户都可以从这个数据库克隆。如果为假（默认），则只有超级用户或者该数据库的拥有者可以克隆它。 */
	private String istemplate;

	/**
	 * 初始化一个数据库SQL类
	 * 
	 * @param databaseName
	 *          数据库的名字
	 */
	public SdDatabaseContentByDB2(String databaseName) {
		super(databaseName);
	}

	@Override
	public String createSQL() {
		StringBuilder sb = new StringBuilder("CREATE DATABASE ");
		sb.append(getDatabaseName());
		if (getUserName() != null) {
			sb.append(" OWNER = " + getUserName());
		}
		if (getTemplate() != null) {
			sb.append(" TEMPLATE = " + getTemplate());
		}
		if (getEncoding() != null) {
			sb.append(" ENCODING = " + getEncoding());
		}
		if (getCollate() != null) {
			sb.append(" LC_COLLATE = " + getCollate());
		}
		if (getCtype() != null) {
			sb.append(" LC_CTYPE = " + getCtype());
		}
		if (getTablespaceName() != null) {
			sb.append(" TABLESPACE = " + getTablespaceName());
		}
		if (getAllowconn() != null) {
			sb.append(" ALLOW_CONNECTIONS = " + getAllowconn());
		}
		if (getConnlimit() != null) {
			sb.append(" CONNECTION LIMIT = " + getConnlimit());
		}
		if (getIstemplate() != null) {
			sb.append(" IS_TEMPLATE = " + getIstemplate());
		}

		sb.append(";");
		return sb.toString();
	}

	@Override
	public String updateSQL() throws UnsupportedOperationException {
		StringBuilder sb = new StringBuilder(" ALTER DATABASE ");
		sb.append(getDatabaseName());
		if (getAllowconn() != null) {
			sb.append(" ALLOW_CONNECTIONS = " + getAllowconn());
		}
		if (getConnlimit() != null) {
			sb.append(" CONNECTION LIMIT = " + getConnlimit());
		}
		if (getIstemplate() != null) {
			sb.append(" IS_TEMPLATE = " + getIstemplate());
		}
		if (getAllowconn() != null && getConnlimit() != null && getIstemplate() != null) {
			sb.append(";");
		}
		if (getNewDatabaseName() != null) {
			sb.append(" ALTER DATABASE ");
			sb.append(getDatabaseName());
			sb.append(" RENAME TO ");
			sb.append(getNewDatabaseName());
			sb.append(";");
		}
		if (getUserName() != null) {
			sb.append(" ALTER DATABASE ");
			sb.append(getDatabaseName());
			sb.append(" OWNER TO ");
			sb.append(getUserName());
			sb.append(";");
		}
		if (getTablespaceName() != null) {
			sb.append(" ALTER DATABASE ");
			sb.append(getDatabaseName());
			sb.append(" SET TABLESPACE ");
			sb.append(getTablespaceName());
			sb.append(";");
		}
		return sb.toString();
	}

	@Override
	public String deleteSQL() {
		return "DROP DATABASE " + getDatabaseName();
	}

	/**
	 * 获取新的数据库名称
	 * 
	 * @return
	 */
	public String getNewDatabaseName() {
		return newDatabaseName;
	}

	/**
	 * 设置新的数据库名称
	 * 
	 * @param newDatabaseName
	 * @return
	 */
	public SdDatabaseContentByDB2 setNewDatabaseName(String newDatabaseName) {
		this.newDatabaseName = newDatabaseName;
		return this;
	}

	/**
	 * 获取将拥有该数据库的用户的角色名
	 * 
	 * @return
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 设置将拥有该数据库的用户的角色名
	 * 
	 * @param userName
	 * @return
	 */
	public SdDatabaseContentByDB2 setUserName(String userName) {
		this.userName = userName;
		return this;
	}

	/**
	 * 获取要从其创建新数据库的模板名称
	 * 
	 * @return
	 */
	public String getTemplate() {
		return template;
	}

	/**
	 * 设置要从其创建新数据库的模板名称
	 * 
	 * @param template
	 * @return
	 */
	public SdDatabaseContentByDB2 setTemplate(String template) {
		this.template = template;
		return this;
	}

	/**
	 * 获取使用的字符集编码。
	 * 
	 * @return
	 */
	public String getEncoding() {
		return encoding;
	}

	/**
	 * 设置使用的字符集编码。
	 * 
	 * @param encoding
	 * @return
	 */
	public SdDatabaseContentByDB2 setEncoding(String encoding) {
		this.encoding = encoding;
		return this;
	}

	/**
	 * 获取使用的排序规则顺序
	 * 
	 * @return
	 */
	public String getCollate() {
		return collate;
	}

	/**
	 * 设置使用的排序规则顺序
	 * 
	 * @param collate
	 * @return
	 */
	public SdDatabaseContentByDB2 setCollate(String collate) {
		this.collate = collate;
		return this;
	}

	/**
	 * 获取数据库相关联的表空间名称
	 * 
	 * @return
	 */
	public String getTablespaceName() {
		return tablespaceName;
	}

	/**
	 * 设置数据库相关联的表空间名称
	 * 
	 * @param tablespaceName
	 * @return
	 */
	public SdDatabaseContentByDB2 setTablespaceName(String tablespaceName) {
		this.tablespaceName = tablespaceName;
		return this;
	}

	/**
	 * 获取要在新数据库中使用的字符分类（LC_CTYPE）。这会影响字符的类别，如小写、大写和数字。默认是使用模板数据库的字符分类。附加限制见下文。
	 * 
	 * @return
	 */
	public String getCtype() {
		return ctype;
	}

	/**
	 * 设置要在新数据库中使用的字符分类（LC_CTYPE）。这会影响字符的类别，如小写、大写和数字。默认是使用模板数据库的字符分类。附加限制见下文。
	 * 
	 * @param ctype
	 * @return
	 */
	public SdDatabaseContentByDB2 setCtype(String ctype) {
		this.ctype = ctype;
		return this;
	}

	/**
	 * 获取如果为假，则没有人能连接到这个数据库。默认为真，表示允许连接（除了被其他机制约束以外，例如GRANT/REVOKE CONNECT）。
	 * 
	 * @return
	 */
	public String getAllowconn() {
		return allowconn;
	}

	/**
	 * 设置如果为假，则没有人能连接到这个数据库。默认为真，表示允许连接（除了被其他机制约束以外，例如GRANT/REVOKE CONNECT）。
	 * 
	 * @param allowconn
	 * @return
	 */
	public SdDatabaseContentByDB2 setAllowconn(String allowconn) {
		this.allowconn = allowconn;
		return this;
	}

	/**
	 * 获取这个数据库允许多少并发连接。-1（默认值）表示没有限制。
	 * 
	 * @return
	 */
	public String getConnlimit() {
		return connlimit;
	}

	/**
	 * 设置这个数据库允许多少并发连接。-1（默认值）表示没有限制。
	 * 
	 * @param connlimit
	 * @return
	 */
	public SdDatabaseContentByDB2 setConnlimit(String connlimit) {
		this.connlimit = connlimit;
		return this;
	}

	/**
	 * 获取如果为真，则任何具有CREATEDB特权的用户都可以从这个数据库克隆。如果为假（默认），则只有超级用户或者该数据库的拥有者可以克隆它。
	 * 
	 * @return
	 */
	public String getIstemplate() {
		return istemplate;
	}

	/**
	 * 设置如果为真，则任何具有CREATEDB特权的用户都可以从这个数据库克隆。如果为假（默认），则只有超级用户或者该数据库的拥有者可以克隆它。
	 * 
	 * @param istemplate
	 * @return
	 */
	public SdDatabaseContentByDB2 setIstemplate(String istemplate) {
		this.istemplate = istemplate;
		return this;
	}


}
