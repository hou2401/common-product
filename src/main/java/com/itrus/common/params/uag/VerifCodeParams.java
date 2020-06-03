package com.itrus.common.params.uag;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

@ApiModel(description = "请求UAG部门实体类")
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
