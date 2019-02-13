package org.mirrentools.sd.models.db.query;

/**
 * 表的属性,用于获取表属性
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public class SdTableAttribute {
	/** 表类别（可为 null） */
	private String tableCat;
	/** 表模式（可为 null） */
	private String tableSchem;
	/** 表名称 */
	private String tableName;
	/**
	 * 表类型。典型的类型是 "TABLE"、"VIEW"、"SYSTEM TABLE"、"GLOBAL TEMPORARY"、"LOCAL
	 * TEMPORARY"、"ALIAS" 和 "SYNONYM
	 */
	private String tableType;
	/** 表的解释性注释 */
	private String remarks;
	/** 类型的类别（可为 null） */
	private String typeCat;
	/** 类型模式（可为 null） */
	private String typeSchem;
	/** 类型名称（可为 null） */
	private String typeName;
	/** 有类型表的指定 "identifier" 列的名称（可为 null） */
	private String selfReferencingColName;
	/**
	 * 指定在 SELF_REFERENCING_COL_NAME 中创建值的方式。这些值为 "SYSTEM"、"USER" 和 "DERIVED"。（可能为
	 * null）
	 */
	private String refGeneration;

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
	public SdTableAttribute setTableCat(String tableCat) {
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
	public SdTableAttribute setTableSchem(String tableSchem) {
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
	public SdTableAttribute setTableName(String tableName) {
		this.tableName = tableName;
		return this;
	}
	/**
	 * table type. Typical types are "TABLE","VIEW", "SYSTEM TABLE", "GLOBAL
	 * TEMPORARY","LOCAL TEMPORARY", "ALIAS", "SYNONYM".
	 * 
	 * @return
	 */
	public String getTableType() {
		return tableType;
	}
	/**
	 * table type. Typical types are "TABLE","VIEW", "SYSTEM TABLE", "GLOBAL
	 * TEMPORARY","LOCAL TEMPORARY", "ALIAS", "SYNONYM".
	 * 
	 * @param tableType
	 * @return
	 */
	public SdTableAttribute setTableType(String tableType) {
		this.tableType = tableType;
		return this;
	}
	/**
	 * explanatory comment on the table
	 * 
	 * @return
	 */
	public String getRemarks() {
		return remarks;
	}
	/**
	 * explanatory comment on the table
	 * 
	 * @param remarks
	 * @return
	 */
	public SdTableAttribute setRemarks(String remarks) {
		this.remarks = remarks;
		return this;
	}
	/**
	 * the types catalog (may be null)
	 * 
	 * @return
	 */
	public String getTypeCat() {
		return typeCat;
	}
	/**
	 * the types catalog (may be null)
	 * 
	 * @param typeCat
	 * @return
	 */
	public SdTableAttribute setTypeCat(String typeCat) {
		this.typeCat = typeCat;
		return this;
	}
	/**
	 * the types schema (may be null)
	 * 
	 * @return
	 */
	public String getTypeSchem() {
		return typeSchem;
	}
	/**
	 * the types schema (may be null)
	 * 
	 * @param typeSchem
	 * @return
	 */
	public SdTableAttribute setTypeSchem(String typeSchem) {
		this.typeSchem = typeSchem;
		return this;
	}
	/**
	 * type name (may be null)
	 * 
	 * @return
	 */
	public String getTypeName() {
		return typeName;
	}
	/**
	 * type name (may be null)
	 * 
	 * @param typeName
	 * @return
	 */
	public SdTableAttribute setTypeName(String typeName) {
		this.typeName = typeName;
		return this;
	}
	/**
	 * name of the designated"identifier" column of a typed table (may be null)
	 * 
	 * @return
	 */
	public String getSelfReferencingColName() {
		return selfReferencingColName;
	}
	/**
	 * name of the designated"identifier" column of a typed table (may be null)
	 * 
	 * @param selfReferencingColName
	 * @return
	 */
	public SdTableAttribute setSelfReferencingColName(String selfReferencingColName) {
		this.selfReferencingColName = selfReferencingColName;
		return this;
	}
	/**
	 * specifies how values inSELF_REFERENCING_COL_NAME are created. Values
	 * are"SYSTEM", "USER", "DERIVED". (may be null)
	 * 
	 * @return
	 */
	public String getRefGeneration() {
		return refGeneration;
	}
	/**
	 * specifies how values inSELF_REFERENCING_COL_NAME are created. Values
	 * are"SYSTEM", "USER", "DERIVED". (may be null)
	 * 
	 * @param refGeneration
	 * @return
	 */
	public SdTableAttribute setRefGeneration(String refGeneration) {
		this.refGeneration = refGeneration;
		return this;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("SdTableAttribute: \n");
		sb.append("  ┣━tableCat = " + tableCat + "\n");
		sb.append("  ┣━tableSchem = " + tableSchem + "\n");
		sb.append("  ┣━tableName = " + tableName + "\n");
		sb.append("  ┣━tableType = " + tableType + "\n");
		sb.append("  ┣━remarks = " + remarks + "\n");
		sb.append("  ┣━typeCat = " + typeCat + "\n");
		sb.append("  ┣━typeSchem = " + typeSchem + "\n");
		sb.append("  ┣━typeName = " + typeName + "\n");
		sb.append("  ┣━selfReferencingColName = " + selfReferencingColName + "\n");
		sb.append("  ┗━refGeneration = " + refGeneration + "\n");
		return sb.toString();

	}
}
