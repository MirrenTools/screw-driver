package ${content.items.dao.packageName};

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ${content.items.entity.packageName}.${content.items.entity.className};
/**
 * ${content.items.entity.className}数据库相关操作
 * @author 
 */ 
@Repository
<#if content.content.primaryField??><#assign assign_fieldType = content.content.primaryField[0].fieldType></#if>
public interface ${content.items.dao.className} extends JpaRepository<${content.items.entity.className}, ${assign_fieldType!'null'}> {

}
