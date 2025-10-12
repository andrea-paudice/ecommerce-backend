package com.cp.project_mangashop.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cp.project_mangashop.dto.order.OrderDTO;
import com.cp.project_mangashop.dto.order.OrderCreateDTO;
import com.cp.project_mangashop.dto.order.OrderDTOMapper;
import com.cp.project_mangashop.dto.order.OrderUpdateDTO;
import com.cp.project_mangashop.dto.orderItem.OrderItemCreateDTO;
import com.cp.project_mangashop.dto.orderItem.OrderItemDTO;
import com.cp.project_mangashop.entity.Order;
import com.cp.project_mangashop.entity.User;
import com.cp.project_mangashop.service.interfaces.OrderItemService;
import com.cp.project_mangashop.service.interfaces.OrderService;
import com.cp.project_mangashop.service.interfaces.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	OrderItemService orderItemService;
	
	// API ADMIN
	
	@GetMapping(path = "/admin/order/all")
	public ResponseEntity<?> getAll() {
		List<OrderDTO> ordersDTO = orderService.getAll();
		
		if(ordersDTO.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(ordersDTO, HttpStatus.OK);		
	}
	
	@GetMapping(path = "/admin/order/{orderId}")
	public ResponseEntity<?> getOrder(@PathVariable int orderId) {
		Order order = orderService.getOrderById(orderId);
		OrderDTO orderDTO = OrderDTOMapper.orderToDTO(order);
		
		return new ResponseEntity<>(orderDTO, HttpStatus.OK);		
	}
	
	@PutMapping(path = "/admin/order/update/{orderId}")
	public ResponseEntity<?> updateOrder(@PathVariable int orderId, @Valid @RequestBody OrderUpdateDTO orderDTOUpdate) {
		
		Order savedOrder = orderService.updateOrder(orderId, orderDTOUpdate);
		OrderDTO savedOrderDTO = OrderDTOMapper.orderToDTO(savedOrder);
		
		return new ResponseEntity<>(savedOrderDTO, HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/admin/order/delete/{orderId}")
	public ResponseEntity<?> deleteOrder(@PathVariable int orderId) {
		Order existing = orderService.getOrderById(orderId);
		orderService.deleteOrder(existing.getOrderId());
		
		return new ResponseEntity<>("Ordine eliminato", HttpStatus.OK);
		
	}
	
	// API USER
	
	@PostMapping(path = "/user/order/add")
	public ResponseEntity<?> addOrder(@Valid @RequestBody OrderCreateDTO orderDTOCreate) {
		Order order = orderService.insertOrder(orderDTOCreate);
		OrderDTO orderDTO = OrderDTOMapper.orderToDTO(order);
		
		return new ResponseEntity<>(orderDTO, HttpStatus.OK);
		
	}
	
	@GetMapping(path = "/user/order/myorders")
	public ResponseEntity<?> getMyOrders(Principal principal) {
		User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("Utente non trovato."));
		List<OrderDTO> orders = orderService.getOrderByUser(user);
		
		return new ResponseEntity<>(orders, HttpStatus.OK);
	}
	
}
