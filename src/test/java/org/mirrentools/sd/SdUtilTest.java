package org.mirrentools.sd;

import org.mirrentools.sd.common.SdUtil;

public class SdUtilTest {
	public static void main(String[] args) {
		String score = SdUtil.replaceToUnderScore("nameREMOVEnameIsMirren", " ", "-");
		System.out.println(score);
		System.out.println("*********************");
		String camelCase = SdUtil.toCamelCase("NameREMOVEnameIsMirren");
		System.out.println(camelCase);

	}
}
