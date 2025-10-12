package com.cp.project_mangashop.dto.cartItem;

import com.cp.project_mangashop.dto.cart.CartDTO;
import com.cp.project_mangashop.dto.product.ProductDTO;

import lombok.Data;

@Data
public class CartItemDTO {

	private int idCartItem;
	private CartDTO cart;
	private ProductDTO product;
	
}
