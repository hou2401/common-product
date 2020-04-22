package com.itrus.common.service.serviceutil;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import com.itrus.common.WebApplication;

@SpringBootTest(classes = WebApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)// 指定启动类
public class ServiceUtilTest extends AbstractTestNGSpringContextTests {
	
	
	
}
