package com.itrus.common.response.uag;

import com.itrus.common.response.uag.entity.UserInfoBase;
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
public class SearchAllResult implements Serializable {
    private List<UserInfoBase> users;
}
