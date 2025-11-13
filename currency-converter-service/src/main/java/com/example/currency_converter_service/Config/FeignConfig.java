package com.example.currency_converter_service.Config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.currency_converter_service.bean.CurrencyConverter;


@FeignClient(name = "currency-exchange-service")
public interface FeignConfig {
	
@GetMapping("/currency-exchange/from/{from}/to/{to}")
	
	public CurrencyConverter currencyConverter(@PathVariable String from,@PathVariable String to);

}
