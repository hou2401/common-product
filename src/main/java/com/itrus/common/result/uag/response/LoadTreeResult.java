package com.itrus.common.result.uag.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import com.itrus.common.result.uag.response.entity.DeptInfo;
import com.itrus.common.result.uag.response.entity.UserInfoBase;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoadTreeResult implements Serializable {
    private DeptInfo deptInfo;
    private UserInfoBase userInfoBase;
}
