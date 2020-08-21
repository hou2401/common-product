package com.itrus.common.result.uag.enterprise;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;
import com.itrus.common.result.uag.UagResult;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 企业注册返回结果
 * @author Administrator
 *
 */
@ToString
@Data
public class RegisteredEnterpriseResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 与rootUuid一样
	 */
	private Long uuid;

	/**
	 * 根节点组织id
	 */
	private Long rootUuid;
	
	/**
	 * 管理员id
	 */
	private Long adminUuid;
	
	/**
	 * uuid 
	 */
	public static final String UUID_KEY="uuid";
	
	
	
	
}
