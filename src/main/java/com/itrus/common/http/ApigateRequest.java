package com.itrus.common.http;

import cn.com.itrus.atom.sign.common.bean.Result;
import com.alibaba.fastjson.JSONObject;
import com.itrus.common.request.apigate.CountRequest;
import com.itrus.common.request.apigate.GetJwtTokenRequest;
import com.itrus.common.request.apigate.RefreshTokenRequest;
import com.itrus.common.response.apigate.GetJwtTokenResult;
import com.itrus.common.response.apigate.PrecountResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName ApigateRequest
 * @Author: Yuliu
 * @Description: 网关调用方法
 * @Date:Created in 20:30 2020/9/1
 * @Modified By:
 * @Version 1.0
 **/
@Slf4j
@Component
public class ApigateRequest {

    private static final Long SUCCESSCODE = 0L;

    @Autowired
    private GateRequest gateRequest;

    /**
     * 成功获取里面的值
     *
     * @param result
     * @return
     * @throws HttpException
     */
    private Object isOk(Result<?> result) throws HttpException {
        Long code = result.getCode();
        if (code != null && SUCCESSCODE.equals(code)) {
            return result.getData();
        }
        throw new HttpException(result.getMsg());
    }

    /**
     * 获取jwtToken
     *
     * @param getJwtTokenRequest
     * @return
     * @throws Exception
     */
    public GetJwtTokenResult getJwtToken(GetJwtTokenRequest getJwtTokenRequest) throws Exception {

        GetJwtTokenResult getJwtTokenResult = (GetJwtTokenResult) isOk(gateRequest.getJwtToken(getJwtTokenRequest));
        return getJwtTokenResult;
    }

    /**
     * 刷新jwtToken
     *
     * @param refreshTokenRequest
     * @return
     * @throws Exception
     */
    public RefreshTokenRequest refreshToken(RefreshTokenRequest refreshTokenRequest) throws Exception {
        RefreshTokenRequest refreshTokenResponse = (RefreshTokenRequest) isOk(gateRequest.refreshToken(refreshTokenRequest));
        return refreshTokenResponse;
    }

    /**
     * 产品计数
     *
     * @param countRequest
     * @return
     */
    public Result<JSONObject> count(CountRequest countRequest) {
        return gateRequest.count(countRequest);
    }

    /**
     * 产品预计数
     *
     * @param countRequest
     * @return
     * @throws Exception
     */
    public PrecountResult precount(CountRequest countRequest) throws Exception {
        PrecountResult precountResult = (PrecountResult) isOk(gateRequest.precount(countRequest));
        return precountResult;
    }

    /**
     * 产品预计数提交
     *
     * @param precountResult
     * @return
     */
    public Result<JSONObject> commitPrecount(PrecountResult precountResult) {
        return gateRequest.commitPrecount(precountResult);
    }

    /**
     * 产品预计数回滚
     *
     * @param precountResult
     * @return
     */
    public Result<JSONObject> rollbackPrecount(PrecountResult precountResult) {
        return gateRequest.rollbackPrecount(precountResult);
    }


}
