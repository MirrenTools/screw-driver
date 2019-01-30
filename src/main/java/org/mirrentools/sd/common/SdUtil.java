package org.mirrentools.sd.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 字符串工具
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public class SdUtil {
	/** 默认分词符号 */
	public final static String DEFAULT_PARTICIPLE_FLAG = "<--->";
	/** 分词中默认要移除的字符串 */
	public final static List<String> DEFAULT_PARTICIPLE_EXCLUDES = asList(" ");
	/** 分词中默认要转换为连接词的字符串 */
	public final static List<String> DEFAULT_PARTICIPLE_TO_JOIN = asList("-", "_");

	/**
	 * 获取用户项目根目录
	 * 
	 * @return
	 */
	public static String getUserDir() {
		return System.getProperty("user.dir") + "/";
	}

	/**
	 * 将字符串转换为连字符命名
	 * 
	 * @param str
	 * @return
	 */
	public static String toHyphenCase(String str) {
		String underScore = splitJoin(str, DEFAULT_PARTICIPLE_FLAG);
		String[] split = underScore.split(DEFAULT_PARTICIPLE_FLAG);
		StringBuilder sb = new StringBuilder(split[0]);
		for (int i = 1; i < split.length; i++) {
			sb.append("-" + split[i]);
		}
		return sb.toString().replaceAll("-+", "-");
	}

	/**
	 * 将字符串转换为连字符命名
	 * 
	 * @param str
	 * @return
	 */
	public static String toHyphenCaseUpper(String str) {
		return toHyphenCase(str).toUpperCase();
	}

	/**
	 * 将字符串转换为下划线命名
	 * 
	 * @param str
	 * @return
	 */
	public static String toUnderScoreCase(String str) {
		String underScore = splitJoin(str, DEFAULT_PARTICIPLE_FLAG);
		String[] split = underScore.split(DEFAULT_PARTICIPLE_FLAG);
		StringBuilder sb = new StringBuilder(split[0]);
		for (int i = 1; i < split.length; i++) {
			sb.append("_" + split[i]);
		}
		return sb.toString().replaceAll("_+", "_");
	}

	/**
	 * 将字符串转换为下划线命名
	 * 
	 * @param str
	 * @return
	 */
	public static String toUnderScoreCaseUpper(String str) {
		return toUnderScoreCase(str).toUpperCase();
	}

	/**
	 * 将字符串转换成帕斯卡命名规范
	 * 
	 * @param str
	 * @return
	 */
	public static String toPascalCase(String str) {
		String underScore = splitJoin(str, DEFAULT_PARTICIPLE_FLAG);
		String[] split = underScore.split(DEFAULT_PARTICIPLE_FLAG);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < split.length; i++) {
			sb.append(firstToUpperCase(split[i]));
		}
		return sb.toString();

	}

	/**
	 * 将字符串转换成驼峰命名规范
	 * 
	 * @param str
	 * @return
	 */
	public static String toCamelCase(String str) {
		String underScore = splitJoin(str, DEFAULT_PARTICIPLE_FLAG);
		String[] split = underScore.split(DEFAULT_PARTICIPLE_FLAG);
		StringBuilder sb = new StringBuilder(split[0]);
		for (int i = 1; i < split.length; i++) {
			sb.append(firstToUpperCase(split[i]));
		}
		return sb.toString();
	}

	/**
	 * 将字符串首字母大写
	 * 
	 * @param str
	 * @return
	 */
	public static String firstToUpperCase(String str) {
		if (str != null && str.length() > 0) {
			char[] s = str.toCharArray();
			if (s[0] >= 97 && s[0] <= 122) {
				s[0] -= 32;
				return String.valueOf(s);
			}
		}
		return str;
	}

	/**
	 * 将字符串首字母小写
	 * 
	 * @param str
	 * @return
	 */
	public static String firstToLowerCase(String str) {
		if (str != null && str.length() > 0) {
			char[] s = str.toCharArray();
			if (s[0] >= 65 && s[0] <= 90) {
				s[0] += 32;
				return String.valueOf(s);
			}
		}
		return str;
	}

	/**
	 * 将字符串大小写字母按词拆分,并将其连接成新的字符串
	 * 
	 * @param str
	 *          字符串
	 * @param join
	 *          连接词,如果字符串存在loin则按join分词并返回
	 * @return
	 */
	public static String splitJoin(String str, String join) {
		return splitJoin(str, join, DEFAULT_PARTICIPLE_EXCLUDES, DEFAULT_PARTICIPLE_TO_JOIN);
	}

	/**
	 * 将字符串大小写字母按词拆分,并将其连接成新的字符串
	 * 
	 * @param str
	 *          字符串
	 * @param join
	 *          连接词,如果字符串存在join则按join分词并返回
	 * @param excludes
	 *          去除掉那些词
	 * @param replaceToJoin
	 *          将那些词替换为join,替换后如果字符串存在join则按join分词并返回
	 * @return
	 */
	public static String splitJoin(String str, String join, List<String> excludes, List<String> replaceToJoin) {
		// 删除排除的词
		if (excludes != null) {
			for (String r : excludes) {
				str = str.replace(r, "");
			}
		}
		// 替换指定词为join
		if (replaceToJoin != null) {
			for (String r : replaceToJoin) {
				str = str.replace(r, join);
			}
		}
		// 替换字符串多种多个join为一个
		str = str.replaceAll(join + "+", join);
		// if (str.indexOf(join) != -1) {
		// return str.toLowerCase();
		// }
		// 分词
		List<String> splits = new ArrayList<String>();
		for (int i = 0; i < str.length();) {
			StringBuilder word = new StringBuilder();
			char c = str.charAt(i);
			word.append(c);
			i++;
			if (isLetters(c)) {
				while (i < str.length()) {
					char c1 = str.charAt(i);
					if (isLetters(c1)) {
						if (isLower(c) == isLower(c1)) {
							word.append(c1);
							i++;
						} else {
							break;
						}
					} else {
						break;
					}
				}
			} else {
				while (i < str.length()) {
					char c1 = str.charAt(i);
					if (!isLetters(c1)) {
						word.append(c1);
						i++;
					} else {
						break;
					}
				}
			}
			splits.add(word.toString());
		}
		// 组词
		List<String> items = new ArrayList<String>();
		for (int i = 0; i < splits.size();) {
			if (splits.get(i).length() == 1) {
				if (isNumber(splits.get(i))) {
					if (items.size() > 0) {
						String last = items.get(items.size() - 1);
						items.remove(items.size() - 1);
						items.add(last + splits.get(i));
						i++;
						if (i == splits.size()) {
							break;
						}
					}
				} else {
					StringBuilder sb = new StringBuilder(splits.get(i));
					i++;
					if (i < splits.size()) {
						sb.append(splits.get(i));
						i++;
					}
					items.add(sb.toString());
				}
			} else {
				items.add(splits.get(i));
				i++;
			}
		}
		return magre(join, items).toLowerCase().replaceAll(join + "+", join);
	}

	/**
	 * 判断字符是否为英文中的26大小写字母
	 * 
	 * @param c
	 * @return
	 */
	public static boolean isLetters(char c) {
		if (c >= 65 && c <= 90) {
			return true;
		} else if (c >= 97 && c <= 122) {
			return true;
		}
		return false;
	}

	/**
	 * 判断字符是否为英文中的26小写字母
	 * 
	 * @param c
	 * @return
	 */
	public static boolean isLower(char c) {
		if (c >= 97 && c <= 122) {
			return true;
		}
		return false;
	}

	/**
	 * 判断字符是否为英文中的26大写字母
	 * 
	 * @param c
	 * @return
	 */
	public static boolean isUpper(char c) {
		if (c >= 65 && c <= 90) {
			return true;
		}
		return false;
	}

	/**
	 * 判断字符串是否为数字
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumber(String str) {
		for (char c : str.toCharArray()) {
			if (!(c >= 48 && c <= 57)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 检查字符串里面是否包含指定字符,包含返回true
	 * 
	 * @param regex
	 *          指定字符
	 * @param str
	 *          字符串
	 * @return
	 */
	public static boolean indexOf(String regex, String... str) {
		if (str == null) {
			return false;
		}
		for (String temp : str) {
			if (temp.indexOf(regex) == -1) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 如果jdk大于1.8可以直接使用String.join<br>
	 * 将字符串中间以separator连接起来<br>
	 * 示例:magre(".","1","2","3") 结果:"1.2.3"
	 * 
	 * @param separator
	 * @param str
	 * @return
	 */
	public static String magre(String separator, String... str) {
		StringBuilder result = null;
		for (String temp : str) {
			if (result == null) {
				result = new StringBuilder(temp);
			}
			result.append(separator + temp);
		}
		return result == null ? null : result.toString();
	}

	/**
	 * 将字符串集合按指定字符串拼接成一个新的字符串
	 * 
	 * @param separator
	 *          分割符号
	 * @param items
	 *          字符串数组
	 * @return
	 */
	public static String magre(String separator, List<String> items) {
		StringBuilder result = new StringBuilder();
		boolean first = true;
		for (String temp : items) {
			if (!first) {
				result.append(separator);
			}
			result.append(temp);
			if (first) {
				first = false;
			}
		}
		return result.toString();
	}

	/**
	 * 将字符串str中带有集合中rep[0]的字符串,代替为rep[1]的中的字符串
	 * 
	 * @param str
	 * @param rep
	 * @return
	 */
	public static String replace(String str, List<String[]> rep) {
		for (String[] item : rep) {
			if (item[1] == null) {
				item[1] = "";
			}
			str = str.replace(item[0], item[1]);
		}
		return str;
	}

	/**
	 * 创建字符串数组
	 * 
	 * @param str
	 * @return
	 */
	public static String[] asStrArray(String... str) {
		return str;
	}

	/**
	 * 将对象转换为List数组
	 * 
	 * @param t
	 * @return
	 */
	@SafeVarargs
	public static <T> List<T> asList(T... t) {
		return Arrays.asList(t);
	}

	/**
	 * 判断字符串是否为null或者空,如果是返回true
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNullOrEmpty(String str) {
		if (str == null || "".equals(str.trim())) {
			return true;
		}
		return false;
	}

	/**
	 * 判断字符串是否为null或者空,如果是返回true
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNullOrEmpty(String... str) {
		for (int i = 0; i < str.length; i++) {
			if (str[i] == null || "".equals(str[i].trim())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 判断一个对象是否为null或者空,如果是返回true
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNullOrEmpty(Object obj) {
		if (obj == null) {
			return true;
		}
		return false;
	}

	/**
	 * 判断一个对象是否为null或者空,如果是返回true
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNullOrEmpty(Object... obj) {
		for (int i = 0; i < obj.length; i++) {
			if (obj[i] == null) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 判断一个List对象是否为null或者空,如果是返回true
	 * 
	 * @param str
	 * @return
	 */
	@SafeVarargs
	public static <T> boolean isNullOrEmpty(List<T>... list) {
		for (int i = 0; i < list.length; i++) {
			if (list[i] == null || list[i].isEmpty()) {
				return true;
			}
		}
		return false;
	}

}
