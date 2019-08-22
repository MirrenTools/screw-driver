package org.mirrentools.sd.models.db.update;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 表的约束属性,用于新建与修改<br>
 * 属性的顺序为:tdName>type>name>exp
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public abstract class SdAbstractConstraintContent {
	/** 约束的类型 */
	private String type;
	/** 约束的名称 */
	private String name;
	/** 约束的表达式,比如: id > 10 */
	private String exp;
	/** 要删除的约束名 */
	private String removeConstraint;
	/** 拓展属性 */
	private Map<String, Object> extensions;

	/**
	 * 创建的SQL语句
	 * 
	 * @return
	 */
	public abstract String createSQL();

	/**
	 * 修改的SQL语句
	 * 
	 * @return
	 */
	public abstract String updateSQL();

	/**
	 * 删除的SQL语句,如果getRemoveIndexName==null返回null
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
	 * 获取索引类型
	 * 
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * 设置索引类型
	 * 
	 * @param type
	 */
	public SdAbstractConstraintContent setType(String type) {
		this.type = type;
		return this;
	}

	/**
	 * 获取索引名字
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置索引名字
	 * 
	 * @param name
	 */
	public SdAbstractConstraintContent setName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * 获取表达式
	 * 
	 * @return
	 */
	public String getExp() {
		return exp;
	}

	/**
	 * 设置约束的表达式,比如: id > 10
	 * 
	 * @param exp
	 * @return
	 */
	public SdAbstractConstraintContent setExp(String exp) {
		this.exp = exp;
		return this;
	}

	/**
	 * 获取要删除的约束名
	 * 
	 * @return
	 */
	public String getRemoveConstraint() {
		return removeConstraint;
	}

	/**
	 * 设置要删除的要删除的约束名
	 * 
	 * @param removeConstraint
	 * @return
	 */
	public SdAbstractConstraintContent setRemoveConstraint(String removeConstraint) {
		this.removeConstraint = removeConstraint;
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
	public SdAbstractConstraintContent addExtension(String key, Object value) {
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
	public SdAbstractConstraintContent setExtensions(Map<String, Object> extensions) {
		this.extensions = extensions;
		return this;
	}

	@Override
	public String toString() {
		return "SdAbstractConstraintContent [type=" + type + ", name=" + name + ", exp=" + exp + ", extensions=" + extensions + "]";
	}

}
