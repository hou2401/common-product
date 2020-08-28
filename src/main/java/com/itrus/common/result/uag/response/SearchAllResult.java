package com.itrus.common.result.uag.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

import com.itrus.common.result.uag.response.entity.UserInfoBase;

/**
 * @author yuying
 * 查询全网指定用户信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchAllResult implements Serializable {

    private static final long serialVersionUID = -8630945349460026019L;
    /**
     * 用户信息列表
     */
    private List<UserInfoBase> users;
}
