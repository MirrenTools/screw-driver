package org.mirrentools.sd.impl;

import org.mirrentools.sd.ScrewDriver;
import org.mirrentools.sd.ScrewDriverCode;
import org.mirrentools.sd.ScrewDriverSQL;
import org.mirrentools.sd.common.SdUtil;
import org.mirrentools.sd.models.SdBean;
import org.mirrentools.sd.models.SdClassContent;
import org.mirrentools.sd.models.SdDatabase;
import org.mirrentools.sd.options.ScrewDriverOptions;

/**
 * 螺丝刀核心类
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class ScrewDriverImpl extends ScrewDriver {
	// /** 项目工具 */
	// private ScrewDriverProject projectUtil;
	/** 代码工具 */
	private ScrewDriverCode codeUtil;
	/** 数据库工具 */
	private ScrewDriverSQL sqlUtil;

	public ScrewDriverImpl(ScrewDriverOptions options) {
		SdUtil.requireNonNull(options, "The ScrewDriverOptions cannot be null , you can new ScrewDriverOptions");
		this.codeUtil = new ScrewDriverCodeImpl(options);
		this.sqlUtil = new ScrewDriverSqlImpl(options);
	}

	// /**
	// * 生成项目
	// *
	// * @return
	// */
	// public boolean createProject() {
	// return projectUtil.execute();
	// }

	/**
	 * 生成代码
	 * 
	 * @param bean
	 *          类或表属性的描述
	 * @return
	 */
	public boolean createCode(SdBean bean) {
		return codeUtil.execute(bean);
	}

	/**
	 * 生成代码
	 * 
	 * @param classContent
	 *          类属性的描述
	 * @return
	 */
	public boolean createCode(SdClassContent classContent) {
		return codeUtil.execute(classContent);
	}

	/**
	 * 创建数据库
	 * 
	 * @param database
	 *          数据库属性描述
	 * @return
	 */
	public boolean createDatabase(SdDatabase database) {
		return sqlUtil.createDatabase(database);
	}

	/**
	 * 创建表
	 * 
	 * @param bean
	 *          表属性的描述
	 * @return
	 */
	public boolean createTable(SdBean bean) {
		return sqlUtil.createTable(bean);
	}

	/**
	 * 修改表
	 * 
	 * @param bean
	 *          表属性的描述
	 * @return
	 */
	public boolean updateTable(SdBean bean) {
		return sqlUtil.alterTable(bean);
	}

	/**
	 * 删除表
	 * 
	 * @param bean
	 *          表属性的描述
	 * @return
	 */
	public boolean deleteTable(SdBean bean) {
		return sqlUtil.deleteTable(bean);
	}

}
