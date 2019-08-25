package org.mirrentools.sd;

import java.io.File;
import java.net.URL;

import org.mirrentools.sd.options.ScrewDriverOptions;
import org.mirrentools.sd.options.def.ScrewDriverMySqlOptions;

public class MyTest {
	public static void main(String[] args) {
		ScrewDriverMySqlOptions options = new ScrewDriverMySqlOptions(null, null);
		System.out.println(options);
		System.exit(0);
		URL url = Thread.currentThread().getContextClassLoader().getResource("templates");
		File file = new File(url.getFile());
		System.out.println(file.exists());
	}
}
