package com.itrus.common.enums.dsvs;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: meng
 * @Description:
 * @Date: Create in 18:53 2020/8/25 0025
 */
@Getter
@AllArgsConstructor
public enum VdsResultEunm {
    VDSRESULT_0(0,"成功"),
    VDSRESULT_1(1,"数字签名无效"),
    VDSRESULT_2(2,"签名后添加批注信息");
    private Integer code;
    private String name;
}
