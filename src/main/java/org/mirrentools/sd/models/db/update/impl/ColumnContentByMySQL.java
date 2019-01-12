package org.mirrentools.sd.models.db.update.impl;

import org.mirrentools.sd.models.db.update.AbstractColumnContent;

/**
 * 数据列属性的MySQL实现
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public class ColumnContentByMySQL extends AbstractColumnContent {
	/** 字符排序 */
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

	public String getCollate() {
		return collate;
	}
	public ColumnContentByMySQL setCollate(String collate) {
		this.collate = collate;
		return this;
	}

}
