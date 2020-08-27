package com.itrus.common.response.uag;

import com.itrus.common.response.entity.Leaders;
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
public class SearchLeadersResult implements Serializable {
    private int total;

    private List<Leaders> leaders;
}
