package com.itrus.common.enums.dsvs;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: meng
 * @Description:
 * @Date: Create in 18:55 2020/8/25 0025
 */
@Getter
@AllArgsConstructor
public enum VtsResultEnum {
    VTSRESULT_0(0,"成功"),
    VTSRESULT_1(1,"时间戳验证失败"),
    VTSRESULT_9(9,"无时间戳");
    private Integer code;
    private String name;
}
