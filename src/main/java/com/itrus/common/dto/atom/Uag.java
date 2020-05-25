package com.itrus.common.dto.atom;

import lombok.Data;
import lombok.ToString;

/**
 *证书相关url
 * @author wen_guoxing
 *
 */
@Data
@ToString
public class Uag {
	/**
	 * 用户注册
	 */
	private String userRegister;
	/**
	 * 用户更新
	 */
	private String userUpdate;
	/**
	 * 用户详细信息查询
	 */
	private String userSearchInfo;
	/**
	 * 用户更新/重置/忘记密码
	 */
	private String resetPassWd;
	/**
	 *创建企业
	 */
	private String entAdd;
	/**
	 * 更新企业
	 */
	private String entUpdate;
	/**
	 * 企业详细信息查询
	 */
	private String entSearchInfo;
	/**
	 * 创建部门
	 */
	private String deptAdd;
	/**
	 * 更新部门
	 */
	private String deptUpdate;
	/**
	 * 部门详细信息查询
	 */
	private String deptSearchInfo;
	/**
	 * 删除部门
	 */
	private String deptDelete;
	/**
	 * 查询企业下一级节点信息
	 */
	private String entSearchOneNode;
	/**
	 * 查询部门下一级节点信息
	 */
	private String deptSearchOneNode;
	/**
	 * 查询企业下全部节点信息
	 */
	private String entAll;
	
	/**
	 * 查询部门下所有节点信息
	 */
	private String deptAll;
	
	/**
	 * 查询当前用户加入的企业列表
	 */
	private String findJoinCompanys;
	
	/**
	 * 批量导入
	 */
	private String betchImport;
	
	/**
	 * 移除邀约用户
	 */
	private String removeUser;
	
	/**
	 * 用户切换企业
	 */
	private String switchEnterprise;
	
	/**
	 * 企业邀请用户
	 */
	private String joinEnterprise;
	
	/**
	 * 口令认证
	 */
	private String passwdAuth;
	
	/**
	 * 获取短信验证码
	 */
	private String getVerificationCode;
	
	/**
	 * 短信验证码认证
	 */
	private String verifySmsCodeAuth;
	
	/**
	 * 单点退出接口
	 */
	private String logout;
	
	/**
	 * 添加扩展属性
	 */
	private String extendedAdd;
	
	/**
	 * 查询当前节点下uuid集合
	 */
	private String findChildUuidList;
	
	/**
	 * 用户授权接口
	 */
	private String grantAuth;
	
	/**
	 * 根据手机号或uuid集合查询用户信息
	 */
	private String findUserInfoByUuidList;
	
	/**
	 * 全量查询企业和用户信息
	 */
	private String findAllEnterpriseAndUser;

}
