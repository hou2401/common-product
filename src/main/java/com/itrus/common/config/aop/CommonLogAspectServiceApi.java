package com.itrus.common.config.aop;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.itrus.common.params.ByteParams;
import com.itrus.common.request.atom.FssUploadRequest;
import com.itrus.common.request.atom.SealLimpidRequest;
import com.itrus.common.request.atom.UploadParams;
import com.itrus.common.request.fcs.GenerateThumbnailRequest;
import com.itrus.common.request.fcs.Pdf2pngRequest;
import com.itrus.common.request.fcs.TotalPageRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class CommonLogAspectServiceApi {

    /**
     * 以 controller 包下定义的所有请求为切入点
     */
    @Pointcut("execution(* com.itrus.common.http..*.*(..))")
    public void commonLogAspectServiceApi() {
    }

    /**
     * 在切点之前织入
     *
     * @param joinPoint
     * @throws Throwable
     */
    @Before("commonLogAspectServiceApi()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 开始打印请求日志
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        if (attributes == null) {
            return;
        }

        HttpServletRequest request = attributes.getRequest();

        // 打印请求相关参数
        log.info("========================================== common Start ==========================================");
        // 打印请求 url
        log.info("URL            : {}", request.getRequestURL().toString());
        // 打印 Http method
        log.info("HTTP Method    : {}", request.getMethod());
        // 打印调用 controller 的全路径以及执行方法
        log.info("Class Method   : {}.{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        // 打印请求的 IP
        log.info("IP             : {}", request.getRemoteAddr());
        // 打印请求入参
        Object[] args = joinPoint.getArgs();
        List<Object> arguments = new ArrayList<>(args.length);
        if (args != null) {
            for (Object arg : args) {
                if (arg instanceof ServletRequest
                        || arg instanceof ServletResponse
                        || arg instanceof MultipartFile
                        || arg instanceof byte[]
                        || arg instanceof ByteParams
                        || arg instanceof FssUploadRequest
                        || arg instanceof SealLimpidRequest
                        || arg instanceof UploadParams
                        || arg instanceof GenerateThumbnailRequest
                        || arg instanceof Pdf2pngRequest
                        || arg instanceof TotalPageRequest
                ) {
                    //ServletRequest不能序列化，从入参里排除，否则报异常：java.lang.IllegalStateException: It is illegal to call this method if the current request is not in asynchronous mode (i.e. isAsyncStarted() returns false)
                    //ServletResponse不能序列化 从入参里排除，否则报异常：java.lang.IllegalStateException: getOutputStream() has already been called for this response
                    continue;
                }
                arguments.add(arg);
            }
        }
        try {

            log.info("Request Args   : {}", new Gson().toJson(arguments));
        } catch (Exception e) {
            log.error("message={}", e.getMessage(), e);
        }
    }

    /**
     * 在切点之后织入
     *
     * @throws Throwable
     */
    @After("commonLogAspectServiceApi()")
    public void doAfter() throws Throwable {
        log.info("=========================================== common End ===========================================");
        // 每个请求之间空一行
        log.info("");
    }

    /**
     * 环绕
     *
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("commonLogAspectServiceApi()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        // 打印出参
        try {
            if (!(result instanceof String)) {
                log.info("Response Args  : {}", new Gson().toJson(result));
            }
        } catch (Exception e) {
            log.error("message={}", e.getMessage(), e);
        }
        // 执行耗时
        log.info("Time-Consuming : {} ms", System.currentTimeMillis() - startTime);
        return result;
    }

}

