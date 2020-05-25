package com.itrus.common.params.uag;

import com.itrus.common.params.uag.BaseUagParams;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * <p>
 *  UAG 根据手机号或uuid集合获取用户基本信息实体类
 * </p>
 *
 * @author han_yanhui
 * @since 2020-5-25 10:30:12
 */
@Data
@EqualsAndHashCode(callSuper=true)
@ToString
public class UserListParams extends BaseUagParams{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 用户uuid集合 手机号和uuid集合二选一
	 */
	private Long[] uuidList;
	
	/**
	 *用户手机号集合 手机号和uuid集合二选一
	 */
	private String[] phoneList;
	
	
	public UserListParams() {
		super();
	}
	
	public UserListParams(String manager,Long[] uuidList) {
		super(manager, null);
		this.uuidList = uuidList;
	}
	
	public UserListParams(String manager,String[] phoneList) {
		super(manager, null);
		this.phoneList = phoneList;
	}

}
