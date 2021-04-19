package ${content.items.serviceImpl.packageName};
<#assign assign_ClassName = content.items.serviceImpl.className>
<#assign assign_EntityName = content.items.entity.className>
<#assign assign_SqlName = content.items.sql.camelName>


import ${content.items.service.packageName}.${content.items.service.className};
import ${content.items.sql.packageName}.${content.items.sql.className};

import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import io.vertx.jdbcclient.JDBCPool;
import io.vertx.ext.sql.assist.SQLExecute;

/**
 * ${content.items.entity.className}数据服务接口的默认实现
 * 
 * @author 
 *
 */
public class ${assign_ClassName} implements ${content.items.service.className} {
	/** 日志工具 */
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	/** SQL操作语句 */
	private ${content.items.sql.className} ${assign_SqlName};

	/**
	 * 初始化
	 * 
	 * @param execute SQL执行器
	 */
	public ${assign_ClassName}(SQLExecute<JDBCPool> execute) {
		super();
		this.${assign_SqlName}= new ${content.items.sql.className}(execute);
	}

}
