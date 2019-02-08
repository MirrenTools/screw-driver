package org.mirrentools.sd.models.db.update.impl.mysql;

import org.mirrentools.sd.models.db.update.SdAbstractColumnContent;

/**
 * 数据列属性的MySQL实现
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public class SdColumnContentByMySQL extends SdAbstractColumnContent {
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
	public SdColumnContentByMySQL setCollate(String collate) {
		this.collate = collate;
		return this;
	}

}
