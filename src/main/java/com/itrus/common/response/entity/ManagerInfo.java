package com.itrus.common.response.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ManagerInfo implements Serializable {
    private int uuid;

    private String creatorName;

    private String phone;

    private String email;

    private String state;

    private String createTime;
}
