package com.cp.project_mangashop.service.interfaces;

import java.util.List;

import com.cp.project_mangashop.dto.orderItem.OrderItemDTO;
import com.cp.project_mangashop.entity.OrderItem;

public interface OrderItemService {

	public List<OrderItemDTO> getAll();
	public OrderItemDTO getById(int idOrderItem);
	public void insertOrderItem(OrderItem orderItem);
	public OrderItemDTO updateOrderItem(OrderItem orderItem);
	public void deleteOrderItem(int idOrderItem);
	
}
