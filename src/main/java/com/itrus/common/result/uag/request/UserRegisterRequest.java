package com.itrus.common.result.uag.request;

import com.itrus.common.request.base.UserBase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 个人账号注册
 */
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class UserRegisterRequest extends UserBase {
	
	/**
	 * 账号来源 0:Saas(默认)  1: Api
	 */
	private String sourceType;
	
	/**
	 * 来源编码 来源是API，需要传入AppID
	 */
	private String sourceCode;

}
