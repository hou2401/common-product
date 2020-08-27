package com.itrus.common.response.uag;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchByUuidsResult implements Serializable {
    private List<String> uuids;
    private List<HashMap<String,Object>> userInfos;
}
