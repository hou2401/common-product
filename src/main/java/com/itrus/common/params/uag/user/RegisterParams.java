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
