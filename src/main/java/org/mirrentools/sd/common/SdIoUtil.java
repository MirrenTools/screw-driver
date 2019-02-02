package org.mirrentools.sd.common;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Io相关工具,如果JDK大于等于1.7其实用Files也很方便的
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public class SdIoUtil {
	/**
	 * 写数据后同时将流关闭
	 * 
	 * @param inputStream
	 * @param outputStream
	 * @throws Exception
	 */
	public static void writeAndClose(InputStream inputStream, OutputStream outputStream) throws Exception {
		BufferedInputStream input = null;
		BufferedOutputStream output = null;
		try {
			input = new BufferedInputStream(inputStream);
			output = new BufferedOutputStream(outputStream);
			byte[] bs = new byte[1024];
			int len = 0;
			while ((len = input.read(bs)) != -1) {
				output.write(bs, 0, len);
			}
			output.flush();
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (input != null) {
					input.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (output != null) {
					output.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (outputStream != null) {
					outputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
