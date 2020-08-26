package com.itrus.common.params.uag;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class EntListParams {
	
	/**
	 * 当前登录手机号
	 */
	private String phone;
	
	/**
	 * 用户的userId
	 */
	private String uuid;
	
	/**
	 * 登录状态 不传默认全查
	 */
	private String joinState;
	
	public EntListParams(String uuid, String phone, String joinState) {
		super();
		this.uuid = uuid;
		this.phone = phone;
		this.joinState = joinState;
	}
	public EntListParams(String uuid) {
		super();
		this.uuid = uuid;
	}
	
	public EntListParams() {
		super();
	}
}
