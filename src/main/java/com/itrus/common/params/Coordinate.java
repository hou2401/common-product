package com.itrus.common.params;

import lombok.Data;
import lombok.ToString;

/**
 * @ClassName Coordinate
 * @Author: Yuliu
 * @Description:
 * @Date:Created in 11:40 2020/4/7
 * @Modified By:
 * @Version 1.0
 **/
@Data
@ToString
public class Coordinate {

    /**
     * 坐标轴x
     */
    private Integer x;
    /**
     * 坐标轴y
     */
    private Integer y;

//    public Coordinate(Integer x, Integer y) {
//        this.x = x;
//        this.y = y;
//    }
}
