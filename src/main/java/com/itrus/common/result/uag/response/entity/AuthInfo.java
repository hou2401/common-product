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
public class AuthInfo implements Serializable {
    private String inOneType;

    private String socialCode;

    private String unitCode;

    private String legalName;

    private String registerNumber;

    private String registerMoney;

    private String registerAddress;

    private String registrationAuthority;

    private String beginTime;

    private String endTime;

    private String bankNum;

    private String bankName;

    private String subBankName;

    private String businessScope;

    private String checkTime;

    private String setupTime;

    private String revokeTime;

    private String orgState;

    private String authType;

    private String authResult;

    private String authTime;

    private String bankCode;

    private String bankProvinceCode;

    private String bankCityCode;

}
