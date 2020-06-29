package com.itrus.common.params.uag;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

/**
 * <p>
 *  UAG 授权
 * </p>
 *
 * @author han_yanhui
 * @since 2020-5-25 10:30:12
 */
@ApiModel(description = "请求UAG授权实体类")
@ToString
@Data
public class GrantAuthParams implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 管理员手机号
	 */
	private String manager;
	/**
	 * 公司uuid
	 */
	private Long uuid;
	
	/**
	 * 用户uuid
	 */
	private Long userUuid;
	
	/**
	 * 用户手机号
	 */
	private String phone;
	
	public GrantAuthParams() {
		super();
	}
	/**
	 * 授权 用户userUuid和phone二选一
	 * @param uuid
	 * @param userUuid
	 * @param phone
	 */
	public GrantAuthParams(String manager, Long uuid,Long userUuid,String phone) {
		super();
		this.manager = manager;
		this.uuid = uuid;
		this.userUuid = userUuid;
		this.phone = phone;
	}
	
}
