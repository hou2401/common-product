package com.itrus.common.result.uag;

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
	 * 根节点组织id
	 */
	private Long rootuuid;
	
	/**
	 * 管理员id
	 */
	private Long adminuuid;
	
	
}
