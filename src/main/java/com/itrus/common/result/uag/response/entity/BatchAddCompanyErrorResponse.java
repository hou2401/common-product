package com.itrus.common.result.uag.response.entity;

import com.itrus.common.result.uag.entity.OrgInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @ClassName BatchAddCompanyErrorResponse
 * @Author: Yuliu
 * @Description:
 * @Date:Created in 11:35 2020/9/3
 * @Modified By:
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class BatchAddCompanyErrorResponse implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * 企业名称
     */
    private String orgName;
    /**
     * 错误消息
     */
    private String message;

    private HashMap<String, OrgInfo> dataInfo;

}
