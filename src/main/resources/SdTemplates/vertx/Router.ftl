package ${content.items.router.packageName};
<#assign assign_ClassName = content.items.router.className>
<#assign assign_ServiceName = content.items.service.className>
import ${content.items.service.packageName}.${content.items.service.className};

import io.vertx.core.MultiMap;
import io.vertx.core.http.HttpHeaders;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import io.vertx.jdbcclient.JDBCPool;
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

	private ${assign_ClassName}(SQLExecute<JDBCPool> execute) {
		super();
		this.service = ${assign_ServiceName}.create(execute);
	}

	/**
	 * 启动服务
	 * 
	 * @param router
	 *          Router
	 * @param execute
	 *          数据执行器
	 */
	public static void startService(Router router, SQLExecute<JDBCPool> execute) {
		${assign_ClassName} instance = new ${assign_ClassName}(execute);
		<#assign assign_EntityLowerName = content.items.entity.lowerName >
		// 获取所有数据
		router.get("/${assign_EntityLowerName}/find").handler(instance::find);
		// 获取分页数据
		router.get("/${assign_EntityLowerName}/limit").handler(instance::limit);
		// 新增数据
		router.post("/${assign_EntityLowerName}/save").handler(instance::save);
		<#if content.content.primaryField??>
		// 获取指定数据
		router.get("/${assign_EntityLowerName}/get").handler(instance::get);
		// 更新数据
		router.post("/${assign_EntityLowerName}/update").handler(instance::update);
		// 更新数据
		router.post("/${assign_EntityLowerName}/delete").handler(instance::delete);
		</#if>
	}

	private void find(RoutingContext rct) {
		MultiMap params = rct.request().params();
		if (LOG.isDebugEnabled()) {
			LOG.debug("执行获取数据[${assign_ServiceName}.find]-->请求参数:\n" + params);
		}
		service.find(params, res -> {
			rct.response().putHeader(HttpHeaders.CONTENT_TYPE, "application/json; charset=utf-8").end(res.result().toBuffer());
		});
	}

	private void limit(RoutingContext rct) {
		MultiMap params = rct.request().params();
		if (LOG.isDebugEnabled()) {
			LOG.debug("执行获取数据[${assign_ServiceName}.limit]-->请求参数:\n" + params);
		}
		service.limit(params, res -> {
			rct.response().putHeader(HttpHeaders.CONTENT_TYPE, "application/json; charset=utf-8").end(res.result().toBuffer());
		});
	}

	private void save(RoutingContext rct) {
		MultiMap params = rct.request().params();
		if (LOG.isDebugEnabled()) {
			LOG.debug("执行新增数据[${assign_ServiceName}.save]-->请求参数:\n" + params);
		}
		service.save(params, res -> {
			rct.response().putHeader(HttpHeaders.CONTENT_TYPE, "application/json; charset=utf-8").end(res.result().toBuffer());
		});
	}
	<#if content.content.primaryField??>
	
	private void get(RoutingContext rct) {
		MultiMap params = rct.request().params();
		if (LOG.isDebugEnabled()) {
			LOG.debug("执行获取数据[${assign_ServiceName}.get]-->请求参数:\n" + params);
		}
		service.get(params, res -> {
			rct.response().putHeader(HttpHeaders.CONTENT_TYPE, "application/json; charset=utf-8").end(res.result().toBuffer());
		});
	}

	private void update(RoutingContext rct) {
		MultiMap params = rct.request().params();
		if (LOG.isDebugEnabled()) {
			LOG.debug("执行更新数据[${assign_ServiceName}.update]-->请求参数:\n" + params);
		}
		service.update(params, res -> {
			rct.response().putHeader(HttpHeaders.CONTENT_TYPE, "application/json; charset=utf-8").end(res.result().toBuffer());
		});
	}
	
	private void delete(RoutingContext rct) {
		MultiMap params = rct.request().params();
		if (LOG.isDebugEnabled()) {
			LOG.debug("执行删除数据[${assign_ServiceName}.delete]-->请求参数:\n" + params);
		}
		service.delete(params, res -> {
			rct.response().putHeader(HttpHeaders.CONTENT_TYPE, "application/json; charset=utf-8").end(res.result().toBuffer());
		});
	}
	</#if>
}
