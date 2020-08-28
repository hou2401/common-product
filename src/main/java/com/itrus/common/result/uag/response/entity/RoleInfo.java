package com.itrus.common.result.uag.response.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuying
 * UserInfoCompany的属性
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleInfo {
    /**
     * 是否是超级管理员
     */
    private Boolean superAdmin;
    /**
     * 角色名称
     */
    private String name;
    /**
     * 角色类型 0 未加入 1 在职 2 已拒绝 3 异常 4 离职
     */
    private String type;
}
