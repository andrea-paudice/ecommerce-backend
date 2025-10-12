package com.cp.project_mangashop.dto.cart;

import java.time.LocalDate;
import java.util.List;

import com.cp.project_mangashop.dto.cartItem.CartItemDTO;
import com.cp.project_mangashop.entity.User;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CartDTO {

	private int cartId;
	@NotNull(message = "L'utente è obbligatorio")
	private User user;
	private List<CartItemDTO> cartItems;
	private LocalDate creationDate;
	private LocalDate updateDate;
	
}
