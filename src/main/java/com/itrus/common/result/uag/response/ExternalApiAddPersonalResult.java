package com.itrus.common.result.uag.response;

import com.itrus.common.result.uag.response.entity.UserInfoBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * @author yuying
 * openApi-批量创建外部联系人-个人
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExternalApiAddPersonalResult implements Serializable {

    /**
     * 成功数目
     */
    private Integer successSize;
    /**
     * 失败数目
     */
    private Integer errorSize;
    /**
     * 失败信息列表
     */
    private List<String> errorData;
    /**
     * 成功信息列表映射集
     */
    private List<HashMap<String, UserInfoBase>> successList;
}
