package com.itrus.common.request.fcs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * @ClassName TotalPageRequest
 * @Author: Yuliu
 * @Description:
 * @Date:Created in 9:47 2020/8/31
 * @Modified By:
 * @Version 1.0
 **/
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TotalPageRequest implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 需要操作的文件
     */
    private MultipartFile multipartFile;

}
