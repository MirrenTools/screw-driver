package ${content.items.controller.packageName};
<#assign assign_EntityName = content.items.entity.className>
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ${content.items.service.packageName}.${content.items.service.className};
import ${content.items.entity.packageName}.${assign_EntityName};

/**
 * ${assign_EntityName}的接口服务
 * 
 * @author 
 *
 */
@RestController
@RequestMapping("/${content.items.entity.lowerName}")
public class ${content.items.controller.className} {
	/**${assign_EntityName}的服务*/
	@Autowired
	private ${content.items.service.className} service;

	@GetMapping(path = "/find", produces = { "application/json;charset=UTF-8" })
	public Map<String, Object> find() {
		return service.find();
	}

	@GetMapping(path = "/limit", produces = { "application/json;charset=UTF-8" })
	public Map<String, Object> limit(Integer page, Integer rowSize) {
		return service.limit(page, rowSize);
	}

	@PostMapping(path = "/save", produces = { "application/json;charset=UTF-8" })
	public Map<String, Object> save(${assign_EntityName} data) {
		return service.save(data);
	}
	<#if content.content.primaryField??>
	<#assign assign_fieldType = content.content.primaryField[0].fieldType>
	<#assign assign_fieldName = content.content.primaryField[0].fieldName>
	@GetMapping(path = "/get", produces = { "application/json;charset=UTF-8" })
	public Map<String, Object> get(${assign_fieldType} ${assign_fieldName}) {
		return service.findOne(${assign_fieldName});
	}
	
	@PostMapping(path = "/update", produces = { "application/json;charset=UTF-8" })
	public Map<String, Object> update(${assign_EntityName} data) {
		return service.update(data);
	}
	
	@PostMapping(path = "/delete", produces = { "application/json;charset=UTF-8" })
	public Map<String, Object> delete(${assign_fieldType} ${assign_fieldName}) {
		return service.delete(${assign_fieldName});
	}
	</#if>

}
