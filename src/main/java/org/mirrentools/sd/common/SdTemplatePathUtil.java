package org.mirrentools.sd.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.logging.Logger;

/**
 * 获取路径的目录
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public class SdTemplatePathUtil {
	/** JUL日志 */
	private static final Logger LOG = Logger.getLogger(SdTemplatePathUtil.class.getName());
	/** 默认的模板文件夹 */
	private final static String DEFAULT_PATH = "SdTemplates/";

	/**
	 * 获取模板所在文件夹,返回的文件夹有可能不是/结尾 获取顺序获取,如果到最后还获取不到则抛出异常<br>
	 * 如果path为空则获取 <br>
	 * 1. classPath/SdTemplates<br>
	 * 2. user.dir/SdTemplates<br>
	 * 3. 创建user.dir/SdTemplates<br>
	 * 如果path不为空则获取<br>
	 * 1. path<br>
	 * 2. user.dir/path<br>
	 * 3. user.dir/SdTemplates/path<br>
	 * 4. 创建user.dir/SdTemplates/path<<br>
	 * 
	 * @return
	 */
	public static String getPath(String path) {
		if (SdUtil.isNullOrEmpty(path)) {
			return getPath();
		}
		if (new File(path).exists()) {
			return path;
		}
		String userdir = SdUtil.getUserDir() + path;
		if (new File(userdir).exists()) {
			return userdir;
		}
		String userdirTemplates = SdUtil.getUserDir() + DEFAULT_PATH + path;
		File file = new File(userdirTemplates);
		if (!file.exists()) {
			boolean res = file.mkdirs();
			LOG.info("create " + userdirTemplates + " -->" + res);
		}
		return userdirTemplates;
	}

	/**
	 * getPath(String path)当path为null时的实现
	 * 
	 * @return
	 */
	public static String getPath() {
		URL url = Thread.currentThread().getContextClassLoader().getResource(DEFAULT_PATH);
		if (new File(url.getFile()).exists()) {
			return url.getFile();
		}
		if (new File(DEFAULT_PATH).exists()) {
			return DEFAULT_PATH;
		}
		String userdir = SdUtil.getUserDir() + DEFAULT_PATH;
		File file = new File(userdir);
		if (!file.exists()) {
			boolean res = file.mkdirs();
			LOG.info("create " + userdir + " -->" + res);
		}
		return userdir;
	}

	/**
	 * 获取文件,也可以用于做为检查文件是否存在,不存在就复制架包的文件<br>
	 * 获取模板的规则,获取顺序获取,如果到最后还获取不到则抛出异常<br>
	 * 1. SdTemplates/file<br>
	 * 2. user.dir/SdTemplates/file<br>
	 * 3. 复制screw-driver-X.jar/SdTemplates/file 到 user.dir/SdTemplates/file<br>
	 * 
	 * @param path
	 *          所在路径
	 * @param fileName
	 *          文件的名称
	 * @return
	 */
	public static File getFile(String fileName) {
		return getFile(null, fileName);
	}

	/**
	 * 获取文件,也可以用于做为检查文件是否存在,不存在就复制架包的文件<br>
	 * 获取模板的规则,获取顺序获取,如果到最后还获取不到则抛出异常<br>
	 * 1. path/file<br>
	 * 2. user.dir/SdTemplates/path/file<br>
	 * 3. 复制screw-driver-X.jar/SdTemplates/path/file 到
	 * user.dir/SdTemplates/path/file<br>
	 * 4. 复制screw-driver-X.jar/SdTemplates/file 到 user.dir/SdTemplates/path/file<br>
	 * 
	 * @param path
	 *          所在路径
	 * @param fileName
	 *          文件的名称
	 * @return
	 */
	public static File getFile(String path, String fileName) {
		SdUtil.requireNonNull(fileName, "模板文件的名字不能为空");
		String dir = getPath(path);
		if (!dir.endsWith("/")) {
			dir += "/";
		}
		File file = new File(dir + fileName);
		if (file.exists()) {
			return file;
		}
		InputStream inputStream = null;
		if (path == null) {
			path = "";
		} else if (!path.endsWith("/")) {
			path += "/";
		}

		try {
			String jarPath = SdTemplatePathUtil.class.getProtectionDomain().getCodeSource().getLocation().getFile();
			URL url = new URL("jar:file:" + jarPath + "!/" + path + fileName);
			inputStream = url.openStream();
			LOG.info(String.format("copy template \nfrom: %s \nto: %s", url.toString(), file.toString()));
		} catch (IOException e) {
			try {
				String jarPath = SdTemplatePathUtil.class.getProtectionDomain().getCodeSource().getLocation().getFile();
				URL url = new URL("jar:file:" + jarPath + "!/" + DEFAULT_PATH + path + fileName);
				inputStream = url.openStream();
				LOG.info(String.format("copy template \nfrom: %s \nto: %s", url.toString(), file.toString()));
			} catch (IOException e1) {
				try {
					String jarPath = SdTemplatePathUtil.class.getProtectionDomain().getCodeSource().getLocation().getFile();
					URL url = new URL("jar:file:" + jarPath + "!/" + DEFAULT_PATH + fileName);
					inputStream = url.openStream();
					LOG.info(String.format("copy template \nfrom: %s \nto: %s", url.toString(), file.toString()));
				} catch (IOException e2) {
					throw new SdException("没有找到file查找规则中的文件");
				}
			}
		}

		OutputStream outputStream = null;
		try {
			boolean newFile = file.createNewFile();
			if (!newFile) {
				return null;
			}
			outputStream = new FileOutputStream(file);
			SdIoUtil.writeAndClose(inputStream, outputStream);
			return file;
		} catch (Exception e) {
			throw new SdException(e);
		}
	}

}
