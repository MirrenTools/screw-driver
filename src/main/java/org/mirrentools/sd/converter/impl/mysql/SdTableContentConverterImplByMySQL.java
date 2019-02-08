package org.mirrentools.sd.converter.impl.mysql;

import org.mirrentools.sd.converter.SdAbstractTableContentConverter;
import org.mirrentools.sd.models.SdBean;
import org.mirrentools.sd.models.SdColumn;
import org.mirrentools.sd.models.db.update.SdAbstractColumnContent;
import org.mirrentools.sd.models.db.update.SdAbstractForeignKeyContent;
import org.mirrentools.sd.models.db.update.SdAbstractIndexKeyContent;
import org.mirrentools.sd.models.db.update.SdAbstractPrimaryKeyContent;
import org.mirrentools.sd.models.db.update.SdAbstractTableContent;
import org.mirrentools.sd.models.db.update.impl.mysql.SdColumnContentByMySQL;
import org.mirrentools.sd.models.db.update.impl.mysql.SdForeignKeyContentByMySQL;
import org.mirrentools.sd.models.db.update.impl.mysql.SdIndexKeyContentByMySQL;
import org.mirrentools.sd.models.db.update.impl.mysql.SdPrimaryKeyContentByMySQL;
import org.mirrentools.sd.models.db.update.impl.mysql.SdTableContentByMySQL;

/**
 * 将SdBean转换为MySQL数据库创建表需要的内容
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class SdTableContentConverterImplByMySQL extends SdAbstractTableContentConverter {

	@Override
	public SdAbstractTableContent newTableContent(SdBean bean) {
		SdTableContentByMySQL result = new SdTableContentByMySQL();
		result.setTableName(bean.getName());
		result.setRemark(bean.getRemark());
		result.setCharset(super.getCharacterSet());
		result.setCollate(super.getCollate());
		return result;
	}

	@Override
	public SdAbstractColumnContent newColumnContent(SdColumn col) {
		SdColumnContentByMySQL result = new SdColumnContentByMySQL();
		result.setCollate(col.getCollate());
		return result;
	}

	@Override
	public SdAbstractPrimaryKeyContent newPrimaryKeyContent(SdColumn col) {
		return new SdPrimaryKeyContentByMySQL();
	}

	@Override
	public SdAbstractIndexKeyContent newIndexKeyContent(SdColumn col) {
		return new SdIndexKeyContentByMySQL();
	}

	@Override
	public SdAbstractForeignKeyContent newForeignKeyContent(SdColumn col) {
		return new SdForeignKeyContentByMySQL();
	}

}
