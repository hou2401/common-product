package com.itrus.common.response.uag;

import com.itrus.common.response.uag.entity.UserInfoAll;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class searchByDept implements Serializable {
    private Integer total;

    private List<UserInfoAll> userList;
}
