package com.itrus.common.response.atom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author yuying
 * 文件上传
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FssUploadResult implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * 文件存储ID
     */
    private Long fssId;
    /**
     * 文件SHA1的hash值
     */
    private String hashValue;
}
