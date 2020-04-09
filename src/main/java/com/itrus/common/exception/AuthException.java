package com.itrus.common.exception;

/**
 * 
 * 实名认证异常类
 * @author wen_guoxing
 *
 */
public class AuthException extends ItrusException {
	private static final long serialVersionUID = 1L;
	public AuthException() {
		super();
	}
	public AuthException(String msg) {
		super(msg);
	}
	public AuthException(String msg, Throwable throwable) {
		super(msg, throwable);
	}
	public AuthException(Throwable throwable) {
		super(throwable);
	}
}
