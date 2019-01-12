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
	 * 设置SdBean
	 * 
	 * @param bean
	 */
	void setSdBean(SdBean bean);

	/**
	 * 将SdBean装换为类属性
	 * 
	 * @return
	 */
	Class toClass();

}
