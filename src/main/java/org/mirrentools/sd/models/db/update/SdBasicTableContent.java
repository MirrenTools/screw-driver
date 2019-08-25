package org.mirrentools.sd.models.db.update;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据库表属性创建或者修改SQL语句的基本实现版实现,实际数据库如果操作相同可以继承该类,不同可以选择重写
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public abstract class SdBasicTableContent extends SdAbstractTableContent {

	@Override
	public List<String> createSQL() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("CREATE TABLE %s %s%s(", (isIfNotExist() ? " IF NOT EXIST " : ""), (getSchema() == null ? "" : getSchema() + "."), getTableName()));
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
		result.add(sb.toString());
		return result;
	}

	@Override
	public List<String> updateSQL() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("ALTER TABLE %s%s ", (getSchema() == null ? "" : getSchema() + "."), getTableName()));
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
		if (getForeignKeys() != null && !getForeignKeys().isEmpty()) {
			sb.append(",");
			for (int i = 0; i < getForeignKeys().size(); i++) {
				sb.append(getForeignKeys().get(i).updateSQL());
				if (i != getForeignKeys().size() - 1) {
					sb.append(",");
				}
			}
		}
		if (getConstraints() != null && !getConstraints().isEmpty()) {
			sb.append(",");
			for (int i = 0; i < getConstraints().size(); i++) {
				sb.append(getConstraints().get(i).updateSQL());
				if (i != getConstraints().size() - 1) {
					sb.append(",");
				}
			}
		}
		sb.append(";\n");
		List<String> result = new ArrayList<String>();
		result.add(sb.toString());
		return result;
	}

	@Override
	public String deleteSQL() {
		return " DROP TABLE " + getTableName() + ";";
	}

}
