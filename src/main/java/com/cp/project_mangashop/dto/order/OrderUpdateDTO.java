package com.cp.project_mangashop.dto.order;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.cp.project_mangashop.dto.orderItem.OrderItemCreateDTO;
import com.cp.project_mangashop.entity.CartItem;
import com.cp.project_mangashop.entity.User;
import com.cp.project_mangashop.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
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
