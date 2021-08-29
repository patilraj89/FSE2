package com.estock.cmp.registration.pojo;

import java.util.List;

import com.estock.cmp.registration.model.Stock;

public class CmpStock {
	
	List<Stock> stockData;
	double avgVal;
	double minVal;
	double maxVal;
	public List<Stock> getStockData() {
		return stockData;
	}
	public void setStockData(List<Stock> stockData) {
		this.stockData = stockData;
	}
	public double getAvgVal() {
		return avgVal;
	}
	public void setAvgVal(double avgVal) {
		this.avgVal = avgVal;
	}
	public double getMinVal() {
		return minVal;
	}
	public void setMinVal(double minVal) {
		this.minVal = minVal;
	}
	public double getMaxVal() {
		return maxVal;
	}
	public void setMaxVal(double maxVal) {
		this.maxVal = maxVal;
	}
	@Override
	public String toString() {
		return "CmpStock [stockData=" + stockData + ", avgVal=" + avgVal + ", minVal=" + minVal + ", maxVal=" + maxVal
				+ "]";
	}
	
	
	

}
