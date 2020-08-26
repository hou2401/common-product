package com.itrus.common.uag.request;

import com.itrus.common.uag.request.base.EntBase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper=true)
public class ExternalAddCompanyRequest extends EntBase {
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


}
