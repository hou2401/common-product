package com.itrus.common.result.uag.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import com.itrus.common.result.uag.response.entity.UserInfoBase;

/**
 * @author yuying
 * 通过uuid集合获取用户信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchByUuidsResult implements Serializable {

    private static final long serialVersionUID = -3612642904042589070L;
    /**
     * 用户唯一标识集合
     */
    private List<String> uuids;
    /**
     * 用户信息列表
     */
    private List<HashMap<String, UserInfoBase>> userInfos;
}
