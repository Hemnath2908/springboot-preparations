package com.spring.preparation.payment.business;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.preparation.payment.dto.PaymentDTO;
import com.spring.preparation.payment.model.PaymentRequest;
import com.spring.preparation.payment.model.PaymentResponse;
import com.spring.preparation.payment.vo.PaymentRepository;

@Service
public class PaymentServiceBusiness {
	
	@Autowired
	PaymentRepository paymentRepository;
	
	@Autowired
	PaymentDTO payment;
	
	public PaymentResponse makePayment(PaymentRequest paymentRequest) {
		payment.setPrice(paymentRequest.getPrice());
		payment.setPaymentStatus(callUPIServices());
		
		paymentRepository.save(payment);
		
		return new PaymentResponse(payment.getPaymentGuid(), payment.getPaymentStatus());
	}
	
	public String callUPIServices() {
		//It will generate true or false randomly
		Random random = new Random();
		String paymentStatus = random.nextBoolean()? "Payment Success" : "Payment Failed" ;
		return paymentStatus;
	}

}