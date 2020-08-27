package com.itrus.common.request.uag.dgs;

import com.itrus.common.request.uag.dgs.entity.PositionArray;
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
public class DgsPdfImageMarkRequest {
    private String pdfData;

    private String imageData;

    private Integer beginPage;

    private Integer endPage;

    private Float opacity;

    private Float rotation;

    private Float width;

    private Float height;

    private String align;

    private Float margin;

    private List<PositionArray> positionArray;
}
