package com.itrus.common.baseMapper;

import tk.mybatis.mapper.common.*;

/**
* <p>Title: MyBaseMapper.java</p>
* <p>Description: 通用mapper接口</p>
* <p>Copyright: Copyright (c) 2019</p>
* <p>Company: com.itrus</p>
* @author wen_guoxing
* @date 2019年8月9日
* @version 1.0
 */
public interface MyBaseMapper<T> extends BaseMapper<T>, MySqlMapper<T>, IdsMapper<T>, ConditionMapper<T>, ExampleMapper<T> {


}
