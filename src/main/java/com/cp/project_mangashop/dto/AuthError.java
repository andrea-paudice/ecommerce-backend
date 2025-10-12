package com.cp.project_mangashop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AuthError {

	private String username;
	private String password;
	private String message;
	
}
