package com.itrus.common.uag.request;

import com.itrus.common.uag.request.base.EntBase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 企业创建-运营管理
 */
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class OrgAddCompanyOnOperationRequest extends EntBase {
    /**
     *手机号
     */
    private String phone;
    /**
     *邮箱
     */
    private String email;
    /**
     *状态
     */
    private String state;
    /**
     *姓名
     */
    private String displayName;
    /**
     *证件类型
     */
    private String idCardType;
    /**
     *证件号码
     */
    private String idCardNum;

}
