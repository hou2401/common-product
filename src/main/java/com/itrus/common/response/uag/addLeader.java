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
public class addLeader implements Serializable {
    private int successCount;

    private int errorCount;

    private List<String> errorDataList;
}
