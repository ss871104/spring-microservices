package com.ss871104.microservices.currencyexchangeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {
	
	private Logger logger = 
				LoggerFactory.getLogger(CircuitBreakerController.class);
	
	@GetMapping("/sample-api")
	@Retry(name = "sample-api", fallbackMethod = "hardcodedResponse")
	//@CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
	//@RateLimiter(name="default")
//	@Bulkhead(name="sample-api")
	public String sampleApi() {
		logger.info("Sample api call received");

		return "sample-api";
	}
	
	public String hardcodedResponse(Exception ex) {
		return "fallback-response";
	}
}
