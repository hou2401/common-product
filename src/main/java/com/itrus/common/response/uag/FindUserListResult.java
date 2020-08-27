package com.itrus.common.response.uag;

import com.itrus.common.response.entity.User;
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
public class FindUserListResult implements Serializable {
    private List<User> userList;
}
