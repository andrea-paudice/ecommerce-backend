package com.cp.project_mangashop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cp.project_mangashop.dto.orderItem.OrderItemDTO;
import com.cp.project_mangashop.dto.orderItem.OrderItemDTOMapper;
import com.cp.project_mangashop.entity.OrderItem;
import com.cp.project_mangashop.repository.OrderItemRepository;
import com.cp.project_mangashop.service.interfaces.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService{

	 @Autowired
	 OrderItemRepository orderItemRepo;
	
	@Override
	public List<OrderItemDTO> getAll() {
		List<OrderItem> orderItems = orderItemRepo.findAll();
		List<OrderItemDTO> orderItemsDTO = orderItems.stream()
				.map(orderItem -> OrderItemDTOMapper.orderItemToDTO(orderItem))
				.toList();
		
		return orderItemsDTO;
		
	}

	@Override
	public OrderItemDTO getById(int idOrderItem) {
		OrderItem orderItem = orderItemRepo.findById(idOrderItem)
				.orElseThrow(() -> new RuntimeException("OrderItem non trovato."));
		
		OrderItemDTO orderItemDTO = OrderItemDTOMapper.orderItemToDTO(orderItem);
		
		return orderItemDTO;
		
	}

	@Override
	public void insertOrderItem(OrderItem orderItem) {
		orderItemRepo.save(orderItem);
	}

	@Override
	public OrderItemDTO updateOrderItem(OrderItem orderItem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteOrderItem(int idOrderItem) {
		// TODO Auto-generated method stub
		
	}

}
