package ${content.entity.classPackage};

/**
 * ${content.entity.tableName}实体类
 * 
 * @author 
 *
 */
public class ${content.entity.className} {
	<#list content.entity.attrs as item> 
	/**${item.remarks!}*/
	private ${item.javaType} ${item.field}; 
	</#list>
	
	<#list content.entity.attrs as item> 
	/**
	 * 获取${item.field}
	 * 
	 * @return
	 */
	public ${item.javaType} ${item.fget}() {
		return ${item.field};
	}

	/**
	 * 设置${item.field}
	 * 
	 * @param ${item.field}
	 */
	public void ${item.fset}(${item.javaType} ${item.field}) {
		this.${item.field} = ${item.field};
	}
	</#list>

	@Override
	public String toString() {
		return "${content.entity.className!} [<#list content.entity.attrs as item>${item.field}=" + ${item.field} + " <#if item?has_next>,</#if> </#list>]";
	
	}
	
	
}
