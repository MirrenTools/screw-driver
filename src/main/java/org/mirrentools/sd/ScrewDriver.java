package org.mirrentools.sd;

import java.util.Map;

import org.mirrentools.sd.util.SdCodeUtil;
import org.mirrentools.sd.util.SdProjectUtil;
import org.mirrentools.sd.util.SdSqlUtil;

/**
 * 生成工具的接口
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public interface ScrewDriver {

	/**
	 * 执行生成项目
	 * 
	 * @return
	 */
	boolean createProject();


	/**
	 * 执行生成代码
	 * 
	 * @return
	 */
	boolean createCode();

	/**
	 * 执行生成SQL
	 * 
	 * @return
	 */
	boolean createSQL();

	/**
	 * 获取项目生成工具
	 * 
	 * @return
	 */
	SdProjectUtil getProjectUtil();

	/**
	 * 设置项目生成工具
	 * 
	 * @param projectUtil
	 * @return
	 */
	ScrewDriver setProjectUtil(SdProjectUtil projectUtil);

	/**
	 * 获取代码生成工具
	 * 
	 * @return
	 */
	SdCodeUtil getCodeUtil();

	/**
	 * 设置代码生成工具
	 * 
	 * @param codeUtil
	 * @return
	 */
	ScrewDriver setCodeUtil(SdCodeUtil codeUtil);

	/**
	 * 获取SQL生成工具
	 * 
	 * @return
	 */
	SdSqlUtil getSqlUtil();

	/**
	 * 设置SQL生成工具
	 * 
	 * @param sqlUtil
	 * @return
	 */
	ScrewDriver setSqlUtil(SdSqlUtil sqlUtil);

	/**
	 * 添加附加属性
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	SdCodeUtil addExtension(String key, Object value);

	/**
	 * 获取附加属性集合
	 * 
	 * @return
	 */
	Map<String, Object> getExtensions();

	/**
	 * 设置附加属性集合
	 * 
	 * @param extensions
	 * @return
	 */
	SdCodeUtil setExtensions(Map<String, Object> extensions);


}
