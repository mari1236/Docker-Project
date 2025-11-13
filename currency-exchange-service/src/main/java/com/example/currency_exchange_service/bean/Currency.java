package com.example.currency_exchange_service.bean;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Currency {

	@Id
	private int id;
	@Column(name = "currency_from")
	private String from;
	@Column(name = "currency_to")
	private String to;
	@Column(name = "conversion_multiple")
	private BigDecimal conversionMultiple;
	@Column(name = "enviroment_port")
	private String enviromentPort;

	public Currency() {
		super();
	}

	public Currency(int id, String from, String to, BigDecimal conversionMultiple, String enviromentPort) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
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

	public String getEnviromentPort() {
		return enviromentPort;
	}

	public void setEnviromentPort(String enviromentPort) {
		this.enviromentPort = enviromentPort;
	}
	

}
