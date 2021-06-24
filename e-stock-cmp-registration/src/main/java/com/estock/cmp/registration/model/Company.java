package com.estock.cmp.registration.model;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "company")
public class Company {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "cmpName")
	private String cmpName;
	
	@Column(name = "cmpCeo")
	private String cmpCeo;
	
	@Column(name = "cmpTurnover")
	private BigInteger cmpTurnover;
	
	@Column(name = "stockExchange")
	private String stockExchange;
	
	@Column(name = "cmpWebsite")
	private String cmpWebsite;
	
	public Company() {}
	
	public Company(Integer id, String cmpName, String cmpCeo, BigInteger cmpTurnover, String stockExchange,
			String cmpWebsite) {
		super();
		this.id = id;
		this.cmpName = cmpName;
		this.cmpCeo = cmpCeo;
		this.cmpTurnover = cmpTurnover;
		this.stockExchange = stockExchange;
		this.cmpWebsite = cmpWebsite;
	}
	public Integer getCmpId() {
		return id;
	}
	public void setCmpId(Integer id) {
		this.id = id;
	}
	public String getCmpName() {
		return cmpName;
	}
	public void setCmpName(String cmpName) {
		this.cmpName = cmpName;
	}
	public String getCmpCeo() {
		return cmpCeo;
	}
	public void setCmpCeo(String cmpCeo) {
		this.cmpCeo = cmpCeo;
	}
	public BigInteger getCmpTurnover() {
		return cmpTurnover;
	}
	public void setCmpTurnover(BigInteger cmpTurnover) {
		this.cmpTurnover = cmpTurnover;
	}
	public String getStockExchange() {
		return stockExchange;
	}
	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}
	public String getCmpWebsite() {
		return cmpWebsite;
	}
	public void setCmpWebsite(String cmpWebsite) {
		this.cmpWebsite = cmpWebsite;
	}
	@Override
	public String toString() {
		return "Company [cmpId=" + id + ", cmpName=" + cmpName + ", cmpCeo=" + cmpCeo + ", cmpTurnover="
				+ cmpTurnover + ", stockExchange=" + stockExchange + ", cmpWebsite=" + cmpWebsite + "]";
	}
	
	
	

}
