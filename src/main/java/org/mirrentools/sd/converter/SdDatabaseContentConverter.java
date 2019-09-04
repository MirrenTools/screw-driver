package org.mirrentools.sd.converter;

import org.mirrentools.sd.models.SdDatabase;
import org.mirrentools.sd.models.db.update.SdAbstractDatabaseContent;

/**
 * 将SdDatabase转换为数据库的操作属性
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public interface SdDatabaseContentConverter {
	/**
	 * 转换属性
	 * 
	 * @param database
	 * @return
	 */
	SdAbstractDatabaseContent converter(SdDatabase database);
}
