package ${content.items.entity.packageName};

/**
 * ${content.content.tableName}实体类
 * @author 
 */
public class ${content.items.entity.className} {
	<#list content.content.fields as item> 
	/** ${item.fieldRemark!} */
	private ${item.fieldType} ${item.fieldName}; 
	</#list>
	
	<#list content.content.fields as item> 
	/**
	 * 获取${item.fieldRemark}
	 * 
	 * @return
	 */
	public ${item.fieldType} <#if item.fieldType == "boolean" || item.fieldType == "Boolean">is<#else>get</#if>${item.fieldNamePascal}() {
		return ${item.fieldName};
	}

	/**
	 * 设置${item.fieldRemark}
	 * 
	 * @param ${item.fieldName}
	 */
	public void set${item.fieldNamePascal}(${item.fieldType} ${item.fieldName}) {
		this.${item.fieldName} = ${item.fieldName};
	}
	</#list>

	@Override
	public String toString() {
		return "${content.items.entity.className} [<#list content.content.fields as item>${item.fieldName}=" + ${item.fieldName} + " <#if item?has_next>,</#if> </#list>]";
	}
}
