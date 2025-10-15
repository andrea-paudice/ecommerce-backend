package com.cp.project_mangashop.dto.order;

import java.time.LocalDate;
import java.util.List;

import com.cp.project_mangashop.dto.orderItem.OrderItemCreateDTO;
import com.cp.project_mangashop.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
public class OrderCreateDTO {

	private int orderId;
	@NotNull(message = "L'utente è obbligatorio")
	private int userId;
	private LocalDate orderDate;
	private List<OrderItemCreateDTO> orderItems;
	@JsonProperty("status")
	private OrderStatus status = OrderStatus.IN_ELABORAZIONE;
}
