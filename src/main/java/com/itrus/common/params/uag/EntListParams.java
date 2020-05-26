package com.itrus.common.params.uag;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

@ApiModel(description = "请求UAG部门实体类")
@ToString
@Data
public class EntListParams {
	
	/**
	 * 当前登录手机号
	 */
	private String phone;
	
	/**
	 * 登录状态 不传默认全查
	 */
	private String joinState;
	
	public EntListParams(String phone, String joinState) {
		super();
		this.phone = phone;
		this.joinState = joinState;
	}
	
	public EntListParams(String phone) {
		super();
		this.phone = phone;
	}

	public EntListParams() {
		super();
	}
    
}
