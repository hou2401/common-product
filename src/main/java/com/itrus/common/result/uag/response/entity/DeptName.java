package com.itrus.common.result.uag.response.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuying
 * userInfoCompany的属性
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeptName {
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 部门UUID
     */
    private String uuid;
}
