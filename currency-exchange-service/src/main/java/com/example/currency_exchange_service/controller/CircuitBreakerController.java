package com.example.currency_exchange_service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {
	
	Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
	
	@GetMapping("/sample")
	@Retry(name = "default", fallbackMethod="defaultMethod")
	public String sampleApi() {
		logger.info("It call for retry");
	   ResponseEntity<String> res =new RestTemplate().getForEntity("http://localhost:2020/getMaria", String.class);
		return res.getBody();
	}
	
	public String defaultMethod(Exception e) {
		logger.info("My Retry Exception");
		return "Retry Concept has understood";
	}
	
	@GetMapping("/circuitSample")
	@CircuitBreaker(name = "circuit", fallbackMethod="circuitMethod")
	public String circuitSampleApi() {
		logger.info("It call for circuit breaker");
	   ResponseEntity<String> res =new RestTemplate().getForEntity("http://localhost:2020/getMaria", String.class);
		return res.getBody();
	}
	
	public String circuitMethod(Exception e) {
		logger.info("Circuit Logger call again and again");
		return "Circuit Breaker Concept has understood";
	}
	
//	@GetMapping("/circuitSample")
//	@CircuitBreaker(name = "circuit", fallbackMethod = "fallbackResponse")
//	public String callExternalService() {
//		logger.info("It call for circuit breaker");
//	    throw new RuntimeException("Simulated failure");
//	}
//
//	public String fallbackResponse(Throwable throwable) {
//		logger.info("Fallback triggered after circuit opens!");
//	    return "Fallback response: external service unavailable";
//	}


}
