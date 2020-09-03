package com.itrus.common.result.uag.request;

import com.itrus.common.result.uag.entity.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author yuying
 * openApi-批量创建外部联系人-个人
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExternalApiAddPersonalRequest {

    /**
     * 用户信息集合 必选
     */
    private List<UserInfo> userInfoList;
    /**
     * 要添加外部联系人关系的节点唯一标识 必选
     */
    private String companyUuid;
    /**
     * 要添加外部联系人关系的节点类型 必选
     * 0 企业
     * 1 部门
     * 2 用户
     * 3 全部
     */
    private String type;
}
