package com.cp.project_mangashop.dto.order;

import java.util.List;

import com.cp.project_mangashop.dto.orderItem.OrderItemCreateDTO;
import com.cp.project_mangashop.dto.orderItem.OrderItemDTO;
import com.cp.project_mangashop.dto.orderItem.OrderItemDTOMapper;
import com.cp.project_mangashop.dto.user.UserDTOMapper;
import com.cp.project_mangashop.entity.Order;
import com.cp.project_mangashop.entity.User;

public class OrderDTOMapper {

	public static OrderDTO orderToDTO(Order order, User user) {
		OrderDTO dto = new OrderDTO();
		
		dto.setOrderId(order.getOrderId());
		dto.setUser(UserDTOMapper.UserToDTO(user));
		dto.setOrderDate(order.getOrderDate());
		dto.setTotalPrice(order.getTotalPrice());
		dto.setStatus(order.getStatus());
		
		return dto;
		
	}
	
	public static OrderDTO orderToDTO(Order order) {
		OrderDTO dto = new OrderDTO();
		
		dto.setOrderId(order.getOrderId());
		dto.setOrderDate(order.getOrderDate());
		dto.setTotalPrice(order.getTotalPrice());
		dto.setUser(UserDTOMapper.UserToDTO(order.getUser()));
		dto.setOrderItemsId(order.getOrderItems().stream()
				.map(orderItem -> OrderItemDTOMapper.orderItemToDTO(orderItem))
				.toList());
		dto.setStatus(order.getStatus());
		
		return dto;
		
	}
	
	public static OrderCreateDTO orderToDTOCreate(Order order, User user) {
		OrderCreateDTO dto = new OrderCreateDTO();
		
		dto.setOrderId(order.getOrderId());
		dto.setUserId(order.getUser().getUserId());
		dto.setOrderDate(order.getOrderDate());
		dto.setStatus(order.getStatus());
		
		return dto;
		
	}

	public static Order DTOtoOrder(OrderDTO orderDTO) {
		Order order = new Order();
		
		order.setOrderId(orderDTO.getOrderId());
		order.setOrderDate(orderDTO.getOrderDate());
		order.setUser(UserDTOMapper.DTOToUser(orderDTO.getUser()));
		order.setTotalPrice(orderDTO.getTotalPrice());
		order.setOrderItems(orderDTO.getOrderItemsId()
				.stream()
				.map(orderItem -> OrderItemDTOMapper.DTOToOrderItem(orderItem))
				.toList());
		order.setStatus(orderDTO.getStatus());
		
		return order;
		
	}
	
	public static Order DTOToOrder(OrderCreateDTO dto) {
		Order order = new Order();
		
		order.setOrderId(dto.getOrderId());
		order.setOrderDate(dto.getOrderDate());
		order.setStatus(dto.getStatus());
		
		return order;
	}
	
	public static OrderCreateDTO orderToDTOCreate(Order order) {
		OrderCreateDTO dto = new OrderCreateDTO();
		
		dto.setOrderId(order.getOrderId());
		dto.setUserId(order.getUser().getUserId());
		dto.setOrderId(order.getUser().getUserId());
		dto.setOrderDate(order.getOrderDate());
		dto.setStatus(order.getStatus());
		
		return dto;
		
	}
	
//	public static Order DTOCreateToOrder(OrderCreateDTO dto, User user, List<OrderItemCreateDTO> orderItems) {
//		Order order = new Order();
//		
//		order.setOrderId(dto.getOrderId());
//		order.setUser(user);
//		order.setOrderDate(dto.getOrderDate());
//		order.setOrderItems(orderItems.stream()
//				.map(orderItem -> OrderItemDTOMapper.DTOToOrderItem(orderItem))
//				.toList());
//		
//		return order;
//	}
}
