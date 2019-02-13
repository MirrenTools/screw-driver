package org.mirrentools.sd.models.db.query;
/**
 * 表的索引主外键类,对应 :<br>
 * DatabaseMetaData.getImportedKeys(catalog, schema, table)<br>
 * DatabaseMetaData.getExportedKeys(catalog, schema, table)<br>
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public class SdTablePortedKeysAttribute {
	/** 1.PKTABLE_CAT String => primary key table catalog (may be null) */
	private String pktableCat;
	/** 2.PKTABLE_SCHEM String => primary key table schema (may be null) */
	private String pktableSchem;
	/** 3.PKTABLE_NAME String => primary key table name */
	private String pktableName;
	/** 4.PKCOLUMN_NAME String => primary key column name */
	private String pkcolumnName;
	/**
	 * 5.FKTABLE_CAT String => foreign key table catalog (may be null)being
	 * exported (may be null)
	 */
	private String fktableCat;
	/**
	 * 6.FKTABLE_SCHEM String => foreign key table schema (may be null)being
	 * exported (may be null)
	 */
	private String fktableSchem;
	/** 7.FKTABLE_NAME String => foreign key table namebeing exported */
	private String fktableName;
	/** 8.FKCOLUMN_NAME String => foreign key column namebeing exported */
	private String fkcolumnName;
	/**
	 * 9.KEY_SEQ short => sequence number within foreign key( a valueof 1
	 * represents the first column of the foreign key, a value of 2 wouldrepresent
	 * the second column within the foreign key).
	 */
	private short keySeq;
	/**
	 * 10.UPDATE_RULE short => What happens toforeign key when primary is
	 * updated:<br>
	 * importedNoAction - do not allow update of primarykey if it has been
	 * imported<br>
	 * importedKeyCascade - change imported key to agreewith primary key
	 * update<br>
	 * importedKeySetNull - change imported key to NULL ifits primary key has been
	 * updated<br>
	 * importedKeySetDefault - change imported key to default valuesif its primary
	 * key has been updated<br>
	 * importedKeyRestrict - same as importedKeyNoAction(for ODBC 2.x
	 * compatibility)<br>
	 */
	private short updateRule;
	/**
	 * 11.DELETE_RULE short => What happens tothe foreign key when primary is
	 * deleted. importedKeyNoAction - do not allow delete of primarykey if it has
	 * been imported<br>
	 * importedKeyCascade - delete rows that import a deleted key<br>
	 * importedKeySetNull - change imported key to NULL ifits primary key has been
	 * deleted<br>
	 * importedKeyRestrict - same as importedKeyNoAction(for ODBC 2.x
	 * compatibility)<br>
	 * importedKeySetDefault - change imported key to default ifits primary key
	 * has been deleted
	 */
	private short deleteRule;
	/** 12.FK_NAME String => foreign key name (may be null) */
	private String fkName;
	/** 13.PK_NAME String => primary key name (may be null) */
	private String pkName;
	/**
	 * 14.DEFERRABILITY short => can the evaluation of foreign keyconstraints be
	 * deferred until commit <br>
	 * importedKeyInitiallyDeferred - see SQL92 for definition<br>
	 * importedKeyInitiallyImmediate - see SQL92 for definition<br>
	 * importedKeyNotDeferrable - see SQL92 for definition<br>
	 */
	private short deferrability;
	/**
	 * primary key table catalog (may be null)
	 * 
	 * @return
	 */
	public String getPktableCat() {
		return pktableCat;
	}
	/**
	 * primary key table catalog (may be null)
	 * 
	 * @param pktableCat
	 * @return
	 */
	public SdTablePortedKeysAttribute setPktableCat(String pktableCat) {
		this.pktableCat = pktableCat;
		return this;
	}
	/**
	 * primary key table schema (may be null)
	 * 
	 * @return
	 */
	public String getPktableSchem() {
		return pktableSchem;
	}
	/**
	 * primary key table schema (may be null)
	 * 
	 * @param pktableSchem
	 * @return
	 */
	public SdTablePortedKeysAttribute setPktableSchem(String pktableSchem) {
		this.pktableSchem = pktableSchem;
		return this;
	}
	/**
	 * primary key table name
	 * 
	 * @return
	 */
	public String getPktableName() {
		return pktableName;
	}
	/**
	 * primary key table name
	 * 
	 * @param pktableName
	 * @return
	 */
	public SdTablePortedKeysAttribute setPktableName(String pktableName) {
		this.pktableName = pktableName;
		return this;
	}
	/**
	 * primary key column name
	 * 
	 * @return
	 */
	public String getPkcolumnName() {
		return pkcolumnName;
	}
	/**
	 * primary key column name
	 * 
	 * @param pkcolumnName
	 * @return
	 */
	public SdTablePortedKeysAttribute setPkcolumnName(String pkcolumnName) {
		this.pkcolumnName = pkcolumnName;
		return this;
	}
	/**
	 * foreign key table catalog (may be null)being exported (may be null)
	 * 
	 * @return
	 */
	public String getFktableCat() {
		return fktableCat;
	}
	/**
	 * foreign key table catalog (may be null)being exported (may be null)
	 * 
	 * @param fktableCat
	 * @return
	 */
	public SdTablePortedKeysAttribute setFktableCat(String fktableCat) {
		this.fktableCat = fktableCat;
		return this;
	}
	/**
	 * foreign key table schema (may be null)being exported (may be null)
	 * 
	 * @return
	 */
	public String getFktableSchem() {
		return fktableSchem;
	}
	/**
	 * foreign key table schema (may be null)being exported (may be null)
	 * 
	 * @param fktableSchem
	 * @return
	 */
	public SdTablePortedKeysAttribute setFktableSchem(String fktableSchem) {
		this.fktableSchem = fktableSchem;
		return this;
	}
	/**
	 * foreign key table namebeing exported
	 * 
	 * @return
	 */
	public String getFktableName() {
		return fktableName;
	}
	/**
	 * foreign key table namebeing exported
	 * 
	 * @param fktableName
	 * @return
	 */
	public SdTablePortedKeysAttribute setFktableName(String fktableName) {
		this.fktableName = fktableName;
		return this;
	}
	/**
	 * foreign key column namebeing exported
	 * 
	 * @return
	 */
	public String getFkcolumnName() {
		return fkcolumnName;
	}
	/**
	 * foreign key column namebeing exported
	 * 
	 * @param fkcolumnName
	 * @return
	 */
	public SdTablePortedKeysAttribute setFkcolumnName(String fkcolumnName) {
		this.fkcolumnName = fkcolumnName;
		return this;
	}
	/**
	 * sequence number within foreign key( a valueof 1 represents the first column
	 * of the foreign key, a value of 2 wouldrepresent the second column within
	 * the foreign key).
	 * 
	 * @return
	 */
	public short getKeySeq() {
		return keySeq;
	}
	/**
	 * sequence number within foreign key( a valueof 1 represents the first column
	 * of the foreign key, a value of 2 wouldrepresent the second column within
	 * the foreign key).
	 * 
	 * @param keySeq
	 * @return
	 */
	public SdTablePortedKeysAttribute setKeySeq(short keySeq) {
		this.keySeq = keySeq;
		return this;
	}
	/**
	 * 10.UPDATE_RULE short => What happens toforeign key when primary is
	 * updated:<br>
	 * importedNoAction - do not allow update of primarykey if it has been
	 * imported<br>
	 * importedKeyCascade - change imported key to agreewith primary key
	 * update<br>
	 * importedKeySetNull - change imported key to NULL ifits primary key has been
	 * updated<br>
	 * importedKeySetDefault - change imported key to default valuesif its primary
	 * key has been updated<br>
	 * importedKeyRestrict - same as importedKeyNoAction(for ODBC 2.x
	 * compatibility)<br>
	 * 
	 * @return
	 */
	public short getUpdateRule() {
		return updateRule;
	}
	/**
	 * 10.UPDATE_RULE short => What happens toforeign key when primary is
	 * updated:<br>
	 * importedNoAction - do not allow update of primarykey if it has been
	 * imported<br>
	 * importedKeyCascade - change imported key to agreewith primary key
	 * update<br>
	 * importedKeySetNull - change imported key to NULL ifits primary key has been
	 * updated<br>
	 * importedKeySetDefault - change imported key to default valuesif its primary
	 * key has been updated<br>
	 * importedKeyRestrict - same as importedKeyNoAction(for ODBC 2.x
	 * compatibility)<br>
	 * 
	 * @param updateRule
	 * @return
	 */
	public SdTablePortedKeysAttribute setUpdateRule(short updateRule) {
		this.updateRule = updateRule;
		return this;
	}
	/**
	 * 11.DELETE_RULE short => What happens tothe foreign key when primary is
	 * deleted. importedKeyNoAction - do not allow delete of primarykey if it has
	 * been imported<br>
	 * importedKeyCascade - delete rows that import a deleted key<br>
	 * importedKeySetNull - change imported key to NULL ifits primary key has been
	 * deleted<br>
	 * importedKeyRestrict - same as importedKeyNoAction(for ODBC 2.x
	 * compatibility)<br>
	 * importedKeySetDefault - change imported key to default ifits primary key
	 * has been deleted
	 * 
	 * @return
	 */
	public short getDeleteRule() {
		return deleteRule;
	}
	/**
	 * 11.DELETE_RULE short => What happens tothe foreign key when primary is
	 * deleted. importedKeyNoAction - do not allow delete of primarykey if it has
	 * been imported<br>
	 * importedKeyCascade - delete rows that import a deleted key<br>
	 * importedKeySetNull - change imported key to NULL ifits primary key has been
	 * deleted<br>
	 * importedKeyRestrict - same as importedKeyNoAction(for ODBC 2.x
	 * compatibility)<br>
	 * importedKeySetDefault - change imported key to default ifits primary key
	 * has been deleted
	 * 
	 * @param deleteRule
	 * @return
	 */
	public SdTablePortedKeysAttribute setDeleteRule(short deleteRule) {
		this.deleteRule = deleteRule;
		return this;
	}
	/**
	 * foreign key name (may be null)
	 * 
	 * @return
	 */
	public String getFkName() {
		return fkName;
	}
	/**
	 * foreign key name (may be null)
	 * 
	 * @param fkName
	 * @return
	 */
	public SdTablePortedKeysAttribute setFkName(String fkName) {
		this.fkName = fkName;
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
	public SdTablePortedKeysAttribute setPkName(String pkName) {
		this.pkName = pkName;
		return this;
	}
	/**
	 * 14.DEFERRABILITY short => can the evaluation of foreign keyconstraints be
	 * deferred until commit <br>
	 * importedKeyInitiallyDeferred - see SQL92 for definition<br>
	 * importedKeyInitiallyImmediate - see SQL92 for definition<br>
	 * importedKeyNotDeferrable - see SQL92 for definition<br>
	 * 
	 * @return
	 */
	public short getDeferrability() {
		return deferrability;
	}
	/**
	 * 14.DEFERRABILITY short => can the evaluation of foreign keyconstraints be
	 * deferred until commit <br>
	 * importedKeyInitiallyDeferred - see SQL92 for definition<br>
	 * importedKeyInitiallyImmediate - see SQL92 for definition<br>
	 * importedKeyNotDeferrable - see SQL92 for definition<br>
	 * 
	 * @param deferrability
	 * @return
	 */
	public SdTablePortedKeysAttribute setDeferrability(short deferrability) {
		this.deferrability = deferrability;
		return this;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("SdTablePortedKeysAttribute: \n");
		sb.append("  ┣━pktableCat = " + pktableCat + "\n");
		sb.append("  ┣━pktableSchem = " + pktableSchem + "\n");
		sb.append("  ┣━pktableName = " + pktableName + "\n");
		sb.append("  ┣━pkcolumnName = " + pkcolumnName + "\n");
		sb.append("  ┣━fktableCat = " + fktableCat + "\n");
		sb.append("  ┣━fktableSchem = " + fktableSchem + "\n");
		sb.append("  ┣━fktableName = " + fktableName + "\n");
		sb.append("  ┣━fkcolumnName = " + fkcolumnName + "\n");
		sb.append("  ┣━keySeq = " + keySeq + "\n");
		sb.append("  ┣━updateRule = " + updateRule + "\n");
		sb.append("  ┣━deleteRule = " + deleteRule + "\n");
		sb.append("  ┣━fkName = " + fkName + "\n");
		sb.append("  ┣━pkName = " + pkName + "\n");
		sb.append("  ┗━deferrability = " + deferrability + "\n");
		return sb.toString();
	}

}
