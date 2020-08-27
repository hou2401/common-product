package com.itrus.common.result.uag.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

import com.itrus.common.result.uag.response.entity.CompanyInfo;
import com.itrus.common.result.uag.response.entity.DeptList;

/**
 * @author yuying
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoadResult implements Serializable {
    private CompanyInfo companyInfo;

    private List<DeptList> deptList;
}
