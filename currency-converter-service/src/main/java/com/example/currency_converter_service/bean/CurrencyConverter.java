package com.example.currency_converter_service.bean;

import java.math.BigDecimal;

public class CurrencyConverter {

	private int id;
	private String from;
	private String to;
	private BigDecimal conversionMultiple;
	private int quantity;
	private BigDecimal totalCalculatedAmount;
	private String enviromentPort;
	
	
	public CurrencyConverter() {
		super();
	}
	public CurrencyConverter(int id, String from, String to, BigDecimal conversionMultiple, int quantity,
			BigDecimal totalCalculatedAmount, String enviromentPort) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.quantity = quantity;
		this.totalCalculatedAmount = totalCalculatedAmount;
		this.enviromentPort = enviromentPort;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}
	public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}
	public String getEnviromentPort() {
		return enviromentPort;
	}
	public void setEnviromentPort(String enviromentPort) {
		this.enviromentPort = enviromentPort;
	}
	
	
}
