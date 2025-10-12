package com.cp.project_mangashop.service.interfaces;

import java.util.List;

import com.cp.project_mangashop.dto.order.OrderCreateDTO;
import com.cp.project_mangashop.dto.order.OrderDTO;
import com.cp.project_mangashop.dto.order.OrderUpdateDTO;
import com.cp.project_mangashop.entity.Order;

public interface OrderService {

	public List<OrderDTO> getAll();
	public Order getOrderById(int orderId);
	public Order insertOrder(OrderCreateDTO order);
	public Order updateOrder(int orderId, OrderUpdateDTO order);
	public void deleteOrder(int orderId);
	
}
