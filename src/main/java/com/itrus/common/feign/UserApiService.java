package com.itrus.common.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itrus.common.params.uag.user.RegisterParams;
import com.itrus.common.result.uag.UagResult;
import com.itrus.common.result.uag.user.RegisterResult;

@FeignClient("userapi")
public interface UserApiService {

	/**
	 * 	用户注册
	    * @api {POST} /user/register [用户注册]
	    * @apiVersion version
	    * @apiUse RegisterParams
	    * @apiName  register
	    * @apiGroup userapi
	    * @apiSuccess [(group)] [{type}] field [description]
	 */
	@PostMapping("/user/register")
	UagResult<RegisterResult> register(RegisterParams params);

	
	
}
