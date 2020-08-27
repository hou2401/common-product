package com.itrus.common.request.dgs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.itrus.common.request.dgs.entity.Param;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DgsPdfFillRequest {
    private String pdfURI;
    private List<Param> params;
    private String returnType;

}
