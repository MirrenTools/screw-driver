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
	 * 是否允许使用 NULL值<br>
	 * true = 明确允许使用 NULL值<br>
	 * false = 可能不允许使用 NULL值(不明确是否允许使用NULL值)<br>
	 */
	private boolean nullable;

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
	 * ISO rules are used to determine the nullability for a column. <br>
	 * YES --- if the column can include NULLs <br>
	 * NO --- if the column cannot include NULLs <br>
	 * empty string --- if the nullability for thecolumn is unknown
	 */
	private String nullableISO;
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
	private String sourceDataType;
	/**
	 * Indicates whether this is a generated column<br>
	 * YES --- if this a generated column<br>
	 * NO --- if this not a generated column<br>
	 * empty string --- if it cannot be determined whether this is a generated
	 * column
	 */
	private String generatedcolumn;

	/**
	 * 获取列名
	 * 
	 * @return
	 */
	public String getColumnName() {
		return columnName;
	}

	/**
	 * 设置列名
	 * 
	 * @param columnName
	 * @return
	 */
	public SdTableColumnAttribute setColumnName(String columnName) {
		this.columnName = columnName;
		return this;
	}

	/**
	 * 获取JDBC数据类型
	 * 
	 * @return
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * 设置JDBC数据类型
	 * 
	 * @param typeName
	 * @return
	 */
	public SdTableColumnAttribute setTypeName(String typeName) {
		this.typeName = typeName;
		return this;
	}

	/**
	 * 获取默认值
	 * 
	 * @return
	 */
	public String getColumnDef() {
		return columnDef;
	}

	/**
	 * 设置默认值
	 * 
	 * @param columnDef
	 * @return
	 */
	public SdTableColumnAttribute setColumnDef(String columnDef) {
		this.columnDef = columnDef;
		return this;
	}

	/**
	 * 获取长度
	 * 
	 * @return
	 */
	public int getColumnSize() {
		return columnSize;
	}

	/**
	 * 设置长度
	 * 
	 * @param columnSize
	 * @return
	 */
	public SdTableColumnAttribute setColumnSize(int columnSize) {
		this.columnSize = columnSize;
		return this;
	}

	/**
	 * 获取注释
	 * 
	 * @return
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * 设置注释
	 * 
	 * @param remarks
	 * @return
	 */
	public SdTableColumnAttribute setRemarks(String remarks) {
		this.remarks = remarks;
		return this;
	}

	/**
	 * 获取小数部分有多少位
	 * 
	 * @return
	 */
	public int getDecimalDigits() {
		return decimalDigits;
	}

	/**
	 * 设置小数部分有多少位
	 * 
	 * @param decimalDigits
	 * @return
	 */
	public SdTableColumnAttribute setDecimalDigits(int decimalDigits) {
		this.decimalDigits = decimalDigits;
		return this;
	}

	/**
	 * 获取是否可以为空
	 * 
	 * @return
	 */
	public boolean isNullable() {
		return nullable;
	}

	/**
	 * 设置是否可以为空
	 * 
	 * @param nullable
	 * @return
	 */
	public SdTableColumnAttribute setNullable(boolean nullable) {
		this.nullable = nullable;
		return this;
	}

	/**
	 * 获取列在表中的顺序
	 * 
	 * @return
	 */
	public int getOrdinalPosition() {
		return ordinalPosition;
	}

	/**
	 * 设置列在表中的顺序
	 * 
	 * @param ordinalPosition
	 * @return
	 */
	public SdTableColumnAttribute setOrdinalPosition(int ordinalPosition) {
		this.ordinalPosition = ordinalPosition;
		return this;
	}

	/**
	 * 获取是否自增
	 * 
	 * @return
	 */
	public String getAutoincrement() {
		return autoincrement;
	}

	/**
	 * 设置是否自增
	 * 
	 * @param autoincrement
	 * @return
	 */
	public SdTableColumnAttribute setAutoincrement(String autoincrement) {
		this.autoincrement = autoincrement;
		return this;
	}

	public String getTableCat() {
		return tableCat;
	}

	public SdTableColumnAttribute setTableCat(String tableCat) {
		this.tableCat = tableCat;
		return this;
	}

	public String getTableSchem() {
		return tableSchem;
	}

	public SdTableColumnAttribute setTableSchem(String tableSchem) {
		this.tableSchem = tableSchem;
		return this;
	}

	public String getTableName() {
		return tableName;
	}

	public SdTableColumnAttribute setTableName(String tableName) {
		this.tableName = tableName;
		return this;
	}

	public int getDataType() {
		return dataType;
	}

	public SdTableColumnAttribute setDataType(int dataType) {
		this.dataType = dataType;
		return this;
	}

	public int getNumPrecRadix() {
		return numPrecRadix;
	}

	public SdTableColumnAttribute setNumPrecRadix(int numPrecRadix) {
		this.numPrecRadix = numPrecRadix;
		return this;
	}

	public int getCharOctetLength() {
		return charOctetLength;
	}

	public SdTableColumnAttribute setCharOctetLength(int charOctetLength) {
		this.charOctetLength = charOctetLength;
		return this;
	}

	public String getNullableISO() {
		return nullableISO;
	}

	public SdTableColumnAttribute setNullableISO(String nullableISO) {
		this.nullableISO = nullableISO;
		return this;
	}

	public String getScopeCatalog() {
		return scopeCatalog;
	}

	public SdTableColumnAttribute setScopeCatalog(String scopeCatalog) {
		this.scopeCatalog = scopeCatalog;
		return this;
	}

	public String getScopeSchema() {
		return scopeSchema;
	}

	public SdTableColumnAttribute setScopeSchema(String scopeSchema) {
		this.scopeSchema = scopeSchema;
		return this;
	}

	public String getScopeTable() {
		return scopeTable;
	}

	public SdTableColumnAttribute setScopeTable(String scopeTable) {
		this.scopeTable = scopeTable;
		return this;
	}

	public String getSourceDataType() {
		return sourceDataType;
	}

	public SdTableColumnAttribute setSourceDataType(String sourceDataType) {
		this.sourceDataType = sourceDataType;
		return this;
	}

	public String getGeneratedcolumn() {
		return generatedcolumn;
	}

	public SdTableColumnAttribute setGeneratedcolumn(String generatedcolumn) {
		this.generatedcolumn = generatedcolumn;
		return this;
	}

	@Override
	public int compareTo(SdTableColumnAttribute obj) {
		return ordinalPosition > obj.getOrdinalPosition() ? 1 : (ordinalPosition == obj.getOrdinalPosition() ? 0 : -1);
	}

}
