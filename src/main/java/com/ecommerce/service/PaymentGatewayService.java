package com.ecommerce.service;

import org.springframework.stereotype.Service;

import com.ecommerce.entity.PaymentMethod;

@Service
public class PaymentGatewayService {
	public boolean validatePayement(PaymentMethod paymentMethod) {
		return true;
	}
}
