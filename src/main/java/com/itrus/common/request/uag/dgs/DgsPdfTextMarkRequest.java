package com.itrus.common.request.uag.dgs;

import com.itrus.common.request.uag.dgs.entity.PositionArray;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;
import java.util.List;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DgsPdfTextMarkRequest {
    private String pdfData;

    private String text;

    private Integer beginPage;

    private Integer endPage;

    private Float opacity;

    private Float rotation;

    private Float fontSize;

    private Integer colorR;

    private Integer colorG;

    private Integer colorB;

    private String align;

    private Float margin;

    private List<PositionArray> positionArray;
}

