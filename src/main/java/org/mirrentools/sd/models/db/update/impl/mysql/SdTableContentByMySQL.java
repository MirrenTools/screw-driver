package org.mirrentools.sd.models.db.update.impl.mysql;

import org.mirrentools.sd.models.db.update.SdAbstractTableContent;

/**
 * 数据库表属性创建或者修改SQL语句的MySQL实现
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public class SdTableContentByMySQL extends SdAbstractTableContent {
	/** 数据库引擎 */
	private String engine;
	/** 字符集 */
	private String charset;
	/** 核对 */
	private String collate;
	/** 自增量 */
	private Integer increment;

	@Override
	public String createSQL() {
		StringBuilder sb = new StringBuilder();
		sb.append("CREATE TABLE `" + getTableName() + "`(");
		for (int i = 0; i < getColums().size(); i++) {
			sb.append(getColums().get(i).createSQL());
			if (i != getColums().size() - 1) {
				sb.append(",");
			}
		}
		if (getPrimaryKey() != null && getPrimaryKey().getColumns() != null && !getPrimaryKey().getColumns().isEmpty()) {
			sb.append(",");
			sb.append(getPrimaryKey().createSQL());
		}
		if (getIndexKeys() != null && !getIndexKeys().isEmpty()) {
			sb.append(",");
			for (int i = 0; i < getIndexKeys().size(); i++) {
				sb.append(getIndexKeys().get(i).createSQL());
				if (i != getIndexKeys().size() - 1) {
					sb.append(",");
				}
			}
		}
		if (getForeignKeys() != null && !getForeignKeys().isEmpty()) {
			sb.append(",");
			for (int i = 0; i < getForeignKeys().size(); i++) {
				sb.append(getForeignKeys().get(i).createSQL());
				if (i != getForeignKeys().size() - 1) {
					sb.append(",");
				}
			}
		}
		sb.append(")");
		if (getEngine() != null) {
			sb.append(" ENGINE=" + getEngine());
		}
		if (getCharset() != null) {
			sb.append(" CHARSET=" + getCharset());
		}
		if (getCollate() != null) {
			sb.append(" COLLATE=" + getCollate());
		}
		if (getIncrement() != null) {
			sb.append(" AUTO_INCREMENT=" + getIncrement());
		}
		if (getRemark() != null) {
			sb.append(" COMMENT='" + getRemark() + "'");
		}
		sb.append(";");
		return sb.toString();
	}

	@Override
	public String updateSQL() {
		StringBuilder sb = new StringBuilder();
		sb.append("ALTER TABLE `" + getTableName() + "`");
		for (int i = 0; i < getColums().size(); i++) {
			sb.append(getColums().get(i).updateSQL());
			if (i != getColums().size() - 1) {
				sb.append(",");
			}
		}
		if (getPrimaryKey() != null && getPrimaryKey().getColumns() != null && !getPrimaryKey().getColumns().isEmpty()) {
			sb.append(",");
			sb.append(getPrimaryKey().updateSQL());
		}
		if (getIndexKeys() != null && !getIndexKeys().isEmpty()) {
			sb.append(",");
			for (int i = 0; i < getIndexKeys().size(); i++) {
				sb.append(getIndexKeys().get(i).updateSQL());
				if (i != getIndexKeys().size() - 1) {
					sb.append(",");
				}
			}
		}
		if (getForeignKeys() != null && !getForeignKeys().isEmpty()) {
			sb.append(",");
			for (int i = 0; i < getForeignKeys().size(); i++) {
				sb.append(getForeignKeys().get(i).updateSQL());
				if (i != getForeignKeys().size() - 1) {
					sb.append(",");
				}
			}
		}
		if (getEngine() != null) {
			sb.append(", ENGINE=" + getEngine());
		}
		if (getCharset() != null) {
			sb.append(", CHARSET=" + getCharset());
		}
		if (getCollate() != null) {
			sb.append(", COLLATE=" + getCollate());
		}
		if (getIncrement() != null) {
			sb.append(", AUTO_INCREMENT=" + getIncrement());
		}
		if (getRemark() != null) {
			sb.append(", COMMENT='" + getRemark() + "'");
		}
		sb.append(";");
		return sb.toString();
	}

	@Override
	public String deleteSQL() {
		return " DROP TABLE `" + getTableName() + "`;";
	}

	/**
	 * 获取数据库引擎
	 * 
	 * @return
	 */
	public String getEngine() {
		return engine;
	}
	/**
	 * 设置数据库引擎
	 * 
	 * @param engine
	 * @return
	 */
	public SdTableContentByMySQL setEngine(String engine) {
		this.engine = engine;
		return this;
	}

	/**
	 * 获取字符集
	 * 
	 * @return
	 */
	public String getCharset() {
		return charset;
	}

	/**
	 * 设置字符集
	 * 
	 * @param charset
	 */
	public SdTableContentByMySQL setCharset(String charset) {
		this.charset = charset;
		return this;
	}

	/**
	 * 获取字符集核对
	 * 
	 * @return
	 */
	public String getCollate() {
		return collate;
	}

	/**
	 * 设置字符集核对
	 * 
	 * @param collate
	 */
	public SdTableContentByMySQL setCollate(String collate) {
		this.collate = collate;
		return this;
	}
	/**
	 * 获取自增量
	 * 
	 * @return
	 */
	public Integer getIncrement() {
		return increment;
	}
	/**
	 * 设置自增量
	 * 
	 * @param increment
	 * @return
	 */
	public SdTableContentByMySQL setIncrement(Integer increment) {
		this.increment = increment;
		return this;
	}

	@Override
	public String toString() {
		return "SdTableContentByMySQL [engine=" + engine + ", charset=" + charset + ", collate=" + collate + "]";
	}

}
