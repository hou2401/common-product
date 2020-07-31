package com.itrus.common.params.uag;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class DeptParams {
	
	/**
	 * 管理员账号
	 */
	private String manager;
	
	/**
	 * 上级节点uuid
	 */
	private Long parentUuid;
	
	/**
	 * 上级节点类型
	 */
	private String parentType;
	
	/**
	 * 部门名称
	 */
	private String deptName;
	
	/**
	 * 部门编号
	 */
    private String deptCode;
    
    /**
            * 部门类型 默认部门级 1为公司级部门 0为部门级部门
     */
    private String deptType;
    
    /**
     * 1精确查 2 模糊查 默认精确查询
     */
    private String queryMode;
    
    /**
             * 节点id
     */
    private Long uuid;
    
    private Boolean mode = true;
    

	public DeptParams(String manager, Long parentUuid, String parentType, String deptName, String deptCode, String deptType) {
		super();
		this.manager = manager;
		this.parentUuid = parentUuid;
		this.parentType = parentType;
		this.deptName = deptName;
		this.deptCode = deptCode;
		this.deptType = deptType;
	}
	
	public DeptParams(String manager, Long uuid, String deptName, String deptCode, String deptType) {
		super();
		this.manager = manager;
		this.uuid = uuid;
		this.deptName = deptName;
		this.deptCode = deptCode;
		this.deptType = deptType;
	}
	
	public DeptParams(String manager, Long uuid, String deptName) {
		super();
		this.manager = manager;
		this.uuid = uuid;
		this.deptName = deptName;
	}

	public DeptParams() {
		super();
	}
    
}
