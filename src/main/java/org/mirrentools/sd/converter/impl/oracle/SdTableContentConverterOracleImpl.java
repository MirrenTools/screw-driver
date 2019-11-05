package org.mirrentools.sd.converter.impl.oracle;

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
import org.mirrentools.sd.models.db.update.impl.oracle.SdConstraintContentByOracle;
import org.mirrentools.sd.models.db.update.impl.oracle.SdTableContentByOracle;
import org.mirrentools.sd.models.db.update.impl.oracle.SdColumnContentByOracle;
import org.mirrentools.sd.models.db.update.impl.oracle.SdForeignKeyContentByOracle;
import org.mirrentools.sd.models.db.update.impl.oracle.SdIndexKeyContentByOracle;
import org.mirrentools.sd.models.db.update.impl.oracle.SdPrimaryKeyContentByOracle;
import org.mirrentools.sd.models.db.update.impl.oracle.SdSequenceContentByOracle;

/**
 * 将SdBean转换为Oracle数据库创建表需要的内容
 * 
 * @author <a href="http://mirrentools.org">Likangkang</a>
 *
 */
public class SdTableContentConverterOracleImpl extends SdAbstractTableContentConverter {

	public SdTableContentConverterOracleImpl() {
		super(new SdBasicTypeConverter("ScrewDriver UNKNOWN TYPE", SdType.getDictionary(SdTypeMode.ORACLE)));
	}

	public SdTableContentConverterOracleImpl(SdTypeConverter typeConverter) {
		super(typeConverter);
	}

	@Override
	public SdAbstractTableContent newTableContent(SdBean bean) {
		SdTableContentByOracle result = new SdTableContentByOracle();
		result.setTableName(bean.getName());
		result.setRemark(bean.getRemark());
		result.setCollate(super.getCollate());
		return result;
	}

	@Override
	public SdAbstractColumnContent newColumnContent(SdColumn col) {
		SdColumnContentByOracle result = new SdColumnContentByOracle();
		result.setCollate(col.getCollate());
		return result;
	}

	@Override
	public SdAbstractPrimaryKeyContent newPrimaryKeyContent(SdColumn col) {
		return new SdPrimaryKeyContentByOracle();
	}

	@Override
	public SdAbstractIndexKeyContent newIndexKeyContent(SdColumn col) {
		return new SdIndexKeyContentByOracle();
	}

	@Override
	public SdAbstractForeignKeyContent newForeignKeyContent(SdColumn col) {
		return new SdForeignKeyContentByOracle();
	}

	@Override
	public SdAbstractConstraintContent newConstraintContent(SdColumn col) {
		return new SdConstraintContentByOracle();
	}

	@Override
	public SdAbstractSequenceContent newSequenceContent(SdSequence sequence) {
		return new SdSequenceContentByOracle();
	}

}
