package com.spring.preparation.orderservice.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse {
	
	private int orderId;
	
	private String transactionId;
	
	private String orderStatus;

}
