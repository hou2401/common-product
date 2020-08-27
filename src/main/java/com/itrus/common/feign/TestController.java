package com.itrus.common.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.itrus.common.dto.HttpDTO;
import com.itrus.common.http.AtomedApiRequest;
import com.itrus.common.http.CommonRequest;
import com.itrus.common.params.CertParams;
import com.itrus.common.params.uag.user.RegisterParams;
import com.itrus.common.result.uag.UagResult;

import cn.com.itrus.atom.sign.common.bean.Result;

@RequestMapping("test")
@RestController
public class TestController {

	@Autowired
	private HttpDTO http;
	  
	@Autowired
	private CommonRequest commonRequest;
	
	@Autowired
	private AtomedApiRequest request;
	@GetMapping("testAbc")
	public UagResult<RegisterParams> test() throws Exception{
		System.out.println("testapbc---1");
		Result<JSONObject> applyCert = request.applyCert(new CertParams());
		System.out.println("testapbc---2"+JSONObject.toJSONString(applyCert));
		JSONObject applyCert1 = commonRequest.applyCert(new CertParams());
		System.out.println("testapbc---3"+JSONObject.toJSONString(applyCert1));
		return null;
	}
}
