package com.cp.project_mangashop.dto.orderItem;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.cp.project_mangashop.dto.order.OrderDTO;
import com.cp.project_mangashop.dto.product.ProductDTO;
import com.cp.project_mangashop.entity.CartItem;
import com.cp.project_mangashop.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
public class OrderItemDTO {

	private int idOrderItem;
	@JsonIgnore
	private OrderDTO order;
	
	private ProductDTO product;
	private int quantity;
	private BigDecimal price;
	
}
