package com.itrus.common.result.uag.response.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CompanyList implements Serializable {
    private static final long serialVersionUID = 2122639022290459210L;
    /**
     * 企业名称
     */
    private String orgName;
    /**
     * 公司UUID
     */
    private String orgUuid;
    /**
     * 角色名字列表
     */
    private List<RoleInfo> roleNameList;
    /**
     * 认证结果
     */
    private String authResult;
}
