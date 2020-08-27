package com.itrus.common.request.uag.dsvs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class KeywordSignatures {
    private String pages;

    private String sealURI;
    private String sealBytes;
    private Float sealWidth;
    private Float sealHeight;
    private String sealScale;

    private String keyword;
    private Integer stampMax;
    private String stampStyle;


    private Float offsetX;

    private Float offsetY;
}
