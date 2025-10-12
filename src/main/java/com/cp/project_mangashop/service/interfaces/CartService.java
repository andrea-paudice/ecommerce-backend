package com.cp.project_mangashop.service.interfaces;

import com.cp.project_mangashop.dto.cart.CartDTO;
import com.cp.project_mangashop.entity.Cart;
import com.cp.project_mangashop.entity.Product;
import com.cp.project_mangashop.entity.User;

public interface CartService {
	
    CartDTO getCartByUser(User user);
    Cart addProductToCart(User user, Product product, int quantity);
    Cart removeProductFromCart(User user, int productId);
    void clearCart(User user);
    
}