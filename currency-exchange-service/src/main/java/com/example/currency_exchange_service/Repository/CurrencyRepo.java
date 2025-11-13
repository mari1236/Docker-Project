package com.example.currency_exchange_service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.currency_exchange_service.bean.Currency;

public interface CurrencyRepo extends JpaRepository<Currency, Integer>{
	
	Currency findByFromAndTo(String from,String to);
	
	

}
