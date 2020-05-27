package com.itrus.common.params.uag;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

@ApiModel(description = "请求UAG查询组织实体类")
@ToString
@Data
public class SearchCondition {

	/**
	 * 审核条件   待审核/审核通过/审核拒绝 --check_status
	 */
	private String[] ifAudited;   // 审核状态 1：审核通过  3：待审核  4：审核拒绝  不填默认查询全部
	
	/**
	 * 查询节点类型  用户/部门/公司
	 */
	private String[] nodeType;  // 查询节点类型   1：用户  2：部门 3：公司
	
	/**
	 * 是查询树还是查询子节点
	 */
	private String ifLoadNodes;
	
	/**
	 * 默认需要显示超级管理员
	 * 0不显示
	 */
	private String ifRoot="1";
	
	/**
	 * 用户认证状态 
	 */
	private Integer realName;  //1已认证 2未认证 3认证未通过 4联系人已离职 5待审核
	
	/**
	 * 加入状态
	 */
	private String[] joinState;
    /**
     * 姓名或者手机号
     */
	private String phoneOrDisplayName;
    /**
     * 查询方式：1精确查询、2模糊查询 （不传默认精确查）
     */
	private String queryMode;

    /**
     * 分页参数-每页显示记录数
     */
	private Integer pageSize;
    /**
     * 分页参数-当前第几页
     */
	private Integer pageIndex;
	
	
	public SearchCondition(String[] ifAudited, String[] nodetype, String ifLoadNodes, Integer realName, String ifRoot) {
		super();
		this.ifAudited = ifAudited;
		this.nodeType = nodetype;
		this.ifLoadNodes = ifLoadNodes;
		this.realName = realName;
		this.ifRoot = ifRoot;
	}
	

	public SearchCondition(String[] ifAudited, String[] nodetype, String ifLoadNodes, Integer realName) {
		super();
		this.ifAudited = ifAudited;
		this.nodeType = nodetype;
		this.ifLoadNodes = ifLoadNodes;
		this.realName = realName;
	}

	public SearchCondition() {
		super();
	}
	
}
