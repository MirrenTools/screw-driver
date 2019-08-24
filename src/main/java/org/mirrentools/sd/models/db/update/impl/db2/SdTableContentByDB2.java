package org.mirrentools.sd.models.db.update.impl.db2;

import org.mirrentools.sd.models.db.update.SdAbstractTableContent;

public class SdTableContentByDB2 extends SdAbstractTableContent{
	/**
	 * 数据库表属性创建或者修改SQL语句的DB2实现
	 * 
	 * @author likk
	 *
	 */
	@Override
	public String createSQL() {
		StringBuilder sb = new StringBuilder();
		sb.append("CREATE TABLE " + getTableName() + "(");
		for (int i = 0; i < getColums().size(); i++) {
			sb.append(getColums().get(i).createSQL());
			if (i != getColums().size() - 1) {
				sb.append(",");
			}
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



	@Override
	public String toString() {
		return "SdTableContentByDB2 []";
	}

}
