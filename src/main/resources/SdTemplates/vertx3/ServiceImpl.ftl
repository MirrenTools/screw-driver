package ${content.items.serviceImpl.packageName};
<#assign assign_ClassName = content.items.serviceImpl.className>
<#assign assign_EntityName = content.items.entity.className>
<#assign assign_SqlName = content.items.sql.camelName>

import java.util.ArrayList;
import java.util.List;

import ${content.items.service.packageName}.${content.items.service.className};
import ${content.items.sql.packageName}.${content.items.sql.className};
import ${content.items.entity.packageName}.${content.items.entity.className};

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.MultiMap;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.jdbc.JDBCClient;
import io.vertx.ext.sql.assist.SQLExecute;
import io.vertx.ext.sql.assist.SqlAssist;

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
	 * @param execute
	 */
	public ${assign_ClassName}(SQLExecute<JDBCClient> execute) {
		super();
		this.${assign_SqlName}= new ${content.items.sql.className}(execute);
	}

	@Override
	public void find(MultiMap params, Handler<AsyncResult<JsonObject>> handler) {
		${assign_SqlName}.selectAll(res -> {
			if (res.succeeded()) {
				List<JsonObject> result = res.result() == null ? new ArrayList<>() : res.result();
				if (LOG.isDebugEnabled()) {
					LOG.debug("执行获取数据[${assign_ClassName}.find]-->成功:" + result);
				}
				handler.handle(formatSuccess(result));
			} else {
				LOG.error("执行获取数据[${assign_ClassName}.find]-->失败:", res.cause());
				handler.handle(formatFailure(500, "获取数据失败,请稍后重试!", "获取数据失败,请联系管理员!", null));
			}
		});
	}
	
	@Override
	public void limit(MultiMap params, Handler<AsyncResult<JsonObject>> handler) {
		Integer page = getInteger(params.get("page"), 1);
		Integer rowSize = getInteger(params.get("rowSize"), 15);
		SqlAssist assist = new SqlAssist();
		assist.setPage(page).setRowSize(rowSize);
		${assign_SqlName}.limitAll(assist, res -> {
			if (res.succeeded()) {
				JsonObject result = res.result();
				if (LOG.isDebugEnabled()) {
					LOG.debug("执行获取数据[${assign_ClassName}.limit]-->成功:" + result);
				}
				handler.handle(formatSuccess(result));
			} else {
				LOG.error("执行获取数据[${assign_ClassName}.limit]-->失败:", res.cause());
				handler.handle(formatFailure(500, "获取数据失败,请稍后重试!", "获取数据失败,请联系管理员!", null));
			}
		});
	}
	@Override
	public void save(MultiMap params, Handler<AsyncResult<JsonObject>> handler) {
		try {
			${assign_EntityName} data = new ${assign_EntityName}(params);
			<#if content.content.cantNullField??>
			if (<#list content.content.cantNullField as cnf>data.get${cnf.fieldNamePascal}() == null <#if cnf?has_next> && </#if></#list>) {
				handler.handle(formatFailure(412, "新增数据失败,缺少必填的数据!", "缺少必填项参数", 0));
				return;
			}
			</#if>
			${assign_SqlName}.insertNonEmpty(data, res -> {
				if (res.succeeded()) {
					int result = res.result();
					if (LOG.isDebugEnabled()) {
						LOG.debug("执行新增数据[${assign_ClassName}.save]-->成功:" + result);
					}
					handler.handle(formatSuccess(result));
				} else {
					LOG.error("执行新增数据[${assign_ClassName}.save]-->失败:", res.cause());
					handler.handle(formatFailure(500, "新增失败,请稍后重试!", "获取数据失败,请联系管理员!", 0));
				}
			});
		} catch (Exception e) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("执行新增数据[${assign_ClassName}.save]-->失败:", e);
			}
			handler.handle(formatFailure(413, "新增失败,存在无效的数据!", e.getMessage(), 0));
		}
	}
	
	<#if content.content.primaryField??>
	<#assign assign_fieldType = content.content.primaryField[0].fieldType>
	<#assign assign_fieldName = content.content.primaryField[0].fieldName>
	<#assign assign_fieldPascalName = content.content.primaryField[0].fieldNamePascal>
	@Override
	public void get(MultiMap params, Handler<AsyncResult<JsonObject>> handler) {
		<#if assign_fieldType  ==  "Integer" || assign_fieldType  ==  "int">
		<#assign assign_fieldIdCreate = "Integer ${assign_fieldName} = getInteger(params.get(\"${assign_fieldName}\"))">
		<#elseif assign_fieldType  ==  "Long" || assign_fieldType  ==  "long">
		<#assign assign_fieldIdCreate = "Long ${assign_fieldName} = getLong(params.get(\"${assign_fieldName}\"))">
		<#elseif assign_fieldType  ==  "Float" || assign_fieldType  ==  "float">
		<#assign assign_fieldIdCreate = "Float ${assign_fieldName} = getFloat(params.get(\"${assign_fieldName}\"))">
		<#elseif assign_fieldType  ==  "Double" || assign_fieldType  ==  "double">
		<#assign assign_fieldIdCreate = "Double ${assign_fieldName} = getDouble(params.get(\"${assign_fieldName}\"))">
		<#else>
		<#assign assign_fieldIdCreate = "String ${assign_fieldName} = params.get(\"${assign_fieldName}\")">
		</#if>
		${assign_fieldIdCreate};
		if (${assign_fieldName} == null <#if assign_fieldType == "String"> || ${assign_fieldName}.trim().isEmpty()</#if>) {
			handler.handle(formatFailure(412, "获取数据失败,请求中缺少必填的参数!", "id不能为空", null));
			return;
		}
		${assign_SqlName}.selectById(${assign_fieldName}, res -> {
			if (res.succeeded()) {
				JsonObject result = res.result();
				if (LOG.isDebugEnabled()) {
					LOG.debug("执行获取数据[${assign_ClassName}.get]-->成功:" + result);
				}
				handler.handle(formatSuccess(result));
			} else {
				LOG.error("执行获取数据[${assign_ClassName}.get]-->失败:", res.cause());
				handler.handle(formatFailure(500, "获取数据失败,请稍后重试!", "获取数据失败,请联系管理员!", null));
			}
		});
	}

	@Override
	public void update(MultiMap params, Handler<AsyncResult<JsonObject>> handler) {
		try {
			${assign_EntityName}  data = new ${assign_EntityName}(params);
			if (data.get${assign_fieldPascalName}() == null) {
				handler.handle(formatFailure(412, "修改数据失败,缺少必填的数据!", "id不能为空", 0));
				return;
			}
			if (<#list content.content.fields as cnf><#if cnf.fieldType != "boolean" && cnf.fieldName != assign_fieldName>data.get${cnf.fieldNamePascal}() == null <#if cnf?has_next> && </#if></#if></#list>) {
				handler.handle(formatFailure(412, "修改数据失败,没有设置修改项!", "没有要更新的属性", 0));
				return;
			}
			${assign_SqlName}.updateNonEmptyById(data, res -> {
				if (res.succeeded()) {
					int result = res.result();
					if (LOG.isDebugEnabled()) {
						LOG.debug("执行更新数据[${assign_ClassName}.update]-->结果[受影响]:" + result);
					}
					handler.handle(formatSuccess(result));
				} else {
					LOG.error("执行更新数据[${assign_ClassName}.update]-->失败:", res.cause());
					handler.handle(formatFailure(500, "修改数据失败,请稍后重试!", "修改数据失败,请联系管理员!", null));
				}
			});
		} catch (Exception e) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("执行更新数据[${assign_ClassName}.update]-->失败:", e);
			}
			handler.handle(formatFailure(413, "修改数据失败,存在无效的数据!", e.getMessage(), null));
		}
	}
	
	@Override
	public void delete(MultiMap params, Handler<AsyncResult<JsonObject>> handler) {
		${assign_fieldIdCreate};
		if (${assign_fieldName} == null <#if assign_fieldType == "String"> || ${assign_fieldName}.trim().isEmpty()</#if>) {
			handler.handle(formatFailure(412, "删除数据失败,请求中缺少必填的参数!", "id不能为空", null));
			return;
		}
		${assign_SqlName}.deleteById(${assign_fieldName}, res -> {
			if (res.succeeded()) {
				int result = res.result();
				if (LOG.isDebugEnabled()) {
					LOG.debug("执行删除数据[${assign_ClassName}.delete]-->结果[受影响]:" + result);
				}
				handler.handle(formatSuccess(result));
			} else {
				LOG.error("执行删除数据[${assign_ClassName}.delete]-->失败:", res.cause());
				handler.handle(formatFailure(500, "删除数据失败,请稍后重试!", "删除数据失败,请联系管理员!", null));
			}
		});
	}
	</#if>
	/**
	 * TODO 如果你看到这些方法时,你应该将其抽成一个工具类,并修改模板使用工具类替换它们
	 */
	public <T> Future<JsonObject> formatSuccess(T data) {
		JsonObject result = new JsonObject();
		// 状态码
		result.put("code", 200);
		// 显示给用户的提示信息
		result.put("msg", "成功!");
		// 显示给前端开发人员的信息
		result.put("explain", "成功!");
		// 操作结果的数据
		if (data == null) {
			result.putNull("data");
		} else {
			result.put("data", data);
		}
		return Future.succeededFuture(result);
	}

	/**
	 * TODO 这里可以在工具类中提供不同的构造方法
	 */
	public <T> Future<JsonObject> formatFailure(int code, String msg, String explain, T data) {
		JsonObject result = new JsonObject();
		result.put("code", code);
		result.put("msg", msg);
		result.put("explain", explain);
		if (data == null) {
			result.putNull("data");
		} else {
			result.put("data", data);
		}
		return Future.succeededFuture(result);
	}
	public Integer getInteger(String num) {
		try {
			Integer result = new Integer(num);
			return result;
		} catch (NumberFormatException e) {
			return null;
		}
	}
	public Integer getInteger(String num, Integer def) {
		try {
			Integer result = new Integer(num);
			return result;
		} catch (NumberFormatException e) {
			return def;
		}
	}
	public Long getLong(String num) {
		try {
			Long result = new Long(num);
			return result;
		} catch (NumberFormatException e) {
			return null;
		}
	}
	public Long getLong(String num, Long def) {
		try {
			Long result = new Long(num);
			return result;
		} catch (NumberFormatException e) {
			return def;
		}
	}
	public Float Float(String num) {
		try {
			Float result = new Float(num);
			return result;
		} catch (NumberFormatException e) {
			return null;
		}
	}
	public Float Float(String num, Float def) {
		try {
			Float result = new Float(num);
			return result;
		} catch (NumberFormatException e) {
			return def;
		}
	}
	public Double getDouble(String num) {
		try {
			Double result = new Double(num);
			return result;
		} catch (NumberFormatException e) {
			return null;
		}
	}
	public Double getDouble(String num, Double def) {
		try {
			Double result = new Double(num);
			return result;
		} catch (NumberFormatException e) {
			return def;
		}
	}

}
