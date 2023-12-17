package com.spring.preparation.orderservice.business;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.spring.preparation.orderservice.dto.OrderServiceDTO;
import com.spring.preparation.orderservice.model.PaymentResponse;
import com.spring.preparation.orderservice.model.TransactionRequest;
import com.spring.preparation.orderservice.model.TransactionResponse;
import com.spring.preparation.orderservice.vo.OrderServiceRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderServiceBusiness {

	@Autowired
	OrderServiceRepository orderRepo;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	TransactionRequest transactionRequest;


	public TransactionResponse placeOrder(OrderServiceDTO orderDetails) {
		String tranactionId = UUID.randomUUID().toString();
		try {
			transactionRequest.setPrice(orderDetails.getPrice());
			
			PaymentResponse paymentResponse = restTemplate.postForObject("http://PAYMENT-SERVICE/api/makePayment", transactionRequest, PaymentResponse.class);
			if ("Payment Success".equals(paymentResponse.getPaymentStatus())) {
				orderDetails.setTransactionId(paymentResponse.getTransactionId());
				orderRepo.save(orderDetails);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new TransactionResponse(orderDetails.getOrderId(), orderDetails.getTransactionId(),
				"Order Placed Successfully");
	}

}