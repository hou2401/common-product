package com.itrus.common.response.ra;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpException;

import java.io.Serializable;

/**
 * @author yuying
 */
@Data
@ToString
@AllArgsConstructor
public class RaResult<T> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private static final Integer GET_CODE = 0;
    public static final String DATA_KEY = "data";
    public static final String defaultMessage = "调用失败";
    private static final Integer okCode = 0;

    /**
     * 返回状态
     */
    public Integer code;

    /**
     * 返回消息
     */
    public String msg;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public T data;

    /**
     * 请求OK
     *
     * @param result json对象
     */
    public boolean isOk() {
        return GET_CODE.equals(code) ? true : false;
    }

    /**
     * 请求不OK
     *
     * @param result json对象
     */
    public boolean isNotOk() {
        return !isOk();
    }

    /**
     * 获取响应失败提示语
     */
    public String getMessage() {
        if (StringUtils.isBlank(msg)) {
            return defaultMessage;
        }
        return msg;
    }

    public static Object isOk(RaResult<?> result) throws HttpException {
        Integer code = result.getCode();
        if (code != null && code.equals(okCode)) {
            return result.getData();
        }
//        return result.getMsg();
        throw new HttpException(result.getMsg());
    }

}

