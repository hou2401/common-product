package com.itrus.common.request.dgs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DgsPdfCreateRequest {
    private int styleType;
    private int pageSize;
    private File zipFile;
}
