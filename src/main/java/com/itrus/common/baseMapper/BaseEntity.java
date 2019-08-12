package com.itrus.common.baseMapper;
import com.alibaba.fastjson.JSON;
import lombok.Data;
import javax.persistence.Transient;
import java.io.Serializable;

/**
 * <p>Title: BaseEntity.java</p>
 * <p>Description:实体类通用属性 </p>
 * <p>Copyright: Copyright (c) 2019</p>
 * <p>Company: com.itrus</p>
 * @author wen_guoxing
 * @date 2019年8月9日
 * @version 1.0
 */
@Data
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 查询时between的开始时间
	 */
	@Transient
	private String startTime;

	/**
	 * 查询时between的结束时间
	 */
	@Transient
	private String endTime;

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

}
