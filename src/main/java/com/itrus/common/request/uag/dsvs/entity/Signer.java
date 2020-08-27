package com.itrus.common.request.uag.dsvs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Signer implements Serializable {
    private Long certId;
    private String sm3zValue;
    private Long secondCertId;
    private String secondSm3zValue;
    private Boolean timestamp;
    private Long signaturePolicy;
    private List<PagesSignItem> pagesSignatures;
    private List<keywordSignItem> keywordSignatures;
    private List<crossSignItem> crossSignatures;
}
