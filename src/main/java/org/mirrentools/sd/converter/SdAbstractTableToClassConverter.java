package org.mirrentools.sd.converter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.mirrentools.sd.models.SdBean;
import org.mirrentools.sd.models.SdClassContent;
import org.mirrentools.sd.models.SdColumn;
import org.mirrentools.sd.models.db.query.SdTable;
import org.mirrentools.sd.models.db.query.SdTableAttribute;
import org.mirrentools.sd.models.db.query.SdTableColumnAttribute;
import org.mirrentools.sd.models.db.query.SdTableIndexKeyAttribute;
import org.mirrentools.sd.models.db.query.SdTablePortedKeysAttribute;
import org.mirrentools.sd.models.db.query.SdTablePrimaryKeyAttribute;

/**
 * 将SdTable转换为SdClassContent的转换器的抽象实现
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public abstract class SdAbstractTableToClassConverter implements SdTableToClassConverter {
	/**
	 * 将数据库索表中的short引类型转换为字符串索引类型,在读取表信息时一般没有多大的作用,如果需要用到重写即可
	 * 
	 * @param type
	 * @return
	 */
	public String getIndexType(short type) {
		return null;
	};

	@Override
	public SdClassContent converter(SdTable table) {
		return getClassConverter().converter(getSdBean(table));
	}
	/**
	 * 将table转换为SdBean
	 * 
	 * @param table
	 * @return
	 */
	public SdBean getSdBean(SdTable table) {
		SdBean result = new SdBean();
		converterInfo(table, result);
		converterColumns(table, result);
		converterExtension(table, result);
		return result;
	}

	/**
	 * 初始化基本信息
	 * 
	 * @param table
	 * @param result
	 */
	public void converterInfo(SdTable table, SdBean result) {
		SdTableAttribute info = table.getInfo();
		result.setName(info.getTableName());
		result.setRemark(info.getRemarks());
	}

	/**
	 * 转换列属性
	 * 
	 * @param table
	 * @param result
	 */
	public void converterColumns(SdTable table, SdBean result) {
		Map<String, SdColumn> colMaps = new LinkedHashMap<String, SdColumn>();
		for (SdTableColumnAttribute col : table.getColumns()) {
			SdColumn column = new SdColumn();
			column.setName(col.getColumnName());
			column.setType(col.getTypeName());
			column.setLength(col.getColumnSize() == 0 ? null : col.getColumnSize());
			column.setRemark(col.getRemarks());
			column.setNullable(col.isNullable() == 1 ? true : false);
			column.setDefaults(col.getColumnDef());
			column.setAutoIncrement("YES".equals(col.getAutoincrement()));
			column.setOrdinalPosition(col.getOrdinalPosition());
			colMaps.put(col.getColumnName(), column);
		}
		if (table.getPrimaryKey() != null) {
			SdTablePrimaryKeyAttribute primaryKey = table.getPrimaryKey();
			if (colMaps.get(primaryKey.getColumnName()) != null) {
				colMaps.get(primaryKey.getColumnName()).setPrimary(true).setPrimaryName(primaryKey.getPkName());
			}
		}
		if (table.getIndexKeys() != null) {
			for (SdTableIndexKeyAttribute index : table.getIndexKeys()) {
				if (colMaps.get(index.getColumnName()) != null) {
					colMaps.get(index.getColumnName()).setIndexName(index.getIndexName()).setIndexType(getIndexType(index.getType()));
				}
			}
		}
		if (table.getForeignKeys() != null) {
			for (SdTablePortedKeysAttribute foreginkey : table.getForeignKeys()) {
				if (colMaps.get(foreginkey.getFkcolumnName()) != null) {
					colMaps.get(foreginkey.getFkcolumnName()).setForeignConstraint(foreginkey.getFkName())
							.setForeignReferencesDB(foreginkey.getFktableCat()).setForeignReferencesTable(foreginkey.getFktableName())
							.setForeignReferencesColumn(foreginkey.getFkcolumnName());
				}
			}
		}

		List<SdColumn> list = new ArrayList<SdColumn>(colMaps.values());
		Collections.sort(list);
		result.setColumns(list);
	}

	/**
	 * 转换拓展属性
	 * 
	 * @param table
	 * @param result
	 */
	public void converterExtension(SdTable table, SdBean result) {
		result.setExtensions(table.getExtensions());
	}

}
