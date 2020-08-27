package com.itrus.common.request.uag.dgs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PositionArray {
	/**
     * 坐标轴x
     */
    private Integer x;
    /**
     * 坐标轴y
     */
    private Integer y;
}
