package org.mirrentools.sd.converter;

import org.mirrentools.sd.models.SdBean;
import org.mirrentools.sd.models.entity.Class;

/**
 * 将SdBean转换成类属性
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public interface SdBeanConverterToClass {
	/**
	 * 转换属性
	 * 
	 * @param bean
	 * @return
	 */
	Class converter(SdBean bean);
}
