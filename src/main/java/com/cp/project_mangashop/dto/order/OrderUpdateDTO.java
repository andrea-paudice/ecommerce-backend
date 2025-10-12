package com.cp.project_mangashop.dto.order;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.cp.project_mangashop.dto.orderItem.OrderItemCreateDTO;
import com.cp.project_mangashop.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class OrderUpdateDTO {

	private int orderId;
	private int userId;
	private LocalDate orderDate;
	@Positive(message = "Il prezzo deve essere positivo")
	private BigDecimal totalPrice;
	private List<OrderItemCreateDTO> orderItems;
	@JsonProperty("status")
	private OrderStatus status;
	
}
