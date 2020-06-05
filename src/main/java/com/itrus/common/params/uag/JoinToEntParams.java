package com.itrus.common.params.uag;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

/**
 * <p>
 *  UAG 根据手机号或uuid集合获取用户基本信息实体类
 * </p>
 *
 * @author han_yanhui
 * @since 2020-5-25 10:30:12
 */
@ApiModel(description = "请求UAG切换企业实体类")
@ToString
@Data
public class JoinToEntParams implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 企业用户关联id
	 */
	private Long id;
	
	/**
	 *用户状态（ 1 已加入 3 拒绝 ）
	 */
	private String joinState;
	
	
	public JoinToEntParams() {
		super();
	}
	
	public JoinToEntParams(Long id,String joinState) {
		super();
		this.id = id;
		this.joinState = joinState;
	}

}
