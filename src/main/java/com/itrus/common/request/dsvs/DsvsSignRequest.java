package com.itrus.common.request.dsvs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.itrus.common.request.dsvs.entity.CrossSignatures;
import com.itrus.common.request.dsvs.entity.KeywordSignatures;
import com.itrus.common.request.dsvs.entity.PagesSignatures;

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
