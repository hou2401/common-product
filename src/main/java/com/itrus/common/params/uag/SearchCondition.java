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
	 * 1表示用户，2表示部门，3表示子公司 默认全查
	 */
	private String[] nodeType;

	/**
	 * 默认需要显示超级管理员
	 * 0不显示
	 */
	private String ifRoot="1";
	
	/**
	 * 手机号
	 */
	private String phone;
	
	/**
	 * 姓名
	 */
	private String displayName;
	
	/**
	 * 用户认证状态 加入状态 0未加入 1 已加入 2异常 3 拒绝 4 离职
	 */
	private String joinState;
	
	/**
	 * 每页显示条数
	 */
	private Integer pageSize;
	
	/**
	 * 第几页
	 */
	private Integer pageIndex;
	
	/**
	 * 1精确查 2 模糊查 默认精确查询
	 */
	private String queryMode = "1";
	
	public SearchCondition(String[] ifAudited, String[] nodeType, String joinState) {
		super();
		this.ifAudited = ifAudited;
		this.nodeType = nodeType;
		this.joinState = joinState;
	}

	public SearchCondition() {
		super();
	}
	
}
