package com.itrus.common.response.dsvs;

import com.itrus.common.response.dsvs.entity.KeywordCoordinate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName DsvsKeywordCoordinatesResult
 * @Author: Yuliu
 * @Description:
 * @Date:Created in 11:56 2020/8/29
 * @Modified By:
 * @Version 1.0
 **/
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DsvsKeywordCoordinatesResult implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;


   private  List<KeywordCoordinate>  keywordCoordinates;


}
