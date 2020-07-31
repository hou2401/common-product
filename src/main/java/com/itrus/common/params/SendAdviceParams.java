package com.itrus.common.params;

import lombok.Data;
import lombok.ToString;

/**
 * 发送通知公共实体
 * @author wgx52
 *
 */
@Data
@ToString
public class SendAdviceParams {
	
	/**
	 * 邮件实体
	 */
	private EmailParams email;
	
	/**
	 * 短信实体
	 */
	private SmsParams sms;

	public SendAdviceParams(EmailParams email, SmsParams sms) {
		super();
		this.email = email;
		this.sms = sms;
	}

	public SendAdviceParams() {
		super();
		// TODO Auto-generated constructor stub
	}
}
