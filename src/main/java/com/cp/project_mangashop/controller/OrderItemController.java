package com.cp.project_mangashop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cp.project_mangashop.dto.orderItem.OrderItemDTO;
import com.cp.project_mangashop.service.interfaces.OrderItemService;

@RestController
@RequestMapping(path = "/orderItems")
public class OrderItemController {

	@Autowired
	OrderItemService orderItemService;
	
	@GetMapping(path = "/all")
	public ResponseEntity<?> getAll() {
		List<OrderItemDTO> orderItemsDTO = orderItemService.getAll();
		if(orderItemsDTO.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(orderItemsDTO, HttpStatus.NOT_FOUND);
		
	}
	
}
