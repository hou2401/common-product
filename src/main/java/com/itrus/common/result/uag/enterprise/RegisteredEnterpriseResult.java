package com.itrus.common.result.uag.enterprise;

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
@EqualsAndHashCode(callSuper=true)
public class RegisteredEnterpriseResult extends UagResult{

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
	
	
	/**
	 *  是否存在
	 *
	 * @param result json对象
	 */
	public static boolean isExist(JSONObject result) {
		if( isOk(result)){
			//1001  手机号已经存在
			UagResult uagResult = JSONObject.parseObject(result.toJSONString(), UagResult.class);
			return   "1004".equals(uagResult.getCode()) ? 
					true : false;
		}
		return false;
		
	}
	
	
}
