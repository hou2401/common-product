package com.itrus.common.result.uag.response.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class RealInfo implements Serializable {
    private static final long serialVersionUID = 7600854741101156684L;
    /**
     * 姓名
     */
    private String displayName;
    /**
     * 认证时间
     */
    private String authTime;
    /**
     * 实名认证类型 0 未实名(默认) 1 已实名 2 实名中
     */
    private String authType;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 个人证件类型
     * 1 居民身份证 （默认）
     * 2 护照
     * 3 港澳居民来往内地通行证
     * 4 台湾居民往来大陆通行证
     * 5 香港永久性居民身份证
     * 6 外籍身份证
     */
    private String idCardType;
    /**
     * 证件号码
     */
    private String idCardNum;
    /**
     * 银行卡号
     */
    private String bankCardNum;
    /**
     * 实名认证结果 0 未实名(默认) 1 已实名 2 实名中
     */
    private String authResult;
}
