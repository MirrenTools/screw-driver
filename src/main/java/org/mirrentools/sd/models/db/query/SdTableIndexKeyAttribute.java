package org.mirrentools.sd.models.db.query;

/**
 * 表的索引属性,用于获取索引属性
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public class SdTableIndexKeyAttribute {
	/** table catalog (may be null) */
	private String tableCat;
	/** table schema (may be null) */
	private String tableSchem;
	/** table name */
	private String tableName;
	/** Can index values be non-unique.false when TYPE is tableIndexStatistic */
	private boolean nonUnique;
	/** index catalog (may be null); null when TYPE is tableIndexStatistic */
	private String indexQualifier;
	/** index name; null when TYPE istableIndexStatistic */
	private String indexName;
	/**
	 * index type:<br>
	 * tableIndexStatistic - this identifies table statistics that arereturned in
	 * conjuction with a table's index descriptions <br>
	 * tableIndexClustered - this is a clustered index <br>
	 * tableIndexHashed - this is a hashed index <br>
	 * tableIndexOther - this is some other style of index
	 */
	private short type;
	/**
	 * column sequence numberwithin index; zero when TYPE is tableIndexStatistic
	 */
	private short ordinalPosition;
	/** column name; null when TYPE istableIndexStatistic */
	private String columnName;
	/**
	 * column sort sequence, "A" => ascending,"D" => descending, may be null if
	 * sort sequence is not supported; null when TYPE is tableIndexStatistic
	 */
	private String ascOrDesc;
	/**
	 * When TYPE is tableIndexStatistic, thenthis is the number of rows in the
	 * table; otherwise, it is thenumber of unique values in the index.
	 */
	private int cardinality;
	/**
	 * When TYPE is tableIndexStatisic thenthis is the number of pages used for
	 * the table, otherwise itis the number of pages used for the current index.
	 */
	private int pages;
	/** Filter condition, if any.(may be null) */
	private String filterCondition;

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
	public SdTableIndexKeyAttribute setTableCat(String tableCat) {
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
	public SdTableIndexKeyAttribute setTableSchem(String tableSchem) {
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
	public SdTableIndexKeyAttribute setTableName(String tableName) {
		this.tableName = tableName;
		return this;
	}
	/**
	 * Can index values be non-unique.false when TYPE is tableIndexStatistic
	 * 
	 * @return
	 */
	public boolean isNonUnique() {
		return nonUnique;
	}
	/**
	 * Can index values be non-unique.false when TYPE is tableIndexStatistic
	 * 
	 * @param nonUnique
	 * @return
	 */
	public SdTableIndexKeyAttribute setNonUnique(boolean nonUnique) {
		this.nonUnique = nonUnique;
		return this;
	}
	/**
	 * index catalog (may be null); null when TYPE is tableIndexStatistic
	 * 
	 * @return
	 */
	public String getIndexQualifier() {
		return indexQualifier;
	}
	/**
	 * index catalog (may be null); null when TYPE is tableIndexStatistic
	 * 
	 * @param indexQualifier
	 * @return
	 */
	public SdTableIndexKeyAttribute setIndexQualifier(String indexQualifier) {
		this.indexQualifier = indexQualifier;
		return this;
	}
	/**
	 * index name; null when TYPE istableIndexStatistic
	 * 
	 * @return
	 */
	public String getIndexName() {
		return indexName;
	}
	/**
	 * index name; null when TYPE istableIndexStatistic
	 * 
	 * @param indexName
	 * @return
	 */
	public SdTableIndexKeyAttribute setIndexName(String indexName) {
		this.indexName = indexName;
		return this;
	}
	/**
	 * index type:<br>
	 * tableIndexStatistic - this identifies table statistics that arereturned in
	 * conjuction with a table's index descriptions <br>
	 * tableIndexClustered - this is a clustered index <br>
	 * tableIndexHashed - this is a hashed index <br>
	 * tableIndexOther - this is some other style of index
	 * 
	 * @return
	 */
	public short getType() {
		return type;
	}
	/**
	 * index type:<br>
	 * tableIndexStatistic - this identifies table statistics that arereturned in
	 * conjuction with a table's index descriptions <br>
	 * tableIndexClustered - this is a clustered index <br>
	 * tableIndexHashed - this is a hashed index <br>
	 * tableIndexOther - this is some other style of index
	 * 
	 * @param type
	 * @return
	 */
	public SdTableIndexKeyAttribute setType(short type) {
		this.type = type;
		return this;
	}
	/**
	 * column sequence numberwithin index; zero when TYPE is tableIndexStatistic
	 * 
	 * @return
	 */
	public short getOrdinalPosition() {
		return ordinalPosition;
	}
	/**
	 * column sequence numberwithin index; zero when TYPE is tableIndexStatistic
	 * 
	 * @param ordinalPosition
	 * @return
	 */
	public SdTableIndexKeyAttribute setOrdinalPosition(short ordinalPosition) {
		this.ordinalPosition = ordinalPosition;
		return this;
	}
	/**
	 * column name; null when TYPE istableIndexStatistic
	 * 
	 * @return
	 */
	public String getColumnName() {
		return columnName;
	}
	/**
	 * column name; null when TYPE istableIndexStatistic
	 * 
	 * @param columnName
	 * @return
	 */
	public SdTableIndexKeyAttribute setColumnName(String columnName) {
		this.columnName = columnName;
		return this;
	}
	/**
	 * column sort sequence, "A" => ascending,"D" => descending, may be null if
	 * sort sequence is not supported; null when TYPE is tableIndexStatistic
	 * 
	 * @return
	 */
	public String getAscOrDesc() {
		return ascOrDesc;
	}
	/**
	 * column sort sequence, "A" => ascending,"D" => descending, may be null if
	 * sort sequence is not supported; null when TYPE is tableIndexStatistic
	 * 
	 * @param ascOrDesc
	 * @return
	 */
	public SdTableIndexKeyAttribute setAscOrDesc(String ascOrDesc) {
		this.ascOrDesc = ascOrDesc;
		return this;
	}
	/**
	 * When TYPE is tableIndexStatistic, thenthis is the number of rows in the
	 * table; otherwise, it is thenumber of unique values in the index.
	 * 
	 * @return
	 */
	public int getCardinality() {
		return cardinality;
	}
	/**
	 * When TYPE is tableIndexStatistic, thenthis is the number of rows in the
	 * table; otherwise, it is thenumber of unique values in the index.
	 * 
	 * @param cardinality
	 * @return
	 */
	public SdTableIndexKeyAttribute setCardinality(int cardinality) {
		this.cardinality = cardinality;
		return this;
	}
	/**
	 * When TYPE is tableIndexStatisic thenthis is the number of pages used for
	 * the table, otherwise itis the number of pages used for the current index.
	 * 
	 * @return
	 */
	public int getPages() {
		return pages;
	}
	/**
	 * When TYPE is tableIndexStatisic thenthis is the number of pages used for
	 * the table, otherwise itis the number of pages used for the current index.
	 * 
	 * @param pages
	 * @return
	 */
	public SdTableIndexKeyAttribute setPages(int pages) {
		this.pages = pages;
		return this;
	}
	/**
	 * Filter condition, if any.(may be null)
	 * 
	 * @return
	 */
	public String getFilterCondition() {
		return filterCondition;
	}
	/**
	 * Filter condition, if any.(may be null)
	 * 
	 * @param filterCondition
	 * @return
	 */
	public SdTableIndexKeyAttribute setFilterCondition(String filterCondition) {
		this.filterCondition = filterCondition;
		return this;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("SdTableIndexKeyAttribute: \n");
		sb.append("  ┣━tableCat = " + tableCat + "\n");
		sb.append("  ┣━tableSchem = " + tableSchem + "\n");
		sb.append("  ┣━tableName = " + tableName + "\n");
		sb.append("  ┣━nonUnique = " + nonUnique + "\n");
		sb.append("  ┣━indexQualifier = " + indexQualifier + "\n");
		sb.append("  ┣━indexName = " + indexName + "\n");
		sb.append("  ┣━type = " + type + "\n");
		sb.append("  ┣━ordinalPosition = " + ordinalPosition + "\n");
		sb.append("  ┣━columnName = " + columnName + "\n");
		sb.append("  ┣━ascOrDesc = " + ascOrDesc + "\n");
		sb.append("  ┣━cardinality = " + cardinality + "\n");
		sb.append("  ┣━pages = " + pages + "\n");
		sb.append("  ┗━filterCondition = " + filterCondition + "\n");
		return sb.toString();

	}

}
