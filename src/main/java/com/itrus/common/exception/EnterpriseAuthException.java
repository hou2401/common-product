package com.itrus.common.exception;

/**
 * 
 * 企业实名认证异常类
 * @author wen_guoxing
 *
 */
public class EnterpriseAuthException extends Exception {
	private static final long serialVersionUID = 1L;
	public EnterpriseAuthException() {
		super();
	}
	public EnterpriseAuthException(String msg) {
		super(msg);
	}
	public EnterpriseAuthException(String msg, Throwable throwable) {
		super(msg, throwable);
	}
	public EnterpriseAuthException(Throwable throwable) {
		super(throwable);
	}
}
