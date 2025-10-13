package com.cp.project_mangashop.service.interfaces;

import com.cp.project_mangashop.dto.cart.CartDTO;
import com.cp.project_mangashop.entity.Cart;
import com.cp.project_mangashop.entity.CartItem;
import com.cp.project_mangashop.entity.Product;
import com.cp.project_mangashop.entity.User;

public interface CartService {
	
    Cart getCartByUser(User user);
    Cart saveCart(User user);
    void addProductToCart(User user, CartItem newCartItem);
    Cart removeProductFromCart(User user, int productId);
    void clearCart(User user);
    
}