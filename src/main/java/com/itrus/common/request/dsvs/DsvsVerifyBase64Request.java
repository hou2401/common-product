package com.itrus.common.request.dsvs;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DsvsVerifyBase64Request {
    private String pdfBytes;
    private Boolean checkAnnot;
    private Boolean checkCRL;
    private Boolean checkIssuer;

}
