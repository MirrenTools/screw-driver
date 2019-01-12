package org.mirrentools.sd.models.db.update.impl;

import org.mirrentools.sd.models.db.update.AbstractTableContent;

/**
 * 数据库表属性创建或者修改SQL语句的MySQL实现
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public class TableContentByMySQL extends AbstractTableContent {
	/** 字符集 */
	private String charset;
	/** 核对 */
	private String collate;

	@Override
	public String createSQL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateSQL() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 获取字符集
	 * 
	 * @return
	 */
	public String getCharset() {
		return charset;
	}

	/**
	 * 设置字符集
	 * 
	 * @param charset
	 */
	public void setCharset(String charset) {
		this.charset = charset;
	}

	/**
	 * 获取字符集核对
	 * 
	 * @return
	 */
	public String getCollate() {
		return collate;
	}

	/**
	 * 设置字符集核对
	 * 
	 * @param collate
	 */
	public void setCollate(String collate) {
		this.collate = collate;
	}

	@Override
	public String toString() {
		return super.toString() + "\nTableContentMySQL [charset=" + charset + ", collate=" + collate + "]";
	}

}
