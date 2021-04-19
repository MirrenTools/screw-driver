package ${content.items.service.packageName};

import ${content.items.serviceImpl.packageName}.${content.items.serviceImpl.className};

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.MultiMap;
import io.vertx.core.json.JsonObject;
import io.vertx.jdbcclient.JDBCPool;
import io.vertx.ext.sql.assist.SQLExecute;

/**
 * ${content.items.entity.className}数据服务接口
 * 
 * @author 
 *
 */
public interface ${content.items.service.className} {
	/**
	 * 创建一个实例
	 * 
	 * @param execute
	 * @return
	 */
	static ${content.items.service.className} create(SQLExecute<JDBCPool> execute) {
		return new ${content.items.serviceImpl.className}(execute);
	}

	/**
	 * 获取所有数据
	 * 
	 * @param params 请求参数
	 * @param handler 响应结果
	 */
	//void empty(MultiMap params, Handler<AsyncResult<JsonObject>> handler);
}
