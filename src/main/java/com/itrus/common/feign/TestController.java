package com.itrus.common.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itrus.common.dto.HttpDTO;
import com.itrus.common.params.uag.user.RegisterParams;
import com.itrus.common.result.uag.UagResult;

@RequestMapping("test")
@RestController
public class TestController {

	  @Autowired
	    private HttpDTO http;
	@GetMapping("testAbc")
	public UagResult<RegisterParams> test(){
		System.out.println("test");
		String alled = http.getAlled();
		System.out.println(alled);
		return null;
	}
}
