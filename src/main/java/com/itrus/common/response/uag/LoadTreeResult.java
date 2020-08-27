package com.itrus.common.response.uag;

import com.itrus.common.response.uag.entity.DeptInfo;
import com.itrus.common.response.uag.entity.UserInfoBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

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
