package ${content.items.entity.packageName};

<#if content.content.imports??>
	<#list content.content.imports as impt>
import ${impt};
	</#list>
</#if>
import lombok.Data;

/**
 * ${content.content.remark}
 * @author 
 */ 
<#if content.content.annotations??>
	<#list content.content.annotations as anno>
${anno}
	</#list>
</#if>
@Data
public class ${content.items.entity.className} {
	<#list content.content.fields as item> 
	/** ${item.fieldRemark!} */
	<#if item.annotations??><#list item.annotations as anno>${anno}</#list></#if>
	private ${item.fieldType} ${item.fieldName} <#if item._default??> = item._default</#if>; 
	</#list>
}