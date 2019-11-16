package ${content.items.service.packageName};

import ${content.items.entity.packageName}.${content.items.entity.className};

import java.util.Map;

/**
 * ${content.items.entity.className}数据服务接口
 * 
 * @author 
 *
 */
public interface ${content.items.service.className} {
	/**
	 * 获取所有数据
	 * 
	 * @return
	 */
	Map<String, Object> find();

	/**
	 * 获取分页
	 * 
	 * @param page    第几页
	 * @param rowSize 每页显示多少行
	 * @return
	 */
	Map<String, Object> limit(Integer page, Integer rowSize);

	/**
	 * 保存
	 * 
	 * @param data
	 * @return
	 */
	Map<String, Object> save(${content.items.entity.className} data);
	<#if content.content.primaryField??>
	/**
	 * 获取指定数据
	 * 
	 * @param id
	 * @return
	 */
	Map<String, Object> findOne(Long id);
	
	/**
	 * 保存
	 * 
	 * @param data
	 * @return
	 */
	Map<String, Object> update(${content.items.entity.className} data);
	
	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	Map<String, Object> delete(Long id);
	</#if>
}
