package com.itrus.common.result.uag.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

import com.itrus.common.result.uag.response.entity.UserInfoAll;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class searchByCompanyResult implements Serializable {
    private Integer total;

    private List<UserInfoAll> userList;
}
