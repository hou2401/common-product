package com.itrus.common.exception;

/**
 * 
 * 个人实名认证异常类
 * @author wen_guoxing
 *
 */
public class PersionAuthException extends AuthException {
	private static final long serialVersionUID = 1L;
	public PersionAuthException() {
		super();
	}
	public PersionAuthException(String msg) {
		super(msg);
	}
	public PersionAuthException(String msg, Throwable throwable) {
		super(msg, throwable);
	}
	public PersionAuthException(Throwable throwable) {
		super(throwable);
	}
}
