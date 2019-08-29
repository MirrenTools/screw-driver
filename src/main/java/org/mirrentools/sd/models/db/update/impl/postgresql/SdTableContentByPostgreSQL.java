package org.mirrentools.sd.models.db.update.impl.postgresql;

import java.util.ArrayList;
import java.util.List;

import org.mirrentools.sd.common.SdUtil;
import org.mirrentools.sd.models.db.update.SdAbstractColumnContent;
import org.mirrentools.sd.models.db.update.SdAbstractIndexKeyContent;
import org.mirrentools.sd.models.db.update.SdAbstractSequenceContent;
import org.mirrentools.sd.models.db.update.SdBasicTableContent;

/**
 * 数据库表属性创建或者修改SQL语句的PostgreSQL实现
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 */
public class SdTableContentByPostgreSQL extends SdBasicTableContent {
	/** 默认的模式 */
	public final static String DEFAULT_SCHEMAS = "public";
	/** 字符排序 */
	private String collate;

	/**
	 * 初始化一个public模式的示例
	 */
	public SdTableContentByPostgreSQL() {
		super.setSchema(DEFAULT_SCHEMAS);
	}

	/**
	 * 初始化一个自定义模式的示例
	 * 
	 * @param schemas
	 */
	public SdTableContentByPostgreSQL(String schemas) {
		super.setSchema(schemas);
	}

	@Override
	public List<String> createSQL() {
		List<String> result = new ArrayList<String>();
		result.add(super.createSQL().get(0).replace("UNSIGNED", ""));
		// 添加表的注释
		if (!SdUtil.isNullOrEmpty(getRemark())) {
			result.add(createTableComment());
		}
		// 添加列的注释
		for (int i = 0; i < getColums().size(); i++) {
			if (!SdUtil.isNullOrEmpty(getColums().get(i).getRemark())) {
				result.add(createColumnComment(getColums().get(i)));
			}
		}
		// 创建索引以及索引的注释
		if (getIndexKeys() != null && !getIndexKeys().isEmpty()) {
			for (int i = 0; i < getIndexKeys().size(); i++) {
				generateIndex(true, getIndexKeys().get(i), result);
			}
		}
		// 创建序列
		if (getSequences() != null && !getSequences().isEmpty()) {
			for (SdAbstractSequenceContent sequence : getSequences()) {
				result.add(sequence.createSQL());
			}
		}

		return result;
	}

	@Override
	public List<String> updateSQL() {
		List<String> result = new ArrayList<String>();
		result.add(super.updateSQL().get(0).replace("UNSIGNED", ""));
		// 添加表的注释
		if (!SdUtil.isNullOrEmpty(getRemark())) {
			result.add(createTableComment());
		}
		// 添加列的注释
		for (int i = 0; i < getColums().size(); i++) {
			if (!SdUtil.isNullOrEmpty(getColums().get(i).getRemark())) {
				result.add(createColumnComment(getColums().get(i)));
			}
		}
		// 创建索引以及索引的注释
		if (getIndexKeys() != null && !getIndexKeys().isEmpty()) {
			for (int i = 0; i < getIndexKeys().size(); i++) {
				result.add(String.format(" DROP INDEX IF EXISTS %s.%s;", getSchema(), getIndexKeys().get(i).getName()));
				generateIndex(false, getIndexKeys().get(i), result);
			}
		}
		// 创建序列
		if (getSequences() != null && !getSequences().isEmpty()) {
			for (SdAbstractSequenceContent sequence : getSequences()) {
				result.add(sequence.updateSQL());
			}
		}
		return result;
	}

	@Override
	public String deleteSQL() {
		return String.format(" DROP TABLE '%s'.'%s';", getSchema(), getTableName());
	}

	/**
	 * 创建表的注释
	 * 
	 * @return
	 */
	public String createTableComment() {
		return String.format(" COMMENT ON TABLE %s.%s IS '%s';\n", getSchema(), getTableName(), getRemark());
	}

	/**
	 * 创建表中列的注释注释
	 * 
	 * @param column
	 * @return
	 */
	public String createColumnComment(SdAbstractColumnContent column) {
		return String.format(" COMMENT ON COLUMN %s.%s.%s IS '%s';\n", getSchema(), getTableName(), column.getName(), column.getRemark());
	}

	/**
	 * 创建索引
	 * 
	 * @param mode
	 *          类型,ture=创建,false=修改
	 * @param index
	 *          索引数据
	 * @param result
	 *          SQL语句集合
	 */
	public void generateIndex(boolean mode, SdAbstractIndexKeyContent index, List<String> result) {
		StringBuilder sb = new StringBuilder();
		if (mode) {
			sb.append(" CREATE ");
		} else {
			sb.append(" ALTER ");
		}
		if (index.isUnique()) {
			sb.append(" UNIQUE ");
		}
		sb.append(" INDEX ");
		if (index.isConcurrently()) {
			sb.append(" CONCURRENTLY ");
		}
		sb.append(String.format(" %s ON %s.%s USING %s ", index.getName(), getSchema(), getTableName(), index.getType()));
		sb.append(" (");
		for (int i = 0; i < index.getColumns().size(); i++) {
			sb.append("'" + index.getColumns().get(i) + "'");
			if (i != index.getColumns().size() - 1) {
				sb.append(",");
			}
		}
		sb.append(")");
		if (converterExtensions() != null) {
			sb.append(" " + converterExtensions());
		}
		sb.append(";");
		result.add(sb.toString());
		result.add(String.format(" COMMENT ON INDEX %s.%s IS '%s';\n", getSchema(), index.getName(), index.getRemark()));
	}

	/**
	 * 获取排序
	 * 
	 * @return
	 */
	public String getCollate() {
		return collate;
	}

	/**
	 * 设置排序
	 * 
	 * @param collate
	 * @return
	 */
	public SdTableContentByPostgreSQL setCollate(String collate) {
		this.collate = collate;
		return this;
	}

}
