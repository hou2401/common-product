package com.itrus.common.request.uag.atom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FssUploadRequest {
	
	//要上传的文件  必选
	private byte[] fileBytes;
	//文件名称 可选
	private String fileName;
	//业务类型，字符串格式[0-9a-zA-Z_-]*，最大长度为20个字符推荐：seal、src_contract、signed_contract...  可选
	private String bizType;
	//加密类型：1. 不加密（默认） (可选)
	private Integer encryptionType;
    
    String originalFilename;
    
}
