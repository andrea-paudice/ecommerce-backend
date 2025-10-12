package com.cp.project_mangashop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "cart_items")
@Data
public class CartItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCartItem;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_cart")
	private Cart cart;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_product")
	private Product product;
	
}
