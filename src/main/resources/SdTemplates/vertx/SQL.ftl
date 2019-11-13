package ${content.items.sql.packageName};

import ${content.items.entity.packageName}.${content.items.entity.className};

import io.vertx.ext.jdbc.JDBCClient;
import io.vertx.ext.sql.assist.CommonSQL;
import io.vertx.ext.sql.assist.SQLExecute;

/**
 * ${content.items.entity.className}数据库相关操作
 * @author 
 */ 
public class ${content.items.sql.className} extends CommonSQL<${content.items.entity.className},JDBCClient> {
	public ${content.items.sql.className}(SQLExecute<JDBCClient> execute) {
		super(execute);
	}

}
