package com.cp.project_mangashop.dto.cart;

import java.time.LocalDate;
import java.util.List;

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
public class CartCreateDTO {

	private int cartId;
	@NotNull(message = "L'utente è obbligatorio")
	private User user;
	private LocalDate creationDate;
	
}
