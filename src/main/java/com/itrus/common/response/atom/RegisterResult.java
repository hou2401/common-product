package com.itrus.common.response.atom;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * 用户注册返回实体
 * @author wgx52
 *
 */
/**
 * @apiDefine RegisterResult 用户注册返回实体
 * 
 * @apiParam {Long} uuid 用户注册id.
 *
 */
@Getter
@EqualsAndHashCode(callSuper=false)
public class RegisterResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * uuid 
	 * 注册成功，返回用户注册uuid
	 */
	private Long uuid;
	
}
