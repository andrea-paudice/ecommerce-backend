package com.cp.project_mangashop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cp.project_mangashop.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

	
	
}
