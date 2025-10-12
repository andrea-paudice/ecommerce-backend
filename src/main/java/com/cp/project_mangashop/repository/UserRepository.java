package com.cp.project_mangashop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cp.project_mangashop.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	Optional<User> findByUsername(String username);
	
}
