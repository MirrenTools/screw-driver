package org.mirrentools.sd.models.db.update.impl.sqlserver;

import java.util.List;

import org.mirrentools.sd.common.SdUtil;
import org.mirrentools.sd.models.db.update.SdAbstractColumnContent;
import org.mirrentools.sd.models.db.update.SdBasicTableContent;

/**
 * 数据库表属性创建或者修改SQL语句的SQL Server实现
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 */
public class SdTableContentBySqlServer extends SdBasicTableContent {

	@Override
	public List<String> createSQL() {
		List<String> result = super.createSQL();
		// 添加表说明
		if (!SdUtil.isNullOrEmpty(getRemark())) {
			result.add(getTableRemarks());
		}
		// 添加列说明
		for (int i = 0; i < getColums().size(); i++) {
			SdAbstractColumnContent col = getColums().get(i);
			if (!SdUtil.isNullOrEmpty(col.getRemark())) {
				result.add(getColomnRemarks(col.getName(), col.getRemark()));
			}
		}
		return result;
	}

	@Override
	public String deleteSQL() {
		return " DROP TABLE " + getTableName() + ";";
	}

	/**
	 * 获取表的注释
	 * 
	 * @return
	 */
	private String getTableRemarks() {
		StringBuilder result = new StringBuilder();
		result.append(" EXEC sp_addextendedproperty ");
		result.append(String.format("@name = N'MS_Description', @value = '%s',", getRemark()));
		result.append(String.format("@level0type = N'Schema', @level0name = '%s',", (getSchema() == null ? "dbo" : getSchema())));
		result.append(String.format("@level1type = N'Table', @level1name = '%s';", getTableName()));
		return result.toString();
	}

	/**
	 * 获取列注释
	 * 
	 * @param colName
	 *          列名
	 * @param remark
	 *          注释
	 * @return
	 */
	private String getColomnRemarks(String colName, String remark) {
		StringBuilder result = new StringBuilder();
		result.append(" EXEC sp_addextendedproperty ");
		result.append(String.format("@name = N'MS_Description', @value = '%s',", remark));
		result.append(String.format("@level0type = N'Schema', @level0name = '%s',", (getSchema() == null ? "dbo" : getSchema())));
		result.append(String.format("@level1type = N'Table', @level1name = '%s',", getTableName()));
		result.append(String.format("@level2type = N'Column', @level2name = '%s';", colName));
		return result.toString();
	}

}
