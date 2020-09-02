package com.itrus.common.response.apigate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName GetJwtTokenResponse
 * @Author: Yuliu
 * @Description:
 * @Date:Created in 20:41 2020/9/1
 * @Modified By:
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetJwtTokenResult implements Serializable {


    private boolean auth;

    private String jwtToken;

}
