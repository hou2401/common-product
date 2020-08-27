package com.itrus.common.result.uag.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

import com.itrus.common.result.uag.response.entity.User;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindUserListResult implements Serializable {
    private List<User> userList;
}
