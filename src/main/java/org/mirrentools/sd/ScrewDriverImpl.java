package org.mirrentools.sd;

import java.util.Map;

import org.mirrentools.sd.common.SdException;
import org.mirrentools.sd.util.SdCodeUtil;
import org.mirrentools.sd.util.SdProjectUtil;
import org.mirrentools.sd.util.SdSqlUtil;

/**
 * 生成工具的默认实现
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class ScrewDriverImpl implements ScrewDriver {
	/** 项目生成工具 */
	private SdProjectUtil projectUtil;
	/** 代码生成工具 */
	private SdCodeUtil codeUtil;
	/** 数据库生成工具 */
	private SdSqlUtil sqlUtil;

	/**
	 * 初始化一个生成工具
	 */
	public ScrewDriverImpl() {
		super();
	}

	/**
	 * 初始化一个带有代码生成工具
	 * 
	 * @param codeUtil
	 */
	public ScrewDriverImpl(SdCodeUtil codeUtil) {
		super();
		this.codeUtil = codeUtil;
	}

	/**
	 * 初始化一个带有数据库的生成工具
	 * 
	 * @param sqlUtil
	 */
	public ScrewDriverImpl(SdSqlUtil sqlUtil) {
		super();
		this.sqlUtil = sqlUtil;
	}

	/**
	 * 初始化一个带有代码加数据库的生成工具
	 * 
	 * @param codeUtil
	 * @param sqlUtil
	 */
	public ScrewDriverImpl(SdCodeUtil codeUtil, SdSqlUtil sqlUtil) {
		super();
		this.codeUtil = codeUtil;
		this.sqlUtil = sqlUtil;
	}

	/**
	 * 初始化一个带有项目加代码加数据库的生成工具
	 * 
	 * @param projectUtil
	 * @param codeUtil
	 * @param sqlUtil
	 */
	public ScrewDriverImpl(SdProjectUtil projectUtil, SdCodeUtil codeUtil, SdSqlUtil sqlUtil) {
		super();
		this.projectUtil = projectUtil;
		this.codeUtil = codeUtil;
		this.sqlUtil = sqlUtil;
	}

	@Override
	public boolean createProject() {
		if (projectUtil == null) {
			throw new NullPointerException("代码生成工具为空,可以创建一个SdProjectUtil实现并设置在该类中!");
		}
		return projectUtil.execute();
	}

	@Override
	public boolean createCode() {
		if (codeUtil == null) {
			throw new NullPointerException("代码生成工具为空,可以创建一个SdCodeUtil实现并设置在该类中!");
		}
		return codeUtil.execute();
	}

	@Override
	public boolean createSQL() {
		if (sqlUtil == null) {
			throw new NullPointerException("数据库生成工具为空,可以创建一个SdSQLUtil实现并设置在该类中!");
		}
		return sqlUtil.execute();
	}

	@Override
	public SdProjectUtil getProjectUtil() {
		return projectUtil;
	}

	@Override
	public ScrewDriverImpl setProjectUtil(SdProjectUtil projectUtil) {
		this.projectUtil = projectUtil;
		return this;
	}

	@Override
	public SdCodeUtil getCodeUtil() {
		return codeUtil;
	}

	@Override
	public ScrewDriverImpl setCodeUtil(SdCodeUtil codeUtil) {
		this.codeUtil = codeUtil;
		return this;
	}

	@Override
	public SdSqlUtil getSqlUtil() {
		return sqlUtil;
	}

	@Override
	public ScrewDriverImpl setSqlUtil(SdSqlUtil sqlUtil) {
		this.sqlUtil = sqlUtil;
		return this;
	}

	@Override
	public SdCodeUtil addExtension(String key, Object value) {
		throw new SdException("该方法为备用拓展字段,如果需要使用到该字段可以继承后重写");
	}

	@Override
	public Map<String, Object> getExtensions() {
		throw new SdException("该方法为备用拓展字段,如果需要使用到该字段可以继承后重写");
	}

	@Override
	public SdCodeUtil setExtensions(Map<String, Object> extensions) {
		throw new SdException("该方法为备用拓展字段,如果需要使用到该字段可以继承后重写");
	}

}
