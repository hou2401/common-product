package com.itrus.common.result.uag.response;

import java.io.Serializable;
import java.util.List;

import com.itrus.common.result.uag.response.entity.BatchAddPersonalErrorResponse;
import com.itrus.common.result.uag.response.entity.BatchAddPersonalSuccessResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuying
 * openApi-批量创建外部联系人-个人
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExternalApiAddPersonalResult implements Serializable {

    private static final long serialVersionUID = 1981676700966344877L;

    /**
     * 失败信息列表
     */
    private List<BatchAddPersonalErrorResponse> errorList;
    /**
     * 成功信息列表映射集
     */
    private List<BatchAddPersonalSuccessResponse> successList;
}
