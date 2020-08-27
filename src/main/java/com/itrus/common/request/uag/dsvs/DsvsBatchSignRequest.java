package com.itrus.common.request.uag.dsvs;

import com.itrus.common.request.uag.dsvs.entity.Signer;
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
public class DsvsBatchSignRequest{
    private String pdfURI;
    private String pdfBytes;
    private String returnType;
    private Long coordinateAxisType;
    private List<Signer> signers;
}
