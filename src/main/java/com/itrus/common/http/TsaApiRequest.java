package com.itrus.common.http;

import com.itrus.common.request.ra.TimeStampRequest;
import com.itrus.common.response.ra.RaResult;
import com.itrus.common.response.ra.TimeStampResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;

/**
 * @author yuying
 * 时间戳服务配置接口
 */
@Component
@FeignClient(value = "${http.tsa}") //value:被调用的服务在注册中心的名称
public interface TsaApiRequest {
    /**
     * 新增时间戳配置
     *
     * @param obj
     * @return
     */
    @RequestMapping(value = "/web/tsa/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    RaResult<String> TsaAdd(TimeStampRequest obj);

    /**
     * 根据企业唯一标识查询时间戳配置详情，只返回最后一次添加的一条
     *
     * @param enterpriseId 必填 企业唯一标识
     * @param productId    可选 产品唯一标识
     * @return
     */
    @RequestMapping(value = "/web/tsa/getTsaConfig", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    RaResult<TimeStampResponse> TsaGetTsaConfig(@RequestPart("enterpriseId") String enterpriseId, @RequestPart("productId") String productId);

    /**
     * 根据tsaCode查询时间戳配置是否已存在
     *
     * @param tsaCode 必选 时间戳代码
     * @return
     */

    @RequestMapping(value = "/web/tsa/getByTsaCode", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    RaResult<TimeStampResponse> TsaGetByTsaCode(@RequestPart("tsaCode") String tsaCode);

    /**
     * 根据tsaCode更新时间戳配置
     *
     * @param obj
     * @return
     */
    @RequestMapping(value = "/web/tsa/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    RaResult<String> TsaUpdate(TimeStampRequest obj);

    /**
     * 根据tsaCode删除时间戳服务配置
     *
     * @param tsaCode 必填 时间戳代码
     * @return
     */
    @RequestMapping(value = "/web/tsa/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    RaResult<String> TsaDelete(@RequestPart("tsaCode") String tsaCode);
}
