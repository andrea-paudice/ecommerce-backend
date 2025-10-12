package com.cp.project_mangashop.dto.user;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserDTO {

	private int userId;
	@NotNull(message = "L'username è obbligatorio")
	private String username;
	@NotNull(message = "La passowrd è obbligatoria")
	private String password;
	@NotNull(message = "La mail è obbligatoria")
	private String email;
	private String role;
	
}
