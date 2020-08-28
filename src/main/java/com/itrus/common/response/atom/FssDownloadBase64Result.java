package com.itrus.common.response.atom;

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
public class FssDownloadBase64Result implements Serializable {
    private static final long serialVersionUID = 7364722461130134714L;
    private String fileBytes;

    private String fileName;
}
