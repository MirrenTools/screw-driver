package org.mirrentools.sd.models.db.update.impl.postgresql;

import org.mirrentools.sd.common.SdUtil;
import org.mirrentools.sd.models.db.update.SdAbstractColumnContent;
import org.mirrentools.sd.models.db.update.SdAbstractIndexKeyContent;
import org.mirrentools.sd.models.db.update.SdBasicTableContent;

/**
 * 数据库表属性创建或者修改SQL语句的PostgreSQL实现
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 */
public class SdTableContentByPostgreSQL extends SdBasicTableContent {
	/** 默认的模式 */
	public final static String DEFAULT_SCHEMAS = "public";
	/** 字符排序 */
	private String collate;

	/**
	 * 初始化一个public模式的示例
	 */
	public SdTableContentByPostgreSQL() {
		super.setSchema(DEFAULT_SCHEMAS);
	}

	/**
	 * 初始化一个自定义模式的示例
	 * 
	 * @param schemas
	 */
	public SdTableContentByPostgreSQL(String schemas) {
		super.setSchema(schemas);
	}

	@Override
	public String createSQL() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.createSQL().replace("UNSIGNED", ""));
		// 添加表的注释
		if (!SdUtil.isNullOrEmpty(getRemark())) {
			sb.append(createTableComment());
		}
		// 添加列的注释
		for (int i = 0; i < getColums().size(); i++) {
			if (!SdUtil.isNullOrEmpty(getColums().get(i).getRemark())) {
				sb.append(createColumnComment(getColums().get(i)));
			}
		}
		// 创建索引以及索引的注释
		if (getIndexKeys() != null && !getIndexKeys().isEmpty()) {
			for (int i = 0; i < getIndexKeys().size(); i++) {
				sb.append(createIndex(getIndexKeys().get(i)));
			}
		}
		return sb.toString();
	}

	@Override
	public String updateSQL() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.updateSQL().replace("UNSIGNED", ""));
		// 添加表的注释
		if (!SdUtil.isNullOrEmpty(getRemark())) {
			sb.append(createTableComment());
		}
		// 添加列的注释
		for (int i = 0; i < getColums().size(); i++) {
			if (!SdUtil.isNullOrEmpty(getColums().get(i).getRemark())) {
				sb.append(createColumnComment(getColums().get(i)));
			}
		}
		// 创建索引以及索引的注释
		if (getIndexKeys() != null && !getIndexKeys().isEmpty()) {
			for (int i = 0; i < getIndexKeys().size(); i++) {
				sb.append(String.format(" DROP INDEX IF EXISTS %s.%s;", getSchema(), getIndexKeys().get(i).getName()));
				sb.append(createIndex(getIndexKeys().get(i)));
			}
		}
		return sb.toString();
	}

	@Override
	public String deleteSQL() {
		return String.format(" DROP TABLE '%s'.'%s';", getSchema(), getTableName());
	}

	/**
	 * 创建表的注释
	 * 
	 * @return
	 */
	public String createTableComment() {
		return String.format(" COMMENT ON TABLE %s.%s IS '%s';\n", getSchema(), getTableName(), getRemark());
	}

	/**
	 * 创建表中列的注释注释
	 * 
	 * @param column
	 * @return
	 */
	public String createColumnComment(SdAbstractColumnContent column) {
		return String.format(" COMMENT ON COLUMN %s.%s.%s IS '%s';\n", getSchema(), getTableName(), column.getName(), column.getRemark());
	}

	/**
	 * 创建索引
	 * 
	 * @param index
	 * @return
	 */
	public String createIndex(SdAbstractIndexKeyContent index) {
		StringBuilder sb = new StringBuilder();
		sb.append(" CREATE ");
		if (index.isUnique()) {
			sb.append(" UNIQUE ");
		}
		sb.append(" INDEX ");
		if (index.isConcurrently()) {
			sb.append(" CONCURRENTLY ");
		}
		sb.append(String.format(" %s ON %s.%s USING %s ", index.getName(), getSchema(), getTableName(), index.getType()));
		sb.append(" (");
		for (int i = 0; i < index.getColumns().size(); i++) {
			sb.append("'" + index.getColumns().get(i) + "'");
			if (i != index.getColumns().size() - 1) {
				sb.append(",");
			}
		}
		sb.append(")");
		if (converterExtensions() != null) {
			sb.append(" " + converterExtensions());
		}
		sb.append(";\n");
		if (index.getRemark() != null) {
			sb.append(String.format(" COMMENT ON INDEX %s.%s IS '%s';\n", getSchema(), index.getName(), index.getRemark()));
		}
		return sb.toString();
	}

	/**
	 * 获取排序
	 * 
	 * @return
	 */
	public String getCollate() {
		return collate;
	}

	/**
	 * 设置排序
	 * 
	 * @param collate
	 * @return
	 */
	public SdTableContentByPostgreSQL setCollate(String collate) {
		this.collate = collate;
		return this;
	}

}
