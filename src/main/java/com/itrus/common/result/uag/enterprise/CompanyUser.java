package com.itrus.common.result.uag.enterprise;

import java.io.Serializable;

import lombok.Data;

/**
 * 用户与企业信息
 * 组合实体
 * @author wgx52
 *
 */
@Data
public class CompanyUser implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 用户名
	 */
	private String userName;
	
	/**
	 * 密码  ？？？ 加密的吗？天威云 md5加密
	 */
	private String passWd;
	
	/**
	 * 手机号
	 */
	private String phone;
	
	/**
	 * 个人邮箱
	 */
	private String email;
	
	/**
	 * 实名状态
	 */
	private String realName;
	
	/**
	 * 真实姓名
	 */
	private String displayName;
	
	/**
	 * 身份证号
	 */
	private String idCard;
	/**
	 * 性别
	 */
	private String sex;
	
	/**
	 * 状态
	 */
	private String joinState;
	
	/**
	 * 职位
	 */
	private String position;
	
	/**
	 * 成员编号
	 */
	private String code;
	
	/**
	 * 公司邮箱
	 */
	private String companyEmail;

//	@Override
//	public boolean equals(Object obj) {
//		//用身份证号来判断是不是同一个人
//		if( obj instanceof CompanyUser){
//			String idCard = ((CompanyUser) obj).getIdCard();
//			if( idCard != null ){
//				return idCard.equals(this.idCard);
//			}else{
//				return false;
//			}
//			
//		}
//		return false;
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((code == null) ? 0 : code.hashCode());
//		result = prime * result + ((companyEmail == null) ? 0 : companyEmail.hashCode());
//		result = prime * result + ((displayName == null) ? 0 : displayName.hashCode());
//		result = prime * result + ((email == null) ? 0 : email.hashCode());
//		result = prime * result + ((idCard == null) ? 0 : idCard.hashCode());
//		result = prime * result + ((joinState == null) ? 0 : joinState.hashCode());
//		result = prime * result + ((passWd == null) ? 0 : passWd.hashCode());
//		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
//		result = prime * result + ((position == null) ? 0 : position.hashCode());
//		result = prime * result + ((realName == null) ? 0 : realName.hashCode());
//		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
//		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
//		return result;
//	}
	
	
}
