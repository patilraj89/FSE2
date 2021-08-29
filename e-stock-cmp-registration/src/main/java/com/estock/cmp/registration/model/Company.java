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
	private String comapnyName;
	
	@Column(name = "cmpCeo")
	private String comapnyCEO;
	
	@Column(name = "cmpTurnover")
	private BigInteger companyTurnover;
	
	@Column(name = "stockExchange")
	private String stockExchang;
	
	@Column(name = "cmpWebsite")
	private String companyWebsite;
	
	public Company() {}

	public Company(Integer id, String comapnyName, String comapnyCEO, BigInteger companyTurnover, String stockExchang,
			String companyWebsite) {
		super();
		this.id = id;
		this.comapnyName = comapnyName;
		this.comapnyCEO = comapnyCEO;
		this.companyTurnover = companyTurnover;
		this.stockExchang = stockExchang;
		this.companyWebsite = companyWebsite;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComapnyName() {
		return comapnyName;
	}

	public void setComapnyName(String comapnyName) {
		this.comapnyName = comapnyName;
	}

	public String getComapnyCEO() {
		return comapnyCEO;
	}

	public void setComapnyCEO(String comapnyCEO) {
		this.comapnyCEO = comapnyCEO;
	}

	public BigInteger getCompanyTurnover() {
		return companyTurnover;
	}

	public void setCompanyTurnover(BigInteger companyTurnover) {
		this.companyTurnover = companyTurnover;
	}

	public String getStockExchang() {
		return stockExchang;
	}

	public void setStockExchang(String stockExchang) {
		this.stockExchang = stockExchang;
	}

	public String getCompanyWebsite() {
		return companyWebsite;
	}

	public void setCompanyWebsite(String companyWebsite) {
		this.companyWebsite = companyWebsite;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", comapnyName=" + comapnyName + ", comapnyCEO=" + comapnyCEO
				+ ", companyTurnover=" + companyTurnover + ", stockExchang=" + stockExchang + ", companyWebsite="
				+ companyWebsite + "]";
	}
	
	

}
