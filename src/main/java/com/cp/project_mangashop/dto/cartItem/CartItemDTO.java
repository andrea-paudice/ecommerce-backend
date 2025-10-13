package com.cp.project_mangashop.dto.cartItem;

import java.time.LocalDate;
import java.util.List;

import com.cp.project_mangashop.dto.cart.CartDTO;
import com.cp.project_mangashop.dto.product.ProductDTO;
import com.cp.project_mangashop.entity.CartItem;
import com.cp.project_mangashop.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class CartItemDTO {

	private int idCartItem;
//	@JsonIgnore
//	private CartDTO cart;
	private ProductDTO product;
	
}
