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
public class Param {
    private String type;
    private String value;
    private Integer pageNum;
    private Float xPercent;
    private Float yPercent;
    private Float picWidth;
    private Float picHeight;
    private Integer fontSize;
    private String fontColor;
    private Float scale;

}
