package com.itrus.common.params.uag;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class VerifCodeParams {
	
	/**
	 * 管理员账号
	 */
	private String phone;
	
	/**
	 * 短信模板
	 */
	private String msgTemplate;
	
	public VerifCodeParams(String phone,String msgTemplate) {
		super();
		this.phone = phone;
		this.msgTemplate = msgTemplate;
	}

	public VerifCodeParams() {
		super();
	}
    
}
