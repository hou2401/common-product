package com.itrus.common.params.uag;

import lombok.Data;
import lombok.ToString;

/**
 * 请求UAG查询组织实体类
 * @author wgx52
 *
 */
@ToString
@Data
public class UagOrgParams {
	
	/**
	 * 组织id 公司/部门
	 */
	private Long uuid;
	
	/**
	 * 用户在UAG存储用户名 -本地手机号或者邮箱号
	 */
	private String manager;
	
    private SearchCondition searchCondition;

	public UagOrgParams(Long uuid, String manager, SearchCondition searchCondition) {
		super();
		this.uuid = uuid;
		this.manager = manager;
		this.searchCondition = searchCondition;
	}
	public UagOrgParams(Long uuid, String manager) {
		super();
		this.uuid = uuid;
		this.manager = manager;
	}

	public UagOrgParams() {
		super();
	}
    
}
