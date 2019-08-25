package org.mirrentools.sd;

import org.mirrentools.sd.common.SdUtil;
import org.mirrentools.sd.impl.ScrewDriverCodeImpl;
import org.mirrentools.sd.impl.ScrewDriverSqlImpl;
import org.mirrentools.sd.options.ScrewDriverOptions;

/**
 * 螺丝刀核心类
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class ScrewDriver {
	// /** 项目工具 */
	// private ScrewDriverProject projectUtil;
	/** 代码工具 */
	private ScrewDriverCode codeUtil;
	/** 数据库工具 */
	private ScrewDriverSQL sqlUtil;

	/**
	 * 根据配置配置文件创建ScrewDriver
	 * 
	 * @param options
	 * @return
	 */
	public static ScrewDriver instance(ScrewDriverOptions options) {
		SdUtil.requireNonNull(options, "The ScrewDriverOptions cannot be null ,you can new ScrewDriver(db name)Options");
		return new ScrewDriver(options);
	}

	private ScrewDriver(ScrewDriverOptions options) {
		super();
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
	 * @return
	 */
	public boolean createCode() {
		return codeUtil.execute();
	}

	/**
	 * 生成SQL
	 * 
	 * @return
	 */
	public boolean createSQL() {
		return sqlUtil.execute();
	}

}
