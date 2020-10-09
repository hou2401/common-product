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
    private String roleName;
    /**
     *            是否是主管理员
     * 1 是
     * 0 否
     */
    private String type;
}
