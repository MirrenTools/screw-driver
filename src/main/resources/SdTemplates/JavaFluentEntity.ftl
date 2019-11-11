package ${content.items.entity.packageName};

<#if content.content.imports??>
	<#list content.content.imports as impt>
import ${impt};
	</#list>
</#if>

/**
 * ${content.content.remark}
 * @author 
 */ 
<#if content.content.annotations??>
	<#list content.content.annotations as anno>
${anno}
	</#list>
</#if>
<#assign assign_ClassName = content.items.entity.className>
public class ${assign_ClassName} {
	<#list content.content.fields as item> 
	<#if item.fieldRemark??>/** ${item.fieldRemark} */</#if>
	<#if item.annotations??>
		<#list item.annotations as anno>
	${anno}
		</#list>
	</#if>
	private ${item.fieldType} ${item.fieldName} <#if item.defaults??> = <#if item.fieldType == "char" || item.fieldType == "Character" >'</#if><#if item.fieldType == "String">"</#if>${item.defaults}<#if item.fieldType == "String">"</#if><#if item.fieldType == "char" || item.fieldType == "Character" >'</#if><#if item.fieldType == "float">f</#if><#if item.fieldType == "Float">F</#if><#if item.fieldType == "long">l</#if><#if item.fieldType == "Long">L</#if></#if>; 
	</#list>
	
	<#list content.content.fields as item> 
	<#if item.fieldRemark??>
	/**
	 * 获取${item.fieldRemark}
	 * 
	 * @return
	 */
	</#if>
	public ${item.fieldType} <#if item.fieldType == "boolean">is<#else>get</#if>${item.fieldNamePascal}() {
		return ${item.fieldName};
	}
	<#if item.fieldRemark??>
	/**
	 * 设置${item.fieldRemark}
	 * 
	 * @param ${item.fieldName}
	 */
	</#if>
	public ${assign_ClassName} set${item.fieldNamePascal}(${item.fieldType} ${item.fieldName}) {
		this.${item.fieldName} = ${item.fieldName};
		return this;
	}
	</#list>

	@Override
	public String toString() {
		return "${content.items.entity.className} [<#list content.content.fields as item>${item.fieldName}=" + ${item.fieldName} + " <#if item?has_next>,</#if> </#list>]";
	}
}
