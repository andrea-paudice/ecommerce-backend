package com.cp.project_mangashop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cart_items")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
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

	@Override
	public String toString() {
		return "CartItem [idCartItem=" + idCartItem + ", product=" + product + "]";
	}
	
	
	
}
