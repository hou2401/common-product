package com.itrus.common.result.uag.request;

import com.itrus.common.request.base.EntBase;

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
public class ExternalUpdateCompanyRequest extends EntBase {
    /**
     * 数据库标识
     */
    private Long id;
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
