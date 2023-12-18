package com.spring.preparation.orderservice.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LoggingController {
	
//	Logger log = LoggerFactory.getLogger(getClass());
	
	
	@Before(value = "execution(* com.spring.preparation.orderservice.controller.OrderServiceController.*(..))")
	public void beforeLogging(JoinPoint joinPoint) {
		log.debug(joinPoint.getSignature() + " method executing");
		log.info("method called");
		
	}

}
