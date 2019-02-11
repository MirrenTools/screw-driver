package org.mirrentools.sd;

import java.io.File;
import java.net.URL;

public class MyTest {
	public static void main(String[] args) {
		URL url = Thread.currentThread().getContextClassLoader().getResource("templates");
		File file = new File(url.getFile());
		System.out.println(file.exists());
	}
}
