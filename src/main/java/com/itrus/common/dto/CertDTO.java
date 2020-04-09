package com.itrus.common.dto;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import io.swagger.annotations.ApiModel;
import lombok.ToString;

/**
 * @author han_yanhui
 * @ClassName CertDTO.java
 * @Description
 * @createTime 2020年02月18日 20:58:00
 */

@ApiModel(description = "证书请求参数实体")
@ToString
@Component
public class CertDTO implements Serializable {

    private static final long serialVersionUID = 8307540918174470372L;

    /**
     * 单位名称
     */
    @Value("${itrus.cert.oName}")
    private String o;

    /**
     * 部门名称
     */
    @Value("${itrus.cert.ouName}")
    private String ou;

    /**
     * 个人姓名或者企业名称
     */
    private String cn;

    /**
     * 申请证书所使用的RA,由服务提供者进行配置
     */
    @Value("${itrus.cert.raCode}")
    private String raCode;

    /**
     * 证书有效天数，默认使用RA配置的有效天数
     */
    @Value("${itrus.cert.validDays}")
    private Integer validDays;

    /**
     * 证书扩展信息
     */
    private JSON extJson;
    
    public void setO(String o) {
    	this.o = o;
    }
    
    public void setOu(String ou) {
    	this.ou = ou;
    }

	public void setCn(String cn) {
		this.cn = cn;
	}

	public void setExtJson(JSON extJson) {
		this.extJson = extJson;
	}

	public String getO() {
		return o;
	}

	public String getOu() {
		return ou;
	}

	public String getCn() {
		return cn;
	}

	public String getRaCode() {
		if( StringUtils.isBlank(raCode) ) {
			return null;
		}
		return raCode;
	}

	public Integer getValidDays() {
		return validDays;
	}

	public JSON getExtJson() {
		return extJson;
	}
	
}
