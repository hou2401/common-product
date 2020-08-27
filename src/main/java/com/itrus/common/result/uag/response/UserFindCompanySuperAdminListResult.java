package com.itrus.common.result.uag.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFindCompanySuperAdminListResult implements Serializable {

    private HashMap<String,Object> data;
}
