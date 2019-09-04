package org.mirrentools.sd.converter.impl.postgresql;

import org.mirrentools.sd.converter.SdDatabaseContentConverter;
import org.mirrentools.sd.models.SdDatabase;
import org.mirrentools.sd.models.db.update.SdAbstractDatabaseContent;
import org.mirrentools.sd.models.db.update.impl.postgresql.SdDatabaseContentByPostgreSql;

/**
 * 将SdDatabase转换为数据库的操作属性PostgreSQL版实现
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class SdDatabaseConverterPostgreSqlImpl implements SdDatabaseContentConverter {
	@Override
	public SdAbstractDatabaseContent converter(SdDatabase database) {
		if (database == null) {
			return null;
		}
		return new SdDatabaseContentByPostgreSql(database);
	}

}
