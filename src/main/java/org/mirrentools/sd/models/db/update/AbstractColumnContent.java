package org.mirrentools.sd.models.db.update;

import java.util.LinkedHashMap;
import java.util.Map;

import org.mirrentools.sd.common.SdUtil;

/**
 * 抽象的数据库表操作类,用于做表的新建与修改
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public abstract class AbstractColumnContent {
	/** 列的名字 */
	private String name;
	/** 列的数据类型 */
	private String type;
	/** 列的长度 */
	private long length;
	/** 列的默认值 */
	private String _default;
	/** 列是否主键 */
	private boolean primary;
	/** 列是否允许为空 */
	private boolean notNull;
	/** 列的注释 */
	private String remark;
	/** 是否为无符号 */
	private boolean unsigned;
	/** 是否自增 */
	private boolean autoIncrement;
	/** 拓展属性 */
	private Map<String, Object> extensions;

	/**
	 * 创建表的SQL语句
	 * 
	 * @return
	 */
	public abstract String createSQL();

	/**
	 * 修改表的SQL语句
	 * 
	 * @return
	 */
	public abstract String updateSQL();

	/**
	 * 获取列的名字
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置列的名字
	 * 
	 * @param name
	 * @return
	 */
	public AbstractColumnContent setName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * 获取列的名字
	 * 
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * 设置列的名字
	 * 
	 * @param type
	 * @return
	 */
	public AbstractColumnContent setType(String type) {
		this.type = type;
		return this;
	}

	/**
	 * 获取列的长度
	 * 
	 * @return
	 */
	public long getLength() {
		return length;
	}

	/**
	 * 设置列的长度
	 * 
	 * @param length
	 * @return
	 */
	public AbstractColumnContent setLength(long length) {
		this.length = length;
		return this;
	}

	/**
	 * 获取默认值
	 * 
	 * @return
	 */
	public String getDefault() {
		return _default;
	}

	/**
	 * 设置默认值
	 * 
	 * @param _default
	 * @return
	 */
	public AbstractColumnContent setDefault(String _default) {
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
	 * 设置为主键
	 * 
	 * @param primary
	 * @return
	 */
	public AbstractColumnContent setPrimary(boolean primary) {
		this.primary = primary;
		return this;
	}

	/**
	 * 是否可以为空
	 * 
	 * @return
	 */
	public boolean isNotNull() {
		return notNull;
	}

	/**
	 * 设置是否可以为空
	 * 
	 * @param notNull
	 * @return
	 */
	public AbstractColumnContent setNotNull(boolean notNull) {
		this.notNull = notNull;
		return this;
	}

	/**
	 * 获取注解
	 * 
	 * @return
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 设置注解
	 * 
	 * @param comment
	 * @return
	 */
	public AbstractColumnContent setRemark(String remark) {
		this.remark = remark;
		return this;
	}

	/**
	 * 是否为无符号数值
	 * 
	 * @return
	 */
	public boolean isUnsigned() {
		return unsigned;
	}

	/**
	 * 设置是否为无符号数值
	 * 
	 * @param unsigned
	 * @return
	 */
	public AbstractColumnContent setUnsigned(boolean unsigned) {
		this.unsigned = unsigned;
		return this;
	}

	/**
	 * 列属性是否自增
	 * 
	 * @return
	 */
	public boolean isAutoIncrement() {
		return autoIncrement;
	}

	/**
	 * 设置列属性是否自增
	 * 
	 * @param autoIncrement
	 * @return
	 */
	public AbstractColumnContent setAutoIncrement(boolean autoIncrement) {
		this.autoIncrement = autoIncrement;
		return this;
	}

	/**
	 * 获得拓展属性
	 * 
	 * @return
	 */
	public Map<String, Object> getExtensions() {
		return extensions;
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
	public AbstractColumnContent addExtension(String key, Object value) {
		if (SdUtil.isNullOrEmpty(key)) {
			return this;
		}
		if (this.extensions == null) {
			this.extensions = new LinkedHashMap<String, Object>();
		}
		this.extensions.put(key, value);
		return this;
	}

	/**
	 * 设置附加属性
	 * 
	 * @param extensions
	 * @return
	 */
	public AbstractColumnContent setExtensions(Map<String, Object> extensions) {
		this.extensions = extensions;
		return this;
	}

	@Override
	public String toString() {
		return "AbstractColumnContent [name=" + name + ", type=" + type + ", length=" + length + ", default=" + _default + ", primary=" + primary + ", notNull=" + notNull + ", remark=" + remark
				+ ", unsigned=" + unsigned + ", autoIncrement=" + autoIncrement + ", extensions=" + extensions + "]";
	}

}
