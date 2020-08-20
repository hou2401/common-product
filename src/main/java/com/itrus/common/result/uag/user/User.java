package com.itrus.common.result.uag.user;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * 用户注册返回实体
 * @author wgx52
 *
 */
@Getter
@EqualsAndHashCode(callSuper=false)
public class User implements Serializable{

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
