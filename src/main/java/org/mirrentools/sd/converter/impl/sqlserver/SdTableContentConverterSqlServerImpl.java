package org.mirrentools.sd.converter.impl.sqlserver;

import org.mirrentools.sd.constant.SdType;
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
import org.mirrentools.sd.models.db.update.impl.sqlserver.SdColumnContentBySqlServer;
import org.mirrentools.sd.models.db.update.impl.sqlserver.SdConstraintContentBySqlServer;
import org.mirrentools.sd.models.db.update.impl.sqlserver.SdForeignKeyContentBySqlServer;
import org.mirrentools.sd.models.db.update.impl.sqlserver.SdIndexKeyContentBySqlServer;
import org.mirrentools.sd.models.db.update.impl.sqlserver.SdPrimaryKeyContentBySqlServer;
import org.mirrentools.sd.models.db.update.impl.sqlserver.SdTableContentBySqlServer;

/**
 * 将SdBean转换为SQL Server数据库创建表需要的内容
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class SdTableContentConverterSqlServerImpl extends SdAbstractTableContentConverter {

	public SdTableContentConverterSqlServerImpl() {
		super(new SdBasicTypeConverter("ScrewDriver UNKNOWN TYPE", SdType.getDictionary(SdTypeMode.SQL_SERVER)));
	}

	public SdTableContentConverterSqlServerImpl(SdTypeConverter typeConverter) {
		super(typeConverter);
	}

	@Override
	public SdAbstractTableContent newTableContent(SdBean bean) {
		SdTableContentBySqlServer result = new SdTableContentBySqlServer();
		if (super.getSchemas() != null) {
			result.setSchema(super.getSchemas());
		}
		return result;
	}

	@Override
	public SdAbstractColumnContent newColumnContent(SdColumn col) {
		return new SdColumnContentBySqlServer();
	}

	@Override
	public SdAbstractPrimaryKeyContent newPrimaryKeyContent(SdColumn col) {
		return new SdPrimaryKeyContentBySqlServer();
	}

	@Override
	public SdAbstractIndexKeyContent newIndexKeyContent(SdColumn col) {
		return new SdIndexKeyContentBySqlServer();
	}

	@Override
	public SdAbstractForeignKeyContent newForeignKeyContent(SdColumn col) {
		return new SdForeignKeyContentBySqlServer();
	}

	@Override
	public SdAbstractConstraintContent newConstraintContent(SdColumn col) {
		return new SdConstraintContentBySqlServer();
	}

	@Override
	public SdAbstractSequenceContent newSequenceContent(SdSequence sequence) {
		return null;
	}
}
