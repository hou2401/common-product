package com.itrus.common.request.uag.dgs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DgsPdfTextAndQrCodeMarkRequest {
    private String pdfData;
    private DgsPdfTextMarkRequest textMark;
    private DgsPdfQrCodeMarkRequest qrCodeMark;
}
