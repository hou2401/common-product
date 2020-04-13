package com.itrus.common.result.atom;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ApplyCertResult{
	
	private Long id;
	
	private String certSn;
	
	private String certBuf;
	
	private String certChain;
	
	private String  issuer;
	
	private String subject;
	
	private Date notAfter;
	
	private Date notBefore;
	
	private String privateKeyAlg;
	
	private Integer status ;
}
