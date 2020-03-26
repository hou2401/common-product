package com.itrus.common.dto;

import org.apache.http.HttpException;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "http")
public class HttpDTO {
	
	private String httped;
	
	private String url;
	
	/**
	 * 是否为http模式
	 * @return
	 * @throws HttpException
	 */
	public boolean httped() throws HttpException{
		if( "1".equals(httped) || "true".equalsIgnoreCase(httped) ) {
			return true;
		}
		return false;
	}
}
