package org.mirrentools.sd.models.db.update.impl.postgresql;

import org.mirrentools.sd.models.db.update.SdAbstractTableContent;

/**
 * 数据库表属性创建或者修改SQL语句的PostgreSQL实现
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class SdTableContentByPostgreSQL extends SdAbstractTableContent {
	/** 默认的模式 */
	public final static String DEFAULT_SCHEMAS = "public";
	/** 模式 */
	private String schemas = DEFAULT_SCHEMAS;

	@Override
	public String createSQL() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("CREATE TABLE %s \"%s\".\"%s\"(", (isIfNotExist() ? " if not exist " : ""), schemas, getTableName()));
		for (int i = 0; i < getColums().size(); i++) {
			sb.append(getColums().get(i).createSQL());
			if (i != getColums().size() - 1) {
				sb.append(",");
			}
		}

		return null;
	}

	@Override
	public String updateSQL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteSQL() {
		return String.format("DROP TABLE \"%s\".\"%s\";", getSchemas(), getTableName());
	}

	/**
	 * 获取模式
	 * 
	 * @return
	 */
	public String getSchemas() {
		return schemas;
	}

	/**
	 * 设置模式
	 * 
	 * @param schemas
	 * @return
	 */
	public SdTableContentByPostgreSQL setSchemas(String schemas) {
		this.schemas = schemas;
		return this;
	}

}
