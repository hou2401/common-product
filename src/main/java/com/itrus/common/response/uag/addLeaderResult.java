package com.itrus.common.response.uag;

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
public class addLeaderResult implements Serializable {
    private Integer successCount;

    private Integer errorCount;

    private List<String> errorDataList;
}
