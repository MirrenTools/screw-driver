<#assign assign_EntityLowerName = content.items.entity.lowerName >
package ${content.items.test.packageName};

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(classes = { <#if content.items.test.extensions??>${content.items.test.extensions.main!'null'}<#else>null</#if>.class })
@AutoConfigureMockMvc
class ${content.items.test.className} {
	/** 状态码的key */
	public final static String CODE_KEY = "code";
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testFind() throws Exception {
		String result = mockMvc.perform(get("/${assign_EntityLowerName}/find"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$." + CODE_KEY).value(200))
				.andDo(print()).andReturn().getResponse()
				.getContentAsString();
		System.out.println("testFind /${assign_EntityLowerName}/find: " + result);
	}

	@Test
	public void testLimit() throws Exception {
		String result = mockMvc.perform(get("/${assign_EntityLowerName}/limit")
					.param("page", "1")
					.param("rowSize", "15")
				)
				.andExpect(status().isOk())
				.andExpect(jsonPath("$." + CODE_KEY).value(200))
				.andDo(print()).andReturn().getResponse()
				.getContentAsString();
		System.out.println("testLimit /${assign_EntityLowerName}/limit: " + result);
	}

	@Test
	public void testSave() throws Exception {
		String result = mockMvc.perform(post("/${assign_EntityLowerName}/save")
					<#if content.content.cantNullField??>
						<#list content.content.cantNullField as item>
						<#if item.fieldType  ==  "Integer" || item.fieldType  ==  "int" || item.fieldType  ==  "Long" || item.fieldType  ==  "long">
					.param("${item.fieldName}", "1")
						<#elseif item.fieldType  ==  "Float" || item.fieldType  ==  "float" || item.fieldType  ==  "Double" || item.fieldType  ==  "double">
					.param("${item.fieldName}", "1.0")
						<#else>
					.param("${item.fieldName}", "${item.fieldName}")
						</#if>
						</#list>
					</#if>
				)
				.andExpect(status().isOk())
				.andExpect(jsonPath("$." + CODE_KEY).value(200))
				.andDo(print()).andReturn()
				.getResponse().getContentAsString();
		System.out.println("testSave /${assign_EntityLowerName}/save: " + result);
	}
	<#if content.content.primaryField??>
	<#assign assign_idType = content.content.primaryField[0].fieldType>
	<#assign assign_idName = content.content.primaryField[0].fieldName>
	<#if assign_idType  ==  "Integer" || assign_idType  ==  "int" || assign_idType  ==  "Long" || assign_idType  ==  "long">
	<#assign assign_idData = 1>
	<#elseif assign_idType  ==  "Float" || assign_idType  ==  "float" || assign_idType  ==  "Double" || assign_idType  ==  "double">
	<#assign assign_idData = 1.0>
	<#else>
	<#assign assign_idData = assign_idName>
	</#if>
	@Test
	public void testGet() throws Exception {
		String result = mockMvc.perform(get("/${assign_EntityLowerName}/get")
					.param("${assign_idName}", "${assign_idData}")
				)
				.andExpect(status().isOk())
				.andExpect(jsonPath("$." + CODE_KEY).value(200))
				.andDo(print()).andReturn().getResponse()
				.getContentAsString();
		System.out.println("testGet /${assign_EntityLowerName}/get: " + result);
	}

	@Test
	public void testDelete() throws Exception {
		String result = mockMvc.perform(post("/${assign_EntityLowerName}/delete")
					.param("${assign_idName}", "${assign_idData}")
				)
				.andExpect(status().isOk())
				.andExpect(jsonPath("$." + CODE_KEY).value(200))
				.andDo(print()).andReturn().getResponse()
				.getContentAsString();
		System.out.println("testDelete /${assign_EntityLowerName}/delete: " + result);
	}
	</#if>

}
