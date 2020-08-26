package com.itrus.common.dto;

import org.apache.http.HttpException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "http")
public class HttpDTO {
	
	/**
	 * 调用原子服务 使用 分布的 还是 整合版本
	 */
	private String alled;
	
	/**
	 * 重试次数 
	 * 默认1此
	 */
	@Value("${http.retryCount:1}")
	private Integer retryCount;
	
	/**
	 * 合并版原子服务注册中心名称
	 */
	@Value("${http.atomed}")
	private String atomed;
	
	/**
	 * 文档转换服务 只有拆分版
	 */
	@Value("${http.fcs}")
	private String fcs;
	
	/**
	 * 印章服务拆分版注册中心名称
	 */
	@Value("${http.seal}")
	private String seal;
	
	/**
	 * 文件存储服务拆分版注册中心名称
	 */
	@Value("${http.fss}")
	private String fss;
	
	/**
	 * 证书服务拆分版注册中心名称
	 */
	@Value("${http.cs}")
	private String cs;
	
	/**
	 * 签章验章服务拆分版注册中心名称
	 */
	@Value("${http.dsvs}")
	private String dsvs;
	
	/**
	 * 文档生成服务拆分版注册中心名称
	 */
	@Value("${http.dgs}")
	private String dgs;
	
	/**
	 * 是否校验token 默认校验
	 */
	@Value("${http.tokened:1}")
	private String tokened;
	
	
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
	
	/**
	 * 是否为校验token
	 * @return
	 * @throws HttpException
	 */
	public boolean tokened() throws HttpException{
		if( "1".equals(tokened) || "true".equalsIgnoreCase(tokened) ) {
			return true;
		}
		return false;
	}
}
