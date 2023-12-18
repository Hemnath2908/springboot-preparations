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

import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderServiceBusiness {

	@Autowired
	OrderServiceRepository orderRepo;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	TransactionRequest transactionRequest;

	@Retry(name = "orderService", fallbackMethod = "retryIfServerDown")
	public TransactionResponse placeOrder(OrderServiceDTO orderDetails) {
		String tranactionId = UUID.randomUUID().toString();
		String orderStatus = "";
		try {
			transactionRequest.setPrice(orderDetails.getPrice());

			log.info("Trying to connect Multiple times");

			PaymentResponse paymentResponse = restTemplate.postForObject("http://PAYMENT-SERVICE/api/makePayment",
					transactionRequest, PaymentResponse.class);
			orderStatus = paymentResponse.getPaymentStatus().equals("Payment Success") ? "Order Placed Successfully"
					: "Payment Failed Please try again later !!!";
			if ("Payment Success".equals(paymentResponse.getPaymentStatus())) {
				orderDetails.setTransactionId(paymentResponse.getTransactionId());
				orderDetails.setStatus(paymentResponse.getPaymentStatus());
				orderRepo.save(orderDetails);
			}
		} catch (Exception e) {
			throw e; 
		}
		return new TransactionResponse(orderDetails.getOrderId(), orderDetails.getTransactionId(), orderStatus);
	}

	public TransactionResponse retryIfServerDown(Exception e) {
		return new TransactionResponse(0, null, "Payment Failed due to server issue");

	}

}
