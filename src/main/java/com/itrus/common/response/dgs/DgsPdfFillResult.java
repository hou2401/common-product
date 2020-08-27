package com.itrus.common.response.dgs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DgsPdfFillResult implements Serializable {
    private Long fssId;
    private String pdfBytes;
    private String hashValue;
}
