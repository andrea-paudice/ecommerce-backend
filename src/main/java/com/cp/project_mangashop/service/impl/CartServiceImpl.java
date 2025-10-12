package com.cp.project_mangashop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.cp.project_mangashop.dto.cart.CartDTO;
import com.cp.project_mangashop.dto.cart.CartDTOMapper;
import com.cp.project_mangashop.entity.Cart;
import com.cp.project_mangashop.entity.Product;
import com.cp.project_mangashop.entity.User;
import com.cp.project_mangashop.repository.CartRepository;
import com.cp.project_mangashop.service.interfaces.CartService;

public class CartServiceImpl implements CartService{

	@Autowired
	CartRepository cartRepo;
	
	@Override
	public CartDTO getCartByUser(User user) {
		Cart cart = cartRepo.findByUser(user)
				.orElseThrow(() -> new RuntimeException("Carrello non presente"));
		CartDTO cartDTO = CartDTOMapper.CartToDTO(cart);
		
		return cartDTO;
	}

	@Override
	public Cart addProductToCart(User user, Product product, int quantity) {
		
		
		return null;
	}

	@Override
	public Cart removeProductFromCart(User user, int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clearCart(User user) {
		// TODO Auto-generated method stub
		
	}

}
