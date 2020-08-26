package com.itrus.common.enums.dsvs;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: meng
 * @Description:
 * @Date: Create in 18:50 2020/8/25 0025
 */
@Getter
@AllArgsConstructor
public enum VcResultEnum {
    VCRESULT_0(0,"成功"),
    VCRESULT_1(1,"证书已吊销"),
    VCRESULT_2(2,"证书不在有效期内"),
    VCRESULT_4(4,"无效的证书签名"),
    VCRESULT_8(8,"证书损坏。（证书编码格式异常，无法解析证书。）"),
    VCRESULT_9(9,"证书无吊销列表URI"),
    VCRESULT_10(10,"吊销列表下载失败"),
    VCRESULT_11(11,"吊销列表解释失败");
    private Integer code;
    private String name;
}
