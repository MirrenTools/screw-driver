package org.mirrentools.sd;

import static org.hamcrest.CoreMatchers.both;

import java.io.File;
import java.net.URL;

import org.mirrentools.sd.options.ScrewDriverOptions;
import org.mirrentools.sd.options.def.ScrewDriverMySqlOptions;

public class MyTest {
	public static void main(String[] args) {
		System.exit(0);
		ScrewDriverMySqlOptions options = new ScrewDriverMySqlOptions(null, null);
		System.out.println(options);
		URL url = Thread.currentThread().getContextClassLoader().getResource("templates");
		File file = new File(url.getFile());
		System.out.println(file.exists());
	}
}
