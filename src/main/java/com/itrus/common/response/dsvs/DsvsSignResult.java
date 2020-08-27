package com.itrus.common.response.dsvs;

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
public class DsvsSignResult implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long fssId;
    private String pdfBytes;
    private String hashValue;
}
