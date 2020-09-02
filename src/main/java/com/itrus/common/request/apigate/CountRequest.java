package com.itrus.common.request.apigate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName CountRequest
 * @Author: Yuliu
 * @Description:
 * @Date:Created in 20:48 2020/9/1
 * @Modified By:
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountRequest implements Serializable {

    /**
     *  应用ID
     */
    private String appId;
    /**
     *  产品编号
     */
    private String serviceCode;
    /**
     *  计数个数，默认为1
     */
    private Integer count;

}
