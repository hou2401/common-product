package com.itrus.common.response.dsvs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @ClassName KeywordCoordinate
 * @Author: Yuliu
 * @Description:
 * @Date:Created in 12:56 2020/8/29
 * @Modified By:
 * @Version 1.0
 **/

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class KeywordCoordinate implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 关键字X轴坐标位置，从左上角开始的百分比坐标
     */
    private Float x;
    /**
     * 关键字Y轴坐标位置，从左上角开始的百分比坐标
     */
    private Float y;
    /**
     * 关键字所在页数
     */
    private Integer pageNo;



}
