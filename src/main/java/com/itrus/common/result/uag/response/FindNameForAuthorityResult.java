package com.itrus.common.result.uag.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;

import com.itrus.common.result.uag.response.entity.orgCompany;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindNameForAuthorityResult implements Serializable {
    private String person;
    private HashMap<String, orgCompany> company;
}
