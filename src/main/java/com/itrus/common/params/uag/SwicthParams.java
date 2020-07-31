package com.itrus.common.params.uag;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

/**
 * <p>
 *  UAG 根据手机号或uuid集合获取用户基本信息实体类
 * </p>
 *请求UAG切换企业实体类
 * @author han_yanhui
 * @since 2020-5-25 10:30:12
 */
@ToString
@Data
public class SwicthParams implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 手机号
	 */
	private String phone;
	
	/**
	 *企业id ---选填，不填默认切换个人
	 */
	private Long companyUuid;
	
	
	public SwicthParams() {
		super();
	}
	
	public SwicthParams(String phone,Long companyUuid) {
		super();
		this.phone = phone;
		this.companyUuid = companyUuid;
	}

}
