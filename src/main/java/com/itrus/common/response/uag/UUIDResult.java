package com.itrus.common.response.uag;

import java.io.Serializable;

import lombok.*;

/**
 * 用户注册返回实体
 * @author wgx52
 *
 */
/**
 *
 * @apiDefine RegisterResult 用户注册返回实体
 * 
 * @apiParam {Long} uuid 用户注册id.
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class UUIDResult implements Serializable{

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
