package ${content.items.assist.packageName};

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * SQL查询帮助类
 * 
 * @author <a href="https://mirrentools.org">Mirren</a>
 *
 */
public class SqlAssist {
	/** 去重 */
	private String distinct;
	/** 排序 */
	private String orderBy;
	/** 分组 */
	private String groupBy;
	/** 数据分页第几页 */
	private Integer page;
	/** 数据分页开始行 */
	private Integer startRow;
	/** 每次取多少行数据 */
	private Integer rowSize;
	/** 设置自定义返回列 */
	private String resultColumn;
	/** 条件集 */
	private List<WhereCondition<?>> condition = null;
	/** having条件集 */
	private List<WhereCondition<?>> having = null;
	/** 自定义值,该值可以在自定义Mapper需要用到Assist跟自定义的值时使用 */
	private Object customValue;

	/**
	 * 分页查询返回结果
	 * 
	 * @author <a href="https://mirrentools.org">Mirren</a>
	 *
	 * @param <T>
	 */
	public class LimitResult<T> {
		/** 数据总行数 */
		private long totals;
		/** 数据总页数 */
		private int pages;
		/** 当前是第几页 */
		private int page;
		/** 每页显示多少行数据 */
		private int size;
		/** 数据 */
		private List<T> data;

		/**
		 * 初始化
		 * 
		 * @param totals 总行数
		 * @param page   当前页
		 * @param size   每页显示多少行数据
		 */
		public LimitResult(long totals, int page, int size) {
			super();
			this.totals = totals;
			this.page = page;
			this.size = size;
		}

		/**
		 * 获取数据总行数
		 * 
		 * @return
		 */
		public long getTotals() {
			return totals;
		}

		/**
		 * 设置数据总行数
		 * 
		 * @param totals
		 * @return
		 */
		public LimitResult<T> setTotals(long totals) {
			this.totals = totals;
			return this;
		}

		/**
		 * 获取数据总页数
		 * 
		 * @return
		 */
		public int getPages() {
			if (totals == 0) {
				return 0;
			}
			if (totals % size == 0) {
				pages = (int) (totals / size);
			} else {
				pages = (int) (totals / size) + 1;
			}
			return pages;
		}

		/**
		 * 获取当前是第几页
		 * 
		 * @return
		 */
		public int getPage() {
			return page;
		}

		/**
		 * 获取每页显示多少行数据
		 * 
		 * @return
		 */
		public int getSize() {
			return size;
		}

		/**
		 * 获取数据
		 * 
		 * @return
		 */
		public List<T> getData() {
			return data;
		}

		/**
		 * 设置数据
		 * 
		 * @param data
		 * @return
		 */
		public LimitResult<T> setData(List<T> data) {
			this.data = data;
			return this;
		}

		@Override
		public String toString() {
			return "LimitResult [totals=" + totals + ", pages=" + pages + ", page=" + page + ", size=" + size
					+ ", data=" + data + "]";
		}

	}

	/***
	 * 条件类,require属性为列的条件,value为条件值,values为多个条件值,suffix为结尾
	 * 
	 * @author <a href="https://mirrentools.org">Mirren</a>
	 *
	 * @param <T>
	 */
	public class WhereCondition<T> {
		/** 查询语句前缀 */
		private String condition;
		/** 单个查询条件值 */
		private T value;
		/** 多个查询条件值 */
		private Object[] values;
		/** 查询语句的后缀 */
		private String suffix;

		public WhereCondition(String condition, T value) {
			super();
			this.condition = condition;
			this.value = value;
		}

		public WhereCondition(String condition, T value, String suffix) {
			super();
			this.condition = condition;
			this.value = value;
			this.suffix = suffix;
		}

		public WhereCondition(String condition, String suffix, Object... values) {
			super();
			this.condition = condition;
			this.suffix = suffix;
			this.values = values;
		}

		public String getCondition() {
			return condition;
		}

		public void setCondition(String condition) {
			this.condition = condition;
		}

		public T getValue() {
			return value;
		}

		public void setValue(T value) {
			this.value = value;
		}

		public Object[] getValues() {
			return values;
		}

		public void setValues(Object[] values) {
			this.values = values;
		}

		public String getSuffix() {
			return suffix;
		}

		public void setSuffix(String suffix) {
			this.suffix = suffix;
		}

		@Override
		public String toString() {
			return "WhereCondition [condition=" + condition + ", value=" + value + ", values=" + Arrays.toString(values)
					+ ", suffix=" + suffix + "]";
		}

	}

	/**
	 * 添加查询条件,参数为Assist的内部类whereCondition,推荐使用Assist的静态条件方法添加条件;
	 * 
	 * @param condition 示例:setCondition(Assist.whereCondition("id",10))
	 */
	public void setCondition(WhereCondition<?> condition) {
		if (getCondition() == null) {
			this.condition = new ArrayList<>();
		}
		this.condition.add(condition);
	}

	/**
	 * 添加查询条件,参数为Assist的内部类whereCondition,推荐使用Assist的静态条件方法添加条件;
	 * 
	 * @param condition 示例:setCondition(Assist.whereCondition("id",10),Assist.whereCondition("id",10)...)
	 */
	public void setConditions(WhereCondition<?>... condition) {
		if (getCondition() == null) {
			this.condition = new ArrayList<>();
		}
		for (int i = 0; i < condition.length; i++) {
			this.condition.add(condition[i]);
		}
	}

	/**
	 * 添加并且条件,列名与表达式<br>
	 * 示例: column = id IS NULL<br>
	 * SQL: [and] id IS NULL
	 * 
	 * @param column 列名:如果表中存在相同列名使用表名.列名
	 * @return
	 */
	public <T> SqlAssist and(String column) {
		this.setCondition(new SqlAssist().new WhereCondition<T>("and " + column + " ", null));
		return this;
	}

	/**
	 * 添加或者条件,列名与表达式<br>
	 * 示例: column = id IS NULL<br>
	 * SQL: [or] id IS NULL
	 * 
	 * @param column 列名:如果表中存在相同列名使用表名.列名
	 * @return
	 */
	public <T> SqlAssist or(String column) {
		this.setCondition(new SqlAssist().new WhereCondition<T>("or " + column + " ", null));
		return this;
	}

	/**
	 * 
	 * 添加并且等于条件<br>
	 * 示例: column = id ,value =1<br>
	 * SQL: [and] id = 1
	 * 
	 * @param <T>
	 * @param column 列名:如果表中存在相同列名使用表名.列名
	 * @param value  条件值
	 * @return
	 */
	public <T> SqlAssist andEq(String column, T value) {
		setCondition(new SqlAssist().new WhereCondition<T>("and " + column + " = ", value));
		return this;
	}

	/**
	 * 添加或者等于条件<br>
	 * 示例: column = id ,value =1<br>
	 * SQL: [or] id = 1
	 * 
	 * @param <T>
	 * @param column 列名:如果表中存在相同列名使用表名.列名
	 * @param value  条件值
	 * @return
	 */
	public <T> SqlAssist orEq(String column, T value) {
		setCondition(new SqlAssist().new WhereCondition<T>("or " + column + " = ", value));
		return this;
	}

	/**
	 * 添加并且不等于条件<br>
	 * 示例: column = id ,value =1<br>
	 * SQL: [and] id <> 1
	 * 
	 * @param column 列名:如果表中存在相同列名使用表名.列名
	 * @param value  条件值
	 * @return
	 */
	public <T> SqlAssist andNeq(String column, T value) {
		setCondition(new SqlAssist().new WhereCondition<T>("and " + column + " <> ", value));
		return this;
	}

	/**
	 * 添加或者不等于条件<br>
	 * 示例: column = id ,value =1<br>
	 * SQL: [or] id <> 1
	 * 
	 * @param column 列名:如果表中存在相同列名使用表名.列名
	 * @param value  条件值
	 * @return
	 */
	public <T> SqlAssist orNeq(String column, T value) {
		setCondition(new SqlAssist().new WhereCondition<T>("or " + column + " <> ", value));
		return this;
	}

	/**
	 * 添加并且小于条件<br>
	 * 示例: column = id ,value =1<br>
	 * SQL: [and] id < 1
	 * 
	 * @param column 列名:如果表中存在相同列名使用表名.列名
	 * @param value  条件值
	 * @return
	 */
	public <T> SqlAssist andLt(String column, T value) {
		setCondition(new SqlAssist().new WhereCondition<T>("and " + column + "< ", value));
		return this;
	}

	/**
	 * 添加或者小于条件<br>
	 * 示例: column = id ,value =1<br>
	 * SQL: [or] id < 1
	 * 
	 * @param column 列名:如果表中存在相同列名使用表名.列名
	 * @param value  条件值
	 * @return
	 */
	public <T> SqlAssist orLt(String column, T value) {
		setCondition(new SqlAssist().new WhereCondition<T>("or " + column + " < ", value));
		return this;
	}

	/**
	 * 添加并且小于等于条件<br>
	 * 示例: column = id ,value =1<br>
	 * SQL: [and] id <= 1
	 * 
	 * @param column 列名:如果表中存在相同列名使用表名.列名
	 * @param value  条件值
	 * @return
	 */
	public <T> SqlAssist andLte(String column, T value) {
		setCondition(new SqlAssist().new WhereCondition<T>("and " + column + " <= ", value));
		return this;
	}

	/**
	 * 添加或者小于等于条件<br>
	 * 示例: column = id ,value =1<br>
	 * SQL: [or] id <= 1
	 * 
	 * @param column 列名:如果表中存在相同列名使用表名.列名
	 * @param value  条件值
	 * @return
	 */
	public <T> SqlAssist orLte(String column, T value) {
		setCondition(new SqlAssist().new WhereCondition<T>("or " + column + " <= ", value));
		return this;
	}

	/**
	 * 添加并且大于条件<br>
	 * 示例: column = id ,value =1<br>
	 * SQL: [and] id > 1
	 * 
	 * @param column 列名:如果表中存在相同列名使用表名.列名
	 * @param value  条件值
	 * @return
	 */
	public <T> SqlAssist andGt(String column, T value) {
		setCondition(new SqlAssist().new WhereCondition<T>("and " + column + " > ", value));
		return this;
	}

	/**
	 * 添加或者大于条件<br>
	 * 示例: column = id ,value =1<br>
	 * SQL: [or] id > 1
	 * 
	 * @param column 列名:如果表中存在相同列名使用表名.列名
	 * @param value  条件值
	 * @return
	 */
	public <T> SqlAssist orGt(String column, T value) {
		setCondition(new SqlAssist().new WhereCondition<T>("or " + column + " > ", value));
		return this;
	}

	/**
	 * 添加并且大于等于条件<br>
	 * 示例: column = id ,value =1<br>
	 * SQL: [and] id >= 1
	 * 
	 * @param column 列名:如果表中存在相同列名使用表名.列名
	 * @param value  条件值
	 * @return
	 */
	public <T> SqlAssist andGte(String column, T value) {
		setCondition(new SqlAssist().new WhereCondition<T>("and " + column + " >= ", value));
		return this;
	}

	/**
	 * 添加或者大于等于条件<br>
	 * 示例: column = id ,value =1<br>
	 * SQL: [or] id >= 1
	 * 
	 * @param column 列名:如果表中存在相同列名使用表名.列名
	 * @param value  条件值
	 * @return
	 */
	public <T> SqlAssist orGte(String column, T value) {
		setCondition(new SqlAssist().new WhereCondition<T>("or " + column + " >= ", value));
		return this;
	}

	/**
	 * 添加并且like条件<br>
	 * 示例: column = id ,value =%1%<br>
	 * SQL: [and] id like %1%
	 * 
	 * @param column 列名:如果表中存在相同列名使用表名.列名
	 * @param value  条件值
	 * @return
	 */
	public <T> SqlAssist andLike(String column, T value) {
		setCondition(new SqlAssist().new WhereCondition<T>("and " + column + " like ", value));
		return this;
	}

	/**
	 * 添加或者like条件<br>
	 * 示例: column = id ,value =%1%<br>
	 * SQL: [or] id like %1%
	 * 
	 * @param column 列名:如果表中存在相同列名使用表名.列名
	 * @param value  条件值
	 * @return
	 */
	public <T> SqlAssist orLike(String column, T value) {
		setCondition(new SqlAssist().new WhereCondition<T>("or " + column + " like ", value));
		return this;
	}

	/**
	 * 添加并且like条件<br>
	 * 示例: column = id ,value =%1%<br>
	 * SQL: [and] id not like %1%
	 * 
	 * @param column 列名:如果表中存在相同列名使用表名.列名
	 * @param value  条件值
	 * @return
	 */
	public <T> SqlAssist andNotLike(String column, T value) {
		setCondition(new SqlAssist().new WhereCondition<T>("and " + column + " not like ", value));
		return this;
	}

	/**
	 * 添加并且like条件<br>
	 * 示例: column = id ,value =%1%<br>
	 * SQL: [and] id not like %1%
	 * 
	 * @param column 列名:如果表中存在相同列名使用表名.列名
	 * @param value  条件值
	 * @return
	 */
	public <T> SqlAssist orNotLike(String column, T value) {
		setCondition(new SqlAssist().new WhereCondition<T>("or " + column + " not like ", value));
		return this;
	}

	/**
	 * 添加并且条件,列名与表达式<br>
	 * 示例: column = id<br>
	 * SQL: [and] id IS NULL
	 * 
	 * @param column 列名:如果表中存在相同列名使用表名.列名
	 * @return
	 */
	public <T> SqlAssist andIsNull(String column) {
		this.setCondition(new SqlAssist().new WhereCondition<T>("and " + column + " is null ", null));
		return this;
	}

	/**
	 * 添加或者条件,列名与表达式<br>
	 * 示例: column = id<br>
	 * SQL: [or] id IS NULL
	 * 
	 * @param column 列名:如果表中存在相同列名使用表名.列名
	 * @return
	 */
	public <T> SqlAssist orIsNull(String column) {
		this.setCondition(new SqlAssist().new WhereCondition<T>("or " + column + " is null ", null));
		return this;
	}

	/**
	 * SQL: [and] column is not null <br>
	 * 解释: 或者列名is not null
	 * 
	 * @param column 列名,如果存在相同列名则使用表名.列名
	 * @return
	 */
	public <T> SqlAssist andIsNotNull(String column) {
		this.setCondition(new SqlAssist().new WhereCondition<T>("and " + column + " is not null ", null));
		return this;
	}

	/**
	 * SQL: [or] column is not null <br>
	 * 解释: 或者列名is not null
	 * 
	 * @param column 列名,如果存在相同列名则使用表名.列名
	 * @return
	 */
	public <T> SqlAssist orIsNotNull(String column) {
		this.setCondition(new SqlAssist().new WhereCondition<T>("or " + column + " is not null ", null));
		return this;
	}

	/**
	 * 添加查询条件:列名 in 条件值 <br>
	 * 参数1(列名) in 参数2(条件值)<br>
	 * 结果: and 列名 in (条件值)
	 * 
	 * @param column 列名
	 * @param value  条件值
	 * @return
	 */
	public <T> SqlAssist andIn(String column, T value) {
		setCondition(new SqlAssist().new WhereCondition<T>("and " + column + " in (", value, " ) "));
		return this;
	}

	/**
	 * 添加查询条件:列名 in 条件值 <br>
	 * 参数1(列名) in 参数2(条件值)<br>
	 * 结果: or 列名 in (条件值)
	 * 
	 * @param column 列名
	 * @param value  条件值
	 * @return
	 */
	public <T> SqlAssist orIn(String column, T value) {
		setCondition(new SqlAssist().new WhereCondition<T>("or " + column + " in (", value, " ) "));
		return this;
	}

	/**
	 * 添加查询条件:列名 in 多个条件值 ,如果List可以调用list.toArray()<br>
	 * 参数1(列名) in 参数2(条件值,添加值...)<br>
	 * 结果: and 列名 in (条件值,添加值...)
	 * 
	 * @param column 列名
	 * @param values 条件值
	 * @return
	 */
	public <T> SqlAssist andIn(String column, Object... values) {
		setCondition(new SqlAssist().new WhereCondition<T>("and " + column + " in (", " ) ", values));
		return this;
	}

	/**
	 * 添加查询条件:列名 in 多个条件值 ,如果List可以调用list.toArray()<br>
	 * 参数1(列名) in 参数2(条件值,添加值...)<br>
	 * 结果: or 列名 in (条件值,添加值...)
	 * 
	 * @param column 列名
	 * @param values 条件值
	 * @return
	 */
	public <T> SqlAssist orIn(String column, Object... values) {
		setCondition(new SqlAssist().new WhereCondition<T>("or " + column + " in (", " ) ", values));
		return this;
	}

	/**
	 * 自定义查询条件 :<br>
	 * 参数1=自定义开头语句<br>
	 * 参数2=条件值<br>
	 * 参数3=自定义结尾语句<br>
	 * 如果表中存在相同列名使用表名.列名,如果不存在相同列名可以直接列名<br>
	 * 示例子查询:<br>
	 * 参数1= 列名 in (select 返回列名 from 表名 where 列名 = <br>
	 * 参数2= 123456<br>
	 * 参数3= ) <br>
	 * 假设有一张user表,里面有id列结果为:<br>
	 * select * from user where id in (select id from user where id=123456)<br>
	 * <b>需要特别注意的是,当where中不止一个条件的时候需要加上and或者or,根据自己的情况而定</b>
	 * 
	 * @param prefix
	 * @param value
	 * @param suffix
	 * @return
	 */
	public <T> SqlAssist customCondition(String prefix, T value, String suffix) {
		setCondition(new SqlAssist().new WhereCondition<T>(prefix, value, suffix));
		return this;
	}

	/**
	 * 获取一个查询条件
	 * 
	 * 示例:Assist.condition(" and id = ",1);
	 * 
	 * @param condition 条件的SQL语句比如 and id =
	 * @param value     条件的值
	 * @return
	 */
	public static <T> WhereCondition<T> whereCondition(String condition, T value) {
		return new SqlAssist().new WhereCondition<T>(condition, value);
	}

	/**
	 * 获取一个查询条件
	 * 
	 * 示例:Assist.condition(" and id in (",1,")");
	 * 
	 * @param condition 条件的SQL语句比如 and id =
	 * @param value     条件的值
	 * @param suffix    后缀
	 * @return
	 */
	public static <T> WhereCondition<T> whereCondition(String condition, T value, String suffix) {
		return new SqlAssist().new WhereCondition<T>(condition, value, suffix);
	}

	/**
	 * 获取一个查询条件
	 * 
	 * 示例:Assist.condition(" and id in (",")",1,2,3,4);
	 * 
	 * @param condition 条件的SQL语句比如 and id =
	 * @param suffix    后缀
	 * @param values    条件的值
	 * @return
	 */
	public static <T> WhereCondition<T> whereCondition(String condition, String suffix, Object... values) {
		return new SqlAssist().new WhereCondition<T>(condition, suffix, values);
	}

	/**
	 * 设置排序,通过Assist.order(列名,排序方式)<br>
	 * 示例:assist.setOrder(Assist.order("id",true))//将id正序排序
	 * 
	 * @param column
	 * @param mode
	 */

	/**
	 * 获取是否去重
	 * 
	 * @return
	 */
	public String getDistinct() {
		return distinct;
	}

	/**
	 * 设置是否去重
	 * 
	 * @param distinct
	 */
	public SqlAssist setDistinct(boolean distinct) {
		if (distinct) {
			this.distinct = "distinct";
		}
		return this;
	}

	/**
	 * 获取排序
	 * 
	 * @return
	 */
	public String getOrderBy() {
		return orderBy;
	}

	/**
	 * 设置排序 示例传入: id,type DESC<br>
	 * SQL: ORDER BY id ,type DESC
	 * 
	 * @param orderBy 排序规则,比如 id,type DESC
	 * @return
	 */
	public SqlAssist setOrderBy(String orderBy) {
		this.orderBy = " order by " + orderBy;
		return this;
	}

	/**
	 * 获取分组
	 * 
	 * @return
	 */
	public String getGroupBy() {
		return groupBy;
	}

	/**
	 * 设置分组 示例传入: id,type<br>
	 * SQL: GROUP BY id ,type
	 * 
	 * @param groupBy 要分组的列名比如id,type
	 * @return
	 */
	public SqlAssist setGroupBy(String groupBy) {
		this.groupBy = " group by " + groupBy;
		return this;
	}

	/**
	 * 添加and having条件<br>
	 * 示例: prefix = count(type) > ,value =2<br>
	 * SQL: [and] count(type)
	 * 
	 * @param <T>
	 * @param prefix 函数表达式或列名:如果表中存在相同列名使用表名.列名
	 * @param value  条件值
	 * @return
	 */
	public <T> SqlAssist andHaving(String prefix, T value) {
		if (getHaving() == null) {
			this.having = new ArrayList<>();
			this.having.add(new SqlAssist().new WhereCondition<T>(" having " + prefix, value));
		} else {
			this.having.add(new SqlAssist().new WhereCondition<T>("and " + prefix, value));
		}
		return this;
	}

	/**
	 * 添加or having条件<br>
	 * 示例: prefix = count(type) > ,value =2<br>
	 * SQL: [or] count(type)
	 * 
	 * @param <T>
	 * @param prefix 函数表达式或列名:如果表中存在相同列名使用表名.列名
	 * @param value  条件值
	 * @return
	 */
	public <T> SqlAssist orHaving(String prefix, T value) {
		if (getHaving() == null) {
			this.having = new ArrayList<>();
			this.having.add(new SqlAssist().new WhereCondition<T>(" having " + prefix, value));
		} else {

			this.having.add(new SqlAssist().new WhereCondition<T>("or " + prefix, value));
		}
		return this;
	}

	/**
	 * 获取分组查询
	 * 
	 * @return
	 */
	public List<WhereCondition<?>> getHaving() {
		return having;
	}

	/**
	 * 获取第几页
	 * 
	 * @return
	 */
	public Integer getPage() {
		return page;
	}

	/**
	 * 设置第几页,该值仅在limitAll方法中有效,最终会被转换为startRow
	 * 
	 * @param page
	 * @return
	 */
	public SqlAssist setPage(Integer page) {
		this.page = page;
		return this;
	}

	/**
	 * 获取开始分页行
	 * 
	 * @return
	 */
	public Integer getStartRow() {
		return startRow;
	}

	/**
	 * 设置从第几行开始取数据
	 * 
	 * @param startRow
	 */
	public SqlAssist setStartRow(Integer startRow) {
		this.startRow = startRow;
		return this;
	}

	/**
	 * 获取每次取多少行数据
	 * 
	 * @return
	 */
	public Integer getRowSize() {
		return rowSize;
	}

	/**
	 * 设置每次取多少很数据
	 * 
	 * @param rowSize
	 */
	public SqlAssist setRowSize(Integer rowSize) {
		this.rowSize = rowSize;
		return this;
	}

	/**
	 * 获取返回指定列
	 * 
	 * @return
	 */
	public String getResultColumn() {
		return resultColumn;
	}

	/**
	 * 设置返回指定列多个列以,逗号隔开;需要特别注意的是返回列需要起别名,别名以mapper里面的resultMap的column为准;
	 * 一般是类名加上属性的顺序号,
	 * 
	 * @return
	 */
	public SqlAssist setResultColumn(String resultColumn) {
		this.resultColumn = resultColumn;
		return this;
	}

	/**
	 * 获取自定义的属性值
	 * 
	 * @return
	 */
	public Object getCustomValue() {
		return customValue;
	}

	/**
	 * 设置自定义的属性值
	 * 
	 * @param customValue
	 */
	public SqlAssist setCustomValue(Object customValue) {
		this.customValue = customValue;
		return this;
	}

	/**
	 * 获取条件集
	 * 
	 * @return
	 */
	public List<WhereCondition<?>> getCondition() {
		return condition;
	}

	/**
	 * 初始化
	 */
	public SqlAssist() {
		super();
	}

	/**
	 * 初始化,该构造方法用于使用Assist的静态条件方法,动态添加条件
	 * 
	 * @param condition 示例:Assist.lt("id",10)...
	 */
	public SqlAssist(WhereCondition<?>... condition) {
		super();
		if (this.condition == null) {
			this.condition = new ArrayList<>();
		}
		for (int i = 0; i < condition.length; i++) {
			this.condition.add(condition[i]);
		}
	}

	@Override
	public String toString() {
		return "SqlAssist [distinct=" + distinct + ", orderBy=" + orderBy + ", groupBy=" + groupBy + ", page=" + page
				+ ", startRow=" + startRow + ", rowSize=" + rowSize + ", resultColumn=" + resultColumn + ", condition="
				+ condition + ", having=" + having + ", customValue=" + customValue + "]";
	}

}
