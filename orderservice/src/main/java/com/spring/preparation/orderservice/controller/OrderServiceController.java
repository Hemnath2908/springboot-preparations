package com.spring.preparation.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.preparation.orderservice.business.OrderServiceBusiness;
import com.spring.preparation.orderservice.dto.OrderServiceDTO;
import com.spring.preparation.orderservice.model.TransactionResponse;

@RestController
@RequestMapping("/order")
public class OrderServiceController {
	
	@Autowired
	OrderServiceBusiness orderService;
	
	@PostMapping("/placeOrder")
	public TransactionResponse placeOrder(@RequestBody OrderServiceDTO orderDetails) {
		TransactionResponse response = orderService.placeOrder(orderDetails);
		return response;
	}

}
