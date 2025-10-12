package com.cp.project_mangashop.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cp.project_mangashop.dto.order.OrderCreateDTO;
import com.cp.project_mangashop.dto.order.OrderDTO;
import com.cp.project_mangashop.dto.order.OrderDTOMapper;
import com.cp.project_mangashop.dto.order.OrderUpdateDTO;
import com.cp.project_mangashop.dto.orderItem.OrderItemCreateDTO;
import com.cp.project_mangashop.dto.orderItem.OrderItemDTO;
import com.cp.project_mangashop.dto.orderItem.OrderItemDTOMapper;
import com.cp.project_mangashop.dto.product.ProductDTO;
import com.cp.project_mangashop.dto.product.ProductDTOMapper;
import com.cp.project_mangashop.dto.user.UserDTO;
import com.cp.project_mangashop.dto.user.UserDTOMapper;
import com.cp.project_mangashop.entity.Order;
import com.cp.project_mangashop.entity.OrderItem;
import com.cp.project_mangashop.entity.Product;
import com.cp.project_mangashop.entity.User;
import com.cp.project_mangashop.repository.OrderRepository;
import com.cp.project_mangashop.service.interfaces.OrderItemService;
import com.cp.project_mangashop.service.interfaces.OrderService;
import com.cp.project_mangashop.service.interfaces.ProductService;
import com.cp.project_mangashop.service.interfaces.UserService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	UserService userService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	OrderItemService orderItemService;
	
	@Override
	public List<OrderDTO> getAll() {
		List<Order> orders = orderRepo.findAll();
		List<OrderDTO> ordersDTO = orders.stream()
				.map(order -> OrderDTOMapper.orderToDTO(order))
				.toList();
		
		return ordersDTO;
	
	}

	@Override
	public Order getOrderById(int orderId) {
		Optional<Order> order = orderRepo.findById(orderId);
		
		if(order.isEmpty()) {
			return null;
		}
		
		return order.get();
		
	}

	@Override
	public Order insertOrder(OrderCreateDTO orderCreateDTO) {
		User user = userService.getUser(orderCreateDTO.getUserId());
		
		Order order = new Order();
		order.setOrderDate(LocalDate.now());
		order.setUser(user);
		BigDecimal totalPrice = BigDecimal.ZERO;
		List<OrderItem> items = new ArrayList<>();
		
		for (OrderItemCreateDTO itemDTO : orderCreateDTO.getOrderItems()) {
			Product product = productService.getProductById(itemDTO.getProductId());
			
			BigDecimal itemPrice = BigDecimal.valueOf(product.getPrice())
					.multiply(BigDecimal.valueOf(itemDTO.getQuantity()))
	                .setScale(2, RoundingMode.HALF_UP);
			
			OrderItem orderItem = new OrderItem();
			orderItem.setOrder(order);
			orderItem.setProduct(product);
			orderItem.setQuantity(itemDTO.getQuantity());
			orderItem.setPrice(itemPrice);
			
			totalPrice = totalPrice.add(orderItem.getPrice());
			items.add(orderItem);
			
		}
		
		
		order.setOrderItems(items);
		order.setTotalPrice(totalPrice.setScale(2, RoundingMode.HALF_UP));
		orderRepo.save(order);
		
		return order;
		
	}

	@Override
	public Order updateOrder(int orderId, OrderUpdateDTO orderUpdate) {
		Order existing = getOrderById(orderId);
		User user;
		if(existing == null) {
			throw new RuntimeException("Ordine non trovato.");
		}
		
		if(existing.getUser().getUserId() != orderUpdate.getUserId()) {
			user = userService.getUser(orderUpdate.getUserId());
			existing.setUser(user);
		}
		
		BigDecimal totalPrice = BigDecimal.ZERO;
		List<OrderItem> updatedItems = new ArrayList<>();
		
		for (OrderItemCreateDTO itemDTO : orderUpdate.getOrderItems()) {
			Product productDTO = productService.getProductById(itemDTO.getProductId());
			if(productDTO == null) {
				throw new RuntimeException("Prodotto non trovato");
			}
			
			OrderItem orderItem = new OrderItem();
			
			orderItem.setIdOrderItem(itemDTO.getId());
			orderItem.setOrder(existing);
			orderItem.setOrder((existing));
			orderItem.setProduct((productDTO));
			orderItem.setQuantity(itemDTO.getQuantity());
			orderItem.setPrice(BigDecimal.valueOf(orderItem.getProduct().getPrice())
					.setScale(2, RoundingMode.HALF_UP));
			
			totalPrice = totalPrice.add(orderItem.getPrice());
			updatedItems.add(orderItem);
			
		}
		
		existing.setOrderDate(LocalDate.now());
		existing.setOrderItems(updatedItems);
		
		orderRepo.save(existing);
		
		return existing;
	}

	@Override
	public void deleteOrder(int orderId) {
		orderRepo.deleteById(orderId);
		
	}

}
