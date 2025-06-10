package com.ecommerce.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.ecommerce.OrderStatus;
import com.ecommerce.PaymentMethod;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponseDTO {
	private Long id;
	private Long userId;
	private Double totalAmount;
	private OrderStatus status;
	private PaymentMethod paymentMethod;
	private LocalDateTime createdAt;
	private LocalDateTime upatedAt;
	private List<OrderItemDTO> items;

}
