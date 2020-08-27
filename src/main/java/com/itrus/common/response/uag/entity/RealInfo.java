package com.itrus.common.response.uag.entity;

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
    private String realName;

    private String authTime;

    private String authType;

    private String phone;

    private String idCardType;

    private String idCardNum;

    private String bankCardNum;

    private String authResult;
}
