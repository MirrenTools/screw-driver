package ${content.items.dao.packageName};

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import ${content.items.entity.packageName}.${content.items.entity.className};
/**
 * ${content.items.entity.className}数据库相关操作
 * @author 
 */ 
<#if content.content.primaryField??><#assign assign_fieldType = content.content.primaryField[0].fieldType></#if>
public interface ${content.items.dao.className} extends BaseMapper<${content.items.entity.className}> {

}
