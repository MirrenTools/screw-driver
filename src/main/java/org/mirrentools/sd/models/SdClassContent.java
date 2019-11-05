package org.mirrentools.sd.models;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.mirrentools.sd.common.SdUtil;

/**
 * 模板生成所需要的实体属性上下文
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class SdClassContent {
	/** 表的名字 */
	private String tableName;
	/** 别名 */
	private String alias;
	/** 表的名字帕斯卡命名 */
	private String pascalName;
	/** 表的名字驼峰命名 */
	private String camelName;
	/** 表的名字连字符命名 */
	private String hyphenName;
	/** 表的名字下划线命名 */
	private String underScoreName;
	/** 表的注释 */
	private String remark;
	/** 需要导入的包 */
	private Set<String> imports;
	/** 类的注解 */
	private Set<String> annotations;
	/** 属性集(包含下方主键.外键.索引.其他普通属性集,不包含不能为空以及附加属性) */
	private List<SdColumn> fields;
	/** 所有主键属性集 */
	private List<SdColumn> primaryField;
	/** 所有外键属性集 */
	private List<SdColumn> foreignField;
	/** 所有索引属性集 */
	private List<SdColumn> indexField;
	/** 所有其他普通的属性集 */
	private List<SdColumn> otherField;
	/** 所有不能为空的属性集 */
	private List<SdColumn> cantNullField;
	/** 附加的属性,该属性一般用于只需要创建类属性而不需要创建表属性时使用,可以直接定义Field属性 */
	private List<SdColumn> additionalField;
	/** 类的关系属性 */
	private List<SdRelationalContent> relationals;
	/** 拓展属性 */
	private Map<String, Object> extensions;
	/**
	 * 获取表的名字
	 * 
	 * @return
	 */
	public String getTableName() {
		return tableName;
	}
	/**
	 * 设置表的名字
	 * 
	 * @param tableName
	 * @return
	 */
	public SdClassContent setTableName(String tableName) {
		this.tableName = tableName;
		return this;
	}
	/**
	 * 获取别名
	 * 
	 * @return
	 */
	public String getAlias() {
		return alias;
	}
	/**
	 * 设置别名
	 * 
	 * @param alias
	 * @return
	 */
	public SdClassContent setAlias(String alias) {
		this.alias = alias;
		return this;
	}
	/**
	 * 获取表名的帕斯卡命名
	 * 
	 * @return
	 */
	public String getPascalName() {
		return pascalName;
	}
	/**
	 * 设置表名的帕斯卡命名
	 * 
	 * @param pascalName
	 * @return
	 */
	public SdClassContent setPascalName(String pascalName) {
		this.pascalName = pascalName;
		return this;
	}
	/**
	 * 获取表名的驼峰命名
	 * 
	 * @return
	 */
	public String getCamelName() {
		return camelName;
	}
	/**
	 * 表名的驼峰命名
	 * 
	 * @param camelName
	 * @return
	 */
	public SdClassContent setCamelName(String camelName) {
		this.camelName = camelName;
		return this;
	}
	/**
	 * 获取表名的连字符命名
	 * 
	 * @return
	 */
	public String getHyphenName() {
		return hyphenName;
	}
	/**
	 * 设置表名的连字符命名
	 * 
	 * @param hyphenName
	 * @return
	 */
	public SdClassContent setHyphenName(String hyphenName) {
		this.hyphenName = hyphenName;
		return this;
	}
	/**
	 * 获取表名的下划线命名
	 * 
	 * @return
	 */
	public String getUnderScoreName() {
		return underScoreName;
	}
	/**
	 * 设置表名的下划线命名
	 * 
	 * @param underScoreName
	 * @return
	 */
	public SdClassContent setUnderScoreName(String underScoreName) {
		this.underScoreName = underScoreName;
		return this;
	}
	/**
	 * 获取表的注释
	 * 
	 * @return
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置表的注释
	 * 
	 * @param remark
	 * @return
	 */
	public SdClassContent setRemark(String remark) {
		this.remark = remark;
		return this;
	}

	/**
	 * 获取需要引入的包
	 * 
	 * @return
	 */
	public Set<String> getImports() {
		return imports;
	}
	/**
	 * 设置需要引入的包
	 * 
	 * @param imports
	 */
	public SdClassContent addImports(String imports) {
		if (getImports() == null) {
			setImports(new LinkedHashSet<String>());
		}
		getImports().add(imports);
		return this;
	}

	/**
	 * 设置需要引入的包
	 * 
	 * @param imports
	 */
	public SdClassContent setImports(Set<String> imports) {
		this.imports = imports;
		return this;
	}
	/**
	 * 获取类的注解
	 * 
	 * @return
	 */
	public Set<String> getAnnotations() {
		return annotations;
	}

	/**
	 * 添加类的注解
	 * 
	 * @param annotation
	 * @return
	 */
	public SdClassContent addAnnotation(String annotation) {
		if (getImports() == null) {
			this.annotations = new LinkedHashSet<String>();
		}
		this.annotations.add(annotation);
		return this;
	}

	/**
	 * 设置类的注解
	 * 
	 * @param annotations
	 * @return
	 */
	public SdClassContent setAnnotations(Set<String> annotations) {
		this.annotations = annotations;
		return this;
	}
	/**
	 * 获取所有属性列
	 * 
	 * @return
	 */
	public List<SdColumn> getFields() {
		return fields;
	}

	/**
	 * 添加所有属性列
	 * 
	 * @param field
	 * @return
	 */
	public SdClassContent addField(SdColumn field) {
		if (getFields() == null) {
			setFields(new ArrayList<SdColumn>());
		}
		getFields().add(field);
		return this;
	}

	/**
	 * 设置所有属性列
	 * 
	 * @param allField
	 * @return
	 */
	public SdClassContent setFields(List<SdColumn> fields) {
		this.fields = fields;
		return this;
	}

	/**
	 * 获取主键属性列
	 * 
	 * @return
	 */
	public List<SdColumn> getPrimaryField() {
		return primaryField;
	}

	/**
	 * 添加主键属性列
	 * 
	 * @param field
	 * @return
	 */
	public SdClassContent addPrimaryField(SdColumn field) {
		if (getPrimaryField() == null) {
			setPrimaryField(new ArrayList<SdColumn>());
		}
		getPrimaryField().add(field);
		return this;
	}
	/**
	 * 设置主键属性列
	 * 
	 * @param primaryField
	 * @return
	 */
	public SdClassContent setPrimaryField(List<SdColumn> primaryField) {
		this.primaryField = primaryField;
		return this;
	}
	/**
	 * 获取外键属性
	 * 
	 * @return
	 */
	public List<SdColumn> getForeignField() {
		return foreignField;
	}
	/**
	 * 添加外键属性
	 * 
	 * @param foreignField
	 * @return
	 */
	public SdClassContent addForeignField(SdColumn foreignField) {
		if (getForeignField() == null) {
			setForeignField(new ArrayList<SdColumn>());
		}
		getForeignField().add(foreignField);
		return this;
	}

	/**
	 * 设置外键属性
	 * 
	 * @param foreignField
	 * @return
	 */
	public SdClassContent setForeignField(List<SdColumn> foreignField) {
		this.foreignField = foreignField;
		return this;
	}
	/**
	 * 获取索引属性列
	 * 
	 * @return
	 */
	public List<SdColumn> getIndexField() {
		return indexField;
	}

	/**
	 * 添加索引属性列
	 * 
	 * @param field
	 * @return
	 */
	public SdClassContent addIndexField(SdColumn field) {
		if (getIndexField() == null) {
			setIndexField(new ArrayList<SdColumn>());
		}
		getIndexField().add(field);
		return this;
	}
	/**
	 * 设置索引属性列
	 * 
	 * @param indexField
	 * @return
	 */
	public SdClassContent setIndexField(List<SdColumn> indexField) {
		this.indexField = indexField;
		return this;
	}
	/**
	 * 获取其他普通的属性列
	 * 
	 * @return
	 */
	public List<SdColumn> getOtherField() {
		return otherField;
	}

	/**
	 * 添加其他普通的属性列
	 * 
	 * @param field
	 * @return
	 */
	public SdClassContent addOtherField(SdColumn field) {
		if (getOtherField() == null) {
			setOtherField(new ArrayList<SdColumn>());
		}
		getOtherField().add(field);
		return this;
	}
	/**
	 * 设置其他普通的属性列
	 * 
	 * @param otherField
	 * @return
	 */
	public SdClassContent setOtherField(List<SdColumn> otherField) {
		this.otherField = otherField;
		return this;
	}
	/**
	 * 获取不能为空的属性列
	 * 
	 * @return
	 */
	public List<SdColumn> getCantNullField() {
		return cantNullField;
	}
	/**
	 * 添加不能为空的属性列
	 * 
	 * @param field
	 * @return
	 */
	public SdClassContent addCantNullField(SdColumn field) {
		if (getCantNullField() == null) {
			setCantNullField(new ArrayList<SdColumn>());
		}
		getCantNullField().add(field);
		return this;
	}
	/**
	 * 设置不能为空的属性列
	 * 
	 * @param cantNullField
	 * @return
	 */
	public SdClassContent setCantNullField(List<SdColumn> cantNullField) {
		this.cantNullField = cantNullField;
		return this;
	}
	/**
	 * 获取附加属性
	 * 
	 * @return
	 */
	public List<SdColumn> getAdditionalField() {
		return additionalField;
	}
	/**
	 * 添加附加属性
	 * 
	 * @param additionalField
	 * @return
	 */
	public SdClassContent addAdditionalField(SdColumn additionalField) {
		if (getAdditionalField() == null) {
			setAdditionalField(new ArrayList<SdColumn>());
		}
		getAdditionalField().add(additionalField);
		return this;
	}
	/**
	 * 设置附加属性
	 * 
	 * @param additionalField
	 * @return
	 */
	public SdClassContent setAdditionalField(List<SdColumn> additionalField) {
		this.additionalField = additionalField;
		return this;
	}
	/**
	 * 获取关系列属性
	 * 
	 * @return
	 */
	public List<SdRelationalContent> getRelationals() {
		return relationals;
	}
	/**
	 * 添加关系属性
	 * 
	 * @param relational
	 * @return
	 */
	public SdClassContent addRelational(SdRelationalContent relational) {
		if (getRelationals() == null) {
			setRelationals(new ArrayList<SdRelationalContent>());
		}
		getRelationals().add(relational);
		return this;
	}

	/**
	 * 设置关系列属性
	 * 
	 * @param relationals
	 * @return
	 */
	public SdClassContent setRelationals(List<SdRelationalContent> relationals) {
		this.relationals = relationals;
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
	public SdClassContent addExtension(String key, Object value) {
		if (getExtensions()==null) {
			setExtensions(new LinkedHashMap<String, Object>());
		}
		getExtensions().put(key, value);
		return this;
	}
	/**
	 * 获取拓展属性
	 * 
	 * @return
	 */
	public Map<String, Object> getExtensions() {
		return extensions;
	}

	/**
	 * 设置拓展属性
	 * 
	 * @param extensions
	 * @return
	 */
	public SdClassContent setExtensions(Map<String, Object> extensions) {
		this.extensions = extensions;
		return this;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("SdClassContent: \n");
		sb.append("tableName=" + tableName + "\n");
		sb.append("alias=" + alias + "\n");
		sb.append("pascalName=" + pascalName + "\n");
		sb.append("camelName=" + camelName + "\n");
		sb.append("hyphenName=" + hyphenName + "\n");
		sb.append("underScoreName=" + underScoreName + "\n");
		sb.append("remark=" + remark + "\n");
		if (imports != null) {
			sb.append("*********************imports*************************\n");
			for (String impt : imports) {
				sb.append("┣━" + impt + "\n");
			}
		} else {
			sb.append("imports: " + imports + "\n");
		}
		if (annotations != null) {
			sb.append("*********************annotations*************************\n");
			for (String anno : annotations) {
				sb.append("┣━" + anno + "\n");
			}
		} else {
			sb.append("annotations: " + annotations + "\n");
		}
		if (fields != null) {
			sb.append("*********************fields*************************\n");
			for (SdColumn f : fields) {
				sb.append(f);
			}
		} else {
			sb.append("fields: " + fields + "\n");
		}
		if (primaryField != null) {
			sb.append("********************primaryField**************************\n");
			for (SdColumn f : primaryField) {
				sb.append(f);
			}
		} else {
			sb.append("primaryField: " + primaryField + "\n");
		}
		if (foreignField != null) {
			sb.append("*******************foreignField***************************\n");
			for (SdColumn f : foreignField) {
				sb.append(f);
			}
		} else {
			sb.append("indexField: " + foreignField + "\n");
		}
		if (indexField != null) {
			sb.append("*******************indexField***************************\n");
			for (SdColumn f : indexField) {
				sb.append(f);
			}
		} else {
			sb.append("indexField: " + indexField + "\n");
		}
		if (otherField != null) {
			sb.append("*******************otherField***************************\n");
			for (SdColumn f : otherField) {
				sb.append(f);
			}
		} else {
			sb.append("otherField: " + otherField + "\n");
		}
		if (cantNullField != null) {
			sb.append("*******************cantNullField***************************\n");
			for (SdColumn f : cantNullField) {
				sb.append(f);
			}
		} else {
			sb.append("cantNullField: " + cantNullField + "\n");
		}
		if (relationals != null) {
			sb.append("*******************relationals***************************\n");
			for (SdRelationalContent r : relationals) {
				sb.append(r);
			}
		} else {
			sb.append("relationals: " + relationals + "\n");
		}
		sb.append("extensions: " + extensions + "\n");
		return sb.toString();
	}

}
