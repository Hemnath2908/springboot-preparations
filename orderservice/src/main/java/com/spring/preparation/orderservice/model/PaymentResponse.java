package com.spring.preparation.orderservice.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponse {
	
	private String transactionId;
	
	private String paymentStatus;

}
