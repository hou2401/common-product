package com.itrus.common.result.uag.response.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CompanyBaseInfo implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * 企业全称
     */
    private String orgName;
    /**
     * 企业UUID
     */
    private String uuid;
    
    /**
     * 企业状态
     */
    private String state;
}
