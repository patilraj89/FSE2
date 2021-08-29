package com.estock.document;

import java.sql.Time;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Stock {
	
	private String cmpCode;
	private float stockPrice;
	private String tDate;
	private String time;
	
	
	
	public String gettDate() {
		return tDate;
	}
	public void settDate(String tDate) {
		this.tDate = tDate;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
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
