package com.ss871104.microservices.currencyexchangeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ss871104.microservices.currencyexchangeservice.bean.CurrencyExchange;
import com.ss871104.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private CurrencyExchangeRepository repository;

	@Autowired
	private Environment environment;

	// http://localhost:8000/currency-exchange/from/USD/to/NTD
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {

		CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);
		
		if (currencyExchange == null) {
			throw new RuntimeException("Unable to find data for " + from + " to " + to);
		}

		String port = environment.getProperty("local.server.port");
		
		currencyExchange.setEnvironment(port);

		return currencyExchange;

	}

}
