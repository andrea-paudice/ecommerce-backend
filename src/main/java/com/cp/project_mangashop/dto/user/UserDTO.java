package com.cp.project_mangashop.dto.user;

import java.time.LocalDate;
import java.util.List;

import com.cp.project_mangashop.dto.cart.CartCreateDTO;
import com.cp.project_mangashop.dto.cart.CartDTO;
import com.cp.project_mangashop.entity.CartItem;
import com.cp.project_mangashop.entity.User;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
public class UserDTO {

	private int userId;
	@NotNull(message = "L'username è obbligatorio")
	private String username;
	@NotNull(message = "La passowrd è obbligatoria")
	private String password;
	@NotNull(message = "La mail è obbligatoria")
	private String email;
	private String role;
	private CartDTO cart;
	private CartCreateDTO cartCreate;
	
}
