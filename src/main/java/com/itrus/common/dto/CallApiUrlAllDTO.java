package com.itrus.common.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.itrus.common.dto.atom.Cert;
import com.itrus.common.dto.atom.Dgs;
import com.itrus.common.dto.atom.Dsvs;
import com.itrus.common.dto.atom.File;
import com.itrus.common.dto.atom.Seal;
import com.itrus.common.dto.atom.Uag;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Component
@ConfigurationProperties(prefix = "callapiurl")
@PropertySource("classpath:config/CallApiPartUrlDTO.properties")
public class CallApiUrlAllDTO {
	
	/**
	 * 印章相关url集合
	 */
	private Seal seal;

	/**
	 * 文件处理相关的url地址
	 */
	private File file;

	/**
	 * ####################证书服务#####################
	 */
	private Cert cert;
	
	/**
	##################签章验章######################
	 * 
	 */
	private Dsvs dsvs;
	
	/**
	##################文档生产服务######################
	 * 
	 */
	private Dgs dgs;
	/**
	##################UAG######################
	 * 
	 */
//	private Uag uag;
	
}
