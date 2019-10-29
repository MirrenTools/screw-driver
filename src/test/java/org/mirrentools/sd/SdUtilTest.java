package org.mirrentools.sd;

import java.io.File;
import java.io.IOException;

import org.mirrentools.sd.common.SdUtil;

public class SdUtilTest {
	public static void main(String[] args) throws IOException {
		String file = SdUtil.readFileToString(new File("D:/TempJect/input.txt"));
		System.out.println(file);
		
		System.exit(0);
		String str = "my_name_is_mirren-my-NameIsMirrenNAME id mirren出生年份BornIn1991";
		System.out.println("原字符串: " + str);
		String camelCase = SdUtil.toCamelCase(str);
		System.out.println("camelCase: " + camelCase);
		String pascalCase = SdUtil.toPascalCase(str);
		System.out.println("pascalCase: " + pascalCase);
		String underScoreCase = SdUtil.toUnderScoreCase(str);
		System.out.println("underScoreCase: " + underScoreCase);
		String upperUnderScoreCase = SdUtil.toUnderScoreCaseUpper(str);
		System.out.println("upperUnderScoreCase: " + upperUnderScoreCase);
		String hyphenCase = SdUtil.toHyphenCase(str);
		System.out.println("hyphenCase: " + hyphenCase);
		String upperHyphenCase = SdUtil.toHyphenCaseUpper(str);
		System.out.println("upperHyphenCase: " + upperHyphenCase);

	}
}
