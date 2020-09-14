package com.itrus.common.result.uag.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CertNameResponse implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String RaCode;

    private String RaName;
}
