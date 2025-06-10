package com.ecommerce.service;

import java.util.List;

import com.ecommerce.dto.OrderRequestDTO;
import com.ecommerce.dto.OrderResponseDTO;
import com.ecommerce.dto.StatusUpdaeDTO;
import com.ecommerce.repository.OrderRepository;
import com.ecommerce.util.ModelMapperUtil;

public class OrderServiceImpl implements IOrderService {
	//private final OrderRepository orderRepository;
	//private final PaymentGatewayService paymentService;
	//private final ModelMapperUtil modelMapper;

	/*
	 * @Override public OrderResponseDTO placeOrder(OrderResponseDTO orderRequest) {
	 * // TODO Auto-generated method stub
	 * if(!paymentService.validatePayement(orderRequest.getPaymentMethod())) { throw
	 * }
	 * 
	 * 
	 * return null; }
	 */

	@Override
	public OrderResponseDTO updateOrderStatus(Long orderId, StatusUpdaeDTO statusupdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderResponseDTO> getOrderByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderResponseDTO> getOrderByUser(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
