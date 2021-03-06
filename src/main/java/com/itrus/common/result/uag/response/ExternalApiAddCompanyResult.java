package com.itrus.common.result.uag.response;

import java.io.Serializable;
import java.util.List;

import com.itrus.common.result.uag.response.entity.BatchAddCompanyErrorResponse;
import com.itrus.common.result.uag.response.entity.BatchAddCompanySuccessResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuying
 *  openApi-批量创建外部联系人-企业
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExternalApiAddCompanyResult implements Serializable {

    private static final long serialVersionUID = -6971119941138348519L;
    /**
     * 成功个数
     */
    private Integer successSize;
    /**
     * 错误个数
     */
    private Integer errorSize;
    /**
     * 错误数据列表
     */
    private List<BatchAddCompanyErrorResponse> errorList;
    /**
     * 成功数据列表
     */
    private List<BatchAddCompanySuccessResponse> successList;
}
