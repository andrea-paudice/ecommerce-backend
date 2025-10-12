package com.cp.project_mangashop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cp.project_mangashop.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	List<Product> findAllByDeletedIsFalse();
	
}
