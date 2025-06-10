package com.ecommerce.service;

import java.util.List;

import com.ecommerce.dto.OrderResponseDTO;
import com.ecommerce.dto.StatusUpdaeDTO;

public interface IOrderService {
	//OrderResponseDTO placeOrder(OrderResponseDTO request);

	OrderResponseDTO updateOrderStatus(Long orderId, StatusUpdaeDTO statusupdate);

	List<OrderResponseDTO> getOrderByStatus(String status);

	List<OrderResponseDTO> getOrderByUser(Long userId);
}
