package org.mirrentools.sd.models.db.update.impl.db2;

import java.util.ArrayList;
import java.util.List;

import org.mirrentools.sd.models.db.update.SdAbstractColumnContent;
import org.mirrentools.sd.models.db.update.SdAbstractTableContent;

public class SdTableContentByDB2 extends SdAbstractTableContent{
	/**
	 * 数据库表属性创建或者修改SQL语句的DB2实现
	 * 
	 * @author likk
	 *
	 */
	@Override
	public List<String> createSQL() {
		List<String> result = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		sb.append("CREATE TABLE  " +(getSchema() == null ? "" : getSchema() + ".")+ getTableName() + "(");
		for (int i = 0; i < getColums().size(); i++) {
			sb.append(getColums().get(i).createSQL());
			if (i != getColums().size() - 1) {
				sb.append(",");
			}
		}
		sb.append(");\\n");
		result.add(sb.toString());
		if (getIndexKeys() != null && !getIndexKeys().isEmpty()) {
			for (int i = 0; i < getIndexKeys().size(); i++) {
				result.add(getIndexKeys().get(i).createSQL());
			}
		}
		if (getForeignKeys() != null && !getForeignKeys().isEmpty()) {
			sb.append(",");
			for (int i = 0; i < getForeignKeys().size(); i++) {
				result.add(getForeignKeys().get(i).createSQL());
			}
		}
		
		return result;
	}

	@Override
	public List<String>  updateSQL() {
		List<String> result = new ArrayList<String>();
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
		return result;
	}

	@Override
	public String deleteSQL() {
		return " DROP TABLE `" + getTableName() + "`;";
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

	@Override
	public String toString() {
		return "SdTableContentByDB2 []";
	}

}
