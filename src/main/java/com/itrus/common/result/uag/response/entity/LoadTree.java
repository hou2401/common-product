package com.itrus.common.result.uag.response.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoadTree implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * 部门信息
     */
    private DeptInfo deptInfo;
    /**
     * 用户基本信息
     */
    private UserInfoBase userInfoBase;
}
