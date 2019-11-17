<#assign assign_ClassName = content.items.entity.className>
package ${content.items.entity.packageName};

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import lombok.Data;
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
@Data
@Entity
@Table<#if assign_ClassName != content.content.tableName>(name = "${content.content.tableName}")</#if>
public class ${assign_ClassName} {
	<#list content.content.fields as item> 
	<#if item.fieldRemark??>/** ${item.fieldRemark} */</#if>
	<#if item.annotations??>
		<#list item.annotations as anno>
	${anno}
		</#list>
	</#if>
	<#if item.primary == true>@Id</#if>
	<#if item.primary == true && (item.autoIncrement==true || item.identity==true)>@GeneratedValue(strategy=GenerationType.IDENTITY)</#if>
	<#if item.fieldName != item.name || item.nullable == false || item.length?? || item.unique==true >
	@Column(<#assign assign_flag=false ><#if item.fieldName != item.name>name = "${item.name}"<#assign assign_flag = true ></#if><#if item.length??><#if assign_flag==true>,</#if> <#if item.precision??>precision = ${item.length}, scale = ${item.precision}<#else>length = ${item.length}</#if><#assign assign_flag =true ></#if><#if item.unique==true><#if assign_flag==true>,</#if> unique = true<#assign assign_flag =true ></#if><#if item.nullable == false ><#if assign_flag==true>,</#if> nullable = false</#if>)
	</#if>
	private ${item.fieldType} ${item.fieldName} <#if item.defaults??> = <#if item.fieldType == "char" || item.fieldType == "Character" >'</#if><#if item.fieldType == "String">"</#if>${item.defaults}<#if item.fieldType == "String">"</#if><#if item.fieldType == "char" || item.fieldType == "Character" >'</#if><#if item.fieldType == "float">f</#if><#if item.fieldType == "Float">F</#if><#if item.fieldType == "long">l</#if><#if item.fieldType == "Long">L</#if></#if>; 
	</#list>
	<#list content.content.additionalField as item> 
	<#if item.fieldRemark??>/** ${item.fieldRemark} */</#if>
	<#if item.annotations??>
		<#list item.annotations as anno>
	${anno}
		</#list>
	</#if>
	private ${item.fieldType} ${item.fieldName} <#if item.defaults??> = <#if item.fieldType == "char" || item.fieldType == "Character" >'</#if><#if item.fieldType == "String">"</#if>${item.defaults}<#if item.fieldType == "String">"</#if><#if item.fieldType == "char" || item.fieldType == "Character" >'</#if><#if item.fieldType == "float">f</#if><#if item.fieldType == "Float">F</#if><#if item.fieldType == "long">l</#if><#if item.fieldType == "Long">L</#if></#if>; 
	</#list>
}
