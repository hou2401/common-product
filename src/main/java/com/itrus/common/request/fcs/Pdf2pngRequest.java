package com.itrus.common.request.fcs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author yuying
 * PDF转PNG
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pdf2pngRequest  implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 要转换的PDF文件的base64
     */
    private byte[] data;
    /**
     * 缩放比例因子，其中1 = 72 DPI；数值越大，生成的图片清晰度越高<br/>文件大小越大。取值范围：1.0～4.0, 默认值：1.25
     */
    private Float scale;
}