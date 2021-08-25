package com.estock.document;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Stock {
	
	private String cmpCode;
	private float stockPrice;
	private String tDate;	
	
	public String getCmpCode() {
		return cmpCode;
	}
	public void setCmpCode(String cmpCode) {
		this.cmpCode = cmpCode;
	}
	public float getStockPrice() {
		return stockPrice;
	}
	public void setStockPrice(float stockPrice) {
		this.stockPrice = stockPrice;
	}
	public String getDate() {
		return tDate;
	}
	public void setDate(String tDate) {
		this.tDate = tDate;
	}
	@Override
	public String toString() {
		return "Stock [cmpCode=" + cmpCode + ", stockPrice=" + stockPrice + ", date=" + tDate + "]";
	}
	
	
	
	
	
	
	
	

}
