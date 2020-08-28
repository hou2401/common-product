package com.itrus.common.response.fcs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetTotalPagesResult implements Serializable {
    /**
     * 文件总页数
     */
    private Integer pageCount;
}
