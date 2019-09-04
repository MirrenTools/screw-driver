package org.mirrentools.sd.converter.impl.mysql;

import org.mirrentools.sd.converter.SdDatabaseContentConverter;
import org.mirrentools.sd.models.SdDatabase;
import org.mirrentools.sd.models.db.update.SdAbstractDatabaseContent;
import org.mirrentools.sd.models.db.update.impl.mysql.SdDatabaseContentByMySQL;

/**
 * 将SdDatabase转换为数据库的操作属性MySQL版实现
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class SdDatabaseConverterMySqlImpl implements SdDatabaseContentConverter {
	@Override
	public SdAbstractDatabaseContent converter(SdDatabase database) {
		if (database == null) {
			return null;
		}
		return new SdDatabaseContentByMySQL(database.getDatabase(), database.getEncoding(), database.getCollate()).setExtensions(database.getExtensions());
	}

}
