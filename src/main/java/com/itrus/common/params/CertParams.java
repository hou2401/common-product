package com.itrus.common.params;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

/**
 * @author lixc
 * @ClassName CertDTO.java
 * @Description
 * @createTime 2020年02月18日 20:58:00
 */

@ApiModel(description = "证书请求参数实体")
@ToString
@Component
@Data
public class CertParams implements Serializable {

    private static final long serialVersionUID = 8307540918174470372L;

    /**
     * 单位名称
     */
    private String o;

    /**
     * 部门名称
     */
    private String ou;

    /**
     * 个人姓名或者企业名称
     */
    private String cn;

    /**
     * 申请证书所使用的RA,由服务提供者进行配置
     */
    private String raCode;

    /**
     * 证书有效天数，默认使用RA配置的有效天数
     */
    private Integer validDays;

    /**
     * 证书扩展信息
     */
    private JSON extJson;

	public CertParams(String o, String ou, String cn, String raCode, Integer validDays, JSON extJson) {
		super();
		this.o = o;
		this.ou = ou;
		this.cn = cn;
		this.raCode = raCode;
		this.validDays = validDays;
		this.extJson = extJson;
	}

	public CertParams() {
		super();
	}
    
}
