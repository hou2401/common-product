package com.itrus.common.response.uag;

import com.itrus.common.response.entity.Company;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindCompanyListResult implements Serializable {
    private Integer total;

    private List<Company> companyList;
}
