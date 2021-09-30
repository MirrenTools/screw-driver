<#assign assign_ClassName = content.items.entity.className>
package ${content.items.entity.packageName};

<#if content.content.imports??>
	<#list content.content.imports as impt>
import ${impt};
	</#list>
</#if>
import io.vertx.core.MultiMap;
import io.vertx.ext.sql.assist.Table;
import io.vertx.ext.sql.assist.TableColumn;
import io.vertx.ext.sql.assist.TableId;
/**
 * <#if content.content.remark??>${content.content.remark}</#if>
 * @author 
 */ 
<#if content.content.annotations??>
	<#list content.content.annotations as anno>
${anno}
	</#list>
</#if>
@Table("${content.content.tableName}")
public class ${assign_ClassName} {
	<#-- 添加属性 -->
	<#list content.content.fields as item> 
	<#if item.fieldRemark??>/** ${item.fieldRemark} */</#if>
	<#if item.annotations??>
		<#list item.annotations as anno>
	${anno}
		</#list>
	</#if>
	<#if item.primary == true>@TableId(value = "${item.name}"<#if item.name != item.fieldName>, alias = "${item.fieldName}"</#if>)<#else>@TableColumn(value = "${item.name}"<#if item.name != item.fieldName>, alias = "${item.fieldName}"</#if>)</#if>
	private ${item.fieldType} ${item.fieldName}; 
	</#list>
	<#if content.content.additionalField??>
	<#list content.content.additionalField as item> 
	<#if item.fieldRemark??>/** ${item.fieldRemark} */</#if>
	<#if item.annotations??>
		<#list item.annotations as anno>
	${anno}
		</#list>
	</#if>
	private ${item.fieldType} ${item.fieldName}; 
	</#list>
	</#if>
	<#-- 添加常量 -->
	<#list content.content.fields as item> 
	/**${item.fieldName}属性在JsonObject中key的名称*/
  public final static String KEY_${item.fieldName} = "${item.fieldName}";
	/**${item.fieldName}属性在table中column的名称*/
  public final static String COL_${item.fieldName} = "${item.name}";
	</#list>
	
	/**
	 * 实例化
	 */
	public ${assign_ClassName}() {
		super();
	}
	/**
	 * 实例化
	 */
	public ${assign_ClassName}(MultiMap params) {
		super();
		try {
		<#list content.content.fields as item> 
		<#if item.fieldType  ==  "Integer" || item.fieldType  ==  "int">
		if(params.get("${item.fieldName}") != null){
			try {
				this.set${item.fieldNamePascal}(Integer.valueOf(params.get("${item.fieldName}")));
			} catch (Exception e) {
				throw new IllegalArgumentException("无法识别参数:${item.fieldName},请检查是否符合要求!");
			}
		}
		<#elseif item.fieldType  ==  "Long" || item.fieldType  ==  "long">
		if(params.get("${item.fieldName}") != null){
			try {
				this.set${item.fieldNamePascal}(Long.valueOf(params.get("${item.fieldName}")));
			} catch (Exception e) {
				throw new IllegalArgumentException("无法识别参数:${item.fieldName},请检查是否符合要求!");
			}
		}
		<#elseif item.fieldType  ==  "Float" || item.fieldType  ==  "float">
		if(params.get("${item.fieldName}") != null){
			try {
				this.set${item.fieldNamePascal}(Float.valueOf(params.get("${item.fieldName}")));
			} catch (Exception e) {
				throw new IllegalArgumentException("无法识别参数:${item.fieldName},请检查是否符合要求!");
			}
		}
		<#elseif item.fieldType  ==  "Double" || item.fieldType  ==  "double">
		if(params.get("${item.fieldName}") != null){
			try {
				this.set${item.fieldNamePascal}(Double.valueOf(params.get("${item.fieldName}")));
			} catch (Exception e) {
				throw new IllegalArgumentException("无法识别参数:${item.fieldName},请检查是否符合要求!");
			}
		}
		<#else>
		this.set${item.fieldNamePascal}(params.get("${item.fieldName}"));
		</#if>
		</#list>
		} catch (Exception e) {
			throw e;
		}
	}
	
	<#-- 添加get与set -->
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
	<#if content.content.additionalField??>
	<#list content.content.additionalField as item> 
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
	</#if>

	@Override
	public String toString() {
		return "${content.items.entity.className} [<#list content.content.fields as item>${item.fieldName}=" + ${item.fieldName} + " <#if item?has_next>,</#if> </#list><#if content.content.additionalField??><#list content.content.additionalField as item>, ${item.fieldName}=" + ${item.fieldName} + " <#if item?has_next>,</#if> </#list></#if>]";
	}
}
