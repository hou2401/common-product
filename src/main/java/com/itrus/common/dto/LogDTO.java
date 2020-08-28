package com.itrus.common.dto;

import lombok.Data;

@Data
public class LogDTO {
	public static final int SUCCESS = 0;
	public static final int FAILED = 1;
	//提供服务的主机ip，为了运维测试时好找哪个机器出现问题。
	private String ip;
	//服务的名称  对应我们业务系统，请求头中会获取到
	private String serverCode;
	//服务的编号  对应我们业务系统，请求头中会获取到
	private String serverName;
	//产品编号 ，平台定义的，请求头中会获取到
	private String serviceCode;
	//产品名称 ，平台定义的，请求头中会获取到
	private String serviceName;
	//当前访问所属企业编号，请求头中会获取到
	private String companyUuid;
	//当前访问所属企业名称，请求头中会获取到
	private String companyName;
	//请求唯一标识，请求头中会获取到，用于串联多个系统的来回调用。
	private String requestId;
	//用户请求的业务单号
	private String orderId;
	//天威产生的业务唯一单号。
	private String itrusOrderId;
	//成功或者失败
	private Integer result;
	//成功或者失败原因
	private String description;
}
