package ${content.items.serviceImpl.packageName};
<#assign assign_ClassName = content.items.serviceImpl.className>
<#assign assign_EntityName = content.items.entity.className>
<#assign assign_daoName = content.items.dao.camelName>

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import ${content.items.service.packageName}.${content.items.service.className};
import ${content.items.dao.packageName}.${content.items.dao.className};
import ${content.items.entity.packageName}.${content.items.entity.className};

/**
 * ${content.items.entity.className}数据服务接口的默认实现
 * 
 * @author 
 *
 */
@Service
public class ${assign_ClassName} implements ${content.items.service.className} {
	private final Log LOG = LogFactory.getLog(this.getClass());

	@Autowired
	private ${content.items.dao.className} ${assign_daoName};

	@Override
	public Map<String, Object> find() {
		List<${assign_EntityName}> data = ${assign_daoName}.selectList(null);
		if (LOG.isDebugEnabled()) {
			LOG.debug("执行获取数据[${assign_ClassName}.find]-->成功:" + data);
		}
		return formatSucceed(data);
	}

	@Override
	public Map<String, Object> limit(Integer page, Integer rowSize) {
		if (LOG.isDebugEnabled()) {
			LOG.debug(String.format("执行获取数据[${assign_ClassName}.limit]-->请求数据:\npage:%d \nrowSize: %d", page, rowSize));
		}
		if (page == null) {
			page = 1;
		}
		if (rowSize == null) {
			rowSize = 15;
		}
		IPage<${assign_EntityName}> data =  ${assign_daoName}.selectPage(new Page<Users>(page, rowSize), null);
		Map<String, Object> result = new HashMap<>();
		result.put("pages", data.getPages());
		result.put("current", data.getCurrent());
		result.put("total", data.getTotal());
		result.put("size", data.getSize());
		result.put("records", data.getRecords());
		if (LOG.isDebugEnabled()) {
			LOG.debug("执行获取数据[${assign_ClassName}.limit]-->成功:" + result);
		}
		return formatSucceed(result);
	}

	@Override
	public Map<String, Object> save(${assign_EntityName} data) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("执行更新数据[${assign_ClassName}.save]-->请求数据:" + data);
		}
		<#if content.content.cantNullField??>
		if (<#list content.content.cantNullField as cnf>data.get${cnf.fieldNamePascal}() == null <#if cnf?has_next> && </#if></#list>) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("执行更新数据[${assign_ClassName}.save]-->失败:缺少必填参数");
			}
			return formatFailed(412, "操作失败,缺少必填的数据!", "缺少必填项参数", data);
		}
		</#if>
		int result = ${assign_daoName}.insert(data);
		if (LOG.isDebugEnabled()) {
			LOG.debug("执行更新数据[${assign_ClassName}.save]-->结果:" + result);
		}
		return formatSucceed(result);
	}
	<#if content.content.primaryField??>
	<#assign assign_fieldType = content.content.primaryField[0].fieldType>
	<#assign assign_fieldName = content.content.primaryField[0].fieldName>
	@Override
	public Map<String, Object> findOne(${assign_fieldType} id) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("执行获取数据[${assign_ClassName}.findOne]-->请求数据:\nid:" + id);
		}
		if (id == null<#if assign_fieldType == "String"> || id.trim().isEmpty()</#if>) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("执行获取数据[${assign_ClassName}.findOne]-->失败:id为空");
			}
			return formatFailed(412, "获取数据失败,请求中缺少必填的参数!", "id不能为空", null);
		}
		${assign_EntityName} result = ${assign_daoName}.selectById(id);;
		if (LOG.isDebugEnabled()) {
			LOG.debug("执行获取数据[${assign_ClassName}.findOne]-->结果:" + result);
		}
		return formatSucceed(result);
	}
	
	@Override
	public Map<String, Object> update(${assign_EntityName} data) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("执行更新数据[${assign_ClassName}.update]-->请求数据:" + data);
		}
		if (data == null || (<#list content.content.fields as cnf><#if cnf.fieldType != "boolean" && cnf.fieldName != assign_fieldName>data.get${cnf.fieldNamePascal}() == null <#if cnf?has_next> && </#if></#if></#list>)) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("执行更新数据[${assign_ClassName}.update]-->失败:缺少必填参数");
			}
			return formatFailed(412, "操作失败,缺少必填的数据!", "缺少必填项参数", 0);
		}
		int result = ${assign_daoName}.updateById(data);
		return formatSucceed(result);
	}

	@Override
	public Map<String, Object> delete(${assign_fieldType} id) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("执行删除数据[${assign_ClassName}.delete]-->请求数据:" + id);
		}
		if (id == null<#if assign_fieldType == "String"> || id.trim().isEmpty()</#if>) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("执行删除数据[${assign_ClassName}.delete]-->失败:id为空");
			}
			return formatFailed(412, "操作失败,缺少必填的数据!", "缺少必填项参数", 0);
		}
		int result = ${assign_daoName}.deleteById(id);
		return formatSucceed(result);
	}
	</#if>

	// TODO 当你看到以下的方法后你应该将其抽为工具并修改模板
	/**
	 * 格式化返回结果为失败
	 * 
	 * @param code    错误码
	 * @param msg     提示信息(给用户看的)
	 * @param explain 错误提示(给前端看)
	 * @param data    数据
	 * @return
	 */
	public Map<String, Object> formatFailed(int code, String msg, String explain, Object data) {
		Map<String, Object> result = new HashMap<>();
		result.put("code", code);
		result.put("msg", msg);
		result.put("explain", explain);
		result.put("data", data);
		return result;
	}

	public Map<String, Object> formatSucceed(Object data) {
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("msg", "成功!");
		result.put("explain", "成功!");
		result.put("data", data);
		return result;
	}

}
