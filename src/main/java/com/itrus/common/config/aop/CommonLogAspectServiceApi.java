package com.itrus.common.config.aop;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;

import lombok.extern.slf4j.Slf4j;

/**
 * AOP   前置通知 后置通知
// 申明是个spring管理的bean
 */
@Aspect
@Component
@Slf4j
public class CommonLogAspectServiceApi {
	
	
	
	
	
	// 申明一个切点 里面是 execution表达式
	@Pointcut("execution(* com.itrus.common.http..*.*(..))")
	private void controllerAspect() {
	}

	// 请求method前打印内容
	@Before(value = "controllerAspect()")
	public void methodBefore(JoinPoint joinPoint) {
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		
		if( requestAttributes == null ){
			return;
		}
		
		HttpServletRequest request = requestAttributes.getRequest();
		log.info("==========common=====请求内容===============");
		try {
			// 打印请求内容
			log.info("请求地址:" + request.getRequestURL().toString());
			log.info("请求方式:" + request.getMethod());
			log.info("请求类方法:" + joinPoint.getSignature());
			Object[] args = joinPoint.getArgs();
			List<Object> arguments = new ArrayList<>(args.length);
			for (int i = 0; i < args.length; i++) {
				if (args[i] instanceof ServletRequest || args[i] instanceof ServletResponse || args[i] instanceof MultipartFile) {
					//ServletRequest不能序列化，从入参里排除，否则报异常：java.lang.IllegalStateException: It is illegal to call this method if the current request is not in asynchronous mode (i.e. isAsyncStarted() returns false)
					//ServletResponse不能序列化 从入参里排除，否则报异常：java.lang.IllegalStateException: getOutputStream() has already been called for this response
					continue;
				}
				arguments.add(args[i]);
			}
			if (arguments != null && !(arguments.isEmpty())) {
				log.info("请求类方法参数:" + JSONObject.toJSONString(arguments) );
			}
		} catch (Exception e) { 
			log.error("###CommonLogAspectServiceApi.class methodBefore() ### ERROR:", e); 
		} 
		log.info("==========common=====请求内容==============="); 
	} 
	// 在方法执行完结后打印返回内容
	@AfterReturning(returning = "o", pointcut = "controllerAspect()") 
	public void methodAfterReturing(Object o) { 
		log.info("----------common----返回内容----------------"); 
		try { 
			log.info("Response内容:" + JSONObject.toJSONString(o)); 
		} catch (Exception e) {
			log.error("###CommonLogAspectServiceApi.class methodAfterReturing() ### ERROR:", e);
		}
		log.info("----------common----返回内容----------------");  
	}

}
