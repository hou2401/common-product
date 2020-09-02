package com.itrus.common.request.ra;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CertConfigRequest {
    /**
     * raType  ra类型
     */
    @NotNull(message = "RA类型不允许为空")
    @Min(value = 1, message = "ra类型只能是1或者2")
    @Max(value = 2, message = "ra类型只能是1或者2")
    private int raType;

    /**
     * 证书名称
     */
    @NotBlank(message = "证书名称不允许为空")
//    @Range(min = 1, max = 100, message = "证书名称在1-100之间")
    private String raName;

    /**
     * raCode
     */
    @NotBlank(message = "RaCode不允许为空")
//    @Range(min = 1, max = 100, message = "RaCode在1-100之间")
    private String raCode;

    /**
     * 证书类型
     */
    @NotNull(message = "证书类型不允许为空")
    @Min(value = 1, message = "证书类型是1或者2")
    @Max(value = 2, message = "证书类型是1或者2")
    private int certType;

    /**
     * 证书子类
     */
    @NotNull(message = "证书子类型不允许为空")
    @Min(value = 1, message = "证书子类型是1或者2")
    @Max(value = 2, message = "证书子类型是1或者2")
    private int certSubType;

    /**
     * 证书算法
     */
    /**
     * raCode
     */
    @NotBlank(message = "证书算法不允许为空")
//    @Range(min = 1, max = 20, message = "证书算法在1-20之间")
    private String keyAlgorithm;

    /**
     * ra地址
     */
//	@NotBlank(message = "ra地址不能为空")
//    @Range(min = 1, max = 255, message = "ra地址在1-255之间")
    private String serviceUrl;

    /**
     * ra账号
     */
//	@NotBlank(message = "ra账号hash不能为空")
//    @Range(min = 1, max = 255, message = "ra账号hash在1-255之间")
    private String accountHash;
    /**
     * ra密码
     */
//	@NotBlank(message = "RA密码不能为空")
//    @Range(min = 1, max = 255, message = "ra密码在1-255之间")
    private String aaPassword;

    /**
     * 应用标识
     */
//	@NotBlank(message = "appId不能为空")
//    @Range(min = 1, max = 50, message = "appId在1-50之间")
    private String appId;

    /**
     * secretkey
     */
//	@NotBlank(message = "secretkey不能为空")
//    @Range(min = 1, max = 50, message = "ra密码在1-50之间")
    private String appSecret;

    /**
     * serviceCode
     */
//	@NotBlank(message = "serviceCode不能为空")
//    @Range(min = 1, max = 50, message = "serviceCode  1-50之间")
    private String serviceCode;
    /**
     * 有效期
     */
    private String maxValidDays;

    /**
     * 产品标识
     */
    private String productId;

    /**
     * 企业标识
     */
    private String enterpriseId;
}
