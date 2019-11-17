<#assign assign_ClassName = content.items.entity.className>
package ${content.items.entity.packageName};

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
}
