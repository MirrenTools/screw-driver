package org.mirrentools.sd.converter.impl.sqlite;

import org.mirrentools.sd.SdType;
import org.mirrentools.sd.converter.SdAbstractTableContentConverter;
import org.mirrentools.sd.converter.SdBasicTypeConverter;
import org.mirrentools.sd.converter.SdTypeConverter;
import org.mirrentools.sd.enums.SdTypeMode;
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
import org.mirrentools.sd.models.db.update.impl.sqlite.SdColumnContentBySqlite;
import org.mirrentools.sd.models.db.update.impl.sqlite.SdConstraintContentBySqlite;
import org.mirrentools.sd.models.db.update.impl.sqlite.SdForeignKeyContentBySqlite;
import org.mirrentools.sd.models.db.update.impl.sqlite.SdIndexKeyContentBySqlite;
import org.mirrentools.sd.models.db.update.impl.sqlite.SdPrimaryKeyContentBySqlite;
import org.mirrentools.sd.models.db.update.impl.sqlite.SdTableContentBySqlite;

/**
 * 将SdBean转换为SQLite数据库创建表需要的内容
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class SdTableContentConverterSqliteImpl extends SdAbstractTableContentConverter {

	public SdTableContentConverterSqliteImpl() {
		super(new SdBasicTypeConverter("ScrewDriver UNKNOWN TYPE", SdType.getDictionary(SdTypeMode.SQLITE)));
	}

	public SdTableContentConverterSqliteImpl(SdTypeConverter typeConverter) {
		super(typeConverter);
	}

	@Override
	public SdAbstractTableContent newTableContent(SdBean bean) {
		return new SdTableContentBySqlite();
	}

	@Override
	public SdAbstractColumnContent newColumnContent(SdColumn col) {
		return new SdColumnContentBySqlite();
	}

	@Override
	public SdAbstractPrimaryKeyContent newPrimaryKeyContent(SdColumn col) {
		return new SdPrimaryKeyContentBySqlite();
	}

	@Override
	public SdAbstractIndexKeyContent newIndexKeyContent(SdColumn col) {
		return new SdIndexKeyContentBySqlite();
	}

	@Override
	public SdAbstractForeignKeyContent newForeignKeyContent(SdColumn col) {
		return new SdForeignKeyContentBySqlite();
	}

	@Override
	public SdAbstractConstraintContent newConstraintContent(SdColumn col) {
		return new SdConstraintContentBySqlite();
	}

	@Override
	public SdAbstractSequenceContent newSequenceContent(SdSequence sequence) {
		return null;
	}
}
