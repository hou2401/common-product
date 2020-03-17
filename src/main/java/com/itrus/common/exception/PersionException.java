package com.itrus.common.exception;

/**
 * 
 * 个人实名认证异常类
 * @author wen_guoxing
 *
 */
public class PersionException extends Exception {
	private static final long serialVersionUID = 1L;
	public PersionException() {
		super();
	}
	public PersionException(String msg) {
		super(msg);
	}
	public PersionException(String msg, Throwable throwable) {
		super(msg, throwable);
	}
	public PersionException(Throwable throwable) {
		super(throwable);
	}
}
