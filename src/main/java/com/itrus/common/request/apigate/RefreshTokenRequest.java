package com.itrus.common.request.apigate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName RefreshTokenRequest
 * @Author: Yuliu
 * @Description:
 * @Date:Created in 20:47 2020/9/1
 * @Modified By:
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefreshTokenRequest implements Serializable {

    /**
     * token串
     */
    private String jwtToken;
}
