package com.itrus.common.http;

import cn.com.itrus.atom.sign.common.bean.Result;
import com.itrus.common.request.ra.CertConfigRequest;
import com.itrus.common.request.ra.TimeStampRequest;
import com.itrus.common.response.ra.CertConfigResponse;
import com.itrus.common.response.ra.RaResult;
import com.itrus.common.response.ra.TimeStampResponse;
import org.bouncycastle.asn1.tsp.TimeStampReq;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.redis.core.script.ReactiveScriptExecutor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;

import java.awt.*;
import java.util.List;

/**
 * @author yuying
 */
@Component
@FeignClient(value = "${http.ra}") //value:被调用的服务在注册中心的名称
public interface RaApiRequest {
    /**
     * 新建RA证书配置
     *
     * @param obj
     * @return
     */
    @RequestMapping(value = "/web/ra/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    RaResult<String> RaAdd(CertConfigRequest obj);

    /**
     * 查询RA证书配置
     *
     * @param raCode
     * @return
     */
    @RequestMapping(value = "/web/ra/getByRaCode", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    RaResult<String> GetByRaCode(@RequestPart("raCode") String raCode);


    /**
     * 更新RA证书配置
     *
     * @param obj
     * @return
     */
    @RequestMapping(value = "/web/ra/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    RaResult<String> RaUpdate(CertConfigRequest obj);


    /**
     * 根据唯一标识删除区块链服务配置
     *
     * @param raCode
     * @return
     */
    @RequestMapping(value = "/web/ra/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    RaResult<String> RaDelete(@RequestPart("raCode") String raCode);

    /**
     * 查询区块链服务配置列表
     *
     * @param enterpriseId 必选 企业唯一标识
     * @param productId    可选 产品唯一标识
     * @return
     */
    @RequestMapping(value = "/web/ra/getList", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    RaResult<List<CertConfigResponse>> RaGetList(@RequestPart("enterpriseId") String enterpriseId, @RequestPart("productId") String productId);




}
