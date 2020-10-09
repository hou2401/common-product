package com.itrus.common.http;

import cn.com.itrus.atom.sign.common.bean.Result;
import com.alibaba.fastjson.JSONObject;
import com.itrus.common.request.apigate.CountRequest;
import com.itrus.common.request.apigate.GetJwtTokenRequest;
import com.itrus.common.request.apigate.RefreshTokenRequest;
import com.itrus.common.response.apigate.GetJwtTokenResult;
import com.itrus.common.response.apigate.PrecountResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName GateRequest
 * @Author: Yuliu
 * @Description:
 * @Date:Created in 20:33 2020/9/1
 * @Modified By:
 * @Version 1.0
 **/
@FeignClient(value = "${http.apigate}")
public interface GateRequest {

    /**
     * 获取jwtToken
     *
     * @param obj 请求参数
     * @return 返回创建结果
     */
    @RequestMapping(value = "/auth/appAuth", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    Result<GetJwtTokenResult> getJwtToken(GetJwtTokenRequest obj);

    /**
     * 刷新jwtToken
     *
     * @param obj 请求参数
     * @return 返回创建结果
     */
    @RequestMapping(value = "/auth/refreshToken", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    Result<RefreshTokenRequest> refreshToken(RefreshTokenRequest obj);

    /**
     * 产品计数
     *
     * @param obj 请求参数
     * @return 返回创建结果
     */
    @RequestMapping(value = "/count", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    Result<JSONObject> count(CountRequest obj);

    /**
     * 产品预计数
     *
     * @param obj 请求参数
     * @return 返回创建结果
     */
    @RequestMapping(value = "/precount", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    Result<PrecountResult> precount(CountRequest obj);

    /**
     * 产品预计数提交
     *
     * @param obj 请求参数
     * @return 返回创建结果
     */
    @RequestMapping(value = "/commitPrecount", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    Result<JSONObject> commitPrecount(PrecountResult obj);

    /**
     * 产品预计数回滚
     *
     * @param obj 请求参数
     * @return 返回创建结果
     */
    @RequestMapping(value = "/rollbackPrecount", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    Result<JSONObject> rollbackPrecount(PrecountResult obj);


}
