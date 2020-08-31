package com.itrus.common.result.uag.response;

import com.itrus.common.result.uag.response.entity.LoadTree;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

import com.itrus.common.result.uag.response.entity.DeptInfo;
import com.itrus.common.result.uag.response.entity.UserInfoBase;

/**
 * @author yuying
 * 加载企业下全量节点信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoadTreeResult implements Serializable {

    private List<LoadTree> data;
}
