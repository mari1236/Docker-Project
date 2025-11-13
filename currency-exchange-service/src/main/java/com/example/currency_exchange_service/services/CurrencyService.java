package com.example.currency_exchange_service.services;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.currency_exchange_service.Repository.CurrencyRepo;
import com.example.currency_exchange_service.bean.Currency;


@Service
public class CurrencyService {
	
	private final CurrencyRepo currencyRepo;
	
	public CurrencyService(CurrencyRepo repo) {
		this.currencyRepo=repo;
	}
	
	public List<Currency> getAllCurrencyRecord() {
		return this.currencyRepo.findAll();
		
	}
	
	public Currency FromToCurreny(String from,String to) {
		return this.currencyRepo.findByFromAndTo(from, to);
	}
	
	


}
