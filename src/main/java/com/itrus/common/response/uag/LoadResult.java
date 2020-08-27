package com.itrus.common.response.uag;

import com.itrus.common.response.uag.entity.CompanyInfo;
import com.itrus.common.response.uag.entity.DeptList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

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
