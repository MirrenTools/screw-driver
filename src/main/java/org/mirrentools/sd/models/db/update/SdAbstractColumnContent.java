package org.mirrentools.sd.models.db.update;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 抽象的数据库表操作类,用于做表的新建与修改
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public abstract class SdAbstractColumnContent {
	/** 列的名字 */
	private String name;
	/** 列的数据类型 */
	private String type;
	/** 列的长度 */
	private Integer length;
	/** 列的默认值 */
	private Object _default;
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
	 * 删除表的SQL语句
	 * 
	 * @return
	 */
	public abstract String deleteSQL();
	/**
	 * 转换拓展字段,该方法用户转换拓展字段,如果基础的getBasicSQL方法可以用但是需要用到拓展字段时可以重写该方法,给方法的内容如果不为空会被追加到最后
	 * 
	 * @return
	 */
	public String converterExtensions() {
		return null;
	}
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
	public SdAbstractColumnContent setName(String name) {
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
	public SdAbstractColumnContent setType(String type) {
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
	public SdAbstractColumnContent setLength(Integer length) {
		this.length = length;
		return this;
	}

	/**
	 * 获取默认值
	 * 
	 * @return
	 */
	public Object getDefault() {
		return _default;
	}

	/**
	 * 设置默认值
	 * 
	 * @param _default
	 * @return
	 */
	public SdAbstractColumnContent setDefault(Object _default) {
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
	public SdAbstractColumnContent setPrimary(boolean primary) {
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
	public SdAbstractColumnContent setNotNull(boolean notNull) {
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
	public SdAbstractColumnContent setRemark(String remark) {
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
	public SdAbstractColumnContent setUnsigned(boolean unsigned) {
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
	public SdAbstractColumnContent setAutoIncrement(boolean autoIncrement) {
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
		return getExtensions().get(key);
	}

	/**
	 * 添加附加属性
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public SdAbstractColumnContent addExtension(String key, Object value) {
		if (getExtensions() == null) {
			setExtensions(new LinkedHashMap<String, Object>());
		}
		getExtensions().put(key, value);
		return this;
	}

	/**
	 * 设置附加属性
	 * 
	 * @param extensions
	 * @return
	 */
	public SdAbstractColumnContent setExtensions(Map<String, Object> extensions) {
		this.extensions = extensions;
		return this;
	}

	@Override
	public String toString() {
		return "AbstractColumnContent [name=" + name + ", type=" + type + ", length=" + length + ", default=" + _default + ", primary="
				+ primary + ", notNull=" + notNull + ", remark=" + remark + ", unsigned=" + unsigned + ", autoIncrement=" + autoIncrement
				+ ", extensions=" + extensions + "]";
	}

}
