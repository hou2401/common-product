package com.itrus.common.response.uag;

import com.itrus.common.response.uag.entity.orgCompany;
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
public class FindNameForAuthorityResult implements Serializable {
    private String person;
    private HashMap<String, orgCompany> company;
}
