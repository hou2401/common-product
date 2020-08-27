package com.itrus.common.request.uag.dgs;

import com.itrus.common.request.uag.dgs.entity.Param;
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
public class DgsPdfFillRequest {
    private String pdfURI;
    private List<Param> params;
    private String returnType;

}
