package org.mirrentools.sd.converter.impl.db2;

import org.mirrentools.sd.converter.SdAbstractTableContentConverter;
import org.mirrentools.sd.models.SdBean;
import org.mirrentools.sd.models.SdColumn;
import org.mirrentools.sd.models.db.update.SdAbstractColumnContent;
import org.mirrentools.sd.models.db.update.SdAbstractConstraintContent;
import org.mirrentools.sd.models.db.update.SdAbstractForeignKeyContent;
import org.mirrentools.sd.models.db.update.SdAbstractIndexKeyContent;
import org.mirrentools.sd.models.db.update.SdAbstractPrimaryKeyContent;
import org.mirrentools.sd.models.db.update.SdAbstractTableContent;
import org.mirrentools.sd.models.db.update.impl.db2.SdConstraintContentByDB2;
import org.mirrentools.sd.models.db.update.impl.db2.SdTableContentByDB2;
import org.mirrentools.sd.models.db.update.impl.db2.SdColumnContentByDB2;
import org.mirrentools.sd.models.db.update.impl.db2.SdForeignKeyContentByDB2;
import org.mirrentools.sd.models.db.update.impl.db2.SdIndexKeyContentByDB2;
import org.mirrentools.sd.models.db.update.impl.db2.SdPrimaryKeyContentByDB2;
/**
 * 将SdBean转换为DB2数据库创建表需要的内容
 * 
 * @author <a href="http://mirrentools.org">Likangkang</a>
 *
 */
public class SdTableContentConverterDB2Impl extends SdAbstractTableContentConverter {

	@Override
	public SdAbstractTableContent newTableContent(SdBean bean) {
		SdTableContentByDB2 result = new SdTableContentByDB2();
		result.setTableName(bean.getName());
		result.setRemark(bean.getRemark());
		result.setCollate(super.getCollate());
		return result;
	}

	@Override
	public SdAbstractColumnContent newColumnContent(SdColumn col) {
		SdColumnContentByDB2 result = new SdColumnContentByDB2();
		result.setCollate(col.getCollate());
		return result;
	}

	@Override
	public SdAbstractPrimaryKeyContent newPrimaryKeyContent(SdColumn col) {
		return new SdPrimaryKeyContentByDB2();
	}

	@Override
	public SdAbstractIndexKeyContent newIndexKeyContent(SdColumn col) {
		return new SdIndexKeyContentByDB2();
	}

	@Override
	public SdAbstractForeignKeyContent newForeignKeyContent(SdColumn col) {
		return new SdForeignKeyContentByDB2();
	}

	@Override
	public SdAbstractConstraintContent newConstraintContent(SdColumn col) {
		// TODO Auto-generated method stub
		return new SdConstraintContentByDB2();
	}

}
