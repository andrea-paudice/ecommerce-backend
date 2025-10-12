package com.cp.project_mangashop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cp.project_mangashop.entity.Cart;
import com.cp.project_mangashop.entity.User;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    Optional<Cart> findByUser(User user);
}
