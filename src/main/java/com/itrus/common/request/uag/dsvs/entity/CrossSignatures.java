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
public class CrossSignatures {
    private String pages;

    private String sealURI;

    private String sealBytes;

    private Float sealWidth;

    private Float sealHeight;

    private String sealScale;

    private double y;
}
