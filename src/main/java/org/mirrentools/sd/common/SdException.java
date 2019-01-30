package org.mirrentools.sd.common;

/**
 * 代码生成器的异常类
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class SdException extends RuntimeException {
	private static final long serialVersionUID = 5236581232824826486L;

	/**
	 * 初始化一个异常
	 * 
	 * @param msg
	 */
	public SdException(String msg) {
		super(msg);
	}

	/**
	 * 初始化一个异常
	 * 
	 * @param throwable
	 */
	public SdException(Throwable throwable) {
		super(throwable);
	}

	/**
	 * 初始化一个异常
	 * 
	 * @param msg
	 */
	public SdException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

}
