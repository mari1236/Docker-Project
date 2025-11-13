package com.example.currency_converter_service.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import javax.xml.xpath.XPathFunctionResolver;

import org.bouncycastle.jcajce.provider.digest.GOST3411.HashMac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.currency_converter_service.Config.FeignConfig;
import com.example.currency_converter_service.Config.RestTemplateConfig;
import com.example.currency_converter_service.bean.CurrencyConverter;

@RestController
@RequestMapping("/currency-conversion")
public class CurrencyConverterController {
	
	@Autowired
	private FeignConfig feignConfig;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	Environment env;

	@GetMapping("/from/{from}/to/{to}/quantity/{quantity}")

	public CurrencyConverter convertCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable int quantity) {

		
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("from", from);
		hashMap.put("to", to);
		ResponseEntity<CurrencyConverter> response = restTemplate.getForEntity(
				"http://localhost:1020/currency-exchange/from/{from}/to/{to}", CurrencyConverter.class, hashMap);
		CurrencyConverter converter = response.getBody();
		return new CurrencyConverter(converter.getId(), from, to, converter.getConversionMultiple(), quantity,
				converter.getConversionMultiple().multiply(BigDecimal.valueOf(quantity)), converter.getEnviromentPort());

	}

	@GetMapping("/feign/from/{from}/to/{to}/quantity/{quantity}")

	public CurrencyConverter convertCurrencyFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable int quantity) {
		
		

		String port = env.getProperty("server.port");
		CurrencyConverter converter = feignConfig.currencyConverter(from, to);
		
		return new CurrencyConverter(converter.getId(), from, to, converter.getConversionMultiple(), quantity,
				converter.getConversionMultiple().multiply(BigDecimal.valueOf(quantity)), converter.getEnviromentPort());

	}

}
