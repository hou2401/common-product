package com.itrus.common.request.ra;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author yuying
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TimeStampRequest implements Serializable {
    private static final long serialVersionUID = 2731861820655895140L;
    /**
     * 用户名
     */
    @NotBlank(message="用户名不允许为空")
//    @Range(min = 1, max = 100, message = "用户名在1-100位之间")
    private String userName;

    /**
     * 用户密码
     */
    @NotBlank(message="密码不允许为空")
//    @Range(min = 1, max = 100, message ="用户密码不允许为空")
    private String password;

    /**
     * url
     */
    @NotBlank(message="url不允许为空")
//    @Range(min = 1, max = 255, message ="时间戳url不允许为空")
    private String serviceUrl;

    /**
     * 企业证件类型
     */
    @NotBlank(message="时间戳tsaCode不允许为空")
//    @Range(min = 1, max = 100, message = "时间戳编码在1-100之间")
    private String tsaCode;

    /**
     * 产品服务唯一标识
     */
    private String productId ;

    /**
     * 企业id
     */
    private String enterpriseId;

}
