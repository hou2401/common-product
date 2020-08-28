package com.itrus.common.result.uag.response.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuying
 * 部门信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeptInfo {

    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 部门唯一标识
     */
    private Integer uuid;
    /**
     * 部门类型
     */
    private String deptType;
    /**
     * 排序
     */
    private Integer orderNum;
    /**
     * 上级节点唯一标识
     */
    private Integer parentUuid;
    /**
     * 上级节点类型
     */
    private String parentType;
    /**
     * 企业唯一标识
     */
    private Integer companyUuid;
    /**
     * 创建部门的管理员名称
     */
    private String creatorName;
    /**
     * 路径
     */
    private String path;
}
