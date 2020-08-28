package com.itrus.common.request.cert.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExtJson {
    /**
     * 用户名字
     */
    private String userSurname;
    /**
     * 用户序列号
     */
    private String userSerialnumber;
    /**
     * 用户邮箱
     */
    private String userEmail;
    /**
     * 用户组织
     */
    private String userOrganization;
    /**
     * 用户组织单元
     */
    private String userOrgunit;
    /**
     * 用户城市
     */
    private String userCountry;
    /**
     * 用户状态
     */
    private String userState;
    /**
     * 用户地区
     */
    private String userLocality;
    /**
     * 用户街道
     */
    private String userStreet;
    /**
     * 用户 DNS
     */
    private String userDns;
    /**
     * 用户 IP
     */
    private String userIp;
    /**
     * 用户主题
     */
    private String userTitle;
    /**
     * 用户描述信息
     */
    private String userDescription;
    /**
     * 用户额外字段
     */
    private String userAdditionalField1;

    private String userAdditionalField2;

    private String userAdditionalField3;

    private String userAdditionalField4;

    private String userAdditionalField5;

    private String userAdditionalField6;

    private String userAdditionalField7;

    private String userAdditionalField8;

    private String userAdditionalField9;

    private String userAdditionalField10;
}
