package org.mirrentools.sd.models.db.update.impl.sqlite;

import java.util.ArrayList;
import java.util.List;

import org.mirrentools.sd.models.db.update.SdAbstractColumnContent;
import org.mirrentools.sd.models.db.update.SdBasicTableContent;

/**
 * 数据库表属性创建或者修改SQL语句的SQLite实现
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 */
public class SdTableContentBySqlite extends SdBasicTableContent {

	@Override
	public List<String> createSQL() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("CREATE TABLE %s %s(", (isIfNotExist() ? " IF NOT EXIST " : ""), getTableName()));

		if (getPrimaryKey() != null && getPrimaryKey().getColumns() != null && getPrimaryKey().getColumns().size() > 1) {
			// 添加多个主键
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
		} else {
			// 添加单个主键
			for (int i = 0; i < getColums().size(); i++) {
				sb.append(getColumnSQL(getColums().get(i)));
				if (i != getColums().size() - 1) {
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
		if (getConstraints() != null && !getConstraints().isEmpty()) {
			sb.append(",");
			for (int i = 0; i < getConstraints().size(); i++) {
				sb.append(getConstraints().get(i).createSQL());
				if (i != getConstraints().size() - 1) {
					sb.append(",");
				}
			}
		}
		sb.append(");\n");
		List<String> result = new ArrayList<String>();
		// 添加创建表的语句
		result.add(sb.toString());
		// 添加创建索引的语句
		if (getIndexKeys() != null && !getIndexKeys().isEmpty()) {
			for (int i = 0; i < getIndexKeys().size(); i++) {
				result.add(getIndexKeys().get(i).createSQL());
			}
		}
		return result;
	}

	@Override
	public List<String> updateSQL() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("ALTER TABLE %s(", getTableName()));
		if (getPrimaryKey() != null && getPrimaryKey().getColumns() != null && getPrimaryKey().getColumns().size() > 1) {
			// 添加多个主键
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
		} else {
			// 添加单个主键
			for (int i = 0; i < getColums().size(); i++) {
				sb.append(getColumnSQL(getColums().get(i)));
				if (i != getColums().size() - 1) {
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
		if (getConstraints() != null && !getConstraints().isEmpty()) {
			sb.append(",");
			for (int i = 0; i < getConstraints().size(); i++) {
				sb.append(getConstraints().get(i).createSQL());
				if (i != getConstraints().size() - 1) {
					sb.append(",");
				}
			}
		}
		sb.append(");\n");
		List<String> result = new ArrayList<String>();
		// 添加创建表的语句
		result.add(sb.toString());
		// 添加创建索引的语句
		if (getIndexKeys() != null && !getIndexKeys().isEmpty()) {
			for (int i = 0; i < getIndexKeys().size(); i++) {
				result.add(getIndexKeys().get(i).createSQL());
			}
		}
		return result;

	}

	/**
	 * 获取列的SQL
	 * 
	 * @param col
	 * @return
	 */
	private String getColumnSQL(SdAbstractColumnContent col) {
		StringBuilder sb = new StringBuilder();
		sb.append(col.getName());
		sb.append(" " + col.getType());
		if (col.getLength() != null) {
			sb.append("(" + col.getLength() + ") ");
		}
		if (col.isPrimary()) {
			sb.append(" PRIMARY KEY ");
		}
		if (col.isAutoIncrement() && "INTEGER".equalsIgnoreCase(col.getType())) {
			sb.append(" AUTOINCREMENT ");
		}
		if (col.isNotNull()) {
			sb.append(" NOT NULL ");
		}
		if (col.getDefault() != null) {
			if (col.getDefault() instanceof Number) {
				sb.append(" DEFAULT " + col.getDefault());
			} else {
				sb.append(" DEFAULT '" + col.getDefault() + "'");
			}
		}
		if (converterExtensions() != null) {
			sb.append(" " + converterExtensions());
		}
		return sb.toString();
	}

}
