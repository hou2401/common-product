package com.itrus.common.result.uag.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.lang.annotation.DeclareAnnotation;

import java.io.Serializable;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CertNameResponse implements Serializable {

    private String RaCode;

    private String RaName;
}
