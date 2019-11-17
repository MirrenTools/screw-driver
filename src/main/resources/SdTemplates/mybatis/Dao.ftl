<#assign assign_entityName = content.items.entity.className>
package ${content.items.dao.packageName};

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import ${content.items.assist.packageName}.SqlAssist;
import ${content.items.assist.packageName}.SqlAssist.LimitResult;
import ${content.items.entity.packageName}.${assign_entityName};

/**
 * ${content.items.entity.className}数据库相关操作
 * @author 
 */ 
@Mapper
public interface ${content.items.dao.className} {

	/**
	 * 获取数据总行数
	 * 
	 * @param assist 查询帮助类,没有时可以传入null
	 * @return
	 */
	long getCount(SqlAssist assist);

	/**
	 * 查询所有数据
	 * 
	 * @param assist 查询帮助类,没有时可以传入null
	 * @return
	 */
	List<${assign_entityName}> selectAll(SqlAssist assist);

	/**
	 * 分页获取数据,
	 * 
	 * @param assist 查询帮助类,默认page=1,rowSize=15
	 * @return
	 */
	default LimitResult<${assign_entityName}> limitAll(SqlAssist assist) {
		if (assist == null) {
			assist = new SqlAssist();
		}
		if (assist.getPage() == null || assist.getPage() < 1) {
			assist.setPage(1);
		}
		if (assist.getRowSize() == null || assist.getRowSize() < 1) {
			assist.setRowSize(15);
		}
		if (assist.getPage() == 1) {
			assist.setStartRow(0);
		} else {
			assist.setStartRow((assist.getPage() - 1) * assist.getRowSize());
		}
		long count = getCount(assist);
		LimitResult<${assign_entityName}> result = new SqlAssist().new LimitResult<${assign_entityName}>(count, assist.getPage(), assist.getRowSize());
		if (count == 0) {
			return result;
		}
		List<${assign_entityName}> data = selectAll(assist);
		result.setData(data);
		return result;
	}


	/**
	 * 通过对象中不为空的属性为条件获取数据,只返回一条结果
	 * 
	 * @param data
	 * @return
	 */
	${assign_entityName} selectSingleByObj(${assign_entityName} data);

	/**
	 * 通过对象中不为空的属性作为条件获取数据
	 * 
	 * @param data
	 * @return
	 */
	List<${assign_entityName}> selectByObj(${assign_entityName} data);

	/**
	 * 插入一个对象包括属性值为null的值
	 * 
	 * @param data
	 * @return
	 */
	int insertAll(${assign_entityName} data);

	/**
	 * 插入一个对象,只插入对象中值不为null的属性
	 * 
	 * @param data
	 * @return
	 */
	int insertNotNull(${assign_entityName} data);

	/**
	 * 批量添加全部所有字段
	 * 
	 * @param data
	 * @return
	 */
	int insertBatch(List<${assign_entityName}> data);

	/**
	 * 插入一个对象,如果该对象不存在就新建如果该对象已经存在就更新
	 * 
	 * @param data
	 * @return
	 */
	int replace(${assign_entityName} data);


	/**
	 * 通过查询帮助类删除数据
	 * 
	 * @param assist 查询帮助类,没有时可以传入null
	 * @return
	 */
	int deleteByAssist(SqlAssist assist);


	/**
	 * 更新一个对象中所有的属性包括null值,条件为SqlAssist查询帮助类
	 * 
	 * @param data   对象
	 * @param assist 查询帮助类
	 * @return
	 */
	int updateAllByAssist(@Param("data") ${assign_entityName} data, @Param("assist") SqlAssist assist);

	/**
	 * 更新一个对象中属性不为null值,条件为SqlAssist查询帮助类
	 * 
	 * @param data   对象
	 * @param assist 查询帮助类
	 * @return
	 */
	int updateNotNullByAssist(@Param("data") ${assign_entityName} data, @Param("assist") SqlAssist assist);
	<#if content.content.primaryField??>
	<#assign assign_idType = content.content.primaryField[0].fieldType>
	/**
	 * 通过id获取数据
	 * 
	 * @param id
	 * @return
	 */
	${assign_entityName} selectById(${assign_idType} id);
	/**
	 * 通过id删除数据
	 * 
	 * @param id
	 * @return
	 */
	int deleteById(${assign_idType}  id);
	/**
	 * 更新一个对象中所有的属性包括null值,条件为对象中的id
	 * 
	 * @param data
	 * @return
	 */
	int updateAllById(${assign_entityName} data);

	/**
	 * 更新一个对象中属性不为null值,条件为对象中的id
	 * 
	 * @param data
	 * @return
	 */
	int updateNotNullById(${assign_entityName} data);
	</#if>
}
