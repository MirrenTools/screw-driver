package org.mirrentools.sd.models;

import java.util.LinkedHashMap;
import java.util.Map;

import org.mirrentools.sd.common.SdUtil;

/**
 * 创建类与表列所需要的属性
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class SdColumn {
	/** 列的名字 */
	private String name;
	/** 列的数据类型 */
	private String type;
	/** 列的长度 */
	private String length;
	/** 列的默认值 */
	private String _default;
	/** 列是否为主键 */
	private boolean primary;
	/** 列的主键名称 */
	private String primaryName;
	/** 是否为索引 */
	private boolean index;
	/** 索引的类型 */
	private String indexType;
	/** 索引的名字 */
	private String indexName;
	/** 列是否允许为空 */
	private boolean nullable;
	/** 列是否为无符号 */
	private boolean unsigned;
	/** 列是否自增量 */
	private boolean autoIncrement;
	/** 列的注解 */
	private String remark;
	/** 拓展属性 */
	private Map<String, Object> extensions;

	public String getName() {
		return name;
	}

	public SdColumn setName(String name) {
		this.name = name;
		return this;
	}

	public String getType() {
		return type;
	}

	public SdColumn setType(String type) {
		this.type = type;
		return this;
	}

	public String getLength() {
		return length;
	}

	public SdColumn setLength(String length) {
		this.length = length;
		return this;
	}

	public String getDefault() {
		return _default;
	}

	public SdColumn setDefault(String _default) {
		this._default = _default;
		return this;
	}

	public boolean isPrimary() {
		return primary;
	}

	public SdColumn setPrimary(boolean primary) {
		this.primary = primary;
		return this;
	}

	public String getPrimaryName() {
		return primaryName;
	}

	public SdColumn setPrimaryName(String primaryName) {
		this.primaryName = primaryName;
		return this;
	}

	public boolean isIndex() {
		return index;
	}

	public SdColumn setIndex(boolean index) {
		this.index = index;
		return this;
	}

	public String getIndexType() {
		return indexType;
	}

	public SdColumn setIndexType(String indexType) {
		this.indexType = indexType;
		return this;
	}

	public String getIndexName() {
		return indexName;
	}

	public SdColumn setIndexName(String indexName) {
		this.indexName = indexName;
		return this;
	}

	public boolean isNullable() {
		return nullable;
	}

	public SdColumn setNullable(boolean nullable) {
		this.nullable = nullable;
		return this;
	}

	public boolean isUnsigned() {
		return unsigned;
	}

	public SdColumn setUnsigned(boolean unsigned) {
		this.unsigned = unsigned;
		return this;
	}

	public boolean isAutoIncrement() {
		return autoIncrement;
	}

	public SdColumn setAutoIncrement(boolean autoIncrement) {
		this.autoIncrement = autoIncrement;
		return this;
	}

	public String getRemark() {
		return remark;
	}

	public SdColumn setRemark(String remark) {
		this.remark = remark;
		return this;
	}

	/**
	 * 获得拓展属性值
	 * 
	 * @return
	 */
	public Object getExtension(String key) {
		if (SdUtil.isNullOrEmpty(getExtensions(), key)) {
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
		if (SdUtil.isNullOrEmpty(key)) {
			return this;
		}
		if (this.extensions == null) {
			this.extensions = new LinkedHashMap<String, Object>();
		}
		this.extensions.put(key, value);
		return this;
	}

	public Map<String, Object> getExtensions() {
		return extensions;
	}

	public SdColumn setExtensions(Map<String, Object> extensions) {
		this.extensions = extensions;
		return this;
	}

	@Override
	public String toString() {
		return "JsgColumn [name=" + name + ", type=" + type + ", length=" + length + ", default=" + _default + ", primary=" + primary + ", primaryName=" + primaryName + ", index=" + index + ", indexType="
				+ indexType + ", indexName=" + indexName + ", nullable=" + nullable + ", unsigned=" + unsigned + ", autoIncrement=" + autoIncrement + ", remark=" + remark + ", extensions=" + extensions + "]";
	}

}
