package com.itrus.common.params.uag;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BaseUagParams implements Serializable{
	
	   private static final long serialVersionUID = 1L;

	    /**
	     * 管理员账户，必填
	     */
	    private String manager;

	   /**
	    * 组织id
	    */
	    private Long uuid;
	    
	    

}
