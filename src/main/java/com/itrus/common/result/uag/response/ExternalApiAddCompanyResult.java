package com.itrus.common.result.uag.response;

import com.itrus.common.result.uag.response.entity.UserAndCompanyInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * @author yuying
 *  openApi-批量创建外部联系人-企业
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExternalApiAddCompanyResult implements Serializable {
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
    private List<String> errorData;
    /**
     * 成功数据列表
     */
    private List<HashMap<String, UserAndCompanyInfo>> successList;
}
