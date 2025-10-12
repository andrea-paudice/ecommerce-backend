package com.cp.project_mangashop.dto.orderItem;

import com.cp.project_mangashop.dto.order.OrderDTOMapper;
import com.cp.project_mangashop.dto.product.ProductDTOMapper;
import com.cp.project_mangashop.entity.OrderItem;

public class OrderItemDTOMapper {

	public static OrderItemDTO orderItemToDTO(OrderItem orderItem) {
		OrderItemDTO orderItemDTO = new OrderItemDTO();
		
		orderItemDTO.setIdOrderItem(orderItem.getIdOrderItem());
		//orderItemDTO.setOrder(OrderDTOMapper.orderToDTO(orderItem.getOrder()));
		orderItemDTO.setProduct(ProductDTOMapper.productToDTO(orderItem.getProduct()));
		orderItemDTO.setQuantity(orderItem.getQuantity());
		orderItemDTO.setPrice(orderItem.getPrice());
		
		return orderItemDTO;
		
	}
	
	public static OrderItem DTOToOrderItem(OrderItemDTO orderItemDTO) {
		OrderItem orderItem = new OrderItem();
		
		orderItem.setIdOrderItem(orderItemDTO.getIdOrderItem());
		orderItem.setProduct(ProductDTOMapper.DTOtoProduct(orderItemDTO.getProduct()));
		orderItem.setQuantity(orderItemDTO.getQuantity());
		orderItem.setPrice(orderItemDTO.getPrice());
		
		return orderItem;
		
	}
	
//	public static OrderItem DTOToOrderItem(OrderItemCreateDTO orderItemDTO) {
//		OrderItem orderItem = new OrderItem();
//		
//		orderItem.setProduct(orderItemDTO.getProductId());
//		orderItem.setQuantity(orderItemDTO.getQuantity());
//		
//		return orderItem;
//		
//	}
	
}
