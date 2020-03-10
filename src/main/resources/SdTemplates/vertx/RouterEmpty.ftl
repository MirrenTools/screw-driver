package ${content.items.router.packageName};
<#assign assign_ClassName = content.items.router.className>
<#assign assign_ServiceName = content.items.service.className>
import ${content.items.service.packageName}.${content.items.service.className};

import io.vertx.core.MultiMap;
import io.vertx.core.http.HttpHeaders;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.jdbc.JDBCClient;
import io.vertx.ext.sql.assist.SQLExecute;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

/**
 * ${content.items.entity.className}的接口服务
 * 
 * @author 
 *
 */
public class ${assign_ClassName} {
	/** 日志工具 */
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	/** 数据服务接口 */
	private ${assign_ServiceName} service;

	private ${assign_ClassName}(${assign_ServiceName} service) {
		super();
		this.service = service;
	}

	/**
	 * 启动服务
	 * 
	 * @param router
	 *          Router
	 * @param execute
	 *          数据执行器
	 */
	public static void startService(Router router, SQLExecute<JDBCClient> execute) {
		${assign_ClassName} instance = new ${assign_ClassName}(${assign_ServiceName}.create(execute));
		// 获取所有数据
		router.get("").handler(instance::empty);

	}

	private void empty(RoutingContext rct) {
		MultiMap params = rct.request().params();
		if (LOG.isDebugEnabled()) {
			LOG.debug("执行获取数据[${assign_ServiceName}.find]-->请求参数:\n" + params);
		}
		//service.empty(params, res -> {
		//	rct.response().putHeader(HttpHeaders.CONTENT_TYPE, "application/json; charset=utf-8").end(res.result().toBuffer());
		//});
	}
}
