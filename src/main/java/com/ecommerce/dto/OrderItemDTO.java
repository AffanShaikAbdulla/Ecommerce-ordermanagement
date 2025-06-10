package com.ecommerce.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemDTO {
	@NotNull(message = "Product Id is required")
	private Long productId;
	@NotNull(message = "Qunatity must be least 1")
	private Integer quantity;
	@Positive(message = "Price must be positive")
	private Double price;

}
