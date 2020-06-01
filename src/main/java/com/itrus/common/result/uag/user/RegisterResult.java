package com.itrus.common.result.uag.user;

import com.alibaba.fastjson.JSONObject;
import com.itrus.common.result.uag.UagResult;

import lombok.EqualsAndHashCode;

/**
 * 用户注册返回实体
 * @author wgx52
 *
 */
@EqualsAndHashCode(callSuper=false)
public class RegisterResult extends UagResult{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * uuid 
	 * 注册成功，返回用户注册uuid
	 */
	private Long uuid;
	
	public Long getUuid(){
		
		JSONObject data = this.getData();
		
		uuid = data.getLong("uuid");
		
		return uuid;
	}
	
}
