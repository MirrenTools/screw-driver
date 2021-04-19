<#assign assign_EntityLowerName = content.items.entity.lowerName >
package ${content.items.test.packageName};
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.client.WebClientOptions;
import io.vertx.ext.web.codec.BodyCodec;

@RunWith(VertxUnitRunner.class)
public class ${content.items.test.className} {
	public WebClient webClient;
	/** 状态码的key */
	public final static String CODE_KEY = "code";

	@Before
	public void startUp() {
		Vertx vertx = Vertx.vertx();
		WebClientOptions options = new WebClientOptions();
		options.setDefaultHost("localhost").setDefaultPort(8080);
		webClient = WebClient.create(vertx, options);
	}

	@Test
	public void testFind(TestContext context) {
		Async async = context.async();
		webClient.get("/${assign_EntityLowerName}/find").as(BodyCodec.jsonObject()).send(res -> {
			if (res.succeeded()) {
				context.assertEquals(200, res.result().statusCode());
				JsonObject body = res.result().body();
				System.out.println("test /${assign_EntityLowerName}/find: " + body);
				context.assertEquals(200, body.getInteger(CODE_KEY));
				async.complete();
			} else {
				context.fail(res.cause());
			}
		});
	}

	@Test
	public void testLimit(TestContext context) {
		Async async = context.async();
		webClient.get("/${assign_EntityLowerName}/limit")
		.addQueryParam("page", "1")
		.addQueryParam("rowSize", "15")
		.as(BodyCodec.jsonObject()).send(res -> {
			if (res.succeeded()) {
				context.assertEquals(200, res.result().statusCode());
				JsonObject body = res.result().body();
				System.out.println("test /${assign_EntityLowerName}/limit: " + body);
				context.assertEquals(200, body.getInteger(CODE_KEY));
				async.complete();
			} else {
				context.fail(res.cause());
			}
		});
	}	
	@Test
	public void testSave(TestContext context) {
		Async async = context.async();
		webClient.post("/${assign_EntityLowerName}/save")
		<#if content.content.cantNullField??>
			<#list content.content.cantNullField as item>
			<#if item.fieldType  ==  "Integer" || item.fieldType  ==  "int" || item.fieldType  ==  "Long" || item.fieldType  ==  "long">
		.addQueryParam("${item.fieldName}", "1")
			<#elseif item.fieldType  ==  "Float" || item.fieldType  ==  "float" || item.fieldType  ==  "Double" || item.fieldType  ==  "double">
		.addQueryParam("${item.fieldName}", "1.0")
			<#else>
		.addQueryParam("${item.fieldName}", "${item.fieldName}")
			</#if>
			</#list>
		</#if>
		.as(BodyCodec.jsonObject()).send(res -> {
			if (res.succeeded()) {
				context.assertEquals(200, res.result().statusCode());
				JsonObject body = res.result().body();
				System.out.println("test /${assign_EntityLowerName}/save: " + body);
				context.assertEquals(200, body.getInteger(CODE_KEY));
				async.complete();
			} else {
				context.fail(res.cause());
			}
		});
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
	public void testGet(TestContext context) {
		Async async = context.async();
		webClient.get("/${assign_EntityLowerName}/get")
		.addQueryParam("${assign_idName}", "${assign_idData}")
		.as(BodyCodec.jsonObject()).send(res -> {
			if (res.succeeded()) {
				context.assertEquals(200, res.result().statusCode());
				JsonObject body = res.result().body();
				System.out.println("test /${assign_EntityLowerName}/get: " + body);
				context.assertEquals(200, body.getInteger(CODE_KEY));
				async.complete();
			} else {
				context.fail(res.cause());
			}
		});
	}
	
	@Test
	public void testUpdate(TestContext context) {
		Async async = context.async();
		webClient.post("/${assign_EntityLowerName}/update")
		.addQueryParam("${assign_idName}", "${assign_idData}")
		<#if content.content.cantNullField??>
			<#list content.content.cantNullField as item>
			<#if item.fieldName != assign_idName>
				<#if item.fieldType  ==  "Integer" || item.fieldType  ==  "int" || item.fieldType  ==  "Long" || item.fieldType  ==  "long">
		.addQueryParam("${item.fieldName}", "2")
				<#elseif item.fieldType  ==  "Float" || item.fieldType  ==  "float" || item.fieldType  ==  "Double" || item.fieldType  ==  "double">
		.addQueryParam("${item.fieldName}", "2.0")
				<#else>
		.addQueryParam("${item.fieldName}", "new_${item.fieldName}")
				</#if>
			</#if>
			</#list>
		</#if>
		.as(BodyCodec.jsonObject()).send(res -> {
			if (res.succeeded()) {
				context.assertEquals(200, res.result().statusCode());
				JsonObject body = res.result().body();
				System.out.println("test /${assign_EntityLowerName}/update: " + body);
				context.assertEquals(200, body.getInteger(CODE_KEY));
				async.complete();
			} else {
				context.fail(res.cause());
			}
		});
	}
	
	@Test
	public void testDelete(TestContext context) {
		Async async = context.async();
		webClient.post("/${assign_EntityLowerName}/delete")
		.addQueryParam("${assign_idName}", "${assign_idData}")
		.as(BodyCodec.jsonObject()).send(res -> {
			if (res.succeeded()) {
				context.assertEquals(200, res.result().statusCode());
				JsonObject body = res.result().body();
				System.out.println("test /${assign_EntityLowerName}/delete: " + body);
				context.assertEquals(200, body.getInteger(CODE_KEY));
				async.complete();
			} else {
				context.fail(res.cause());
			}
		});
	}
	</#if>
}
