package com.spring.preparation.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.preparation.payment.business.PaymentServiceBusiness;
import com.spring.preparation.payment.model.PaymentRequest;
import com.spring.preparation.payment.model.PaymentResponse;

@RestController
@RequestMapping("/api")
public class PaymentServiceController {
	
	@Autowired
	PaymentServiceBusiness paymentServiceBusiness;
	
	@PostMapping("/makePayment")
	public PaymentResponse makePayment(@RequestBody PaymentRequest paymenRequest) {
		PaymentResponse response =  paymentServiceBusiness.makePayment(paymenRequest);
		return response;
	}

}
