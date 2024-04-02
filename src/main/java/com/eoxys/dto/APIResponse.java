package com.eoxys.dto;

import lombok.Data;

@Data
public class APIResponse {

	private boolean status;
	private String message;
	private Object data;

}
