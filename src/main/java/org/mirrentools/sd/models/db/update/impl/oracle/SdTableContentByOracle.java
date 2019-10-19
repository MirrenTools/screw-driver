package org.mirrentools.sd.models.db.update.impl.oracle;

import java.util.ArrayList;
import java.util.List;

import org.mirrentools.sd.models.db.update.SdAbstractColumnContent;
import org.mirrentools.sd.models.db.update.SdAbstractForeignKeyContent;
import org.mirrentools.sd.models.db.update.SdAbstractIndexKeyContent;
import org.mirrentools.sd.models.db.update.SdAbstractTableContent;

public class SdTableContentByOracle extends SdAbstractTableContent{
	/**
	 * 数据库表属性创建或者修改SQL语句的Oracle实现
	 * 
	 * @author likk
	 *
	 */
	@Override
	public List<String> createSQL() {
		List<String> result = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		String tbname = (getSchema() == null ? "" : getSchema() + ".")+ getTableName();
		//建表语句以及列注释
		sb.append("CREATE TABLE  " + tbname + "(");
		for (int i = 0; i < getColums().size(); i++) {
			sb.append(getColums().get(i).createSQL());
			if (i != getColums().size() - 1) {
				sb.append(",");
			}
			if (getColums().get(i).getRemark()!= null ) {
				result.add("comment on column "+tbname+"."+getColums().get(i).getName()+" is'" +getColums().get(i).getRemark()+ "'");
			}
		
		}
		sb.append(")");
		result.add(0,sb.toString());
		//创建表注释
		
		if (getRemark()!= null ) {
			result.add("comment on table "+tbname+" is '" +getRemark() +"'");
		}
		//创建索引
		if (getIndexKeys() != null && !getIndexKeys().isEmpty()) {
			for(SdAbstractIndexKeyContent index :getIndexKeys()) {
				result.add(index.createSQL());
			}
		}
		//创建外键
		if (getForeignKeys() != null && !getForeignKeys().isEmpty()) {
			for(SdAbstractForeignKeyContent foreignkey:getForeignKeys()) {
				result.add(foreignkey.createSQL());
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
