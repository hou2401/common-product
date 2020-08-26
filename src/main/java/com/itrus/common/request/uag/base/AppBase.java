package com.itrus.common.request.uag.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppBase {
    /**
     * 应用id
     */
    private String appId;
    /**
     * 应用名称
     */
    private String appName;
    /**
     * 应用key
     */
    private String appKey;
}
