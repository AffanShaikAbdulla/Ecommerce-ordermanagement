package com.ecommerce.dto;

import java.util.List;

import com.ecommerce.OrderItem;
import com.ecommerce.PaymentMethod;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequestDTO {
	@NotNull(message = "User Id is required")
	private Long userId;
	@NotNull(message = "Order items cannot be emptys")
	private PaymentMethod paymentMethod;
	private List<OrderItemDTO> items;

}
