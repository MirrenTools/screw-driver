package org.mirrentools.sd.converter;

import org.mirrentools.sd.models.SdBean;
import org.mirrentools.sd.models.db.update.AbstractTableContent;

/**
 * 将SdBean转换为数据库操作属性
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public interface SdBeanConverterToTableContent {
	/**
	 * 设置SdBean
	 * 
	 * @param bean
	 */
	void setSdBean(SdBean bean);

	/**
	 * 将SdBean转换为数据库操作属性
	 * 
	 * @return
	 */
	AbstractTableContent toTableContent();

}
