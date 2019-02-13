package org.mirrentools.sd.models.db.query;

/**
 * 表的列属性,用于获取表列的属性,该类对应 java.sql.DatabaseMetaData.getColumns
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public class SdTableColumnAttribute implements Comparable<SdTableColumnAttribute> {
	// ====================================================
	// *******************常用属性***************************
	// ====================================================

	/** column name */
	private String columnName;
	/**
	 * Data source dependent type name, for a UDT the type name is fully qualified
	 */
	private String typeName;
	/**
	 * default value for the column, which should be interpreted as a string when
	 * the value is enclosed in single quotes (may be null)
	 */
	private String columnDef;
	/** column size */
	private int columnSize;
	/** comment describing column (may be null) */
	private String remarks;
	/**
	 * the number of fractional digits. Null is returned for data types
	 * whereDECIMAL_DIGITS is not applicable.
	 */
	private int decimalDigits;
	/**
	 * is NULL allowed. <br>
	 * columnNoNulls - might not allow NULL values<br>
	 * columnNullable = 1 - definitely allows NULL values<br>
	 * columnNullableUnknown - nullability unknown
	 */
	private int nullable;
	/**
	 * ISO rules are used to determine the nullability for a column. <br>
	 * YES --- if the column can include NULLs <br>
	 * NO --- if the column cannot include NULLs <br>
	 * empty string --- if the nullability for thecolumn is unknown
	 */
	private String isNullable;
	/** index of column in table(starting at 1) */
	private int ordinalPosition;
	/**
	 * Indicates whether this column is auto incremented<br>
	 * YES --- if the column is auto incremented<br>
	 * NO --- if the column is not auto incremented<br>
	 * empty string --- if it cannot be determined whether the column is auto
	 * incremented
	 */
	private String autoincrement;

	// ====================================================
	// *******************不常用属性**************************
	// ====================================================

	/** table catalog (may be null) */
	private String tableCat;
	/** table schema (may be null) */
	private String tableSchem;
	/** table name */
	private String tableName;
	/** SQL type from java.sql.Types */
	private int dataType;
	/** Radix (typically either 10 or 2) */
	private int numPrecRadix;
	/** for char types themaximum number of bytes in the column */
	private int charOctetLength;
	/**
	 * catalog of table that is the scopeof a reference attribute (null if
	 * DATA_TYPE isn't REF)
	 */
	private String scopeCatalog;
	/**
	 * schema of table that is the scopeof a reference attribute (null if the
	 * DATA_TYPE isn't REF)
	 */
	private String scopeSchema;
	/**
	 * table name that this the scopeof a reference attribute (null if the
	 * DATA_TYPE isn't REF)
	 */
	private String scopeTable;
	/**
	 * source type of a distinct type or user-generatedRef type, SQL type from
	 * java.sql.Types (null if DATA_TYPEisn't DISTINCT or user-generated REF)
	 */
	private short sourceDataType;
	/**
	 * Indicates whether this is a generated column<br>
	 * YES --- if this a generated column<br>
	 * NO --- if this not a generated column<br>
	 * empty string --- if it cannot be determined whether this is a generated
	 * column
	 */
	private String generatedcolumn;

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
	public SdTableColumnAttribute setColumnName(String columnName) {
		this.columnName = columnName;
		return this;
	}

	/**
	 * Data source dependent type name, for a UDT the type name is fully qualified
	 * 
	 * @return
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * Data source dependent type name, for a UDT the type name is fully qualified
	 * 
	 * @param typeName
	 * @return
	 */
	public SdTableColumnAttribute setTypeName(String typeName) {
		this.typeName = typeName;
		return this;
	}

	/**
	 * default value for the column, which should be interpreted as a string when
	 * the value is enclosed in single quotes (may be null)
	 * 
	 * @return
	 */
	public String getColumnDef() {
		return columnDef;
	}

	/**
	 * default value for the column, which should be interpreted as a string when
	 * the value is enclosed in single quotes (may be null)
	 * 
	 * @param columnDef
	 * @return
	 */
	public SdTableColumnAttribute setColumnDef(String columnDef) {
		this.columnDef = columnDef;
		return this;
	}

	/**
	 * column size
	 * 
	 * @return
	 */
	public int getColumnSize() {
		return columnSize;
	}

	/**
	 * column size
	 * 
	 * @param columnSize
	 * @return
	 */
	public SdTableColumnAttribute setColumnSize(int columnSize) {
		this.columnSize = columnSize;
		return this;
	}

	/**
	 * comment describing column (may be null)
	 * 
	 * @return
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * comment describing column (may be null)
	 * 
	 * @param remarks
	 * @return
	 */
	public SdTableColumnAttribute setRemarks(String remarks) {
		this.remarks = remarks;
		return this;
	}

	/**
	 * the number of fractional digits. Null is returned for data types
	 * whereDECIMAL_DIGITS is not applicable.
	 * 
	 * @return
	 */
	public int getDecimalDigits() {
		return decimalDigits;
	}

	/**
	 * the number of fractional digits. Null is returned for data types
	 * whereDECIMAL_DIGITS is not applicable.
	 * 
	 * @param decimalDigits
	 * @return
	 */
	public SdTableColumnAttribute setDecimalDigits(int decimalDigits) {
		this.decimalDigits = decimalDigits;
		return this;
	}

	/**
	 * is NULL allowed. <br>
	 * columnNoNulls - might not allow NULL values<br>
	 * columnNullable = 1 - definitely allows NULL values<br>
	 * columnNullableUnknown - nullability unknown
	 * 
	 * @return
	 */
	public int isNullable() {
		return nullable;
	}

	/**
	 * is NULL allowed. <br>
	 * columnNoNulls - might not allow NULL values<br>
	 * columnNullable = 1 - definitely allows NULL values<br>
	 * columnNullableUnknown - nullability unknown
	 * 
	 * @param nullable
	 * @return
	 */
	public SdTableColumnAttribute setNullable(int nullable) {
		this.nullable = nullable;
		return this;
	}

	/**
	 * index of column in table(starting at 1)
	 * 
	 * @return
	 */
	public int getOrdinalPosition() {
		return ordinalPosition;
	}

	/**
	 * index of column in table(starting at 1)
	 * 
	 * @param ordinalPosition
	 * @return
	 */
	public SdTableColumnAttribute setOrdinalPosition(int ordinalPosition) {
		this.ordinalPosition = ordinalPosition;
		return this;
	}

	/**
	 * Indicates whether this column is auto incremented<br>
	 * YES --- if the column is auto incremented<br>
	 * NO --- if the column is not auto incremented<br>
	 * empty string --- if it cannot be determined whether the column is auto
	 * incremented
	 * 
	 * @return
	 */
	public String getAutoincrement() {
		return autoincrement;
	}

	/**
	 * Indicates whether this column is auto incremented<br>
	 * YES --- if the column is auto incremented<br>
	 * NO --- if the column is not auto incremented<br>
	 * empty string --- if it cannot be determined whether the column is auto
	 * incremented
	 * 
	 * @param autoincrement
	 * @return
	 */
	public SdTableColumnAttribute setAutoincrement(String autoincrement) {
		this.autoincrement = autoincrement;
		return this;
	}
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
	public SdTableColumnAttribute setTableCat(String tableCat) {
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
	public SdTableColumnAttribute setTableSchem(String tableSchem) {
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
	 * 
	 * @param tableName
	 * @return
	 */
	public SdTableColumnAttribute setTableName(String tableName) {
		this.tableName = tableName;
		return this;
	}
	/**
	 * SQL type from java.sql.Types
	 * 
	 * @return
	 */
	public int getDataType() {
		return dataType;
	}
	/**
	 * SQL type from java.sql.Types
	 * 
	 * @param dataType
	 * @return
	 */
	public SdTableColumnAttribute setDataType(int dataType) {
		this.dataType = dataType;
		return this;
	}
	/**
	 * Radix (typically either 10 or 2)
	 * 
	 * @return
	 */
	public int getNumPrecRadix() {
		return numPrecRadix;
	}
	/**
	 * Radix (typically either 10 or 2)
	 * 
	 * @param numPrecRadix
	 * @return
	 */
	public SdTableColumnAttribute setNumPrecRadix(int numPrecRadix) {
		this.numPrecRadix = numPrecRadix;
		return this;
	}
	/**
	 * for char types themaximum number of bytes in the column
	 * 
	 * @return
	 */
	public int getCharOctetLength() {
		return charOctetLength;
	}
	/**
	 * for char types themaximum number of bytes in the column
	 * 
	 * @param charOctetLength
	 * @return
	 */
	public SdTableColumnAttribute setCharOctetLength(int charOctetLength) {
		this.charOctetLength = charOctetLength;
		return this;
	}
	/**
	 * ISO rules are used to determine the nullability for a column. <br>
	 * YES --- if the column can include NULLs <br>
	 * NO --- if the column cannot include NULLs <br>
	 * empty string --- if the nullability for thecolumn is unknown
	 * 
	 * @return
	 */
	public String getIsNullable() {
		return isNullable;
	}
	/**
	 * ISO rules are used to determine the nullability for a column. <br>
	 * YES --- if the column can include NULLs <br>
	 * NO --- if the column cannot include NULLs <br>
	 * empty string --- if the nullability for thecolumn is unknown
	 * 
	 * @param isNullable
	 * @return
	 */
	public SdTableColumnAttribute setIsNullable(String isNullable) {
		this.isNullable = isNullable;
		return this;
	}
	/**
	 * catalog of table that is the scopeof a reference attribute (null if
	 * DATA_TYPE isn't REF)
	 * 
	 * @return
	 */
	public String getScopeCatalog() {
		return scopeCatalog;
	}
	/**
	 * catalog of table that is the scopeof a reference attribute (null if
	 * DATA_TYPE isn't REF)
	 * 
	 * @param scopeCatalog
	 * @return
	 */
	public SdTableColumnAttribute setScopeCatalog(String scopeCatalog) {
		this.scopeCatalog = scopeCatalog;
		return this;
	}
	/**
	 * schema of table that is the scopeof a reference attribute (null if the
	 * DATA_TYPE isn't REF)
	 * 
	 * @return
	 */
	public String getScopeSchema() {
		return scopeSchema;
	}
	/**
	 * schema of table that is the scopeof a reference attribute (null if the
	 * DATA_TYPE isn't REF)
	 * 
	 * @param scopeSchema
	 * @return
	 */
	public SdTableColumnAttribute setScopeSchema(String scopeSchema) {
		this.scopeSchema = scopeSchema;
		return this;
	}
	/**
	 * table name that this the scopeof a reference attribute (null if the
	 * DATA_TYPE isn't REF)
	 * 
	 * @return
	 */
	public String getScopeTable() {
		return scopeTable;
	}
	/**
	 * table name that this the scopeof a reference attribute (null if the
	 * DATA_TYPE isn't REF)
	 * 
	 * @param scopeTable
	 * @return
	 */
	public SdTableColumnAttribute setScopeTable(String scopeTable) {
		this.scopeTable = scopeTable;
		return this;
	}
	/**
	 * source type of a distinct type or user-generatedRef type, SQL type from
	 * java.sql.Types (null if DATA_TYPEisn't DISTINCT or user-generated REF)
	 * 
	 * @return
	 */
	public short getSourceDataType() {
		return sourceDataType;
	}
	/**
	 * source type of a distinct type or user-generatedRef type, SQL type from
	 * java.sql.Types (null if DATA_TYPEisn't DISTINCT or user-generated REF)
	 * 
	 * @param sourceDataType
	 * @return
	 */
	public SdTableColumnAttribute setSourceDataType(short sourceDataType) {
		this.sourceDataType = sourceDataType;
		return this;
	}
	/**
	 * Indicates whether this is a generated column<br>
	 * YES --- if this a generated column<br>
	 * NO --- if this not a generated column<br>
	 * empty string --- if it cannot be determined whether this is a generated
	 * 
	 * @return
	 */
	public String getGeneratedcolumn() {
		return generatedcolumn;
	}
	/**
	 * Indicates whether this is a generated column<br>
	 * YES --- if this a generated column<br>
	 * NO --- if this not a generated column<br>
	 * empty string --- if it cannot be determined whether this is a generated
	 * 
	 * @param generatedcolumn
	 * @return
	 */
	public SdTableColumnAttribute setGeneratedcolumn(String generatedcolumn) {
		this.generatedcolumn = generatedcolumn;
		return this;
	}

	@Override
	public int compareTo(SdTableColumnAttribute obj) {
		return ordinalPosition > obj.getOrdinalPosition() ? 1 : (ordinalPosition == obj.getOrdinalPosition() ? 0 : -1);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("SdTableColumnAttribute: \n");
		sb.append("  ┣━columnName = " + columnName + "\n");
		sb.append("  ┣━typeName = " + typeName + "\n");
		sb.append("  ┣━columnDef = " + typeName + "\n");
		sb.append("  ┣━columnSize = " + columnSize + "\n");
		sb.append("  ┣━remarks = " + remarks + "\n");
		sb.append("  ┣━columnDef = " + columnDef + "\n");
		sb.append("  ┣━decimalDigits = " + decimalDigits + "\n");
		sb.append("  ┣━nullable = " + nullable + "\n");
		sb.append("  ┣━isNullable = " + isNullable + "\n");
		sb.append("  ┣━ordinalPosition = " + ordinalPosition + "\n");
		sb.append("  ┣━autoincrement = " + autoincrement + "\n");
		sb.append("  ┣━tableCat = " + tableCat + "\n");
		sb.append("  ┣━tableSchem = " + tableSchem + "\n");
		sb.append("  ┣━tableName = " + tableName + "\n");
		sb.append("  ┣━dataType = " + dataType + "\n");
		sb.append("  ┣━numPrecRadix = " + numPrecRadix + "\n");
		sb.append("  ┣━charOctetLength = " + charOctetLength + "\n");
		sb.append("  ┣━scopeCatalog = " + scopeCatalog + "\n");
		sb.append("  ┣━scopeSchema = " + scopeSchema + "\n");
		sb.append("  ┣━scopeTable = " + scopeTable + "\n");
		sb.append("  ┣━sourceDataType = " + sourceDataType + "\n");
		sb.append("  ┗━generatedcolumn = " + generatedcolumn + "\n");
		return sb.toString();

	}

}
