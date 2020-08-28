package com.itrus.common.result.uag.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeptInfo implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String uuid;
	
	private String type;
}
