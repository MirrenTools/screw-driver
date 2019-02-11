package org.mirrentools.sd.models.db.update;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 抽象数据库属性用于做为数据库的创建与修改使用,需要继承该类后重写sql方法
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public abstract class SdAbstractDatabaseContent {
	/** 数据库的名字 */
	private String databaseName;
	/** 拓展属性 */
	private Map<String, Object> extensions;

	public SdAbstractDatabaseContent(String databaseName) {
		super();
		this.databaseName = databaseName;
	}

	/**
	 * 新增数据库的语句
	 * 
	 * @return
	 */
	public abstract String createSQL();

	/**
	 * 更新数据库的语句
	 * 
	 * @return
	 * @throws UnsupportedOperationException
	 *           如果数据库不支持或者没有实现则抛出该异常
	 */
	public abstract String updateSQL() throws UnsupportedOperationException;
	/**
	 * 删除数据库的语句
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
	 * 获取数据库的名字
	 * 
	 * @return
	 */
	public String getDatabaseName() {
		return databaseName;
	}

	/**
	 * 设置数据库的名字
	 * 
	 * @param databaseName
	 */
	public SdAbstractDatabaseContent setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
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
	public SdAbstractDatabaseContent addExtension(String key, Object value) {
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
	public SdAbstractDatabaseContent setExtensions(Map<String, Object> extensions) {
		this.extensions = extensions;
		return this;
	}

	@Override
	public String toString() {
		return "AbstractDatabaseContent [databaseName=" + databaseName + ", extensions=" + extensions + "]";
	}

}
