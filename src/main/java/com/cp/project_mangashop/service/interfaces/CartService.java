package com.cp.project_mangashop.service.interfaces;

import com.cp.project_mangashop.entity.Cart;
import com.cp.project_mangashop.entity.CartItem;
import com.cp.project_mangashop.entity.User;

public interface CartService {
	
    public Cart getCartByUser(User user);
    public Cart saveCart(User user);
    public void updateCart(Cart cart);
    public void addProductToCart(User user, CartItem newCartItem);
    public void clearCart(User user);
    
}