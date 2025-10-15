package com.cp.project_mangashop.service.interfaces;

import com.cp.project_mangashop.entity.CartItem;

public interface CartItemService {

	public CartItem getCartItemById(int idCartItem);
	public void insertCartItem(CartItem cartItem);
	public void deleteCartitem(CartItem cartItem);
	
}
