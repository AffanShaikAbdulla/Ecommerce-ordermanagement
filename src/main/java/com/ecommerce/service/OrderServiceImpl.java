package com.ecommerce.service;

import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.stereotype.Service;

import com.ecommerce.dto.OrderRequestDTO;
import com.ecommerce.dto.OrderResponseDTO;
import com.ecommerce.dto.StatusUpdaeDTO;
import com.ecommerce.entity.Order;
import com.ecommerce.entity.OrderItem;
import com.ecommerce.entity.OrderStatus;
import com.ecommerce.exception.PaymentValidationException;
import com.ecommerce.repository.OrderRepository;
import com.ecommerce.util.ModelMapperUtil;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements IOrderService {
	private final OrderRepository orderRepository;
	private final PaymentGatewayService paymentService;
	private final ModelMapperUtil modelMapper;

	
	@Override
	@Transactional
	public OrderResponseDTO placeOrder(OrderRequestDTO orderRequest) {  // Correct parameter type
	    if (!paymentService.validatePayement(orderRequest.getPaymentMethod())) {
	        throw new PaymentValidationException("Payment method validation failed");
	    }

	    Double totalAmount = caluclateTotalAmount(orderRequest);
	    Order order = buildOrder(orderRequest, totalAmount);
	    addOrderItems(orderRequest, order);
	    
	    Order savedOrder = orderRepository.save(order);
	    return modelMapper.map(savedOrder, OrderResponseDTO.class);
	}

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

	// calucalte total amount
	private Double caluclateTotalAmount(OrderRequestDTO orderRequest) {
		return orderRequest.getItems().stream().mapToDouble(item -> item.getPrice() * item.getQuantity()).sum();

	}

	private Order buildOrder(OrderRequestDTO orderRequest, Double totalAmount) {
		return Order.builder().userId(orderRequest.getUserId()).totalAmount(totalAmount).status(OrderStatus.PENDING)
				.paymentMethod(orderRequest.getPaymentMethod()).build();

	}

	private void addOrderItems(OrderRequestDTO orderRequest, Order order) {
		orderRequest.getItems().forEach(item -> {
			OrderItem orderItem = OrderItem.builder().productId(item.getProductId()).quantity(item.getQuantity())
					.price(item.getPrice()).build();
			order.addItem(orderItem);

		});

	}

}
