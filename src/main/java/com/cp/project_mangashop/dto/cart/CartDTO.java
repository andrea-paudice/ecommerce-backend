package com.cp.project_mangashop.dto.cart;

import java.time.LocalDate;
import java.util.List;

import com.cp.project_mangashop.dto.cartItem.CartItemDTO;
import com.cp.project_mangashop.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class CartDTO {

	private int cartId;
	@NotNull(message = "L'utente è obbligatorio")
	@JsonIgnore
	private User user;
	private List<CartItemDTO> cartItems;
	private LocalDate creationDate;
	private LocalDate updateDate;
	
}
