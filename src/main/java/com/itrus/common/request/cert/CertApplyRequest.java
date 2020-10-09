package com.itrus.common.request.cert;

import com.itrus.common.request.cert.entity.ExtJson;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CertApplyRequest {
    /**
     * 单位名称
     */
    private String o;
    /**
     * 部门名称
     */
    private String ou;
    /**
     * 个人姓名或企业名称
     */
    private String cn;
    /**
     * 申请证书所使用的RA，由服务提供者进行配置
     */

    private String raCode;
    /**
     * 证书有效天数，默认使用RA配置的有效天数
     */
    private Integer validDays;
    /**
     * 证书扩展信息，参考CA的《UserAPI开发手册.pdf》
     */
    private ExtJson extJson;
}
