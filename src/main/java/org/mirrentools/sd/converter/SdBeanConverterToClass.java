package org.mirrentools.sd.converter;

import org.mirrentools.sd.models.SdBean;
import org.mirrentools.sd.models.SdClassContent;

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
	SdClassContent converter(SdBean bean);
}
