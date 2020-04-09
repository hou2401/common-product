package com.itrus.common.exception;

/**
 * 
 * 调用UAG异常
 * @author wen_guoxing
 *
 */
public class UagException extends AuthException {
	private static final long serialVersionUID = 1L;
	public UagException() {
		super();
	}
	public UagException(String msg) {
		super(msg);
	}
	public UagException(String msg, Throwable throwable) {
		super(msg, throwable);
	}
	public UagException(Throwable throwable) {
		super(throwable);
	}
}
