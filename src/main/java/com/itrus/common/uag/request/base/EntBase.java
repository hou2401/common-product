package com.itrus.common.uag.request.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntBase {
    /**
     * 企业唯一标识
     */
    private Long companyUuid;
    /**
     * 企业全称
     */
    private String orgName;
    /**
     * 是否三证合一
     */
    private String inOneType;
    /**
     * 统一社会信用代码（三证合一必选）
     */
    private String socialCode;
    /**
     * 组织结构代码（三证未合一必选）
     */
    private String unitCode;
    /**
     * 工商注册号（三证未合一必选）
     */
    private String registerNumber;


}
