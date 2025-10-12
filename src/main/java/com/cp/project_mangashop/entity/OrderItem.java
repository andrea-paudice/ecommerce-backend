package com.cp.project_mangashop.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "order_items")
@Data
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idOrderItem;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_order")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_product")
	private Product product;
	
	private int quantity;
	
	@Column(columnDefinition = "Double")
	private BigDecimal price;
	
}
