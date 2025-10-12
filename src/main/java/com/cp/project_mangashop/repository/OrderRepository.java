package com.cp.project_mangashop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cp.project_mangashop.entity.Order;
import com.cp.project_mangashop.entity.User;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

	public List<Order> findByUser(User user);
	
}
