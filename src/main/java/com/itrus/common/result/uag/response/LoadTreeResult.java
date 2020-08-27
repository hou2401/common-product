package com.itrus.common.result.uag.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import com.itrus.common.result.uag.response.entity.DeptInfo;
import com.itrus.common.result.uag.response.entity.UserInfoBase;

/**
 * @author yuying
 * 加载企业下全量节点信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoadTreeResult implements Serializable {
    /**
     * 部门信息
     */
    private DeptInfo deptInfo;
    /**
     * 用户基本信息
     */
    private UserInfoBase userInfoBase;
}
