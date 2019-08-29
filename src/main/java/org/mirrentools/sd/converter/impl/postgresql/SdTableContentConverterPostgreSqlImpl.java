package org.mirrentools.sd.converter.impl.postgresql;

import org.mirrentools.sd.converter.SdAbstractTableContentConverter;
import org.mirrentools.sd.models.SdBean;
import org.mirrentools.sd.models.SdColumn;
import org.mirrentools.sd.models.SdSequence;
import org.mirrentools.sd.models.db.update.SdAbstractColumnContent;
import org.mirrentools.sd.models.db.update.SdAbstractConstraintContent;
import org.mirrentools.sd.models.db.update.SdAbstractForeignKeyContent;
import org.mirrentools.sd.models.db.update.SdAbstractIndexKeyContent;
import org.mirrentools.sd.models.db.update.SdAbstractPrimaryKeyContent;
import org.mirrentools.sd.models.db.update.SdAbstractSequenceContent;
import org.mirrentools.sd.models.db.update.SdAbstractTableContent;
import org.mirrentools.sd.models.db.update.impl.postgresql.SdColumnContentByPostgreSQL;
import org.mirrentools.sd.models.db.update.impl.postgresql.SdConstraintContentByPostgreSQL;
import org.mirrentools.sd.models.db.update.impl.postgresql.SdForeignKeyContentByPostgreSQL;
import org.mirrentools.sd.models.db.update.impl.postgresql.SdIndexKeyContentByPostgreSQL;
import org.mirrentools.sd.models.db.update.impl.postgresql.SdPrimaryKeyContentByPostgreSQL;
import org.mirrentools.sd.models.db.update.impl.postgresql.SdSequenceContentByPostgreSQL;
import org.mirrentools.sd.models.db.update.impl.postgresql.SdTableContentByPostgreSQL;

/**
 * 将SdBean转换为PostgreSQL数据库创建表需要的内容
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class SdTableContentConverterPostgreSqlImpl extends SdAbstractTableContentConverter {

	@Override
	public SdAbstractTableContent newTableContent(SdBean bean) {
		SdTableContentByPostgreSQL result = new SdTableContentByPostgreSQL();
		if (super.getSchemas() != null) {
			result.setSchema(super.getSchemas());
		}
		return result;
	}

	@Override
	public SdAbstractColumnContent newColumnContent(SdColumn col) {
		return new SdColumnContentByPostgreSQL();
	}

	@Override
	public SdAbstractPrimaryKeyContent newPrimaryKeyContent(SdColumn col) {
		return new SdPrimaryKeyContentByPostgreSQL();
	}

	@Override
	public SdAbstractIndexKeyContent newIndexKeyContent(SdColumn col) {
		return new SdIndexKeyContentByPostgreSQL();
	}

	@Override
	public SdAbstractForeignKeyContent newForeignKeyContent(SdColumn col) {
		return new SdForeignKeyContentByPostgreSQL();
	}

	@Override
	public SdAbstractConstraintContent newConstraintContent(SdColumn col) {
		return new SdConstraintContentByPostgreSQL();
	}

	@Override
	public SdAbstractSequenceContent newSequenceContent(SdSequence sequence) {
		return new SdSequenceContentByPostgreSQL();
	}
}
