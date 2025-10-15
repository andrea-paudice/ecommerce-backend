package com.cp.project_mangashop.service.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cp.project_mangashop.entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Integer>{

	void deleteByCart_CartId(int idCart);
	
}
