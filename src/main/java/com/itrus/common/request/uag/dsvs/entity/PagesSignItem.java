package com.itrus.common.request.uag.dsvs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagesSignItem {
    private String pages;

    private String sealURI;
    private String sealBytes;
    private Float sealWidth;
    private Float sealHeight;
    private String sealScale;
    private String sealPoint;
    private String stampStyle;
    private Float x;
    private Float y;
}
