package org.mirrentools.sd;

import org.mirrentools.sd.common.SdUtil;

public class SdUtilTest {
	public static void main(String[] args) {
		String str = "my_name_is_mirren-my-NameIsMirren出生年份BornIn1991";
		System.out.println("原字符串: " + str);
		String camelCase = SdUtil.toCamelCase(str);
		System.out.println(camelCase);
		String pascalCase = SdUtil.toPascalCase(str);
		System.out.println(pascalCase);
		String underScoreCase = SdUtil.toUnderScoreCase(str);
		System.out.println(underScoreCase);
		String upperUnderScoreCase = SdUtil.toUnderScoreCaseUpper(str);
		System.out.println(upperUnderScoreCase);
		String hyphenCase = SdUtil.toHyphenCase(str);
		System.out.println(hyphenCase);
		String upperHyphenCase = SdUtil.toHyphenCaseUpper(str);
		System.out.println(upperHyphenCase);

	}
}
