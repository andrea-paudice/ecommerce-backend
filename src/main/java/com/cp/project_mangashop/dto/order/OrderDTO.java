package com.cp.project_mangashop.dto.order;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.cp.project_mangashop.dto.orderItem.OrderItemDTO;
import com.cp.project_mangashop.dto.user.UserDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class OrderDTO {

	private int orderId;
	@NotNull(message = "L'utente è obbligatorio")
	private UserDTO user;
	@NotNull(message = "La data dell'ordine è obbligatoria")
	private LocalDate orderDate;
	@Positive(message = "Il prezzo deve essere positivo")
	private BigDecimal totalPrice;
	
	private List<OrderItemDTO> orderItemsId;
	
	
}
