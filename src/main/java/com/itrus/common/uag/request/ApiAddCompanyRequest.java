package com.itrus.common.uag.request;

import com.itrus.common.uag.request.base.EntBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ApiAddCompanyRequest extends EntBase {
    /**
     * 标识给哪个企业/个人创建外部
     */
    private String uuid;
    /**
     * 节点类型
     */
    private String type;
    /**
     * 姓名
     */
    private String displayName;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 企业邮箱
     */
    private String email;
    /**
     * 企业类型
     */
    private String orgType;
    /**
     * 应用ID
     */
    private String appId;
    /**
     * 实名状态
     */
    private String authResult;
}
