package com.prueba.inditex.entity.error;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorEntity {

	private int code;
	
	private String message;
	
}
