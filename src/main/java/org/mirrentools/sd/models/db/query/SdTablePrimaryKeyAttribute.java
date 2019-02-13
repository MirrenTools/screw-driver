package org.mirrentools.sd.models.db.query;

/**
 * 表主键属性,用于获取表主键属性
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public class SdTablePrimaryKeyAttribute {
	/** table catalog (may be null) */
	private String tableCat;
	/** table schema (may be null) */
	private String tableSchem;
	/** table name */
	private String tableName;
	/** column name */
	private String columnName;
	/**
	 * sequence number within primary key( a valueof 1 represents the first column
	 * of the primary key, a value of 2 wouldrepresent the second column within
	 * the primary key).
	 */
	private String keySeq;
	/** primary key name (may be null) */
	private String pkName;

	/**
	 * table catalog (may be null)
	 * 
	 * @return
	 */
	public String getTableCat() {
		return tableCat;
	}
	/**
	 * table catalog (may be null)
	 * 
	 * @param tableCat
	 * @return
	 */
	public SdTablePrimaryKeyAttribute setTableCat(String tableCat) {
		this.tableCat = tableCat;
		return this;
	}
	/**
	 * table schema (may be null)
	 * 
	 * @return
	 */
	public String getTableSchem() {
		return tableSchem;
	}
	/**
	 * table schema (may be null)
	 * 
	 * @param tableSchem
	 * @return
	 */
	public SdTablePrimaryKeyAttribute setTableSchem(String tableSchem) {
		this.tableSchem = tableSchem;
		return this;
	}
	/**
	 * table name
	 * 
	 * @return
	 */
	public String getTableName() {
		return tableName;
	}
	/**
	 * table name
	 */
	public SdTablePrimaryKeyAttribute setTableName(String tableName) {
		this.tableName = tableName;
		return this;
	}
	/**
	 * column name
	 * 
	 * @return
	 */
	public String getColumnName() {
		return columnName;
	}
	/**
	 * column name
	 * 
	 * @param columnName
	 * @return
	 */
	public SdTablePrimaryKeyAttribute setColumnName(String columnName) {
		this.columnName = columnName;
		return this;
	}
	/**
	 * sequence number within primary key( a valueof 1 represents the first column
	 * of the primary key, a value of 2 wouldrepresent the second column within
	 * the primary key).
	 * 
	 * @return
	 */
	public String getKeySeq() {
		return keySeq;
	}
	/**
	 * sequence number within primary key( a valueof 1 represents the first column
	 * of the primary key, a value of 2 wouldrepresent the second column within
	 * the primary key).
	 * 
	 * @param keySeq
	 * @return
	 */
	public SdTablePrimaryKeyAttribute setKeySeq(String keySeq) {
		this.keySeq = keySeq;
		return this;
	}
	/**
	 * primary key name (may be null)
	 * 
	 * @return
	 */
	public String getPkName() {
		return pkName;
	}
	/**
	 * primary key name (may be null)
	 * 
	 * @param pkName
	 * @return
	 */
	public SdTablePrimaryKeyAttribute setPkName(String pkName) {
		this.pkName = pkName;
		return this;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("SdTablePrimaryKeyAttribute: \n");
		sb.append("  ┣━tableCat = " + tableCat + "\n");
		sb.append("  ┣━tableSchem = " + tableSchem + "\n");
		sb.append("  ┣━tableName = " + tableName + "\n");
		sb.append("  ┣━columnName = " + columnName + "\n");
		sb.append("  ┣━keySeq = " + keySeq + "\n");
		sb.append("  ┗━pkName = " + pkName + "\n");
		return sb.toString();

	}

}
