package com.cp.project_mangashop.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cp.project_mangashop.entity.Cart;
import com.cp.project_mangashop.entity.CartItem;
import com.cp.project_mangashop.entity.User;
import com.cp.project_mangashop.repository.CartRepository;
import com.cp.project_mangashop.service.interfaces.CartService;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	CartRepository cartRepo;
	
	@Override
	public Cart saveCart(User user) {
		Cart newCart = new Cart();
		newCart.setUser(user);
		newCart.setCreationDate(LocalDate.now());
		
		cartRepo.save(newCart);

		return newCart;
	}
	
	@Override
	public Cart getCartByUser(User user) {
		Cart cart = cartRepo.findByUser(user)
				.orElseThrow(() -> new RuntimeException("Carrello non presente"));
		
		return cart;
	}

	@Override
	public void addProductToCart(User user, CartItem newCartItem) {
		Cart cart = user.getCart();
		List<CartItem> cartItems = cart.getCartItems();
		cartItems.add(newCartItem);
		
	}


	@Override
	public void clearCart(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCart(Cart cart) {
		cartRepo.save(cart);
	}

	

}
