package com.cp.project_mangashop.dto.cartItem;

import com.cp.project_mangashop.dto.cart.CartDTOMapper;
import com.cp.project_mangashop.dto.product.ProductDTOMapper;
import com.cp.project_mangashop.entity.CartItem;

public class CartItemDTOMapper {

	public static CartItem DTOToCartItem(CartItemDTO cartItemDTO) {
		CartItem cartItem = new CartItem();
		
		cartItem.setIdCartItem(cartItemDTO.getIdCartItem());
		cartItem.setProduct(ProductDTOMapper.DTOtoProduct(cartItemDTO.getProduct()));

		return cartItem;
		
	}
	
	public static CartItemDTO cartItemToDTO(CartItem cartItem) {
		CartItemDTO cartItemDTO = new CartItemDTO();
		
		cartItemDTO.setIdCartItem(cartItem.getIdCartItem());
		cartItemDTO.setProduct(ProductDTOMapper.productToDTO(cartItem.getProduct()));

		return cartItemDTO;
		
	}
	
}
