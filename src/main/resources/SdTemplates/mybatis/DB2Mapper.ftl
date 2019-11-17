<#assign assign_TableName = content.content.tableName>
<#assign assign_AssistFullName = content.items.assist.packageName+"."+content.items.assist.className>
<#assign assign_EntityFullName = content.items.entity.packageName+"."+content.items.entity.className>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${content.items.dao.packageName}.${content.items.dao.className}">
	<!-- 实体类的返回map-->
	<resultMap id="result_entity_map" type="${assign_EntityFullName}">
	<#list content.content.fields as item> 
		<#if item.primary == true>
		<id column="${item.name}" property="${item.fieldName}" />
		<#else>
		<result column="${item.name}" property="${item.fieldName}" />
		</#if>
	</#list>
	</resultMap>
	<!-- assist是 SQL查询帮助类添加条件, ${r'${req.condition}'}表示列名或前缀,${r'#{req.value}'}表示值它是防SQL注入的 -->
	<sql id="assist">
		<where>
			<foreach collection="condition" item="req" separator=" ">
				${r'${req.condition}'}
				<if test="req.value != null">
					${r'#{req.value}'}
				</if>
				<if test="req.values != null">
					<foreach collection="req.values" item="value" separator=",">
						${r'#{value}'}
					</foreach>
				</if>
				<if test="req.suffix != null"> ${r'${req.suffix}'}</if>
			</foreach>
		</where>
	</sql>
	<!-- having_assist用于添加having后面的条件,与assist的SQL块一样作用 -->
	<sql id="having_assist">
		<foreach collection="having" item="req" separator=" ">
			${r'${req.condition}'}
			<if test="req.value != null">
				${r'#{req.value}'}
			</if>
			<if test="req.values != null">
				<foreach collection="req.values" item="value" separator=",">
					${r'#{value}'}
				</foreach>
			</if>
			<if test="req.suffix != null"> ${r'${req.suffix}'}</if>
		</foreach>
	</sql>

	<!-- update_assist用于更新数据查询辅助工具类,与assist的SQL块一样作用 -->
	<sql id="update_assist">
		<where>
			<foreach collection="condition" item="req" separator=" ">
				${r'${req.condition}'}
				<if test="req.value != null">
					${r'#{req.value}'}
				</if>
				<if test="req.values != null">
					<foreach collection="req.values" item="value" separator=",">
						${r'#{value}'}
					</foreach>
				</if>
				<if test="req.suffix != null"> ${r'${req.suffix}'}</if>
			</foreach>
		</where>
	</sql>

	<!-- 数据库中表的列名 -->
	<sql id="table_column">
		<#list content.content.fields as item>${item.name}<#if item?has_next>,</#if></#list>
	</sql>

	<!--获取数据总行数 -->
	<select id="getCount" parameterType="${assign_AssistFullName}" resultType="java.lang.Long">
		select count(*) from ${assign_TableName}
		<if test="condition != null">
			<include refid="assist" />
		</if>
		<if test="groupBy != null ">${r'${groupBy}'}</if>
		<if test="having != null ">
			<include refid="having_assist" />
		</if>
	</select>

	<!-- 获取所有数据 -->
	<select id="selectAll" parameterType="${assign_AssistFullName}" resultMap="result_entity_map">
		<if test="rowSize!=null">
			select * from ( select temp_table.*, rownumber () over () as tt_row_index from (
		</if>
		select
		<if test="distinct != null">${r'${distinct}'}</if>
		<choose>
			<when test="resultColumn!=null">${r'${resultColumn}'}</when>
			<otherwise>
				<include refid="table_column" />
			</otherwise>
		</choose>
		from ${assign_TableName}
		<if test="condition != null ">
			<include refid="assist" />
		</if>
		<if test="groupBy != null ">${r'${groupBy}'}</if>
		<if test="having != null ">
			<include refid="having_assist" />
		</if>
		<if test="orderBy != null ">${r'${orderBy}'}</if>
		<if test="rowSize!=null">
			) AS temp_table ) AS tt_result_table 
			where tt_result_table.tt_row_index 
			<choose>
				<when test="startRow!=null">
					between ${r'#{startRow}'} and ${r'#{startRow}'}+${r'#{rowSize}'}
				</when>
				<otherwise>
					between 0 and ${r'#{rowSize}'}
				</otherwise>
			</choose>
		</if>
	</select>

	<!-- 通过对象中不为空的属性为条件获取数据,只返回一条结果 -->
	<select id="selectSingleByObj" parameterType="${assign_EntityFullName}" resultMap="result_entity_map">
		select
		<include refid="table_column" />
		from ${assign_TableName}
		<where>
			<#list content.content.fields as item> 
			<#if item.primary != true>
			<if test="${item.fieldName} != null"> and ${item.name} = ${r'#{'}${item.fieldName}${r'}'}</if>
			</#if>
			</#list>
			<#list content.content.fields as item> 
			<#if item.primary == true>
			<if test="${item.fieldName} != null"> and ${item.name} = ${r'#{'}${item.fieldName}${r'}'}</if>
			</#if>
			</#list>
		</where>
 	 	FETCH FIRST 1 ROWS ONLY 
	</select>

	<!-- 通过对象中不为空的属性作为条件获取数据 -->
	<select id="selectByObj" parameterType="${assign_EntityFullName}" resultMap="result_entity_map">
		select
		<include refid="table_column" />
		from ${assign_TableName}
		<where>
			<#list content.content.fields as item> 
			<#if item.primary != true>
			<if test="${item.fieldName} != null"> and ${item.name} = ${r'#{'}${item.fieldName}${r'}'}</if>
			</#if>
			</#list>
			<#list content.content.fields as item> 
			<#if item.primary == true>
			<if test="${item.fieldName} != null"> and ${item.name} = ${r'#{'}${item.fieldName}${r'}'}</if>
			</#if>
			</#list>
		</where>
	</select>

	<!-- 插入一个对象包括属性值为null的值 -->
	<insert id="insertAll" parameterType="${assign_EntityFullName}">
		insert into
		${assign_TableName}
		(<#list content.content.fields as item>${item.name}<#if item?has_next>,</#if></#list>)
		values(<#list content.content.fields as item>${r'#{'}${item.fieldName}${r'}'}<#if item?has_next>,</#if></#list>)
	</insert>

	<!-- 插入一个对象,只插入对象中值不为null的属性 -->
	<insert id="insertNotNull" parameterType="${assign_EntityFullName}">
		insert into ${assign_TableName}
		<trim prefix="(" suffix=")" suffixOverrides=",">
		<#list content.content.fields as item>
			<if test="${item.fieldName} != null">${item.name},</if>
		</#list>
		</trim>
		<trim prefix="values (" suffix=")" suffixOverrides=",">
		<#list content.content.fields as item>
			<if test="${item.fieldName} != null">${r'#{'}${item.fieldName}${r'}'},</if>
		</#list>
		</trim>
	</insert>

	<!-- 批量添加全部所有字段 -->
	<insert id="insertBatch" parameterType="ArrayList">
		insert into
		${assign_TableName}
		(<#list content.content.fields as item>${item.name}<#if item?has_next>,</#if></#list>)
		values
		<foreach collection="list" item="item" index="index" separator=",">
			(<#list content.content.fields as item>${r'#{item.'}${item.fieldName}${r'}'}<#if item?has_next>,</#if></#list>)
		</foreach>
	</insert>

	<!-- 插入一个对象,如果该对象不存在就新建如果该对象已经存在就更新 -->
	<insert id="replace" parameterType="${assign_EntityFullName}">
		replace into
		${assign_TableName}
		(<#list content.content.fields as item>${item.name}<#if item?has_next>,</#if></#list>)
		values(<#list content.content.fields as item>${r'#{'}${item.fieldName}${r'}'}<#if item?has_next>,</#if></#list>)
	</insert>

	<!-- 通过查询帮助类删除数据 -->
	<delete id="deleteByAssist" parameterType="${assign_AssistFullName}">
		delete from
		${assign_TableName}
		<if test="distinct != null">
			<include refid="assist" />
		</if>
	</delete>

	<!-- 更新一个对象中所有的属性包括null值,条件为SqlAssist查询帮助类 ,data=对象,assist=查询帮助类 -->
	<update id="updateAllByAssist" parameterType="map">
		update ${assign_TableName}
		<set>
		<#list content.content.fields as item>
			${item.name} = ${r'#{'}${item.fieldName}${r'}'}<#if item?has_next>,</#if>
		</#list>
		</set>
		<if test="assist !=null">
			<if test="assist.condition != null">
				<include refid="update_assist" />
			</if>
		</if>
	</update>

	<!--更新一个对象中属性不为null值,条件为SqlAssist查询帮助类,data=对象,assist=查询帮助类 -->
	<update id="updateNotNullByAssist" parameterType="map">
		update ${assign_TableName}
		<set>
		<#list content.content.fields as item>
			<if test="data.${item.fieldName} != null">${item.name} = ${r'#{'}${item.fieldName}${r'}'}<#if item?has_next>,</#if></if>
		</#list>
		</set>
		<if test="assist !=null">
			<if test="assist.condition != null">
				<include refid="update_assist" />
			</if>
		</if>
	</update>
	<#if content.content.primaryField??>
	<#assign assign_idFieldType = content.content.primaryField[0].fieldType>
	<#assign assign_idFieldName = content.content.primaryField[0].name>
	<#assign assign_idName = content.content.primaryField[0].name>
	<!-- 通过id获取数据 -->
	<select id="selectById" parameterType="${assign_idFieldType}" resultMap="result_entity_map">
		select
		<include refid="table_column" />
		from ${assign_TableName}
		where ${assign_idName} = ${r'#{id}'}
	</select>
	
	<!-- 通过id删除数据 -->
	<delete id="deleteById" parameterType="${assign_idFieldType}">
		delete from ${assign_TableName}
		where ${assign_idName} = ${r'#{id}'}
	</delete>
	
	<!-- 更新一个对象中所有的属性包括null值,条件为对象中的id -->
	<update id="updateAllById" parameterType="${assign_EntityFullName}">
		update ${assign_TableName} set
		<set>
		<#list content.content.fields as item>
			<#if item.primary != true>
			${item.name} = ${r'#{'}${item.fieldName}${r'}'}<#if item?has_next>,</#if>
			</#if>
		</#list>
		</set>
		where ${assign_idName} = ${r'#{'}${assign_idFieldName}${r'}'}
	</update>

	<!-- 更新一个对象中属性不为null值,条件为对象中的id -->
	<update id="updateNotNullById" parameterType="${assign_EntityFullName}">
		update ${assign_TableName}
		<set>
		<#list content.content.fields as item>
			<#if item.primary != true>
			<if test="${item.fieldName} != null">name = ${r'#{'}${item.fieldName}${r'}'}<#if item?has_next>,</#if></if>
			</#if>
		</#list>
		</set>
		where ${assign_idName} = ${r'#{'}${assign_idFieldName}${r'}'}
	</update>
	</#if>
</mapper>