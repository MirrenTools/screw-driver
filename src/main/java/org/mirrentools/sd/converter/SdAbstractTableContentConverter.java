package org.mirrentools.sd.converter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.mirrentools.sd.ScrewDriverException;
import org.mirrentools.sd.common.SdUtil;
import org.mirrentools.sd.models.SdBean;
import org.mirrentools.sd.models.SdColumn;
import org.mirrentools.sd.models.db.update.SdAbstractColumnContent;
import org.mirrentools.sd.models.db.update.SdAbstractConstraintContent;
import org.mirrentools.sd.models.db.update.SdAbstractForeignKeyContent;
import org.mirrentools.sd.models.db.update.SdAbstractIndexKeyContent;
import org.mirrentools.sd.models.db.update.SdAbstractPrimaryKeyContent;
import org.mirrentools.sd.models.db.update.SdAbstractTableContent;

/**
 * 将SdBean转换为数据库创建表需要内容的抽象方法
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public abstract class SdAbstractTableContentConverter implements SdTableContentConverter {

	/** 数据库引擎 */
	private String engine;
	/** 字符集 */
	private String characterSet;
	/** 数据库排序规则 */
	private String collate;
	/** 拓展属性 */
	private Map<String, Object> extensions;

	/**
	 * 初始化一个表内容,子类需要实现它并初始化子类相应的内容
	 * 
	 * @param bean
	 * @return
	 */
	public abstract SdAbstractTableContent newTableContent(SdBean bean);

	/**
	 * 初始化一个列内容,子类需要实现它并初始化子类相应的内容
	 * 
	 * @param col
	 * @return
	 */
	public abstract SdAbstractColumnContent newColumnContent(SdColumn col);

	/**
	 * 初始化一个主键内容,子类需要实现它并初始化子类相应的内容
	 * 
	 * @param col
	 * @return
	 */
	public abstract SdAbstractPrimaryKeyContent newPrimaryKeyContent(SdColumn col);

	/**
	 * 初始化一个索引内容,子类需要实现它并初始化子类相应的内容
	 * 
	 * @param col
	 * @return
	 */
	public abstract SdAbstractIndexKeyContent newIndexKeyContent(SdColumn col);

	/**
	 * 初始化一个外键内容,子类需要实现它并初始化子类相应的内容
	 * 
	 * @param col
	 * @return
	 */
	public abstract SdAbstractForeignKeyContent newForeignKeyContent(SdColumn col);

	/**
	 * 初始化约束内容,子类需要实现它并初始化子类相应的内容
	 * 
	 * @param col
	 * @return
	 */
	public abstract SdAbstractConstraintContent newConstraintContent(SdColumn col);

	@Override
	public SdAbstractTableContent converter(SdBean bean) {
		SdAbstractTableContent result = newTableContent(bean);
		if (result.getTableName() == null) {
			result.setTableName(SdUtil.toUnderScoreCase(bean.getName()));
		}
		if (result.getRemark() == null) {
			result.setRemark(bean.getRemark());
		}
		if (result.getSchema() == null) {
			result.setSchema(bean.getSchema());
		}
		if (result.getOwner() == null) {
			result.setOwner(bean.getOwner());
		}
		if (result.getTablespace() == null) {
			result.setTablespace(bean.getTablespace());
		}
		if (result.getIndexspace() == null) {
			result.setIndexspace(bean.getIndexspace());
		}
		if (result.isCompressable() == null) {
			result.setCompressable(bean.isCompressable());
		}
		if (bean.getColumns() != null) {
			List<SdColumn> columns = new ArrayList<SdColumn>();
			List<SdColumn> primarys = new ArrayList<SdColumn>();
			List<SdColumn> indexs = new ArrayList<SdColumn>();
			List<SdColumn> foreigns = new ArrayList<SdColumn>();
			for (SdColumn col : bean.getColumns()) {
				columns.add(col);
				if (col.isPrimary()) {
					primarys.add(col);
				}
				if (col.isIndex()) {
					indexs.add(col);
				}
				if (col.isForeignKey()) {
					foreigns.add(col);
				}
			}
			converterColumns(columns, result);
			converterPrimaryKey(primarys, result);
			converterIndexKey(indexs, result);
			converterForeignKey(foreigns, result);
		} else {
			throw new ScrewDriverException("SdBean 中 getColumns() 为 null 如果创建表没有列属性没有任何意义");
		}
		converterExtensions(bean, result);
		return result;
	}

	/**
	 * 转换列属性
	 * 
	 * @param columns
	 * @param result
	 */
	public void converterColumns(List<SdColumn> columns, SdAbstractTableContent result) {
		for (SdColumn col : columns) {
			SdAbstractColumnContent column = newColumnContent(col);
			column.setName(col.getName());
			column.setRemark(col.getRemark());
			column.setType(col.getType());
			column.setLength(col.getLength());
			column.setDefault(col.getDefault());
			column.setPrimary(col.isPrimary());
			column.setNotNull(col.isNullable());
			column.setAutoIncrement(col.isAutoIncrement());
			column.setUnsigned(col.isUnsigned());
			column.setExtensions(col.getExtensions());
			result.addColum(column);
		}
	}

	/**
	 * 转换主键属性
	 * 
	 * @param columns
	 * @param result
	 */
	public void converterPrimaryKey(List<SdColumn> columns, SdAbstractTableContent result) {
		if (!columns.isEmpty()) {
			SdAbstractPrimaryKeyContent primary = null;
			for (int i = 0; i < columns.size(); i++) {
				SdColumn col = columns.get(i);
				if (primary == null) {
					primary = newPrimaryKeyContent(col);
				}
				if (primary.getName() != null && col.getPrimaryName() != null) {
					if (!col.getPrimaryName().equals(primary.getName())) {
						throw new ScrewDriverException("一张表只能有一个主键属性");
					}
					primary.setName(col.getPrimaryName());
				}
				primary.addColumn(col.getName());
				if (col.getExtensions() != null) {
					for (Entry<String, Object> ext : col.getExtensions().entrySet()) {
						primary.addExtension(ext.getKey(), ext.getValue());
					}
				}
			}
			result.setPrimaryKey(primary);
		}
	}

	/**
	 * 转换索引属性
	 * 
	 * @param columns
	 * @param result
	 */
	public void converterIndexKey(List<SdColumn> columns, SdAbstractTableContent result) {
		if (!columns.isEmpty()) {
			Map<String, SdAbstractIndexKeyContent> indexs = new LinkedHashMap<String, SdAbstractIndexKeyContent>();
			for (int i = 0; i < columns.size(); i++) {
				SdColumn col = columns.get(i);
				if (col.getIndexType() == null) {
					System.out.println(col);
					throw new ScrewDriverException("索引的类型不能为空");
				}
				SdAbstractIndexKeyContent indexContent = indexs.get(col.getIndexName());
				if (indexContent == null) {
					indexContent = newIndexKeyContent(col);
					indexContent.setName(col.getIndexName());
					indexContent.setType(col.getIndexType());
					indexContent.setRemark(col.getIndexRemark());
					indexContent.addColumn(col.getName());
					indexs.put(col.getIndexName(), indexContent);
				} else {
					if (indexContent.getType() != null && col.getIndexType() != null) {
						if (!indexContent.getType().equals(col.getIndexType())) {
							throw new ScrewDriverException("存在了两个相同索引名字,不同索引类型的属性");
						}
					} else {
						indexContent.setType(col.getIndexType());
					}
					indexContent.setRemark(col.getIndexRemark());
					indexContent.addColumn(col.getName());
				}
				if (col.getExtensions() != null) {
					for (Entry<String, Object> ext : col.getExtensions().entrySet()) {
						indexContent.addExtension(ext.getKey(), ext.getValue());
					}
				}
			}
			for (Entry<String, SdAbstractIndexKeyContent> entry : indexs.entrySet()) {
				result.addIndexKey(entry.getValue());
			}
		}
	}

	/**
	 * 转换外键属性
	 * 
	 * @param columns
	 * @param result
	 */
	public void converterForeignKey(List<SdColumn> columns, SdAbstractTableContent result) {
		if (!columns.isEmpty()) {
			Map<String, SdAbstractForeignKeyContent> foreigns = new LinkedHashMap<String, SdAbstractForeignKeyContent>();
			for (int i = 0; i < columns.size(); i++) {
				SdColumn col = columns.get(i);
				if (col.getForeignReferencesTable() == null) {
					throw new ScrewDriverException("外键引用那个表的属性不能为空");
				}
				SdAbstractForeignKeyContent foreign = foreigns.get(col.getForeignConstraint());
				if (foreign == null) {
					foreign = newForeignKeyContent(col);
					foreign.setConstraint(col.getForeignConstraint());
					foreign.setReferencesDB(col.getForeignReferencesDB());
					foreign.setReferencesTable(col.getForeignReferencesTable());
					foreign.addReferencesColumn(col.getForeignReferencesColumn());
					foreign.addForeignKey(col.getName());
					foreigns.put(col.getForeignConstraint(), foreign);
				} else {
					if (col.getForeignConstraint().equals(foreign.getConstraint())) {
						if (!col.getForeignReferencesTable().equals(foreign.getReferencesTable())) {
							throw new ScrewDriverException("存在了两个相同的外键约束名,但是引用的表名不想同");
						}
					}
					foreign.addForeignKey(col.getName());
				}
				if (col.getExtensions() != null) {
					for (Entry<String, Object> ext : col.getExtensions().entrySet()) {
						col.addExtension(ext.getKey(), ext.getValue());
					}
				}
			}
			for (Entry<String, SdAbstractForeignKeyContent> entry : foreigns.entrySet()) {
				result.addForeignKey(entry.getValue());
			}
		}
	}

	/**
	 * 转换约束内容
	 * 
	 * @param columns
	 * @param result
	 */
	public void converterConstraintContent(List<SdColumn> columns, SdAbstractTableContent result) {
		if (!columns.isEmpty()) {
			for (int i = 0; i < columns.size(); i++) {
				SdAbstractConstraintContent constraint = null;
				SdColumn col = columns.get(i);
				if (constraint == null) {
					constraint = newConstraintContent(col);
				}
				constraint.setType(col.getConstraintType());
				constraint.setName(col.getConstraintName());
				constraint.setExp(col.getConstraintExp());
				if (col.getExtensions() != null) {
					for (Entry<String, Object> ext : col.getExtensions().entrySet()) {
						constraint.addExtension(ext.getKey(), ext.getValue());
					}
				}
				result.addConstraint(constraint);
			}
		}
	}

	/**
	 * 转换拓展属性
	 * 
	 * @param bean
	 * @param result
	 */
	public void converterExtensions(SdBean bean, SdAbstractTableContent result) {
		result.setExtensions(bean.getExtensions());
	}

	@Override
	public String getEngine() {
		return engine;
	}

	@Override
	public SdTableContentConverter setEngine(String engine) {
		this.engine = engine;
		return this;
	}

	@Override
	public String getCharacterSet() {
		return characterSet;
	}

	@Override
	public SdTableContentConverter setCharacterSet(String characterSet) {
		this.characterSet = characterSet;
		return this;
	}

	@Override
	public String getCollate() {
		return collate;
	}

	@Override
	public SdTableContentConverter setCollate(String collate) {
		this.collate = collate;
		return this;
	}

	@Override
	public Map<String, Object> getExtensions() {
		return extensions;
	}

	@Override
	public Object getExtension(String key) {
		if (getExtensions() == null) {
			return null;
		}
		return getExtensions().get(key);
	}

	@Override
	public SdTableContentConverter putExtension(String key, Object value) {
		if (getExtensions() == null) {
			setExtensions(new LinkedHashMap<String, Object>());
		}
		getExtensions().put(key, value);
		return this;
	}

	@Override
	public SdTableContentConverter setExtensions(Map<String, Object> extensions) {
		this.extensions = extensions;
		return this;
	}

}
