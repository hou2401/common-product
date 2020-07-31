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
	private Long uuid;
	
	/**
	 * 登录状态 不传默认全查
	 */
	private String joinState;
	
	public EntListParams(String phone, String joinState) {
		super();
		this.phone = phone;
		this.joinState = joinState;
	}
	
	public EntListParams(Long uuid, String joinState) {
		super();
		this.uuid = uuid;
		this.joinState = joinState;
	}
	
	public EntListParams(String phone) {
		super();
		this.phone = phone;
	}

	public EntListParams() {
		super();
	}

	public EntListParams(Long uuid) {
		super();
		this.uuid = uuid;
	}
}
