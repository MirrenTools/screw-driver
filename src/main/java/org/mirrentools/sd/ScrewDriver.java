package org.mirrentools.sd;

import org.mirrentools.sd.impl.ScrewDriverImpl;
import org.mirrentools.sd.models.SdBean;
import org.mirrentools.sd.models.SdClassContent;
import org.mirrentools.sd.models.SdDatabase;
import org.mirrentools.sd.options.ScrewDriverOptions;

/**
 * ScrewDriver的核心,用于生成代码与数据库操作
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public abstract class ScrewDriver {

	/**
	 * 根据配置文件实例化ScrewDriver
	 * 
	 * @param options
	 * @return
	 */
	public static ScrewDriver instance(ScrewDriverOptions options) {
		return new ScrewDriverImpl(options);
	}

	// /**
	// * 生成项目
	// *
	// * @return
	// */
	// public abstract boolean createProject();

	/**
	 * 生成代码
	 * 
	 * @param bean
	 *          类或表属性的描述
	 * @return
	 */
	public abstract boolean createCode(SdBean bean);

	/**
	 * 生成代码
	 * 
	 * @param classContent
	 *          类属性的描述
	 * @return
	 */
	public abstract boolean createCode(SdClassContent classContent);

	/**
	 * 创建数据库
	 * 
	 * @param database
	 *          数据库属性描述
	 * @return
	 */
	public abstract boolean createDatabase(SdDatabase database);

	/**
	 * 创建表
	 * 
	 * @param bean
	 *          表属性的描述
	 * @return
	 */
	public abstract boolean createTable(SdBean bean);

	/**
	 * 修改表
	 * 
	 * @param bean
	 *          表属性的描述
	 * @return
	 */
	public abstract boolean updateTable(SdBean bean);

	/**
	 * 删除表
	 * 
	 * @param bean
	 *          表属性的描述
	 * @return
	 */
	public abstract boolean deleteTable(SdBean bean);

}
