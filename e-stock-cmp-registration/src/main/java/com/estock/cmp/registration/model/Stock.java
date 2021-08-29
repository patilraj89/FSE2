package com.estock.cmp.registration.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stock")
public class Stock {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "cmpCode")
	private String cmpCode;
	
	@Column(name = "stockPrice")
	private float stockPrice;
	
	@Column(name = "tDate")
	private String tDate;
	
	@Column(name = "time")
	private String time;
	
	public Stock() {}
	
	
	

	public Stock(Integer id, String cmpCode, float stockPrice, String tDate, String time) {
		super();
		this.id = id;
		this.cmpCode = cmpCode;
		this.stockPrice = stockPrice;
		this.tDate = tDate;
		this.time = time;
	}




	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	
	

}
