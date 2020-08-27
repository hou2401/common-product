package com.itrus.common.result.uag.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class loadPersonalResult implements Serializable {
    private String orgName;

    private String idCardNum;

    private String displayName;

    private String phone;

    private String email;

    private String authResult;

    private String sourceCode;

    private String createTime;
}
