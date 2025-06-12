package com.ecommerce.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.dto.OrderRequestDTO;
import com.ecommerce.dto.OrderResponseDTO;
import com.ecommerce.dto.StatusUpdaeDTO;
import com.ecommerce.service.IOrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	private final IOrderService orderService;

	public OrderController(IOrderService orderService) {
		super();
		this.orderService = orderService;
	}

	@PostMapping
	public ResponseEntity<OrderResponseDTO> placeOrder(@Valid @RequestBody OrderRequestDTO orderRequest) {
		OrderResponseDTO response = orderService.placeOrder(orderRequest);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);

	}

	@PatchMapping("/{orderId}/status")
	public ResponseEntity<OrderResponseDTO> updateOrderStatus(@PathVariable Long orderId,
			@Valid @RequestBody StatusUpdaeDTO statusUpdate) {
		OrderResponseDTO response = orderService.updateOrderStatus(orderId, statusUpdate);

		return ResponseEntity.ok(response);
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<List<OrderResponseDTO>> getOrdersByUser(@PathVariable Long userId) {
	    List<OrderResponseDTO> orders = orderService.getOrderByUser(userId);
	    return ResponseEntity.ok(orders);
	}


}
