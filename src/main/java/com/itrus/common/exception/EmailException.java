package com.itrus.common.exception;

/**
 * 
* Copyright: Copyright (c) 2019 LanRu-Caifu
* 
* @ClassName: SmsException.java
* @Description: 发送邮件异常
*
* @version: v1.0.0
* @author: wen_guoxing
* @date: 2019年5月9日 下午6:44:24 
*
 */
public class EmailException extends Exception {
    private static final long serialVersionUID = 1L;
    public EmailException() {
        super();
    }
    public EmailException(String msg) {
        super(msg);
    }
    public EmailException(String msg, Throwable throwable) {
        super(msg, throwable);
    }
    public EmailException(Throwable throwable) {
        super(throwable);
    }
}
