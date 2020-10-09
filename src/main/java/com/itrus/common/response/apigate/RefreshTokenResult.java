package com.itrus.common.response.apigate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName RefreshTokenResult
 * @Author: Yuliu
 * @Description:
 * @Date:Created in 20:42 2020/9/1
 * @Modified By:
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefreshTokenResult implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String jwtToken;

}
