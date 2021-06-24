package com.estock.registration.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estock.registration.pojo.CmpStock;

@RestController
@RequestMapping("/api/v1/market/stock")
public class StockRegistrationController {
	
	@GetMapping("/getStock")
	public String getStock() {
		return "Stock controller executed";
	}
	
	@GetMapping("/getAllStocks")
	public List<CmpStock> getAllStocks(){
		
		List<CmpStock> cmpList = new ArrayList<>();
		cmpList.add(new CmpStock(1, 200, LocalDate.now()));
		return cmpList;
		
	}

}
