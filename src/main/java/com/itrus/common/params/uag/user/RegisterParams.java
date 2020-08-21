package com.itrus.common.params.uag.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 用户注册
 * @author wgx52
 *
 */
/**
 * @apiDefine RegisterParams 用户注册请求实体
 * 
 * @apiParam {String} phone 手机号.
 * @apiParam {String} passwd 密码.
 * @apiParam {String} state 账号状态 0未激活，1正常（默认） 2挂起.
 *
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RegisterParams {

	/**
	 * 手机号
	 */
	private String phone;
	
	/**
	 * 密码
	 */
	private String passwd;
	
	
	/**
	 * 账号状态
	 * 状态 详见 1.3.3
	 * com.itrus.common.enums.uag.account.AccountStatus
	 */
	private String state;
	
}
