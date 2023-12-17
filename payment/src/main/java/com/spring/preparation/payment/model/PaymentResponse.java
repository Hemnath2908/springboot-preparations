package com.spring.preparation.payment.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResponse {
	
	private String transactionId;
	
	private String paymentStatus;

}
