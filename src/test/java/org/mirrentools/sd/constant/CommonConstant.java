package org.mirrentools.sd.constant;

import java.util.HashMap;
import java.util.Map;

import org.mirrentools.sd.models.SdTemplate;
import org.mirrentools.sd.models.SdTemplateAttribute;
import org.mirrentools.sd.models.db.query.SdTable;
import org.mirrentools.sd.models.db.query.SdTableAttribute;
import org.mirrentools.sd.models.db.query.SdTableColumnAttribute;
import org.mirrentools.sd.models.db.query.SdTableIndexKeyAttribute;
import org.mirrentools.sd.models.db.query.SdTablePortedKeysAttribute;
import org.mirrentools.sd.models.db.query.SdTablePrimaryKeyAttribute;

/**
 * 一些测试中可能灰反复使用的类
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public class CommonConstant {
	// 设置实体生成模板
	public static Map<String, SdTemplate> templates;
	// 数据库配置文件
	public static SdTable studentTable;

	static {
		initTemplates();
		initTable();
	}

	/**
	 * 初始化模板工具
	 */
	private static void initTemplates() {
		templates = new HashMap<String, SdTemplate>();
		SdTemplate entity = new SdTemplate().setFile("entity.ftl").setSourceFolder(SdConstant.MAVEN_TEST).setPackageName("com.entity").setClassName("User");
		templates.put("entity", entity);
		SdTemplate dao = new SdTemplate().setFile("dao.ftl").setSourceFolder(SdConstant.MAVEN_TEST).setPackageName("com.dao").setClassName("UserDao");
		dao.addAttribute(new SdTemplateAttribute("test", "{c}{p}", "测试驼峰与帕斯卡还有下划线{u},连字符{h}"));
		templates.put("dao", dao);
	}

	/**
	 * 初始化表
	 */
	private static void initTable() {
		studentTable = new SdTable();
		String tableName = "classes_student";
		studentTable.setInfo(new SdTableAttribute().setTableName(tableName).setRemarks("学生表"));
		SdTableColumnAttribute c1 = new SdTableColumnAttribute().setColumnName("id").setTypeName(SQL.BIGINT).setAutoincrement("YES").setRemarks("学生的id");
		SdTableColumnAttribute c2 = new SdTableColumnAttribute().setColumnName("name").setTypeName(SQL.VARCHAR).setColumnSize(30).setNullable(1).setRemarks("学生的id");
		SdTableColumnAttribute c3 = new SdTableColumnAttribute().setColumnName("mobile_phone").setTypeName(SQL.VARCHAR).setColumnDef("0086").setColumnSize(30).setNullable(1).setRemarks("学生的手机号码");
		SdTableColumnAttribute c4 = new SdTableColumnAttribute().setColumnName("classes_id").setTypeName(SQL.INT).setRemarks("班级的id");
		studentTable.addColumn(c1).addColumn(c2).addColumn(c3).addColumn(c4);
		studentTable.setPrimaryKey(new SdTablePrimaryKeyAttribute().setColumnName("id").setPkName("Primary").setTableName(tableName));
		studentTable.addIndexKey(new SdTableIndexKeyAttribute().setTableName(tableName).setColumnName("mobile_phone").setIndexName("idx_user_mobile_phone"));
		studentTable
				.addForeignKey(new SdTablePortedKeysAttribute().setFktableCat("root").setFktableName("classes").setFkName("classes_id").setFkName("FK_classes_student_id").setFkcolumnName("classes_id"));
	}
}
