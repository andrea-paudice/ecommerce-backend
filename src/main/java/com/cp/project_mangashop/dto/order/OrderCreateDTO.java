package com.cp.project_mangashop.dto.order;

import java.time.LocalDate;
import java.util.List;

import com.cp.project_mangashop.dto.orderItem.OrderItemCreateDTO;
import com.cp.project_mangashop.dto.orderItem.OrderItemDTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class OrderCreateDTO {

	private int orderId;
	@NotNull(message = "L'utente è obbligatorio")
	private int userId;
	private LocalDate orderDate;
	
	private List<OrderItemCreateDTO> orderItems;
	
}
