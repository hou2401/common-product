package com.itrus.common.params.uag;

import com.itrus.common.params.uag.BaseUagParams;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * <p>
 *  UAG 用户扩展字段
 * </p>
 *
 * @author han_yanhui
 * @since 2020-5-25 10:30:12
 */
@Data
@EqualsAndHashCode(callSuper=true)
@ToString
public class UserExtParams extends BaseUagParams{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 成员编号
	 */
	private String code;
	
	/**
	 *职位
	 */
	private String position;
	
	/**
	 *地址
	 */
	private String address;
	
	/**
	 *用户状态（0 待加入 1 已加入 2 异常 3 拒绝 4 离职）
	 */
	private String joinState;
	
	/**
	 *公司邮箱
	 */
	private String companyEmail;
	
	/**
	 * 是否立即申请证书( true立即申请，false使用时候再申请 )
	 */
	private Boolean applyCert;
	
	/**
	 * 实名认证( 客户认证true,天威认证false )
	 */
	private Boolean authentication;
	
	
	public UserExtParams() {
		super();
	}
	
	public UserExtParams(String code,String position,String address,String joinState,String companyEmail) {
		super();
		this.code = code;
		this.position = position;
		this.address = address;
		this.joinState = joinState;
		this.companyEmail = companyEmail;
	}
	
}
