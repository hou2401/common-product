package com.itrus.common.response.apigate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName PrecountResult
 * @Author: Yuliu
 * @Description:
 * @Date:Created in 20:43 2020/9/1
 * @Modified By:
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrecountResult implements Serializable {

    /**
     * 应用ID
     */
    private String appId;
    /**
     * 订单编号
     */
    private String orderNum;
    /**
     * 是否为预付费订单
     */
    private Boolean isPreCount;
    /**
     * 预计数数量
     */
    private Integer count;

}
