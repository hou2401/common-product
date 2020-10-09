package com.itrus.common.result.uag.response;

import com.itrus.common.response.ra.CertConfigResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RaGetListResult implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<CertConfigResponse> result;
}
