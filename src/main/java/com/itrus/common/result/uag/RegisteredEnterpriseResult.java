package com.itrus.common.result.uag;

import lombok.Getter;
import lombok.ToString;

/**
 * 企业注册返回结果
 * @author Administrator
 *
 */
@ToString
@Getter
public class RegisteredEnterpriseResult extends UagResult{

	private Long orguuid;
	
	private Long adminuuid;
	
	
}
