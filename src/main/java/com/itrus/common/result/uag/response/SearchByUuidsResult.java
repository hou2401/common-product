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
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchByUuidsResult implements Serializable {
    private List<String> uuids;

    private List<HashMap<String, UserInfoBase>> userInfos;
}
