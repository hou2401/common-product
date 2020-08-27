package com.itrus.common.response.uag.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubInfo implements Serializable {
    private String orgName;

    private String uuid;
}
