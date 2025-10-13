package com.cp.project_mangashop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cp.project_mangashop.entity.CartItem;
import com.cp.project_mangashop.service.interfaces.CartItemRepository;
import com.cp.project_mangashop.service.interfaces.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService{

	@Autowired
	CartItemRepository cartItemRepo;
	
	@Override
	public void insertCartItem(CartItem cartItem) {
		cartItemRepo.save(cartItem);
		
	}

	

	
	
}
