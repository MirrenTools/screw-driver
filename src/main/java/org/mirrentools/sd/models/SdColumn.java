package org.mirrentools.sd.models;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.mirrentools.sd.common.SdUtil;

/**
 * 创建类与表列所需要的属性,<br>
 * 在被
 * {@link org.mirrentools.sd.converter.SdTemplateContentConverter}转换时,如果类属性为空需要将表中的列属性转换为类属性,主外键索引等同名则算为联合列<br>
 * 所以在生成时添加表属性就可以了,如果列属性不能很好的转换为类属性才设置类属性
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class SdColumn implements Comparable<SdColumn> {
	/*
	 * 类属性, 如果类属性不为空就取类属性, 如果类属性为空就将表属性转换为类属性
	 */
	/** 需要导入的包 */
	private Set<String> imports;
	/** 类属性的注解 */
	private Set<String> annotations;
	/** 类属性的关系属性 */
	private SdRelationalContent relationalContent;
	/** 类属性数据类型 */
	private String fieldType;
	/** 类属性的名字 */
	private String fieldName;
	/** 类属性的名字帕斯卡命名 */
	private String fieldNamePascal;
	/** 类属性的名字连字符命名 */
	private String fieldNameHyphen;
	/** 类属性的名字下划线命名 */
	private String fieldNameUnderScore;
	/** 类属性的注释 */
	private String fieldRemark;

	/*
	 * 表属性
	 */
	/** 列的名字 */
	private String name;
	/** 列的数据类型 */
	private String type;
	/** 列的注释 */
	private String remark;
	/** 列的长度 */
	private Integer length;
	/** 列的默认值 */
	private String _default;
	/** 列是否为主键 */
	private boolean primary;
	/** 列的主键名称 */
	private String primaryName;
	/** 列是否为外键 */
	private boolean foreignKey;
	/** 外键的名字 */
	private String foreignConstraint;
	/** 外键引用那个表 */
	private String foreignReferencesDB;
	/** 外键引用那个表 */
	private String foreignReferencesTable;
	/** 外键引用那个表的列 */
	private String foreignReferencesColumn;
	/** 是否为索引 */
	private boolean index;
	/** 索引的类型 */
	private String indexType;
	/** 索引的名字 */
	private String indexName;
	/** 索引的备注信息 */
	private String indexRemark;
	/** 列是否允许为空 */
	private boolean nullable = true;
	/** 列是否为无符号 */
	private boolean unsigned;
	/** 列是否自增量 */
	private boolean autoIncrement;
	/** 字符排序 */
	private String collate;
	/** 在表中的顺序 */
	private int ordinalPosition;

	/** 拓展属性 */
	private Map<String, Object> extensions;

	/**
	 * 获取类属性需要引入的包
	 * 
	 * @return
	 */
	public Set<String> getImports() {
		return imports;
	}

	/**
	 * 添加类属性需要引入的包,默认根据表中列的类型添加需要引入的包
	 * 
	 * @param imports
	 * @return
	 */
	public SdColumn addImport(String imports) {
		if (getImports() == null) {
			this.imports = new LinkedHashSet<String>();
		}
		this.imports.add(imports);
		return this;
	}

	/**
	 * 设置类属性需要引入的包,默认根据表中列的类型添加需要引入的包
	 * 
	 * @param imports
	 * @return
	 */
	public SdColumn setImports(Set<String> imports) {
		this.imports = imports;
		return this;
	}

	/**
	 * 获取类属性的注解
	 * 
	 * @return
	 */
	public Set<String> getAnnotations() {
		return annotations;
	}

	/**
	 * 添加类属性的注解
	 * 
	 * @param annotation
	 * @return
	 */
	public SdColumn addAnnotation(String annotation) {
		if (getImports() == null) {
			this.annotations = new LinkedHashSet<String>();
		}
		this.annotations.add(annotation);
		return this;
	}

	/**
	 * 设置类属性的注解
	 * 
	 * @param annotations
	 * @return
	 */
	public SdColumn setAnnotations(Set<String> annotations) {
		this.annotations = annotations;
		return this;
	}

	/**
	 * 获取属性的关系属性内容
	 * 
	 * @return
	 */
	public SdRelationalContent getRelationalContent() {
		return relationalContent;
	}

	/**
	 * 设置属性的关系属性内容
	 * 
	 * @param relationalContent
	 * @return
	 */
	public SdColumn setRelationalContent(SdRelationalContent relationalContent) {
		this.relationalContent = relationalContent;
		return this;
	}

	/**
	 * 获取类的属性类型
	 * 
	 * @return
	 */
	public String getFieldType() {
		return fieldType;
	}

	/**
	 * 设置类的属性类型,默认将表中列的属性转换为类属性类型
	 * 
	 * @param fieldType
	 * @return
	 */
	public SdColumn setFieldType(String fieldType) {
		this.fieldType = fieldType;
		return this;
	}

	/**
	 * 获取类的属性名字,实现时最好是它为驼峰命名
	 * 
	 * @return
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * 设置类的属性名字,默认将表中的列名转换为类属性名,实现时最好是它为驼峰命名
	 * 
	 * @param fieldName
	 * @return
	 */
	public SdColumn setFieldName(String fieldName) {
		this.fieldName = fieldName;
		return this;
	}

	/**
	 * 获取类的属性名字按帕斯卡命名
	 * 
	 * @return
	 */
	public String getFieldNamePascal() {
		return fieldNamePascal;
	}

	/**
	 * 设置类的属性名字按帕斯卡命名
	 * 
	 * @param fieldNamePascal
	 * @return
	 */
	public SdColumn setFieldNamePascal(String fieldNamePascal) {
		this.fieldNamePascal = fieldNamePascal;
		return this;
	}

	/**
	 * 获取类的属性名字按连字符命名
	 * 
	 * @return
	 */
	public String getFieldNameHyphen() {
		return fieldNameHyphen;
	}

	/**
	 * 设置类的属性名字按连字符命名
	 * 
	 * @param fieldNameHyphen
	 * @return
	 */
	public SdColumn setFieldNameHyphen(String fieldNameHyphen) {
		this.fieldNameHyphen = fieldNameHyphen;
		return this;
	}

	/**
	 * 获取类的属性名字按下划线命名
	 * 
	 * @return
	 */
	public String getFieldNameUnderScore() {
		return fieldNameUnderScore;
	}

	/**
	 * 设置类的属性名字按下划线命名
	 * 
	 * @param fieldNameUnderScore
	 * @return
	 */
	public SdColumn setFieldNameUnderScore(String fieldNameUnderScore) {
		this.fieldNameUnderScore = fieldNameUnderScore;
		return this;
	}

	/**
	 * 获取类的属性的注释
	 * 
	 * @return
	 */
	public String getFieldRemark() {
		return fieldRemark;
	}

	/**
	 * 设置类的属性的注释,默认取列属性的注解
	 * 
	 * @param fieldRemark
	 * @return
	 */
	public SdColumn setFieldRemark(String fieldRemark) {
		this.fieldRemark = fieldRemark;
		return this;
	}

	/**
	 * 获取列名
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置列名
	 * 
	 * @param name
	 * @return
	 */
	public SdColumn setName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * 获取列的类型
	 * 
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * 设置列的类型
	 * 
	 * @param type
	 * @return
	 */
	public SdColumn setType(String type) {
		this.type = type;
		return this;
	}

	/**
	 * 获取列的长度
	 * 
	 * @return
	 */
	public Integer getLength() {
		return length;
	}

	/**
	 * 设置列的长度
	 * 
	 * @param length
	 * @return
	 */
	public SdColumn setLength(Integer length) {
		this.length = length;
		return this;
	}

	/**
	 * 设置默认值
	 * 
	 * @return
	 */
	public String getDefault() {
		return _default;
	}

	/**
	 * 获取默认值
	 * 
	 * @param _default
	 * @return
	 */
	public SdColumn setDefault(String _default) {
		this._default = _default;
		return this;
	}

	/**
	 * 是否为主键
	 * 
	 * @return
	 */
	public boolean isPrimary() {
		return primary;
	}

	/**
	 * 设置是否为主键,如果==true,则不能为空
	 * 
	 * @param primary
	 * @return
	 */
	public SdColumn setPrimary(boolean primary) {
		this.primary = primary;
		if (primary) {
			this.nullable = false;
		}
		return this;
	}

	/**
	 * 获取是否为外键
	 * 
	 * @return
	 */
	public boolean isForeignKey() {
		return foreignKey;
	}

	/**
	 * 获取外键的名字
	 * 
	 * @return
	 */
	public String getForeignConstraint() {
		return foreignConstraint;
	}

	/**
	 * 设置外键的名字,如果外键的名字相同则视为多列引用
	 * 
	 * @param foreignConstraint
	 * @return
	 */
	public SdColumn setForeignConstraint(String foreignConstraint) {
		this.foreignConstraint = foreignConstraint;
		this.foreignKey = true;
		return this;
	}
	/**
	 * 获取外键引用那个数据库
	 * 
	 * @return
	 */
	public String getForeignReferencesDB() {
		return foreignReferencesDB;
	}

	/**
	 * 设置外键的引用那个数据库
	 * 
	 * @param foreignReferencesDB
	 * @return
	 */
	public SdColumn setForeignReferencesDB(String foreignReferencesDB) {
		this.foreignReferencesDB = foreignReferencesDB;
		this.foreignKey = true;
		return this;
	}

	/**
	 * 获取外键引用那个表
	 * 
	 * @return
	 */
	public String getForeignReferencesTable() {
		return foreignReferencesTable;
	}

	/**
	 * 设置外键的引用那个表
	 * 
	 * @param foreignReferencesTable
	 * @return
	 */
	public SdColumn setForeignReferencesTable(String foreignReferencesTable) {
		this.foreignReferencesTable = foreignReferencesTable;
		this.foreignKey = true;
		return this;
	}
	/**
	 * 获取外键的引用那个
	 * 
	 * @return
	 */
	public String getForeignReferencesColumn() {
		return foreignReferencesColumn;
	}
	/**
	 * 设置外键的引用那个列
	 * 
	 * @param foreignReferencesColumn
	 * @return
	 */
	public SdColumn setForeignReferencesColumn(String foreignReferencesColumn) {
		this.foreignReferencesColumn = foreignReferencesColumn;
		return this;
	}

	/**
	 * 获取主键的名字
	 * 
	 * @return
	 */
	public String getPrimaryName() {
		return primaryName;
	}

	/**
	 * 设置主键的名字
	 * 
	 * @param primaryName
	 * @return
	 */
	public SdColumn setPrimaryName(String primaryName) {
		this.primaryName = primaryName;
		return this;
	}

	/**
	 * 是否为索引
	 * 
	 * @return
	 */
	public boolean isIndex() {
		return index;
	}

	/**
	 * 获取索引类型
	 * 
	 * @return
	 */
	public String getIndexType() {
		return indexType;
	}

	/**
	 * 设置索引类型
	 * 
	 * @param indexType
	 * @return
	 */
	public SdColumn setIndexType(String indexType) {
		this.indexType = indexType;
		this.index = true;
		return this;
	}

	/**
	 * 获取索引名字
	 * 
	 * @return
	 */
	public String getIndexName() {
		return indexName;
	}

	/**
	 * 设置索引名字
	 * 
	 * @param indexName
	 * @return
	 */
	public SdColumn setIndexName(String indexName) {
		this.indexName = indexName;
		this.index = true;
		return this;
	}

	/**
	 * 获取索引的注释
	 * 
	 * @return
	 */
	public String getIndexRemark() {
		return indexRemark;
	}

	/**
	 * 设置索引的注释
	 * 
	 * @param indexRemark
	 * @return
	 */
	public SdColumn setIndexRemark(String indexRemark) {
		this.indexRemark = indexRemark;
		return this;
	}

	/**
	 * 是否可以为空
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
	public SdColumn setNullable(boolean nullable) {
		this.nullable = nullable;
		return this;
	}

	/**
	 * 是否为无符号
	 * 
	 * @return
	 */
	public boolean isUnsigned() {
		return unsigned;
	}

	/**
	 * 设置是否为无符号
	 * 
	 * @param unsigned
	 * @return
	 */
	public SdColumn setUnsigned(boolean unsigned) {
		this.unsigned = unsigned;
		return this;
	}

	/**
	 * 是否自增
	 * 
	 * @return
	 */
	public boolean isAutoIncrement() {
		return autoIncrement;
	}

	/**
	 * 设置是否自增
	 * 
	 * @param autoIncrement
	 * @return
	 */
	public SdColumn setAutoIncrement(boolean autoIncrement) {
		this.autoIncrement = autoIncrement;
		return this;
	}

	/**
	 * 获取注释
	 * 
	 * @return
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 设置注释
	 * 
	 * @param remark
	 * @return
	 */
	public SdColumn setRemark(String remark) {
		this.remark = remark;
		return this;
	}

	/**
	 * 获取字符排序规则
	 * 
	 * @return
	 */
	public String getCollate() {
		return collate;
	}

	/**
	 * 设置字符排序规则
	 * 
	 * @param collate
	 * @return
	 */
	public SdColumn setCollate(String collate) {
		this.collate = collate;
		return this;
	}
	/**
	 * 获取列的顺序
	 * 
	 * @return
	 */
	public int getOrdinalPosition() {
		return ordinalPosition;
	}
	/**
	 * 设置列的顺序
	 * 
	 * @param ordinalPosition
	 * @return
	 */
	public SdColumn setOrdinalPosition(int ordinalPosition) {
		this.ordinalPosition = ordinalPosition;
		return this;
	}

	/**
	 * 获得拓展属性值
	 * 
	 * @return
	 */
	public Object getExtension(String key) {
		if (SdUtil.isNullOrEmpty(getExtensions())) {
			return null;
		}
		return getExtensions().get(key);
	}

	/**
	 * 添加附加属性
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public SdColumn addExtension(String key, Object value) {
		if (getExtensions() == null) {
			setExtensions(new LinkedHashMap<String, Object>());
		}
		getExtensions().put(key, value);
		return this;
	}

	/**
	 * 获取附加属性
	 * 
	 * @return
	 */
	public Map<String, Object> getExtensions() {
		return extensions;
	}

	/**
	 * 设置附加属性
	 * 
	 * @param extensions
	 * @return
	 */
	public SdColumn setExtensions(Map<String, Object> extensions) {
		this.extensions = extensions;
		return this;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("SdColumn: \n");
		sb.append("  ┣━imports = " + imports + "\n");
		sb.append("  ┣━annotations = " + annotations + "\n");
		sb.append("  ┣━relationalContent = " + relationalContent + "\n");
		sb.append("  ┣━fieldType = " + fieldType + "\n");
		sb.append("  ┣━fieldName = " + fieldName + "\n");
		sb.append("  ┣━fieldNamePascal = " + fieldNamePascal + "\n");
		sb.append("  ┣━fieldNameHyphen = " + fieldNameHyphen + "\n");
		sb.append("  ┣━fieldNameUnderScore = " + fieldNameUnderScore + "\n");
		sb.append("  ┣━fieldRemark = " + fieldRemark + "\n");
		sb.append("  ┣━name = " + name + "\n");
		sb.append("  ┣━type = " + type + "\n");
		sb.append("  ┣━remark = " + remark + "\n");
		sb.append("  ┣━length = " + length + "\n");
		sb.append("  ┣━default = " + _default + "\n");
		sb.append("  ┣━primary = " + primary + "\n");
		sb.append("  ┣━primaryName = " + primaryName + "\n");
		sb.append("  ┣━foreignKey = " + foreignKey + "\n");
		sb.append("  ┣━foreignConstraint = " + foreignConstraint + "\n");
		sb.append("  ┣━foreignReferencesDB = " + foreignReferencesDB + "\n");
		sb.append("  ┣━foreignReferencesTable = " + foreignReferencesTable + "\n");
		sb.append("  ┣━foreignReferencesColumn = " + foreignReferencesColumn + "\n");
		sb.append("  ┣━index = " + index + "\n");
		sb.append("  ┣━indexType = " + indexType + "\n");
		sb.append("  ┣━indexName = " + indexName + "\n");
		sb.append("  ┣━nullable = " + nullable + "\n");
		sb.append("  ┣━unsigned = " + unsigned + "\n");
		sb.append("  ┣━autoIncrement = " + autoIncrement + "\n");
		sb.append("  ┣━collate = " + collate + "\n");
		sb.append("  ┣━ordinalPosition = " + ordinalPosition + "\n");
		sb.append("  ┗━extensions = " + extensions + "\n");
		return sb.toString();
	}

	@Override
	public int compareTo(SdColumn obj) {
		return ordinalPosition > obj.getOrdinalPosition() ? 1 : (ordinalPosition == obj.getOrdinalPosition() ? 0 : -1);
	}

}
