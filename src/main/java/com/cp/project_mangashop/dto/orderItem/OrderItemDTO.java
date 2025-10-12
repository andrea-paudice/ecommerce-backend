package com.cp.project_mangashop.dto.orderItem;

import java.math.BigDecimal;

import com.cp.project_mangashop.dto.order.OrderDTO;
import com.cp.project_mangashop.dto.product.ProductDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class OrderItemDTO {

	private int idOrderItem;
	@JsonIgnore
	private OrderDTO order;
	
	private ProductDTO product;
	private int quantity;
	private BigDecimal price;
	
}
