package com.spring.preparation.payment.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data 
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {

	private int price;
	 
	

	
}
