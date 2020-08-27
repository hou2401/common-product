package com.itrus.common.result.uag.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExtendAttr {
    /**
     * 家庭住址
     */
    private String homeAddress;
    /**
     * 座机号码
     */
    private String telphoneNumber;

    /**
     * 注册地址
     */
    private String orgAddress;

    /**
     * 公司座机号码
     */
    private String companyTelphoneNumber;

}
