package com.itrus.common.request.uag.dsvs;

import com.itrus.common.request.uag.dsvs.entity.CrossSignatures;
import com.itrus.common.request.uag.dsvs.entity.KeywordSignatures;
import com.itrus.common.request.uag.dsvs.entity.PagesSignatures;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DsvsSignRequest {
    private String pdfURI;

    private String pdfBytes;

    private String sm3zValue;

    private Long secondCertId;

    private String secondSm3zValue;

    private Long signaturePolicy;

    private Long coordinateAxisType;

    private Long certId;

    private Boolean timeStamp;

    private String returnType;

    private List<PagesSignatures> pagesSignatures;

    private List<KeywordSignatures> keywordSignatures;

    private List<CrossSignatures> crossSignatures;

}
