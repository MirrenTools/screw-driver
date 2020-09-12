package org.mirrentools.sd.impl;

import java.util.Map;

import org.mirrentools.sd.ScrewDriver;
import org.mirrentools.sd.ScrewDriverCode;
import org.mirrentools.sd.ScrewDriverSQL;
import org.mirrentools.sd.common.SdUtil;
import org.mirrentools.sd.models.SdBean;
import org.mirrentools.sd.models.SdClassContent;
import org.mirrentools.sd.models.SdDatabase;
import org.mirrentools.sd.models.SdTemplate;
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

	/**
	 * 用过配置文件初始化ScrewDriver的默认实现
	 * 
	 * @param options
	 */
	public ScrewDriverImpl(ScrewDriverOptions options) {
		SdUtil.requireNonNull(options, "The ScrewDriverOptions cannot be null , you can new ScrewDriverOptions");
		this.codeUtil = new ScrewDriverCodeImpl(options);
		this.sqlUtil = new ScrewDriverSqlImpl(options);
	}

	// @Override
	// public boolean createProject() {
	// return projectUtil.execute();
	// }

	@Override
	public boolean createCode(SdBean bean, Map<String, SdTemplate> templateMaps) {
		return codeUtil.execute(bean, templateMaps);
	}

	@Override
	public boolean createCode(SdClassContent classContent, Map<String, SdTemplate> templateMaps) {
		return codeUtil.execute(classContent, templateMaps);
	}

	@Override
	public boolean createDatabase(SdDatabase database) {
		return sqlUtil.createDatabase(database);
	}

	@Override
	public boolean createTable(SdBean bean) {
		return sqlUtil.createTable(bean);
	}

	@Override
	public SdClassContent readTable(String tableName) {
		return sqlUtil.readTable(tableName);
	}

	@Override
	public boolean updateTable(SdBean bean) {
		return sqlUtil.alterTable(bean);
	}

	@Override
	public boolean deleteTable(SdBean bean) {
		return sqlUtil.deleteTable(bean);
	}

}
