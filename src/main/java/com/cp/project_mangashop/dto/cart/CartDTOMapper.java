package com.cp.project_mangashop.dto.cart;

import com.cp.project_mangashop.dto.cartItem.CartItemDTOMapper;
import com.cp.project_mangashop.entity.Cart;

public class CartDTOMapper {

	public static Cart DTOToCart(CartDTO cartDTO) {
		Cart cart = new Cart();
		
		cart.setCartId(cartDTO.getCartId());
		cart.setUser(cartDTO.getUser());
		cart.setCartItems(cartDTO.getCartItems()
				.stream()
				.map(cartItem -> CartItemDTOMapper.DTOToCartItem(cartItem))
				.toList());
		cart.setCreationDate(cartDTO.getCreationDate());
		cart.setUpdateDate(cartDTO.getUpdateDate());
		
		return cart;
		
	}

	public static CartDTO CartToDTO(Cart cart) {
		CartDTO cartDTO = new CartDTO();
		
		cartDTO.setCartId(cart.getCartId());
		cartDTO.setUser(cart.getUser());
		cartDTO.setCartItems(cart.getCartItems()
					.stream()
					.map(cartItem -> CartItemDTOMapper.cartItemToDTO(cartItem))
					.toList());
		
		cartDTO.setCreationDate(cart.getCreationDate());
		cartDTO.setUpdateDate(cart.getUpdateDate());
		
		return cartDTO;
	}
	
	public static CartCreateDTO CartToDTOCreate(Cart cart) {
		CartCreateDTO cartDTO = new CartCreateDTO();
		
		cartDTO.setCartId(cart.getCartId());
		cartDTO.setUser(cart.getUser());
		cartDTO.setCreationDate(cart.getCreationDate());

		
		return cartDTO;
	}
	
}
