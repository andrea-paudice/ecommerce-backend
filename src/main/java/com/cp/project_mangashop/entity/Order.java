package com.cp.project_mangashop.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "orders")
@Data
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_order")
	private int orderId;
	
	@ManyToOne
	@JoinColumn(name = "fk_user_id")
	private User user;
	
	@Column(name = "order_date")
	private LocalDate orderDate;
	
	@Column(name = "total_price", columnDefinition = "Double")
	private BigDecimal totalPrice;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderItem> orderItems;
	
}
