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
	
	private String alled;
	
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
	
	/**
	 * 是否为合并调用式
	 * @return
	 * @throws HttpException
	 */
	public boolean alled() throws HttpException{
		if( "1".equals(alled) || "true".equalsIgnoreCase(alled) ) {
			return true;
		}
		return false;
	}
}
