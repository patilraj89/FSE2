package com.estock.registration.pojo;

import java.time.LocalDate;

public class CmpStock {
	
	private int cmpId;
	private int stockPrice;
	private LocalDate date;
	public CmpStock(int cmpId, int stockPrice, LocalDate date) {
		super();
		this.cmpId = cmpId;
		this.stockPrice = stockPrice;
		this.date = date;
	}
	public int getCmpId() {
		return cmpId;
	}
	public void setCmpId(int cmpId) {
		this.cmpId = cmpId;
	}
	public int getStockPrice() {
		return stockPrice;
	}
	public void setStockPrice(int stockPrice) {
		this.stockPrice = stockPrice;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	

}
