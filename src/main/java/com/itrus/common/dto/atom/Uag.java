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
	 * 企业注册 -包含注册企业超级管理员
	 */
	private String createAdmin;
	/**
	 * 新增节点 -新增节点分为新增用户、新增子公司、新增部门三种情况
	 */
	private String createUtsNode;
	/**
	 * 更新节点 -更新节点可分为更新更新用户、更新子公司、更新部门三种情况
	 */
	private String updateUtsNode;
	/**
	 * 用户升级管理员
	 */
	private String upgradeAdmin;
	/**
	 * 取消管理员权限
	 */
	private String cancelAdminAuth;
	/**
	 * 删除节点 -删除节点用户、部门、子公司都算节点
	 */
	private String deleteUtsNode;
	/**
	 * 重命名节点  -用户、子公司、部门都可以节点重命名
	 */
	private String renameUtsNode;
	/**
	 * 移动节点 -属于更换用户部门
	 */
	private String movingUtsNode;
	/**
	 * 根据节点类型查找当前节点下所有节点数据
	 */
	private String findAllSubLevelUser;
	/**
	 * 查询节点下所有一级节点
	 */
	private String findAllOneLevelNode;
	/**
	 * 查询当前节点下所有下一级节点或加载权限树
	 */
	private String findAllOneLevelChildren;
	/**
	 * 重置用户密码
	 */
	private String resetNodePassword;
	/**
	 * 判断当前用户是否根节点下用户
	 */
	private String verfyUserExistRootNode;

}
