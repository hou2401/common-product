package com.itrus.common.exception;

/**
 * <p>Title: ItrusException.java</p>
 * <p>Description: 异常信息类</p>
 * <p>Copyright: Copyright (c) 2019</p>
 * <p>Company: com.itrus</p>
 * @author wen_guoxing
 * @date 2019年8月9日
 * @version 1.0
 */
public class ItrusException extends RuntimeException {
	private static final long serialVersionUID = -7319532573008583652L;

	/**
	 * 异常码
	 */
	protected int code = 1;

	/**
	 * 异常信息
	 */
	private String msg;

	private ItrusException(int code, String msgFormat, Object... args) {
		super(String.format(msgFormat, args));
		this.code = code;
		this.msg = String.format(msgFormat, args);
	}

	public ItrusException() {
		super();
	}

	@Override
	public String getMessage() {
		return msg;
	}

	public int getCode() {
		return code;
	}

	/**
	 * 实例化异常
	 * @param msgFormat msgFormat
	 * @param args args
	 * @return ItrusException
	 */
	public ItrusException newInstance(String msgFormat, Object... args) {
		return new ItrusException(this.code, msgFormat, args);
	}

	public ItrusException(String message, Throwable cause) {
		super(message, cause);
		this.msg = message;
	}

	public ItrusException(Throwable cause) {
		super(cause);
		this.msg = this.getMessage();
	}

	public ItrusException(String message) {
		super(message);
		this.msg = message;
	}
}
