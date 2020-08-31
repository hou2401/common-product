package com.itrus.common.result.uag.response.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoadTree {
    private static final long serialVersionUID = 3026600311660818285L;
    /**
     * 部门信息
     */
    private DeptInfo deptInfo;
    /**
     * 用户基本信息
     */
    private UserInfoBase userInfoBase;
}
