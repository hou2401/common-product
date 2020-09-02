package com.itrus.common.request.apigate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName PrecountRoAndCoRequest
 * @Author: Yuliu
 * @Description:
 * @Date:Created in 20:49 2020/9/1
 * @Modified By:
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrecountRoAndCoRequest implements Serializable {

    /**
     * 应用id
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
