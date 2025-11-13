package com.example.currency_exchange_service.controller;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.currency_exchange_service.bean.Currency;
import com.example.currency_exchange_service.services.CurrencyService;

@RestController
public class CurrencyController {
	
	@Autowired
	private Environment env;
	@Autowired
	private CurrencyService currencyService;
	
	private Logger logger = LoggerFactory.getLogger(CurrencyController.class);
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	
	public Currency currencyConverter(@PathVariable String from,@PathVariable String to) {
		
		logger.info("Msg value {} to {}",from,to);
		String port = env.getProperty("server.port");
		System.out.println("How Working");
		
		 Currency currency=currencyService.FromToCurreny(from, to);
		 currency.setEnviromentPort(port);
		 return currency;
	}
	
	@GetMapping("/getAllCurrency")
	public List<Currency> getAllRecord() {
		return currencyService.getAllCurrencyRecord();
	}

	
}
