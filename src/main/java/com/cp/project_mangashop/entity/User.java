package com.cp.project_mangashop.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private int userId;
	
	@Column(nullable = false, unique = true)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	private String email;
	
	private String role = "ROLE_USER";
	
	@OneToMany(mappedBy = "user")
	private List<Order> orders;
	
}
